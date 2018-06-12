<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>BOOP: Cadastro</title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
      crossorigin="anonymous">
    <link rel="stylesheet" href="https://bootswatch.com/4/simplex/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value=" /css/style.css "/>">
  </head>

  <body>
    <!-- BG ANIMATION -->
    <div class="container py-5">
      <div class="row w-100 justify-content-center">
        <!-- LOGO -->
        <div class="logo-xl bg-dark"></div>
      </div>
      <div class="row justify-content-center mt-5">
        <div class="col-md-7 col-lg-5 col-xl-4">
          <div class="card">
            <div class="card-body">
              <h4 class="card-title">Cadastro</h4>
              <form action="cadastroUsuario" class="mt-3">
                <div class="form-group">
                  <label for="usuario">Usuário</label>
                  <input type="text" class="form-control" id="usuario" placeholder="Digite seu usuário">
                </div>
                <div class="form-group">
                  <label for="nome">Nome</label>
                  <input type="text" class="form-control" id="nome" placeholder="Digite seu nome">
                </div>
                <div class="form-group">
                  <label for="email">Email</label>
                  <input type="email" class="form-control" id="email" placeholder="Digite seu email">
                </div>
                <div class="form-group">
                  <label for="matricula">Matricula</label>
                  <input type="text" class="form-control" id="matricula" placeholder="Digite sua matricula">
                </div>  
                <div class="form-group">
                  <label for="senha">Senha</label>
                  <input type="password" class="form-control" id="senha" placeholder="Digite sua senha">
                </div>
                <div class="form-group">
                  <label for="senhaConfirmacao">Confirme sua senha</label>
                  <input type="password" class="form-control" id="senhaConfirmacao" placeholder="Digite sua senha novamente">
                </div>
                <button type="submit" class="btn btn-primary float-right">Cadastrar</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"></script>
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script> -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
      crossorigin="anonymous"></script>
    <script src="<c:url value=" /js/app.js "/>"></script>

  </body>

  </html>