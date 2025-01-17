package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class IU_LOGIN extends JFrame {

	private JPanel contentPane;
	private JTextField correoArea;
	private JTextField passwordArea;
    private Controler controler = null;
    private JButton logButton;

	/**
	 * Launch the application.
	 */
	
		public void run() {
			try {
				IU_LOGIN frame = new IU_LOGIN();
				frame.setVisible(true);
			} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	

	/**
	 * Create the frame.
	 */
	public IU_LOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		correoArea = new JTextField();
		correoArea.setBounds(162, 92, 96, 19);
		contentPane.add(correoArea);
		correoArea.setColumns(10);
		correoArea.addActionListener(getControler());
		
		
		passwordArea = new JTextField();
		passwordArea.setBounds(162, 145, 96, 19);
		contentPane.add(passwordArea);
		passwordArea.setColumns(10);
		passwordArea.addActionListener(getControler());
		
		logButton = new JButton("ACCEDER");
		logButton.setBounds(162, 202, 96, 21);
		contentPane.add(logButton);
		logButton.addActionListener(getControler());
		
		
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(162, 131, 73, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("email");
		lblNewLabel_1.setBounds(162, 77, 45, 13);
		contentPane.add(lblNewLabel_1);
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
        	if(e.getSource().equals(logButton)) {
        		//CHECKEAR Y PROCEDER CON EL LOGIN
        		
        		String email = correoArea.getText();
        		String password = passwordArea.getText();
        		
        		boolean logInCorrecto = GestorUsuarios.getGUsuarios().checkLogIn(email, password);
        		
        		if(logInCorrecto) {
        			//PASA A MENU PRINCIPAL
        		}
        		else {
        			//MOSTRAR PANTALLA DE ERROR
        		}
        		
        	}
        }
    }
}
