package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.absence;
import metier.emploi;
import metier.employé;
import metier.message;
import metier.retard;
import DAO.*;


public class listeEmpl {
	static int b;
	///////////////////////////////employe//////////////////////////////////////////////
		public static List<employé> listeEmployes() {
//			List<emploi> emploi = new ArrayList<emploi>();
			List<employé> employes = new ArrayList<employé>();
			Connection connection= SingletonConnection.getConnection();
			System.out.println("5");
			
			try {
				PreparedStatement ps = connection.prepareStatement("select * from personne Where role='employe' \r\n;");
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					employé em = new employé();
//					emploi ee=new emploi();
					em.setId(rs.getInt("id"));
					System.out.println("10");
					em.setNom(rs.getString("nom"));
					System.out.println("10");
					em.setPrenom(rs.getString("prenom"));
					System.out.println("10");
					em.setEmail(rs.getString("email"));
					System.out.println("10");
					em.setMdp(rs.getString("mdp"));
					System.out.println("10");
					em.setSalaire(rs.getString("salaire"));
					System.out.println("10");
					em.setRole(rs.getString("role"));
//					em.setNomP(ee.setNom_P(rs2.getString("nomP_P")));
 				//em.setPhoto(rs.getPhoto("photo"));
					em.setNumtel(rs.getString("numtel"));
	                em.setAdresse(rs.getString("adresse"));
//					ee.setNom_P(rs2.getString("nomP_P"));
//					ee.setId_P(rs2.getInt("id_P"));
					employes.add(em);
//					emploi.add(ee);
				}
				System.out.println(employes);
				ps.close();
//				ps2.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
			
			return employes;
		}
		///////////////////////////////////absence/////////////////////////////////////////////////////////
		public List<absence> listeAbsence() {
			List<absence> absence = new ArrayList<absence>();
			List<employé> employes = new ArrayList<employé>();
			Connection connection= SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("select  id_Ab , count(id_Ab) from absence   group by id_Ab \r\n;");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					absence em=new absence();
					em.setId_Ab(rs.getInt("id_Ab"));
					em.setNbreA(rs.getInt("count(id_Ab)"));
					absence.add(em);
				}
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
			return absence;
		}
		
		public static List<absence> listeAbsence1(int id_Ab) {
			List<absence> absence = new ArrayList<absence>();
			
			Connection connection= SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("select * from absence Where id_Ab=? ;");
				ps.setInt(1, id_Ab);
				
				ResultSet rs = ps.executeQuery();
				
				absence em;
				while(rs.next()) {
					em=new absence();
					em.setId_Ab(rs.getInt("id_Ab"));
					em.setIdA(rs.getInt("idA"));
					em.setDateA(rs.getString("dateA"));
					em.setNatureA(rs.getString("natureA"));
				
					
					absence.add(em);
					
				}
				System.out.println(55);
				
				ps.close();
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}System.out.println(absence);
			return absence;					

		}
		////////////////////////////////////////////////retard////////////////////////////////////////
		public List<retard> listeRetard() {
			List<retard> retard = new ArrayList<retard>();
			List<employé> employes = new ArrayList<employé>();
			Connection connection= SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("select  id_Re , count(id_Re) from retard   group by id_Re \r\n;");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					retard em=new retard();
					em.setId_Re(rs.getInt("id_Re"));
					em.setNbreR(rs.getInt("count(id_Re)"));
					retard.add(em);
				}
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
			return retard;
		}
		
		public static List<retard> listeRetard1(int id_Re) {
			List<retard> retard = new ArrayList<retard>();
			
			Connection connection= SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("select * from retard Where id_Re=? ;");
				ps.setInt(1, id_Re);
				ResultSet rs = ps.executeQuery();

				retard em;
				
				while(rs.next()) {
					em=new retard();
					System.out.println(88);
					em.setId_Re(rs.getInt("id_Re"));
					em.setIdR(rs.getInt("idR"));
					em.setDateR(rs.getString("dateR"));
					em.setNatureR(rs.getString("natureR"));
				
					retard.add(em);
					
				}
				System.out.println(55);
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}System.out.println(retard);
			return retard;					

		}
		/////////////////////////////////getAbsence//////////////////////////////////////////////////////////
		public List<absence> getAbsence(int id) {
			List<absence> absence = new ArrayList<absence>();
			Connection connection= SingletonConnection.getConnection();
			try {
				PreparedStatement ps1=connection.prepareStatement("select natureA ,dateA from absence  where id_Ab=? \r\n;");
				ps1.setInt(1, id);
				PreparedStatement ps=connection.prepareStatement("select count(id_Ab) from absence where id_Ab=? \r\n;");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				ResultSet rs1 = ps1.executeQuery();
				if(rs.next()) {
					
				}
				while(rs1.next()) {
					absence em=new absence();
					em.setNatureA(rs1.getString("natureA"));
					em.setDateA(rs1.getString("dateA"));
					em.setNbreA(rs.getInt("count(id_Ab)"));
					absence.add(em);
					
				}System.out.println(absence);
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
			return absence;
		}
		///////////////////////////////getRetard//////////////////////////////////////////////////////////
		
		public List<retard> getRetard(int id) {
			List<retard> retard = new ArrayList<retard>();
			Connection connection= SingletonConnection.getConnection();
			try {
				PreparedStatement ps1=connection.prepareStatement("select natureR ,dateR from retard  where id_Re=? \r\n;");
				ps1.setInt(1, id);
				PreparedStatement ps=connection.prepareStatement("select count(id_Re) from retard where id_Re=? \r\n;");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				ResultSet rs1 = ps1.executeQuery();
				if(rs.next()) {
					
				}
				while(rs1.next()) {
					retard em=new retard();
					em.setNatureR(rs1.getString("natureR"));
					em.setDateR(rs1.getString("dateR"));
					em.setNbreR(rs.getInt("count(id_Re)"));
					retard.add(em);
					
				}System.out.println(retard);
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
			return retard;
		}
		////////////////////////////////get email//////////////////////////////////////////////////////
		public static List<employé> listeEmplemail() {
			List<employé> employes = new ArrayList<employé>();
			Connection connection= SingletonConnection.getConnection();		
			try {
				PreparedStatement ps = connection.prepareStatement("select * from personne Where role='employe' \r\n;");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					employé em = new employé();
					em.setEmail(rs.getString("email"));
					employes.add(em);
				}
				System.out.println(employes);
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
			return employes;
		}
		//////////////////////////////getnbrempl///////////////////////////////////////////
		public static int getNbrEmployes() {
			Connection connection= SingletonConnection.getConnection();	
			int n = 0;
			try {
				PreparedStatement ps = connection.prepareStatement("select count(email) from personne  ; ");

				ResultSet res = ps.executeQuery();
				while (res.next()) {
					n = res.getInt("count(email)");
				}
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}

			return n;
		}
		/////////////////////////////////getemail/////////////////////////////////////////
//		public static String [] getEmail() {
//			String select ="select email from personne where role='employe'";
//			Connection conn=SingletonConnection.getConnection();
//			String[] email = new String[getNbrEmployes()];
//			try {
//				PreparedStatement ps = conn.prepareStatement("SELECT email,numtel personne order by numtel;");
//				System.out.println(ps);System.out.println(email);
//				ResultSet rs = ps.executeQuery();
//				int i = 0;
//				while (rs.next()) {
//					
//					email[i] = rs.getString("email");
//					i++;
//					System.out.println(email);
//				}
//				ps.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("error");
//			}
//			return email;}
		/////////////////////////////////////getmessage////////////////////////////////////
		public List<message> getUser(){
			List<message> uss = new ArrayList<message>();
			String query = "select * from message;";
			try {
				PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					message us = new message();
					us.setEmail(rs.getString("email_Me"));
					
					us.setDateE(rs.getString("dateE"));
					us.setIdM(rs.getInt("idM_R"));
					us.setIdE(rs.getInt("id_R"));
					uss.add(us);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return uss;
		}
		///////////////////////////////////liste Message///////////////////////////////////////////////
		public static List<message> listeMessage() {
			List<message> message= new ArrayList<message>();
			
			Connection connection= SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("select * from messagee Where nom_en='zarki' AND prenom_en='adam' ;");
				ResultSet rs = ps.executeQuery();

				message me;
				
				while(rs.next()) {
					me=new message();
					System.out.println(88);
					me.setEmail(rs.getString("email_Me"));
					me.setIdM(rs.getInt("idMe"));
					me.setSujet(rs.getString("contenu"));
					me.setDateE(rs.getString("dateE"));
					me.setObjet(rs.getString("objet"));
					message.add(me);
					
				}
				System.out.println(55);
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}System.out.println(message);
			return message;					

		}
		public static List<message> listeMessageEmploye(String email) {
			List<message> message= new ArrayList<message>();
			
			Connection connection= SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("select * from messagee Where email_Me=?;");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();

				message me;
				
				while(rs.next()) {
					me=new message();
					System.out.println(88);
					me.setNom(rs.getString("nom_en"));
					me.setPrenom(rs.getString("prenom_en"));
					me.setEmail(rs.getString("email_Me"));
					me.setIdM(rs.getInt("idMe"));
					me.setSujet(rs.getString("contenu"));
					me.setDateE(rs.getString("dateE"));
					me.setObjet(rs.getString("objet"));
					message.add(me);
					
				}
				System.out.println(55);
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}System.out.println(message);
			return message;					

		}
		public static List<employé> listeEmplemailE() {
			List<employé> employes = new ArrayList<employé>();
			Connection connection= SingletonConnection.getConnection();		
			try {
				PreparedStatement ps = connection.prepareStatement("select * from personne \r\n;");
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					employé em = new employé();
					em.setEmail(rs.getString("email"));
					employes.add(em);
				}
				System.out.println(employes);
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
			return employes;}
		public static List<message> listeMessageE(String nom , String prenom) {
			List<message> message= new ArrayList<message>();
			
			Connection connection= SingletonConnection.getConnection();
			try {
				PreparedStatement ps=connection.prepareStatement("select * from messagee Where nom_en=? AND prenom_en=? ;");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ResultSet rs = ps.executeQuery();
				
				message me;
				
				while(rs.next()) {
					me=new message();
					System.out.println(88);
					me.setNom(rs.getString("nom_en"));
					me.setPrenom(rs.getString("prenom_en"));
					me.setEmail(rs.getString("email_Me"));
					me.setIdM(rs.getInt("idMe"));
					me.setSujet(rs.getString("contenu"));
					me.setDateE(rs.getString("dateE"));
					me.setObjet(rs.getString("objet"));
					message.add(me);
					
				}
				System.out.println(55);
				ps.close();
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}System.out.println(message);
			return message;					
		}


}


