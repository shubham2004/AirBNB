package AirBNB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class UserDao {
	private static UserDao instance=null;
	private UserDao() {};
	public static UserDao getInstance()
	{
		if(instance==null)
		{
			instance = new UserDao();
		}
		return instance;
	}
	
	private User logedinUser = null;
	private HashMap<Integer,User> userMap = new HashMap<>(); 		// id,user
	private HashMap<Long,Integer>  phoneMap  = new HashMap<>(); 	// phone,id
	private HashMap<Integer,Property> propertyMap = new HashMap<>();    //id,property
	private HashMap<Integer,MaintainanceOrder> maintainanceOrderMap = new HashMap<>(); //id,maintainanceOrder
	private HashMap<Integer,Order> orderMap = new HashMap<>();    //id,map
	
///////////   user   //////////////
	// login user
	public User loginUser(Long phone)
	{
		if(!phoneMap.containsKey(phone))
		{
			System.out.println("No user registered with phone "+phone);
			return null;
		}
		User user = userMap.get(phoneMap.get(phone));
		logedinUser = user;
		System.out.println("Successfully Logedin "+user.getName());
		return user;
	}
	
/////// register user	////////////////
	public User registerUser(String name,Long phoneNo)
	{
		if(phoneMap.containsKey(phoneNo))
		{
			System.out.println("User is already registered");
			return  null;
		}
		int id = IdGenerator.generateId();
		User user = new User (id,name,phoneNo);
		phoneMap.put(phoneNo, id);
		userMap.put(id, user);
		System.out.println("New User registered");
		return user;
	}
	
//////////    property    /////////////////////
	public Property registerProperty(String name, String address, int price,int type)
	{
		Property property = PropertyFactory.getProperty(name,address,price,new Date(),type);
		propertyMap.put(property.getPropertyId(), property);
		System.out.println("Property has been registered successfully with Property ID "+ property.getPropertyId()+" and "+property.getClass());
		return property;
	}
	
/////////	 review		//////////////////////
	public Review setReview(int propertyId,String comment,int rating)
	{
		if(!propertyMap.containsKey(propertyId))
		{
			System.out.println("No property found");
			return null;
		}
		if(rating<0 || rating >5)
		{
			System.out.println("Invalid rating entered, please enter number between 0 ~ 5");
		}
		Review review = new Review(IdGenerator.generateId(),logedinUser.getUserid(), propertyId, comment, rating);
		propertyMap.get(propertyId).getReviewList().add(review);
		System.out.println(logedinUser.getName()+"'s review has been successfully added for "+ propertyMap.get(propertyId).getName());
		return review;
	}
	
////////	get property list //////////////
	public ArrayList<Property> getSortedProperty() {
		ArrayList<Property> propertyList = new ArrayList<>();
		for(Entry<Integer, Property> entry : propertyMap.entrySet())
		{
			if(entry.getValue().getAvailableBy().compareTo(new Date())<=0)
				propertyList.add(entry.getValue());
		}
		Collections.sort(propertyList,new PropertyComparator());
		return propertyList;
	}
	
///////	rent property	//////////////////
	public void rentProperty(int propertyId,int days)
	{
		if(propertyMap.get(propertyId).getAvailableBy().compareTo(new Date())>0)
		{
			System.out.println("Property is not available currently for renting");
			return;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(propertyMap.get(propertyId).getAvailableBy());
		cal.add(Calendar.MONTH, 2);
		System.out.println(propertyMap.get(propertyId).getName()+" has been successfully rented to "+logedinUser.getName());
		propertyMap.get(propertyId).setAvailableBy(cal.getTime());
		
	}
	
//////	creating rent order	/////////////
	public Order createOrder(int propertyId,int days)
	{
		if(!propertyMap.containsKey(propertyId))
		{
			System.out.println("no property found");
			return null;
		}
		if(days<=0)
		{
			System.out.println("invalid booking months entered");
			return null;
		}
		int id = IdGenerator.generateId();
		Order order=new Order(id,logedinUser.getUserid(),propertyId,propertyMap.get(propertyId).getPrice()*days,0,days);
		orderMap.put(id,order);
		System.out.println(logedinUser.getName()+" your rent order for "+propertyMap.get(propertyId).getName()+" has been confirmed");
		return order;
	}

/////	creating mintainance order	/////////////
	public MaintainanceOrder createOrder(int propertyId,int type,Date requestedDate)
	{
		if(!propertyMap.containsKey(propertyId))
		{
			System.out.println("No property found");
			return null;
		}
		if(requestedDate.compareTo(new Date())<0)
		{
			System.out.println("Invalid date entered");
			return null;
		}
		int orderId=IdGenerator.generateId();
		Maintainance maintainance = MaintainanceFactory.getMaintainanceFactory(type);
		MaintainanceOrder maintainanceOrder = new MaintainanceOrder(orderId, propertyId, logedinUser.getUserid(),maintainance.getCost(),maintainance,requestedDate);
		maintainanceOrderMap.put(orderId, maintainanceOrder);
		System.out.println(logedinUser.getName()+" your maintainance order of "+ maintainance.getName()+" for "+propertyMap.get(propertyId).getName()+" has been confirmed");
		return maintainanceOrder;
	}
	
	public ArrayList<MaintainanceOrder> getPendingOrderList()
	{
		ArrayList<MaintainanceOrder> orderList = new ArrayList<>();
		for(Entry<Integer,MaintainanceOrder> entry : maintainanceOrderMap.entrySet())
		{
			if(entry.getValue().getStatus()==false)
				orderList.add(entry.getValue());
		}
		return orderList;
	}
	
}
