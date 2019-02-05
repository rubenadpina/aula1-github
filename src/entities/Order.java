package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static StringBuilder sb = new StringBuilder();
	private static SimpleDateFormat sdf = new SimpleDateFormat();

	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> items = new ArrayList<>();
	private Client client = new Client();
	
	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getitems() {
		return items;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem orderItem) {
		items.add(orderItem);
	}

	public void removeItem(OrderItem orderItem) {
		items.remove(orderItem);
	}

	public double total() {
		double sum = 0.00;
		for(OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		sb.append("Order moment: " + sdf.format(moment));
		sb.append("\nOrder status: ");
		sb.append(status + "\n");
		sb.append(client.toString());
		sb.append("\nOrder items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("\nTotal price: $");
		sb.append(total());
		return sb.toString();
	}
	
	
}
