package vistasBD;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelosBD.DepartamentosDTO;
import repositoryBD.DepartamentosRepository;
import repositoryBD.EmpleadosRepository;
import javax.swing.JScrollPane;

public class MostrarDepartamentos extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarDepartamentos dialog = new MostrarDepartamentos();
					LoadDepartamentos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MostrarDepartamentos() {
		setBounds(100, 100, 610, 436);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		getContentPane().add(table);

	}

	public void LoadDepartamentos() {
		scrollPane.setViewportView(table);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        modelo.addColumn("Descripción");
        modelo.addColumn("Población");
		DepartamentosRepository emp = new DepartamentosRepository();
		ArrayList<DepartamentosDTO> dptos = emp.listarTodos();
		for (DepartamentosDTO dpto : dptos) {
			modelo.addRow(new Object[] {
					dpto.getDescripcion(),
					dpto.getPoblacion()
			});
		}
		scrollPane.setViewportView(table);
		
	}
	/**
	 * Create the dialog.
	 */
	
}
