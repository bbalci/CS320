package racms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchPanelAdmin extends JFrame{
	
	public static void searchPanelAdmin(){
		
		JFrame frame = new JFrame("SELECT BRANCH");		
		JPanel MainPanel = new JPanel(new FlowLayout());
		
		//Branch List should be gathered from database
		String[] branchlist = {"1", "2", "3", "4", "5"};	
		
		JComboBox list = new JComboBox(branchlist);
		
		JButton goButton = new JButton("Go");
		goButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//TODO
			}
		});
		
		
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
                searchPanelAdmin();
            }
        });
	}

}
