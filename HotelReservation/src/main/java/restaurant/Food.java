package restaurant;

public class Food {
	
	private String id;
	private String name;
	private double price;
	
	public Food(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String getFoodID() {
		return this.id;
	}
	
	public String toString() {
		return "'" + this.id + "'    '" + this.name + "'     '" + this.price + "'\n";
	}

}
