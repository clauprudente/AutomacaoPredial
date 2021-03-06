package br.usjt.arqdsis.sisPredial.Core;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdsis.sisPredial.DAO.AbstractDao;
import br.usjt.arqdsis.sisPredial.Models.Empresa;
import br.usjt.arqdsis.sisPredial.Models.IEntidade;

public class FachadeUsuario extends AbstractFachade {

	public FachadeUsuario() {
		super();
	}
	
	@Override
	public RequestDispatcher createPage(HttpServletRequest request, HttpServletResponse response) {
		AbstractDao dao = factoryDao.criar(new Empresa());
		request.setAttribute("empresas", dao.consultarTodos(null));
		request.setAttribute("_metodo","post");
		return request.getRequestDispatcher(factoryDispacherPath.criar(factoryViewHelper.criar(request).criar(request)).postPage());
	}

	@Override
	public RequestDispatcher updatePage(HttpServletRequest request, HttpServletResponse response) {
		AbstractDao dao = factoryDao.criar(new Empresa());
		request.setAttribute("empresas", dao.consultarTodos(null));
		IEntidade entidade = factoryViewHelper.criar(request).criar(request);
		dao = factoryDao.criar(entidade);
		entidade = (IEntidade) dao.consultar(entidade);
		request.setAttribute("entidade", entidade);
		request.setAttribute("_metodo","put");
		return request.getRequestDispatcher(factoryDispacherPath.criar(entidade).putPage());
	}

	
	
	
}
