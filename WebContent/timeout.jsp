<%
	if(request.getSession().getAttribute("objUsuarioSS") == null){
		response.sendRedirect("expira.jsp");
	}
%>