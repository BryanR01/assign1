package assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class OrderDB implements OrderDBInterface{
	int size=25;
	Order[] orders=new Order[size];
	int OrderAmt;
	int place=0;
	int rand=0;

	@Override
	public int loadOrders(String fileName) {
		try {
			File file= new File(fileName);
			Scanner scanner= new Scanner(file);
			
			scanner.nextLine();// !!!Might cause problems
			
			while (scanner.hasNextLine()) {
				String line= scanner.nextLine();//Get one line from the file at once
				String[] OrderInfo=line.split(",");// make an array with every part of the order
				int id=Integer.parseInt(OrderInfo[0]);// The scanner made everything into a String so i have to change id and amt back to int and double
				double amt=Double.parseDouble(OrderInfo[3]);
				
				Order order= new Order(id, OrderInfo[1], OrderInfo[2], amt, OrderInfo[4]);
				OrderAmt++;
				
				if(rand<size) {
				orders[place]=order;
				place++;
				}
				
				rand++;
				
				
				
			}
			
		}catch(FileNotFoundException e) {
			System.out.printf("Error: File - "+ fileName+ " - Not Found");
		}
		return OrderAmt;
	}//LoadOrders
	
	

	@Override
	public int saveOrders(String fileName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void showOrders() {
		try {
		System.out.printf("%-9s %-35s %-9s", "Order ID", "Product","Total Amt\n");
		System.out.printf("%-9s %-35s %-9s", "--------", "--------", "---------\n");
		for(int i=0; i<orders.length; i++) {
			System.out.printf("%-9s %-35s %9.2f\n",orders[i].id , orders[i].product , orders[i].amt);
		}
		}catch(NullPointerException e) {
			System.out.printf("List is emplty\n\n");
		}
		
	}//Show

	@Override
	public boolean add(Order order) {
		if(orders[orders.length-1]==null) {
			orders[orders.length-1]=order;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void add(int index, Order order) {
		orders[index-1]=order;
		
	}

	@Override
	public void clear() {
		for(int i=0; i<size; i++) {
			orders[i]=null;
		}
		
	}

	@Override
	public Order get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int searchByOrderID(int orderID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order set(int index, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resize() {
		Order[] ordersTemp=orders;
		Order[] orders= new Order[size+25];
		for(int i=0; i>size; i++) {
			orders[i]=ordersTemp[i];
		}
		size+=25;
	}
	
	

}
