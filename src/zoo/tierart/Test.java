package zoo.tierart;

import java.util.ArrayList;

import zoo.pfleger.PflegerModel;
import zoo.tier.TierDAO;

public class Test {
	
	public static void main (String[] args) {
		
	
	ArrayList<TierartModel> tierartModelList = new ArrayList<TierartModel>();
	TierartDao.deleteTierart("Elefant");
	tierartModelList = TierartDao.getAllTierart();
	
	for (TierartModel t : tierartModelList) {
		System.out.println(t);
	}
	
	
	}

}
