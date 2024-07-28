package ClientGui;

import client.ChatClient;
import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Order;

public class updateOptionsGui {
	helpClass help= new helpClass();
	public static int updateStatus=-1;
	
	@FXML
	private Button btnBack=null;
	@FXML
	private Button btnUpdateAdd=null;
	@FXML
	private Button btnUpdatePrice=null;
	@FXML
	private TextField txtOrderNum;
	@FXML
	private Button btnSave=null;
	@FXML
	private TextField txtOrderAddress;
	@FXML
	private Label lblResult;
	@FXML
	private TextField txtOrderPrice;
	
	
	public void btnBack(ActionEvent event) throws Exception{
		help.generalBtnBack("/ClientGui/ClientStartGui.fxml", event);
	}
	
	public void btnAdd(ActionEvent event) throws Exception
	{
		help.changeScreen("/ClientGui/ClientUpdateAddGui.fxml", event);
	}
	
	public void btnPrice(ActionEvent event) throws Exception
	{
		help.changeScreen("/ClientGui/ClientUpdatePriceGUI.fxml", event);
	}
	
	public void btnSaveAdd(ActionEvent event) throws Exception
	{
		String orderNum=txtOrderNum.getText().toString();
		String address=txtOrderAddress.getText().toString();
		if(orderNum.trim().isEmpty() || (orderNum.equals("please enter order number!")) || (!help.checkNumIsInt(orderNum)))
		{
			txtOrderNum.setText("please enter order number!");
		}
		else if(address.trim().isEmpty()  || (address.equals("please enter order number!")))
		{
			txtOrderNum.setText("please enter address!");
		}
		else
		{
			String addressToUpdate="UpdateAddress "+orderNum+" "+txtOrderAddress.getText().toString();
			ClientUI.chat.accept(addressToUpdate);
		}
		
		if(updateStatus==1)
		{
			lblResult.setText("update succeeded!");
		}
		if(updateStatus==2)
		{
			lblResult.setText("update failed! no such order");
		}
		updateStatus=-1;
		
	}
	
	public void btnSavePrice(ActionEvent event) throws Exception
	{
		String orderNum=txtOrderNum.getText().toString();
		String price=txtOrderPrice.getText().toString();
		if(orderNum.trim().isEmpty() || (orderNum.equals("please enter order number!")) || (!help.checkNumIsInt(orderNum)))
		{
			txtOrderNum.setText("please enter order number!");
		}
		else if(price.trim().isEmpty() || (price.equals("please enter order number!")) )
		{
			txtOrderNum.setText("please enter price!");
		}
		else
		{
			if(help.checkNumIsDouble(price))
			{
				String priceToUpdate="UpdatePrice "+orderNum+" "+price;
				ClientUI.chat.accept(priceToUpdate);
			}
			else
			{
				txtOrderPrice.setText("please enter a correct price!");
			}
		}
		
		if(updateStatus==1)
		{
			lblResult.setText("update succeeded!");
		}
		if(updateStatus==2)
		{
			lblResult.setText("update failed! no such order");
		}
		updateStatus=-1;
		
	}

}
