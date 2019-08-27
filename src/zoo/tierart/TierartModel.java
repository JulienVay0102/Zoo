package zoo.tierart;

public class TierartModel {
	
	private String gattung;
	private int anzahl;
	private String lebensraum;
	private float groesse;
	private String nahrung;
	
	public TierartModel(String gattung, int anzahl, String lebensraum, float groesse, String nahrung) {
		super();
		this.gattung = gattung;
		this.anzahl = anzahl;
		this.lebensraum = lebensraum;
		this.groesse = groesse;
		this.nahrung = nahrung;
	}
	
	
	
	
	public String toStringForPopUp() {
		return "Gattung:    " 			+ gattung 		+ "\n"	+
				"Anzahl:    " 			+ anzahl 		+ "\n"	+
				"Lebensraum: " 		+ lebensraum 	+ "\n"	+
				"Größe:     "				+ groesse 		+ "\n"	+
				"Nahrung:   " 			+ nahrung;
	}
	
	@Override
	public String toString() {
		return gattung;
	}



	public TierartModel() {
		// TODO Auto-generated constructor stub
	}
	public String getGattung() {
		return gattung;
	}
	public void setGattung(String gattung) {
		this.gattung = gattung;
	}
	public int getAnzahl() {
		return anzahl;
	}
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	public String getLebensraum() {
		return lebensraum;
	}
	public void setLebensraum(String lebensraum) {
		this.lebensraum = lebensraum;
	}
	public float getGroesse() {
		return groesse;
	}
	public void setGroesse(float groesse) {
		this.groesse = groesse;
	}
	public String getNahrung() {
		return nahrung;
	}
	public void setNahrung(String nahrung) {
		this.nahrung = nahrung;
	}
}
