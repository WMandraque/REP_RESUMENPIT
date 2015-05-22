<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Usuario</title>
</head>
<body>

<s:form action="actualizarUsuario" method="post">

          <s:textfield label="Usuario"    name="usuario.usuario"/>
          <s:textfield label="Contraseña" name="usuario.clave"/>
          <s:textfield label="Nombre"     name="usuario.nombre"/>
          <s:textfield label="Apellido"   name="usuario.apellido"/>
          <s:textfield label="Fecha de Acceso" name="usuario.fechaAcceso" title="MM/dd/yyyy"/>
          <s:select label="Estado" list="listadoEstados" name="usuario.estado.idEstado" listKey="idEstado" listValue="descripcion"/>
          <s:submit value="Actualizar"/>
          <s:reset value="Limpiar"/>

</s:form>

<s:actionmessage/>
<s:actionerror/>




</body>
</html>