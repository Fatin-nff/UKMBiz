
public class Product {
	
	private String ProductID;
	private String Name;
	private double Price;
	private String Colour;
	private String Category;
	private int Stock;
	private String Description;
	
	
	public Product(String productID, String name, double price, String colour, String category, int stock, String description) {
		
		ProductID = productID;
		Name = name;
		Price = price;
		Colour = colour;
		Category = category;
		Stock = stock;
		Description = description;
	}

	public String getProductID() {
		return ProductID;
	}


	public void setProductID(String productID) {
		ProductID = productID;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public double getPrice() {
		return Price;
	}


	public void setPrice(int price) {
		Price = price;
	}


	public String getColour() {
		return Colour;
	}


	public void setColour(String colour) {
		Colour = colour;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
	}


	public int getStock() {
		return Stock;
	}


	public void setStock(int stock) {
		Stock = stock;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}
}
