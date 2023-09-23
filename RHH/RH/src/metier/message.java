package metier;

public class message {
	private int idM;
      private int idR;
      private int idE;
      private String nom;
      private String prenom;
      private String sujet;
      private String email;
      private String dateE;
      private String objet;
	public message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public message(int idM, int idR, int idE, String nom, String prenom, String sujet, String email, String dateE,
			String objet) {
		super();
		this.idM = idM;
		this.idR = idR;
		this.idE = idE;
		this.nom = nom;
		this.prenom = prenom;
		this.sujet = sujet;
		this.email = email;
		this.dateE = dateE;
		this.objet = objet;
	}
	public int getIdM() {
		return idM;
	}
	public void setIdM(int idM) {
		this.idM = idM;
	}
	public int getIdR() {
		return idR;
	}
	public void setIdR(int idR) {
		this.idR = idR;
	}
	public int getIdE() {
		return idE;
	}
	public void setIdE(int idE) {
		this.idE = idE;
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
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateE() {
		return dateE;
	}
	public void setDateE(String dateE) {
		this.dateE = dateE;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	@Override
	public String toString() {
		return "message [idM=" + idM + ", idR=" + idR + ", idE=" + idE + ", nom=" + nom + ", prenom=" + prenom
				+ ", sujet=" + sujet + ", email=" + email + ", dateE=" + dateE + ", objet=" + objet + "]";
	}
	
	
      
}
