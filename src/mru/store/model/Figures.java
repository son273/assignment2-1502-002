package mru.store.model;

public class Figures extends Toys {

	private int serialNum;
	private String name;
	private String brand;
	private int price;
	private int stockCount;
	private int minAge;
	private String classification;
	
	public Figures (int serialNum, String name, String brand, int price, int stockCount, int minAge, String classification) {
		this.serialNum = serialNum;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stockCount = stockCount;
		this.minAge = minAge;
		this.classification = classification;
	}

	@Override
	public void setSerialNumber(int serialNum) {
		this.serialNum = serialNum;
	}

	@Override
	public int getSerialNumber() {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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
		return serialNum + ";" + name + ";" + brand + ";" + price + ";" + stockCount + ";" + minAge + ";"
				+ classification;
	}

	

}
