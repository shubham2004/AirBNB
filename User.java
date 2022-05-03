package AirBNB;

public class User {
	private int UserId;
	private String name;
	private Long phoneNo;
	
	public User(int UserId,String name,Long phoneNo)
	{
		this.UserId = UserId;
		this.name = name;
		this.phoneNo = phoneNo;
	}
	public int getUserid() {
		return UserId;
	}
	public void setUserid(int userid) {
		this.UserId = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
