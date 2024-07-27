package client;


//import gui.AcademicFrameController;
import ClientGui.OrderStartGui;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientUI extends Application {
	public static ClientConsole chat; //only one instance
	
	
	
	public static void main(String[] args) throws Exception
	{
		launch(args);
	}

	 
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		 //chat = new ClientConsole("localhost", 5555); //This means I'm using my own computer, for prototype it needs an API
		 //For prototype make sure server asks for API and database password
		 
		 OrderStartGui aFrame = new OrderStartGui(); // create StudentFrame
		aFrame.start(primaryStage);
	}
}
