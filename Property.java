package AirBNB;

import java.util.ArrayList;
import java.util.Date;

public interface Property {
	
	public int getPropertyId();
	public void setPropertyId(int propertyId) ;
	public int getPrice() ;
	public void setPrice(int price) ;
	public String getName();
	public void setName(String name);
	public Date getAvailableBy();
	public void setAvailableBy(Date availableBy);
	public ArrayList<Review> getReviewList() ;
	public void setReviewList(ArrayList<Review> reviewList) ;
	public String getAddress();
	public void setAddress(String address);
}
