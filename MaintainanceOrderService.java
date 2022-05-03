package AirBNB;

import java.util.ArrayList;
import java.util.Date;

public class MaintainanceOrderService {
	private static MaintainanceOrderService instance = null;
	private MaintainanceOrderService() {};
	
	public static MaintainanceOrderService getInstance()
	{
		if(instance==null)
			instance=new MaintainanceOrderService();
		return instance;
	}
	UserDao userDao = UserDao.getInstance();
	public MaintainanceOrder createOrder(int propertyId,int type,Date requestedDate)
	{
		return userDao.createOrder( propertyId, type,requestedDate);
	}
	
	public ArrayList<MaintainanceOrder> getPendingOrderList()
	{
		return userDao.getPendingOrderList();
	}
}
