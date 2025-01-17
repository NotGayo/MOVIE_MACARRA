package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_ACCESO extends JFrame {
	private JButton logInButton;
	private JPanel contentPane;
	private JButton registerButton;
    private Controler controler = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_ACCESO frame = new IU_ACCESO();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_ACCESO() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentPane.getLayout();
		flowLayout.setVgap(170);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		logInButton = new JButton("LOG IN");
		contentPane.add(logInButton);
        this.logInButton.addActionListener(this.getControler());

		
		registerButton = new JButton("REGISTER");
		contentPane.add(registerButton);
        this.registerButton.addActionListener(this.getControler());

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
        	if (e.getSource().equals(logInButton)) {
        		//iniciar una ventana de login
        		closeWindow();
        		IU_LOGIN iulg = new IU_LOGIN();
        		iulg.run();
        	}
        	
        	if (e.getSource().equals(registerButton)) {
        		//iniciar una ventana de registro
        		closeWindow();
        		IU_REGISTRO iur = new IU_REGISTRO();
        		iur.run();
        	}
        }
	}

}
