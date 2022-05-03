package AirBNB;

public class RentOrderService {
	private static  RentOrderService instance = null;
	private RentOrderService() {};
	public static RentOrderService getInstance()
	{
		if(instance==null)
			instance=new RentOrderService();
		return instance;
	}
	UserDao userDao = UserDao.getInstance();
	public Order rentProperty(int id,int days)
	{
		userDao.rentProperty(id,days);
		return userDao.createOrder(id,days);
	}
}
