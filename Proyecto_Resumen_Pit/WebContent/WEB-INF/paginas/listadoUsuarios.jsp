<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>inserte titulo</title>
</head>
<body>


<s:form action="buscarUsuario">

<s:textfield label="Usuario" name="usuario.nombre"/>
<s:submit value="buscar"/>

</s:form>

<s:actionmessage/>

<h2>Listado de usuario</h2>

<s:if test="!listadoUsuarios.isEmpty">

	<table bgcolor="yellow" border="1">
		<tr class="titulos">
			<td>Usuario</td>
			<td>Clave</td>
			<td>Nombre</td>
			<td>Apellido</td>
			<td>Fecha Acceso</td>
			<td>Estado</td>
			<td>Editar</td>
			<td>Eliminar</td>
		</tr>
		<s:iterator value="listadoUsuarios">
		<tr>
			<td><s:property value="usuario"/></td>
			<td><s:property value="clave"/></td>
			<td><s:property value="nombre"/></td>
			<td><s:property value="apellido"/></td>
			<td><s:property value="fechaAcceso"/></td>
			<td><s:if test="estado==1">Disponible</s:if><s:else>No Disponible</s:else>
			<td>
			    <!-- alistamos la preparacion de un action, y le asignamos el id para llamarlo como url -->
			    <s:url action="cargarUsuario" id="actualizar">
			      <!-- Inteyctamos al atributo, el valor del property de la lista -->
			      <!-- El parametro estara listo -->
			    		<s:param name="usuario.usuario">
					 				<s:property value="usuario"/>
					    </s:param>
			    </s:url>
			    
			    <!-- Llamamos al action en un href -->
			    <s:a href="%{actualizar}">Actualizar</s:a>
			</td>
			
			<td>
			 <s:url action="eliminarUsuario" id="eliminar">
			  <s:param name="usuario.usuario">
			           <s:property value="usuario"/>
			  </s:param>
			 </s:url>
			 
			 <s:a href="%{eliminar}">Eliminar</s:a>
		</td>	
		</tr>
		
		</s:iterator>
	</table>



</s:if>
</body>
</html>