package ec.edu.ups.SistemaEducativo1.bussiness;

import javax.ejb.Remote;

import ec.edu.ups.SistemaEducativo1.model.Solicitudes;

@Remote
public interface SolicitudesONRemote {
	
	public void crearSolicitud(Solicitudes s) throws Exception;
	
}
