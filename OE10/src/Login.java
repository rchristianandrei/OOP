import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener{
	
	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private JButton button;
	
	Login(){
		
		frame = new JFrame();
		frame.setTitle("OE9 by Andrei");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	
		createHeader();
		createBody();
		
		frame.setVisible(true);
	}

	private void createHeader() {
		
		JPanel header = new JPanel();
		header.setPreferredSize(new Dimension(500, 50));
		header.setLayout(new BorderLayout());
		header.setBackground(Settings.headerBGColor);
		
		JLabel title = new JLabel("Login");
		title.setFont(Settings.headerFont);
		title.setForeground(Settings.headerFGColor);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		header.add(title, BorderLayout.CENTER);
		
		this.frame.add(header, BorderLayout.NORTH);
	}
	
	private void createBody() {
		
		JPanel body = new JPanel();
		body.setBackground(Settings.bodyBGColor);
		body.setPreferredSize(new Dimension(500, 450));
		body.setLayout(null);
		
		Color color = new Color(242, 240, 235);
		
		JLabel userLabel = new JLabel();
		userLabel.setIcon(new ImageIcon("images/user.png"));
		userLabel.setBounds(10, 9, 32, 32);
		
		this.username = new JTextField();
		this.username.setBounds(52, 0, 238, 50);
		this.username.setBackground(color);
		this.username.setFont(Settings.bodyFont);
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
		this.password.setFont(Settings.bodyFont);
		this.password.setHorizontalAlignment(JTextField.CENTER);
		this.password.setBorder(null);
		this.password.setEchoChar('*');
		this.password.addActionListener(this);
		
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
		this.button.setFont(Settings.bodyFont);
		this.button.addActionListener(this);
		
		JPanel submitButtonPanel = new JPanel();
		submitButtonPanel.setBounds(175, 220, 150, 50);
		submitButtonPanel.setBackground(color);
		submitButtonPanel.setLayout(new BorderLayout());		
		submitButtonPanel.add(this.button);
		
		body.add(usernamePanel);
		body.add(passwordPanel);
		body.add(submitButtonPanel);
		
		this.frame.add(body);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == button || e.getSource() == password) {
			String pass = "";
			
			for (char c : password.getPassword()) {
				pass += c;
			}
			
			password.setText("");
			
			MyConnection.getCredentials("select * from users_tbl where username ='"+username.getText()+"';");
			
			if(Account.username != null) {
				if(Account.username.equals(username.getText().toString()) && Account.password.equals(pass)) {
					new MainProgram();
					frame.dispose();
					return;
				}
			}
			
			JOptionPane.showMessageDialog(frame, "Invalid Credentials", "Warning", JOptionPane.WARNING_MESSAGE);
			
		}
	}
}
