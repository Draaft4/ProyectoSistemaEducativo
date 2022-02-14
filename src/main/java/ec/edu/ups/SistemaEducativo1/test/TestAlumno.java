package ec.edu.ups.SistemaEducativo1.test;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.AsignaturaONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.CalificacionesONLocal;
import ec.edu.ups.SistemaEducativo1.bussiness.DocenteONLocal;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;
import ec.edu.ups.SistemaEducativo1.model.Docente;

@WebServlet("/TestAlumno")
public class TestAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Inject
	private AlumnoONLocal dao;
	@Inject
	private DocenteONLocal daoD;
	@Inject
	private AsignaturaONLocal daoA;
	@Inject
	private CalificacionesONLocal daoC;
	
    public TestAlumno() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Docente test1 = new Docente();
		test1.setCedula("0101");
		test1.setContrasena("123");
		test1.setCorreo("doc1");
		test1.setDireccion("Calle test");
		test1.setNombre("Test Docente");
		test1.setTituloAcademico("Ing testing");
		try {
			daoD.crearDocente(test1);
		} catch (Exception e) {
		}
		Asignatura as = new Asignatura();
		as.setDocente(test1);
		as.setNombreAsignatura("Sufrimiento eterno");
		as.setEspacioFisico("Infierno");
		as.setNumHoras(666);
		Asignatura as1 = new Asignatura();
		as1.setDocente(test1);
		as1.setNombreAsignatura("Sufrimiento eterno2");
		as1.setEspacioFisico("Infierno2");
		as1.setNumHoras(666);
		Asignatura as2 = new Asignatura();
		as2.setDocente(test1);
		as2.setNombreAsignatura("Sufrimiento eterno3");
		as2.setEspacioFisico("Infierno3");
		as2.setNumHoras(666);
		try {
			daoA.crearAsignatura(as);
		} catch (Exception e1) {
		}
		try {
			daoA.crearAsignatura(as1);
		} catch (Exception e1) {
		}
		try {
			daoA.crearAsignatura(as2);
		} catch (Exception e1) {
		}
		Alumno test = new Alumno();
		test.setCedula("01");
		test.setContrasena("123");
		test.setCorreo("test");
		test.setDireccion("Av Test");
		test.setNombre("Test");
		test.setAsignaturas(new java.util.ArrayList<Asignatura>());
		test.getAsignaturas().add(as);
		test.getAsignaturas().get(0).setCalificaciones(new java.util.ArrayList<Calificaciones>());
		Calificaciones cali = new Calificaciones();
		cali.setNotaParcial(10);
		try {
			daoC.insertarCalificaciones(cali);
		} catch (Exception e1) {
		}
		test.getAsignaturas().get(0).getCalificaciones().add(cali);
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
