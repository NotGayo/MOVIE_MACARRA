package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GestorUsuarios;

public class IU_MENU extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton pyr;
    private JButton alquilar;
    
    private Controler controler = null;
    private String correo;

    /**
     * Launch the application.
     */
            public void run() {
                try {
                    IU_MENU frame = new IU_MENU(correo);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


    /**
     * Create the frame.
     */
    public IU_MENU(String email) {
    	this.correo = email;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(2, 1, 10, 10)); // Dos filas, una para cada botón


        setContentPane(contentPane);
        pyr = new JButton("PUNTUAR Y RESERÑAR");
		contentPane.add(pyr);
        this.pyr.addActionListener(this.getControler());

        setContentPane(contentPane);
        alquilar = new JButton("ALQUILAR");
		contentPane.add(alquilar);
        this.alquilar.addActionListener(this.getControler());



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
        	if (e.getSource().equals(pyr)) {
        		//iniciar una ventana de login
        		closeWindow();
        		IU_PYR iupyr = new IU_PYR(correo, codPelicula);
        		iupyr.run();
        	}
        	
        	if (e.getSource().equals(alquilar)) {
        		//iniciar una ventana de login
        		closeWindow();
        		IU_BUSCARPELI iual = new IU_BUSCARPELI(correo);
        		//iual.run();
        	}
        	
        }
	}
    }

