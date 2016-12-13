
import java.util.ArrayList;
import java.util.Date;

public class BusinessLayer {
	private DatabaseManager databaseManager = new DatabaseManager();
	
	public ArrayList<Car> listCars(String vendorName, Date outDate, Date returnDate) {
		ArrayList<Car> allCars = databaseManager.getCarList();
		ArrayList<Car> pickedCars = new ArrayList<Car>();
		
		for(int i = 0; i < allCars.size(); i++) {
			if (databaseManager.checkAvailableAtCertainDates(allCars.get(i).getPlate(), outDate, returnDate)) {
				pickedCars.add(allCars.get(i));
			}
		}
		return pickedCars;
	}
	
	public ArrayList<Admin> listAdmins() {
		return databaseManager.getAdminList();
	}
}
