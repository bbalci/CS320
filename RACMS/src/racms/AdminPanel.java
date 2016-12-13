package racms;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminPanel extends JFrame{
	public AdminPanel(){
		JLabel hello = new JLabel("MERHABA!");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,800);
		this.add(hello);
	}
}
