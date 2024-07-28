package ClientGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ReportPage
{
	private helpClass help = new helpClass();
	
	@FXML
	private ComboBox<String> cmbChooseRestaurant;
	
	@FXML
	private ComboBox<String> cmbChooseType;
	
	@FXML
	private TextField Date;
	
	@FXML
	private Button btnShow;
	
	@FXML
	private Button btnBack;
	
	public void btnShowClick (ActionEvent event) throws Exception 
	{
		help.changeScreen("/ClientGui/ReportShow.fxml", event);
	}
	
	public void btnBackClick (ActionEvent event) throws Exception 
	{
	
		help.changeScreen("/ClientGui/brunchManeger.fxml", event);
	}
	
	
	

}
