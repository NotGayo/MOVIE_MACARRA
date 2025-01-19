package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IU_VPP extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			IU_VPP frame = new IU_VPP();
			frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}

	/**
	 * Create the frame.
	 */
	public IU_VPP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
