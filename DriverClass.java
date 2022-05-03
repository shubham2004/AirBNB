package AirBNB;

import java.util.ArrayList;
import java.util.Date;

public class DriverClass {
	public static void main(String args[])
	{
		UserService userService = UserService.getInstance();
		MaintainanceOrderService maintainService = MaintainanceOrderService.getInstance();
		PropertyService propertyService = PropertyService.getInstance();
		RentOrderService rentOrderService = RentOrderService.getInstance();
		
		User user1 = new User(IdGenerator.generateId(),"Shubham",7530004116L);
		userService.loginUser(7530004116L);
		userService.registerUser(user1.getName(), user1.getPhoneNo());
		userService.loginUser(user1.getPhoneNo());
		
		
		
		
		//creating property
		Property property1 = PropertyFactory.getProperty("Zuri", "123-ye apartment, Banglore", 1000,new Date(), 3); 
		Property property2 = PropertyFactory.getProperty("Shubsanskar", "123-ye apartment, Banglore", 1000,new Date(), 1); 
		Property property3 = PropertyFactory.getProperty("Bagmane", "123-ye apartment, Banglore", 1000,new Date(), 2); 
		
		// adding property to the system
		property1=propertyService.registerProperty(property1.getName(),property1.getAddress(),property1.getPrice(),3);
		property2=propertyService.registerProperty(property2.getName(),property2.getAddress(),property2.getPrice(),1);
		property3=propertyService.registerProperty(property3.getName(),property3.getAddress(),property3.getPrice(),2);
		
		
		ArrayList<Property> propertyList = propertyService.getSortedProperty();
		for(int i=0;i<propertyList.size();i++)
		{
			System.out.print(propertyList.get(i).getName()+" ");
		}
		System.out.println();
		// Adding Review
		Review review=propertyService.rateProperty(property3.getPropertyId(), "good", 5);
		System.out.println(property3.getReviewList().get(0).comment);
		
		//Renting property
//		Order order1 = rentOrderService.rentProperty(property1.getPropertyId(), 1);
		Order order2 = rentOrderService.rentProperty(property2.getPropertyId(), 2);
		
		//get sorted propert list by review
		ArrayList<Property> propertyList2 = propertyService.getSortedProperty();
		for(int i=0;i<propertyList2.size();i++)
		{
			System.out.print(propertyList2.get(i).getName()+" ");
		}
		System.out.println();
		
		//Adding maintainance order
		MaintainanceOrder maintainanceOrder = maintainService.createOrder(property1.getPropertyId(), 1, new Date());
		ArrayList<MaintainanceOrder> pendingMaintainanceOrderList = maintainService.getPendingOrderList();
		
		
	}
}
