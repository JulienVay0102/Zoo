package zoo.tier;
import zoo.pfleger.PflegerModel;
import zoo.tierart.*;

public class TierModel {
	public TierModel() {
		// TODO Auto-generated constructor stub
	}
	private int tierID;
	private String name;
	private int height;
	private int alter;
	private String gender;
	private String date;
	private TierartModel tierart;
	private PflegerModel pfleger;
	
	public TierModel(int tierID, String name, int height, int alter, String gender, String date, TierartModel tierart,
			PflegerModel pfleger) {
		super();
		this.tierID = tierID;
		this.name = name;
		this.height = height;
		this.alter = alter;
		this.gender = gender;
		this.date = date;
		this.tierart = tierart;
		this.pfleger = pfleger;
	}
	public int getTierID() {
		return tierID;
	}
	public void setTierID(int id) {
		this.tierID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public TierartModel getTierart() {
		return tierart;
	}
	public void setTierart(TierartModel tierart) {
		this.tierart = tierart;
	}
	public PflegerModel getPfleger() {
		return pfleger;
	}
	public void setPfleger(PflegerModel pfleger) {
		this.pfleger = pfleger;
	}
	
	
	@Override
	public String toString() {
		return "TierModel [tierID=" + tierID + ", name=" + name + ", height=" + height + ", alter=" + alter
				+ ", gender=" + gender + ", date=" + date + ", tierart=" + tierart + ", pfleger=" + pfleger + "]";
	}
	
	

}
