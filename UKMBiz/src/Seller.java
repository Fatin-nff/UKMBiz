
public class Seller{
	
	private String SellerID;
	private User user;
	//private String Name;


	public Seller(String sellerID, User u) {
		//super(us, ps, p, e);
		
		SellerID = sellerID;
		user = u;
		//Name = name;
	}


	public String getSellerID() {
		return SellerID;
	}


	public void setSellerID(String sellerID) {
		SellerID = sellerID;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
