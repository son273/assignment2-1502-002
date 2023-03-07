package mru.store.model;

public class BoardGames extends Toys{
	private int serialNum;
	private String name;
	private String brand;
	private int price;
	private int stockCount;
	private int minAge;
	private int minNumOfPlayers;
	private int maxNumOfPlayers;
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
		return serialNum+";"+name+";"+brand+";"+price;
	}
	
	

}
