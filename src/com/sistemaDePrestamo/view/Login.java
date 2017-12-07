package com.sistemaDePrestamo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JLabel label;
	private JPasswordField pass;
	private JButton enterBoton;
	private JPanel panel;
	private int difPosY;
	
	
	public Login() {
		
		init();
		
		handleEvents();
	}

	
	
	
	private void handleEvents() {
		
		enterBoton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Clicked");
				callMainFrame();
			}	
		});
		
		
		
		
		pass.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent event) {
				
				if(event.getKeyCode()== KeyEvent.VK_ENTER) {
					
					callMainFrame();
				}
				
			}
			
			
		});
		
		
		
		
		getContentPane().addComponentListener(new ComponentAdapter() {
			
			int temp = 0;
			
			@Override
			public void componentResized(ComponentEvent e) {
				Component c = (Component)e.getSource();
		
				int difWidth = c.getWidth() - 1284;
				int difHeight = c.getHeight() - 691;
				difPosY++;
				
				if(temp == 0) {
					if(temp != getY())
					temp = getY();
				}
				
				
				
				
				
				
				
				
			    if(difWidth > 0 && difHeight > 0 || difWidth < 82 && difHeight < 14) {
			    	panel.setSize(new Dimension(1264+difWidth,651+difHeight));
			    	label.setSize(new Dimension(1244+difWidth,622+difHeight));
			    	
			    	if(difWidth < 82 && difHeight < 14) {
			    	  userName.setLocation(488, 352);
			    	  pass.setLocation(488, 417);
			    	  enterBoton.setLocation(496, 484);
			    	 }else {
			    		 
			    		  userName.setLocation(480+panel.getX(), 348+panel.getY()+1);
				    	  pass.setLocation(480+label.getX(), 413+label.getY());
				    	  enterBoton.setLocation(490+label.getX(), 480+label.getY());
			    	}
			    	
			    }else if(difWidth < 0 && difHeight < 0) {
			    	panel.setSize(new Dimension(1264+difWidth,651+difHeight));
			    	label.setSize(new Dimension(1244+difWidth,622+difHeight));	
			    }
			    
			    
			    if(difHeight < 0) {
			    	
			    	System.out.println(difPosY);
			    	
			    	  userName.setLocation(480+panel.getX(), userName.getY()+difPosY);
			    	  pass.setLocation(480+label.getX(), 413+getY());
			    	  enterBoton.setLocation(490+label.getX(), 480+getY());
			    	  difPosY=0;
			    	
			    }
							
			}

		});
		
	}
	
	

	
	
	
	
	
	
	private void init() {
		
		//setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(25, 15, 1276, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 0, 1274, 662);
		contentPane.add(panel);
		panel.setLayout(null);
		
		userName = new JTextField();
		userName.setBorder(null);
		userName.setBounds(483, 362, 413, 39);
		panel.add(userName);
		userName.setColumns(10);
		
		enterBoton = new JButton("Sign In");
		enterBoton.setDisabledIcon(null);
		enterBoton.setForeground(Color.WHITE);
		enterBoton.setFont(new Font("Verdana", Font.ITALIC, 13));
		enterBoton.setPressedIcon(null);
		enterBoton.setBackground(new Color(51, 204, 153));
		enterBoton.setBorder(new EmptyBorder(0, 0, 0, 0));
		enterBoton.setBounds(490, 492, 406, 34);
		panel.add(enterBoton);
		
		label = new JLabel("");
		label.setDisabledIcon(null);
		label.setToolTipText("Nombre Usuario");
		label.setOpaque(true);
		label.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\fondo.png"));
		label.setBounds(0, 0, 1287, 662);
		panel.add(label);
		
		
		pass = new JPasswordField();
		pass.setBorder(null);
		pass.setBounds(483, 425, 413, 39);
		panel.add(pass);
		
	    setVisible(true);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private void callMainFrame() {
		if(authenticate()) {
			new Principal();
			dispose();
		}
	}
	
	
	
	
	private boolean authenticate() {
		boolean isValid;
		
		char[] password = pass.getPassword();
		String contra = new String(password);
		if(userName.getText().equalsIgnoreCase("admin") && contra.equals("admin"))
			isValid = true;
		else
			isValid = false;
		
		return isValid;
	}
}
