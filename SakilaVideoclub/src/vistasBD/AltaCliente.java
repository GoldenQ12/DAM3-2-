package vistasBD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladoresBD.AddressController;
import controladoresBD.CustomerController;
import controladoresBD.StoreController;
import modelosBD.Adress;
import modelosBD.Customer;
import modelosBD.Store;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class AltaCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private CustomerController customer = new CustomerController();
	private AddressController addresses = new AddressController();
	private StoreController store = new StoreController();
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AltaCliente dialog = new AltaCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AltaCliente() {													
		setBounds(100, 100, 717, 589);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnVolver = new JButton("VOLVER");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						int respuesta = JOptionPane.showConfirmDialog(
								null, 
								"Seguro que quieres volver?", 
								"Confirmación", 
								JOptionPane.YES_NO_OPTION, 
								JOptionPane.QUESTION_MESSAGE);
						if (respuesta == JOptionPane.YES_OPTION) 
							dispose();
				}
			});
			btnVolver.setBounds(553, 447, 138, 92);
			btnVolver.setForeground(Color.RED);
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 18));
			contentPanel.add(btnVolver);
		}
		
		JLabel lblAltaCliente = new JLabel("ALTA CLIENTE");
		lblAltaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaCliente.setForeground(new Color(204, 173, 0));
		lblAltaCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblAltaCliente.setBounds(0, 0, 701, 35);
		contentPanel.add(lblAltaCliente);
		
		JLabel lblId_1 = new JLabel("Tienda:");
		lblId_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1.setForeground(Color.BLACK);
		lblId_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId_1.setBounds(65, 151, 177, 35);
		contentPanel.add(lblId_1);
		
		JLabel lblId_1_1 = new JLabel("Nombre:");
		lblId_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1_1.setForeground(Color.BLACK);
		lblId_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId_1_1.setBounds(65, 197, 177, 35);
		contentPanel.add(lblId_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtNombre.setColumns(10);
		txtNombre.setBounds(179, 197, 446, 35);
		contentPanel.add(txtNombre);
		
		JLabel lblId_1_1_1 = new JLabel("Apellido:");
		lblId_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1_1_1.setForeground(Color.BLACK);
		lblId_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId_1_1_1.setBounds(65, 243, 177, 35);
		contentPanel.add(lblId_1_1_1);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtApellido.setColumns(10);
		txtApellido.setBounds(179, 243, 446, 35);
		contentPanel.add(txtApellido);
		
		JLabel lblId_1_1_1_1 = new JLabel("Activo:");
		lblId_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1_1_1_1.setForeground(Color.BLACK);
		lblId_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId_1_1_1_1.setBounds(65, 381, 106, 35);
		contentPanel.add(lblId_1_1_1_1);
		
		JLabel lblId_1_1_2 = new JLabel("Direcci\u00F3n:");
		lblId_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1_1_2.setForeground(Color.BLACK);
		lblId_1_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId_1_1_2.setBounds(65, 335, 177, 35);
		contentPanel.add(lblId_1_1_2);
		
		JLabel lblId_1_2 = new JLabel("Email:");
		lblId_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1_2.setForeground(Color.BLACK);
		lblId_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId_1_2.setBounds(65, 289, 177, 35);
		contentPanel.add(lblId_1_2);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(179, 289, 446, 35);
		contentPanel.add(txtEmail);
		
		
		
		JComboBox<String> cbDireccion = new JComboBox<String>();
		cbDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		ArrayList<Adress> items = addresses.listarTodos();
		for (Adress item : items) {
			cbDireccion.addItem(item.getAddress());
		}
		cbDireccion.setBounds(179, 335, 446, 35);
		
		contentPanel.add(cbDireccion);
		
		JComboBox<String> cbTienda = new JComboBox<String>();
		cbTienda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		cbTienda.setBounds(179, 151, 196, 35);
		ArrayList<Store> stores = store.listarTodos();
		for (Store item : stores ) {
			cbTienda.addItem(String.valueOf(item.getStore_id()));
		}
		contentPanel.add(cbTienda);
		
		
		
		JCheckBox checkboxActive = new JCheckBox("");
		checkboxActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkboxActive.isSelected()) {
					checkboxActive.setText("Activo");
				} else {
					checkboxActive.setText("Inactivo");
				}
			}
		});
		checkboxActive.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		checkboxActive.setBounds(179, 381, 106, 35);
		contentPanel.add(checkboxActive);
		
		JButton btnBuscar = new JButton("REGISTRAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Adress> addres = addresses.listarTodos();
				int adress_id = 0;
				for (Adress item : addres ) {
					if (item.getAddress().equals(cbDireccion.getSelectedItem().toString())) {
						adress_id = item.getAddress_id();
					}
				}
				int active;
				if (checkboxActive.isSelected()) {
					active = 1;
				} else {
					active = 0;
				}
				LocalDate fechaActual = LocalDate.now();
				Date fecha = Date.valueOf(fechaActual);
				Customer cust = new Customer(0,Integer.parseInt(cbTienda.getSelectedItem().toString()), txtNombre.getText().toString(), txtApellido.getText().toString(), txtEmail.getText().toString(), adress_id, active, fecha, null);
				if (customer.insertar(cust)) {
					JOptionPane.showMessageDialog(null, "Cliente agregado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Cliente no agregado correctamente", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnBuscar.setForeground(new Color(0, 128, 255));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuscar.setBounds(197, 447, 286, 92);
		contentPanel.add(btnBuscar);
	}
}
