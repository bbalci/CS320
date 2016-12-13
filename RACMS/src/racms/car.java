package racms;


public class car {
	byte id;
	String brand;
	String model;
	String clas;
	String gear;
	byte door;
	byte seat;
	String fuel;
	byte price;
	String reserved;


	

	public car(byte id, String brand,String model,String clas, String gear, byte door,byte seat,String fuel,byte price,String reserved) {
		super();
		this.id=id;
		this.brand=brand;
		this.model=model;
		this.clas=clas;
		this.gear=gear;
		this.door=door;
		this.seat=seat;
		this.fuel=fuel;
		this.price=price;
		this.reserved=reserved;
		
		

	}
	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	public byte getId() {
		return id;
	}




	public void setId(byte id) {
		this.id = id;
	}




	public String getBrand() {
		return brand;
	}




	public void setBrand(String brand) {
		this.brand = brand;
	}




	public String getModel() {
		return model;
	}




	public void setModel(String model) {
		this.model = model;
	}




	public String getClas() {
		return clas;
	}




	public void setClas(String clas) {
		this.clas = clas;
	}




	public String getGear() {
		return gear;
	}




	public void setGear(String gear) {
		this.gear = gear;
	}




	public byte getDoor() {
		return door;
	}




	public void setDoor(byte door) {
		this.door = door;
	}




	public byte getSeat() {
		return seat;
	}




	public void setSeat(byte seat) {
		this.seat = seat;
	}




	public String getFuel() {
		return fuel;
	}




	public void setFuel(String fuel) {
		this.fuel = fuel;
	}




	public byte getPrice() {
		return price;
	}




	public void setPrice(byte price) {
		this.price = price;
	}




	public String toString() {
		return "Car [ID=" +id+" Brand="+brand+" Model="+model+" Class="+ clas+" Gear="+gear+ " Door="+ door+" Seat="+seat+" Fuel="+fuel+" Price="+price+" Reserved=" +reserved+"] is saved to database...";
	}

}
