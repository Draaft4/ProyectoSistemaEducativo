package ec.edu.ups.SistemaEducativo1.test;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;

@WebServlet("/TestAlumno")
public class TestAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Inject
	private AlumnoONLocal dao;
	
    public TestAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Alumno test = new Alumno();
		test.setCedula("0101");
		test.setContrasena("123");
		test.setCorreo("test");
		test.setDireccion("Av Test");
		test.setNombre("Test");
		try {
			dao.crearAlumno(test);
		} catch (Exception e) {
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
