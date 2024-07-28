package ClientGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SupplyMethod {
	helpClass help=new helpClass();
	
	@FXML
	public Button btnBack=null;
	@FXML
	public Button btnFinishOrder=null;
	
	@FXML
	private TextField txtRecipientName;
	@FXML
	private TextField txtAddreesWorkplace;
	@FXML
	private TextField txtPhoneNum;
	@FXML
	private TextField txtOrderNum;
	
	public void btnFinishOrder(ActionEvent event) throws Exception
	{
		help.changeScreen("/ClientGui/OrderSummary.fxml", event);
	}
	
	public void getBackBtn(ActionEvent event) throws Exception
	{
		help.generalBtnBack("/ClientGui/MenuGui.fxml", event);
	}
}
