package ClientGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Login 
{
	private helpClass help = new helpClass();
	@FXML
	private TextField UserName;
	
	@FXML
	private TextField Password;
	
	@FXML
	private Button btnConfirm;
	
	@FXML
	private Button btnExit;
	
	
	public void btnConfirmClick (ActionEvent event) throws Exception 
	{
		//go to the require page according to db
	}
	
	public void btnExitClick (ActionEvent event) throws Exception 
	{
		help.ExitBtn(event);
	}
	
	
	
	

}
