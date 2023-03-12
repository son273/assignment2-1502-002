package mru.store.model;

public class Figures extends Toys {

	private long serialNum;
	private String name;
	private String brand;
	private float price;
	private int stockCount;
	private int minAge;
	private String classification;
	
	public Figures (long serialNum, String name, String brand, float price, int stockCount, int minAge, String classification) {
		this.serialNum = serialNum;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stockCount = stockCount;
		this.minAge = minAge;
		this.classification = classification;
	}

	@Override
	public void setSerialNumber(long serialNum) {
		this.serialNum = serialNum;
	}

	@Override
	public long getSerialNumber() {
		return serialNum;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public String format() {
		return "0"+serialNum + ";" + name + ";" + brand + ";" + price + ";" + stockCount + ";" + minAge + ";"
				+ classification;
	}

	@Override
	public String toString() {
		return "Category: Figures, "+"Serial Number: 0"+serialNum+", Name: "+name+", Brand: "+brand+", Price: "+price+", Availible Stock: "+stockCount+", Minimum Age: "+minAge+", Classification: "+classification;
	}
	
	

	

}
