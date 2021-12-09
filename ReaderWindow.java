package realNumbReader;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ReaderWindow {

	private JFrame frame;
	private JButton btn;
	private JTextPane txtPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderWindow window = new ReaderWindow();
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
	public ReaderWindow() {
		initialize();

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if (a.getSource() == btn) {
					JFileChooser fileChooser = new JFileChooser();

					int response = fileChooser.showOpenDialog(null); // select file to open

					if (response == JFileChooser.APPROVE_OPTION) {
						File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
						assert file.exists() == false : "Error: File does not exists.";

						try {
							FileReader reader = new FileReader(file);
							int data = reader.read();
							String txt = "";

							while (data != -1) {
								txt += (char) data;
								data = reader.read();
							}

							fileLinkedList list = new fileLinkedList();

							for (int i = 0; i < txt.length(); i++) {
								if (Character.isDigit(txt.charAt(i))) {
									list.addNode(txt.charAt(i) - '0');
								}
							}

							txtPane.setText(list.calc());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					} else {
						fileChooser.hide();
					}

				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Choose File: ");
		lblNewLabel.setBounds(114, 111, 98, 16);
		frame.getContentPane().add(lblNewLabel);

		btn = new JButton("Select");
		btn.setBounds(224, 106, 117, 29);
		frame.getContentPane().add(btn);

		JLabel lblNewLabel_1 = new JLabel("Real Number Reader ");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(127, 31, 204, 40);
		frame.getContentPane().add(lblNewLabel_1);

		txtPane = new JTextPane();
		txtPane.setBounds(52, 160, 352, 95);
		frame.getContentPane().add(txtPane);
	}
}
