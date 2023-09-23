package metier;

public class retard {
	private String natureR;
	private String dateR;
	private int id_Re;
	private int idR;
	private int nbreR;
	private String nom;
	private String prenom;
	public retard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public retard(String natureR, String dateR, int id_Re, int idR, int nbreR, String nom, String prenom) {
		super();
		this.natureR = natureR;
		this.dateR = dateR;
		this.id_Re = id_Re;
		this.idR = idR;
		this.nbreR = nbreR;
		this.nom = nom;
		this.prenom = prenom;
	}
	public String getNatureR() {
		return natureR;
	}
	public void setNatureR(String natureR) {
		this.natureR = natureR;
	}
	public String getDateR() {
		return dateR;
	}
	public void setDateR(String dateR) {
		this.dateR = dateR;
	}
	public int getId_Re() {
		return id_Re;
	}
	public void setId_Re(int id_Re) {
		this.id_Re = id_Re;
	}
	public int getIdR() {
		return idR;
	}
	public void setIdR(int idR) {
		this.idR = idR;
	}
	public int getNbreR() {
		return nbreR;
	}
	public void setNbreR(int nbreR) {
		this.nbreR = nbreR;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "retard [natureR=" + natureR + ", dateR=" + dateR + ", id_Re=" + id_Re + ", idR=" + idR + ", nbreR="
				+ nbreR + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
	
}