package view;

import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JList;
import model.Pelicula;
import controller.GestorPelis;

public class IU_BUSCARPELI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JList<Pelicula> list;
	private GestorPelis gestorPeliculas; // Gestor de películas

	// Método principal para ejecutar la aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_BUSCARPELI frame = new IU_BUSCARPELI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor de la ventana
	public IU_BUSCARPELI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.CENTER);

		gestorPeliculas = new GestorPelis(); // Inicializa el gestor de películas
		cargarPeliculas(); // Cargar algunas películas de ejemplo
		actualizarLista(); // Actualiza la JList con las películas
	}

	// Método para cargar algunas películas de ejemplo
	private void cargarPeliculas() {
		//gestorValoraciones.anadirValoracion(...)
		//valoraciones = gestorValoraciones.getGV().getListaVal()
		gestorPeliculas.anadirPelicula(new Pelicula(1,"El Padrino", "Francis Ford Coppola","asier", 1972,"fvh","dfghjkl", valoraciones ));
	}

	// Método para actualizar la lista con las películas
	private void actualizarLista() {
		DefaultListModel<Pelicula> modelo = new DefaultListModel<>(); // Modelo para la lista
		for (Pelicula pelicula : gestorPeliculas.getPeliculas()) {
			modelo.addElement(pelicula); // Agregar las películas al modelo
		}
		list.setModel(modelo); // Establecer el modelo en la JList
	}

	// Panel contenedor de la JList
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getList(), BorderLayout.CENTER);
		}
		return panel;
	}

	// Método para obtener la JList
	private JList<Pelicula> getList() {
		if (list == null) {
			list = new JList<>();
		}
		return list;
	}
}
