package racms;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditingFrame extends JFrame{
	String plate;
	DatabaseManager db = new DatabaseManager();
	Car car = db.getCar(plate);
	
	public EditingFrame(String plate) {
		this.plate = plate;
		this.setSize(800,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Edit Car");
	}
	
	public JPanel editPanel() {
		JPanel p = new JPanel();
		
		p.setLayout(new GridLayout(10, 2));
		
		JLabel dp = new JLabel("Daily Price: ");
		JTextField dailyPrice = new JTextField(""+car.getDailyPrice());
		JLabel mra = new JLabel("Minimum Renting Age: ");
		JTextField minRentAge = new JTextField(car.getMinRentAge());
		JLabel n = new JLabel("Notes: ");
		JTextField notes = new JTextField(car.getNotes());
		JLabel k = new JLabel("km: ");
		JTextField km = new JTextField(""+car.getKm());
		JLabel s = new JLabel("Status: ");
		JTextField status = new JTextField(car.getStatus());
		JLabel rn = new JLabel("Renter Name: ");
		JTextField renterName = new JTextField(car.getRenterName());
		JLabel rid = new JLabel("Renter ID: ");
		JTextField renterID = new JTextField(car.getRenterID());
		JLabel ra = new JLabel("Renter Address: ");
		JTextField renterAddress = new JTextField(car.getRenterAddress());
		JLabel rp = new JLabel("Renter Phone: ");
		JTextField renterPhone = new JTextField(car.getRenterPhone());
		JLabel rem = new JLabel("Renter E-Mail: ");
		JTextField renterEmail = new JTextField(car.getRenterEmail());
		
		p.add(dp);
		p.add(dailyPrice);
		p.add(mra);
		p.add(minRentAge);
		p.add(n);
		p.add(notes);
		p.add(k);
		p.add(km);
		p.add(s);
		p.add(status);
		p.add(rn);
		p.add(renterName);
		p.add(rid);
		p.add(renterID);
		p.add(ra);
		p.add(renterAddress);
		p.add(rp);
		p.add(renterPhone);
		p.add(rem);
		p.add(renterEmail);
		
		return p;
	}
}
