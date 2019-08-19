package zoo.tierart;

import java.util.ArrayList;

import zoo.map.PflegerModel;
import zoo.tier.TierDAO;

public class Test {
	
	public static void main (String[] args) {
		
		
	System.out.println(TierDAO.getTier(1).toString());
		
		TierDAO.createTier("Caesar", 190, 19, "m", "01.02.1998", null, new PflegerModel(3,"Hans", "Hansen"));
		System.out.println(TierDAO.getTier(10).toString());
	
	}

}
