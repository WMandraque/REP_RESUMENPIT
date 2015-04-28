<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Logueo</title>


</head>
<body>

<center>
<form action="validarLogueo" method="post" id="fmrLogueo">
<fieldset>
<legend>Loguin</legend>

<table>
<tr>
<td>Usuario: </td>
<td>Password: </td>
</tr>
<tr>
<td><input type="text" name="usuario.usuario" id="txtUsuario"> </td>
<td><input type="password" name="usuario.clave" id="txtClave"> </td>
</tr>
<tr>
   <td>
      <div align="left">
      <input type="submit" value="Ingresar" id="btnLoguin" >
      </div>
</td>

</table>

<s:actionerror/>


</fieldset>
</form>
</center>

</body>
</html>