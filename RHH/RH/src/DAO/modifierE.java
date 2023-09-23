package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.*;
import metier.absence;
import metier.emploi;
import metier.employé;
import metier.message;
import metier.retard;


public class modifierE {
	////////////////////////////////employe//////////////////////////////////////////////////////
	public void modifierEmploye(employé em) {
		Connection connection= SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("update personne \r\n"
					+ "set  nom=? , prenom=?, email=? ,salaire=? , mdp=? ,adresse=?  ,  numtel=? \r\n"
					+ "where id=? ;");
			/*
			 * PreparedStatement ps2 = connection.prepareStatement("update personne \r\n" +
			 * "set  nomP_P=? \r\n" + "where id_P=? ;");
			 */
			ps.setString(1, em.getNom());
			ps.setString(2, em.getPrenom());
			ps.setString(3, em.getEmail());
			ps.setString(4, em.getSalaire());	

			ps.setString(5, em.getMdp());
			ps.setString(6, em.getAdresse());
			ps.setString(7, em.getNumtel());

//			ps.setPhoto(7, em.getPhoto());
			ps.setInt(8, em.getId());
			System.out.println("VALIDE");
			/*
			 * ps2.setString(1, eme.getNom_P()); ps2.setInt(2, em.getId());
			 */
			ps.executeUpdate();
			ps.close();
			/*
			 * ps2.executeUpdate(); ps2.close();
			 */
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}
	public void modifierEmployee(emploi eme) {
		Connection connection= SingletonConnection.getConnection();
		try {

			PreparedStatement ps2 = connection.prepareStatement("update emploi_du_temps \r\n"
					+ "set  nomP_P=? \r\n"
					+ "where id_P=? ;");

            ps2.setString(1, eme.getNom_P());
            ps2.setInt(2, eme.getId_P());
			ps2.executeUpdate();
			ps2.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}

	public static employé cherEmploye(int id) {
		employé em = new employé();
		emploi eme = new emploi();
		absence emee=new absence();
		Connection connection= SingletonConnection.getConnection();
		try {
			
			PreparedStatement ps = connection.prepareStatement(" select * from personne where id=? ");
			ps.setInt(1,id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
			em.setId(rs.getInt("id"));
				em.setNom(rs.getString("nom"));
				em.setPrenom(rs.getString("prenom"));
				em.setEmail(rs.getString("email"));
				em.setNumtel(rs.getString("numtel"));
				em.setSalaire(rs.getString("salaire"));
				em.setMdp( rs.getString("mdp"));
				em.setAdresse(rs.getString("adresse"));
//				em.setPhoto(rs.getString("photo"));


				System.out.println(em +" "+ eme);
			}
			
			ps.close();
		
		

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return em;
	}
	public emploi cherEmploye1(int id_P) {
		emploi eme = new emploi();
		Connection connection= SingletonConnection.getConnection();
		try {
			
			PreparedStatement ps = connection.prepareStatement(" select * from emploi_du_temps where id_P=? ");
			ps.setInt(1,id_P);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				eme = new emploi();
				
				eme.setDate(rs.getDate("date"));
				eme.setId_P(rs.getInt("id_P"));
				eme.setNom_P(rs.getString("nomP_P"));
			}
			System.out.println(eme);
			ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eme;
	}
	public void supprimerEmploye(int id) {
		Connection connection= SingletonConnection.getConnection();

		try {
			PreparedStatement ps2 = connection.prepareStatement("delete  from emploi_du_temps where  id_P=? ; ");
			ps2.setInt(1, id);
			PreparedStatement ps = connection.prepareStatement("delete  from personne where  id=? ; ");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps2.executeUpdate();
			ps2.close();
             ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}
	public void supprimerP(int id) {
		Connection connection= SingletonConnection.getConnection();

		try {
			PreparedStatement ps2 = connection.prepareStatement("delete  from emploi_du_temps where  id_P=? ; ");
			ps2.setInt(1, id);
			ps2.executeUpdate();
			ps2.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}
	
	/////////////////////////////////absence//////////////////////////////////////////////////////////////////////
	public static absence cherEmploye2(int idA) {
		List<absence> absence = new ArrayList<absence>();
		System.out.println(1222);
		absence eme = new absence();
		System.out.println(1223);
		Connection connection= SingletonConnection.getConnection();
		try {
			System.out.println(1224);
			PreparedStatement ps = connection.prepareStatement(" select * from absence where idA=?");
			ps.setInt(1,idA);
			ResultSet rs = ps.executeQuery();

				if(rs.next()) {
					System.out.println(1222);
				eme.setDateA(rs.getString("dateA"));
				eme.setId_Ab(rs.getInt("id_Ab"));
				eme.setIdA(rs.getInt("idA"));
				eme.setNatureA(rs.getString("natureA"));
				System.out.println(12);
				System.out.println(eme);
				
			}
			
			
			
			ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eme;
	}
	public void modifierAbsence(absence eme) {
		Connection connection= SingletonConnection.getConnection();
		try {
//			PreparedStatement ps = connection.prepareStatement("update personne \r\n"
//					+ "set  nom=? , prenom=?" + "where id=? ;");
			PreparedStatement ps2 = connection.prepareStatement("update absence \r\n"
					+ "set dateA=?,natureA=? \r\n"
					+ "where idA=? ;");
//			ps.setString(1, em.getNom());
//			ps.setString(2, em.getPrenom());
//            ps2.setInt(1, eme.getId_Ab());
            ps2.setString(1, eme.getDateA());
            ps2.setString(2, eme.getNatureA());
            ps2.setInt(3, eme.getIdA());

			ps2.executeUpdate();
			ps2.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}
	public void supprimerAbsence(int idA) {
		Connection connection= SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("delete  from absence where  idA=? ; ");
			ps.setInt(1, idA);
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}
	//////////////////////////////////////////retard///////////////////////////////////////////////////
	public static retard cherEmploye3(int idR) {
		List<retard> retard = new ArrayList<retard>();
		System.out.println(1222);
		retard eme = new retard();
		System.out.println(1223);
		Connection connection= SingletonConnection.getConnection();
		try {
			System.out.println(1224);
			PreparedStatement ps = connection.prepareStatement(" select * from retard where idR=?");
			ps.setInt(1,idR);
			ResultSet rs = ps.executeQuery();

				if(rs.next()) {
					System.out.println(1222);
				eme.setDateR(rs.getString("dateR"));
				eme.setId_Re(rs.getInt("id_Re"));
				eme.setIdR(rs.getInt("idR"));
				eme.setNatureR(rs.getString("natureR"));
				System.out.println(12);
				System.out.println(eme);
				
			}
			
			
			
			ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eme;
	}
	public void modifierRetard(retard eme) {
		Connection connection= SingletonConnection.getConnection();
		try {
//			PreparedStatement ps = connection.prepareStatement("update personne \r\n"
//					+ "set  nom=? , prenom=?" + "where id=? ;");
			PreparedStatement ps2 = connection.prepareStatement("update retard \r\n"
					+ "set dateR=?,natureR=? \r\n"
					+ "where idR=? ;");
//			ps.setString(1, em.getNom());
//			ps.setString(2, em.getPrenom());
//            ps2.setInt(1, eme.getId_Ab());
            ps2.setString(1, eme.getDateR());
            ps2.setString(2, eme.getNatureR());
            ps2.setInt(3, eme.getIdR());

			ps2.executeUpdate();
			ps2.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}
	public void supprimerRetard(int idR) {
		Connection connection= SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("delete  from retard where  idR=? ; ");
			ps.setInt(1, idR);
			ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

	}
	////////////////////////////////////////affichage////////////////////////////////////////////////////
	public static employé cherEmploye4(String email) {
		List<employé> ro = new ArrayList<employé>();
		System.out.println(1222);
		employé eme = new employé();
		System.out.println(1223);
		Connection connection= SingletonConnection.getConnection();
		try {
			System.out.println(1224);
			PreparedStatement ps = connection.prepareStatement(" select * from personne where email=?");
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();

				if(rs.next()) {
					System.out.println(1222);
				eme.setNom(rs.getString("nom"));
				eme.setPrenom(rs.getString("prenom"));
				eme.setEmail(rs.getString("email"));
				eme.setMdp(rs.getString("mdp"));
				System.out.println(12);
				System.out.println(eme);
				
			}
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eme;
	}
///////////////////////////////affiche profile///////////////////////////////////////////////////////
	public static employé chercherP(int id) {
		employé em = new employé();


		Connection connection= SingletonConnection.getConnection();
		try {
			
			PreparedStatement ps = connection.prepareStatement(" select * from personne where id=? ");
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				em.setId(rs.getInt("id"));
				em.setNom(rs.getString("nom"));
				em.setPrenom(rs.getString("prenom"));
				em.setEmail(rs.getString("email"));
				em.setNumtel(rs.getString("numtel"));
				em.setSalaire(rs.getString("salaire"));
				em.setMdp( rs.getString("mdp"));
				em.setAdresse(rs.getString("adresse"));
//				em.setPhoto(rs.getString("photo"));

				System.out.println(em);
			}
			
			ps.close();
	

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return em;
	}
	public emploi chercherPP(int id_P) {
		emploi eme = new emploi();
		Connection connection= SingletonConnection.getConnection();
		try {
			
			PreparedStatement ps = connection.prepareStatement(" select * from emploi_du_temps where id_P=? ");
			ps.setInt(1,id_P);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				eme = new emploi();
				
				eme.setDate(rs.getDate("date"));
				eme.setId_P(rs.getInt("id_P"));
				eme.setNom_P(rs.getString("nomP_P"));
			}
			System.out.println(eme);
			ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eme;
	}
	public message cherMessage(int id_Me) {
		message eme = new message();
		Connection connection= SingletonConnection.getConnection();
		try {
			
			PreparedStatement ps = connection.prepareStatement(" select * from messagee where idMe=? ");
			ps.setInt(1,id_Me);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				eme = new message();
				eme.setSujet(rs.getString("contenu"));
				eme.setIdM(rs.getInt("idMe"));
				eme.setObjet(rs.getString("objet"));
				eme.setDateE(rs.getString("dateE"));
			}
			System.out.println(eme);
			ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eme;
	}
}

