
public class Buyer{
	
	private String BuyerID;
	private User user;
	//private String Name;


	public Buyer(String buyerID, User u) {
		//super(us, ps, p, e);
		
		BuyerID = buyerID;
		user = u;
		//Name = name;
	}


	public String getBuyerID() {
		return BuyerID;
	}


	public void setBuyerID(String buyerID) {
		BuyerID = buyerID;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
}
