package AirBNB;

public class HouseCleaning implements Maintainance{
	private int type;
	private int cost;
	private boolean status;
	private String name; 
	HouseCleaning()
	{
		type=2;
		cost=500;
		status = false;
		name = "House Cleaning";
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
