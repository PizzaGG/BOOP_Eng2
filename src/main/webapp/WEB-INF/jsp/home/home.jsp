<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>BOOP</title>

<link rel="stylesheet"
    href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
    integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
    crossorigin="anonymous">
<link rel="stylesheet"
    href="https://bootswatch.com/4/simplex/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/css/style.css "/>">
</head>

<body>

    <nav class="navbar navbar-expand-sm navbar-light bg-light d-lg-none">
    <div class="container">
        <div class="d-flex align-items-center">
            <div class="navbar-profile-pic-div rounded-circle bg-dark-1">
                <img src="<c:url value="/img/perfil.jpg"/>"
                    class="navbar-profile-pic rounded-circle">
            </div>
            <a class="navbar-brand ml-3" href="#">Joao Silva</a>
        </div>
        <button class="navbar-toggler" type="button"
            data-toggle="collapse" data-target="#hidden-menu"
            aria-controls="hidden-menu" aria-expanded="false"
            aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="hidden-menu">
            <ul class="navbar-nav mt-1">
                <li class="nav-item"><a class="nav-link text-primary"
                    href="../BOOP_Eng2/user"> <i
                        class="fas fa-user mr-2"></i> Meu perfil
                </a></li>
                <li class="nav-item"><a
                    class="nav-link text-primary"
                    href="../BOOP_Eng2/mybooks"> <i
                        class="fas fa-book mr-2"></i> Livros
                </a></li>
                <li class="nav-item"><a
                    class="nav-link text-primary" href="../BOOP_Eng2/troca"> <i
                        class="fas fa-exchange-alt mr-2"></i> Trocas
                </a></li>
                <div class="dropdown-divider"></div>
                <li class="nav-item"><a
                    class="nav-link text-primary"
                    href="../BOOP_Eng2/logout"> <i
                        class="fas fa-sign-out-alt mr-2"></i> Sair
                </a></li>
            </ul>
        </div>
    </nav>

    <nav class="navbar navbar-light bg-light pesquisa-pequeno">
    <div class="container w-100 p-0">
        <div class="py-2 w-100">
            <form action="../BOOP_Eng2/pesquisar" method="post">
                <div class="input-group">
                    <input type="text" name="termo" class="form-control"
                        placeholder="Digite algo">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary"
                            type="submit">
                            <i class="fas fa-search mr-1"></i> </a>
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
            <div class="row w-100 justify-content-center mt-4">
                <div class="col-md-6">
                    <c:if test="${msg.getMessagesList().size() > 0}">
                        <c:forEach var="mensagem"
                            items="${msg.getMessagesList()}">
                            <div class="alert alert-warning"
                                role="alert">
                                <button type="button" class="close"
                                    data-dismiss="alert"
                                    aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                <strong> <fmt:message
                                        key="${mensagem.category}" /></strong>
                                <fmt:message key="${mensagem.message}" />
                            </div>
                        </c:forEach>
                    </c:if>
                    ${msg.clear()}
                </div>
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
                                <c:forEach var="livro" items="${livros}">
                                    <div class="col-md-4 col-sm-6 py-2">
                                        <form action="../BOOP_Eng2/livro" method="post">
                                            <div class="card shadow-sm">
                                                <div class="capa-livro-card">
                                                    <img
                                                        class="card-img-top capa-livro-card-img"
                                                        src="<c:url value="/img/book1.jpg "/>"
                                                        alt="Card image cap">
                                                </div>
                                                <div class="card-body">
                                                    <h5 class="card-title">${livro.titulo}</h5>
                                                    <p class="card-text">
                                                        Autor: ${livro.autor}<br>
                                                        ISBN: ${livro.isbn}
                                                    </p>
                                                    <input type="hidden" name="isbn" value="${livro.isbn}">
                                                    <button type="submit" class="btn float-right btn-link p-0">Editar</button>
                                                </div>
                                            </div>
                                        </form>
                                   </div>
                                </c:forEach>
                            </div>
                        </div>
                        <div
                            class="card-body d-flex justify-content-end">
                            <a href="../BOOP_Eng2/cadbook">
                                <button type="button"
                                    class="btn btn-primary">Cadastrar
                                    livro</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 d-none d-lg-block">
                <div class="card w-100 d-flex py-4">
                    <div
                        class="card-body w-100 pt-3 d-flex flex-column align-items-center">
                        <!-- SIDEBAR PROFILE PIC -->
                        <div
                            class="sidebar-profile-pic-div rounded-circle mb-4 bg-dark- d-flex justify-content-center">
                            <img src="<c:url value="/img/perfil.jpg "/>"
                                class="sidebar-profile-pic">
                        </div>

                        <!-- SIDEBAR PROFILE NAME -->
                        <h3>
                            <strong>${usuarioLog.getUsuario().nome}</strong>
                        </h3>
                        <h6 class="text-muted text-uppercase">${usuarioLog.getUsuario().booPoint.getQuantidade()} Boopoints</h6>

                        <form class="mt-3"
                            action="../BOOP_Eng2/pesquisar"
                            method="post">
                            <div class="input-group">
                                <input type="text" name="termo"
                                    class="form-control"
                                    placeholder="Digite algo">
                                <div class="input-group-append">
                                    <button
                                        class="btn btn-outline-secondary"
                                        type="submit">
                                        <i class="fas fa-search mr-1"></i>
                                        Pesquisar</a>
                                    </button>
                                </div>
                            </div>
                        </form>

                        <!-- SIDEBAR NAV -->
                        <ul class="nav nav-pills flex-column w-100 mt-3">
                            <li class="nav-item side-item rounded"><a
                                class="nav-link"
                                href="../BOOP_Eng2/user"> <i
                                    class="fas fa-user mr-2"></i> Meu
                                    perfil
                            </a></li>
                            <li class="nav-item side-item rounded"><a
                                class="nav-link"
                                href="../BOOP_Eng2/mybooks"> <i
                                    class="fas fa-book mr-2"></i> Livros
                            </a></li>
                            <li class="nav-item side-item rounded"><a
                                class="nav-link" href="../BOOP_Eng2/troca"> <i
                                    class="fas fa-exchange-alt mr-2"></i>
                                    Trocas
                            </a></li>
                            <div class="dropdown-divider"></div>
                            <li class="nav-item side-item rounded"><a
                                class="nav-link"
                                href="../BOOP_Eng2/logout"> <i
                                    class="fas fa-sign-out-alt mr-2"></i>
                                    Sair
                            </a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <footer class="container text-center py-4 mt-2">
    <p>BOOP &copy; 2018</p>
    </footer>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>
    <script src="<c:url value="/js/app.js "/>"></script>

</body>

</html>