<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Usuario</title>
</head>
<body>

<!-- Ojo:
        Si 
 -->

<s:form action="registrarUsuario" namespace="/usuario">

          <s:textfield label="Usuario"    name="usuario.usuario"/>
          <s:textfield label="Contrase�a" name="usuario.clave"/>
          <s:textfield label="Nombre"     name="usuario.nombre"/>
          <s:textfield label="Apellido"   name="usuario.apellido"/>
          <s:textfield label="Fecha de Acceso" name="usuario.fechaAcceso" title="MM/dd/yyyy"/>
          
          <s:select list="listadoEstados" label="Estado" name="usuario.estado.idEstado" listKey="idEstado" listValue="descripcion"/>
          
          
          
          
          <s:submit value="Registrar"/>
          <s:reset value="Limpiar"/>

</s:form>







</body>
</html>