package ClientGui;

import java.util.Collection;

import client.ChatClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class CEOMenu {
		helpClass help = new helpClass();
		public static ChatClient chatClient;

		@FXML
		private Button btnLogOut = null;
		@FXML
		private Button btnShow = null;
		@FXML
		private ComboBox<String> cmTypeReport1; //
		@FXML
		private ComboBox<String> cmTypeReport2;
		@FXML
		private ComboBox<String> cmNameRest1;//
		@FXML
		private ComboBox<String> cmNameRest2;
		protected static Collection<String> restaurants;
		
		//Enter data into comboBox from DB
		/*
		@FXML
		private boolean checkInput() {
			String report1 = cmTypeReport1.getValue();
			String restaurant1 = cmNameRest1.getValue();
			return orderPageController.checkInput(restaurant1,report1);
		}
		
		@FXML
		private void btnShow(ActionEvent event) {
			if (checkInput()) {
				orderPageController.setRestaurant(cmbChooseRestaurant.getValue());
				orderPageController.setDetails();
				OrderController.sendOrder();// REMOVE THIS AFTER TESTING
				//orderPageController.switchWindows(event, "/clientOrderPage/MenuPage.fxml");
			} else {
				labelErrorMessage.setText("Check Input");
			}
		}*/
		
	

		public void btnShowreports(ActionEvent event) throws Exception {
			help.changeScreen("/ClientGui/ReportShow.fxml", event); //Show the reports from DB
		}
		
		public void btnLogOut(ActionEvent event) throws Exception 
		{
			//logout from DB
			help.changeScreen("/ClientGui/LoginPage.fxml", event);
		}
}
