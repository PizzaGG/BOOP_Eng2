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
                <img src="<c:url value="/imagem/usuario/${usuarioLog.getUsuario().id}"/>"
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
                <li class="nav-item"><a
                    class="nav-link text-primary"
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
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="card py-1 px-3">
                    <div class="card-body">
                        <!-- BOOK SECTION -->
                        <h2 class="card-title py-3">Minhas trocas</h2>

                        <div class="container">
                            <div class="row">
                                <div class="col-12 py-2">
                                    	<c:if test="${!trocasOrig.isEmpty()}">
									    	PEDIDOS PARA MIM
							            </c:if>
                                    	<c:forEach var="troca" items="${trocasOrig}">
									    	<c:if test="${troca.statusDoPedido == 'SOLICITADO'}">
									    		<form action="aceitarTroca" method="post">
								            		<div class="card shadow-sm mb-3">
			                                            <div class="card-body">
			                                                <h5 class="card-title">Pedido de troca <span class="badge badge-warning ml-2">Em andamento</span></h5>
			                                                <p class="card-text">
			                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
			                                                    <strong>Proprietário do livro:</strong> Eu <br/>
			                                                    <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/>
			                                                </p>
			                                                <input type="hidden" name="troca" value="${troca.id}">
			                                                <button type="submit"
			                                                    class="btn float-right btn-primary">Aceitar
			                                                    troca</button>
			                                    </form>
			                                    <form action="cancelarTroca" method="post">
			                                    	<input type="hidden" name="troca" value="${troca.id}">
			                                    	<button type="submit"
			                                                class="btn float-right btn-outline-primary mr-2">Recusar troca</button>
			                                    </form>
			                                            </div>
			                                        </div>
							            	</c:if>
							            	<c:if test="${troca.statusDoPedido == 'AGUARDANDO_CONFIRMACAO_AMBOS' || troca.statusDoPedido == 'AGUARDANDO_CONFIRMACAO_ORIG'}">
							            	<form action="confirmarTroca" method="post">
								            		<div class="card shadow-sm mb-3">
			                                            <div class="card-body">
			                                                <h5 class="card-title">Pedido de troca <span class="badge badge-success ml-2">Troca realizada</span><span class="badge badge-danger ml-2">A confirmar recebimento</span></h5>
			                                                <p class="card-text">
			                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
			                                                    <strong>Proprietário do livro:</strong> Eu <br/>
			                                                    <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/>
			                                                </p>
			                                    			<input type="hidden" name="troca" value="${troca.id}">
			                                                <button type="submit"
			                                                    class="btn float-right btn-primary">Confirmar envio</button>
			                                            </div>
			                                        </div>
							            	</form>
							            	</c:if>
							            	<c:if test="${troca.statusDoPedido == 'AGUARDANDO_CONFIRMACAO_DEST'}">
								            		<div class="card shadow-sm mb-3">
			                                            <div class="card-body">
			                                                <h5 class="card-title">Pedido de troca <span class="badge badge-success ml-2">Troca realizada</span><span class="badge badge-danger ml-2">A confirmar recebimento</span></h5>
			                                                <p class="card-text">
			                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
			                                                    <strong>Proprietário do livro:</strong> Eu <br/>
			                                                    <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/>
			                                                </p>
			                                    			<input type="hidden" name="troca" value="${troca.id}">
			                                                <button type="button"
			                                                    class="btn float-right btn-primary" disabled>Aguardando confirmação</button>
			                                            </div>
			                                        </div>
							            	</c:if>
							            	<c:if test="${troca.statusDoPedido == 'APROVADO'}">
								            	<div class="card shadow-sm mb-3">
		                                            <div class="card-body">
		                                                <h5 class="card-title">Pedido de troca <span class="badge badge-success ml-2">Troca finalizada</span></h5>
		                                                <p class="card-text">
		                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
			                                                <strong>Proprietário do livro:</strong> Eu <br/>
			                                                <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/>
		                                                </p>
		                                            </div>
		                                        </div>
							            	</c:if>
							            	<c:if test="${troca.statusDoPedido == 'CANCELADO'}">
								            	<div class="card shadow-sm mb-3">
		                                            <div class="card-body">
		                                                <h5 class="card-title">Pedido de troca <span class="badge badge-danger ml-2">Troca cancelada</span></h5>
		                                                <p class="card-text">
		                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
			                                                <strong>Proprietário do livro:</strong> Eu <br/>
			                                                <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/>
		                                                </p>
		                                            </div>
		                                        </div>
							            	</c:if>
							            </c:forEach>
							            <c:if test="${!trocasDest.isEmpty()}">
									    	MEUS PEDIDOS
							            </c:if>
							            <c:forEach var="troca" items="${trocasDest}">
									    	<c:if test="${troca.statusDoPedido == 'SOLICITADO'}">
									    	<form action="cancelarTroca" method="post">
									            	<div class="card shadow-sm mb-3">
			                                            <div class="card-body">
			                                                <h5 class="card-title">Pedido de troca <span class="badge badge-info ml-2">Aguardando aceitação</span></h5>
			                                                <p class="card-text">
			                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
			                                                    <strong>Proprietário do livro:</strong> ${troca.getOriginario().nome} <br/>
			                                                    <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/>
			                                                </p>
			                                    		   <input type="hidden" name="troca" value="${troca.id}">
			                                               <button type="submit"
			                                                    class="btn float-right btn-outline-primary">Cancelar troca</button>
			                                            </div>
			                                        </div>
									    	</form>
	                                        </c:if>
	                                        <c:if test="${troca.statusDoPedido == 'AGUARDANDO_CONFIRMACAO_AMBOS' || troca.statusDoPedido == 'AGUARDANDO_CONFIRMACAO_DEST'}">
		                                        <form action="confirmarTroca" method="post">
									            		<div class="card shadow-sm mb-3">
				                                            <div class="card-body">
				                                                <h5 class="card-title">Pedido de troca <span class="badge badge-success ml-2">Troca realizada</span><span class="badge badge-danger ml-2">A confirmar recebimento</span></h5>
				                                                <p class="card-text">
				                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
				                                                    <strong>Proprietário do livro:</strong> ${troca.getOriginario().nome} <br/>
				                                                    <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/><br/>
				                                                    <strong>Contato para troca:</strong><br/>
				                                                    <strong>Email:</strong> ${troca.getOriginario().email}
				                                                </p>
				                                    			<input type="hidden" name="troca" value="${troca.id}">
				                                                <button type="submit"
				                                                    class="btn float-right btn-primary">Confirmar recebimento</button>
				                                            </div>
				                                        </div>
								            	</form>
	                                        </c:if>
							            	<c:if test="${troca.statusDoPedido == 'AGUARDANDO_CONFIRMACAO_ORIG'}">
								            		<div class="card shadow-sm mb-3">
			                                            <div class="card-body">
			                                                <h5 class="card-title">Pedido de troca <span class="badge badge-success ml-2">Troca realizada</span><span class="badge badge-danger ml-2">A confirmar recebimento</span></h5>
			                                                <p class="card-text">
			                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
			                                                    <strong>Proprietário do livro:</strong> ${troca.getOriginario().nome} <br/>
			                                                    <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/>
			                                                </p>
			                                    			<input type="hidden" name="troca" value="${troca.id}">
			                                                <button type="submit"
			                                                    class="btn float-right btn-primary" disabled>Aguardando confirmação</button>
			                                            </div>
			                                        </div>
							            	</c:if>
	                                        <c:if test="${troca.statusDoPedido == 'APROVADO'}">
								            	<div class="card shadow-sm mb-3">
		                                            <div class="card-body">
		                                                <h5 class="card-title">Pedido de troca <span class="badge badge-success ml-2">Troca finalizada</span></h5>
		                                                <p class="card-text">
		                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
			                                                <strong>Proprietário do livro:</strong> ${troca.getOriginario().nome} <br/>
			                                                <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/>
		                                                </p>
		                                            </div>
		                                        </div>
							            	</c:if>
							            	<c:if test="${troca.statusDoPedido == 'CANCELADO'}">
								            	<div class="card shadow-sm mb-3">
		                                            <div class="card-body">
		                                                <h5 class="card-title">Pedido de troca <span class="badge badge-danger ml-2">Troca cancelada</span></h5>
		                                                <p class="card-text">
		                                                    <strong>Solicitante:</strong> ${troca.getDestinatario().nome} <br/>
			                                                <strong>Proprietário do livro:</strong> ${troca.getOriginario().nome} <br/>
			                                                <strong>Livro solicitado:</strong> ${troca.getLivroSolicitado().titulo} <br/>
		                                                </p>
		                                            </div>
		                                        </div>
							            	</c:if>
							            </c:forEach>
                                        <!-- <div class="card shadow-sm mb-3">
                                            <div class="card-body">
                                                <h5 class="card-title">Pedido de troca <span class="badge badge-warning ml-2">Em andamento</span></h5>
                                                <p class="card-text">
                                                    <strong>Solicitante:</strong> Fulano <br/>
                                                    <strong>Livro de fulano:</strong> A escolher <br/>
                                                    <strong>Meu livro:</strong> Nome Livro
                                                    <br />
                                                </p>
                                                <button type="submit"
                                                    class="btn float-right btn-primary">Continuar
                                                    troca</button>
                                                <button type="submit"
                                                    class="btn float-right btn-outline-primary mr-2">Recusar troca</button>
                                            </div>
                                        </div>
                                        <div class="card shadow-sm mb-3">
                                            <div class="card-body">
                                                <h5 class="card-title">Solicitação ou Pedido de troca <span class="badge badge-info ml-2">Aguardando solicitante</span></h5>
                                                <p class="card-text">
                                                    <strong>Solicitante:</strong> Eu <br/>
                                                    <strong>Livro de fulano:</strong> Nome livro <br/>
                                                    <strong>Meu livro:</strong> A escolher
                                                    <br />
                                                </p>
                                               <button type="submit"
                                                    class="btn float-right btn-outline-primary">Recusar troca</button>
                                            </div>
                                        </div>
                                        <div class="card shadow-sm mb-3">
                                            <div class="card-body">
                                                <h5 class="card-title">Solicitação ou Pedido de troca <span class="badge badge-success ml-2">Troca realizada</span><span class="badge badge-danger ml-2">A confirmar recebimento</span></h5>
                                                <p class="card-text">
                                                    <strong>Solicitante:</strong> Fulano <br/>
                                                    <strong>Livro de fulano:</strong> NomeLivro <br/>
                                                    <strong>Meu livro:</strong> NomeLivro
                                                </p>
                                                <button type="submit"
                                                    class="btn float-right btn-primary">Confirmar recebimento</button>
                                            </div>
                                        </div>
                                        <div class="card shadow-sm mb-3">
                                            <div class="card-body">
                                                <h5 class="card-title">Solicitação ou Pedido de troca <span class="badge badge-success ml-2">Troca finalizada</span></h5>
                                                <p class="card-text">
                                                    <strong>Solicitante:</strong> Fulano <br/>
                                                    <strong>Livro de fulano:</strong> NomeLivro <br/>
                                                    <strong>Meu livro:</strong> NomeLivro
                                                </p>
                                            </div>
                                        </div> -->
                                </div>
                            </div>
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
                            <img src="<c:url value="/imagem/usuario/${usuarioLog.getUsuario().id} "/>"
                                class="sidebar-profile-pic">
                        </div>

                        <!-- SIDEBAR PROFILE NAME -->
                        <h3>
                            <strong>${usuarioLog.getUsuario().nome}</strong>
                        </h3>
                        <h6 class="text-muted text-uppercase">${usuarioLog.getUsuario().booPoint.getQuantidade()}
                            Boopoints</h6>

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