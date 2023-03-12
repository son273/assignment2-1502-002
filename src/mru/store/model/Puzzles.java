package mru.store.model;

public class Puzzles extends Toys{
	private long serialNum;
	private String name;
	private String brand;
	private float price;
	private int stockCount;
	private int minAge;
	private String type; 
	
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
	
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}



	@Override
	public String format() {
		return serialNum+";"+name+";"+brand+";"+price+";"+stockCount+";"+minAge+";"+type;
	}
	
	@Override
	public String toString() {
		return "Category: Puzzles, "+"Serial Number: "+serialNum+", Name: "+name+", Brand: "+brand+", Price: "+price+", Availible Stock: "+stockCount+", Minimum Age: "+minAge+", Type: "+type;
	}

}