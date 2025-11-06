package business.kunde;

public class Kunde {

	private int idKunde;

	private int hausnummer;
	private String vorname;
	private String nachname;
	private String telefonnummer;
	private String email;

	
	public int getIdKunde() {
		return idKunde;
	}

	public void setIdKunde(int idKunde) {
		this.idKunde = idKunde;
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

}
