package ClientGui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuPage 
{
	private helpClass help = new helpClass();
	
	@FXML
	private Button btnSalad;
	
	@FXML
	private Button btnAppetizer;
	
	@FXML
	private Button btnMain;
	
	@FXML
	private Button btnDessert;
	
	@FXML
	private Button btnDrinks;
	
	@FXML
	private Button btnFinishAdd;
	
	public void btnFinishAddClick (ActionEvent event) throws Exception 
	{
		help.changeScreen("/ClientGui/ChooseSupplyMethodPage.fxml", event);
	}
}
