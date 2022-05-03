package AirBNB;

public class Order {
	private int orderId;
	private int userId;
	private int propertyId;
	private int cost;
	private int duration;
	private int timeStamp;
	
	Order(int orderId,int userId,int propertyId,int cost,int duration,int timeStamp)
	{
		this.orderId=orderId;
		this.userId=userId;
		this.propertyId=propertyId;
		this.cost=cost;
		this.duration=duration;
		this.timeStamp=timeStamp;
		
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
