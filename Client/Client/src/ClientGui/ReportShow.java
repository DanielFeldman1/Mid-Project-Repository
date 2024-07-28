package ClientGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ReportShow 
{
	private helpClass help = new helpClass();
	@FXML
	private Button btnBack;
	
	public void btnBackClick (ActionEvent event) throws Exception 
	{
		help.changeScreen("/ClientGui/ReportGui.fxml", event);
	}

}
