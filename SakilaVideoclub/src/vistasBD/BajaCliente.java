package vistasBD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladoresBD.AddressController;
import controladoresBD.CustomerController;
import modelosBD.Adress;
import modelosBD.Customer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BajaCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtTienda;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtactive;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private CustomerController customer = new CustomerController();
	private AddressController addresses = new AddressController();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BajaCliente dialog = new BajaCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BajaCliente() {
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
		
		JLabel lblAltaCliente = new JLabel("ELIMINAR CLIENTE");
		lblAltaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaCliente.setForeground(new Color(204, 173, 0));
		lblAltaCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblAltaCliente.setBounds(0, 0, 701, 35);
		contentPanel.add(lblAltaCliente);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtID.setBounds(384, 79, 121, 35);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId.setBounds(197, 79, 177, 35);
		contentPanel.add(lblId);
		
		
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(
						null, 
						"Seguro que quieres eliminar a este cliente?", 
						"Confirmación", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.WARNING_MESSAGE);
				if (respuesta == JOptionPane.YES_OPTION) {
					if (customer.borrar(Integer.parseInt(txtID.getText()))) {
						JOptionPane.showMessageDialog(null, "No hay cliente con ID " + txtID.getText(), "Información", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Borrado correctamente " + txtID.getText(), "Eliminado", JOptionPane.INFORMATION_MESSAGE);
					}
				}	
			}
		});
		btnEliminar.setForeground(new Color(128, 0, 0));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEliminar.setBounds(197, 447, 138, 92);
		contentPanel.add(btnEliminar);
		
		JLabel lblId_1 = new JLabel("Tienda:");
		lblId_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1.setForeground(Color.BLACK);
		lblId_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId_1.setBounds(197, 119, 177, 35);
		contentPanel.add(lblId_1);
		
		txtTienda = new JTextField();
		txtTienda.setEnabled(false);
		txtTienda.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtTienda.setColumns(10);
		txtTienda.setBounds(384, 119, 120, 35);
		contentPanel.add(txtTienda);
		
		JLabel lblId_1_1 = new JLabel("Nombre:");
		lblId_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1_1.setForeground(Color.BLACK);
		lblId_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId_1_1.setBounds(65, 197, 177, 35);
		contentPanel.add(lblId_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
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
		txtApellido.setEnabled(false);
		txtApellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtApellido.setColumns(10);
		txtApellido.setBounds(179, 243, 446, 35);
		contentPanel.add(txtApellido);
		
		JLabel lblId_1_1_1_1 = new JLabel("Activo:");
		lblId_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblId_1_1_1_1.setForeground(Color.BLACK);
		lblId_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblId_1_1_1_1.setBounds(65, 381, 177, 35);
		contentPanel.add(lblId_1_1_1_1);
		
		txtactive = new JTextField();
		txtactive.setEnabled(false);
		txtactive.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtactive.setColumns(10);
		txtactive.setBounds(179, 381, 446, 35);
		contentPanel.add(txtactive);
		
		txtDireccion = new JTextField();
		txtDireccion.setEnabled(false);
		txtDireccion.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(179, 335, 446, 35);
		contentPanel.add(txtDireccion);
		
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
		txtEmail.setEnabled(false);
		txtEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(179, 289, 446, 35);
		contentPanel.add(txtEmail);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cust = customer.buscar(Integer.parseInt(txtID.getText()));
				if (cust == null) {
					JOptionPane.showMessageDialog(null, "No hay cliente con ID " + txtID.getText());
				}
				txtactive.setText(cust.getActive() == 1 ? "Activo" : "Inactivo");
				txtTienda.setText(cust.getStore_id() == 1 ? "Tienda 1 " : "Tienda 2");
				txtApellido.setText(cust.getLast_name());
				txtNombre.setText(cust.getFirst_name());
				txtDireccion.setText(addresses.buscar(cust.getAddress_id()).getAddress());
				txtEmail.setText(cust.getEmail());
				
			}
		});
		btnBuscar.setForeground(new Color(0, 128, 255));
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuscar.setBounds(345, 447, 138, 92);
		contentPanel.add(btnBuscar);
	}
}
