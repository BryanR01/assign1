package assign1;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[]args) {
		Scanner key=new Scanner(System.in);
		OrderDB data= new OrderDB();
		data.loadOrders("orders.txt");
		int choice=-1;
		
		while(choice!=0) {
			System.out.printf("What would you like to do?: \n1.Show Orders \n2.Add Order at end"
					+ "\n3.Add order at spot\n4.Clear \n5.Get order from spot \n6.Search by order ID \n" );
			choice=key.nextInt();
			
			if(choice==1) {//1
				data.showOrders();
			}
			else if(choice==2) {//2
				int id;
				String customer;
				String product;
				double amt;
				String date;
				
				System.out.print("Enter Order ID: ");
				id=key.nextInt();
				key.nextLine();
				
				System.out.print("Enter Customer Name: ");
				customer=key.nextLine();
				
				System.out.print("Enter Product name: ");
				product=key.nextLine();
				
				
				System.out.print("Enter Total Amount: ");
				amt=key.nextDouble();
				
				
				System.out.print("Enter Order Date: ");
				date=key.next();
				
				Order newOrder=new Order(id, customer, product, amt, date);
				data.add(newOrder);
				
				if(data.add(newOrder)==true) {
					System.out.println("Order added to end!");
					}else {
						System.out.println("Order could not be added list is full");
					}
				}
			else if(choice==3) {//3
				int position;
				
				int id;
				String customer;
				String product;
				double amt;
				String date;
				
				System.out.println("Enter position in list for order: ");
				position=key.nextInt();
				
				System.out.print("Enter Order ID: ");
				id=key.nextInt();
				key.nextLine();
				
				System.out.print("Enter Customer Name: ");
				customer=key.nextLine();
				
				System.out.print("Enter Product name: ");
				product=key.nextLine();
				
				
				System.out.print("Enter Total Amount: ");
				amt=key.nextDouble();
				
				
				System.out.print("Enter Order Date: ");
				date=key.next();
				
				Order newOrder=new Order(id, customer, product, amt, date);
				data.add(position, newOrder);
				
			}
			else if(choice==4) {
				data.clear();
			}
			
			
		}//While
		

		
	}
	
}
