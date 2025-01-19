package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
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
    private JButton mrp;
    private JButton buscarPeli;
    private JButton actualizarDatos;
    
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
		FlowLayout flowLayout = (FlowLayout) contentPane.getLayout();
		flowLayout.setVgap(170);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        mrp = new JButton("PUNTUAR Y RESERÑAR");
		contentPane.add(mrp);
        this.mrp.addActionListener(this.getControler());

        setContentPane(contentPane);
        buscarPeli = new JButton("BUSCAR PELICULA");
		contentPane.add(buscarPeli);
        this.buscarPeli.addActionListener(this.getControler());
        
        setContentPane(contentPane);
        actualizarDatos = new JButton("ACTUALIZAR DATOS");
		contentPane.add(actualizarDatos);
        this.actualizarDatos.addActionListener(this.getControler());




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
        	if (e.getSource().equals(mrp)) {
        		//iniciar una ventana de login
        		closeWindow();
        		IU_MRP iumrp = new IU_MRP(correo);
        		iumrp.run();
        	}
        	
        	if (e.getSource().equals(buscarPeli)) {
        		//iniciar una ventana de buscar pelicula
        		closeWindow();
        		IU_BUSCARPELI iual = new IU_BUSCARPELI(correo);
        		//iual.run();
        	}
        	
        	if (e.getSource().equals(actualizarDatos)) {
        		//iniciar una ventana de modificar datos
        		closeWindow();
        		IU_MOD_DATOS iumd = new IU_MOD_DATOS(correo);
        		iumd.run();
        	}
        	
        }
	}
    }

