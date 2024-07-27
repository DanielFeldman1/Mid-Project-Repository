package ClientGui;

import java.util.Collection;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import entities.Order;

public class OrderPage extends Application {

	private OrderPageController orderPageController;

	private helpClass help = new helpClass();
	@FXML
	private Button btnNext;
	@FXML
	private ComboBox<String> cmbChooseRestaurant;
	@FXML
	private TextField Hour;
	@FXML
	private TextField Min;
	@FXML
	private Label labelErrorMessage;
	protected static Collection<String> restaurants;

	// Tasks - 1.a.Get a list of restaurant from the DB, fill the restaurant - Maybe
	// done
	// 1.b.Connect the OrderPage to be the next page after selecting the ip in the
	// client.
	// 2.Create a local Order object and add desired hour and restaurant to it.

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/clientOrderPage/OrderPage.fxml"));
		Scene scene = new Scene(root);
		// scene.setFill(Color.TRANSPARENT);
		primaryStage.setTitle("BiteMe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	private void initialize() {
		orderPageController = new OrderPageController();
		orderPageController.getRestaurants();
		cmbChooseRestaurant.setItems(FXCollections.observableArrayList(restaurants));
		if (OrderController.order == null)
			OrderController.order = new Order();
	}

	@FXML
	private boolean checkInput() {
		String hours = Hour.getText();
		String min = Min.getText(); // Corrected this line
		String restaurant = cmbChooseRestaurant.getValue();
		return orderPageController.checkInput(restaurant, hours, min);
	}

	@FXML
	private void btnNext(ActionEvent event) {
		if (checkInput()) {
			orderPageController.setDesiredHour(Integer.valueOf(Hour.getText()));
			orderPageController.setDesiredMin(Integer.valueOf(Min.getText()));
			orderPageController.setRestaurant(cmbChooseRestaurant.getValue());
			orderPageController.setDetails();
			OrderController.sendOrder();// REMOVE THIS AFTER TESTING
			//orderPageController.switchWindows(event, "/clientOrderPage/MenuPage.fxml");
		} else {
			labelErrorMessage.setText("Check Input");
		}
	}

	@FXML
	private void btnCancelClick(ActionEvent event) throws Exception {
		help.generalBtnBack("/ClientGui/ClientStartGui.fxml", event);
	}

}