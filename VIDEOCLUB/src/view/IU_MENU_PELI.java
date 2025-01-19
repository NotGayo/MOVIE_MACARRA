package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Pelicula;

public class IU_MENU_PELI extends JFrame {

	private JPanel contentPane;
	private JButton valorar;
    private JButton alquilar;
    private JButton vpp;
    
    private Controler controler = null;
	private Pelicula pPelicula;
	private String correo;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IU_MENU_PELI frame = new IU_MENU_PELI(pPelicula, correo);
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	

	/**
	 * Create the frame.
	 */
	public IU_MENU_PELI(Pelicula pelicula, String usuario) {
		this.pPelicula = pelicula;
		this.correo = usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentPane.getLayout();
		flowLayout.setVgap(170);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        valorar = new JButton("PUNTUAR Y RESERÑAR");
		contentPane.add(valorar);
        this.valorar.addActionListener(this.getControler());

        setContentPane(contentPane);
        alquilar = new JButton("ALQUILAR");
		contentPane.add(alquilar);
        this.alquilar.addActionListener(this.getControler());
        
        setContentPane(contentPane);
        vpp = new JButton("VER PUNTUACIONES PROMEDIO");
		contentPane.add(vpp);
        this.vpp.addActionListener(this.getControler());

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
        	if (e.getSource().equals(valorar)) {
        		//iniciar una ventana de login
        		closeWindow();
        		IU_PYR iupyr = new IU_PYR(correo, pPelicula);
        		iupyr.run();
        	}
        	
        	if (e.getSource().equals(alquilar)) {
        		//iniciar una ventana de buscar pelicula
        		closeWindow();
        		IU_ALQUILAR iual = new IU_ALQUILAR(pPelicula, correo);
        		//iual.run();
        	}
        	
        	if (e.getSource().equals(vpp)) {
        		//iniciar una ventana de modificar datos
        		closeWindow();
        		IU_VPP iuvpp = new IU_VPP(pPelicula);
        		iuvpp.run();
        	}
        	
        }
	}
}