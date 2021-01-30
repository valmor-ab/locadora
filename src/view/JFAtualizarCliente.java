package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class JFAtualizarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEstadocivil;

	public static int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarCliente frame = new JFAtualizarCliente(id);
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
	public JFAtualizarCliente(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("ID do cliente");
		lblNewLabel_5.setBounds(151, 15, 84, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(223, 15, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("Atualizar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 119, 14);
		contentPane.add(lblNewLabel);
		
		ClienteDAO cdao = new ClienteDAO();
		Cliente c = cdao.read(id);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 60, 162, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 41, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(204, 60, 220, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail");
		lblNewLabel_2.setBounds(204, 41, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtEstadocivil = new JTextField();
		txtEstadocivil.setBounds(10, 133, 162, 20);
		contentPane.add(txtEstadocivil);
		txtEstadocivil.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Estado Civil");
		lblNewLabel_3.setBounds(10, 108, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JSpinner spIdade = new JSpinner();
		spIdade.setBounds(247, 133, 46, 20);
		contentPane.add(spIdade);
		
		JLabel lblNewLabel_4 = new JLabel("Idade");
		lblNewLabel_4.setBounds(247, 108, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		lblId.setText(String.valueOf(c.getIdCliente()));
		txtNome.setText(c.getNome());
		txtEmail.setText(c.getEmail());
		txtEstadocivil.setText(c.getEstadocivil());
		spIdade.setValue(c.getIdade());
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				c.setIdCliente(Integer.parseInt(lblId.getText()));
				c.setNome(txtNome.getText());
				c.setEmail(txtEmail.getText());
				c.setEstadocivil(txtEstadocivil.getText());
				c.setIdade(Integer.parseInt(spIdade.getValue().toString()));
				dao.update(c);
				dispose();
			}
		});
		btnAlterar.setBounds(10, 227, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(183, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(null);
				txtEmail.setText(null);
				txtEstadocivil.setText(null);
				spIdade.setValue(0);
			}
		});
		btnLimpar.setBounds(335, 227, 89, 23);
		contentPane.add(btnLimpar);
	}

}
