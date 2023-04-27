import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.HashMap;

public class LibAdmin implements ActionListener {
	
	//frame for admin login
	JFrame loginFrame = new JFrame("Admin Login Page");
	JButton loginButton = new JButton("Login");
	JButton clearButton = new JButton("Clear");
	JTextField usernameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JLabel usernameLabel = new JLabel("Username:");
	JLabel passwordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel("Enter Admin Login Details");
	JLabel message = new JLabel();
	
	LibAdmin () {
		
		AdminLogin();
	}
	
	void AdminLogin() {
		
		usernameLabel.setBounds(50, 100, 80, 25);
		passwordLabel.setBounds(50, 130, 80, 25);
		
		messageLabel.setBounds(50, 50, 300, 35);
		messageLabel.setFont(new Font(null, Font.CENTER_BASELINE, 23));
		
		usernameField.setBounds(125, 100, 200, 25);
		passwordField.setBounds(125, 130, 200, 25);
		
		loginButton.setBounds(125, 170, 90, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		clearButton.setBounds(235, 170, 90, 25);
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);
		
		loginFrame.add(usernameLabel);
		loginFrame.add(passwordLabel);
		loginFrame.add(messageLabel);
		loginFrame.add(message);
		loginFrame.add(usernameField);
		loginFrame.add(passwordField);
		loginFrame.add(loginButton);
		loginFrame.add(clearButton);
		
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setSize(420, 300);
		loginFrame.setLayout(null);
		loginFrame.setVisible(true);
	}
	
	void welcomePage() {
		
		JFrame welcomeFrame = new JFrame();
		
		JLabel welcomeMessage = new JLabel("Welcome to NU Library System!");
		welcomeMessage.setBounds(15, 20, 400, 35);
		welcomeMessage.setFont(new Font(null, Font.CENTER_BASELINE, 25));
		
		welcomeFrame.add(welcomeMessage);
		
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setSize(420, 300);
		welcomeFrame.setLayout(null);
		welcomeFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==clearButton) {
			
			usernameField.setText("");
			passwordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			HashMap<String, String> adminUsers = new HashMap<>();
			adminUsers.put("Admin_01", "AdminOne");
			adminUsers.put("Admin_02", "AdminTwo");
			adminUsers.put("Admin_03", "AdminThree");
			
			String username = usernameField.getText(); 
            String password = new String(passwordField.getPassword());
            
            if(adminUsers.containsKey(username)) {
				
				if(adminUsers.get(username).equals(password)) {
					JOptionPane.showMessageDialog(null, "Login successful!");
					loginFrame.dispose();
					welcomePage();
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Password!");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Incorrect Username!");
			}
		}
	}
}
