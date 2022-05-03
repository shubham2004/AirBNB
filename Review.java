package AirBNB;

public class Review {
	int reviewId;
	int userId;
	int propertyId;
	String comment;
	int rating;
	Review(int reviewId,int userId,int propertyId,String comment,int rating)
	{
		this.reviewId=reviewId;
		this.userId=userId;
		this.propertyId=propertyId;
		this.comment = comment;
		this.rating = rating;
	}
}
