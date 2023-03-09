package mru.store.model;

public abstract class Toys {
	// need setters/getters????
	//may need more
	//may need to overload toString and other methods
	
	public abstract void setSerialNumber(long serialNum);
	public abstract long getSerialNumber();

	public abstract void setName(String name);
	public abstract String getName();

	public abstract void setBrand (String brand);
	public abstract String getBrand ();

	public abstract void setPrice(float price);
	public abstract float getPrice();

	public abstract void setAvalibleCount(int stockCount);
	public abstract int getAvalibleCount();

	public abstract void setAgeAppropriate(int minAge);
	public abstract int getAgeAppropriate();

	public abstract String format();
	public abstract String toString();
	
	
	

	
	
	
	
}
