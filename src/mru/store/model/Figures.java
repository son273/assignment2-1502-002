package mru.store.model;

/**
 * The Figures class is a subclass of the Toys class and represents a type of
 * toy that is a figure. It contains information such as the serial number,
 * name, brand, price, stock count, minimum age, material, and size.
 * 
 * @author caesar and steven
 * @version 6.9
 * 
 */
public class Figures extends Toys {

	private long serialNum; // Serial Number of Toy
	private String name; // Name of Toy
	private String brand; // Brand Name
	private float price; // Price of Toy
	private int stockCount; // Availible Stock
	private int minAge; // Minimum Age
	private String classification; // Classification of Figure toy

	/**
	 * 
	 * Creates a new animal toy with the specified attributes.
	 * 
	 * @param serialNum,      the serial number of the figure
	 * @param name,           the name of the figure
	 * @param brand,          the brand of the figure
	 * @param price,          the price of the figure
	 * @param stockCount,     the number of figure in stock
	 * @param minAge,         the minimum age that the figure is appropriate for
	 * @param classification, the classification of figure
	 * 
	 */
	public Figures(long serialNum, String name, String brand, float price, int stockCount, int minAge,
			String classification) {
//		super(serialNum, name, brand, price, stockCount, minAge);
		this.serialNum = serialNum;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stockCount = stockCount;
		this.minAge = minAge;
		this.classification = classification;
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
	 * Returns Name
	 * 
	 * @return name to user
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Sets name to user input
	 * 
	 *@param name sets name
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns brand to user
	 * 
	 * @return brand
	 * 
	 */
	@Override
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets brand to user input
	 * 
	 * @param brand sets brand
	 * 
	 */
	@Override
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Returns the price
	 * 
	 * @return price
	 */
	@Override
	public float getPrice() {
		return price;
	}

	/**
	 * Sets price to user input
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
	 * returns the classification of figure
	 * 
	 * @return classification
	 */
	public String getClassification() {
		return classification;
	}

	/**
	 * sets classification based on user input
	 * 
	 * @param classification sets the classification of the figure
	 */
	public void setClassification(String classification) {
		this.classification = classification;
	}

	/**
	 * Formats string in format of .txt file
	 */
	@Override
	public String format() {
		return "0" + serialNum + ";" + name + ";" + brand + ";" + price + ";" + stockCount + ";" + minAge + ";"
				+ classification;
	}

	/**
	 * Formats fields in a legible format
	 */
	@Override
	public String toString() {
		return "Category: Figures, " + "Serial Number: 0" + serialNum + ", Name: " + name + ", Brand: " + brand
				+ ", Price: " + price + ", Availible Stock: " + stockCount + ", Minimum Age: " + minAge
				+ ", Classification: " + classification;
	}

}
