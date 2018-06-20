<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>BOOP: Livro</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
      crossorigin="anonymous">
    <link rel="stylesheet" href="https://bootswatch.com/4/simplex/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/css/style.css "/>">
  </head>

  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
        <a href="../BOOP_Eng2/home">
          <div class="nav-logo logo bg-dark my-1"></div>
        </a>

        <div class="col-7 pesquisa-grande">
          <form action="../BOOP_Eng2/pesquisar" method="post">
            <div class="input-group">
              <input type="text" name="termo" class="form-control" placeholder="Digite algo">
              <div class="input-group-append">
                <button class="btn btn-outline-secondary d-flex align-items-center" type="submit">
                  <i class="fas fa-search"></i>
                  <span class="pesquisa-nome ml-2">Pesquisar</span>
                  </a>
                </button>
              </div>
            </div>
          </form>
        </div>

        <div class="navbar-profile d-flex">
          <ul class="nav nav-pills">
            <div class="navbar-profile-pic-div rounded-circle bg-dark-1">
              <img src="<c:url value="/img/perfil.jpg "/>" class="navbar-profile-pic" alt="João Silva">
            </div>
            <li class="nav-item dropdown">
              <button type="button" class="btn btn-link text-black">
                ${usuarioLog.getUsuario().nome}
              </button>
              <a class="text-black" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                <i class="fas fa-caret-down"></i>
              </a>
                <div class="dropdown-menu mt-2">
                    <a class="dropdown-item" href="../BOOP_Eng2/user"> <i
                            class="fas fa-user mr-2"></i> Meu perfil
                    </a> <a class="dropdown-item"
                            href="../BOOP_Eng2/mybooks"> <i
                            class="fas fa-book mr-2"></i> Livros
                    </a> <a class="dropdown-item" href="#"> <i
                            class="fas fa-exchange-alt mr-2"></i> Trocas
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="../BOOP_Eng2/sair"> <i
                            class="fas fa-sign-out-alt mr-2"></i> Sair
                    </a>
                </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <nav class="navbar navbar-light bg-light pesquisa-pequeno">
      <div class="container w-100 p-0">
        <div class="py-2 w-100">
          <form action="../BOOP_Eng2/pesquisar" method="post">
            <div class="input-group">
              <input type="text" name="termo" class="form-control" placeholder="Digite algo">
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

    <div class="my-4"></div>

    <div class="container">
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="../BOOP_Eng2/home">Inicio</a>
        </li>
        <li class="breadcrumb-item">
          <a href="../BOOP_Eng2/mybooks">Todos os livros</a>
        </li>
        <li class="breadcrumb-item active">Livro</li>
      </ol>
      <div class="card">
        <div class="card-body">
          <h4 class="card-title">Livro</h4>
          <form class="mt-4">
            <div class="row">
              <div class="col-md-3">
                <fieldset>
                  <div class="form-group">
                    <div class="mr-auto bg-dark-1 capa mb-3 rounded "></div>
                    <label for="capaLivro">Capa do livro</label>
                    <div class="input-group mb-3 inputFile d-none">
                      <input type="file" class="custom-file-input" id="capaLivro">
                      <label class="custom-file-label" for="capaLivro">Escolher arquivo</label>
                    </div>
                  </div>
                </fieldset>
              </div>
              <div class="col-md-9">
                <fieldset>
                  <div class="row">
                    <div class="form-group col-md-6">
                      <label class="col-form-label" for="tituloLivro">Titulo do livro</label>
                      <input type="text" class="form-control inputEdit" placeholder="Titulo do livro" id="tituloLivro" disabled>
                    </div>
                    <div class="form-group col-md-6">
                      <label class="col-form-label" for="subtituloLivro">Subtitulo do livro</label>
                      <input type="text" class="form-control inputEdit" placeholder="Subtitulo do livro" id="subtituloLivro" disabled>
                    </div>
                  </div>
                  <div class="form-group">
                    <label class="col-form-label" for="autorLivro">Autor</label>
                    <input type="text" class="form-control inputEdit" placeholder="Autor" id="autorLivro" disabled>
                  </div>
                  <div class="row">
                    <div class="form-group col-md-4">
                      <label class="col-form-label" for="anoLivro">Ano</label>
                      <input type="text" class="form-control inputEdit" placeholder="Ano" id="anoLivro" disabled>
                    </div>
                    <div class="form-group col-md-4">
                      <label class="col-form-label" for="edicaoLivro">Edicao</label>
                      <input type="text" class="form-control inputEdit" placeholder="Edicao" id="edicaoLivro" disabled>
                    </div>
                    <div class="form-group col-md-4">
                      <label class="col-form-label" for="isbnLivro">ISBN</label>
                      <input type="text" class="form-control inputEdit" placeholder="ISBN" id="isbnLivro" disabled>
                    </div>
                  </div>
                </fieldset>
              </div>
            </div>
            <button id="editarBtn" type="button" class="btn btn-primary float-right">Editar dados</button>
            <button type="submit" class="btn btn-primary float-right d-none">Salvar</button>
            <button id="cancelarBtn" type="button" class="btn btn-secondary mr-2 float-right d-none">Cancelar</button>
            <button id="excluirBtn" type="button" class="btn btn-outline-primary mr-2 float-right d-none">Excluir livro</button>
            </fieldset>
          </form>
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