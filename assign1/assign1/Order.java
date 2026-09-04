package assign1;

public class Order {
	int id;
	String customer;
	String product;
	double amt;
	String date;
	
	public Order(){
		
	}
	
	public Order(int id, String customer, String product, double amt, String date){
		this.id=id;
		this.customer=customer;
		this.product=product;
		this.amt=amt;
		this.date=date;
	}
	
	public int getID() {return this.id;}
	public String getCustomer() {return this.customer;}
	public String getProduct() {return this.product;}
	public double getAmt() {return this.amt;}
	public String getDate() {return this.date;}

}
