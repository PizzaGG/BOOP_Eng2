<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>BOOP</title>

  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
    crossorigin="anonymous">
  <link rel="stylesheet" href="https://bootswatch.com/4/simplex/bootstrap.min.css">
  <link rel="stylesheet" href="../../../css/style.css">
</head>

<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
      <!-- <a class="navbar-brand" href="#">Boop</a> -->
      <img src="../../../img/boop.svg" class="nav-logo my-1 mr-3" alt="">

      <div class="navbar-profile">
        <ul class="nav nav-pills">
          <div class="navbar-profile-pic-div rounded-circle bg-dark-1">
            <!-- <h5 class="m-0">F</h5> -->
            <img src="../../../img/perfil.jpg" class="navbar-profile-pic" alt="João Silva">
          </div>
          <li class="nav-item dropdown">
            <button type="button" class="btn btn-link text-black">
              João Silva
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
      <li class="breadcrumb-item active">Cadastrar livro</li>
    </ol>
    <div class="card">
      <div class="card-body">
        <h4 class="card-title">Cadastrar livro</h4>

        <form class="mt-4">
          <!-- <div class="alert alert-dismissible alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <p class="mb-0">Livro adicionado com sucesso</p>
          </div> -->
          <div class="row">
            <div class="col-md-3">
              <fieldset>
                <div class="form-group">
                  <div class="mr-auto bg-dark-1 capa mb-3 rounded "></div>
                  <label for="capaLivro">Capa do livro</label>
                  <div class="input-group mb-3">
                    <input type="file" class="custom-file-input" id="capaLivro">
                    <label class="custom-file-label" for="capaLivro">Escolher arquivo</label>
                  </div>
                </div>
              </fieldset>
            </div>
            <div class="col-md-9">
              <fieldset>
                <div class="form-group">
                  <label class="col-form-label" for="nomeLivro">Nome do livro</label>
                  <input type="text" class="form-control" placeholder="Nome do livro" id="nomeLivro">
                </div>
                <div class="form-group">
                  <label class="col-form-label" for="autorLivro">Autor</label>
                  <input type="text" class="form-control" placeholder="Autor" id="autorLivro">
                </div>
                <div class="form-group">
                  <label class="col-form-label" for="isbnLivro">ISBN</label>
                  <input type="text" class="form-control" placeholder="ISBN" id="isbnLivro">
                </div>
              </fieldset>
            </div>
          </div>
          <a href="../BOOP_Eng2/cadastrar">
            <button type="submit" class="btn btn-primary float-right">Cadastrar</button>
          </a>
          <a href="../BOOP_Eng2/index">
          	<button type="button" class="btn btn-secondary mr-2 float-right">Cancelar</button>
          </a>
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
    <script src="../../../js/app.js"></script>

</body>

</html>