package ClientGui;

import java.sql.ResultSet;

import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class showOrderGui {
	helpClass help=new helpClass();
	public static int updateStatus=-1;
	public static String res="";
	
	@FXML
	public Button btnBack=null;
	@FXML
	public Button btnShow=null;
	@FXML
	private TextField txtRestaurant;
	@FXML
	private TextField txtOrderNum;
	@FXML
	private TextField txtTotalPrice;
	@FXML
	private TextField txtOrderListNum;
	@FXML
	private TextField txtOrderAddress;
	
	
	public void showDetails(ActionEvent event) throws Exception
	{
		String temp="";
		String orderNum=txtOrderNum.getText().toString();
		String toSend="SpecificOrder: "+orderNum;
		if(orderNum.trim().isEmpty() || (orderNum.equals("please enter order number!"))  || (orderNum.equals("no such order!"))|| (!help.checkNumIsInt(orderNum)))
		{
			txtOrderNum.setText("please enter order number!");
			txtRestaurant.setText("");
			txtTotalPrice.setText("");
			txtOrderListNum.setText("");
			txtOrderAddress.setText("");
		}
		else
		{
			ClientUI.chat.accept(toSend);
		}
		//after getting response from server
		if(updateStatus==2)
		{
			txtOrderNum.setText("no such order!");
			txtRestaurant.setText("");
			txtTotalPrice.setText("");
			txtOrderListNum.setText("");
			txtOrderAddress.setText("");
		}
		
		if(updateStatus==1) 
		{
			String[] result=res.split("\\s");
			for (int i=4; i<result.length; i++) {
				temp+=result[i]+" ";
			}
			txtRestaurant.setText(result[1]);
			txtTotalPrice.setText(result[2]);
			txtOrderListNum.setText(result[3]);
			txtOrderAddress.setText(temp);
		}
			
		 res="";
		 updateStatus=-1;
		 
	}
	
	public void getBackBtn(ActionEvent event) throws Exception
	{
		help.generalBtnBack("/ClientGui/ClientStartGui.fxml", event);
	}
}
