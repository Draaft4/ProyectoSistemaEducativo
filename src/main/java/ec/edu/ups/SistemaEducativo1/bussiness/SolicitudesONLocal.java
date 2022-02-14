package ec.edu.ups.SistemaEducativo1.bussiness;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.SistemaEducativo1.model.Solicitudes;

@Local
public interface SolicitudesONLocal {
	
	public void crearSolicitud(Solicitudes s) throws Exception;
	public List<Solicitudes> lista ();
	
}
