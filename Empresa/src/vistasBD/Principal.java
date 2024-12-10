package vistasBD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("A\u00D1ADIR DEPARTAMENTO");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(27, 442, 298, 56);
		contentPane.add(btnNewButton);
		
		JButton btnModificarDepartamento = new JButton("MODIFICAR DEPARTAMENTO");
		btnModificarDepartamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnModificarDepartamento.setBounds(335, 442, 298, 56);
		contentPane.add(btnModificarDepartamento);
		
		JButton btnNewButton_1_1 = new JButton("A\u00D1ADIR DEPARTAMENTO");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(27, 532, 298, 56);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("A\u00D1ADIR DEPARTAMENTO");
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1_1.setBounds(335, 532, 298, 56);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnGetDepartamentos = new JButton("MOSTRAR DEPARTAMENTOS");
		btnGetDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarDepartamentos form = new MostrarDepartamentos();
				form.setVisible(true);
			}
		});
		btnGetDepartamentos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnGetDepartamentos.setBounds(27, 274, 408, 56);
		contentPane.add(btnGetDepartamentos);
		
		JButton btnBuscarDepartamento = new JButton("BUSCAR DEPARTAMENTO POR CODIGO");
		btnBuscarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscarDepartamento.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBuscarDepartamento.setBounds(27, 180, 408, 56);
		contentPane.add(btnBuscarDepartamento);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(27, 137, 67, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 16));
		textField.setBounds(93, 137, 71, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblGestionDeDepartamentos = new JLabel("GESTION DE DEPARTAMENTOS Y EMPLEADOS");
		lblGestionDeDepartamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDeDepartamentos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblGestionDeDepartamentos.setBounds(180, 25, 619, 48);
		contentPane.add(lblGestionDeDepartamentos);
	}
}
