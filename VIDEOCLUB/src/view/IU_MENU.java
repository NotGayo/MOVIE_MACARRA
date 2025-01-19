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
    private boolean esAdmin;
    private Controler controler = null;
    private String correo;
    private JButton adm_soli;
    private JButton adm_borrar;
    private JButton adm_modus;
    private JButton modus;


    /**
     * Launch the application.
     */
            public void run() {
                try {
                    IU_MENU frame = new IU_MENU(correo, esAdmin);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


    /**
     * Create the frame.
     */
    public IU_MENU(String email, boolean esAdmin) {
    	this.correo = email;
    	this.esAdmin = esAdmin;
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
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

        if(esAdmin) {
        	//btn solicitudes
        	setContentPane(contentPane);
            adm_soli = new JButton("SOLICITUDES");
    		contentPane.add(adm_soli);
            this.adm_soli.addActionListener(this.getControler());
        	//btn borrar user
            setContentPane(contentPane);
            adm_borrar = new JButton("BORRAR USUARIOS");
    		contentPane.add(adm_borrar);
            this.adm_borrar.addActionListener(this.getControler());
        	//modUsuario siendo admin
            setContentPane(contentPane);
            adm_modus = new JButton("MODIFICAR USERS");
    		contentPane.add(adm_modus);
            this.adm_modus.addActionListener(this.getControler());
        }
        //btn MOD DATOS USER
        setContentPane(contentPane);
        modus = new JButton("MODIFICAR MIS DATOS");
		contentPane.add(modus);
        this.modus.addActionListener(this.getControler());

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
        	if (e.getSource().equals(adm_soli)) {
        		//iniciar una ventana de modificar datos
        		closeWindow();
        		IU_SOLICITUDES_REG iusr = new IU_SOLICITUDES_REG(correo);
        		iusr.run();
        	}
        	if (e.getSource().equals(adm_borrar)) {
        		//iniciar una ventana de modificar datos
        		closeWindow();
        		IU_ADMIN_BORRAR_USUARIO iumd = new IU_ADMIN_BORRAR_USUARIO(correo);
        		iumd.run();
        	}
        	
        	if (e.getSource().equals(adm_modus)) {
        		//iniciar una ventana de modificar datos
        		closeWindow();
        		IU_ADMIN_MOD_USUARIO iumu = new IU_ADMIN_MOD_USUARIO(correo);
        		iumu.run();
        	}
        	if (e.getSource().equals(modus)) {
        		//iniciar una ventana de modificar datos
        		closeWindow();
        		IU_MOD_DATOS iumd = new IU_MOD_DATOS(correo);
        		iumd.run();
        	}
        	
        }
	}
    }

