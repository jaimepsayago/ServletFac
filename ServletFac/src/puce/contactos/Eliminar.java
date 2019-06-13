package puce.contactos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testPackage.Contacto;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactos1 = request.getParameter("nombre");
		
		ArrayList<Contacto> con = (ArrayList<Contacto>)request.getAttribute("contactos");
		Contacto s=null;
		
		 for (Iterator<Contacto> iter = con.iterator(); iter.hasNext();) {
		      s = iter.next();
		      if (s.equals(contactos1)) {
		        iter.remove();
		        RequestDispatcher d = getServletContext().getRequestDispatcher("/index.jsp");
				d.include(request, response);
		      }
		      else {
		        System.out.println(s);
		      }
		    }
		 response.getOutputStream().print(s.toString());
		 response.getOutputStream().flush();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
