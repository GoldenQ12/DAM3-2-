package databasePackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

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
		txtDesc.setBounds(118, 62, 156, 31);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(118, 104, 156, 31);
		contentPane.add(txtPrecio);
		
		txtCod = new JTextField();
		txtCod.setColumns(10);
		txtCod.setBounds(118, 151, 156, 31);
		contentPane.add(txtCod);
		
		JButton btnConsulta = new JButton("Consulta por código");
		btnConsulta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConsulta.addActionListener(new ActionListener() {
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
		btnConsulta.setBounds(10, 193, 264, 57);
		contentPane.add(btnConsulta);
		
		JButton btnAlta = new JButton("Alta");
		btnAlta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bd_empresa", "root", "");
					Statement sentencia = conexion.createStatement();
					String sql = "INSERT INTO articulos (descripcion, precio) VALUES ('" + 
				             txtDesc.getText().replace("'", "''") + "', " + 
				             Double.parseDouble(txtPrecio.getText()) + ")";
					sentencia.execute(sql);
					JOptionPane.showConfirmDialog(null, "Agregado correctamente", "Agregado correctamente", JOptionPane.DEFAULT_OPTION);
				} catch (Exception ex) {
					setTitle(ex.toString());
				}
			}
		});
		btnAlta.setBounds(284, 193, 140, 57);
		contentPane.add(btnAlta);
		
		lblDescripcionDelArtiuclo = new JLabel("Descripción:");
		lblDescripcionDelArtiuclo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescripcionDelArtiuclo.setBounds(10, 66, 156, 23);
		contentPane.add(lblDescripcionDelArtiuclo);
		
		lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 112, 97, 23);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Codigo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(10, 159, 97, 23);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblArticulosDemo = new JLabel("ARTICULOS DEMO");
		lblArticulosDemo.setHorizontalAlignment(SwingConstants.CENTER);
		lblArticulosDemo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblArticulosDemo.setBounds(10, 11, 414, 40);
		contentPane.add(lblArticulosDemo);
		
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
