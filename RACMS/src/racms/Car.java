package racms;

import java.util.Date;

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
}
