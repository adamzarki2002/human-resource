<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Home Employé</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css1/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
    <% response.setHeader("cache-Control","no-cache, no-store");
    if(session.getAttribute("Email")==null){ response.sendRedirect("login.jsp");} %>
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.html">GRH</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4"><div class="info">
         <c:if test="${ !empty sessionScope.prenom && !empty sessionScope.nom }">
        <p style="color: white;">${ sessionScope.prenom } ${ sessionScope.nom } </p>
    </c:if>
        </div>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="profile">profil</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="homeEmploye.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Home
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <a class="nav-link" href="index.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                emploi du temps
                            </a>
                            <a class="nav-link" href="getAbsence">
                                <div class="sb-nav-link-icon"><i class="nav-icon far fa-address-book"></i></div>
                                Absences
                            </a>
                            <a class="nav-link" href="getRetard">
                                <div class="sb-nav-link-icon"><i class="nav-icon far fa-address-book"></i></div>
                                Retard
                            </a>
                             <a class="nav-link" href="listeMessageEmoplye">
                                <div class="sb-nav-link-icon"><i class="nav-icon far fa-address-book"></i></div>
                                message reçu
                            </a>
                            <a class="nav-link" href="listeMessageEmoplyeE">
                                <div class="sb-nav-link-icon"><i class="nav-icon far fa-address-book"></i></div>
                                message envoyer
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        GRH
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
               <section class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-7" style="margin-left:220px">

            <!-- Profile Image -->
            <div class="card card-primary card-outline">
              <div class="card-body box-profile">
           

                <h3 class="profile-username text-center"><input type="text" size="10" class="form-control" style="text-align:center;" placeholder="${ em.nom}" name="nom" disabled="disabled"></h3><h3 class="profile-username text-center"><input type="text" size="10" class="form-control" style="text-align:center;" placeholder="${ em.prenom}" name="prenom" disabled="disabled"></h3>
                

                <p class="text-muted text-center">Employer</p>
         
                <ul class="list-group list-group-unbordered mb-3">
                  <li class="list-group-item">
                    <b>Email</b> <a class="float-right"><input type="text" size="20"  placeholder="${ em.getEmail()}" class="form-control" name="email" disabled="disabled"></a>
                  </li>
                    
                  <li class="list-group-item">
                    <b>Mot de passe</b> <a class="float-right"><input type="text" size="20"  placeholder="${ em.getMdp()}" class="form-control" name="mdp" disabled="disabled"></a>
                  </li>
                  <li class="list-group-item">
                    <b>salaire</b> <a class="float-right"><input type="text" size="20"  placeholder="${ em.getSalaire()}" class="form-control" name="salaire" disabled="disabled"></a>
                  </li>
                  <li class="list-group-item">
                    <b>numero de telephone</b> <a class="float-right"><input type="text" size="20"  placeholder="${ em.numtel}" class="form-control" name="numtel" disabled="disabled"></a>
                  </li>
                  <li class="list-group-item">
                    <b>adresse</b> <a class="float-right"><input type="text" size="20"  placeholder="${ em.adresse}" class="form-control" name="adresse" disabled="disabled"></a>
                  </li>
                  <li class="list-group-item">
                    <b>Poste</b> <a class="float-right"><input type="text" size="20"  placeholder="${ eme.nom_P}" class="form-control" name="adresse" disabled="disabled"></a>
                  </li>
                </ul>
              </div>
              <!-- /.card-body -->
            </div>
            
            <!-- /.card -->

            <!-- Form Element sizes -->
                     <!-- /.card -->
          </div>
          <!--/.col (right) -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
                    
                    
                  
                </div>
           </div>    
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js1/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets1/demo/chart-area-demo.js"></script>
        <script src="assets1/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js1/datatables-simple-demo.js"></script>
    </body>
</html>
