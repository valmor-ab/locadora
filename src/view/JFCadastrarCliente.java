package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSpinner;
import javax.swing.JButton;

public class JFCadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEstadocivil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCliente frame = new JFCadastrarCliente();
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
	public JFCadastrarCliente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 128, 19);
		contentPane.add(lblNewLabel);
		
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setNome(txtNome.getText());
				c.setEmail(txtEmail.getText());
				c.setIdade(Integer.parseInt(spIdade.getValue().toString()));
				c.setEstadocivil(txtEstadocivil.getText());
				dao.create(c);
				dispose();
				
			}
		});
		btnCadastrar.setBounds(38, 227, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(174, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText(null);
				txtEmail.setText(null);
				spIdade.setValue(0);
				txtEstadocivil.setText(null);
			}
		});
		btnLimpar.setBounds(307, 227, 89, 23);
		contentPane.add(btnLimpar);
	}
}
