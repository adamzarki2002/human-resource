package web;

import java.awt.print.Printable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import DAO.ajouterEmp;
import DAO.donnerP;
import DAO.emploidutemps;
import DAO.listeEmpl;
import DAO.modifierE;

import DAO.DaoLogin;

import metier.*;
import DAO.SingletonConnection;



/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet(name = "LoginService", urlPatterns = { "/LoginService","/login","/ajouterEmploye","/listeEmploye" ,"/donnerP","/edit",
		                                        "/modifierEmploye","/supprimerEmploye","/ajouterAbsence","/listeAbsence",
		                                        "/voir","/modifierAbsence","/edit1","/supprimerAbsence",
		                                        "/ajouterRetard","/listeRetard","/voir1","/modifierRetard","/edit2","/supprimerRetard",
		                                        "/logout","/profile","/getAbsence","/getRetard","/ecrireMessage","/EnvoyerMessageE",
		                                        "/listeMessage","/afficherMessage","/listeMessageEmoplye","/afficherMessageE",
		                                        "/ecrireMessageE","/listeMessageEmoplyeE","/EnvoyerMessageEP","/listeMessageR",
		                                        "/AC","/ACsuivant","/EPSE","/generale"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoLogin daologin; 
	private ajouterEmp employe;
	private modifierE employes;
	private listeEmpl employeliste;
	private donnerP poste;
	private emploidutemps emploi;
    public void init() {
    	daologin=new DaoLogin();
    	employe =new ajouterEmp();
    	employeliste=new listeEmpl();
    	poste=new donnerP();
    	employes =new modifierE();
    	emploi=new emploidutemps();
    }
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		System.out.println("path : " + path);
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3600);
		
		if(request.getServletPath().equals("/login")) {
			String Email = request.getParameter("Email");
			String password = request.getParameter("password");

			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			System.out.println(nom);
			System.out.println(prenom);
			System.out.println("userr "+daologin.getUser(Email,password));

				
				if("admin".equals(daologin.getUser(Email,password).getRole())){
					
					Login user =new Login();
					user = daologin.getUser(Email,password);
					
					System.out.println(user);
					System.out.println(user.getId());
					int id =user.getId();
					
					nom = user.getNom();
					prenom = user.getPrenom();
					System.out.println(nom);
					System.out.println(prenom);
					session.setAttribute("Email", Email);
					
					session.setAttribute("nom", nom);
					
					session.setAttribute("prenom", prenom);
					request.getRequestDispatcher("homeAdmin.jsp").forward(request,response);
					
				}else if("employe".equals(daologin.getUser(Email,password).getRole())){
					
					Login user =new Login();
					user = daologin.getUser(Email,password);
					
					nom = user.getNom();
					prenom = user.getPrenom();
					int id =user.getId();
					
					System.out.println(nom);
					System.out.println(prenom);
					System.out.println(id);
					session.setAttribute("Email", Email);
					System.out.println(Email);
					session.setAttribute("nom", nom);
					
					session.setAttribute("prenom", prenom);
					session.setAttribute("id", id);
					request.getRequestDispatcher("homeEmploye.jsp").forward(request,response);
				
				}
				else {
					request.setAttribute("mdpInco", "email ou mot de passe incorrect");
					this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
				}
			
				
				//response.sendRedirect(url);
				
		}
		if(request.getServletPath().equals("/logout")) {
			String Email = (String) session.getAttribute("Email");
			System.out.println(Email);
			System.out.println(00);
			session.removeAttribute("Email");
			session.removeAttribute("nom");
			session.removeAttribute("prenom");
			session.invalidate();
			System.out.println(Email);
			
			
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		
	}
		////////////////////////////////////////employe////////////////////////////////////////////////////
		else if(request.getServletPath().equals("/ajouterEmploye")) {
			employé em = new employé();
			em.setNom(request.getParameter("nom"));
			System.out.println("2");
			em.setPrenom(request.getParameter("prenom"));
			System.out.println("3");
			em.setEmail(request.getParameter("email"));
			System.out.println("4");
			em.setMdp(request.getParameter("mdp"));
			System.out.println("5");
			em.setNumtel(request.getParameter("numtel"));
			System.out.println("7");
			em.setRole(request.getParameter("role"));
			System.out.println("8");
			em.setSalaire(request.getParameter("salaire"));
			em.setAdresse(request.getParameter("adresse"));
			System.out.println("9");
			System.out.println("10");
			request.setAttribute("name", 1);
			System.out.println(5);
		
			 	if(employe.ajouterEmploye(em)!=0) {
			 		
			         // session.setAttribute("username",username);
			         response.sendRedirect("homeAdmin.jsp");
			     } else {
			         
			         //session.setAttribute("user", username);
			         response.sendRedirect("ajouterEmploye.jsp");
			     }
			
		}	
		else if(request.getServletPath().equals("/listeEmploye")) {
			request.setAttribute("employes", employeliste.listeEmployes());
			this.getServletContext().getRequestDispatcher("/listeEmpl.jsp").forward(request, response);
			
			
		}
		else if(request.getServletPath().equals("/donnerP")) {
			emploi ee = new emploi();
			ee.setNom_P(request.getParameter("nomP_P"));
			ee.setNom_Pk(request.getParameter("nom_Pk"));
			ee.setPrenom_Pk(request.getParameter("prenom_Pk"));
			System.out.println("55555");
			ee.setId_P(Integer.parseInt(request.getParameter("id_P")));
			System.out.println("44444");	
			 	if(poste.donnerPoste(ee)!=0) {
			         // session.setAttribute("username",username);
			         response.sendRedirect("homeAdmin.jsp");
			     } else {
			         //session.setAttribute("user", username);
			         response.sendRedirect("donnerP.jsp");
			     }
			 	}
		else if (request.getServletPath().equals("/edit")) {

	 		int id = Integer.parseInt(request.getParameter("id"));
			employé em=employes.cherEmploye(id);
	        emploi eme=employes.cherEmploye1(id); 
			request.setAttribute("em",em);
	        request.setAttribute("eme",eme); 
			System.out.println(id);
			this.getServletContext().getRequestDispatcher("/modifierEmpl.jsp").forward(request, response);
		}	
		
		else if (request.getServletPath().equals("/modifierEmploye")) {
			System.out.println("111");
			employé em = new employé();
			emploi eme = new emploi();
			System.out.println("1");
			em.setNom(request.getParameter("nom"));
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("1");
			 em.setId(id); 
			em.setPrenom(request.getParameter("prenom"));
			System.out.println("1");
			em.setEmail(request.getParameter("email"));
			em.setMdp(request.getParameter("mdp"));
			System.out.println("1");
			em.setSalaire(request.getParameter("salaire"));
			em.setNumtel(request.getParameter("numtel"));
			em.setAdresse(request.getParameter("adresse"));
//		em.setPhoto(request.getParameter("photo"));
			eme.setId_P(id); 
			System.out.println("1");
			eme.setNom_P(request.getParameter("nomP_P"));
			System.out.println(em);
			System.out.println(eme);
			employes.modifierEmploye(em);
			System.out.println("12");
			employes.modifierEmployee(eme);
			System.out.println("12");
			
			request.getRequestDispatcher("/listeEmploye").forward(request, response);
		}
		if (request.getServletPath().equals("/supprimerEmploye")) {
			int id = Integer.parseInt(request.getParameter("id"));
		    System.out.println(id);
		    employes.supprimerP(id);
			employes.supprimerEmploye(id);
			request.setAttribute("em", 1);
			this.getServletContext().getRequestDispatcher("/listeEmploye").forward(request, response);
		}
		//////////////////////////absence/////////////////////////////////////////////////////////////////
		else if(request.getServletPath().equals("/ajouterAbsence")) {
			absence em = new absence();
			em.setId_Ab(Integer.parseInt(request.getParameter("id_Ab")));
			System.out.println("2");
			em.setDateA(request.getParameter("dateA"));
			System.out.println("3");
			em.setNatureA(request.getParameter("natureA"));
			System.out.println("4");
			request.setAttribute("employes", em);
			System.out.println(5);
			employe.ajouterAbsence(em);
			 response.sendRedirect("ajouterAbs.jsp");

			
		}
		else if(request.getServletPath().equals("/listeAbsence")) {
			request.setAttribute("employe", employeliste.listeAbsence());
			this.getServletContext().getRequestDispatcher("/listeAb.jsp").forward(request, response);
			
			
		}
		else if (request.getServletPath().equals("/voir")) {
System.out.println(3);
	 		int id_Ab = Integer.parseInt(request.getParameter("id_Ab"));
			request.setAttribute("employe", employeliste.listeAbsence1(id_Ab));
			System.out.println(1);

			this.getServletContext().getRequestDispatcher("/absE.jsp").forward(request, response);
		}
		else if (request.getServletPath().equals("/modifierAbsence")) {
	        	   int idA = Integer.parseInt(request.getParameter("idA"));
	        	   absence em = new absence();
//            	   em.setId_Ab(Integer.parseInt(request.getParameter("id_Ab")));
	        	   em.setIdA(idA);
					em.setNatureA(request.getParameter("natureA"));
					em.setDateA(request.getParameter("dateA"));
					employes.modifierAbsence(em);
					System.out.println(em);
					this.getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
		}
		else if (request.getServletPath().equals("/edit1")) {
			System.out.println(1228);
			int idA = Integer.parseInt(request.getParameter("idA"));
			System.out.println(1225);
			request.setAttribute("idA", employes.cherEmploye2(idA));
			System.out.println(1222555555);
			System.out.println(idA);
			this.getServletContext().getRequestDispatcher("/modifierAbs.jsp").forward(request, response);
		}	
		else if (request.getServletPath().equals("/supprimerAbsence")) {
			int idA = Integer.parseInt(request.getParameter("idA"));
			employes.supprimerAbsence(idA);
			request.setAttribute("eme", 1);
			this.getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
		
		}
		////////////////////////////////////////retard////////////////////////////////////////////////
		else if(request.getServletPath().equals("/ajouterRetard")) {
			retard em = new retard();
			em.setId_Re(Integer.parseInt(request.getParameter("id_Re")));
			System.out.println("2");
			em.setDateR(request.getParameter("dateR"));
			System.out.println("3");
			em.setNatureR(request.getParameter("natureR"));
			System.out.println("4");
			request.setAttribute("employes", em);
			System.out.println(5);
			employe.ajouterRetard(em);
			 response.sendRedirect("ajouterRe.jsp");
		
			
		}
		else if(request.getServletPath().equals("/listeRetard")) {
			request.setAttribute("employe", employeliste.listeRetard());
			this.getServletContext().getRequestDispatcher("/listRe.jsp").forward(request, response);
			
			
		}
		else if (request.getServletPath().equals("/voir1")) {
System.out.println(3);
	 		int id_Re = Integer.parseInt(request.getParameter("id_Re"));
			request.setAttribute("employe", employeliste.listeRetard1(id_Re));
			System.out.println(1);
			this.getServletContext().getRequestDispatcher("/RetE.jsp").forward(request, response);
		}
		else if (request.getServletPath().equals("/modifierRetard")) {
	        	   int idR = Integer.parseInt(request.getParameter("idR"));
	        	   retard em = new retard();
//            	   em.setId_Ab(Integer.parseInt(request.getParameter("id_Ab")));
	        	   em.setIdR(idR);
					em.setNatureR(request.getParameter("natureR"));
					em.setDateR(request.getParameter("dateR"));
					employes.modifierRetard(em);
					System.out.println(em);
					this.getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
		}
		else if (request.getServletPath().equals("/edit2")) {
			System.out.println(1228);
			int idR = Integer.parseInt(request.getParameter("idR"));
			System.out.println(1225);
			request.setAttribute("idR", employes.cherEmploye3(idR));
			System.out.println(1222555555);
			System.out.println(idR);
			this.getServletContext().getRequestDispatcher("/modifierRe.jsp").forward(request, response);
		}	
		else if (request.getServletPath().equals("/supprimerRetard")) {
			int idR = Integer.parseInt(request.getParameter("idR"));
			employes.supprimerRetard(idR);
			request.setAttribute("eme", 1);
			this.getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
		
		}	
		else if (request.getServletPath().equals("/profile")) {
			int id =(int) session.getAttribute("id");
			System.out.println(id);
			employé em=employes.chercherP(id);
			emploi eme=employes.chercherPP(id);
			request.setAttribute("em", em);
			request.setAttribute("eme", eme);
			System.out.println(em);
			this.getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
		}
		else if (request.getServletPath().equals("/getAbsence")) {
           
            int id =(int) session.getAttribute("id");
			request.setAttribute("employe", employeliste.getAbsence(id));
			
			this.getServletContext().getRequestDispatcher("/absenceE1.jsp").forward(request, response);
		}
		else if (request.getServletPath().equals("/getRetard")) {
            System.out.println(3);
	 		int id = (int) session.getAttribute("id");
			request.setAttribute("employe", employeliste.getRetard(id));
			System.out.println(1);
			this.getServletContext().getRequestDispatcher("/retardE1.jsp").forward(request, response);
		}
		////////////////////////////////////message/////////////////////////////////////////////////
		if(request.getServletPath().equals("/ecrireMessage")) {
			request.setAttribute("employes", employeliste.listeEmplemail());
			this.getServletContext().getRequestDispatcher("/ecrireM.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/EnvoyerMessageE")) {
		
			try {
				

			message message = new message();
			System.out.println(message);
			message.setEmail(request.getParameter("email_Me"));
			message.setSujet(request.getParameter("contenu"));
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			   LocalDateTime now = LocalDateTime.now();
			  String date=dtf.format(now);
			message.setDateE(date);
			message.setObjet(request.getParameter("objet"));	
			
			message.setNom(request.getParameter("nom_en"));
			message.setPrenom(request.getParameter("prenom_en"));
			

			System.out.println(message);
			ajouterEmp.EnvoyerMessageE(message);
            request.setAttribute("cond", 1);

			this.getServletContext().getRequestDispatcher("/homeAdmin.jsp").forward(request, response);
	}
			catch(Exception e) {
				e.getStackTrace();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
	 	}
		else if(request.getServletPath().equals("/listeMessage")) {
			request.setAttribute("employe", employeliste.listeMessage());
			this.getServletContext().getRequestDispatcher("/listeM.jsp").forward(request, response);
			
			
		}
		
		else if (request.getServletPath().equals("/afficherMessage")) {
			int idM = Integer.parseInt(request.getParameter("idMe"));
			System.out.println(idM);
			message em=employes.cherMessage(idM);
			request.setAttribute("em", em);
			System.out.println(em);
			this.getServletContext().getRequestDispatcher("/afficheMessage.jsp").forward(request, response);
		}
		else if(request.getServletPath().equals("/listeMessageR")) {System.out.println("10000000");
			String email = (String) session.getAttribute("Email");
            System.out.println(email);
			request.setAttribute("message", employeliste.listeMessageEmploye(email));
			this.getServletContext().getRequestDispatcher("/listeMR.jsp").forward(request, response);	
		}
		else if(request.getServletPath().equals("/listeMessageEmoplye")) {
			String email = (String) session.getAttribute("Email");
            System.out.println(email);
			request.setAttribute("message", employeliste.listeMessageEmploye(email));
			this.getServletContext().getRequestDispatcher("/listeME.jsp").forward(request, response);	
		}
		
		else if (request.getServletPath().equals("/afficherMessageE")) {
			int idM = Integer.parseInt(request.getParameter("idMe"));
			System.out.println(idM);
			message em=employes.cherMessage(idM);
			request.setAttribute("em", em);
			System.out.println(em);
			this.getServletContext().getRequestDispatcher("/afficherMessageE.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/ecrireMessageE")) {
			request.setAttribute("employes", employeliste.listeEmplemailE());
			this.getServletContext().getRequestDispatcher("/ecrireME.jsp").forward(request, response);
		}
		if(request.getServletPath().equals("/EnvoyerMessageEP")) {
			
			try {
				

			message message = new message();
			System.out.println(message);
			message.setEmail(request.getParameter("email_Me"));
			message.setSujet(request.getParameter("contenu"));
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			   LocalDateTime now = LocalDateTime.now();
			  String date=dtf.format(now);
			message.setDateE(date);
			message.setObjet(request.getParameter("objet"));	
			
			message.setNom(request.getParameter("nom_en"));
			message.setPrenom(request.getParameter("prenom_en"));
			System.out.println(message);
			ajouterEmp.EnvoyerMessageE(message);
            request.setAttribute("cond", 1);

			this.getServletContext().getRequestDispatcher("/homeEmploye.jsp").forward(request, response);
	}
			catch(Exception e) {
				e.getStackTrace();
				System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
	 	}
		
		else if(request.getServletPath().equals("/listeMessageEmoplyeE")) {
			String nom = (String) session.getAttribute("nom");
			String prenom = (String) session.getAttribute("prenom");
			request.setAttribute("message", employeliste.listeMessageE(nom,prenom));
			this.getServletContext().getRequestDispatcher("/listeMEP.jsp").forward(request, response);	
		}
		
		else if(request.getServletPath().equals("/AC")) {
			emploi[] T=emploi.tableauAC();
			
			emploi [][]tab=new emploi[3][5];
			for(int j=0;j<5;j++) {
				for(int i=0;i<3;i++) {
					tab[i][j]=T[i];
					}
				int m=0;
				emploi Tmin=T[m];
				T[m]=T[m+1];
				T[m+1]=T[m+2];
				T[m+2]=Tmin;
			}
			request.setAttribute("emploi",tab);
			this.getServletContext().getRequestDispatcher("/AC.jsp").forward(request, response);
		}
		else if(request.getServletPath().equals("/ACsuivant")) {
			emploi[] T=emploi.tableauAC();
			emploi [][]tab=new emploi[3][5];
		
			for(int j=0;j<5;j++) {
				int m=0;
			emploi Tmin=T[m];
			T[m]=T[m+1];
			T[m+1]=T[m+2];
			T[m+2]=Tmin;
				for(int i=0;i<3;i++) {
					tab[i][j]=T[i];
					}
			
			}
			request.setAttribute("emploi",tab);
			this.getServletContext().getRequestDispatcher("/AC.jsp").forward(request, response);
		}
		
		
		else if(request.getServletPath().equals("/EPSE")) {
			emploi[] T=emploi.tableauEPSE();
			emploi [][]tab=new emploi[4][5];
		
			for(int j=0;j<5;j++) {
			
				for(int i=0;i<4;i++) {
					tab[i][j]=T[i];
					}
				Arrays.toString(T);
			     Collections.reverse(Arrays.asList(T));
			}
			request.setAttribute("emploi",tab);
			this.getServletContext().getRequestDispatcher("/EPSE.jsp").forward(request, response);
		}
		
		else if(request.getServletPath().equals("/generale")) {
			emploi[] T=emploi.tableauAC();
			emploi [][]tab=new emploi[3][5];
		
			for(int j=0;j<5;j++) {
				int m=0;
			emploi Tmin=T[m];
			T[m]=T[m+1];
			T[m+1]=T[m+2];
			T[m+2]=Tmin;
				for(int i=0;i<3;i++) {
					tab[i][j]=T[i];
					}
			
			}
			request.setAttribute("emploi",tab);
			emploi[] Ta=emploi.tableauEPSE();
			emploi [][]tab1=new emploi[4][5];
		
			for(int j=0;j<5;j++) {
			
				for(int i=0;i<4;i++) {
					tab1[i][j]=Ta[i];
					}
				Arrays.toString(Ta);
			     Collections.reverse(Arrays.asList(Ta));
			}
			request.setAttribute("emploi1",tab1);
			this.getServletContext().getRequestDispatcher("/emplGe.jsp").forward(request, response);
		}
		
	}	}	
		
		
		

       

 
		