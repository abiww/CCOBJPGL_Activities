import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

public class LibLibrarian implements ActionListener {
	
	////for librarian login frame
	JFrame loginframe = new JFrame("Librarian Login Page");
	
	JButton loginButton = new JButton("Login");
	JButton clearButton = new JButton("Clear");
	
	JTextField usernameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	
	JLabel usernameLabel = new JLabel("Username:");
	JLabel passwordLabel = new JLabel("Password:");
	JLabel messageLabel = new JLabel("Enter Librarian Login Details");
	JLabel message = new JLabel();
	
	//for library management frame
	JButton borrowButton;
	JTextField borrowField;
	JLabel mlabel;
	JTable table;
	JLabel labelMessage = new JLabel("Library Management");
	
	LibLibrarian () {
		
//		LibrarianLogin();
		LibraryManagement();
	}
	
	void LibrarianLogin() {
		
		usernameLabel.setBounds(50, 100, 80, 25);
		passwordLabel.setBounds(50, 130, 80, 25);
		
		messageLabel.setBounds(50, 50, 300, 35);
		messageLabel.setFont(new Font(null, Font.CENTER_BASELINE, 21));
		
		usernameField.setBounds(125, 100, 200, 25);
		passwordField.setBounds(125, 130, 200, 25);
		
		loginButton.setBounds(125, 170, 90, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		clearButton.setBounds(235, 170, 90, 25);
		clearButton.setFocusable(false);
		clearButton.addActionListener(this);
		
		loginframe.add(usernameLabel);
		loginframe.add(passwordLabel);
		loginframe.add(messageLabel);
		loginframe.add(message);
		loginframe.add(usernameField);
		loginframe.add(passwordField);
		loginframe.add(loginButton);
		loginframe.add(clearButton);
		
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginframe.setSize(420, 300);
		loginframe.setLayout(null);
		loginframe.setVisible(true);
	}
	
	void LibraryManagement() {
		
		JFrame libraryFrame = new JFrame("Library Management");
		
		JLabel borrowLabel = new JLabel("Enter Item:");
		borrowLabel.setBounds(10, 115, 70, 25);
		
		borrowField = new JTextField();
		borrowField.setBounds(80, 115, 70, 25);
		
		borrowButton = new JButton("Borrow");
		borrowButton.setBounds(160, 115, 100, 25);
		borrowButton.setFocusable(false);
		borrowButton.addActionListener(this);
		
		ArrayList<Book> books = new ArrayList<>();
		
		Book book1 = new Book();
		book1.name = "System Analysis and Design";
		book1.author = "Gary B. Shelly";
		book1.copy = 2;
		
		Book book2 = new Book();
		book2.name = "Android Application";
		book2.author = "Corinne Hoisington";
		book2.copy = 3;
		
		Book book3 = new Book();
		book3.name = "Programming Concepts and Logic Formulation";
		book3.author = "Rasauro E. Manuel";
		book3.copy = 4;
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
			   
		String column[] = {"Item #","Title", "Author", "Copies"};
		
		Object[][] rows = { 
				{0, book1.getName(), book1.getAuthor(), book1.getCopy()},
				{1, book2.getName(), book2.getAuthor(), book2.getCopy()},
				{2, book3.getName(), book3.getAuthor(), book3.getCopy()},
		};
		
		table = new JTable(rows, column);
		table.setBounds(10, 50, 430, 60);
		table.setRowHeight(20);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(1).setPreferredWidth(250);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(10);

		
		labelMessage.setBounds(120, 10, 400, 35);
		labelMessage.setFont(new Font(null, Font.CENTER_BASELINE, 25));

		libraryFrame.add(labelMessage);
		libraryFrame.add(table);
		libraryFrame.add(borrowLabel);
		libraryFrame.add(borrowField);
		libraryFrame.add(borrowButton);
		
		libraryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		libraryFrame.setSize(470, 300);
		libraryFrame.setLayout(null);
		libraryFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==clearButton) {
			usernameField.setText("");
			passwordField.setText("");
		}
		
		if(e.getSource()==loginButton) {
			
			HashMap<String, String> libUsers = new HashMap<>();
			libUsers.put("Librarian_01", "LibOne");
			libUsers.put("Librarian_02", "LibTwo");
			libUsers.put("Librarian_03", "LibThree");
			
			String username = usernameField.getText(); 
            String password = new String(passwordField.getPassword());
            
            if(libUsers.containsKey(username)) {
				
				if(libUsers.get(username).equals(password)) {
					JOptionPane.showMessageDialog(null, "Login successful!");
					loginframe.dispose();
					LibraryManagement();
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Password!");
				}
			}	
			else {
				JOptionPane.showMessageDialog(null, "Incorrect Username!");
			}
		}
        
		if(e.getSource()==borrowButton) {
			
			String borrow = borrowField.getText();
			
			if(borrow.equals("0")) {

				int currentCopy = (int) table.getValueAt(0, 3);
				int newCopy = currentCopy - 1;
				
				if (newCopy < 0) {
				
					JOptionPane.showMessageDialog(null, "NO COPIES AVAILABLE");
				}
				else {
					
					JOptionPane.showMessageDialog(null, "You rented: " + table.getValueAt(0, 1));
					table.setValueAt(newCopy, 0, 3);
				}
			}
			else if(borrow.equals("1")) {
				
				int currentCopy = (int) table.getValueAt(1, 3);
				int newCopy = currentCopy - 1;
				
				if (newCopy < 0) {
					
					JOptionPane.showMessageDialog(null, "NO COPIES AVAILABLE");
				}
				else {
					
					JOptionPane.showMessageDialog(null, "You rented: " + table.getValueAt(1, 1));
					table.setValueAt(newCopy, 1, 3);
				}
			}
			else if(borrow.equals("2")) {
				
				int currentCopy = (int) table.getValueAt(2, 3);
				int newCopy = currentCopy - 1;
				
				if (newCopy < 0) {
					
					JOptionPane.showMessageDialog(null, "NO COPIES AVAILABLE");
				}
				else {
					
					JOptionPane.showMessageDialog(null, "You rented: " + table.getValueAt(2, 1));
					table.setValueAt(newCopy, 2, 3);
				}
			}
			else {
				
				JOptionPane.showMessageDialog(null, "INDEX DOES NOT EXIST, Try Again!");
			}
		}
	}
}
