package mru.store.model;

/**
 * The Animals class is a subclass of the Toys class and represents a type of
 * toy that is an animal. It contains information such as the serial number,
 * name, brand, price, stock count, minimum age, material, and size.
 */

public class Animals extends Toys {

	private long serialNum; //
	private String name;
	private String brand;
	private float price;
	private int stockCount;
	private int minAge;
	private String material;
	private String size;

	/**
	 * Creates a new animal toy with the specified attributes.
	 * 
	 * @param serialNum  the serial number of the animal toy
	 * @param name       the name of the animal toy
	 * @param brand      the brand of the animal toy
	 * @param price      the price of the animal toy
	 * @param stockCount the number of animal toys in stock
	 * @param minAge     the minimum age that the animal toy is appropriate for
	 * @param material   the material that the animal toy is made of
	 * @param size       the size of the animal toy
	 */
	public Animals(long serialNum, String name, String brand, float price, int stockCount, int minAge, String material,
			String size) {
		this.serialNum = serialNum;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stockCount = stockCount;
		this.minAge = minAge;
		this.material = material;
		this.size = size;
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

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String format() {
		return serialNum + ";" + name + ";" + brand + ";" + price + ";" + stockCount + ";" + minAge + ";" + material
				+ ";" + size;
	}

	@Override
	public String toString() {
		return "Category: Animals, " + "Serial Number: " + serialNum + ", Name: " + name + ", Brand: " + brand
				+ ", Price: " + price + ", Availible Stock: " + stockCount + ", Minimum Age: " + minAge + ", Material: "
				+ material;
	}

}