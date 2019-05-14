package puce.factura;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/factura")
public class Factura extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Factura() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String subtotal = request.getParameter("subtotal");
		String porcentajeIva = request.getParameter("porcentajeIva");
		
		double dSubtotal = Double.parseDouble(subtotal);
		int iPorcentajeIba = Integer.parseInt(porcentajeIva);
		
		double montoIva = dSubtotal * iPorcentajeIba / 100;
		double total = dSubtotal+montoIva;
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html><head><title>")
		.append("Resumen de Factura")
		.append("</title></head>")
		.append("<body><h1>FACTURA</h1>")
		.append("<p>Cliente Nombre: ").append(nombre).append("</p>")
		.append("<p>Cliente Apellido: ").append(apellido).append("</p>")
		.append("<table>")
		.append("<tr><td>Subtotal:</td><td>").append(dSubtotal).append("</td></tr>")
		.append("<tr><td>MontoIva:</td><td>").append(montoIva).append("</td></tr>")		
		.append("<tr><td>Total:</td><td>").append(total).append("</td></tr>")
		.append("</table></body></html>");
		
		response.getOutputStream().print(sb.toString());
		response.getOutputStream().flush();
			
		
		
	}

}
