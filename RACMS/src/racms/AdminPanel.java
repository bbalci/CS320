package racms;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminPanel extends JFrame{
	BusinessLayer business = new BusinessLayer();
	DatabaseManager db = new DatabaseManager();
	
	public AdminPanel(){
		this.setSize(800,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(vendorOffices());
	}
	
	public JPanel vendorOffices() {
		JPanel vendorPanel = new JPanel();
		
		ArrayList<Admin> allAdmins = business.listAdmins();
		vendorPanel.setLayout(new GridLayout(allAdmins.size(), 2));
		
		for(int i = 0; i<allAdmins.size(); i++) {
			vendorPanel.add(allAdmins.get(i).toPanel());
			JButton choose = new JButton("Choose");
			//TO-DO ADD ACTION LISTENER
			
			vendorPanel.add(choose);
		}
		return vendorPanel;
	}
	
	public JPanel carListingPanel(String vendorNo) throws IOException {
		JPanel carListingPanel = new JPanel();
		carListingPanel.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		
		JCheckBox listOnlyAvailable = new JCheckBox("List Only Available Cars");
		JCheckBox listOnlyRented = new JCheckBox("List Only Rented Cars");
		ArrayList<Car> cars = new ArrayList<Car>();
		JPanel checkBoxes = new JPanel();
		checkBoxes.setLayout(new FlowLayout());
		
		panel.setLayout(new GridLayout(cars.size(), 1));
		
		if (listOnlyAvailable.isSelected()) {
			for(int i = 0; i<cars.size();i++) {
				if(db.checkAvailable(cars.get(i).getPlate())) {
					panel.add(cars.get(i).toPanelAdmin());
				}
			}
		} else if (listOnlyRented.isSelected()) {
			for(int i = 0; i<cars.size();i++) {
				if(db.checkRented(cars.get(i).getPlate())) {
					panel.add(cars.get(i).toPanelAdmin());
				}
			}
		} else {
			for (int i = 0; i<cars.size(); i++) {
				panel.add(cars.get(i).toPanelAdmin());
			}
		}
		
		carListingPanel.add(checkBoxes, BorderLayout.NORTH);
		carListingPanel.add(panel, BorderLayout.SOUTH);
		return carListingPanel;
	}
	
}
