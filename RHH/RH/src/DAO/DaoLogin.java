package DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import DAO.SingletonConnection;
import metier.Login;
import metier.*;

public class DaoLogin {
	
	    
	    
		static Connection conn =SingletonConnection.getConnection();
		
	


		public boolean saveUser(Login user){
	        boolean set = false;
	        Connection conn=SingletonConnection.getConnection();
	    	PreparedStatement pt;
	        try {
	        	pt= conn.prepareStatement("insert into personne(mdp,role,email) values(?,?,?)");
	           
	           
	           pt.setString(1, user.getEmail());
	           System.out.println(user.getEmail());
	           pt.setString(2, user.getMdp());
	           System.out.println(user.getMdp());
	           pt.setString(3, user.getRole());
	           System.out.println(user.getRole());
	           pt.executeUpdate();
	           
	           set = true;
	           System.out.println("vous etes connecté ");
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	        return set;
	    }
		public static Login getUser(String Email , String password) {
			System.out.println(1);
			Login user =new Login();
			System.out.println(2);
			try {
				PreparedStatement pt=conn.prepareStatement("Select * from personne where email=? and mdp=?");
				System.out.println(3);
				pt.setString(1, Email);
				pt.setString(2, password);
			    
				ResultSet rs =pt.executeQuery();
				System.out.println(4);
				if(rs.next()) {
					user.setEmail(rs.getString("email"));
					user.setRole(rs.getString("role"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setId(rs.getInt("id"));
					System.out.println(user);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return user;

		}
		
		
		
		
		
	    static void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	    public void loadDriver(String dbDriver)
		{
			try {
				Class.forName(dbDriver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public boolean validate(Login user) throws ClassNotFoundException, SQLException
		{
			boolean status = false;
			
			
			String sql = "select * from personne where email = ? and mdp =? ";
			PreparedStatement ps;
			try 
			{
			ps = conn.prepareStatement(sql);
		    ps.setString(3, user.getEmail());
			ps.setString(1, user.getMdp());
			ps.setString(2, user.getRole());
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return status;
		}



	}