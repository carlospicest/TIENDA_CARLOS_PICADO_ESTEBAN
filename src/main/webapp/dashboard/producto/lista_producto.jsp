<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"
	import="java.util.HashMap, curso.java.tienda.index.pojo.Pedido,
			curso.java.tienda.index.pojo.Producto, curso.java.tienda.index.pojo.DetallePedido,
			curso.java.tienda.index.pojo.Usuario, curso.java.tienda.util.DateTime,
			curso.java.tienda.index.pojo.Categoria"%>
<%
HashMap<Integer, Producto> productoList = (HashMap<Integer, Producto>) request.getAttribute("productoList");
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="index/assets/css/bootstrap.css">
</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Nombre</th>
				<th scope="col">Categoría</th>
				<th scope="col">Precio</th>
				<th scope="col">Stock</th>
				<th scope="col">Impuesto</th>
				<th scope="col">Baja</th>
				<th scope="col">Fecha de alta</th>
				<th scope="col">Acciones</th>
			</tr>
		</thead>
		<tbody>
		<% for (Producto producto : productoList.values()) { %>
			<tr>
				<td><%= producto.getNombre() %></td>
				<td><%= producto.getCategoria().getNombre() %></td>
				<td><%= producto.getPrecio() %></td>
				<td><%= producto.getStock() %></td>
				<td><%= producto.getImpuesto() %></td>
				<td><%= producto.isBaja() %></td>
				<td><%= producto.getFecha_alta() %></td>
				<td>
					<a class="btn btn-success" href="producto_actualizar?producto=<%= producto.getId() %>">Modificar</a>
					<a class="btn btn-danger" href="producto_eliminar?producto=<%= producto.getId() %>">Eliminar</a>
				</td>
			</tr>
			<% } %>
		</tbody>
	</table>

	<a href="producto_agregar" class="btn btn-default">Agregar nuevo producto</a>

</body>
</html>