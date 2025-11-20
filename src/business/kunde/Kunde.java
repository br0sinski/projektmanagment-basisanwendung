package business.kunde;

public class Kunde {
	
	private int hausnummer;
	private String vorname;
	private String nachname;
	private String telefonnummer;
	private String email;
	private boolean dachgeschoss;//geändert
	
	
	//geaddet: 
	public Kunde() {}

	public Kunde(int hausnummer, String vorname, String nachname, String telefonnummer, String email, boolean dachgeschoss) {
		this.hausnummer = hausnummer;
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefonnummer = telefonnummer;
		this.email = email;
		this.dachgeschoss = dachgeschoss;
	}
	public int getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isDachgeschoss() {
		return dachgeschoss;
	}

	public void setDachgeschoss(boolean dachgeschoss) {
		this.dachgeschoss = dachgeschoss;
	}
	
}
