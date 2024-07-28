package ClientGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
 
public class SupplierPage
{
	private helpClass help = new helpClass();
	
	@FXML
	private TextField OrderNum;
	
	@FXML
	private Button btnApprove;
	
	@FXML
	private ComboBox<String> cmbChooseStatus;
	
	@FXML
	private TextField ArriveTime;
	
	@FXML
	private Button btnSave;
	
	@FXML
	private Button btnLogOut;
	
	
	public void btnSaveClick (ActionEvent event) throws Exception 
	{
		//clear the fields//
	}
	
	public void btnLogOutClick (ActionEvent event) throws Exception 
	{
		//logout from db
		help.changeScreen("/ClientGui/LoginPage.fxml", event);
	}
	
	
	
	

}
