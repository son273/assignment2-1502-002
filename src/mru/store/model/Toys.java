package mru.store.model;

/**
 * 
 * The Toys class is an abstract class that provides getters and setters for
 * various attributes of a toy. this class provides methods to format and
 * represent the object as a string.
 * 
 * @author Caesar and Steven
 * @version 6.9
 * 
 */
public abstract class Toys {
	protected long serialNum; // Serial Number of Toy
	protected String name; // Name of Toy
	protected String brand; // Brand Name
	protected float price; // Price of Toy
	protected int stockCount; // Availible Stock
	protected int minAge; // Minimum Age
	
	
	
//	public Toys(){
//		serialNum = 0;
//		name="";
//		brand="";
//		price=0;
//		stockCount=0;
//		minAge = 0;
//	}
//	
	
//	public Toys(long serialNum, String name, String brand, float price, int stockCount, int minAge){
//		this.serialNum = serialNum;
//		this.name = name;
//		this.brand = brand;
//		this.price = price;
//		this.stockCount = stockCount;
//		this.minAge = minAge;
//	}
//	
	
	
	
	
	
	
	/**
	 * Sets the serial number of the toy.
	 * 
	 * @param serialNum the serial number of the toy.
	 */
	public abstract void setSerialNumber(long serialNum);

	/**
	 * Gets the serial number of the toy.
	 * 
	 * @return the serial number of the toy.
	 */
	public abstract long getSerialNumber();

	/**
	 * Sets the name of the toy.
	 * 
	 * @param name the name of the toy.
	 */
	public abstract void setName(String name);

	/**
	 * Gets the name of the toy.
	 * 
	 * @return the name of the toy.
	 */
	public abstract String getName();

	/**
	 * Sets the brand of the toy.
	 * 
	 * @param brand the brand of the toy.
	 */
	public abstract void setBrand(String brand);

	/**
	 * Gets the brand of the toy.
	 * 
	 * @return the brand of the toy.
	 */
	public abstract String getBrand();

	/**
	 * Sets the price of the toy.
	 * 
	 * @param price the price of the toy.
	 */
	public abstract void setPrice(float price);

	/**
	 * Gets the price of the toy.
	 * 
	 * @return the price of the toy.
	 */
	public abstract float getPrice();

	/**
	 * Sets the available count of the toy.
	 * 
	 * @param stockCount the available count of the toy.
	 */
	public abstract void setAvalibleCount(int stockCount);

	/**
	 * Gets the available count of the toy.
	 * 
	 * @return the available count of the toy.
	 */
	public abstract int getAvalibleCount();

	/**
	 * Sets the minimum age appropriate for the toy.
	 * 
	 * @param minAge the minimum age appropriate for the toy.
	 */
	public abstract void setAgeAppropriate(int minAge);

	/**
	 * Gets the minimum age appropriate for the toy.
	 * 
	 * @return the minimum age appropriate for the toy.
	 */
	public abstract int getAgeAppropriate();

	/**
	 * Formats the toy information as a string.
	 * 
	 * @return the formatted string.
	 */
	public abstract String format();

	/**
	 * Returns a string representation of the toy object.
	 * 
	 * @return a string representation of the toy object.
	 */
	public abstract String toString();

}
