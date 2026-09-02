package assign1;

public class Driver {
	
	public static void main(String[]args) {
		OrderDB data= new OrderDB();
		
		data.loadOrders("orders.txt");
		
		data.showOrders();

		
	}
	
}
