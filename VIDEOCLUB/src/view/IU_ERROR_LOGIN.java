package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;

public class IU_ERROR_LOGIN extends JFrame {

	private JPanel contentPane;
	private JButton backToLogInBtn;
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
	public IU_ERROR_LOGIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(32, 20, 0, 0);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("CORREO O CONTRASE\u00D1A INCORRECTOS INTENTE DE NUEVO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(65, 20, 361, 143);
		contentPane.add(lblNewLabel);
		
		backToLogInBtn = new JButton("ACEPTAR");
		backToLogInBtn.setBounds(171, 213, 85, 21);
		backToLogInBtn.addActionListener(getControler());
		contentPane.add(backToLogInBtn);
		
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
        	if(e.getSource().equals(backToLogInBtn)) {
        		System.out.println("pulso");
        		closeWindow();
        		IU_LOGIN iulg = new IU_LOGIN();
        		iulg.run();
        	}
        }
    }
}
