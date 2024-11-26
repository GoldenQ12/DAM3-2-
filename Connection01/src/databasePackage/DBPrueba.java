package databasePackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DBPrueba extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDesc;
	private JTextField txtPrecio;
	private JTextField txtCod;
	private JLabel lblDescripcionDelArtiuclo;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBPrueba frame = new DBPrueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DBPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(149, 62, 156, 31);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(149, 104, 156, 31);
		contentPane.add(txtPrecio);
		
		txtCod = new JTextField();
		txtCod.setColumns(10);
		txtCod.setBounds(149, 151, 156, 31);
		contentPane.add(txtCod);
		
		JButton btnNewButton = new JButton("Consulta por código");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_empresa", "root", "");
					Statement sentencia = conexion.createStatement();
					ResultSet rs = sentencia.executeQuery("SELECT codigo, descripcion, precio FROM articulos WHERE codigo = " + txtCod.getText());
					if (rs.next() == true) {
						txtDesc.setText(rs.getString("descripcion"));
						txtPrecio.setText(rs.getString("precio"));
					} else {
						System.out.println("Hello");
					}
				} catch (Exception ex) {
					setTitle(ex.toString());
				}
				
			}
		});
		btnNewButton.setBounds(10, 193, 127, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(149, 193, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Resultado");
		lblNewLabel.setBounds(235, 227, 189, 23);
		contentPane.add(lblNewLabel);
		
		lblDescripcionDelArtiuclo = new JLabel("Descripcion del artiuclo");
		lblDescripcionDelArtiuclo.setBounds(10, 66, 129, 23);
		contentPane.add(lblDescripcionDelArtiuclo);
		
		lblNewLabel_2 = new JLabel("Precio");
		lblNewLabel_2.setBounds(10, 112, 97, 23);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Codigo");
		lblNewLabel_3.setBounds(10, 159, 97, 23);
		contentPane.add(lblNewLabel_3);
		
		cargarDriver();
	}
	
	private void cargarDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			setTitle(ex.toString());
		}
	}
}
