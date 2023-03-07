package mru.store.model;

public abstract class Toys {
	// need setters/getters????
	//may need more
	//may need to overload toString and other methods
	
	public abstract void setSerialNumber(int serialNum);
	public abstract int getSerialNumber();

	public abstract void setName(String name);
	public abstract String getName();

	public abstract void setBrand (String brand);
	public abstract String getBrand ();

	public abstract void setPrice(int price);
	public abstract int getPrice();

	public abstract void setAvalibleCount(int stockCount);
	public abstract int getAvalibleCount();

	public abstract void setAgeAppropriate(int minAge);
	public abstract int getAgeAppropriate();

	public abstract String format();
	
	
	

	
	
	
	
}
