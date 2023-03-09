package mru.store.model;

public class BoardGames extends Toys{
	private long serialNum;
	private String name;
	private String brand;
	private float price;
	private int stockCount;
	private int minAge;
	private int minNumOfPlayers;
	private int maxNumOfPlayers;
	private String designers; 
	
	public BoardGames(long serialNum, String name, String brand, float price, int stockCount, int minAge, int minNumOfPlayers, int maxNumOfPlayers, String designers) {
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
	public void setSerialNumber(long serialNum) {
		this.serialNum = serialNum;
	}


	@Override
	public long getSerialNumber() {
		return serialNum;
	
	}

	@Override
	public void setName(String name) {
		this.name=name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String getBrand() {
		return brand;
	}

	@Override
	public void setPrice(float price) {
		this.price = price;		
	}

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public void setAvalibleCount(int stockCount) {
		this.stockCount = stockCount;
	}

	@Override
	public int getAvalibleCount() {
		return stockCount;
	}

	@Override
	public void setAgeAppropriate(int minAge) {
		this.minAge = minAge;
	}

	@Override
	public int getAgeAppropriate() {
		return minAge;
		
	}
	
	public void setMinNumOfPlayers(int minNumOfPlayers) {
		this.minNumOfPlayers = minNumOfPlayers;
	}
	
	public int getMinNumOfPlayers() {
		return minNumOfPlayers;
	}
	
	public void setMaxNumOfPlayers(int maxNumOfPlayers) {
		this.maxNumOfPlayers = maxNumOfPlayers;
	}
	
	public int getMaxNumOfPlayers() {
		return maxNumOfPlayers;
	}
	
	public void setDesigners(String designers) {
		this.designers = designers;
	}
	
	public String getDesigners() {
		return designers;
	}


	@Override
	public String format() {
		return serialNum+";"+name+";"+brand+";"+price+";"+stockCount+";"+minAge+";"+minNumOfPlayers+"-"+maxNumOfPlayers+";"+designers;
	}
	
	@Override
	public String toString() {
		return "Category: Board Games, "+"Serial Number: "+serialNum+", Name: "+name+", Brand: "+brand+", Price"+price+", Availible Stock: "+stockCount+", Minimum Age: "+minAge + ", Player Count: "+minNumOfPlayers+"-"+maxNumOfPlayers+", Designers:"+designers;
	}
	
	

}
