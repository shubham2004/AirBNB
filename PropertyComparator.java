package AirBNB;

import java.util.ArrayList;
import java.util.Comparator;

public class PropertyComparator implements Comparator<Property> {

	@Override
	public int compare(Property p1, Property p2) {
		// TODO Auto-generated method stub
		double avgRatingOfProperty1 = 0;
		double avgRatingOfProperty2 = 0;
		ArrayList<Review> rlp1 = p1.getReviewList();
		ArrayList<Review> rlp2 = p2.getReviewList();
		for(int i=0;i<rlp1.size();i++){
			avgRatingOfProperty1+=rlp1.get(i).rating;
		}
		for(int i=0;i<rlp2.size();i++){
			avgRatingOfProperty2+=rlp2.get(i).rating;
		}
		if(avgRatingOfProperty1<avgRatingOfProperty2)
			return 1;
		return -1;
	}
	
}
