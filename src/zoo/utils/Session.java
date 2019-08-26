package zoo.utils;

import zoo.pfleger.PflegerModel;
import zoo.tier.TierModel;

public class Session {
	 
	  
	  private static Session session;
	  private PflegerModel pfleger;
	  private TierModel tier;
	 
	  private Session () {}
	  
	  public static Session getInstance () {
	    if (Session.session == null) {
	    	Session.session = new Session ();
	    }
	    return Session.session;
	  }

		public PflegerModel getPfleger() {
			return pfleger;
		}
	
		public void setPfleger(PflegerModel pfleger) {
			this.pfleger = pfleger;
		}
	
		public TierModel getTier() {
			return tier;
		}
	
		public void setTier(TierModel tier) {
			this.tier = tier;
		}
	  
	  
	}