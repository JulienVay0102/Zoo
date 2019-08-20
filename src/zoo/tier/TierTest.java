package zoo.tier;

public class TierTest {

	public static void main (String[] args) {
		
//		TierDAO.createTier("Testobjekt219321", 201, 1 , "m", "01.02.3213", null, null);
//		
//		System.out.println(TierDAO.getTier(1).toString());
//		TierDAO.updateTier(1, "Heinz", 11, 123, "m", "01.02.1999", null, null);
//		System.out.println(TierDAO.getTier(1).toString());
//		TierDAO.deleteTier(33);
		
		for (TierModel tier : TierDAO.getAllTier()) {
			System.out.println(tier.toString());
		}
		
		}
	
	

}
