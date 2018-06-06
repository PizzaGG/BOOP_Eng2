<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="modelo.academico.*, java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <c:import url="/jsp/header.jsp" />

        <body>
          <c:import url="/jsp/navbar.jsp" />

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
                  <button type="submit" class="btn btn-primary float-right">Cadastrar</button>
                  <button type="button" class="btn btn-secondary mr-2 float-right">Cancelar</button>
                  </fieldset>
                </form>
              </div>
            </div>

            <c:import url="/jsp/footer.jsp" />