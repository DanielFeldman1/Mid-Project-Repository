package ClientGui;
import client.ClientConsole;
import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OrderStartGui {
	public static String clientIp="";
	
	helpClass help= new helpClass();
	//Missing the Update Button
	@FXML
	private Button btnUpdateOrder=null;
	@FXML
	private Button btnShowOrders = null;
	@FXML
	private Button btnExit = null;
	@FXML
	private Button btnIP = null;
	@FXML
	private TextField txtIp;

	//method to change between screens
//	public void changeScreen(String source,ActionEvent event) throws Exception
//	{
//		try
//		{
//			FXMLLoader loader = new FXMLLoader();
//			((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
//			Stage primaryStage = new Stage();
//			Pane root = loader.load(getClass().getResource(source).openStream());
//			Scene scene = new Scene(root);	
//			primaryStage.setTitle("Start Frame");
//			primaryStage.setScene(scene);		
//			primaryStage.show();
//		}
//		catch(Exception e) {e.printStackTrace(); }
//	}
	

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/ClientGui/ClientGUIenterIP.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Show Start Frame");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}
	
	//method to enter ip when client logs in and presses button
	public void enterIp(ActionEvent event) throws Exception
	{
		Object[] toSend=new Object[2];
		String temp=txtIp.getText();
		if(temp.trim().isEmpty())
		{
			txtIp.setText("please enter ip!");
		}
		else
		{
			ClientUI.chat = new ClientConsole(temp, 5555);
			toSend[0]=event;
			toSend[1]=clientIp;
			clientIp="";
			//ClientUI.chat.accept(toSend); //fucks the code, why?
			help.changeScreen("/ClientGui/ClientStartGui.fxml",event);
		}	
	}
	
	
	
}
