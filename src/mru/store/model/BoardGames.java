package mru.store.model;

public class BoardGames extends Toys{
	private int serialNum;
	private String name;
	private String brand;
	private int price;
	private int stockCount;
	private int minAge;
	private int numOfPlayers;
	private String designers; 
	

	@Override
	public void setSerialNumber(int serialNum) {
		this.serialNum = serialNum;
	}


	@Override
	public int getSerialNumber() {
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
	public void setPrice(int price) {
		this.price = price;		
	}

	@Override
	public int getPrice() {
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
	
	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	
	public void setDesigners(String designers) {
		this.designers = designers;
	}
	
	public String getDesigners() {
		return designers;
	}
	

}
