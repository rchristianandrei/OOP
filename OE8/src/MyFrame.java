import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	MyFrame(){
		this.setTitle("OE 8 by Andrei");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(new Login());
		
		this.setVisible(true);
	}
}
