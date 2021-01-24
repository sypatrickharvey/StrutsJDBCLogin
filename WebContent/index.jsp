
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request != null)
    {
        response.sendRedirect(request.getContextPath() + "/LoginView.do");
        return;
    }
%>