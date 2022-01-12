package ec.edu.ups.Remota.view;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONRemote;
import ec.edu.ups.SistemaEducativo1.bussiness.AsignaturaONRemote;

public class Principal {

	private static AlumnoONRemote alumnoRemote;

	private static AsignaturaONRemote asignaturaRemote;

	public void conectarAlumno() throws Exception {
		try {
			final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");
			jndiProperties.put("jboss.naming.client.ejb.context", true);

			jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			jndiProperties.put(Context.SECURITY_PRINCIPAL, "demop59");
			jndiProperties.put(Context.SECURITY_CREDENTIALS, "demop59");

			final Context context = new InitialContext(jndiProperties);

			final String lookupName = "ejb:/SistemaEducativo1/AlumnoON!ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONRemote";

			Principal.alumnoRemote = (AlumnoONRemote) context.lookup(lookupName);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void conectarAsignatura() throws Exception {
		try {
			final Hashtable<String, Comparable> jndiProperties = new Hashtable<String, Comparable>();
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");
			jndiProperties.put("jboss.naming.client.ejb.context", true);

			jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			jndiProperties.put(Context.SECURITY_PRINCIPAL, "demop59");
			jndiProperties.put(Context.SECURITY_CREDENTIALS, "demop59");

			final Context context = new InitialContext(jndiProperties);

			final String lookupName = "ejb:/SistemaEducativo1/AsignaturaON!ec.edu.ups.SistemaEducativo1.bussiness.AsignaturaONRemote";

			Principal.asignaturaRemote = (AsignaturaONRemote) context.lookup(lookupName);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public static void main(String[] args) {
		Principal p = new Principal();
		try {
			p.conectarAsignatura();
			p.conectarAlumno();
			PantallaPrincipal prin = new PantallaPrincipal(asignaturaRemote,alumnoRemote);
			
			prin.setVisible(true);
			prin.setLocationRelativeTo(null);
		} catch (Exception e) {
			System.out.println("Error al conectar con el servidor");
		}

	}

}
