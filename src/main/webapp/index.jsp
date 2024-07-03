<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Calculadora</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center text-primary mb-4">Calculadora</h2>
		<form action="CalculaServlet" method="POST"
			class="card card-body bg-dark text-white">
			<div class="mb-3">
				<label for="numero1" class="form-label">Número 1</label> <input
					type="number" class="form-control" id="numero1" name="numero1"
					required min="1" max="100">
			</div>
			<div class="mb-3">
				<label for="numero2" class="form-label">Número 2</label> <input
					type="number" class="form-control" id="numero2" name="numero2"
					required min="1" max="100">
			</div>
			<div class="mb-3">
				<label for="operacion" class="form-label">Operación</label> <select
					name="operacion" id="operacion" class="form-select" required>
					<option value="">Seleccione una operación</option>
					<option value="suma">Suma</option>
					<option value="resta">Resta</option>
					<option value="multiplicacion">Multiplicación</option>
					<option value="division">División</option>
					<option value="ordenar">Ordenar</option>
					<option value="paridad">Paridad</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Calcular</button>
		</form>
		<%
		String resultado = (String) request.getAttribute("resultado");
		if (resultado != null && !resultado.isEmpty()) {
		%>
		<div class="alert alert-success mt-4">
			Resultado:
			<%=resultado%></div>
		<%
		}
		%>

	</div>
</body>
</html>
