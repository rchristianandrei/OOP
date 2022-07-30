import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;

public class MainProgram{
	
	private final String studentIDRegex = "[0-9]{4}-[0-9]{5}";
	private final String defQuery = "select * from student;";
	
	private JFrame frame;
	private JButton logout;
	
	private JButton add = new JButton("ADD");
	private JButton remove = new JButton("REMOVE");
	private JButton search = new JButton("SEARCH");
	private JButton edit = new JButton("EDIT");
	private JButton clear = new JButton("CLEAR");
	private JButton exit = new JButton("EXIT");
	
	private JTextField inputID;
	private JTextField inputName;
	private JTextField inputAdd;
	
	private JPanel results;
	private JScrollPane dataTable;
	
	MainProgram(){
		
		frame = new JFrame();
		frame.setTitle("OE10 by Andrei");
		frame.setSize(1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		createHeader();
		createBody();
		
		frame.setVisible(true);
	}

	private void createHeader() {
		
		JPanel header = new JPanel();
		header.setPreferredSize(new Dimension(500, 80));
		header.setLayout(new BorderLayout());
		header.setBackground(Settings.headerBGColor);
		
		JLabel title = new JLabel(" Student Records");
		title.setFont(Settings.headerFont);
		title.setForeground(Settings.headerFGColor);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel userPanel = new JPanel();
		userPanel.setPreferredSize(new Dimension(300, 80));
		userPanel.setLayout(null);
		userPanel.setBackground(header.getBackground());
		
		JLabel user = new JLabel(Account.username+" ");
		user.setFont(Settings.headerFont);
		user.setHorizontalAlignment(JLabel.RIGHT);
		user.setForeground(Settings.headerFGColor);
		user.setBounds(0, 0, 220, 80);
		userPanel.add(user);
		
		this.logout = new JButton();
		this.logout.setBounds(220, 0, 80, 80);
		this.logout.setIcon(new ImageIcon("images/logout.png"));
		this.logout.setFocusable(false);
		this.logout.setBackground(userPanel.getBackground());
		this.logout.setBorder(null);
		this.logout.addActionListener(e -> {
			
			logout();
		});
		userPanel.add(this.logout);
		
		header.add(title, BorderLayout.WEST);
		header.add(userPanel, BorderLayout.EAST);
		
		this.frame.add(header, BorderLayout.NORTH);
	}
	
	private void createBody() {
		
		JPanel body = new JPanel();
		body.setBackground(Settings.bodyBGColor);
		body.setLayout(null);
		
		
		//	------Start of Input
		JPanel inputPanel = new JPanel();
		//inputPanel.setBackground(Color.red);
		inputPanel.setBounds(75, 25, 400, 500);
		inputPanel.setLayout(null);
		body.add(inputPanel);
		
		//	Settings
		int width = 350;
		int height = 40;
		int gapY = 50;
		
		Dimension inputDimension = new Dimension(250, 40);
		
		//	-----Student ID
		JPanel studentID = new JPanel();
		studentID.setBackground(Color.white);
		studentID.setBounds(25, 25, width, height);
		studentID.setLayout(new BorderLayout());
		inputPanel.add(studentID);
		
		JLabel id = new JLabel(" Student ID:");
		studentID.add(id, BorderLayout.WEST);
		
		inputID = new JTextField();
		inputID.setPreferredSize(inputDimension);
		inputID.setBorder(null);
		inputID.setHorizontalAlignment(JTextField.CENTER);
		inputID.setFont(Settings.bodyFont);
		studentID.add(inputID, BorderLayout.EAST);
		//	-----Student ID
		
		//	-----Student Name
		JPanel studentName = new JPanel();
		studentName.setBackground(Color.white);
		studentName.setBounds(25, (int)studentID.getBounds().getY() + height + gapY, width, height);
		studentName.setLayout(new BorderLayout());
		inputPanel.add(studentName);
		
		JLabel name = new JLabel(" Student Name:");
		studentName.add(name, BorderLayout.WEST);
		
		inputName = new JTextField();
		inputName.setPreferredSize(inputDimension);
		inputName.setBorder(null);
		inputName.setHorizontalAlignment(JTextField.CENTER);
		inputName.setFont(Settings.bodyFont);
		studentName.add(inputName, BorderLayout.EAST);
		//	-----Student Name
		
		//	-----Student Address
		JPanel studentAdd = new JPanel();
		studentAdd.setBackground(Color.white);
		studentAdd.setBounds(25, (int)studentName.getBounds().getY() + height + gapY, width, height);
		studentAdd.setLayout(new BorderLayout());
		inputPanel.add(studentAdd);
		
		JLabel address = new JLabel(" Student Address:");
		studentAdd.add(address, BorderLayout.WEST);
		
		inputAdd = new JTextField();
		inputAdd.setPreferredSize(inputDimension);
		inputAdd.setBorder(null);
		inputAdd.setHorizontalAlignment(JTextField.CENTER);
		inputAdd.setFont(Settings.bodyFont);
		studentAdd.add(inputAdd, BorderLayout.EAST);
		//	-----Student Address
		
		//	-----Buttons
		JPanel buttonsPanel = new JPanel();
		inputPanel.add(buttonsPanel);
		buttonsPanel.setBackground(buttonsPanel.getParent().getBackground());
		buttonsPanel.setBounds(25, (int)studentAdd.getBounds().getY() + height + gapY, width, 180);
		buttonsPanel.setLayout(new GridLayout(2, 3, 10, 10));
		buttonsPanel.add(add);
		buttonsPanel.add(remove);
		buttonsPanel.add(search);
		buttonsPanel.add(edit);
		buttonsPanel.add(clear);
		buttonsPanel.add(exit);
		
		JButton[] buttons = new JButton[6];
		buttons[0] = add;
		buttons[1] = remove;
		buttons[2] = search;
		buttons[3] = edit;
		buttons[4] = clear;
		buttons[5] = exit;
		
		add.setIcon(new ImageIcon("images/plus.png"));
		remove.setIcon(new ImageIcon("images/delete.png"));
		search.setIcon(new ImageIcon("images/search.png"));
		edit.setIcon(new ImageIcon("images/edit.png"));
		clear.setIcon(new ImageIcon("images/eraser.png"));
		exit.setIcon(new ImageIcon("images/exit.png"));
		
		add.addActionListener(e -> {
			
			add();
			getInfo(defQuery);
		});
		
		remove.addActionListener(e -> {
			
			remove();
			getInfo(defQuery);
		});
		
		search.addActionListener(e -> {
			
			search();
		});
		
		edit.addActionListener(e -> {
			
			edit();
			getInfo(defQuery);
		});
		
		clear.addActionListener(e -> {
			
			clear();
		});
		
		exit.addActionListener(e -> {
			
			exit();
		});
		
		for(JButton button : buttons) {
			
			button.setFocusable(false);
			button.setBackground(Color.white);
		}
		
		//	-----Buttons
		//	------End of Input
		
		//	------Start of Results
		results = new JPanel();
		results.setLayout(new BorderLayout());
		//results.setBackground(Color.red);
		results.setBounds(525, 25, 400, 500);
		body.add(results);
		
		getInfo(defQuery);
		
		//	------End of Results
		
		this.frame.add(body, BorderLayout.CENTER);
	}
	
	private void logout() {
		
		new Login();
		
		Account.username = null;
		Account.password = null;
		
		frame.dispose();
	}
	
	private void add() {
		
		String id = inputID.getText();
		String name = inputName.getText();
		String address = inputAdd.getText();
		
		if(!id.matches("[0-9]{4}-[0-9]{5}")) {
			
			message("Invalid ID", "Warning");
			return;
		}
		
		if(name.length() <= 0 && address.length() <= 0) {
			
			message("Blank Field", "Warning");
			return;
		}
		
		String statement = "insert into student (student_id, student_name, address) values ('"+id+"', '"+name+"', '"+address+"');";
		
		MyConnection.addQuery(statement, frame);
		getInfo(defQuery);
	}

	private void remove() {
		
		String id = inputID.getText();
		String query = "delete from student where student_id = '" + id + "';";
		
		if(!id.matches(studentIDRegex)) {
			
			message("Invalid ID", "Warning");
			return;
		}
		
		MyConnection.addQuery(query, frame);
		getInfo(defQuery);
	}
	
	private void edit() {
		
		String id = inputID.getText();
		String name = inputName.getText();
		String address = inputAdd.getText();
		
		if(!id.matches(studentIDRegex)) {
			
			message("Invalid ID", "Warning");
			return;
		}
		
		boolean nameIsEmpty = name.length() <= 0;
		boolean addIsEmpty = address.length() <= 0;
		
		if(nameIsEmpty && addIsEmpty) {
			
			message("Blank Field", "Notice");
			return;
		}
		
		String query = "update student set ";
		boolean isEdited = false;
		
		if (!nameIsEmpty) {
			
			query += "student_name = '" + name + "'";
			isEdited = true;
		}
		
		if(!addIsEmpty) {
			
			if(isEdited) {
				
				query += ", address = '" + address + "' ";
			}
			else {
				
				query += " address = '" + address + "' ";
			}
		}
		
		query+= "where student_id = '" + id + "';";
		
		MyConnection.addQuery(query, frame);
		getInfo(defQuery);
	}
	
	private void search() {
		
		String query = "select * from student;";
		boolean hasCons = false;
		
		if(!inputID.getText().isEmpty()) {
			
			query = query.substring(0, query.length()-1) + " where student_id like '%"+inputID.getText()+"%';";
			hasCons = true;
		}
		
		if(!inputName.getText().isEmpty()) {
			if(hasCons) {
				query = query.substring(0, query.length()-1) + " or student_name like '%"+inputName.getText()+"%';";
			}
			else {
				query = query.substring(0, query.length()-1) + " where student_name like '%"+inputName.getText()+"%';";
				hasCons = true;
			}
		}
		
		if(!inputAdd.getText().isEmpty()) {
			if(hasCons) {
				query = query.substring(0, query.length()-1) + " or address like '%"+inputAdd.getText()+"%';";
			}
			else {
				query = query.substring(0, query.length()-1) + " where address like '%"+inputAdd.getText()+"%';";
			}
		}
		
		getInfo(query);
		results.setVisible(false);
		results.setVisible(true);
	}
	
	private void clear() {
		
		inputID.setText(null);
		inputName.setText(null);
		inputAdd.setText(null);
	}
	
	private void exit() {
		
		frame.dispose();
	}
	
	private void getInfo(String query) {
		
		if(dataTable != null) {
			
			results.remove(dataTable);
			results.setVisible(false);
			results.setVisible(true);
		}
		
		Data data = MyConnection.getQuery(query, frame);
		
		if(data.getEntries() == null) {
			
			return;
		}
		
		JTable temp = new JTable(data.getEntries(), data.getColumns()) {
			
			public boolean isCellEditable(int x, int y) {
				
				return false;
			}
			
			public Component prepareRenderer(TableCellRenderer r, int data, int column) {
				
				Component c = super.prepareRenderer(r, data, column);
				
				try {
					
					int row = getSelectedRow();
					
					inputID.setText(getModel().getValueAt(row, 0).toString());
					inputName.setText(getModel().getValueAt(row, 1).toString());
					inputAdd.setText(getModel().getValueAt(row, 2).toString());
				}
				catch(Exception e) {
					
				}
				
				return c;
			}	
		};
		temp.setPreferredScrollableViewportSize(new Dimension(380, 460));
		temp.setFillsViewportHeight(true);
		
		dataTable = new JScrollPane(temp);
		
		results.add(dataTable, BorderLayout.CENTER);
	}
	
	private void message(String mssg, String title) {
		
		JOptionPane.showMessageDialog(frame, mssg, title, JOptionPane.WARNING_MESSAGE);
	}
}
