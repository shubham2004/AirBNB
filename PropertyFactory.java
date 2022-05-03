package AirBNB;

import java.util.Date;

public class PropertyFactory {
	public static Property getProperty(String name,String address,int price,Date availableBy,int type)
	{
		int id=IdGenerator.generateId();
		switch(type)
		{
		case 1 : 
			return new House(id,name,price,availableBy);
		case 2 : 
			return new OfficeSpace(id,name,price,availableBy);
		case 3: 
			return new EventSpace(id,name,price,availableBy);
		default :
			return null;
		}
		
	}
}
