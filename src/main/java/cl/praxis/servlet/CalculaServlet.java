package cl.praxis.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Anotación que indica que esta clase es un Servlet y mapea las peticiones de "CalculaServlet" a este servlet.
@WebServlet("/CalculaServlet")
public class CalculaServlet extends HttpServlet {
    // El método doPost maneja las solicitudes POST enviadas al servlet.
    protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
        try {
            // Recupera los números y la operación del formulario. Convierte los números de String a int.
            int numero1 = Integer.parseInt(solicitud.getParameter("numero1"));
            int numero2 = Integer.parseInt(solicitud.getParameter("numero2"));
            String operacion = solicitud.getParameter("operacion");
            
            
            // Calcula el resultado según la operación especificada.
            String resultado = calcularResultado(numero1, numero2, operacion);
            
            // Establece el resultado en el atributo resultado para usarlo en la JSP.
            solicitud.setAttribute("resultado", resultado);
            
            // Reenvia la solicitud a la página JSP para mostrar el resultado.
            solicitud.getRequestDispatcher("index.jsp").forward(solicitud, respuesta);
        } catch (NumberFormatException e) {
            // Manejo de error cuando los números no son enteros válidos.
            solicitud.setAttribute("errorMensaje", "Por favor, ingrese solo números enteros.");
            solicitud.getRequestDispatcher("error.jsp").forward(solicitud, respuesta);
        } catch (ArithmeticException e) {
            // Manejo de error para excepciones aritméticas, como la división por cero.
            solicitud.setAttribute("errorMensaje", "Error de cálculo: " + e.getMessage());
            solicitud.getRequestDispatcher("error.jsp").forward(solicitud, respuesta);
        } catch (IllegalArgumentException e) {
            // Manejo de error para operaciones no válidas.
            solicitud.setAttribute("errorMensaje", e.getMessage());
            solicitud.getRequestDispatcher("error.jsp").forward(solicitud, respuesta);
        }
    }

  
    private String calcularResultado(int numero1, int numero2, String operacion) throws IllegalArgumentException, ArithmeticException {
        switch (operacion) {
            case "suma":
                return String.valueOf(numero1 + numero2);
            case "resta":
                return String.valueOf(numero1 - numero2);
            case "multiplicacion":
                return String.valueOf(numero1 * numero2);
            case "division":
                // Excepción específica si el divisor es cero.
                if (numero2 == 0) {
                    throw new ArithmeticException("División por cero.");
                }
                double resultadoDivision = (double) numero1 / numero2;
                // Formatea el resultado para mostrar cero o un decimal según sea necesario.
                return resultadoDivision % 1 == 0 ? String.format("%.0f", resultadoDivision) : String.format("%.1f", resultadoDivision);
            case "ordenar":
                // Determina si los números son iguales o cuál es mayor y cuál es menor.
                if (numero1 == numero2) {
                    return "Ambos números son iguales: " + numero1;
                } else {
                    return "Menor: " + Math.min(numero1, numero2) + ", Mayor: " + Math.max(numero1, numero2);
                }
            case "paridad":
                // Describe si los números son pares o impares.
                return describirParidad(numero1, numero2);
            default:
                // Lanza una excepción si la operación no es reconocida.
                throw new IllegalArgumentException("Operación no válida.");
        }
    }

  
    private String describirParidad(int num1, int num2) {
        boolean esPar1 = num1 % 2 == 0;
        boolean esPar2 = num2 % 2 == 0;
        if (esPar1 && esPar2) {
            return "Ambos números (" + num1 + " y " + num2 + ") son pares.";
        } else if (!esPar1 && !esPar2) {
            return "Ambos números (" + num1 + " y " + num2 + ") son impares.";
        } else if (esPar1) {
            return "Número " + num1 + " es par y número " + num2 + " es impar.";
        } else {
            return "Número " + num1 + " es impar y número " + num2 + " es par.";
        }
    }
}


