package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import Interfaces.ClienteDAO;
import Model.ClienteDTO;
import Model.UsuarioDTO;
import dao.DAOFactory;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet (name = "RegistroCliente" , urlPatterns = {"/RegistrarCliente"})
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
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
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		
		switch (opcion) {
		case "reg":
			registrar(request, response);
			
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
		
		
		
		doGet(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mensaje = "";
		String url;
		
		//Captura de datos
		int tipo = Integer.parseInt(request.getParameter("tipo"));
		String numero = request.getParameter("txtNumero");
		String nombres = request.getParameter("txtNombres");
		String apellidoPa = request.getParameter("txtApellidoPa");
		String apellidoMa = request.getParameter("txtApellidoMa");
		Date fecha = Date.valueOf(request.getParameter("txtFecha"));
		String email = request.getParameter("txtEmail");
		String usuario = request.getParameter("txtUsuario");
		String contrasena = request.getParameter("txtContrasena");
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ClienteDAO dao = fabrica.getClienteDAO();
		
		ClienteDTO c = new ClienteDTO(tipo,numero,nombres,apellidoPa,apellidoMa,fecha,email);
		UsuarioDTO u = new UsuarioDTO(usuario,contrasena);
		
		int ok = dao.registrarCliente(u, c);
		
		if (ok == 0) {
			mensaje+=" <script> alert ('"+" Error al registrar los datos" +"') </script>";
			url = "cliente/registro.jsp";
		}else {
			mensaje+= " <script> alert('"+"Cliente "+nombres+ " registrado OK" +"') </script>";
			url = "Login.jsp";
		}
		System.out.println(fecha);
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
