package ClientGui;

import client.ChatClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class QWmenu {
	helpClass help = new helpClass();
	public static ChatClient chatClient;

	@FXML
	private Button btnSupplierOptions = null;
	@FXML
	private Button btnChangeMenu = null;
	@FXML
	private Button btnBack = null;

	public void btnSupplierOptions(ActionEvent event) throws Exception {
		help.changeScreen("/ClientGui/SupplierGUI.fxml", event);
	}

	public void btnChangeMenu(ActionEvent event) throws Exception {
		help.changeScreen("/ClientGui/ClientShowGui.fxml", event);
	}

//	public void btnLogout (ActionEvent event) throws Exception {
//		help.btnLogout(event);
//	}	
}