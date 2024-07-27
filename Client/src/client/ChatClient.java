// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import common.*;
import entities.Message;

import java.io.*;
import ClientGui.ClientMenu;
import ClientGui.OrderController;
import ClientGui.OrderPageController;
import ClientGui.showOrderGui;
import ClientGui.updateOptionsGui;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient {
	// Instance variables **********************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	ChatIF clientUI;
	public static boolean awaitResponse = false;////////////
	public static OrderPageController opc;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 *
	 * @param host     The server to connect to.
	 * @param port     The port number to connect on.
	 * @param clientUI The interface type variable.
	 * @throws IOException
	 */

	public ChatClient(String host, int port, ChatIF clientUI) throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		ClientMenu.chatClient = this;
		OrderPageController.dbController = this;
		OrderController.client = this;
		// openConnection();
	}
	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 *
	 * @param msg The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		if (msg instanceof Message) {
			Message message = (Message) msg;
			switch (message.getType()) {
			case SEND_RESTAURANTS:
				opc.setRestaurants(message.getContent());
				break;
			default:
				break;
			}
		}
		awaitResponse = false;
		clientUI.display(msg.toString());
		if (msg instanceof String) {
			String str = (String) msg; // turn object to string
			switch (str) {
			case "UpdateAddress_Fail":
				updateOptionsGui.updateStatus = 2;
				break;
			case "UpdateAddress_Success":
				updateOptionsGui.updateStatus = 1;
				break;
			case "UpdatePrice_Fail":
				updateOptionsGui.updateStatus = 2;
				break;
			case "UpdatePrice_Success":
				updateOptionsGui.updateStatus = 1;
				break;
			case "SpecificOrderFail":
				showOrderGui.updateStatus = 2;
				break;
			}
			if (str.toString().startsWith("SpecificOrderSuccess: ")) // resuletSet returned successfully
			{
				showOrderGui.updateStatus = 1;
				showOrderGui.res = str;
			}
		}
	}

	/**
	 * This method handles all data coming from the UI
	 *
	 * @param myMsg The message from the UI.
	 */
	public void handleMessageFromClientUI(Object myMsg) {
		try {
			awaitResponse = true;

			if (myMsg instanceof Message) {
				// Serialize the Message object into a byte array
				ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
				ObjectOutputStream out = new ObjectOutputStream(byteStream);
				out.writeObject(myMsg);
				out.flush();
				byte[] messageBytes = byteStream.toByteArray();
				// Send the byte array to the server
				sendToServer(messageBytes);
			} else {
				sendToServer(myMsg);
			}

			// wait for response
			if (myMsg instanceof String) {
				if (myMsg.equals("ClientDisconnect"))
					return;
			}
			while (awaitResponse) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			clientUI.display("Could not send message to server. Terminating client.");
			quit();
		}
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}
//End of ChatClient class
