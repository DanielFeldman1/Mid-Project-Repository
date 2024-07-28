package ClientGui;

import client.ChatClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CEOMenu {
		helpClass help = new helpClass();
		public static ChatClient chatClient;

		@FXML
		private Button btnUpdateOrder = null;
		@FXML
		private Button btnShowOrders = null;
		@FXML
		private Button btnExit = null;

		public void exitSystem(ActionEvent event) throws Exception {
			chatClient.handleMessageFromClientUI("ClientDisconnect");
			help.ExitBtn(event);
		}

		public void btnUpdate(ActionEvent event) throws Exception {
			help.changeScreen("/ClientGui/ClientUpdateGUI.fxml", event);
		}

		public void btnShowOrder(ActionEvent event) throws Exception {
			help.changeScreen("/ClientGui/ClientShowGui.fxml", event);
		}

		public void btnCreateNewOrder (ActionEvent event) throws Exception {
			help.changeScreen("/ClientGui/OrderPage.fxml", event);
		}	
}
