package ClientGui;

import java.util.Collection;

import client.ChatClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class OrderSummary {
	helpClass help = new helpClass();
	public static ChatClient chatClient;

	@FXML
	private Button btnAddToOrder = null;
	@FXML
	private Button btnLogOutOrderSummary = null;
	
	
	public void btnAddToOrder(ActionEvent event) throws Exception 
	{
		help.changeScreen("/ClientGui/ClientMenu.fxml", event);
	}
	
	
	public void btnLogOutOrderSummary(ActionEvent event) throws Exception 
	{
		//logout from DB
		help.changeScreen("/ClientGui/LoginPage.fxml", event);
	}
	
	
	
	
	

}
