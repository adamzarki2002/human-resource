package DAO;

import DAO.*;

import metier.absence;
import metier.emploi;
import metier.employé;
import metier.message;
import metier.retard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import metier.employé;

public class ajouterEmp {
	public static int ajouterEmploye(employé em) {
		int res=0;
		Connection connection= SingletonConnection.getConnection();
			PreparedStatement ps;
			try {
				 ps = connection.prepareStatement (
					" INSERT INTO personne(nom,prenom,email,mdp,salaire,numtel,role,adresse)  values(?,?,?,?,?,?,?,?)");
			    ps.setString(1, em.getNom());
			    ps.setString(2, em.getPrenom());
			    ps.setString(3, em.getEmail());
			    ps.setString(4, em.getMdp());
			    ps.setString(5, em.getSalaire());
			    ps.setString(6, em.getNumtel());
			    ps.setString(7, em.getRole());
			    ps.setString(8, em.getAdresse());
			   System.out.println(ps);
		        res=ps.executeUpdate();
			    ps.close();
			   
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
			return res;

	}
	public static int ajouterAbsence(absence em) {
		int res=0;
		Connection connection= SingletonConnection.getConnection();
			PreparedStatement ps,ps2;
			try {
				 ps = connection.prepareStatement (
					" INSERT INTO absence(id_Ab,natureA,dateA)  values(?,?,?)");
			    ps.setInt(1, em.getId_Ab());
			    ps.setString(2, em.getNatureA());
			    ps.setString(3, em.getDateA());
//			    ps.setString(4,em.getNom());
//			    ps.setString(5,em.getPrenom());
			   System.out.println(ps);
		        res=ps.executeUpdate();
			    ps.close();
			   
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
			return res;

	}
	public static int getNbreAbsences(int id_Ab) {
		Connection connection= SingletonConnection.getConnection();
		int n=0;
		try {
			PreparedStatement ps=connection.prepareStatement("select count(id_Ab) from absence WHERE id_Ab=?  ; ");
			ps.setInt(1, id_Ab);
			System.out.println("13");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			 n=rs.getInt("count(id_Ab)");
			 
			}ps.close();
			System.out.println(n);
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		return n;
		
	}
	public static int ajouterRetard(retard em) {
		int res=0;
		Connection connection= SingletonConnection.getConnection();
			PreparedStatement ps,ps2;
			try {
				 ps = connection.prepareStatement (
					" INSERT INTO retard(id_Re,natureR,dateR)  values(?,?,?)");
			    ps.setInt(1, em.getId_Re());
			    ps.setString(2, em.getNatureR());
			    ps.setString(3, em.getDateR());
//			    ps.setString(4,em.getNom());
//			    ps.setString(5,em.getPrenom());
			   System.out.println(ps);
		        res=ps.executeUpdate();
			    ps.close();
			   
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
			return res;

	}
	public static int getNbreRetards(int id_Re) {
		Connection connection= SingletonConnection.getConnection();
		int n=0;
		try {
			PreparedStatement ps=connection.prepareStatement("select count(id_Re) from retard WHERE id_Re=?  ; ");
			ps.setInt(1, id_Re);
			System.out.println("13");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			 n=rs.getInt("count(id_Re)");
			 
			}ps.close();
			System.out.println(n);
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		return n;
		
	}
	//////////////////////////////message/////////////////////////////////////////////////////////////////
	public static int EnvoyerMessageE(message me) {
		System.out.println("********");
		System.out.println(me);
		System.out.println("********");
		int res=0;
		Connection connection= SingletonConnection.getConnection(); 
        PreparedStatement ps,ps1 ;

		try {
	        ps = connection.prepareStatement(
            		"INSERT INTO messagee(email_Me,dateE,contenu,nom_en,prenom_en,objet) VALUES(?,?,?,?,?,?);");
	        ps.setString(1, me.getEmail());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			   LocalDateTime now = LocalDateTime.now();
			  String date=dtf.format(now);
			 ps.setString(2, date);
			 ps.setString(3, me.getSujet());
			 ps.setString(4, me.getNom());
			 ps.setString(5, me.getPrenom());
			 ps.setString(6, me.getObjet());
			  ps1 = connection.prepareStatement(
	            		"INSERT INTO message(contenu,objet,idM)\r\n" + 
	            		"SELECT contenu,objet,idMe FROM messagee\r\n" + 
	            		"WHERE email_Me=?;");
			  ps1.setString(1, me.getEmail());
			  System.out.println(ps);
            res=ps.executeUpdate();
            ps1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	return res;
	}
	

}


