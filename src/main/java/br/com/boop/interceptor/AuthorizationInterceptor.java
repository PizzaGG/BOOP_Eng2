package br.com.boop.interceptor;

import javax.inject.Inject;

import br.com.boop.controller.CadastroController;
import br.com.boop.controller.LoginController;
import br.com.boop.controller.MessagesController;
import br.com.boop.model.BoopMessage;
import br.com.boop.model.Usuario;
import br.com.boop.model.UsuarioLogado;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.validator.Severity;

@Intercepts
public class AuthorizationInterceptor {

	@Inject
	private UsuarioLogado info;

	@Inject
	private Result result;

	private String t;

	@Accepts
	public boolean accepts(ControllerMethod method) {
		t = method.getMethod().toString();
		if (t.contains("login") || t.contains("cadast") || info.getUsuario() != null)
			return false;

		System.out.println(method.getMethod());
		System.out.println(!method.containsAnnotation(Public.class));
		return !method.containsAnnotation(Public.class);
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		Usuario current = info.getUsuario();
		if (current == null) {
			if (!t.contains("cadastro")) {
				MessagesController.addMessage(new BoopMessage("error", "user.is.not.logged.in", Severity.ERROR));
				result.redirectTo(LoginController.class).login();
				return;
			} else {
				result.redirectTo(CadastroController.class).cadastrarUsuario();
				return;
			}
		}
		stack.next();
	}

}
