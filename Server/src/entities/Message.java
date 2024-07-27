package entities;

import java.io.Serializable;

/**
 * This class represents a message between the server and the client. It
 * contains the type of the message and its content.
 * 
 * @author Daniel Feldman
 * @version 27-07-24
 */
public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Class variables *************************************************
	/**
	 * The message type, it could be to get a list of branches, or send a list of
	 * branches, etc.
	 */
	private MessageType type;

	/**
	 * The content of the message, such as ArrayLists, Order objects, etc.
	 */
	private Object content; // Change to Serializable ===12=1=21=2=12=1=1==12=1=2121=2=12=1=21=2=1=21=21=2=1=21=21=2=12=1=2

	/**
	 * The message type enumeration.
	 */
	public enum MessageType {
		/**
		 * Get a list of restaurants command.
		 */
		GET_RESTAURANTS,

		/**
		 * Send a list of restaurants command.
		 */
		SEND_RESTAURANTS,
		/**
		 * Send an order to the server
		 */
		CLIENT_SEND_ORDER
	}

	// Constructors ******************************************************
	/**
	 * Constructs a new Message with the specified type and content.
	 * 
	 * @param type    the type of the message
	 * @param content the content of the message
	 */
	public Message(MessageType type, Object content) {
		this.setType(type);
		this.setContent(content);
	}
	// Methods ***********************************************************

	/**
	 * Returns the type of the message.
	 * 
	 * @return the type of the message
	 */
	public MessageType getType() {
		return type;
	}

	/**
	 * Sets the type of the message.
	 * 
	 * @param type the new type of the message
	 */
	public void setType(MessageType type) {
		this.type = type;
	}

	/**
	 * Returns the content of the message.
	 * 
	 * @return the content of the message
	 */
	public Object getContent() {
		return content;
	}

	/**
	 * Sets the content of the message.
	 * 
	 * @param content the new content of the message
	 */
	public void setContent(Object content) {
		this.content = content;
	}
}