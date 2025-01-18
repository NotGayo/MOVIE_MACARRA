package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;


public class IU_MOD_DATOS extends JFrame {

	private JPanel contentPane;
	private JTextField newNombre;
	private JTextField newCorreo;
	private JTextField newContrasena;
	private JButton confirmCambios;
    private Controler controler = null;

    
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IU_ERROR_LOGIN frame = new IU_ERROR_LOGIN();
			frame.setVisible(true);
		} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * Create the frame.
	 */
	public IU_MOD_DATOS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		newNombre = new JTextField();
		newNombre.setBounds(147, 44, 96, 19);
		contentPane.add(newNombre);
		newNombre.setColumns(10);
		
		newCorreo = new JTextField();
		newCorreo.setBounds(147, 98, 96, 19);
		contentPane.add(newCorreo);
		newCorreo.setColumns(10);
		
		newContrasena = new JTextField();
		newContrasena.setBounds(147, 147, 96, 19);
		contentPane.add(newContrasena);
		newContrasena.setColumns(10);
		
		confirmCambios = new JButton("CONFIRM");
		confirmCambios.setBounds(147, 211, 96, 21);
		contentPane.add(confirmCambios);
		
		JLabel lblNewLabel = new JLabel("nombre");
		lblNewLabel.setBounds(147, 34, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("correo");
		lblNewLabel_1.setBounds(147, 88, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("contrase\u00F1a");
		lblNewLabel_2.setBounds(147, 137, 58, 13);
		contentPane.add(lblNewLabel_2);
	}
	
	public void closeWindow() {
		this.dispose();
	}
	private Controler getControler() {
        if (this.controler == null) {
            this.controler = new Controler();
        }

        return this.controler;
    }
	
	private class Controler implements ActionListener {
        private Controler() {
        }
        
        public void actionPerformed(ActionEvent e) {
        	if(e.getSource().equals(confirmCambios)) {
        		//UPDATE USER DATA
        	}
        }
    }
}
