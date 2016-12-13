package racms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class RentPanel extends JFrame{
	public RentPanel() throws IOException{
		this.setTitle("Select the vehicle");
		DatabaseManager db = new DatabaseManager();
		ArrayList<Car> cars = db.getCarList();
	
		Dimension dim = new Dimension(750, (cars.size()*330));
	    this.setSize(dim);
	    
		JPanel frame_panel = new JPanel();
		frame_panel.setMaximumSize(dim);
		
    	GridLayout layout = new GridLayout(2*cars.size(),1);
    	frame_panel.setLayout(layout);
    	
	    for(int i=0; i<cars.size(); i++){
	    	JPanel panel = new JPanel();
	     	panel.setLayout(layout);
	    	panel=cars.get(i).toPanel();
	    	panel.setBorder(BorderFactory.createLineBorder(Color.black));
	    	frame_panel.add(panel);
	    }
	    
	    JScrollPane scrPane = new JScrollPane(frame_panel);
	    this.add(scrPane);
	    
	}
		
}
