import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class LibraryMain implements ActionListener {
	
	JFrame frame = new JFrame("Library Management");;
	JLabel label = new JLabel("Library Management");;
	JLabel label1 = new JLabel("Select your account:");;
	JButton adminLogin = new JButton("Admin");;
	JButton librarianLogin = new JButton("Librarian");
	
	LibraryMain() {
		
		label.setBounds(20, 20, 250, 35);
		label.setFont(new Font(null, Font.CENTER_BASELINE, 25));
		
		label1.setBounds(20, 50, 250, 35);
		
		adminLogin.setBounds(100, 80, 90, 25);
		adminLogin.setFocusable(false);
		adminLogin.addActionListener(this);
		
		librarianLogin.setBounds(100, 115, 90, 25);
		librarianLogin.setFocusable(false);
		librarianLogin.addActionListener(this);
		
		frame.add(label);
		frame.add(label1);
		
		frame.add(adminLogin);
		frame.add(librarianLogin);
			
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==adminLogin) {
			
			LibAdmin libAdmin = new LibAdmin();
			frame.dispose();
		} 
		
		if(e.getSource()==librarianLogin) {
			
			LibLibrarian libLbrarian = new LibLibrarian();
			frame.dispose();
		} 
	}
	
	public static void main(String[] args) {
		
		LibraryMain libraryMain = new LibraryMain();
	}
}
