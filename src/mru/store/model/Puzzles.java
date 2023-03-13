package mru.store.model;

/**
 * 
 * This Class is responsible for dealing with Puzzle toys * @author Steven and
 * Caesar
 * 
 * @version March 12, 2023
 * 
 */
public class Puzzles extends Toys {
	private long serialNum;
	private String name;
	private String brand;
	private float price;
	private int stockCount;
	private int minAge;
	private String type;

	/**
	 * Constructor of Puzzle
	 * 
	 * @param serialNum  initializes serial number
	 * @param name       initializes name
	 * @param brand      initializes brand
	 * @param price      initializes price
	 * @param stockCount initializes availible stock
	 * @param minAge     initializes minimum age
	 * @param type       initializes type of puzzle
	 */
	public Puzzles(long serialNum, String name, String brand, float price, int stockCount, int minAge, String type) {
		this.serialNum = serialNum;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stockCount = stockCount;
		this.minAge = minAge;
		this.type = type;
	}

	@Override
	/**
	 * Sets the serial number to user input
	 * 
	 * @param serialNum sets serial number
	 */
	public void setSerialNumber(long serialNum) {
		this.serialNum = serialNum;
	}

	@Override
	/**
	 * Returns the current serial number
	 * 
	 * @return serialNum
	 */
	public long getSerialNumber() {
		return serialNum;

	}

	@Override
	/**
	 * Sets name to user input
	 * 
	 * @param name sets name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	/**
	 * Returns name
	 * 
	 * @return name to user
	 */
	public String getName() {
		return name;
	}

	@Override
	/**
	 * Sets brand to user input
	 * 
	 * @param brand sets brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	/**
	 * Returns brand to user
	 * 
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}

	@Override
	/**
	 * Sets price to user input
	 * 
	 * @param price sets price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	/**
	 * Returns the price
	 * 
	 * @return price
	 */
	public float getPrice() {
		return price;
	}

	@Override
	/**
	 * Sets stockCount to user input
	 * 
	 * @param stockCount sets stockCount
	 */
	public void setAvalibleCount(int stockCount) {
		this.stockCount = stockCount;
	}

	@Override
	/**
	 * Returns the stock count
	 * 
	 * @return stockCount
	 */
	public int getAvalibleCount() {
		return stockCount;
	}

	@Override
	/**
	 * Sets minAge to user input
	 * 
	 * @param minAge sets minAge
	 */
	public void setAgeAppropriate(int minAge) {
		this.minAge = minAge;
	}

	@Override
	/**
	 * Returns the min age
	 * 
	 * @return minAge
	 */
	public int getAgeAppropriate() {
		return minAge;

	}

	/**
	 * Sets type of puzzle to user input
	 * 
	 * @param setType sets setType
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the type
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	@Override
	/**
	 * Formats string in format of txt file
	 */
	public String format() {
		return serialNum + ";" + name + ";" + brand + ";" + price + ";" + stockCount + ";" + minAge + ";" + type;
	}

	@Override
	/**
	 * Formats fields in a leagible format
	 */
	public String toString() {
		return "Category: Puzzles, " + "Serial Number: " + serialNum + ", Name: " + name + ", Brand: " + brand
				+ ", Price: " + price + ", Availible Stock: " + stockCount + ", Minimum Age: " + minAge + ", Type: "
				+ type;
	}

}