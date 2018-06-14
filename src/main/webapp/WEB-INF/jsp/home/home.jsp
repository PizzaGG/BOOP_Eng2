<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <html>

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>BOOP</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
      crossorigin="anonymous">
    <link rel="stylesheet" href="https://bootswatch.com/4/simplex/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/css/style.css "/>">
  </head>

  <body>

    <%-- 					<img src="<c:url value="/img/perfil.jpg"/>" alt="..."> --%>

      <nav class="navbar navbar-expand-sm navbar-light bg-light d-lg-none">
        <div class="container">
          <div class="d-flex align-items-center">
            <div class="navbar-profile-pic-div rounded-circle bg-dark-1">
              <!-- <h5 class="m-0">F</h5> -->
              <img src="<c:url value="/img/perfil.jpg "/>" class="navbar-profile-pic rounded-circle" alt="Jo�o Silva">
            </div>
            <a class="navbar-brand ml-3" href="#">Joao Silva</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#hidden-menu" aria-controls="hidden-menu"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="hidden-menu">
            <ul class="navbar-nav mt-1">
              <li class="nav-item">
                <a class="nav-link text-primary" href="#">
                  <i class="fas fa-user mr-2"></i> Meu perfil</a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-primary" href="#">
                  <i class="fas fa-book mr-2"></i> Livros</a>
              </li>
              <li class="nav-item">
                <a class="nav-link text-primary" href="#">
                  <i class="fas fa-exchange-alt mr-2"></i> Trocas</a>
              </li>
              <div class="dropdown-divider"></div>
              <li class="nav-item">
                <a class="nav-link text-primary" href="../BOOP_Eng2/sair">
                  <i class="fas fa-sign-out-alt mr-2"></i> Sair</a>
              </li>
            </ul>
          </div>
      </nav>

      <nav class="navbar navbar-light bg-light pesquisa-pequeno">
        <div class="container w-100 p-0">
          <div class="py-2 w-100">
            <form>
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Digite o nome de um livro">
                <div class="input-group-append">
                  <button class="btn btn-outline-secondary" type="submit">
                    <i class="fas fa-search mr-1"></i>
                    </a>
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </nav>

      <!-- BG ANIMATION -->
      <div class="animating-bg">
        <div class="container py-5">
          <div class="row w-100 justify-content-center">
            <!-- LOGO -->
            <div class="logo bg-dark"></div>
          </div>
        </div>
      </div>

      <div class="container">
        <div class="row">
          <div class="col-lg-8">
            <div class="card py-1 px-3">
              <div class="card-body">
                <!-- BOOK SECTION -->
                <h2 class="card-title py-3">Meus livros</h2>

                <div class="container">
                  <div class="row">
                    <div class="col-md-4 col-sm-6 py-2">
                      <div class="card shadow-sm">
                        <div class="capa-livro-card">
                          <img class="card-img-top capa-livro-card-img" src="<c:url value="/img/book1.jpg "/>" alt="Card image cap">
                        </div>
                        <div class="card-body">
                          <h5 class="card-title">Livro Um</h5>
                          <p class="card-text">
                            Autor: Fulano de tal
                            <br> ISBN: 0000000000000
                          </p>
                          <a href="#" class="card-link float-right">Editar</a>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-4 col-sm-6 py-2">
                      <div class="card shadow-sm">
                        <div class="capa-livro-card">
                          <img class="card-img-top capa-livro-card-img" src="<c:url value="/img/book2.jpg "/>" alt="Card image cap">
                        </div>
                        <div class="card-body">
                          <h5 class="card-title">Livro Dois</h5>
                          <p class="card-text">
                            Autor: Aquele Beltrano
                            <br> ISBN: 0000000000000
                          </p>
                          <a href="#" class="card-link float-right">Editar</a>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-4 col-sm-6 py-2">
                      <div class="card shadow-sm">
                        <div class="capa-livro-card">
                          <img class="card-img-top capa-livro-card-img" src="<c:url value="/img/book3.jpg "/>" alt="Card image cap">
                        </div>
                        <div class="card-body">
                          <h5 class="card-title">Livro Tres</h5>
                          <p class="card-text">
                            Autor: Sicraninho
                            <br> ISBN: 0000000000000
                          </p>
                          <a href="#" class="card-link float-right">Editar</a>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="card-body d-flex justify-content-end">
                  <a href="../BOOP_Eng2/cadastro">
                    <button type="button" class="btn btn-secondary mr-2">Cadastrar livro</button>
                  </a>
                  <button type="button" class="btn btn-primary">Todos os livros</button>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-4 d-none d-lg-block">
            <div class="card w-100 d-flex py-4">
              <div class="card-body w-100 pt-3 d-flex flex-column align-items-center">
                <!-- SIDEBAR PROFILE PIC -->
                <div class="sidebar-profile-pic-div rounded-circle mb-4 bg-dark- d-flex justify-content-center">
                  <!-- <h5 class="m-0">F</h5> -->
                  <img src="<c:url value="/img/perfil.jpg "/>" class="sidebar-profile-pic" alt="João Silva">
                </div>

                <!-- SIDEBAR PROFILE NAME -->
                <h3>
                  <strong>${usuarioLog.getUsuario().nome} </strong>
                </h3>
                <h6 class="text-muted text-uppercase">asdasdasd</h6>

                <form class="mt-3">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Digite o nome de um livro">
                    <div class="input-group-append">
                      <button class="btn btn-outline-secondary" type="submit">
                        <i class="fas fa-search mr-1"></i> Pesquisar</a>
                      </button>
                    </div>
                  </div>
                </form>

                <!-- SIDEBAR NAV -->
                <ul class="nav nav-pills flex-column w-100 mt-3">
                  <li class="nav-item side-item rounded">
                    <a class="nav-link" href="../BOOP_Eng2/user">
                      <i class="fas fa-user mr-2"></i> Meu perfil</a>
                  </li>
                  <li class="nav-item side-item rounded">
                    <a class="nav-link" href="#">
                      <i class="fas fa-book mr-2"></i> Livros</a>
                  </li>
                  <li class="nav-item side-item rounded">
                    <a class="nav-link" href="#">
                      <i class="fas fa-exchange-alt mr-2"></i> Trocas</a>
                  </li>
                  <div class="dropdown-divider"></div>
                  <li class="nav-item side-item rounded">
                    <a class="nav-link" href="../BOOP_Eng2/logout">
                      <i class="fas fa-sign-out-alt mr-2"></i> Sair</a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>

      <footer class="container text-center py-4 mt-2">
        <p>BOOP &copy; 2018</p>
      </footer>

      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
      <script src="<c:url value="/js/app.js "/>"></script>

  </body>

  </html>