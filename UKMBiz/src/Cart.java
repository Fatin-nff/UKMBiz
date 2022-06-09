
public class Cart {
	private int Quantity;
	private Product Product;
	
	public Cart(int quantity, Product product) {
		Quantity = quantity;
		Product = product;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public Product getProduct() {
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}
	
}
