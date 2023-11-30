package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;

import Model.UsuarioDTO;
import dao.DAOFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet (name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		
		switch (opcion) {
		case "ing":
				validarUsuario(request,response);
			break;

		default:
			throw new IllegalArgumentException("Valor : " + opcion);
		}
		
		
	}

	private void validarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mensaje ="", url="";
		
		//obtenemos datos
		String usuario = request.getParameter("txtUsuario");
		String contrasena = request.getParameter("txtContrasena");
		
		//instanciamos
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UsuarioDTO u = fabrica.getUsuarioDAO().validar(usuario, contrasena);
		
		if (u!= null) {
			mensaje += "<script> alert('"+"Bienvenido "+ u.getCliente().getNombre()+"') </script>";
			url ="Index.jsp";
			
			HttpSession miSession = request.getSession();
			System.out.println("ID Session: "+ miSession.getId());
			System.out.println("Fecha-----: "+ new SimpleDateFormat().format(miSession.getCreationTime()));
			System.out.println("Duración--: "+ miSession.getMaxInactiveInterval());
			
			request.getSession().setAttribute("mensaje", mensaje); 
			request.getSession().setAttribute("datosUsu",u); 

		} else {
			mensaje += "<script> alert('Usuario o clave incorrecto') </script> ";
			url ="Login.jsp";
			request.getSession().setAttribute("mensaje", mensaje); 


		}
		
		//Salida 
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
