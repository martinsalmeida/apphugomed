package br.com.hugomed.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.hugomed.action.ClienteAction;

/**
 * Servlet implementation class ClienteSV
 */
@WebServlet("/ClienteSV")
public class ClienteSV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF=8");
		new ClienteAction().execute(request, response);
	}

	

}
