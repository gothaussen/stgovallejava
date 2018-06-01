package Interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import Aplicacion.Buscar;
import Persistencia.Datos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Modificar_Registros extends JInternalFrame{
	
	JPanel jBuscar, jModificar, jBuscarP, jModificarP, jRut, jNombre, JApellidos, JNacimiento, JDireccion;
	JTextField TBuscar, TRut, TNombre, TApellidos, TfNacimiento, TDireccion;
	JLabel LBuscar, LRut, LNombre, LApellidos, LfNacimiento, LDireccion;
	JButton btn_Buscar, btn_Modificar;
	
	public Modificar_Registros() {
		super("Modificar Registros", true, true, true);
		
		this.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent arg0) {
				Principal P = (Principal)getDesktopPane().getTopLevelAncestor();
				P.modificar_registros.setEnabled(true);
				P.cont--;
			}
		});
		
		jBuscar = new JPanel();
		jBuscar.setLayout(new BoxLayout(jBuscar, BoxLayout.Y_AXIS));
		
		jModificar = new JPanel();
		jModificar.setLayout(new BoxLayout(jModificar, BoxLayout.Y_AXIS));
		
		jBuscarP = new JPanel();
		
		jModificarP = new JPanel();
		jModificarP.setLayout(new BoxLayout(jModificarP, BoxLayout.Y_AXIS));
		
		jRut = new JPanel();
		jNombre = new JPanel();
		JApellidos = new JPanel();
		JNacimiento = new JPanel();
		JDireccion= new JPanel();
		
		
		// Datos
		// Rut
		
		LRut = new JLabel("Rut");
		TRut = new JTextField(10);
		
		jRut.add(LRut);
		jRut.add(TRut);
		
		// Nombre
		LNombre = new JLabel("Nombre");
		TNombre = new JTextField(10);
		
		jNombre.add(LNombre);
		jNombre.add(TNombre);
		
		// Apellidos 
		LApellidos = new JLabel("Apellidos");
		TApellidos = new JTextField(10);
		
		JApellidos.add(LApellidos);
		JApellidos.add(TApellidos);
		
		// Nacimiento
		LfNacimiento = new JLabel("Fecha Nacimiento");
		TfNacimiento = new JTextField(10);
		
		JNacimiento.add(LfNacimiento);
		JNacimiento.add(TfNacimiento);
		
		// Direccion
		LDireccion = new JLabel("Direccion");
		TDireccion = new JTextField(10);
		
		JDireccion.add(LDireccion);
		JDireccion.add(TDireccion);
		
		// Buscador
		LBuscar = new JLabel("Rut");
		TBuscar = new JTextField(20);
		
		btn_Buscar = new JButton("Buscar");
		btn_Buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar B = new Buscar();
				if (B.buscador(TBuscar.getText()) == true) {
					TRut.setText(B.rut(TBuscar.getText()));
					TNombre.setText(B.nombre(TBuscar.getText()));
					TApellidos.setText(B.apellidos(TBuscar.getText()));
					TfNacimiento.setText(B.fNacimiento(TBuscar.getText()));
					TDireccion.setText(B.direccion(TBuscar.getText()));
				} else {
					JOptionPane.showMessageDialog(null, "Este rut no existe");
				}
			}
		});
		
		btn_Modificar = new JButton("Modificar");
		btn_Modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar B = new Buscar();
				if (B.buscador(TBuscar.getText()) == true) {
					Datos D = new Datos(TRut.getText(), TNombre.getText(), TApellidos.getText(), TfNacimiento.getText(), TDireccion.getText());
					D.data.set(B.BuscarIndex(TBuscar.getText()), D);
					
					TRut.setText("");
					TNombre.setText("");
					TApellidos.setText("");
					TfNacimiento.setText("");
					TDireccion.setText("");
					TBuscar.setText("");
					
					JOptionPane.showMessageDialog(null, "Modificado Con Exito");
				}
			}
		});
		
		//Paneles Modificar
		jModificarP.add(jRut);
		jModificarP.add(jNombre);
		jModificarP.add(JApellidos);
		jModificarP.add(JNacimiento);
		jModificarP.add(JDireccion);
		jModificarP.add(btn_Modificar);
		
		jModificar.add(jModificarP);
		
		// Paneles buscar
		jBuscarP.add(LBuscar);
		jBuscarP.add(TBuscar);
		
		
		jBuscar.add(jBuscarP);
		jBuscar.add(btn_Buscar);
		add(jBuscar, BorderLayout.WEST);
		add(jModificar, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}

}
