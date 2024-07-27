package ClientGui;

import java.sql.Time;

import client.ChatClient;
import entities.Message;
import entities.Message.MessageType;
import entities.Order;

public class OrderController {

	protected static Order order;
	public static ChatClient client;

	public static void setDesiredTime(Time time) {
		order.setArriveTime(time);
	}

	public static void setRestaurant(String restaurant) {
		order.setRestaurant(restaurant);
	}

	public static void sendOrder() {
		Message request = new Message(MessageType.CLIENT_SEND_ORDER, order);
		client.handleMessageFromClientUI(request);
		order = null;
	}
}
