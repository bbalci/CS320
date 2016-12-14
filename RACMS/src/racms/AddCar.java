package racms;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCar extends JFrame{
	private DatabaseManager db = new DatabaseManager();
	
	public AddCar() {
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Add Car");
		this.add(getInfo());
	}
	
	private JPanel getInfo() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(18,2));
		
		JLabel p = new JLabel("Plate: ");
		JTextField plate = new JTextField();
		JLabel v = new JLabel("Vendor No: ");
		JTextField vendorNo = new JTextField();
		JLabel b = new JLabel("Brand: ");
		JTextField brand = new JTextField();
		JLabel m = new JLabel("Model: ");
		JTextField model = new JTextField();
		JLabel pho = new JLabel("Photo URL: ");
		JTextField photo = new JTextField();
		JLabel gt = new JLabel("Gear Type: ");
		JTextField gearType = new JTextField();
		JLabel ft = new JLabel("Fuel Type: ");
		JTextField fuelType = new JTextField();
		JLabel dp = new JLabel("Daily Price: ");
		JTextField dailyPrice = new JTextField();
		JLabel mra = new JLabel("Minimum Renting Age: ");
		JTextField minRentAge = new JTextField();
		JLabel s = new JLabel("Segment: ");
		JTextField segment= new JTextField();
		JLabel n = new JLabel("Notes: ");
		JTextField notes = new JTextField();
		JLabel k = new JLabel("km: ");
		JTextField km = new JTextField();
		JLabel st = new JLabel("Status: ");
		JTextField status = new JTextField();
		JLabel rn = new JLabel("Renter Name: ");
		JTextField renterName = new JTextField();
		JLabel rid = new JLabel("Renter ID: ");
		JTextField renterID = new JTextField();
		JLabel ra = new JLabel("Renter Address: ");
		JTextField renterAddress = new JTextField();
		JLabel rp = new JLabel("Renter Phone: ");
		JTextField renterPhone = new JTextField();
		JLabel rem = new JLabel("Renter E-Mail: ");
		JTextField renterEmail = new JTextField();
		
		panel.add(p);
		panel.add(plate);
		panel.add(v);
		panel.add(vendorNo);
		panel.add(b);
		panel.add(brand);
		panel.add(m);
		panel.add(model);
		panel.add(pho);
		panel.add(photo);
		panel.add(gt);
		panel.add(gearType);
		panel.add(ft);
		panel.add(fuelType);
		panel.add(dp);
		panel.add(dailyPrice);
		panel.add(mra);
		panel.add(minRentAge);
		panel.add(s);
		panel.add(segment);
		panel.add(n);
		panel.add(notes);
		panel.add(k);
		panel.add(km);
		panel.add(st);
		panel.add(status);
		panel.add(rn);
		panel.add(renterName);
		panel.add(rid);
		panel.add(renterID);
		panel.add(ra);
		panel.add(renterAddress);
		panel.add(rp);
		panel.add(renterPhone);
		panel.add(rem);
		panel.add(renterEmail);
		
		db.addCar(plate.getText(), Integer.parseInt(vendorNo.getText()), brand.getText(), model.getText(), 
				photo.getText(), gearType.getText(), fuelType.getText(), Double.parseDouble(dailyPrice.getText()), 
				Integer.parseInt(minRentAge.getText()), segment.getText(), notes.getText(), Double.parseDouble(km.getText()), 
				status.getText(), null, null, renterName.getText(), Integer.parseInt(renterID.getText()), 
				renterAddress.getText(), Integer.parseInt(renterPhone.getText()), renterEmail.getText());
		
		return panel;
	}
}
