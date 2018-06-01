package Interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Principal extends JFrame {

	private JDesktopPane DP;
	private JPanel panel;
	private JMenu menu;
	private JMenuBar barra;
	public JMenuItem ingresar_registro, mostrar_registros, modificar_registros;
	static int cont = 0;
	
	public Principal() {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		DP = new JDesktopPane() {
			ImageIcon icon = new ImageIcon("img/wallpaper.jpg");
			Image image = icon.getImage();
			
			@Override
			protected void paintComponent(Graphics  g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		this.setTitle("Prueba 30-05-2018 | Ignacio Lagos");
		this.setContentPane(DP);
		
		barra = new JMenuBar();
		this.setJMenuBar(barra);
		
		menu = new JMenu("Opciones");
		
		
		ingresar_registro = new JMenuItem("Ingresar Registro");
		ingresar_registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ingreso_Registro IC = new Ingreso_Registro();
				DP.add(IC);
				ingresar_registro.setEnabled(false);
				cont++;
				System.out.println(cont);
			}
		});
		
		mostrar_registros = new JMenuItem("Mostrar Registros");
		mostrar_registros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mostrar_Registros MR = new Mostrar_Registros();
				DP.add(MR);
				mostrar_registros.setEnabled(false);
			}
		});
		
		modificar_registros = new JMenuItem("Modificar Registro");
		modificar_registros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar_Registros MDR = new Modificar_Registros();
				DP.add(MDR);
				modificar_registros.setEnabled(false);
			}
		});
		
		menu.add(ingresar_registro);
		menu.addSeparator();
		menu.add(mostrar_registros);
		menu.addSeparator();
		menu.add(modificar_registros);
		
		barra.add(menu);
		
	}
	
	public void dibuja_frame() {
		// Asigna tamaño y posicionamiento
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		
		//asigna ancho y alto
		int frame_anchura = d.width;
		int frame_altura = d.height;
		
		setSize(frame_anchura / 2, frame_altura / 2);
		//pack();
		setLocation(frame_anchura / 4, frame_altura / 4);
	}
	
	public static void main(String [] args) {
		
		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		Principal P = new Principal();
		P.dibuja_frame();
		P.setVisible(true);
	}
}
