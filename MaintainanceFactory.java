package AirBNB;

public class MaintainanceFactory {
	public static Maintainance getMaintainanceFactory(int type)
	{
		switch(type)
		{
		case 1: return new HouseCleaning();
		case 2: return new Gardening();
		default : return new HouseCleaning();
		}
	}
}
