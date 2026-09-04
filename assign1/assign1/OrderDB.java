package assign1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
			
			//while (scanner.hasNextLine()) {
				for(int i=0; i<size; i++) {
					String line= scanner.nextLine();//Get one line from the file at once
					String[] OrderInfo=line.split(",");// make an array with every part of the order
					int id=Integer.parseInt(OrderInfo[0]);// The scanner made everything into a String so i have to change id and amt back to int and double
					double amt=Double.parseDouble(OrderInfo[3]);
					
					Order order= new Order(id, OrderInfo[1], OrderInfo[2], amt, OrderInfo[4]);
					OrderAmt++;
					
						orders[i]=order;
				}
				
				/*
				if(rand<size) {
				orders[place]=order; //Original code used for testing
				place++;
				}
				
				rand++;
				*/
				
			//}
			
		}catch(FileNotFoundException e) {
			System.out.printf("Error: File - "+ fileName+ " - Not Found");
		}
		return OrderAmt;
	}//LoadOrders
	
	

	@Override
	public int saveOrders(String fileName) {
		int writen=0;
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for(int i=0; i<orders.length; i++) {
				if(orders[i]!=null) {
					Order currOrd=orders[i];
					
					String line=String.format("%d, %s, %s, %.2f, %s", currOrd.id, currOrd.customer, currOrd.product, currOrd.amt, currOrd.date);
					
					writer.write(line);
					writer.newLine();
					writen++;
				}
			}//For
		
		}catch(IOException e) {
			System.out.println("Error saving file ");
		}
		return writen;
	}//Save Orders

	@Override
	public void showOrders() {
		try {
		System.out.printf("%-9s %-35s %-9s", "Order ID", "Product","Total Amt\n");
		System.out.printf("%-9s %-35s %-9s", "--------", "--------", "---------\n");
		
		for(int i=0; i<orders.length; i++) {
			if(orders[i]!=null) {
				System.out.printf("%-9s %-35s %9.2f\n",orders[i].id , orders[i].product , orders[i].amt);
			}
		}
		}catch(NullPointerException e) {
			System.out.printf("Array size error\n\n");
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
		if(orders[index-1]==null) {
			orders[index-1]=order;
		}else {
			System.out.println("That spot has an order in it. Try option 9 to replace it.");
		}
		
	}

	@Override
	public void clear() {
		for(int i=0; i<size; i++) {
			orders[i]=null;
		}
		
	}

	@Override
	public Order get(int index) {
		return orders[index-1];
	}

	@Override
	public int searchByOrderID(int orderID) {
		int index=0;
		try {
		for(int i=0; i<size; i++)
			if(orders[i].id==orderID) {
				index= i;
			}
		}catch(NullPointerException e) {
			System.out.println("That order ID does not exist");
		}
		return index;
	}

	@Override
	public Order remove(int index) {
		Order removedOrd=orders[index-1];
		orders[index-1]=null;
		
		System.out.println("Removed order: "+removedOrd.id+"-"+removedOrd.product);
		
		return removedOrd;
	}

	@Override
	public Order set(int index, Order order) {
		Order replacedOrd=orders[index-1];
		orders[index-1]=order;
		
		
		return replacedOrd;
	}

	@Override
	public int size() {
		int listItems=0;
		for(int i=0; i<orders.length; i++) {
			if(orders[i]!=null) {
				listItems++;
			}
		}
		return listItems;
	}

	@Override
	public int capacity() {
		int cap=orders.length;
		return cap;
	}

	@Override
	public void resize() {
		Order[] ordersTemp=orders;
		Order[] newOrders= new Order[size+25];
		for(int i=0; i<orders.length; i++) {
			newOrders[i]=ordersTemp[i];
		}
		this.orders=newOrders;
		size+=25;
	}
	
	

}
