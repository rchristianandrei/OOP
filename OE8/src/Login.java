
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel implements ActionListener{

	private JButton button;
	private Font font = new Font("Times New Roman", Font.CENTER_BASELINE, 30);
	JTextField username;
	JPasswordField password;
	
	Login(){
		this.setLayout(new BorderLayout());
		
		this.add(createHeader(), BorderLayout.NORTH);
		this.add(createBody(), BorderLayout.CENTER);
	}
	
	private JPanel createHeader() {
		
		JPanel header = new JPanel();
		header.setBackground(Color.red);
		header.setPreferredSize(new Dimension(500, 50));
		header.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Login");
		title.setFont(this.font);
		title.setForeground(Color.white);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		header.add(title, BorderLayout.CENTER);
		
		return header;
	}
	
	private JPanel createBody() {
		
		JPanel body = new JPanel();
		body.setBackground(new Color(99, 189, 194));
		body.setPreferredSize(new Dimension(500, 450));
		body.setLayout(null);
		
		Color color = new Color(242, 240, 235);
		
		JLabel userLabel = new JLabel();
		userLabel.setIcon(new ImageIcon("images/user.png"));
		userLabel.setBounds(10, 9, 32, 32);
		
		this.username = new JTextField();
		this.username.setBounds(52, 0, 238, 50);
		this.username.setBackground(color);
		this.username.setFont(this.font);
		this.username.setHorizontalAlignment(JTextField.CENTER);
		this.username.setBorder(null);
		
		JPanel usernamePanel = new JPanel();
		usernamePanel.setBounds(100, 80, 300, 50);
		usernamePanel.setBackground(color);
		usernamePanel.setLayout(null);
		usernamePanel.add(userLabel);
		usernamePanel.add(username);
		
		this.password = new JPasswordField();
		this.password.setBounds(52, 0, 238, 50);
		this.password.setBackground(color);
		this.password.setFont(this.font);
		this.password.setHorizontalAlignment(JTextField.CENTER);
		this.password.setBorder(null);
		this.password.setEchoChar('*');
		
		JLabel passLabel = new JLabel();
		passLabel.setIcon(new ImageIcon("images/padlock.png"));
		passLabel.setBounds(10, 9, 32, 32);
		
		JPanel passwordPanel = new JPanel();
		passwordPanel.setBounds(100, 150, 300, 50);
		passwordPanel.setBackground(color);
		passwordPanel.setLayout(null);
		passwordPanel.add(passLabel);
		passwordPanel.add(password);
		
		this.button = new JButton("Submit");
		this.button.setFocusable(false);
		this.button.setBackground(color);
		this.button.setFont(font);
		this.button.addActionListener(this);
		
		JPanel submitButtonPanel = new JPanel();
		submitButtonPanel.setBounds(175, 220, 150, 50);
		submitButtonPanel.setBackground(color);
		submitButtonPanel.setLayout(new BorderLayout());		
		submitButtonPanel.add(this.button);
		
		body.add(usernamePanel);
		body.add(passwordPanel);
		body.add(submitButtonPanel);
		
		return body;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button) {
			
			String username = this.username.getText();
			char[] password = this.password.getPassword();
			
			// Optional add restrictions to the length of input
			MyConnection connect = new MyConnection();
			connect.createQuery("SELECT * FROM users_tbl WHERE username = \""+username+"\"");
			
			if(Account.getUsername().equals(username)) {
				boolean isMatch = true;
				for(int i = 0; i < Account.getPassword().length(); i++) {
					if(password[i] != Account.getPassword().charAt(i)) {
						isMatch = false;
						break;
					}
				}
				
				if(isMatch) {
					System.out.println("Login success");
					
					this.setVisible(false);
					this.getParent().add(new Welcome());
					
					return;
				}
			}
			
			System.out.println("Error");
			JOptionPane.showConfirmDialog(this, "Login Unsuccessful", "Warning", JOptionPane.WARNING_MESSAGE);
			
		}
	}
}
