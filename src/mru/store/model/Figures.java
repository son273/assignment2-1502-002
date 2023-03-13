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

	private long serialNum;
	private String name;
	private String brand;
	private float price;
	private int stockCount;
	private int minAge;
	private String classification;

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
	 * Sets name to user input
	 * 
	 * @param name sets name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Returns name
	 * 
	 * @return name to user
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets brand to user input
	 * 
	 * @param brand sets brand
	 */
	@Override
	public String getBrand() {
		return brand;
	}

	/**
	 * Returns brand to user
	 * 
	 * @return brand
	 */
	@Override
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Sets price to user input
	 * 
	 * @param price sets price
	 */
	@Override
	public float getPrice() {
		return price;
	}

	/**
	 * Returns the price
	 * 
	 * @return price
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
	 * @param classification
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
