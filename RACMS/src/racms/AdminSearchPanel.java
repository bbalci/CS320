package racms;

import java.awt.*;

import javax.swing.*;

public class AdminSearchPanel extends JFrame{
	
	public static void openAdminSearchPanel(){
		
		JFrame frame = new JFrame("SELECT BRANCH");		
		JPanel MainPanel = new JPanel(new FlowLayout());		
		String[] branchlist = {"1", "2", "3", "4", "5"};	
		
		JComboBox list = new JComboBox(branchlist);
		JButton goButton = new JButton("Go");
		JLabel searchVendorLabel = new JLabel("Branch List");
		
		searchVendorLabel.setLabelFor(list);
		
		MainPanel.add(searchVendorLabel);
		MainPanel.add(list);		
		MainPanel.add(goButton);
		
		MainPanel.setOpaque(true);
		
		frame.setContentPane(MainPanel);
		frame.setPreferredSize(new Dimension(500,200));
		frame.pack();
		frame.setVisible(true);		
		
	}
	
	public static void main(String[] args){
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                openAdminSearchPanel();
            }
        });
	}

}
