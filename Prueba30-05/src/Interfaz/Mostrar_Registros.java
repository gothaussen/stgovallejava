package Interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Persistencia.Datos;
import Persistencia.Prueba;

public class Mostrar_Registros extends JInternalFrame{
	JScrollPane scrollPane;
	
	
	
	DefaultTableModel dtm;
	JTable table;
	JPanel Pcen, Psup;
	JComboBox C;
	JButton B, BLimpia;
	Object DATOS [][];
	Object data[];
	String [] cabecera;
	
	
	public Mostrar_Registros() {
		super("Registros", true, true, true);
		
		this.addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameClosing(InternalFrameEvent arg0) {
				Principal P = (Principal)getDesktopPane().getTopLevelAncestor();
				P.mostrar_registros.setEnabled(true);
			}
		});
		

		cabecera = new String[] {"RUT", "NOMBRE", "APELLIDOS", "FECHA NACIMIENTO", "DIRECCION"};

		data = new Object[5];

		
		
		Pcen = new JPanel();
		dtm = new DefaultTableModel();
		
		/* Se crea la tabla con el modelo defaultablemodel */
		table = new JTable(dtm);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.white);
		Font letras = new Font("Helvetica", 1, 12);
		table.setFont(letras);
		
		/* Se insertan las columnas */
		//this.insertar_datos_a_tabla(this.table);
		
		/* Se define el tamaño de la tabla (horiz, vert)*/
		this.dibuja_tabla(this.table);
		
		/* Agrega Cabecera */
		this.agregar_cabecera();
		
		
		/* Creamos un scroll pane y le agregamos la JTable */
		scrollPane = new JScrollPane(table);

		
		
		Pcen.add(scrollPane);
		
		getContentPane().add(Pcen, BorderLayout.CENTER);
		
		this.mostrar_todo();
		this.setVisible(true);
		this.setSize(600, 200);
	}
	
	private void dibuja_tabla(JTable tabla) {
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 90));
		tabla.setEnabled(true);
	}

	
	private void centrar_datos(int col) {
		DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
		modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(col).setCellRenderer(modelocentrar);
	}
	
	private void agregar_cabecera() {
		for (int column = 0; column < cabecera.length; column++) {
			dtm.addColumn(cabecera[column]);
		}
		
		for (int i = 0; i<cabecera.length; i++) {
			this.centrar_datos(i);
		}
	}
	
	private void mostrar_todo() {
		for(int i=0; i<Datos.data.size(); i++) {
			Datos DP = (Datos) Datos.data.get(i);
			dtm.addRow(new Object [] {  DP.getRut(), DP.getNombre(), DP.getApellidos(), DP.getNacimiento(), DP.getDireccion() });
		}
	}
	
}
