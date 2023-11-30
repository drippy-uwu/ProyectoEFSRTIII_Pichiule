package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import Interfaces.ReclamoDAO;
import Model.ReclamoDTO;
import Model.UsuarioDTO;
import dao.DAOFactory;

/**
 * Servlet implementation class ReclamoServlet
 */
@WebServlet (name = "CRUD Reclamo", urlPatterns = {"/Reclamo"})
public class ReclamoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReclamoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		switch (opcion) {
		case "lis":
				listarReclamos(request, response);
			
			break;
			
		case "reg":
				registrarReclamos (request,response);
				
		case "bus":
				buscarReclamos (request,response);
				
		case "act":
				actualizarReclamos (request, response);
				
		case "eli":
				eliminarReclamos (request, response);

		default:
			throw new IllegalArgumentException("Valor : " + opcion);

		}
		
	}

	private void eliminarReclamos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje ="";
		String url;
		
		int codigo = Integer.parseInt(request.getParameter("cod"));

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReclamoDAO dao = fabrica.getReclamoDAO();
		
		int ok = dao.eliminarReclamo(codigo);
		
		if(ok==0) {
			mensaje+=" <script> alert('"+" Error al eliminar los datos" +"') </script>";
			 
		}else {
			mensaje+=" <script> alert('"+"Eliminación del Reclamo  "+codigo+" OK" +"') </script>";
		 
		}
		url="Reclamo?opcion=lis";
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);	

	}

	private void actualizarReclamos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje ="";
		String url;
		
		//captura
		int motivo = Integer.parseInt(request.getParameter("motivo"));
		Date fecha= Date.valueOf(request.getParameter("txtFechaReclamo"));
		String descripcion = request.getParameter("txtDescripcion");
		
		int codigo = Integer.parseInt(request.getParameter("txtIdReclamo"));

		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReclamoDAO dao = fabrica.getReclamoDAO();
		
		ReclamoDTO r = new ReclamoDTO();

		r.setId_motivo(motivo);
		r.setFec_reclamo(fecha);
		r.setDes_reclamo(descripcion);
		
		int ok = dao.actualizarReclamo(codigo, r);
		
		if (ok == 0) {
			mensaje+=" <script> alert ('"+" Error al Actualizar los datos" +"') </script>";
			url = "reclamo/actualizarReclamo.jsp";
		}else {
			mensaje+= " <script> alert('"+"Reclamo Actualizado OK" +"') </script>";
			url = "Reclamo?opcion=lis";
		}
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

	private void buscarReclamos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("cod"));
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReclamoDAO dao = fabrica.getReclamoDAO();
		
		ReclamoDTO reclamo = dao.buscarReclamo(codigo);
		
		request.setAttribute("reclamo", reclamo);
		request.getRequestDispatcher("reclamo/actualizarReclamo.jsp").forward(request, response);

		
	}

	private void registrarReclamos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje ="";
		String url;
		
		//captura
		int motivo = Integer.parseInt(request.getParameter("motivo"));
		Date fecha= Date.valueOf(request.getParameter("txtFechaReclamo"));
		String descripcion = request.getParameter("txtDescripcion");
		
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("datosUsu");
		int codigo = usuario.getCliente().getId_cliente();
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReclamoDAO dao = fabrica.getReclamoDAO();
		
		ReclamoDTO r = new ReclamoDTO();
		r.setId_motivo(motivo);
		r.setFec_reclamo(fecha);
		r.setDes_reclamo(descripcion);
		
		int ok = dao.registrarReclamo(codigo, r);
		
		if (ok == 0) {
			mensaje+=" <script> alert ('"+" Error al registrar los datos" +"') </script>";
			url = "reclamo/registrarReclamo.jsp";
		}else {
			mensaje+= " <script> alert('"+"Reclamo registrado OK" +"') </script>";
			url = "Reclamo?opcion=lis";
		}
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
	}

	private void listarReclamos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//captura
		UsuarioDTO usuario = (UsuarioDTO) request.getSession().getAttribute("datosUsu"); 
		int codigo = usuario.getCliente().getId_cliente();
		
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ReclamoDAO dao = fabrica.getReclamoDAO();
		
		ArrayList<ReclamoDTO> lista = dao.listarReclamos(codigo);
		
		request.setAttribute("listaReclamos", lista);
		request.getRequestDispatcher("reclamo/listado.jsp").forward(request, response);

		
	}

}
