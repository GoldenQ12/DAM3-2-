package vistasBD;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionClientes extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionClientes dialog = new GestionClientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionClientes() {
		setBounds(100, 100, 879, 588);
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
					if (respuesta == JOptionPane.YES_OPTION) {
						dispose();
					}	
				}
			});
			btnVolver.setForeground(Color.RED);
			btnVolver.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnVolver.setBounds(660, 454, 187, 84);
			contentPanel.add(btnVolver);
		}
		{
			JButton btnAltaClientes = new JButton("ALTA CLIENTES");
			btnAltaClientes.setForeground(new Color(0, 128, 192));
			btnAltaClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnAltaClientes.setBounds(10, 108, 272, 84);
			contentPanel.add(btnAltaClientes);
		}
		{
			JButton btnGestinDeClientes = new JButton("BAJA CLIENTES");
			btnGestinDeClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BajaCliente form = new BajaCliente();
					form.setVisible(true);
				}
			});
			btnGestinDeClientes.setForeground(new Color(0, 128, 192));
			btnGestinDeClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnGestinDeClientes.setBounds(292, 108, 272, 84);
			contentPanel.add(btnGestinDeClientes);
		}
		{
			JButton btnModificacinDeClientes = new JButton("MODIFICAR CLIENTE");
			btnModificacinDeClientes.setForeground(new Color(0, 128, 192));
			btnModificacinDeClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnModificacinDeClientes.setBounds(575, 108, 272, 84);
			contentPanel.add(btnModificacinDeClientes);
		}
		{
			JButton btnConsultasDeClientes = new JButton("CONSULTAS DE CLIENTES");
			btnConsultasDeClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MostrarClientes form = new MostrarClientes();
					form.setVisible(true);
				}
			});
			btnConsultasDeClientes.setForeground(new Color(0, 128, 192));
			btnConsultasDeClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnConsultasDeClientes.setBounds(10, 203, 411, 84);
			contentPanel.add(btnConsultasDeClientes);
		}
		{
			JLabel lblGestionDeClientes = new JLabel("GESTION DE CLIENTES");
			lblGestionDeClientes.setHorizontalAlignment(SwingConstants.CENTER);
			lblGestionDeClientes.setForeground(new Color(204, 173, 0));
			lblGestionDeClientes.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
			lblGestionDeClientes.setBounds(0, 34, 873, 35);
			contentPanel.add(lblGestionDeClientes);
		}
		
		JButton btnConsultasDeClientes_3 = new JButton("CONSULTAS DE CLIENTES  POR VENDEDOR");
		btnConsultasDeClientes_3.setForeground(new Color(0, 128, 192));
		btnConsultasDeClientes_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConsultasDeClientes_3.setBounds(10, 298, 837, 84);
		contentPanel.add(btnConsultasDeClientes_3);
		
		JButton btnConsultasDeClientes_2 = new JButton("CONSULTAS DE CLIENTES POR PAIS");
		btnConsultasDeClientes_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarClientesPorPais form = new MostrarClientesPorPais(1);
				form.setVisible(true);
			}
		});
		btnConsultasDeClientes_2.setForeground(new Color(0, 128, 192));
		btnConsultasDeClientes_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnConsultasDeClientes_2.setBounds(436, 203, 411, 84);
		contentPanel.add(btnConsultasDeClientes_2);
	}
}
