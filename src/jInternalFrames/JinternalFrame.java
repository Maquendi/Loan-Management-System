package jInternalFrames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.plaf.InternalFrameUI;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.plaf.multi.MultiInternalFrameUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Canvas;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Label;
import java.awt.Point;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class JinternalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JinternalFrame frame = new JinternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public JinternalFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if__67ui_2303172.png"));
		setTitle("Account Edition");
		
		
		
		try {
			
			for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
				
				if("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errors found");
		}
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 470);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Editar Cuenta");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_Account_1891016.png"));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenu mnRealizarTransacciones = new JMenu("Realizar Transacciones");
		mnRealizarTransacciones.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_Dialog-Apply-32_54904.png"));
		menuBar.add(mnRealizarTransacciones);
		
		JMenu mnNewMenu_1 = new JMenu("Saldar Prestamos");
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_icons-07_799759.png"));
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 11, 564, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 52, 25);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(62, 11, 164, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBorder(UIManager.getBorder("RadioButton.border"));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(236, 13, 75, 23);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 51));
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(371, 60, 183, 185);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID Cliente");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 27, 59, 27);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(70, 27, 103, 23);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("ID Cliente");
		label_4.setForeground(Color.WHITE);
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(10, 77, 59, 27);
		panel_1.add(label_4);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(70, 77, 103, 23);
		panel_1.add(textField_7);
		
		JLabel label_5 = new JLabel("ID Cliente");
		label_5.setForeground(Color.WHITE);
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(10, 127, 59, 27);
		panel_1.add(label_5);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(70, 127, 103, 23);
		panel_1.add(textField_8);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 126, 52, 27);
		panel.add(lblNombre);
		
		textField_2 = new JTextField();
		textField_2.setBounds(62, 126, 164, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("Nombre");
		label.setBounds(10, 164, 52, 27);
		panel.add(label);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(62, 164, 164, 27);
		panel.add(textField_3);
		
		JLabel label_1 = new JLabel("Nombre");
		label_1.setBounds(10, 202, 52, 27);
		panel.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(62, 202, 164, 27);
		panel.add(textField_4);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setBounds(10, 240, 52, 27);
		panel.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(62, 240, 164, 27);
		panel.add(textField_5);
		
		JLabel label_3 = new JLabel("Nombre");
		label_3.setBounds(10, 88, 52, 27);
		panel.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(62, 88, 164, 27);
		panel.add(textField_6);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(51, 51, 51), 1, true));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		lblNewLabel_2.setBounds(229, 88, 39, 25);
		panel.add(lblNewLabel_2);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		label_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_6.setBounds(229, 126, 39, 27);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		label_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_7.setBounds(229, 164, 39, 27);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		label_8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_8.setBounds(229, 202, 39, 27);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		label_9.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_9.setBounds(229, 240, 39, 27);
		panel.add(label_9);
		
		JButton btnSaveChanges = new JButton("Save");
		btnSaveChanges.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaveChanges.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSaveChanges.setForeground(new Color(0, 51, 153));
		btnSaveChanges.setBorder(UIManager.getBorder("RadioButton.border"));
		btnSaveChanges.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\check.png"));
		btnSaveChanges.setBounds(453, 306, 101, 33);
		panel.add(btnSaveChanges);
		
		//internalFrame_1.getRootPane().setWindowDecorationStyle(2);
		
		
		
		removeNorthPane();
		
		
		
		
		
		
		
	}
	
	
	
	
	private void removeNorthPane() {
		
		//BasicInternalFrameUI my = (BasicInternalFrameUI)internalFrame.getUI();
		
	}
	
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
