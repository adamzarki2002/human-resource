package metier;

import java.sql.Date;

public class emploi {
private int id_P;
private String nom_P;
private String nom_Pk;
private String prenom_Pk;
private Date date;
public emploi() {
	super();
	// TODO Auto-generated constructor stub
}
public emploi(int id_P, String nom_P, String nom_Pk, String prenom_Pk, Date date) {
	super();
	this.id_P = id_P;
	this.nom_P = nom_P;
	this.nom_Pk = nom_Pk;
	this.prenom_Pk = prenom_Pk;
	this.date = date;
}
public int getId_P() {
	return id_P;
}
public void setId_P(int id_P) {
	this.id_P = id_P;
}
public String getNom_P() {
	return nom_P;
}
public void setNom_P(String nom_P) {
	this.nom_P = nom_P;
}
public String getNom_Pk() {
	return nom_Pk;
}
public void setNom_Pk(String nom_Pk) {
	this.nom_Pk = nom_Pk;
}
public String getPrenom_Pk() {
	return prenom_Pk;
}
public void setPrenom_Pk(String prenom_Pk) {
	this.prenom_Pk = prenom_Pk;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
@Override
public String toString() {
	return "emploi [id_P=" + id_P + ", nom_P=" + nom_P + ", nom_Pk=" + nom_Pk + ", prenom_Pk=" + prenom_Pk + ", date="
			+ date + "]";
}


}
