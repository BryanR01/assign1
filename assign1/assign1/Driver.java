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
					+ "\n3.Add order at spot\n4.Clear \n5.Get order from spot \n6.Search by order ID "
					+ "\n7.Load orders \n8.Remove order at spot \n9.Roplace order at spot "
					+ "\n10.See amount of orders in list \n11.see total space on list \n12.Resize list +25\n" );
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
			else if(choice==4) {//4
				data.clear();
			}
			else if(choice==5) {//5
				int position;
				System.out.printf("Enter position in list for order: \n");
				position=key.nextInt();
				
				Order getOrd=data.get(position);
				
				System.out.printf("%-9s %-35s %-9s", "Order ID", "Product","Total Amt\n");
				System.out.printf("%-9s %-35s %-9s", "--------", "--------", "---------\n");
				System.out.printf("%-9s %-35s %-9s\n\n", getOrd.id, getOrd.product, getOrd.amt);
			}
			else if(choice==6) {//6
				int id;
				System.out.println("Enter order ID: ");
				id=key.nextInt();
				
				Order getOrd=data.orders[data.searchByOrderID(id)];
				
				System.out.printf("%-9s %-35s %-9s", "Order ID", "Product","Total Amt\n");
				System.out.printf("%-9s %-35s %-9s", "--------", "--------", "---------\n");
				System.out.printf("%-9s %-35s %-9s\n\n", getOrd.id, getOrd.product, getOrd.amt);
				
				
			}
			else if(choice==7) {//7
				data.loadOrders("orders.txt");
			}
			else if(choice==8) {//8
				int position;
				System.out.println("Enter position in list for order: ");
				position=key.nextInt();
				
				data.remove(position);
				
				
			}
			else if(choice==9) {//9
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
				data.set(position, newOrder);
			}
			else if(choice==10) {//10
				int listItems=data.size;
				System.out.println("Amount of items in list: "+listItems);
			}
			else if(choice==11) {
				System.out.printf("Total capacity of list is: "+data.capacity()+"\n\n");
			}
			else if(choice==12) {
				data.resize();
			}
	
			
			
			
		}//While
		

		
	}
	
}
