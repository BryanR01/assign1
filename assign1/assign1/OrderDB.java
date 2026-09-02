package assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrderDB implements OrderDBInterface{
	Order[] orders=new Order[25];
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
				
				if(rand>=25) {
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
		System.out.println("Order ID  Product\t\t\t\tTotal Amt\n--------  -------\t\t\t\t---------");
		for(int i=0; i<orders.length; i++) {
			System.out.printf(orders[i].id +"\t  "+ orders[i].product +"\t\t\t\t"+ orders[i].amt+"\n");
		}
		
	}

	@Override
	public boolean add(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(int index, Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}
	
	

}
