package zoo.tierart;

public class Test {
	
	public static void main (String[] args) {
		
		TierartModel tierart;
		
		TierartDao tierartDao = new TierartDao();
		
		tierart = tierartDao.getTierart("Orang Utan");
		
		System.out.println(tierart.getGattung());
		
		tierartDao.updateTierart("Lemur", 12, "Afrika", 1.5f, "Bananen" );

	}

}
