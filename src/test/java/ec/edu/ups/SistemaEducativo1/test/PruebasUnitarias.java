package ec.edu.ups.SistemaEducativo1.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Calificaciones;
import ec.edu.ups.SistemaEducativo1.model.Docente;
import ec.edu.ups.SistemaEducativo1.model.Solicitudes;


public class PruebasUnitarias {
	

	
	@Test
	public void testAlumno() {
		Alumno alumno = new Alumno();
		Date d = new Date();
		ArrayList<Solicitudes> solicitudes = new ArrayList<Solicitudes>();
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
		ArrayList<String> horarios = new ArrayList<String>();
		alumno.setId(0);
//		alumno.setCedula("0101010101");
//		alumno.setDireccion("Avenida España");
//		alumno.setFechaInscripcion(d);
//		alumno.setFechaNacimiento(d);
//		alumno.setNombre("Gustabo Garcia");
		alumno.setAsignaturas(asignaturas);
		alumno.setHorario(horarios);
		alumno.setSolicitudes(solicitudes);
//		assertTrue(alumno.getAsignaturas()==asignaturas);
//		assertTrue(alumno.getCedula()=="0101010101");
//		assertTrue(alumno.getDireccion()=="Avenida España");
//		assertTrue(alumno.getFechaInscripcion()==d);
//		assertTrue(alumno.getFechaNacimiento()==d);
//		assertTrue(alumno.getHorario()==horarios);
//		assertTrue(alumno.getId()==0);
//		assertTrue(alumno.getNombre()=="Gustabo Garcia");
		assertTrue(alumno.getSolicitudes()==solicitudes);
	}
	
	@Test
	public void probarAsignatura() {
		Asignatura asignatura = new Asignatura();
		ArrayList<Calificaciones> calificaciones = new ArrayList<Calificaciones>();
		ArrayList<String> contenido = new ArrayList<String>();
		Docente d = new Docente();
		asignatura.setCalificaciones(calificaciones);
		asignatura.setCodigo(0);
		asignatura.setContenido(contenido);
		asignatura.setDocente(d);
		asignatura.setNombreAsignatura("Cultura fisica");
		asignatura.setNumHoras(15);
		assertTrue(asignatura.getCalificaciones()==calificaciones);
		assertTrue(asignatura.getCodigo()==0);
		assertTrue(asignatura.getContenido()==contenido);
		assertTrue(asignatura.getDocente()==d);
		assertTrue(asignatura.getNombreAsignatura()=="Cultura fisica");
		assertTrue(asignatura.getNumHoras()==15);
	}
	
	@Test
	public void testCalificaciones() {
		Calificaciones calificaciones = new Calificaciones();
		calificaciones.setId(0);
		calificaciones.setNotaParcial(5);
		assertTrue(calificaciones.getId()==0);
		assertTrue(calificaciones.getNotaParcial()==5);
	}
	
	@Test
	public void testDocente() {
		Date td = new Date();
		Docente d = new Docente();
		ArrayList<String> horarios = new ArrayList<String>();
		ArrayList<Solicitudes> solicitudes = new ArrayList<Solicitudes>();
		d.setCedula("0101010101");
		d.setDireccion("Heroes de V");
		d.setFechaNacimiento(td);
		d.setHorario(horarios);
		d.setId(0);
		d.setNombre("Scober Kindred");
		d.setSolicitudes(solicitudes);
		d.setTituloAcademico("Trol Profesional");
		assertTrue(d.getCedula()=="0101010101");
		assertTrue(d.getDireccion()=="Heroes de V");
		assertTrue(d.getFechaNacimiento()==td);
		assertTrue(d.getHorario()==horarios);
		assertTrue(d.getId()==0);
		assertTrue(d.getNombre()=="Scober Kindred");
		assertTrue(d.getSolicitudes()==solicitudes);
		assertTrue(d.getTituloAcademico()=="Trol Profesional");
	}
	
	@Test
	public void testSolicitudes() {
		Solicitudes soli = new Solicitudes();
		soli.setContenido("Solicitud1");
		soli.setId(0);
		assertTrue(soli.getContenido()=="Solicitud1");
		assertTrue(soli.getId()==0);
	}
	
}
