package DAO;

import metier.absence;
import metier.emploi;
import metier.employ�;

public class testSingleton {

	public static void main(String[] args) {
		employ� a=new employ�();
		emploi b=new emploi();
		int c = 1 ;
		int id_Ab=2;
		String email="aymane@gmail.com";
		String password="2002";
		SingletonConnection.getConnection();
//		modifierE.cherEmploye4( email);
		//		listeEmpl.listeEmployes();
//		ajouterEmp.getNbreAbsences(c);
//		listeEmpl.listeAbsence1(id_Ab);
//		DaoLogin.getUser( email , password);
//		listeEmpl.listeEmplemail();
//		listeEmpl.getEmail();
		emploidutemps.tableauAC();
	}

}
