package Interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import Persistencia.Datos;
import Persistencia.Prueba;

public class Ingreso_Registro extends JInternalFrame {
	
	JLabel LRun, LNombre, LApellidos, LNacimiento, LDireccion;
	JTextField TRun, TNombre, TApellidos, TNacimiento, TDireccion;
	JPanel jPrincipal, j1, j2, j3, j4, j5, j6;
	JButton btn_Enviar, btn_Mostrar;
	
	public Ingreso_Registro() {
		super("Ingresar Registro a base de datos", true, true, true);
		
		this.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent arg0) {
				Principal P = (Principal)getDesktopPane().getTopLevelAncestor();
				P.ingresar_registro.setEnabled(true);
				P.cont--;
				System.out.println(P.cont);
			}
		});
		
		// Paneles
		jPrincipal = new JPanel();
		jPrincipal.setLayout(new BoxLayout(jPrincipal, BoxLayout.Y_AXIS));
		j1 = new JPanel();
		j2 = new JPanel();
		j3 = new JPanel();
		j4 = new JPanel();
		j5 = new JPanel();
		j6 = new JPanel();
		
		
		// Rut
		LRun = new JLabel("Rut: ");
		TRun = new JTextField(20);
		
		j1.add(LRun);
		j1.add(TRun);
		
		// Nombre
		LNombre = new JLabel("Nombre: ");
		TNombre = new JTextField(20);
		
		j2.add(LNombre);
		j2.add(TNombre);
		
		// Apellidos
		LApellidos = new JLabel("Apellido: ");
		TApellidos = new JTextField(20);
		
		j3.add(LApellidos);
		j3.add(TApellidos);
		
		// Nacimiento
		LNacimiento = new JLabel("Fecha de Nacimiento");
		TNacimiento = new JTextField(20);
		
		j4.add(LNacimiento);
		j4.add(TNacimiento);
		
		// Direccion
		LDireccion = new JLabel("Direccion");
		TDireccion = new JTextField(20);
		
		j5.add(LDireccion);
		j5.add(TDireccion);
		
		// Boton Enviar
		btn_Enviar = new JButton("Enviar");
		btn_Enviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Datos D = new Datos(TRun.getText(), TNombre.getText(), TApellidos.getText(), TNacimiento.getText(), TDireccion.getText());
				Datos.data.add(D);
			}
		});
		
		btn_Mostrar = new JButton("mostrar");
		btn_Mostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i<Datos.data.size(); i++) {
					System.out.print(((Datos) Datos.data.get(i)).getNombre());	
				}
				
			}
		});
		
		j6.add(btn_Enviar);
		j6.add(btn_Mostrar);
		
		
		jPrincipal.add(j1);
		jPrincipal.add(j2);
		jPrincipal.add(j3);
		jPrincipal.add(j4);
		jPrincipal.add(j5);
		jPrincipal.add(j6);
		add(jPrincipal, BorderLayout.CENTER);
		
		
		this.setVisible(true);
		this.pack();
		
	}
	
	

}
