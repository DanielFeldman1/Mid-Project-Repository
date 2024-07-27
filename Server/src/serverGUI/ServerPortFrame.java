package serverGUI;

import java.util.Collection;
import java.util.Map;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ocsf.server.ConnectionToClient;
import server.EchoServer;
import server.OrderController;
import server.ServerUI;

public class ServerPortFrame extends Application {
	public static String str = "";

	@FXML
	private Button btnConnect = null;
	@FXML
	private Button btnExit = null;
	@FXML
	private TextField textMessage;
	@FXML
	private TextField dbname;
	@FXML
	private TextField password;
	@FXML
	private TextField serverip;
	@FXML
	private TextArea txtClientConnection;

	ServerPortFrame controller;

	public void Connect(ActionEvent event) throws Exception {

		if (str.equals("error")) {
			textMessage.setText("Couldn't connected!");
			str = "";
			return;
		}
		str += "connect";
		if (dbname.getText().trim() == "") {
			dbname.setText("Please enter scheme name");
		}

		if (password.getText().trim() == "") {
			password.setText("Please enter password");
		}
		if (str.equals("connect")) {
			EchoServer.oc = new OrderController(dbname.getText(), password.getText());
			if (EchoServer.oc.successFlag == 1) {
				ServerUI.runServer(EchoServer.DEFAULT_PORT.toString());
				serverip.setText(EchoServer.serverIp);
				textMessage.setText("Connected!");
			} else {
				textMessage.setText("conection failed!");
			}
		}
		str = "";
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/serverGUI/ServerGUI.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		controller = loader.getController();
		EchoServer.spf = this;
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void getExitBtn(ActionEvent event) throws Exception {
		System.out.println("exit Server");
		System.exit(0);
	}

//		public void printConnection(String str) 
//		{
//	            Platform.runLater(() -> {
//	                // Accessing txtClientConnection from the controller instance
//	                if (controller.txtClientConnection != null) {
//	                   controller.txtClientConnection.appendText(str+"\n");
//	                } else {
//	                    System.err.println("txtClientConnection is null!");
//	                }
//	            });
//		}

	public void printConnection(Map<ConnectionToClient, String> clientsMap) {
		System.out.println(clientsMap);
		Platform.runLater(() -> {
			// Accessing txtClientConnection from the controller instance
			String toPrint = "";
			Collection<String> values = clientsMap.values(); // all values in the map
			for (String value : values) {
				toPrint = toPrint + value + "\n"; // add all the values to a string to print
			}
			controller.txtClientConnection.setText(toPrint); // print the clients

		});
	}

}
