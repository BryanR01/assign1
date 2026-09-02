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

}
