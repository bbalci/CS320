package racms;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class DatabaseManager {

	static final String DB_URL = "jdbc:mysql://185.111.233.24:3306/kwmbalci_racms?verifyServerCertificate=false&useSSL=false";
	static final String USER = "kwmbalci_cs320";
	static final String PASS = "Merhaba123";

	static Connection conn = null;
	static Statement stmt = null;
	
	public DatabaseManager(){
		openConn();
	}
	
	public void openConn(){
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
		//openConn();
		ArrayList<Car> cars = new ArrayList<Car>();
		
		String query = "Select * from Car";
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
			//conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return cars;
	}
	
	public ArrayList<Admin> getAdminList() {
		//openConn();
		ArrayList<Admin> admins = new ArrayList<Admin>();
		
		String query = "Select * from Admin";
		try (ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setPasswd(rs.getString("passwd"));
				admin.setVendorName(rs.getString("vendor_name"));
				admin.setVendorNo(rs.getInt("vendor_no"));
				admins.add(admin);
			}
			//conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return admins;
	}
	
	public boolean checkAdmin(int vendor_no, String vendor_name, String passwd){
		//openConn();
		int count = 0;
		
		String query = "Select count(*) from Admin where vendor_no = '"+vendor_no + "' and vendor_name= '"+ vendor_name + "' and passwd = '"+ passwd +"'";
		try (ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				count = rs.getInt("count(*)");
			}
			//conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		if(count == 0)
			return false;
		else
			return true;
		
	}
	
	public void addAdmin(int vendor_no, String vendor_name, String passwd) {
		//openConn();
		String query = "Insert into Admin values(" +vendor_no +",'"+vendor_name +"','" +passwd +"')";
		try {
			stmt.executeUpdate(query);
			//conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void addCar(String plate, int vendorNo, String brand, String model, String photo, 
			String gearType, String fuelType, double dailyPrice, int minRentAge, String segment, 
			String notes, double km, String status, Date outDate, Date returnDate, String renterName, 
			int renterID, String renterAddress, int renterPhone, String renterEmail) {
		
		//openConn();
		
		String query = "insert into Car values('"+plate+"',"+vendorNo+",'"+brand+"','"+model+"','"+
			photo+"','"+gearType+"','"+fuelType+"',"+dailyPrice+","+minRentAge+",'"+segment+"','"+
			notes+"',"+km+",'"+status+","+outDate+","+returnDate+",'"+renterName+"',"+renterID+",'"+
			renterAddress+"',"+renterPhone+",'"+renterEmail+"')";
		
		try {
			stmt.executeUpdate(query);
			//conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public boolean checkAvailable(String plate) {
		//openConn();
		String query = "Select status from Car where plate ='" + plate+"'";
		String status = null;
		
		try (ResultSet rs = stmt.executeQuery(query)){
			while(rs.next()){
				status = rs.getString("status");
			}
			//conn.close();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}
		
		if(status.equalsIgnoreCase("available"))
			return true;
		else
			return false;
	}
	
	public boolean checkRented(String plate) {
		//openConn();
		String query = "Select status from Car where plate='" + plate+"'";
		String status = null;
		
		try (ResultSet rs = stmt.executeQuery(query)){
			while(rs.next()){
				status = rs.getString("status");
			}
			//conn.close();
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.out.println(e.getMessage());
		}
		
		if(status.equalsIgnoreCase("rented"))
			return true;
		else
			return false;
	}
	
	public boolean checkAvailableAtCertainDates(String plate, Date rentingDate, Date returningDate) {
		//openConn();
		if(checkAvailable(plate)) 
			return true;
		else {
			String query = "Select out_date, return_date from Car where plate = '" + plate+"'";
			Date outDate = null;
			Date returnDate = null;
			
			try (ResultSet rs = stmt.executeQuery(query)){
				while(rs.next()){
					outDate = rs.getDate("out_date");
					returnDate = rs.getDate("return_date");
				}
				//conn.close();
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
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
		//openConn();
		String query = "delete from Car where plate = '" + plate + "'";
		
		try {
			stmt.executeUpdate(query);
			//conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void rentCar(Car c){
		//openConn();
		String query = "update Car set "
				+"status='"+c.getStatus()+"',"
				+"renter_address='"+c.getRenterAddress()+"',"
				+"renter_email='"+c.getRenterEmail()+"',"
				+"renter_id="+c.getRenterID()+","
				+"renter_name='"+c.getRenterName()+"',"
			    +"renter_phone="+c.getRenterPhone()+","
				+"out_date='"+c.getOutDate()+"',"
				+"return_date='"+c.getReturnDate()+"'"
				+ " where plate = '" + c.getPlate() + "'";
		try {
			System.out.println(query);
			stmt.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Renting completed!");
			GMailSend g = new GMailSend(c.getRenterEmail());
			g.main();
			//conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.err.println(e.getMessage());
		}
	}
	
	public ArrayList<Car> getVendorsCars(int vendorNo) {
		//openConn();
		String query = "Select * from Car where vendor_no = '"+vendorNo+"'";
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
			//conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return cars;
	}
	
	public int checkID(String username, String password){
		//openConn();
		int result = 0;
		String query = "SELECT COUNT(vendor_no) FROM Admin WHERE vendor_no="+username+" and passwd='"+password+"'";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
	    	  	result = rs.getInt("COUNT(vendor_no)");
	            System.out.print(rs.getInt("COUNT(vendor_no)"));
			}
			//conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}
	
	public Car getCar(String plate) {
		//openConn();
		Car car = new Car();
		
		String query = "Select * from Car where plate = '"+plate+"'";
		
		try (ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
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
			}
			//conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		return car;
	}
}
