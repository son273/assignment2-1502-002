package mru.store.model;

/**
 * The Animals class is a subclass of the Toys class and represents a type of
 * toy that is an animal. It contains information such as the serial number,
 * name, brand, price, stock count, minimum age, material, and size.
 * 
 * @author Caesar and Steven
 * @version 6.9
 */

public class Animals extends Toys {

	
	private String material; // Material of toy
	private String size; // Size of toy

	/**
	 * Creates a new animal toy with the specified attributes.
	 * 
	 * @param serialNum  the serial number of the animal toy
	 * @param name       the name of the animal toy
	 * @param brand      the brand of the animal toy
	 * @param price      the price of the animal toy
	 * @param stockCount the number of animal toys in stock
	 * @param minAge     the minimum age that the animal toy is appropriate for
	 * @param material   the material that the animal toy is made of
	 * @param size       the size of the animal toy
	 */
	
	public Animals(long serialNum, String name, String brand, float price, int stockCount, int minAge, String material,
			String size) {
//		super(serialNum, name, brand, price, stockCount, minAge);
		this.serialNum = serialNum;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stockCount = stockCount;
		this.minAge = minAge;
		this.material = material;
		this.size = size;
	}

	/**
	 * Sets the serial number to user input
	 * 
	 * @param serialNum sets serial number
	 */
	@Override
	public void setSerialNumber(long serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * Returns the current serial number
	 * 
	 * @return serialNum
	 */
	@Override
	public long getSerialNumber() {
		return serialNum;
	}

	/**
	 * Return Name
	 * @return name
	 * 
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets name
	 * @param name sets name
	 * 
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns brand to user
	 * @return brand
	 */
	@Override
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets brand to user input
	 * @param brand sets brand
	 */
	@Override
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Return Price
	 * 
	 * @return price 
	 */
	@Override
	public float getPrice() {
		return price;
	}

	/**
	 * Sets the price
	 * 
	 * @param price sets price
	 */
	@Override
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * Sets stockCount to user input
	 * 
	 * @param stockCount sets stockCount
	 */
	@Override
	public void setAvalibleCount(int stockCount) {
		this.stockCount = stockCount;
	}

	/**
	 * Returns the stock count
	 * 
	 * @return stockCount
	 */
	@Override
	public int getAvalibleCount() {
		return stockCount;
	}

	/**
	 * Sets minAge to user input
	 * 
	 * @param minAge sets minAge
	 */
	@Override
	public void setAgeAppropriate(int minAge) {
		this.minAge = minAge;
	}

	/**
	 * Returns the min age
	 * 
	 * @return minAge
	 */
	@Override
	public int getAgeAppropriate() {
		return minAge;
	}

	/**
	 * returns material of animal toy
	 * 
	 * @return material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * sets the material of animal toy base on user input
	 * 
	 * @param material sets material
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * returns size of animal toy
	 * 
	 * @return size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * sets the size of animal toy based on user input
	 * 
	 * @param size sets size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Formats string in format of .txt file
	 */
	@Override
	public String format() {
		return serialNum + ";" + name + ";" + brand + ";" + price + ";" + stockCount + ";" + minAge + ";" + material
				+ ";" + size;
	}

	/**
	 * Formats fields in a legible format
	 */
	@Override
	public String toString() {
		return "Category: Animals, " + "Serial Number: " + serialNum + ", Name: " + name + ", Brand: " + brand
				+ ", Price: " + price + ", Availible Stock: " + stockCount + ", Minimum Age: " + minAge + ", Material: "
				+ material + ", Size: " + size;
	}

}