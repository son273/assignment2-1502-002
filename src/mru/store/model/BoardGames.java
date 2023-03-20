package mru.store.model;

/**
 * The Board Games class is a subclass of the Toys class and represents a type of
 * toy that is a Board Game. It contains information such as the serial number,
 * name, brand, price, stock count, minimum age, minimum players, maximum players and designers.
 * 
 * @author Steven and Caesar
 * @version 6.9
 * 
 */
public class BoardGames extends Toys {
	private long serialNum; // Serial Number of Toy
	private String name; // Name of Toy
	private String brand; // Brand Name
	private float price; // Price of Toy
	private int stockCount; // Availible Stock
	private int minAge; // Minimum Age
	private int minNumOfPlayers; // Minimum number of players
	private int maxNumOfPlayers; //Minimum number of players
	private String designers; // List of Designers

	/**
	 * Constructor for BoardGames, initializes all fields
	 * 
	 * @param serialNum       initializes serialNum
	 * @param name            initializes name
	 * @param brand           initializes brand
	 * @param price           initializes price
	 * @param stockCount      intializes stockCount
	 * @param minAge          initializes minAge
	 * @param minNumOfPlayers initializes minNumOfPlayers
	 * @param maxNumOfPlayers initializes maxNumOfPlayers
	 * @param designers       initializes designers
	 */
	public BoardGames(long serialNum, String name, String brand, float price, int stockCount, int minAge,
			int minNumOfPlayers, int maxNumOfPlayers, String designers) {
//		super(serialNum, name, brand, price, stockCount, minAge);
		this.serialNum = serialNum;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stockCount = stockCount;
		this.minAge = minAge;
		this.minNumOfPlayers = minNumOfPlayers;
		this.maxNumOfPlayers = maxNumOfPlayers;
		this.designers = designers;
	}

	@Override
	/**
	 * Sets serial number to user input
	 * 
	 * @param serialNum sets serialNum
	 */
	public void setSerialNumber(long serialNum) {
		this.serialNum = serialNum;
	}

	@Override
	/**
	 * Returns the serial number
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
	 * Returns the name
	 * 
	 * @return name
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
	 * Returns the brand
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

	@Override /**
				 * Sets availible stock to user input
				 * 
				 * @param stockCount sets stockCOunt
				 */
	public void setAvalibleCount(int stockCount) {
		this.stockCount = stockCount;
	}

	@Override
	/**
	 * returns stockCount
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
	 * Returns min age
	 * 
	 * @return minAge
	 */
	public int getAgeAppropriate() {
		return minAge;

	}

	/**
	 * Sets minimum # of players to user input
	 * 
	 * @param minNumOfPlayers sets minNumofPlayers
	 */
	public void setMinNumOfPlayers(int minNumOfPlayers) {
		this.minNumOfPlayers = minNumOfPlayers;
	}

	/**
	 * 
	 * @return Minimum # of players
	 */
	public int getMinNumOfPlayers() {
		return minNumOfPlayers;
	}

	/**
	 * Sets maximum number of players to user input
	 * 
	 * @param maxNumOfPlayers sets maxNumOfPlayers
	 */
	public void setMaxNumOfPlayers(int maxNumOfPlayers) {
		this.maxNumOfPlayers = maxNumOfPlayers;
	}

	/**
	 * @return maximum number of players
	 */
	public int getMaxNumOfPlayers() {
		return maxNumOfPlayers;
	}

	/**
	 * Sets designers to user input
	 * 
	 * @param designers sets designers
	 */
	public void setDesigners(String designers) {
		this.designers = designers;
	}

	/**
	 * Returns designers
	 * 
	 * @return designers
	 */
	public String getDesigners() {
		return designers;
	}

	@Override
	/**
	 * Formats string in format of txt file
	 */
	public String format() {
		return serialNum + ";" + name + ";" + brand + ";" + price + ";" + stockCount + ";" + minAge + ";"
				+ minNumOfPlayers + "-" + maxNumOfPlayers + ";" + designers;
	}

	@Override
	/**
	 * Formats fields in a leagible format
	 */
	public String toString() {
		return "Category: Board Games, " + "Serial Number: " + serialNum + ", Name: " + name + ", Brand: " + brand
				+ ", Price: " + price + ", Availible Stock: " + stockCount + ", Minimum Age: " + minAge
				+ ", Player Count: " + minNumOfPlayers + "-" + maxNumOfPlayers + ", Designers: " + designers;
	}

}
