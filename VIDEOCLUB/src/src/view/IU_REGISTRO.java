package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class IU_REGISTRO extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField correo;
	private JTextField contraseña;
	private JTextField fechaNacimiento;

	/**
	 * Launch the application.
	 */
		public void run() {
			try {
				IU_REGISTRO frame = new IU_REGISTRO();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
	

	/**
	 * Create the frame.
	 */
	public IU_REGISTRO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nombre = new JTextField();
		nombre.setBounds(170, 21, 96, 19);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		correo = new JTextField();
		correo.setBounds(170, 60, 96, 19);
		contentPane.add(correo);
		correo.setColumns(10);
		
		contraseña = new JTextField();
		contraseña.setBounds(170, 103, 96, 19);
		contentPane.add(contraseña);
		contraseña.setColumns(10);
		
		fechaNacimiento = new JTextField();
		fechaNacimiento.setColumns(10);
		fechaNacimiento.setBounds(170, 144, 96, 19);
		contentPane.add(fechaNacimiento);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(170, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblCorreo = new JLabel("correo");
		lblCorreo.setBounds(170, 47, 45, 13);
		contentPane.add(lblCorreo);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(170, 89, 71, 13);
		contentPane.add(lblContrasea);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(170, 132, 81, 13);
		contentPane.add(lblFechaNacimiento);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 7));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(170, 202, 96, 21);
		contentPane.add(btnNewButton);
	}
}
