package ec.edu.ups.Remota.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ec.edu.ups.SistemaEducativo1.bussiness.AlumnoONRemote;
import ec.edu.ups.SistemaEducativo1.bussiness.AsignaturaONRemote;
import ec.edu.ups.SistemaEducativo1.model.Alumno;
import ec.edu.ups.SistemaEducativo1.model.Asignatura;
import ec.edu.ups.SistemaEducativo1.model.Persona;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private static AlumnoONRemote alumnoRemote;

	private static AsignaturaONRemote asignaturaRemote;

	private ArrayList<Asignatura> listaAsgF = new ArrayList<Asignatura>();

	public PantallaPrincipal(AsignaturaONRemote asignaturaRemote, AlumnoONRemote alumnoRemote) {
		initComponents();
		this.asignaturaRemote = asignaturaRemote;
		this.alumnoRemote = alumnoRemote;
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		txtCedula = new javax.swing.JTextField();
		txtNombre = new javax.swing.JTextField();
		txtDirDomicilio = new javax.swing.JTextField();
		txtFechNacimiento = new javax.swing.JTextField();
		txtFechaInscripcion = new javax.swing.JTextField();
		btnIngresarEst = new javax.swing.JButton();
		btnFechaActual = new javax.swing.JButton();
		comboAsignaturas = new javax.swing.JComboBox<>();
		jLabel7 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		areaAsignaturas = new javax.swing.JTextArea();
		btnActualizar = new javax.swing.JButton();
		btnSeleccionar = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jLabel10 = new javax.swing.JLabel();
		txtNombreAsignatura = new javax.swing.JTextField();
		btnIngresarAsignatura = new javax.swing.JButton();
		txtNumHoras = new javax.swing.JTextField();
		jPanel3 = new javax.swing.JPanel();
		jLabel11 = new javax.swing.JLabel();
		btnActualizarLista = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Ingreso de Estudiante");

		jLabel2.setText("Ingrese Numero de Cedula:");

		jLabel3.setText("Ingrese Direccion de Domicilio:");

		jLabel4.setText("Ingrese Fecha de Nacimiento: (dd/MM/YYYY)");

		jLabel5.setText("Ingrese Nombre Completo:");

		jLabel6.setText("Ingrese Fecha de Inscripcion: (dd/MM/YYYY)");

		btnIngresarEst.setText("Ingresar");
		btnIngresarEst.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnIngresarEstActionPerformed(evt);
			}
		});

		btnFechaActual.setText("Fecha Actual");
		btnFechaActual.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnFechaActualActionPerformed(evt);
			}
		});

		jLabel7.setText("Seleccione las Asignaturas a cursar:");

		areaAsignaturas.setEditable(false);
		areaAsignaturas.setColumns(20);
		areaAsignaturas.setLineWrap(true);
		areaAsignaturas.setRows(5);
		jScrollPane1.setViewportView(areaAsignaturas);

		btnActualizar.setText("Actualizar");
		btnActualizar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnActualizarActionPerformed(evt);
			}
		});

		btnSeleccionar.setText("Seleccionar");
		btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSeleccionarActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1)
						.addComponent(btnIngresarEst)
						.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.LEADING,
										jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel2).addComponent(jLabel5)
														.addComponent(jLabel3).addComponent(jLabel4)
														.addComponent(jLabel6)).addGap(31, 31, 31))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
														jPanel1Layout.createSequentialGroup().addComponent(jLabel7)
																.addGap(32, 32, 32)))
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(txtCedula).addComponent(txtNombre)
														.addComponent(txtDirDomicilio).addComponent(txtFechNacimiento)
														.addComponent(txtFechaInscripcion)
														.addComponent(comboAsignaturas, 0, 131, Short.MAX_VALUE))))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(btnFechaActual)
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnSeleccionar, javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(jLabel1)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel5).addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel3).addComponent(txtDirDomicilio,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4).addComponent(txtFechNacimiento,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6)
								.addComponent(txtFechaInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnFechaActual))
						.addGap(18, 18, 18)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(comboAsignaturas, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7).addComponent(btnSeleccionar))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
								.addGroup(jPanel1Layout.createSequentialGroup().addComponent(btnActualizar).addGap(0, 0,
										Short.MAX_VALUE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(btnIngresarEst).addContainerGap()));

		jLabel8.setText("Ingreso de Asignatura");

		jLabel9.setText("Nombre de la Asignatura:");

		jLabel10.setText("Numero de horas:");

		btnIngresarAsignatura.setText("Ingresar");
		btnIngresarAsignatura.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnIngresarAsignaturaActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel8)
						.addComponent(btnIngresarAsignatura)
						.addGroup(jPanel2Layout.createSequentialGroup()
								.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel9).addComponent(jLabel10))
								.addGap(18, 18, 18)
								.addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(txtNombreAsignatura).addComponent(txtNumHoras,
												javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel8)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel9).addComponent(txtNombreAsignatura,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel10).addComponent(txtNumHoras,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(btnIngresarAsignatura)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		jLabel11.setText("Lista de Estudiantes Matriculados.");

		btnActualizarLista.setText("Actualizar");
		btnActualizarLista.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnActualizarListaActionPerformed(evt);
			}
		});

		jTextArea1.setEditable(false);
		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane2.setViewportView(jTextArea1);

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane2)
								.addGroup(jPanel3Layout.createSequentialGroup().addComponent(jLabel11)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnActualizarLista).addGap(0, 129, Short.MAX_VALUE)))
						.addContainerGap()));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel11).addComponent(btnActualizarLista))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane2)
						.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addContainerGap()));

		pack();
	}// </editor-fold>

	private void btnIngresarEstActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			if (listaAsgF.size() > 0) {
				String cedula = txtCedula.getText();
				String nombre = txtNombre.getText();
				String direccion = txtDirDomicilio.getText();
				String tfechaIns = txtFechaInscripcion.getText();
				String tfechaNac = txtFechNacimiento.getText();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
				Date fechaIns = sdf.parse(tfechaIns);
				Date fechaNac = sdf.parse(tfechaNac);
				Alumno alumno = new Alumno();
				Persona per = new Persona();
				per.setCedula(cedula);
				per.setNombre(nombre);
				per.setDireccion(direccion);
				alumno.setFechaInscripcion(fechaIns);
				per.setFechaNacimiento(fechaNac);
				alumno.setAsignaturas(listaAsgF);
				alumno.setDatos(per);
				alumnoRemote.crearAlumno(alumno);
			} else {
				JOptionPane.showMessageDialog(this,
						"Error: No puede matricularse sin ingresar previamente las materias.");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void btnFechaActualActionPerformed(java.awt.event.ActionEvent evt) {
		Date fechaActual = new Date();
		System.out.println(fechaActual);
		txtFechaInscripcion.setText(
				(fechaActual.getDay() + 9) + "/" + (fechaActual.getMonth() + 1) + "/" + (fechaActual.getYear() + 1900));
	}

	private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
		ArrayList<Asignatura> listaAsg = new ArrayList<Asignatura>();
		try {
			for (int i = 1; i < 10; i++) {
				Asignatura x = asignaturaRemote.obtenerAsignatura(i);
				if (x != null) {
					listaAsg.add(x);
				} else {
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Termino de ejecutar");
		}
		DefaultComboBoxModel dml = new DefaultComboBoxModel();
		for (int i = 0; i < listaAsg.size(); i++) {
			dml.addElement(listaAsg.get(i).getNombreAsignatura());
		}
		comboAsignaturas.setModel(dml);
	}

	private void btnActualizarListaActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			for (int i = 1; i < 10; i++) {
				Alumno x = new Alumno();
				x=alumnoRemote.obtenerAlumno(i);
				if(x!=null) {
					jTextArea1.setText("");
					jTextArea1.append(x.toString()+"\n");
				}
			}
		} catch (Exception e) {
			System.out.println("Termino de ejecutar");
		}
	}

	private void btnIngresarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {
		String nombre = txtNombreAsignatura.getText();
		try {
			int numeroHoras = Integer.parseInt(txtNumHoras.getText());
			Asignatura asignatura = new Asignatura();
			asignatura.setNombreAsignatura(nombre);
			asignatura.setNumHoras(numeroHoras);
			asignaturaRemote.crearAsignatura(asignatura);
			txtNombreAsignatura.setText("");
			txtNumHoras.setText("");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Ingrese solo numeros por favor");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			int codigo = comboAsignaturas.getSelectedIndex() + 1;
			Asignatura x = asignaturaRemote.obtenerAsignatura(codigo);
			areaAsignaturas.setText("");
			areaAsignaturas.append(x.toString() + "\n");
			listaAsgF.add(x);
		} catch (Exception e) {
		}

	}

	private javax.swing.JTextArea areaAsignaturas;
	private javax.swing.JButton btnActualizar;
	private javax.swing.JButton btnActualizarLista;
	private javax.swing.JButton btnFechaActual;
	private javax.swing.JButton btnIngresarAsignatura;
	private javax.swing.JButton btnIngresarEst;
	private javax.swing.JButton btnSeleccionar;
	private javax.swing.JComboBox<String> comboAsignaturas;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField txtCedula;
	private javax.swing.JTextField txtDirDomicilio;
	private javax.swing.JTextField txtFechNacimiento;
	private javax.swing.JTextField txtFechaInscripcion;
	private javax.swing.JTextField txtNombre;
	private javax.swing.JTextField txtNombreAsignatura;
	private javax.swing.JTextField txtNumHoras;
}