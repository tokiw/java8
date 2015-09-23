package ex04_08;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	
	public Login() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		JLabel userLabel = new JLabel("User name:");
		JLabel passLabel = new JLabel("Password:");
		
		JTextField userTextField = new JTextField();
		JPasswordField passField = new JPasswordField();
		
		panel.add(userLabel);
		panel.add(userTextField);
		panel.add(passLabel);
		panel.add(passField);
		frame.add(panel);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(200, 100));
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
