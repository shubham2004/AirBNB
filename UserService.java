package AirBNB;

public class UserService {
	private static UserService instance=null;
	private UserService(){};
	
	// get instance funtion
	UserDao userDao = UserDao.getInstance();
	public static UserService getInstance()
	{
		if(instance==null)
		{
			instance = new UserService();
		}
		return instance;
	}
	public User registerUser(String name,Long phoneNo)
	{
		return userDao.registerUser(name,phoneNo);
	}
	public User loginUser(Long phoneNo)
	{
		return userDao.loginUser(phoneNo);
	}
}
