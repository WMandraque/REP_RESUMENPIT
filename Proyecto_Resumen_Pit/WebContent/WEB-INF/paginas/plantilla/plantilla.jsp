<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paranet</title>
</head>
<body>
<table>
<tr>
  <td>
  <!-- Cabezera -->
  <tiles:insertAttribute name="cabecera"/>
  </td>
</tr>

<tr>
<td>
<tiles:insertAttribute name="menu"/>
<tiles:insertAttribute name="contenido"/>
</td>
</tr>

<tr>
<td>
<tiles:insertAttribute name="pie"/>
</td>
</tr>

</table>





</body>
</html>