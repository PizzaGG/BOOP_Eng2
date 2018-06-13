<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>BOOP: Entrar</title>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://bootswatch.com/4/simplex/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>

<body>

	<!-- CODIGO QUE GERA MENSAGEM NA VIEW -->	
	<div class="container" style="padding-left: 30px !important;">
		<div class="row">
			<div class="col-md-9 mx-auto" style="padding-top: 22px;">
				<c:if test="${msg.getMessagesList().size() > 0}">
					<c:forEach var="mensagem" items="${msg.getMessagesList()}">
						<div class="alert alert-warning" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong> <fmt:message key="${mensagem.category}" /></strong>
							<fmt:message key="${mensagem.message}" />
						</div> 
					</c:forEach>
				</c:if>
				${msg.clear()}
			</div>
		</div>
	</div>







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
						<h4 class="card-title">Autentica��o</h4>
						<form action="auth" method="post" class="mt-3">
							<div class="form-group">
								<label for="usuario">Matricula</label> <input type="text"
									name="usuario" class="form-control" id="usuario"
									placeholder="Digite sua matricula">
							</div>
							<div class="form-group">
								<label for="senha">Senha</label> <input type="password"
									name="senha" class="form-control" id="senha"
									placeholder="Digite sua senha">
							</div>
							<button type="button" class="px-0 btn btn-link">Esqueci
								minha senha</button>
							<button type="submit" class="btn btn-primary float-right">Entrar</button>
						</form>
					</div>
				</div>
				<hr>
				<a href="../BOOP_Eng2/cadastroUsuario"><button type="button"
						class="btn btn-outline-primary btn-lg btn-block">Cadastrar</button></a>
			</div>
		</div>
	</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script> -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
	<script src="<c:url value="/js/app.js"/>"></script>

</body>

</html>