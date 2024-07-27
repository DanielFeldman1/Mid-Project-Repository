package entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	enum Status {
		APPROVED, READY, FINISHED
	};

	private static int orderCounter = 1;
	private String restaurant;
	private String branch;
	private int orderNumber;
	private float finalPrice;
	private Date date;
	private Time startTime, arriveTime, wantedTime;
	private Status status;
	private ArrayList<Meal> meals = new ArrayList<>();

	public Order() {
		orderNumber = orderCounter++;
	}

//	public Order(int orderNumber, float finalPrice, Date date, Time startTime, Time arriveTime, Time wantedTime,
//			Status status) {
//		this.finalPrice = finalPrice;
//		this.date = date;
//		this.startTime = startTime;
//		this.arriveTime = arriveTime;
//		this.wantedTime = wantedTime;
//		this.status = status;
//	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

	public Date getDate() {
		return date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public Time getArriveTime() {
		return arriveTime;
	}

	public Time getWantedTime() {
		return wantedTime;
	}

	public Status getStatus() {
		return status;
	}

	// Setter methods
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public void setArriveTime(Time arriveTime) {
		this.arriveTime = arriveTime;
	}

	public void setWantedTime(Time wantedTime) {
		this.wantedTime = wantedTime;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String toString() {
		return "Order Number: " + orderNumber + "\nRestaurant: " + restaurant + "\n" + "Final Price: $" + finalPrice
				+ "\n" + "Date: " + date + "\n" + "Start Time: " + startTime + "\n" + "Arrive Time: " + arriveTime
				+ "\n" + "Wanted Time: " + wantedTime + "\n" + "Status: " + status;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

}
