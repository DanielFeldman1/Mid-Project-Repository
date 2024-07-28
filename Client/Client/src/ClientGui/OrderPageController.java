package ClientGui;

import entities.Message;
import entities.Message.MessageType;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import client.ChatClient;
import javafx.event.ActionEvent;

public class OrderPageController {

	public static ChatClient dbController;
	private helpClass windowSwitcher = new helpClass();
	private LocalTime desiredTime = LocalTime.MIDNIGHT;
	private String restaurant;
	// returns a list of all the restaurants

	public OrderPageController() {
		ChatClient.opc = this;
	}

	public void getRestaurants() {
		// Send a message to the server so it knows to return a list of all available
		// branches.
		Message request = new Message(MessageType.GET_RESTAURANTS, null);
		dbController.handleMessageFromClientUI(request); // Maybe something different?
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public void setDesiredHour(int hours) {
		System.out.println(hours);
		desiredTime = desiredTime.plusHours(Long.valueOf(hours));
		System.out.println(desiredTime);
	}

	public void setDesiredMin(int minutes) {
		System.out.println(minutes);
		desiredTime = desiredTime.plusMinutes(Long.valueOf(minutes));
		System.out.println(desiredTime);
	}

	public boolean checkInput(String restaurant, String hour, String min) {
		if (restaurant == null)
			return false;
		if (hour.equals(""))
			return false;
		if (restaurant.equals(""))
			return false;
		if (Integer.valueOf(hour) > 23 || Integer.valueOf(hour) < 0)
			return false;
		if (Integer.valueOf(min) > 59 || Integer.valueOf(min) < 0)
			return false;
		return true;

	}

	public void switchWindows(ActionEvent event, String path) {
		try {
			windowSwitcher.changeScreen(path, event);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setRestaurants(Object msg) {
		if (msg instanceof ArrayList) {
			Collection<String> restaurants = (ArrayList<String>) msg;
			OrderPage.restaurants = restaurants;
		}
	}

	public void setDetails() {
		System.out.println(desiredTime);
		OrderController.order.setArriveTime(Time.valueOf(desiredTime));
		OrderController.order.setRestaurant(restaurant);
	}
}
