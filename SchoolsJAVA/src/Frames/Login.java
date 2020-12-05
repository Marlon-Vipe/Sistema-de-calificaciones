package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Clases.Conectar;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JTextField txtusuario;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	String user = "";
	String pass = "";
	
	public Login() {
		initialize();
                
               
		
	TextPrompt usuario = new TextPrompt("Ingresar usuario",txtusuario);
        TextPrompt password = new TextPrompt("Ingresar contrase�a",txtpass);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/Imagenes/1564632595-5d42661337934-815x440.jpg")));
        lblNewLabel_2.setBounds(0, 0, 801, 403);
        frame.getContentPane().add(lblNewLabel_2);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.desktop);
		frame.setBounds(100, 100, 705, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(371, 0, 325, 403);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(50, 157, 65, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(50, 241, 87, 13);
		panel.add(lblNewLabel_1);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(150, 156, 151, 19);
		panel.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(150, 240, 151, 19);
		panel.add(txtpass);
		
		JButton btningresar = new JButton("Ingresar");
		btningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                                    user = txtusuario.getText();
                                    pass = txtpass.getText();


                                    if(!user.equals("") || !pass.equals("")) {

                                            try {

                                                    PreparedStatement ps = cn.prepareStatement("SELECT tipo_nivel FROM usuarios WHERE username='"+user+
                                                                    "' AND password='"+pass+"'");

                                                    ResultSet rs = ps.executeQuery();


                                                    if(rs.next()) {

                                                            String tipo_nivel = rs.getString("tipo_nivel");

                                                            if(tipo_nivel.equalsIgnoreCase("Administrador")) {
                                                                
                                                                
                                                               
                                                                    new Principal().setVisible(true);
                                                                    

                                                            }

                                                    }

                                                    else {

                                                            JOptionPane.showMessageDialog(null, " Usuario y/o Contrase�a incorrectos ");
                                                            txtusuario.setText("");
                                                            txtpass.setText("");

                                                    }

                                            }catch(SQLException e1) {

                                                    System.err.println(e1);
                                                    JOptionPane.showMessageDialog(null,"Error al iniciar sesion .... contacte al administrador");


                                            }

                                    }

                    else {
					
			JOptionPane.showMessageDialog(null,"Debes llenar todos los campos");
		}
}
		});
		btningresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btningresar.setBounds(119, 310, 97, 21);
		panel.add(btningresar);
	}
	

		Conectar con = new Conectar();
		Connection cn = con.conexion();
}
