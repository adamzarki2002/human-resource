package metier;

public class poste {
      private String nomP;
      private int nbrP;
      
	public poste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public poste(String nomP, int nbrP) {
		super();
		this.nomP = nomP;
		this.nbrP = nbrP;
	}

	public String getNomP() {
		return nomP;
	}

	public void setNomP(String nomP) {
		this.nomP = nomP;
	}

	public int getNbrP() {
		return nbrP;
	}

	public void setNbrP(int nbrP) {
		this.nbrP = nbrP;
	}

	@Override
	public String toString() {
		return "poste [nomP=" + nomP + ", nbrP=" + nbrP + "]";
	}
	
      
}
