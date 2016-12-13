package racms;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Car {
	private String plate;
	private int vendorNo;
	private String brand;
	private String model;
	private String photo;
	private String gearType;
	private String fuelType;
	private double dailyPrice;
	private int minRentAge;
	private String segment;
	private String notes;
	private double km;
	private String status;
	private Date outDate;
	private Date returnDate;
	private String renterName;
	private int renterID;
	private String renterAddress;
	private int renterPhone;
	private String renterEmail;

	public Car(){
	}
	
	// Getters
	public String getPlate() {
		return plate;
	}

	public int getVendorNo() {
		return vendorNo;
	}

	public String getBrand() {
		return brand;
	}
	
	public String getModel() {
		return model;
	}

	public String getPhoto() {
		return photo;
	}

	public String getGearType() {
		return gearType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public double getDailyPrice() {
		return dailyPrice;
	}

	public int getMinRentAge() {
		return minRentAge;
	}

	public String getSegment() {
		return segment;
	}

	public String getNotes() {
		return notes;
	}

	public double getKm() {
		return km;
	}

	public String getStatus() {
		return status;
	}

	public Date getOutDate() {
		return outDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public String getRenterName() {
		return renterName;
	}

	public int getRenterID() {
		return renterID;
	}

	public String getRenterAddress() {
		return renterAddress;
	}

	public int getRenterPhone() {
		return renterPhone;
	}

	public String getRenterEmail() {
		return renterEmail;
	}

	// Setters
	public void setPlate(String newPlate) {
		plate = newPlate;
	}

	public void setVendorNo(int newVendorNo) {
		vendorNo = newVendorNo;
	}

	public void setBrand(String newBrand) {
		brand = newBrand;
	}
	
	public void setModel(String newModel) {
		model = newModel;
	}

	public void setPhoto(String newPhoto) {
		photo = newPhoto;
	}

	public void setGearType(String newGearType) {
		gearType = newGearType;
	}

	public void setFuelType(String newFuelType) {
		fuelType = newFuelType;
	}

	public void setDailyPrice(double newDailyPrice) {
		dailyPrice = newDailyPrice;
	}

	public void setMinRentAge(int newMinRentAge) {
		minRentAge = newMinRentAge;
	}

	public void setSegment(String newSegment) {
		segment = newSegment;
	}

	public void setNotes(String newNotes) {
		notes = newNotes;
	}

	public void setKm(int newKm) {
		km = newKm;
	}

	public void setStatus(String newStatus) {
		status = newStatus;
	}

	public void setOutDate(Date newOutDate) {
		outDate = newOutDate;
	}

	public void setReturnDate(Date newReturnDate) {
		returnDate = newReturnDate;
	}

	public void setRenterName(String newRenterName) {
		renterName = newRenterName;
	}

	public void setRenterID(int newRenterID) {
		renterID = newRenterID;
	}

	public void setRenterAddress(String newRenterAddress) {
		renterAddress = newRenterAddress;
	}

	public void setRenterPhone(int newRenterPhone) {
		renterPhone = newRenterPhone;
	}

	public void setRenterEmail(String newRenterEmail) {
		renterEmail = newRenterEmail;
	}
	
	public JPanel toPanel() throws IOException{
		JPanel car_panel = new JPanel();
		car_panel.setSize(100, 330);
		car_panel.setLayout(new GridLayout(1,3));
		
		URL url;
		url = new URL("http://balci.xyz/racms_photo/"+this.photo);
		BufferedImage c = ImageIO.read(url);
		ImageIcon image = new ImageIcon(c);
		
		JLabel car_image = new JLabel(image);
		car_image.setBorder(new EmptyBorder(10,10,10,10));
		
		JPanel car_info = new JPanel();
		car_info.setLayout(new GridLayout(5,1));
		JLabel brand_model = new JLabel(this.brand+" "+this.model);
		JLabel transmisson = new JLabel("Transmission: "+this.gearType);
		JLabel fuel = new JLabel("Fuel: " +this.fuelType);
		JLabel min_age = new JLabel("Minimum Age: "+this.minRentAge);
		JLabel segment = new JLabel(this.segment+" Segment");
		
		car_info.add(brand_model);
		car_info.add(segment);
		car_info.add(transmisson);
		car_info.add(fuel);
		car_info.add(min_age);
		
		JPanel car_rent = new JPanel();
		car_rent.setLayout(new GridLayout(3,1));
		car_rent.setBorder(new EmptyBorder(20,20,20,20));
		JLabel l_price = new JLabel("Daily Price");
		JLabel price = new JLabel(""+this.dailyPrice+" TL");
		JButton rent_button = new JButton("Rent");
		
		rentHandler rh = new rentHandler(this, car_info);
		rent_button.addActionListener(rh);
		
		car_rent.add(l_price);
		car_rent.add(price);
		car_rent.add(rent_button);
		
		car_panel.add(car_image);
		car_panel.add(car_info);
		car_panel.add(car_rent);
		
		return car_panel;
	}
}

class rentHandler implements ActionListener{
	JPanel jp = new JPanel();
	Car car = new Car(); 
	public rentHandler(Car c, JPanel j){
		jp=j;
		car=c;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		PaymentPanel pp = new PaymentPanel(jp, car);
		pp.setVisible(true);
	}
	
}

