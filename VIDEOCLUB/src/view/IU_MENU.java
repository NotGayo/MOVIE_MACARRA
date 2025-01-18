package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IU_MENU extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IU_MENU frame = new IU_MENU();
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
    public IU_MENU() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridLayout(2, 1, 10, 10)); // Dos filas, una para cada botón

        // Botón para valorar
        JButton btnValorar = new JButton("Valorar");
        btnValorar.addActionListener(e -> {
            // Acción para el botón "Valorar"
            System.out.println("Se ha pulsado el botón Valorar.");
            // Aquí puedes abrir otra ventana para valoración
        });

        // Botón para alquilar
        JButton btnAlquilar = new JButton("Alquilar");
        btnAlquilar.addActionListener(e -> {
            // Abrir la ventana IU_BUSCARPELI
            String correoUsuario = "usuario@ejemplo.com"; // Correo de ejemplo
            IU_BUSCARPELI buscarPeliVentana = new IU_BUSCARPELI(correoUsuario);
            buscarPeliVentana.setVisible(true);
        });

        // Agregar botones al panel principal
        contentPane.add(btnValorar);
        contentPane.add(btnAlquilar);

        setContentPane(contentPane);
    }
}

