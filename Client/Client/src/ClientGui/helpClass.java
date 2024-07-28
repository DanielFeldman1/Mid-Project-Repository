package ClientGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//class to re-use code instead of rewriting things multiple times
public class helpClass {
	
//	General Logout button. Needs to change DB too
//	public void btnLogout (ActionEvent event) throws Exception {
//		help.changeScreen("/ClientGui/LoginPage.fxml", event);
//	}	
	
	public void generalBtnBack(String source,ActionEvent event) throws Exception{
		changeScreen(source, event);
	}
	
	//method to exit system
	public void ExitBtn(ActionEvent event) throws Exception {
		System.exit(0);			
	}
	
	public void changeScreen(String source,ActionEvent event) throws Exception
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
			//Stage primaryStage = new Stage();
			Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
			Pane root = loader.load(getClass().getResource(source).openStream());
			Scene scene = new Scene(root);	
			primaryStage.setTitle("Start Frame");
			primaryStage.setScene(scene);		
			primaryStage.show();
		}
		catch(Exception e) {e.printStackTrace(); }
	}
	
	//check that a string only contains numbers and one dot (for price field) -sure it should be here?
	public Boolean checkNumIsDouble(String num)
	{
		int countDots=0; //count how many dots are in the string
		for (char c : num.toCharArray()) {
		      if ((!(Character.isDigit(c))) && ((Character.compare(c, '.')))!=0) {
		         return false; //if the current char isn't a digit/isn't a dot
		      }
		      if((Character.compare(c, '.')==0)) //current char is a dot
		      {
		    	  if(countDots==1) //there is more than one dot in the string
		    	  {
		    		  return false;
		    	  }
		    	  countDots++;
		      }
		   }
		return true;
	}
	
	//check if a string is an int (for order number field)
	public Boolean checkNumIsInt(String num)
	{
		for (char c : num.toCharArray()) 
		{
		      if ((!(Character.isDigit(c))))
		      {
		         return false; //if the current char isn't a digit
		      }
		    
		   }
		return true;
	}
	

}
