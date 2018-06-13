<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>BOOP: Perfil</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
      crossorigin="anonymous">
    <link rel="stylesheet" href="https://bootswatch.com/4/simplex/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
  </head>

  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
        <!-- <a class="navbar-brand" href="#">Boop</a> -->
        <img src="<c:url value="/img/boop.svg"/>" class="nav-logo my-1 mr-3" alt="">

        <div class="navbar-profile">
          <ul class="nav nav-pills">
            <div class="navbar-profile-pic-div rounded-circle bg-dark-1">
              <!-- <h5 class="m-0">F</h5> -->
              <img src="<c:url value="/img/perfil.jpg"/>" class="navbar-profile-pic" alt="Joao Silva">
            </div>
            <li class="nav-item dropdown">
              <button type="button" class="btn btn-link text-black">
                Joao Silva
              </button>
              <a class="text-black" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-caret-down"></i>
              </a>
              <div class="dropdown-menu mt-2">
                <a class="dropdown-item" href="#">
                  <i class="fas fa-user mr-2"></i> Meu perfil</a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-book mr-2"></i> Livros</a>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-exchange-alt mr-2"></i> Trocas</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">
                  <i class="fas fa-sign-out-alt mr-2"></i> Sair</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="my-5"></div>

    <div class="container">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Início</a>
        </li>
        <li class="breadcrumb-item active">Perfil</li>
      </ol>
      <div class="card">
        <div class="card-body">
          <h4 class="card-title">Perfil</h4>

          <form class="mt-4" action="editarPerfil">
            <div class="row">
              <div class="col-md-3">
                <img src="<c:url value="/img/perfil.jpg"/>" class="img-fluid rounded" alt="Joao Silva">
              </div>
              <div class="col-md-9">
                <fieldset>
                  <div class="row">
                    <div class="form-group col-md-6">
                      <label class="col-form-label" for="usuario">Usuario</label>
                      <input type="text" class="form-control" placeholder="Nome do usuario" id="usuario" disabled>
                    </div>
                    <div class="form-group col-md-6">
                      <label class="col-form-label" for="matricula">Matricula</label>
                      <input type="text" class="form-control" placeholder="Matricula do usuario" id="matricula" disabled>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-form-label" for="nome">Nome</label>
                    <input type="text" class="form-control" placeholder="Nome do usuario" id="nome" disabled>
                  </div>
                  <div class="form-group">
                    <label class="col-form-label" for="email">Email</label>
                    <input type="text" class="form-control" placeholder="Email do usuario" id="email" disabled>
                  </div>
                  <div class="form-group">
                    <label class="col-form-label" for="senha">Senha</label>
                    <input type="password" class="form-control" placeholder="********" id="senha" disabled>
                  </div>
                </fieldset>
              </div>
            </div>
            <button type="submit" class="btn btn-primary float-right">Editar dados</button>
            <!-- <button type="button" class="btn btn-secondary mr-2 float-right">Cancelar</button> -->
            </fieldset>
          </form>
        </div>
      </div>1
    </div>

    <footer class="container text-center py-4 mt-2">
      <p>BOOP &copy; 2018</p>
    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
      crossorigin="anonymous"></script>
    <script src="<c:url value="/js/app.js"/>"></script>

  </body>

</html>