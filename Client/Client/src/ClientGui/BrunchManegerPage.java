package ClientGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class BrunchManegerPage 
{
	private helpClass help = new helpClass();
	
	@FXML
	private ComboBox<String> cmbChooseBrunch;
	
	@FXML
	private Button btnApproveUser;
	
	@FXML
	private Button btnReports;
	
	@FXML
	private Button btnLogOut;
	
	public void btnReportsClick (ActionEvent event) throws Exception 
	{
		help.changeScreen("/ClientGui/ReportGui.fxml", event);
	}
	
	public void btnLogOutClick (ActionEvent event) throws Exception 
	{
		//logout from db
		help.changeScreen("/ClientGui/LoginPage.fxml", event);
	}
	
	
	

}
