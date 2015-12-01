import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dialog;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class Window_sing {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window_sing window = new Window_sing();
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
	public Window_sing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hola com et dius?");
		lblNewLabel.setBounds(173, 75, 70, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(173, 89, 114, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("Fes click");
		btnOk.setBounds(173, 137, 117, 25);
		btnOk.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog d = new JDialog(frame, "hello", true);
				d.setLocationRelativeTo(frame);
				d.setVisible(true);
			}});
		panel.add(btnOk);
			
	}
}
