package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IU_MRP extends JFrame {

	private JPanel contentPane;
	private String correo;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IU_MRP frame = new IU_MRP(correo);
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}

	/**
	 * Create the frame.
	 */
	public IU_MRP(String email) {
		this.correo = email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
