package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import metier.emploi;

public class emploidutemps {
	public static  emploi[] tableauAC() {
		
		emploi em=new emploi();
		Connection connection= SingletonConnection.getConnection();
		 emploi [] T=new emploi[3];
		
		try {
			PreparedStatement ps = connection.prepareStatement("select id_P,nom_Pk,prenom_Pk from emploi_du_temps Where nomP_P='AC' \r\n;");
			ResultSet rs = ps.executeQuery();
          
            int i=0;
		  	while (rs.next()) {
		  		
		  		
		  	  emploi ee=new emploi();

		  			ee.setId_P(rs.getInt("id_P"));
		  			ee.setNom_Pk(rs.getString("nom_Pk"));
		  			ee.setPrenom_Pk(rs.getString("prenom_Pk"));
		  			emploi a=ee;
		  			T[i]=a;
		  			i++;
			 }
//		  	for( i=0;i<3;i++) {
//		  		System.out.println(T[i]);
//		  	}
		  	
			
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		
		return T;
	}

	public static  emploi[] tableauEPSE() {
		
		emploi em=new emploi();
		Connection connection= SingletonConnection.getConnection();
		 emploi [] T=new emploi[4];
		
		try {
			PreparedStatement ps = connection.prepareStatement("select id_P,nom_Pk,prenom_Pk from emploi_du_temps Where nomP_P='EP/SE' \r\n;");
			ResultSet rs = ps.executeQuery();
          
            int i=0;
		  	while (rs.next()) {
		  		
		  		
		  	  emploi ee=new emploi();

		  			ee.setId_P(rs.getInt("id_P"));
		  			ee.setNom_Pk(rs.getString("nom_Pk"));
		  			ee.setPrenom_Pk(rs.getString("prenom_Pk"));
		  			emploi a=ee;
		  			T[i]=a;
		  			i++;
			 }
//		  	for( i=0;i<3;i++) {
//		  		System.out.println(T[i]);
//		  	}
		  	
			
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		
		return T;
	}

}
