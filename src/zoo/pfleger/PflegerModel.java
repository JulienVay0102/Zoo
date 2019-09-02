package zoo.pfleger;

/**
 * Modelclass for Pfleger
 * @author mstuebing
 *
 */

public class PflegerModel {

	private int pflegerID;
	private String vname;
	private String nname;

	public PflegerModel(int pflegerID, String vname, String nname) {
		super();
		this.pflegerID = pflegerID;
		this.vname = vname;
		this.nname = nname;
	}

	public PflegerModel() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Following a list of this classes getter and setter.
	 * @return
	 */
	
	public int getPflegerID() {
		return pflegerID;
	}

	public void setPflegerID(int pflegerID) {
		this.pflegerID = pflegerID;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}
	
	@Override
	public String toString() {
		return vname + " " + nname ;
	}

}
