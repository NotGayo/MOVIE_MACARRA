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

import model.Pelicula;

public class IU_ALQUILAR extends JFrame {

	 private static final long serialVersionUID = 1L;
	    private JPanel contentPane;

	    // Constructor que recibe una pel�cula
	    public IU_ALQUILAR(Pelicula pelicula) {
	        setTitle("Alquilar Pel�cula");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
	        setBounds(100, 100, 400, 300);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(new BorderLayout(0, 0));

	        // Panel para mostrar informaci�n
	        JPanel panelInfo = new JPanel();
	        contentPane.add(panelInfo, BorderLayout.CENTER);

	        // Mostrar informaci�n de la pel�cula
	        JTextArea textArea = new JTextArea();
	        textArea.setEditable(false); // Solo lectura
	        textArea.setText("T�tulo: " + pelicula.getTitulo() + "\n"
	            + "Director: " + pelicula.getDirector() + "\n"
	            + "A�o: " + pelicula.getAnio());
	        contentPane.add(textArea, BorderLayout.CENTER);

	        
	        JPanel panelBoton = new JPanel();
	        contentPane.add(panelBoton, BorderLayout.SOUTH);
	        
	        
	        JButton btnAlquilar = new JButton("Alquilar");
	        btnAlquilar.setFont(new Font("Tahoma", Font.BOLD, 14));
	        panelBoton.add(btnAlquilar);

	        // Acci�n del bot�n "Alquilar"
	        btnAlquilar.addActionListener(e -> {
	            
	        	//MIRAR EL USUARIO	
	        	if(usuario.laHeAlquilado(pelicula.getCodPelicula()){
		        	//SI ESTA ALQUILADA	
	        		JOptionPane.showMessageDialog(this, "Ya tenias alquilada la pel�cula: " + pelicula.getTitulo());
	        	}
	        	else {
	        		//SI NO ESTA ALQUILADA crearAlquiler(usuario,pelicula)
		        	//					anadirAlquiler(usuario, pelicula)
	        	}
	        	

	        	
	        	
	        	
	            dispose(); // Cierra la ventana tras alquilar
	        });
	    }
	    
	    
}
