package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import controller.GestorAlquileres;
import controller.GestorUsuarios;
import model.Alquiler;
import model.Pelicula;
import model.Usuario;

public class IU_ALQUILAR extends JFrame {

	 private static final long serialVersionUID = 1L;
	 private JPanel contentPane;
	 String correoUsuario;

	    // Constructor que recibe una película
	 public IU_ALQUILAR(Pelicula pelicula,String correo) {
		 this.correoUsuario = correo;
		 setTitle("Alquilar Película");
	     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
	     setBounds(100, 100, 400, 300);
	     contentPane = new JPanel();
	     contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	     setContentPane(contentPane);
	     contentPane.setLayout(new BorderLayout(0, 0));

      // Panel para mostrar información
	     JPanel panelInfo = new JPanel();
	     contentPane.add(panelInfo, BorderLayout.CENTER);

      // Mostrar información de la película
	     JTextArea textArea = new JTextArea();
	     textArea.setEditable(false); // Solo lectura
	     textArea.setText("Título: " + pelicula.getTitulo() + "\n"
	         + "Director: " + pelicula.getDirector() + "\n"
	         + "Año: " + pelicula.getAnio());
	     contentPane.add(textArea, BorderLayout.CENTER);

	     JPanel panelBoton = new JPanel();
	     contentPane.add(panelBoton, BorderLayout.SOUTH);
	             
	     JButton btnAlquilar = new JButton("Alquilar");
	     btnAlquilar.setFont(new Font("Tahoma", Font.BOLD, 14));
	     panelBoton.add(btnAlquilar);

	  // Acción del botón "Alquilar"
	     btnAlquilar.addActionListener(e -> {
	          
	      //MIRAR EL USUARIO
	    	 Usuario usuario = GestorUsuarios.getGUsuarios().buscarUsuario("primero@hotmail.com");
	    	 if(usuario.laHeAlquilado(pelicula.getCodPeli())){
		     	//SI ESTA ALQUILADA	
	    		 JOptionPane.showMessageDialog(this, "Ya tenias alquilada la película: " + pelicula.getTitulo());
	    	 }
	    	 else {
	    		 //SI NO ESTA ALQUILADA 
	    		 Alquiler al = GestorAlquileres.getGAlquileres().crearAlquiler(usuario,pelicula);
	    		 GestorAlquileres.getGAlquileres().anadirAlquiler(usuario,al);
	    		 JOptionPane.showMessageDialog(this, "Has alquilado la película: " + pelicula.getTitulo());
	    	 }	
	        	
	    	 dispose(); // Cierra la ventana tras alquilar
	     });
	    }
	    
	    
}
