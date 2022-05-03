package AirBNB;

import java.util.ArrayList;

public class PropertyService {
	
	private static PropertyService instance = null;
	private PropertyService() {};
	public static PropertyService getInstance()
	{
		if(instance == null)
		{
			instance = new PropertyService();
		}
		return instance;
	}
	
	UserDao userDao = UserDao.getInstance();
	public Property registerProperty(String name,String address,int price,int type)
	{
		return userDao.registerProperty(name,address,price,type);
	}
	
	public Review rateProperty(int propertyId,String comment,int rating)
	{
		return	userDao.setReview(  propertyId, comment, rating);
	
	}
	
	public ArrayList<Property> getSortedProperty()
	{
		return userDao.getSortedProperty();
	}
}
