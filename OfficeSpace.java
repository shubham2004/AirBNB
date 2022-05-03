package AirBNB;

import java.util.ArrayList;
import java.util.Date;

public class OfficeSpace implements Property{
	private int propertyId;
	private String name;
	private String address;
	private int price;
	private Date availableBy;
	private ArrayList<Review> reviewList;
	OfficeSpace(int propertyId,String name,int price,Date availableBy)
	{
		this.price=price;
		this.propertyId=propertyId;
		this.name=name;
		this.availableBy=availableBy;
		this.reviewList=new ArrayList<>();
	}
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getAvailableBy() {
		return availableBy;
	}
	public void setAvailableBy(Date availableBy) {
		this.availableBy = availableBy;
	}
	public ArrayList<Review> getReviewList() {
		return reviewList;
	}
	public void setReviewList(ArrayList<Review> reviewList) {
		this.reviewList = reviewList;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
