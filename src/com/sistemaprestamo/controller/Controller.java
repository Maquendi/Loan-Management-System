package com.sistemaprestamo.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.sistemaprestamo.model.*;

public class Controller {
	
	
	private Connection conn;
	private PreparedStatement pst;
    private Modelo modelo;
	
    
	
	public Controller(Modelo modelo) {
		conn = Conexion.getConexion();
		this.modelo = modelo;
		
	}
	
	
	
	public Modelo getSolicitud(String cedula) {

		Solicitud solicitud = new Solicitud();
		Modelo model = new Modelo();

		solicitud = getSolicituds(cedula);
		
		
	
		   if(solicitud != null ) {
			   
			    model.setPerson(getRegistro(cedula));
				model.setSolicitud(solicitud);
				return model;
		   }else {
			   
			   return null;
		   }
		   
	}
	
	
	
	
	public void procesarSolicitud(Solicitud sol,double montoAprobado,Interes interes) {
		
		String sql = "UPDATE solicitud set estatus = ? WHERE solicitud.id_solicitud = ?";
		int resul = 0;
		
		try {
			
			  pst = conn.prepareStatement(sql);
			  pst.setString(1, sol.getEstatus());
			  pst.setInt(2,sol.getNum_solicitud());
			  resul = pst.executeUpdate();
			  pst.close();
		}catch(SQLException e) {
			
		}
		
		System.out.println("Estado: "+sol.getEstatus());
		System.out.println("Numero: " + sol.getNum_solicitud());
		
		if(sol.getEstatus().equals("Aprobado")) {
			
			String insert = "INSERT INTO solicitud_aprobado(id_solicitud,monto_aprobado,interes_aprobado,tipo_Interes) VALUES(?,?,?,?)";
			
			try {
				
				pst = conn.prepareStatement(insert);
				pst.setInt(1,sol.getNum_solicitud());
				pst.setDouble(2,montoAprobado);
				pst.setString(3, interes.getValor() + " % "+interes.getPeriodo());
				pst.setString(4,interes.getTipo_interes());
				pst.executeUpdate();
				
				pst.close();
			}catch(SQLException ex) {
				
			}
			
		}else {
			
			try {
				String insert = "INSERT INTO solicitud_declinada(id_solicitud,razon_declinacion) VALUES(?,?)";
				pst = conn.prepareStatement(insert);
				pst.setInt(1,sol.getNum_solicitud());
				pst.setString(2,sol.getRazonDeclinacion());
				pst.executeUpdate();
				pst.close();
			
			}catch(SQLException e) {
				//nothing here.
			}
		
		}
		
	}
	
	
	public void updateSolicitud(Modelo model) {
		
		Persona p = model.getPerson();
		Solicitud s = model.getSolicitud();
	  
		try {
			
			updateRegistro(p);
			pst = conn.prepareStatement("UPDATE solicitud SET monto_solicitado = ?, plazo = ?, estatus = ? WHERE solicitud.id_registro= ?");
			pst.setDouble(1, s.getMonto_solicitado());
			pst.setInt(2, s.getPlazo_en_meses());
			pst.setString(3, s.getEstatus());
			pst.setInt(4, p.getID());
			pst.executeUpdate();
		    
		    pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	
	public ArrayList<Modelo> getListaSolicitudes(){
		
		ArrayList<Modelo> lista = new ArrayList<>();
		
		String consulta = "SELECT registro.cedula FROM registro JOIN solicitud WHERE registro.id_persona = solicitud.id_registro";
		
		try {
			
			pst = conn.prepareStatement(consulta);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				Modelo modelo = getSolicitud(rs.getString(1));
				
				
				if(modelo.getSolicitud().getEstatus().equals("Pendiente")) {
					lista.add(new Modelo(modelo));
				}
				    
			}
			
			pst.close();
			rs.close();
		  }catch(SQLException e) {
			 e.printStackTrace();
		}
		
		return lista;
	}
	
	
	
	private void updateRegistro(Persona persona) {
	 	
		 String sql = "UPDATE registro SET nombre = ?, apellido = ?, sexo =?, fecha_nac =?, nacionalidad =?, "
		 		+ "categoria=? WHERE registro.cedula = ?";
			 
		 String sexo = (persona.getSexo() == 'M') ? "M": "H";
		 
		try {
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, persona.getNombre_Persona());
			pst.setString(2, persona.getApellido());
			pst.setString(3, sexo);
			pst.setDate(4, new Date(persona.getFecha_nac().getTime()));
			pst.setString(5, persona.getNacionalidad());
			pst.setString(6, persona.getCategoria());
			pst.setString(7,persona.getCedula());
			pst.executeUpdate();
			
			updateAddress(persona);
			updateContact(persona);
			updateEmpleo(persona);
			
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	
	
	
	public Solicitud getSolicituds(String cedula) {
		
		Solicitud sol = new Solicitud();
		
		 boolean found = false;
		
		String consulta = "SELECT * from solicitud join registro on registro.id_persona = solicitud.id_registro "
				+ "where registro.cedula = ?";
		
		try {
			
			pst = conn.prepareStatement(consulta);
			pst.setString(1,cedula);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				String tipoPrestamo;
				
				int t = rs.getInt(7);

				if (t == 1) {
					tipoPrestamo = "Personal";
				} else if (t == 2) {
					tipoPrestamo = "Educativo";
				} else {
					tipoPrestamo = "Hipotecario";
				}
				
				found = true;
				sol.setNum_solicitud(rs.getInt(1));
				sol.setFecha_solicitud(rs.getDate(2));
				sol.setMonto_solicitado(rs.getDouble(3));
				sol.setPlazo_en_meses(rs.getInt(4));
				sol.setEstatus(rs.getString(5));
				sol.setId_solicitante(rs.getInt(6));
				sol.setTipo_prestamo(tipoPrestamo);
				
			}
			
			pst.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		if(found)
			return sol;
		else
			return null;
	}
	
	
	
	private void updateEmpleo(Persona persona) {
		
		String sql = "UPDATE registro_empleo SET inicio_empleo = ?,nombre_empresa=?,telefono_empresa=?,"
				+ "salario=? WHERE registro_empleo.id_registro = ?";
		try {
			
			pst = conn.prepareStatement(sql);
			
			pst.setDate(1,new Date(persona.getEmpleo().getInicioEmpleo().getTime()));
			pst.setString(2,persona.getEmpleo().getNombreEmpresa());
			pst.setString(3,persona.getEmpleo().getTelefonoEmpresa());
			pst.setDouble(4,persona.getEmpleo().getSalario());
			pst.setInt(5,persona.getID());
			
			
			pst.executeUpdate();
			 
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
	  }
		
		
		
	}



	public void updateAddress(Persona persona) {
		
		String sql = "UPDATE addresses SET calle = ?,sector=?,ciudad=? WHERE addresses.id_registro = ?";
		try {
			
			pst = conn.prepareStatement(sql);
			pst.setString(1,persona.getDireccion().getCalle());
			pst.setString(2,persona.getDireccion().getSector());
			pst.setString(3,persona.getDireccion().getCiudad());
			pst.setInt(4, persona.getID());
			pst.executeUpdate();
			
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
	  }
	   
	}
	
	
	
	public void updateContact(Persona persona) {
		
		 String sql = "UPDATE contactos SET telefono = ?, email = ? WHERE contactos.id_registro = ?";
		 
		 
		    try {
				pst = conn.prepareStatement(sql);
				
				pst.setString(1,persona.getContacto().getTelefono());
				pst.setString(2,persona.getContacto().getEmail());
				pst.setInt(3,persona.getID());
				pst.executeUpdate();
				
				pst.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		    		
	}
	
	
	
	
	
	public ArrayList<Persona> getRegistro() {
		
		
		  ArrayList<Persona> lista = new ArrayList<Persona>();
	       String sql ="SELECT registro.cedula from registro";
	       
			try {
				
				pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
			
				while(rs.next()) {  
				      lista.add(getRegistro(rs.getString(1)));
				   }
				
				 pst.close();
				 rs.close();
			     } catch (SQLException e) {
				   e.printStackTrace();
		     }
		
			return lista;
	}
	
	
	
	
	
	
	
	
	
	
	public ArrayList<String> getNames(){
		
		ArrayList<String> nombres = new ArrayList<>();
		ArrayList<Persona> list = getRegistro();
		
		for(Persona p: list) {
			nombres.add(p.getNombre_Persona() + " " + p.getApellido());
		}
		
		return nombres;
	}
	
	
	
	
	
	
	
	
	public Persona getRegistro(String cedula) {
		
		Persona p = new Persona();
		
       String sql = "SELECT * FROM registro WHERE registro.cedula = ?";
       
		try {
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, cedula);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
					
			      p.setID(rs.getInt(1));
			      p.setCedula(rs.getString(2));
			      p.setNombre_Persona(rs.getString(3));
			      p.setApellido(rs.getString(4));
			      p.setSexo(rs.getString(5).charAt(0));
			      p.setFecha_nac(new Date(rs.getDate(6).getTime()));
			      p.setNacionalidad(rs.getString(7));
			      p.setCategoria(rs.getString(8));
			      
			      p.setEmpleo(getEmpleo(p));
			      p.setDireccion(getAddress(p));
			      p.setContacto(getContact(p));
			  		 
			  }
					
			  pst.close();
			  rs.close();
		     } catch (SQLException e) {
			   e.printStackTrace();
	     }
	
		return p; 
	}
	
	
	
	
	
	private Empleo getEmpleo(Persona p) {
		
		ResultSet rs = null;
		Empleo empleo = new Empleo();
		
		String sql = "SELECT * FROM registro_empleo where registro_empleo.id_registro = "+ p.getID();
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		   	
			while(rs.next()) {
			 
			  empleo.setInicioEmpleo(new Date(rs.getDate(2).getTime()));
			  empleo.setNombreEmpresa(rs.getString(3));
			  empleo.setTelefonoEmpresa(rs.getString(4));
			  empleo.setSalario(rs.getDouble(5));
			
			}
			
			pst.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	
		return empleo;
	}



	public Contacto getContact(Persona p) {
		
		ResultSet rs = null;
		Contacto contacto = modelo.getPerson().getContacto();
		
		String sql = "SELECT * FROM contactos where contactos.id_registro = "+ p.getID();
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		   	
			while(rs.next()) {
			 contacto.setContactoID(rs.getInt(1));
			 contacto.setTelefono(rs.getString(2));
			 contacto.setEmail(rs.getString(3));
			
			}
			
			pst.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return contacto;
	}

	
	
	
	


	public boolean isRegistered(String cedula) {
		
		 boolean existe = false;
		try {
			pst = conn.prepareStatement("SELECT * FROM registro WHERE cedula = ?");
			
			pst.setString(1, cedula);
			
			ResultSet rs = pst.executeQuery();
			existe = rs.next();
			
			pst.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return existe;
	}
	

	
	
	private int nextID() {
		
		ResultSet rs = null;
		int nextId = 0;
		
		try {
			
			pst = conn.prepareStatement("SELECT COUNT(*) FROM registro");
			 rs = pst.executeQuery();
			while(rs.next()) {
			  nextId = rs.getInt(1);
			}
			
			pst.close();
			rs.close();
		  } catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error generating a foreign key for the table registro....");
		}
		
		return nextId;
	}
	
	
	
	
	private void addDirecciones(Persona persona) {
		
      String sql = "INSERT INTO addresses(calle,sector,ciudad,id_registro) VALUES(?,?,?,?)";
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,persona.getDireccion().getCalle());
			pst.setString(2,persona.getDireccion().getSector());
			pst.setString(3,persona.getDireccion().getCiudad());
			pst.setInt(4,persona.getID());
			pst.executeUpdate();
			
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public void addEmpleo(Persona persona) {
		
		
     String sql = "INSERT INTO registro_empleo(inicio_empleo,nombre_empresa,telefono_empresa, salario,id_registro) VALUES(?,?,?,?,?)";
		
		
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setDate(1, new Date(persona.getEmpleo().getInicioEmpleo().getTime()));
			pst.setString(2,persona.getEmpleo().getNombreEmpresa());
			pst.setString(3,persona.getEmpleo().getTelefonoEmpresa());
			pst.setDouble(4,persona.getEmpleo().getSalario());
			pst.setInt(5,persona.getID());
			
			pst.executeUpdate();
		
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void addContact(Persona person) {
		
		String sql = "INSERT INTO contactos(telefono,email,id_registro) VALUES(?,?,?)";
		
		//INSERT INTO contactos(email,id_registro,telefono) values('beltran_novas@',48,'829-456-2541') 
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,person.getContacto().getTelefono());
			pst.setString(2,person.getContacto().getEmail());
			pst.setInt(3,person.getID());
			pst.executeUpdate();
		
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public Direccion getAddress(Persona p) {
		
		ResultSet rs = null;
		Direccion address = modelo.getPerson().getDireccion();
		
		String sql = "SELECT * FROM addresses where addresses.id_registro = "+ p.getID();
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		   	
			while(rs.next()) {
			
			 address.setDireccionID(rs.getInt(1));
			 address.setCalle(rs.getString(2));
			 address.setSector(rs.getString(3));
			 address.setCiudad(rs.getString(4));
			
			}
			
				
			pst.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return address;
	}
	
	
	
	
	
	public boolean addSolicitud(Persona persona, Solicitud solicitud) {
		
		boolean added = false;
		String sql = "INSERT INTO solicitud(monto_solicitado,plazo,estatus,id_registro,id_Tprestamo) VALUES(?,?,?,?,?)";
		
		try {
			
			 int id = addToRegistro(persona);
			 
			  if(id != 0) {
				 
				  pst = conn.prepareStatement(sql);
				  pst.setDouble(1, solicitud.getMonto_solicitado());
				  pst.setDouble(2, solicitud.getPlazo_en_meses());
				  pst.setString(3,solicitud.getEstatus());
				  pst.setInt(4, id);
				  pst.setInt(5, solicitud.getTipoPrestamos());
				  if(pst.executeUpdate()== 1) {
					  added = true;
				  }
			  }
			 
			  pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return added;
	}
	
	
	//com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException:
	
	
	
	
	public void addToRegistro(Empleado emp) {
	
		Persona persona = emp;
		int id = addToRegistro(persona);
		emp.setID(id);
		addUser(emp);
		addReferencia(emp);
	
	}
	
	
	
	private Referencia getRef(Empleado emp) {
		
		boolean found = false;
		
		Referencia ref = modelo.getPerson().getRef();
		
		String sql = "SELECT referencia.nombre,referencia.apellido,referencia.telefono,referencia.parentesco from referencia join "
				+ "registro on registro.id_persona=referencia.id_registro WHERE registro.cedula = ?";
		
		try {
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, emp.getCedula());
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				
				ref.setName(rs.getString(1));
				ref.setApellido(rs.getString(2));
				ref.setTelef(rs.getString(3));
				ref.setParentesco(rs.getString(4));
				found = true;
			}
		 	
			pst.close();
			rs.close();
		  }catch(SQLException e) {
			  e.printStackTrace();
		}
		
		
		if(found)
		return ref;
		else
			return null;
	}
	
	
	
	public Empleado getUser(String userName, String password) {
		
		boolean found = false;
		ResultSet rs = null;
		Empleado emp = modelo.getEmpleado();
		String cedula = null;
		
		
		String sql = "SELECT registro.cedula, usuario.usuario, usuario.password,usuario.privilegio from registro inner join usuario "
				+ "on usuario.id_registro = registro.id_persona where usuario.usuario = ? AND usuario.password = ?";
		
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1,userName);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
			  cedula = rs.getString(1);
			  emp.setUser(new User(rs.getString(2),rs.getString(3),rs.getString(4)));	
			  found = true;
			}
			
			pst.close();
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		

		if(found && cedula != null) {
			Persona persona = getRegistro(cedula);
			emp.setNombre_Persona(persona.getNombre_Persona());
			emp.setApellido(persona.getApellido());
			emp.setCedula(cedula);
			emp.setCategoria(persona.getCategoria());
			emp.setFecha_nac(persona.getFecha_nac());
			emp.setID(persona.getID());
			emp.setContacto(persona.getContacto());
			emp.setDireccion(persona.getDireccion());
			emp.setEmpleo(persona.getEmpleo());
			emp.setNacionalidad(persona.getNacionalidad());
			emp.setRef(getRef(emp));
			
			return emp;
		} else {
			return null;
			
		}
			
		
	}
	
	
	
	
	
	
	public Modelo getModelo() {
		return modelo;
	}



	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}



	private void addReferencia(Persona persona) {
		
		String sql = "INSERT INTO referencia(nombre,apellido,telefono,parentesco,id_registro) VALUES(?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, persona.getRef().getName());
			pst.setString(2, persona.getRef().getApellido());
			pst.setString(3,persona.getRef().getTelef());
			pst.setString(4, persona.getRef().getParentesco());
			pst.setInt(5, persona.getID());
			pst.executeUpdate();
			
			
			pst.close();
		} catch (SQLException e) {
			System.out.println("could not add user!!");
			e.printStackTrace();
		}
		
	}
	
	
	private void addUser(Empleado emp) {
		
		String sql = "INSERT INTO usuario(usuario,password,privilegio,id_registro) VALUES(?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getUser().getUserName());
			pst.setString(2, emp.getUser().getPass());
			pst.setString(3, emp.getUser().getPriviledge());
			pst.setInt(4, emp.getID());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("could not add user!!");
			e.printStackTrace();
		}
		
	}
	
	
	
	public int addToRegistro(Persona persona) {
		
		int id_registro = 0;
		
		String sqlRegistro = "INSERT INTO registro(nombre,apellido,cedula,sexo,fecha_nac,nacionalidad,categoria)"
				+ "VALUES(?,?,?,?,?,?,?)";		
		try {
	           pst = conn.prepareStatement(sqlRegistro);
	       
				pst.setString(1, persona.getNombre_Persona());
				pst.setString(2, persona.getApellido());
				pst.setString(3, persona.getCedula());
				pst.setString(4, persona.getSexo()+"");
				pst.setDate(5, new Date(persona.getFecha_nac().getTime()));
				pst.setString(6, persona.getNacionalidad());
				pst.setString(7, persona.getCategoria());
						    
			    if(pst.executeUpdate()== 1){
			    	
			    	id_registro = nextID();
			    	persona.setID(id_registro);
					addContact(persona);
					addDirecciones(persona);
					addEmpleo(persona);
			    }
			    
			    pst.close();
			} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
				e.printStackTrace();
			}catch(SQLException e) { e.printStackTrace();}
			
		return id_registro;
	  }
	

}
