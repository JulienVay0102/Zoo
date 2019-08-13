package zoo.tier;
import zoo.map.PflegerModel;
import zoo.tierart.*;

public class TierModel {
	public TierModel() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String name;
	private int height;
	private int alter;
	private char gender;
	private String date;
	private TierartModel tierart;
	private PflegerModel pfleger;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
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
	

}
