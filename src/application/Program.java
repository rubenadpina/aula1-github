package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		
		System.out.println("Enter cliente data:");
			System.out.print("Name: ");
			String clientName = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Birth date (DD/MM/YYYY): ");
			Date birthDate = sdf.parse(sc.nextLine()); 
			
			Client client = new Client(clientName, email, birthDate);
			
			System.out.println("Enter order data:");
			System.out.print("Status: ");
			OrderStatus status = OrderStatus.valueOf(sc.nextLine());
			
			Order order = new Order(new Date(), status, client);
			
			System.out.print("How many items to this order? ");
			int x = sc.nextInt();
			for (int i = 1; i <= x ; i++) {
				System.out.println("Enter #" + i + " item data:");
				System.out.print("Product name: ");
				sc.nextLine();
				String prdName = sc.nextLine();
				System.out.print("Product price: ");
				double price = sc.nextDouble();
				
				Product product = new Product(prdName, price);
				
				System.out.print("Quantity: ");
				int qtt = sc.nextInt();
				
				OrderItem orderItem = new OrderItem(qtt, price, product);
				
				order.addItem(orderItem);
				
			}
			
			System.out.println();
			System.out.println("ORDER SUMMARY:");
			System.out.println(order);

		sc.close();
	}

}
