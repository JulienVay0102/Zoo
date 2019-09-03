package zoo.utils;

import zoo.pfleger.PflegerModel;
import zoo.tier.TierModel;
/**
 * This class is managing the communication over views. As a singleton pattern, 
 * it saves one specific object of a pfleger and a tier.
 * @author Julien, Konstantin
 *
 */
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