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
        <title>Home Employ�</title>
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
                             <a class="nav-link" href="ecrireMessageE">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Contact
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
                                message re�u
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
      <div class="row">
        
          

                  <!-- /.col -->
        <div class="col-md-16" style="margin-left:90px">
          <div class="card card-primary card-outline">
            <div class="card-header">
              <h3 class="card-title">Liste des messages</h3>

              
              <!-- /.card-tools -->
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              
                <table id="example1" class="table table-bordered table-hover " style="width:900px">
                <thead>
                <tr>
                  <th style="width: 30%">email</th>
                  <th style="width: 35%">Objet</th>
                  <th style="width: 35%">Date</th>
                </tr>
              </thead>
              <tbody >
                 <c:forEach var="msg" items="${message}" >
                  
                  
                  <tr  style="list-style-type:disc;">
                    <td class="mailbox-name" onclick="window.location='afficherMessageE?idMe=${msg.idM}';">${msg.email }</td>
                    <td onclick="window.location='afficherMessageE?idMe=${msg.idM}';" class="mailbox-subject"><b>${msg.objet }</b>
                    </td>
                    <td onclick="window.location='afficherMessageE?idMe=${msg.idM}';" ><b> <i class="fas fa-clock mr-1"> </i>${msg.dateE }</b>
                    </td>
                  </tr>
                  
                  </c:forEach>
                  </tbody>
                </table>
                <!-- /.table -->
              
              <!-- /.mail-box-messages -->
            </div>
            <!-- /.card-body -->
            <div class="card-footer p-0">
              <div class="mailbox-controls">
                <!-- Check all button -->
                
                <div class="float-right" style="margin-right:320px">
                <a href="ecrireMessageE" class="btn btn-primary btn-block mb-3"><i class="fas fa-feather-alt"></i> Ecrire message</a>
                  
                  
                  <!-- /.btn-group -->
                </div>
                <!-- /.float-right -->
              </div>
            </div>
          </div>
          <!-- /.card -->
        </div>
        <!-- /.col -->
      
      <!-- /.row -->
    </section>
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
