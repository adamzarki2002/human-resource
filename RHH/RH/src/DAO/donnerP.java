package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import metier.absence;
import metier.emploi;
import metier.poste;

public class donnerP {
	public static int donnerPoste(emploi ee) {
		int res=0;
		Connection connection= SingletonConnection.getConnection();
			PreparedStatement ps;
			poste em=new poste();
//			ResultSet rs = ps.executeQuery();
			try {
				 ps = connection.prepareStatement (
					" INSERT INTO emploi_du_temps(id_P,date,nomP_P,nom_Pk,prenom_Pk)  values(?,?,?,?,?)");
//				 ps2 = connection.prepareStatement (
//							" select nbrD from poste where nomP=? ");
			    ps.setDate(2, ee.getDate());
		        ps.setString(3, ee.getNom_P());
			    ps.setInt(1, ee.getId_P());
			    ps.setString(4, ee.getNom_Pk());
			    ps.setString(5, ee.getPrenom_Pk());
			    System.out.println(ps);
//			    ps2.setString(1,ee.getNom_P());
//			    em.setNbrP(rs.getInt("nbrD"));
//			    if(em.setNbrP(rs.getInt("nbrD"))== )
		        res=ps.executeUpdate();
//		        res1=ps2.executeUpdate();
			    ps.close();
//			    ps2.close();
			   
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
			return res;

	}
}

