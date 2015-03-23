import java.awt.EventQueue;
import javax.swing.JFrame;

public class main_window extends db{

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					db DATAB = new db();
					DATAB.CREATE_TABLES("ALL");
					main_window window = new main_window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
