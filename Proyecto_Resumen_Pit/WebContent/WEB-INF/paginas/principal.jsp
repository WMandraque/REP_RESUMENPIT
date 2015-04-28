<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Principal</title>
</head>
<body>

<s:actionmessage/>

<table>
<tr>
  <td> <s:a action="registrarUsuario_v1.jsp">Registrar Usuario</s:a></td>
  <td> <s:a action="">Actualizar Usuario</s:a>
  <td> <s:a action="listarUsuario">Listar Usuario</s:a>
</tr>
</table>





</body>
</html>