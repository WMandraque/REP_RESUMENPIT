<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="javascript" type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script  src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/sha1.js"></script>
<script language="javascript" type="text/javascript" src="js/loguin.js"></script>

<title>Logueo</title>
</head>
<body>

<fieldset>
<s:form action="validaLogueo2" method="post">

<legend>Logueo</legend>

<table>

<tr>
	<s:textfield label="Usuario: " name="usuario.usuario" id="txtUsuario" />
	<s:password label="Contraseña: " name="usuario.clave" id="txtPassword" />
</tr>

<tr>
    <td>
     <div align="left">
        <input type="button" value="Ingresar" id="btnLoguin" />
     </div>
   </td>
</tr>


</table>


</s:form>
</fieldset>



</body>
</html>