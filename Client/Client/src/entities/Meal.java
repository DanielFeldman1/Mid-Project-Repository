package entities;

public class Meal {
	private String name, type, optionalComponents;
	private float price;
	
	public Meal(String name, String type, float price, String optionalComponents) {
		this.name = name;
		this.type = type;
		this.optionalComponents = optionalComponents;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOptionalComponents() {
		return optionalComponents;
	}

	public void setOptionalComponents(String optionalComponents) {
		this.optionalComponents = optionalComponents;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "name = " + name + "\n " + "type = " + type + "\n " + "optionalComponents = " + optionalComponents + "\n " +  "price = " + price + "\n ";
	}
}