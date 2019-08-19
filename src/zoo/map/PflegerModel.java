package zoo.map;

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

}
