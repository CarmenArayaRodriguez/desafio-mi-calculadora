<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="card text-white bg-danger">
            <div class="card-header text-center">
                <h2>Error</h2>
            </div>
            <div class="card-body">
                <p class="card-text">${errorMensaje}</p>
                <a href="index.jsp" class="btn btn-light">Intentar otra vez</a>
            </div>
        </div>
    </div>
</body>
</html>