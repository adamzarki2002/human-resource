package metier;

import java.io.InputStream;

public class employé {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private String salaire;
	private String numtel;
	private InputStream photo;
	private String role;
	private String adresse;
	private String nomP;
	public employé() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employé(int id, String nom, String prenom, String email, String mdp, String salaire, String numtel,
			InputStream photo, String role, String adresse, String nomP) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.salaire = salaire;
		this.numtel = numtel;
		this.photo = photo;
		this.role = role;
		this.adresse = adresse;
		this.nomP = nomP;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getSalaire() {
		return salaire;
	}
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	public String getNumtel() {
		return numtel;
	}
	public void setNumtel(String numtel) {
		this.numtel = numtel;
	}
	public InputStream getPhoto() {
		return photo;
	}
	public void setPhoto(InputStream photo) {
		this.photo = photo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNomP() {
		return nomP;
	}
	public void setNomP(String nomP) {
		this.nomP = nomP;
	}
	@Override
	public String toString() {
		return "employé [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", mdp=" + mdp
				+ ", salaire=" + salaire + ", numtel=" + numtel + ", photo=" + photo + ", role=" + role + ", adresse="
				+ adresse + ", nomP=" + nomP + "]";
	}
	


	




}