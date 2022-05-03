 package AirBNB;

import java.util.Date;

public class MaintainanceOrder {
	private int orderId;
	private int propertyId;
	private int userId;
	private int cost;
	private Maintainance type;
	private Date bookingDate;
	private boolean status;
	
MaintainanceOrder(int orderId,int propertyId,int userId,int cost,Maintainance type,Date date)
	{
		this.userId=userId;
		this.propertyId = propertyId;
		this.userId = userId;
		this.cost=cost;
		this.type=type;
		this.bookingDate=date;
		this.status=false;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Maintainance getType() {
		return type;
	}
	public void setType(Maintainance type) {
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
