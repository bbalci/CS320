package racms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseManager {

	static final String DB_URL = "jdbc:mysql://localhost:3306/racms";
	static final String USER = "root";
	static final String PASS = "password";

	static Connection conn = null;
	static Statement stmt = null;
	
	public DatabaseManager() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
		} catch (SQLException ex) {
			System.err.println("Could not get an sql connection.");
			System.err.println(ex.getErrorCode() + ex.getMessage());
			System.exit(0);
		}
	}
	
	public ArrayList<Car> getCarList(){
		ArrayList<Car> cars = new ArrayList<Car>();
		
		String query = "Select * from car";
		try (ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				Car car = new Car();
				car.setBrand(rs.getString("brand"));
				car.setDailyPrice(rs.getDouble("Daily_Price"));
				car.setFuelType(rs.getString("Fuel_Type"));
				car.setGearType(rs.getString("Gear_Type"));
				car.setKm(rs.getInt("km"));
				car.setMinRentAge(rs.getInt("Min_rent_age"));
				car.setModel(rs.getString("model"));
				car.setNotes(rs.getString("notes"));
				car.setOutDate(rs.getDate("out_date"));
				car.setPhoto(rs.getString("photo"));
				car.setPlate(rs.getString("plate"));
				car.setRenterAddress(rs.getString("renter_address"));
				car.setRenterEmail(rs.getString("renter_email"));
				car.setRenterID(rs.getInt("renter_id"));
				car.setRenterName(rs.getString("renter_name"));
				car.setRenterPhone(rs.getInt("renter_phone"));
				car.setReturnDate(rs.getDate("return_date"));
				car.setSegment(rs.getString("segment"));
				car.setStatus(rs.getString("status"));
				car.setVendorNo(rs.getInt("vendor_no"));
				cars.add(car);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return cars;
	}
	
	public ArrayList<Admin> getAdminList() {
		ArrayList<Admin> admins = new ArrayList<Admin>();
		
		String query = "Select * from admin";
		try (ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setPasswd(rs.getString("passwd"));
				admin.setVendorName(rs.getString("vendor_name"));
				admin.setVendorNo(rs.getInt("vendor_no"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return admins;
	}
	
	public boolean checkAdmin(int vendor_no, String vendor_name, String passwd){
		int count = 0;
		
		String query = "Select count(*) from admin where vendor_no = '"+vendor_no + "' and vendor_name= '"+ vendor_name + "' and passwd = '"+ passwd +"'";
		try (ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		if(count == 0)
			return false;
		else
			return true;
		
	}
	
	public void addAdmin(int vendor_no, String vendor_name, String passwd) {
		String query = "Insert into admin values(" +vendor_no +",'"+vendor_name +"','" +passwd +"')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void addCar(String plate, int vendorNo, String brand, String model, String photo, 
			String gearType, String fuelType, double dailyPrice, int minRentAge, String segment, 
			String notes, double km, String status, Date outDate, Date returnDate, String renterName, 
			int renterID, String renterAddress, int renterPhone, String renterEmail) {
		
		String query = "insert into car values('"+plate+"',"+vendorNo+",'"+brand+"','"+model+"','"+
			photo+"','"+gearType+"','"+fuelType+"',"+dailyPrice+","+minRentAge+",'"+segment+"','"+
			notes+"',"+km+",'"+status+","+outDate+","+returnDate+",'"+renterName+"',"+renterID+",'"+
			renterAddress+"',"+renterPhone+",'"+renterEmail+"')";
		
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public boolean checkAvailable(String plate) {
		String query = "Select status from car where plate = " + plate;
		String status = null;
		
		try (ResultSet rs = stmt.executeQuery(query)){
			while(rs.next()){
				status = rs.getString("status");
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(status.equalsIgnoreCase("available"))
			return true;
		else
			return false;
	}
	
	public boolean checkRented(String plate) {
		String query = "Select status from car where plate = " + plate;
		String status = null;
		
		try (ResultSet rs = stmt.executeQuery(query)){
			while(rs.next()){
				status = rs.getString("status");
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(status.equalsIgnoreCase("rented"))
			return true;
		else
			return false;
	}
	
	public boolean checkAvailableAtCertainDates(String plate, Date rentingDate, Date returningDate) {
		if(checkAvailable(plate)) 
			return true;
		else {
			String query = "Select out_date, return_date from car where plate = " + plate;
			Date outDate = null;
			Date returnDate = null;
			
			try (ResultSet rs = stmt.executeQuery(query)){
				while(rs.next()){
					outDate = rs.getDate("out_date");
					returnDate = rs.getDate("return_date");
				}
			} catch(SQLException e) {
				System.out.println(e.getMessage());
			}
			
			if(rentingDate.after(returnDate))
				return true;
			else if(returningDate.before(outDate))
				return true;
			else
				return false;
		}
	}
	
	public void deleteCar(String plate) {
		String query = "delete from car where plate = '" + plate + "'";
		
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public ArrayList<Car> getVendorsCars(int vendorNo) {
		String query = "Select * from car where vendor_no = '"+vendorNo+"'";
		ArrayList<Car> cars = new ArrayList<Car>();
		
		try (ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				Car car = new Car();
				car.setBrand(rs.getString("brand"));
				car.setDailyPrice(rs.getDouble("Daily_Price"));
				car.setFuelType(rs.getString("Fuel_Type"));
				car.setGearType(rs.getString("Gear_Type"));
				car.setKm(rs.getInt("km"));
				car.setMinRentAge(rs.getInt("Min_rent_age"));
				car.setModel(rs.getString("model"));
				car.setNotes(rs.getString("notes"));
				car.setOutDate(rs.getDate("out_date"));
				car.setPhoto(rs.getString("photo"));
				car.setPlate(rs.getString("plate"));
				car.setRenterAddress(rs.getString("renter_address"));
				car.setRenterEmail(rs.getString("renter_email"));
				car.setRenterID(rs.getInt("renter_id"));
				car.setRenterName(rs.getString("renter_name"));
				car.setRenterPhone(rs.getInt("renter_phone"));
				car.setReturnDate(rs.getDate("return_date"));
				car.setSegment(rs.getString("segment"));
				car.setStatus(rs.getString("status"));
				car.setVendorNo(rs.getInt("vendor_no"));
				cars.add(car);
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return cars;
	}
	
}
