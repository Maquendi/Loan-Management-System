package com.sistemaprestamo.model;

import java.util.ArrayList;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TreeGenerator {

	private Caso caso;
	private JTree tree = new JTree();
	private Empleado empleado;
	private DefaultMutableTreeNode node = new DefaultMutableTreeNode("Casos");
	private ArrayList<Caso> listaCasos;


	
	public Empleado getEmpleado() {
		return this.empleado;
	}

	
	
	public void setEmpleado(Empleado emp) {
		this.empleado = emp;
	}



	public Caso getCaso() {
		return caso;
	}



   public void setLista(ArrayList<Caso> lista) {
	   this.listaCasos = lista;
   }


   
   public ArrayList<Caso> getListaCasos() {
	   return listaCasos;
   }
   
   
	public void setCaso(Caso caso) {
		this.caso = caso;
	}






	public JTree getTree() {
		return tree;
	}






	public void setTree(JTree tree) {
		this.tree = tree;
	}




	public TreeGenerator() {
		
	}
	


	public TreeGenerator(Empleado emp,ArrayList<Caso> casos) {
		this.empleado = emp;
		this.listaCasos = casos;
		crearNodos();
	}
	
	
	
	
	
	
	
	private void crearNodos() {
		   
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Mis Casos") {
			
			
			private static final long serialVersionUID = 1L;

			{
				
				for(Caso c: listaCasos) {
				
			    node.add(new DefaultMutableTreeNode(c));
				add(node);
				
				}
			}
			
		}));
			
	}
	
}
