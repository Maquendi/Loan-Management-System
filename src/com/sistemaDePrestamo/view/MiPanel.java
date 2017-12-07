package com.sistemaDePrestamo.view;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.sistemaprestamo.model.Caso;
import com.sistemaprestamo.model.Cliente;

public class MiPanel extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Cliente cliente;
	private Caso caso;
	private JTree tree;
	
	
	private JTextField caseStatus;
	private JTextField caseReason;
	private JPanel panel_21;
	private JTextArea textArea;
	private JTextField nombreCliente;
	private JTextField statusCliente;
	private JLabel caseNumberLabel;
	private JLabel fecha_label;
	
	
	
	
	public MiPanel() {	
		createPanel();
		
		
		
		
		tree.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent event) {
				
				TreePath path = event.getPath();
				
			    DefaultMutableTreeNode node = (DefaultMutableTreeNode)path.getLastPathComponent(); 
			    
			    
			    
			    if(node.isLeaf()) {
			    	
			    	 Object objNode = node.getUserObject();
					// caso = (Casos)objNode;
					 
				//	 caseNumberLabel.setText(caso.getCaseNumber());
					 
				//	 long fecha= caso.getFechaCaso().getTime();
					 Calendar cal = Calendar.getInstance();
				//	 cal.setTimeInMillis(fecha);
					 
					 
					 int year = cal.get(Calendar.YEAR);
					 int month = cal.get(Calendar.MONTH);
					 int day = cal.get(Calendar.DATE);
					 fecha_label.setText(day + "-" + month + "-" + year);
					 
				//	 nombreCliente.setText(caso.getCliente().getNombre_Persona());
				//	 statusCliente.setText("Cliente.status");
				//	 caseStatus.setText(caso.getCaseStatus());
				//	 caseReason.setText(caso.getCaseReason());
					 
					 
					
			    }
			    
			    
			   
			}
			
			
			
		});
		
		add(tree);
		
	}
	
	
	
	
	
   /*
	
	public void crearNodos() {
	   
		tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Mis Casos") {
			
			
			{
				DefaultMutableTreeNode node;
				
				node = new DefaultMutableTreeNode("Casos");
				cliente = new Cliente("Maquendi Beltran","223-007-2582-1",'M',"Ave. 27 de Feb.",new Date(),"829-497-6028",true,"6 añOS");
			/*	
				node.add(new DefaultMutableTreeNode(new Casos(cliente,new Date(),"100-000025-0012","Missing Money","Pendiente")));
				node.add(new DefaultMutableTreeNode(new Casos(cliente,new Date(),"100-001124-3201","Missing Money","Resuelto")));
				node.add(new DefaultMutableTreeNode(new Casos(cliente,new Date(),"100-000025-0147","Missing Money","Pendiente")));
				node.add(new DefaultMutableTreeNode(new Casos(cliente,new Date(),"100-000025-8520","Missing Money","Aprobado")));
				
				add(node);
				
			}
			
		}));
			
	}
	 
	
	
	
	
	
	
	
	public Casos getCaso() {
		return caso;
	}
	
	
	
	*/
	
	
	public void createPanel() {
		
		
        panel_21 = new JPanel();
		
		panel_21.setLayout(null);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_23.setBounds(10, 11, 1151, 61);
		panel_21.add(panel_23);
		panel_23.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Caso Numero: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 28, 106, 22);
		panel_23.add(lblNewLabel);
		
	    caseNumberLabel = new JLabel("000-00000000-0000");
		caseNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		caseNumberLabel.setBounds(107, 33, 124, 14);
		panel_23.add(caseNumberLabel);
		
		JLabel lblCreadaEnFecha = new JLabel("Creada En Fecha: ");
		lblCreadaEnFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCreadaEnFecha.setBounds(269, 28, 140, 22);
		panel_23.add(lblCreadaEnFecha);
		
		fecha_label = new JLabel("01-01-0000");
		fecha_label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fecha_label.setBounds(395, 33, 75, 14);
		panel_23.add(fecha_label);
		
		JLabel lblEstatus = new JLabel("Estatus: ");
		lblEstatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstatus.setBounds(510, 28, 64, 22);
		panel_23.add(lblEstatus);
		
		caseStatus = new JTextField();
		caseStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		caseStatus.setEditable(false);
		caseStatus.setColumns(10);
		caseStatus.setBounds(577, 31, 140, 20);
		panel_23.add(caseStatus);
		
		JLabel lblCaseReason = new JLabel("Case reason:");
		lblCaseReason.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCaseReason.setBounds(759, 28, 98, 22);
		panel_23.add(lblCaseReason);
		
		caseReason = new JTextField();
		caseReason.setFont(new Font("Tahoma", Font.PLAIN, 14));
		caseReason.setEditable(false);
		caseReason.setColumns(10);
		caseReason.setBounds(867, 31, 140, 20);
		panel_23.add(caseReason);
			
		
		
		
		JPanel panel_24 = new JPanel();
		panel_24.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_24.setBounds(10, 83, 235, 405);
		panel_21.add(panel_24);
		panel_24.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(10, 11, 65, 22);
		panel_24.add(lblCliente);
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(10, 64, 88, 22);
		panel_24.add(lblStatus);
		
		nombreCliente = new JTextField();
		nombreCliente.setEditable(false);
		nombreCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombreCliente.setBounds(85, 14, 140, 20);
		panel_24.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		statusCliente = new JTextField();
		statusCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		statusCliente.setEditable(false);
		statusCliente.setColumns(10);
		statusCliente.setBounds(85, 67, 140, 20);
		panel_24.add(statusCliente);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_25.setBounds(773, 83, 322, 405);
		panel_21.add(panel_25);
		panel_25.setLayout(null);
		
		JButton btnNewButton = new JButton("guardar");
		
		btnNewButton.setBounds(229, 371, 83, 23);
		panel_25.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("editar");
		
		btnNewButton_1.setBounds(142, 371, 77, 23);
		panel_25.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 302, 349);
		panel_25.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setEditable(true);
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setEditable(false);
	
			}
		});
		
	}
	
	
	
	
	
	public JPanel getPanel() {
		return this;
	}
	
	public JPanel getOtherPanel() {
		return panel_21;
	}

	
}	
