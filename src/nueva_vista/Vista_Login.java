package nueva_vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.SoftBevelBorder;

import com.sistemaprestamo.controller.Controller;
import com.sistemaprestamo.model.Empleado;

import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Vista_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel firstLabelImage;
	private JTextField userName;
	private JLabel label;
	private JButton enterBoton;
	private JPanel panel;
	private JButton btnCancel;
	private JLabel lblTodosLosReservados;
	private JPasswordField pass;
	private JLabel lblLogin;
	private Controller controlador;
	
	
	
	
	public Vista_Login(Controller controller) {
		init(controller);
	}

	
	
	
	
	private void init(Controller control) {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    System.out.println("This look and feel is not found.");
		}
		
		
		controlador = control;
		setUndecorated(true);
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1193,698);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 102));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		firstLabelImage = new JLabel("");
		firstLabelImage.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		firstLabelImage.setIcon(new ImageIcon("C:\\image\\fondo.jpg"));
		firstLabelImage.setBounds(10, 11, 1173, 676);
		contentPane.add(firstLabelImage);
		
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.GRAY));
		//panel.setBounds(30, 44, 1131, 600);
		
		
		
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		
		userName = new JTextField();
		userName.setFont(new Font("Verdana", Font.PLAIN, 13));
		userName.setBorder(null);
		userName.setBounds(340, 316, 422, 34);
		panel.add(userName);
		userName.setColumns(10);
		
		enterBoton = new JButton("Sign In");
		enterBoton.setIcon(null);
		enterBoton.setDisabledIcon(null);
		enterBoton.setForeground(Color.WHITE);
		enterBoton.setFont(new Font("Verdana", Font.ITALIC, 13));
		enterBoton.setPressedIcon(null);
		enterBoton.setBackground(new Color(51, 204, 153));
		enterBoton.setBorder(new EmptyBorder(0, 0, 0, 0));
		enterBoton.setBounds(340, 445, 422, 34);
		panel.add(enterBoton);
		
		pass = new JPasswordField();
		pass.setBorder(null);
		pass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pass.setBounds(340, 380, 422, 34);
		panel.add(pass);
		
		label = new JLabel("");
		label.setVerifyInputWhenFocusTarget(false);
		label.setRequestFocusEnabled(false);
		label.setIconTextGap(0);
		label.setBackground(Color.WHITE);
		label.setForeground(Color.WHITE);
		label.setFocusTraversalKeysEnabled(false);
		label.setFocusTraversalPolicyProvider(true);
		label.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 51, 51), new Color(102, 102, 102)));
		label.setToolTipText("User Authentication");
		label.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\fondo3.png"));
		//label.setBounds(0, 0, 1131, 600);
		panel.add(label);
		
	
		btnCancel = new JButton("Exit");
		btnCancel.setForeground(new Color(204, 153, 0));
		btnCancel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 13));
		btnCancel.setBorder(UIManager.getBorder("RadioButton.border"));
		btnCancel.setBounds(1066, 660, 79, 23);
		contentPane.add(btnCancel);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(new Color(102, 102, 102));
		label_1.setBackground(new Color(51, 51, 51));
		label_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(51, 51, 51), new Color(51, 51, 51), new Color(51, 51, 51), new Color(51, 51, 51)));
		label_1.setBounds(1051, 655, 110, 32);
		contentPane.add(label_1);
		
		lblTodosLosReservados = new JLabel("(lms).  Todos Los Reservados, Grupo No 3 ");
		lblTodosLosReservados.setBounds(351, 673, 278, 14);
		contentPane.add(lblTodosLosReservados);
		
		lblLogin = new JLabel("Autenticar");
		lblLogin.setForeground(new Color(51, 153, 153));
		lblLogin.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_Account_1891016.png"));
		lblLogin.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblLogin.setBounds(30, 10, 117, 32);
		contentPane.add(lblLogin);

		handleEvents();
	    setVisible(true);
	}
	
	
	
	
	
	
	
	private void handleEvents() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			
				enterBoton.setVisible(false);
				userName.setVisible(false);
				pass.setVisible(false);
				firstLabelImage.setBounds(10, 11, 1173, 676);
			}
		});
		
		
		firstLabelImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panel.setBounds(30, 44, 1131, 600);
				userName.setVisible(true);
				panel.setVisible(true);
				pass.setVisible(true);
				label.setBounds(0, 0, 1131, 600);
				enterBoton.setVisible(true);
				firstLabelImage.setVisible(false);
				
				
			}
		});
		
		
		
		
		firstLabelImage.addKeyListener(new KeyAdapter() {
			
			public void keyTyped(KeyEvent e) {
				int key = e.getKeyCode();
				System.out.println(key);
				if(key == KeyEvent.VK_ENTER) {
					userName.setVisible(true);
					pass.setVisible(true);
					panel.setBounds(30, 44, 1131, 600);
					label.setBounds(0, 0, 1131, 600);
					enterBoton.setVisible(true);
					firstLabelImage.setVisible(false);
					
				}
			}
		});
		
		
		pass.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					callMainFrame();
				}	
			}
		});
		
		enterBoton.addActionListener(new EventosBotonClick());
		btnCancel.addActionListener(new EventosBotonClick());
		
	}
	
	
	
	
	private class EventosBotonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == enterBoton) {
				callMainFrame();
			}else if(e.getSource() == btnCancel) {
				
				int answer = JOptionPane.showConfirmDialog(null, "Confirma Salir de Esta Ventana ?", "Confirm exit", JOptionPane.YES_NO_OPTION);
			 
				if(answer == 0)
				   System.exit(0);
			}
			
		}
		
	}
	
			
	
	
	private void callMainFrame() {
		if(authenticate()) {
			
			if(controlador.getModelo().getEmpleado().getUser().getPriviledge().equals("All Priviledges")) {
				new Vista_Admin(controlador);
				this.dispose();
			}else {
				new Vista_Principal(controlador);
				dispose();
			}
		}else {
			
			JOptionPane.showConfirmDialog(null, "Invalid User Name or Passoword", "Login Failed", JOptionPane.OK_OPTION);
		}
	}
	
	
	
	
	private boolean authenticate() {
		boolean isValid = false;
		
		String contra = new String(pass.getPassword());
		Empleado emp = controlador.getUser(userName.getText(), contra);
		
		if(emp != null) {
		  controlador.getModelo().setEmpleado(emp);	
		  isValid = true;
		}
		
	    return isValid;
		
	}
	
	
}
