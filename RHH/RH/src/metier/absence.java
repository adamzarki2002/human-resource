package metier;

import java.sql.Date;

public class absence {
	private String natureA;
	private String dateA;
	private int id_Ab;
	private int idA;
	private int nbreA;
	private String nom;
	private String prenom;
	public absence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public absence(String natureA, String dateA, int id_Ab, int idA, int nbreA, String nom, String prenom) {
		super();
		this.natureA = natureA;
		this.dateA = dateA;
		this.id_Ab = id_Ab;
		this.idA = idA;
		this.nbreA = nbreA;
		this.nom = nom;
		this.prenom = prenom;
	}
	public String getNatureA() {
		return natureA;
	}
	public void setNatureA(String natureA) {
		this.natureA = natureA;
	}
	public String getDateA() {
		return dateA;
	}
	public void setDateA(String dateA) {
		this.dateA = dateA;
	}
	public int getId_Ab() {
		return id_Ab;
	}
	public void setId_Ab(int id_Ab) {
		this.id_Ab = id_Ab;
	}
	public int getIdA() {
		return idA;
	}
	public void setIdA(int idA) {
		this.idA = idA;
	}
	public int getNbreA() {
		return nbreA;
	}
	public void setNbreA(int nbreA) {
		this.nbreA = nbreA;
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
		return "absence [natureA=" + natureA + ", dateA=" + dateA + ", id_Ab=" + id_Ab + ", idA=" + idA + ", nbreA="
				+ nbreA + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}