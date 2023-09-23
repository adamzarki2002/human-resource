package metier;

public class Login {
      private String email;
      private String mdp;
      private String role;
      private String nom;
      private String prenom;
      private int id;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String email, String mdp, String role, String nom, String prenom, int id) {
		super();
		this.email = email;
		this.mdp = mdp;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Login [email=" + email + ", mdp=" + mdp + ", role=" + role + ", nom=" + nom + ", prenom=" + prenom
				+ ", id=" + id + "]";
	}
	
}