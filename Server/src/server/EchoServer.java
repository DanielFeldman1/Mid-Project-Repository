package server;

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entities.Message;
import entities.Message.MessageType;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import serverGUI.ServerPortFrame;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer {
	// Class variables *************************************************

	/**
	 * The default port to listen on.
	 */
	final public static Integer DEFAULT_PORT = 5555;
	public static OrderController oc;
	public static ServerPortFrame spf;
	public Map<ConnectionToClient, String> clientsMap = new HashMap<>();
	public static String serverIp;
	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 *
	 * @param port The port number to connect on.
	 */
	public EchoServer(int port) {
		super(port);
		try {
			serverIp = InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 *
	 * @param msg    The message received from the client.
	 * @param client The connection from which the message originated.
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		try {
			// Check if the message is in byte array form
			if (msg instanceof byte[]) {
				// Deserialize byte array to Message object
				byte[] messageBytes = (byte[]) msg;
				ByteArrayInputStream byteStream = new ByteArrayInputStream(messageBytes);
				ObjectInputStream objectStream = new ObjectInputStream(byteStream);
				msg = objectStream.readObject();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (msg instanceof Message) {
			Message message = (Message) msg;
			System.out.println("Message received: " + message.getType().toString() + " from " + client);
			switch (message.getType()) {
			case GET_RESTAURANTS:
				// Get list of all restaurants from DB
				// ------------------------STUB FOR TESTING--------------------------------
				ArrayList<String> restaurants = new ArrayList<>();
//				restaurants.add("McDonald's");
//				restaurants.add("Dominos");
//				restaurants.add("KFC");
//				restaurants.add("YESSSSSSSS!!!!!!!!!!!!!");
				ResultSet rs = oc.importRestaurants();
				try {
					while(rs.next())
						restaurants.add(rs.getString(1));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ------------------------STUB FOR TESTING--------------------------------
				Message ret = new Message(MessageType.SEND_RESTAURANTS, restaurants);
				try {
					client.sendToClient(ret);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case CLIENT_SEND_ORDER:
				System.out.println("ORDER RECIEVED");
				System.out.println(message.getContent());
				try {
					client.sendToClient("Order Recieved");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				break;

			}
		}
		System.out.println("Message received: " + msg + " from " + client);
		int flag;
		if (msg instanceof String) {
			String message = (String) msg;
			String[] arr = message.split("\\s"); // first word in the string serves the switch case

			switch (arr[0]) {
			case "ClientDisconnect":
				disconnect(client);// go to the method that prints the disconnecton
				break;
			}

		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port " + getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server stops
	 * listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}

	// Class methods ***************************************************

	/**
	 * This method is responsible for the creation of the server instance (there is
	 * no UI in this phase).
	 *
	 * @param args[0] The port number to listen on. Defaults to 5555 if no argument
	 *                is entered.
	 */
	public static void main(String[] args) // change main name to db??
	{
		int port = 0; // Port to listen on

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}

		EchoServer sv = new EchoServer(port);

		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}

	@Override
	protected void clientConnected(ConnectionToClient client) {
		// System.out.println(client + " is connected");
		String clientIP = client.getInetAddress().getHostAddress();
		String clientHostName = client.getInetAddress().getHostName();
		String toServer = "ClientIP: " + clientIP + " Client Host Name: " + clientHostName + " status: connected";
		if (!clientsMap.containsKey(client)) // Check why there are duplicates
			clientsMap.put(client,
					"ClientIP: " + clientIP + " Client Host Name: " + clientHostName + " status: connected");
		System.out.println(clientsMap);
		spf.printConnection(clientsMap);
	}

	protected void disconnect(ConnectionToClient client) {
		String clientIP = client.getInetAddress().getHostAddress();
		String clientHostName = client.getInetAddress().getHostName();
		// if the client is new- add to the map. else- change it's value
		clientsMap.put(client,
				"ClientIP: " + clientIP + " Client Host Name: " + clientHostName + " status: disconnected");
		// String toServer = "ClientIP: " + clientIP + " Client Host Name: " +
		// clientHostName+ " status: connected";
		spf.printConnection(clientsMap);
	}
}
//End of EchoServer class
