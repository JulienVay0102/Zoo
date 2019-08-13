package zoo.tierart;

import java.util.ArrayList;

public class Test {
	
	public static void main (String[] args) {
		
		TierartModel tierart;
		
		ArrayList<TierartModel> tierartList = new ArrayList<TierartModel>();
		
		TierartDao tierartDao = new TierartDao();
		
		tierart = tierartDao.getTierart("Orang Utan");
		
		System.out.println(tierart.getGattung());
		
		tierartList = tierartDao.getAllTierart();
		
		for (int i = 0; i<tierartList.size(); i++) {
			System.out.println(tierartList.get(i).getGattung());
		}
	
		
	}

}
