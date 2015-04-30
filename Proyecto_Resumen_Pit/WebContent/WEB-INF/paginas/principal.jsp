<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Principal</title>
</head>
<body>

<!-- Ojo:
        Si deseas mostrar una pagina que va a tener un listado que va a jalar de la base de datos
        y esta es implementada en un action.
        Si es un prepare: crear un action definiendo la clase action!!!
        Si es un metodo X definir la clase action y el metodo quien va a hacer ese listado 
        De lo contrario si no va a mostrar nigun listado, solo redireccionar el jsp
 -->
<s:actionmessage/>

<table>
<tr>
  <td> <s:a action="iniciar">Registrar Usuario</s:a></td><!-- !!!!!!! -->
  <td> <s:a action="">Actualizar Usuario</s:a>
  <td> <s:a action="listarUsuario">Listar Usuario</s:a>
</tr>
</table>





</body>
</html>