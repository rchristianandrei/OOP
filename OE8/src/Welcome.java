import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JPanel {
	
	private Font font = new Font("Times New Roman", Font.CENTER_BASELINE, 30);
	
	Welcome(){
		this.setLayout(new BorderLayout());
		
		JLabel title = new JLabel();
		title.setText("Welcome "+Account.getUsername());
		title.setForeground(Color.white);
		title.setFont(font);
		title.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel header = new JPanel();
		header.setPreferredSize(new Dimension(500, 50));
		header.setBackground(Color.red);
		header.setLayout(new BorderLayout());
		header.add(title, BorderLayout.CENTER);
		
		this.add(header, BorderLayout.NORTH);
	}
}
