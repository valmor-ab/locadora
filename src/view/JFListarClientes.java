package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.dao.ClienteDAO;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable JTCliente;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
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
	public JFListarClientes() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				readJTable();
			}
			public void windowLostFocus (WindowEvent e) {
				
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 23, 558, 227);
		contentPane.add(scrollPane);
		
	
		JTCliente = new JTable();
		JTCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Idade", "Email", "Estado Civil"
			}
		));
		scrollPane.setViewportView(JTCliente);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarCliente cc = new JFCadastrarCliente();
				cc.setVisible(true);
			}
		});
		
		btnCadastrar.setBounds(22, 272, 117, 51);
		contentPane.add(btnCadastrar);
		
		JButton btnNewButton_1 = new JButton("Alterar Cliente");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(JTCliente.getSelectedRow()!= -1) {
					JFAtualizarCliente ac = new JFAtualizarCliente(
							(int)JTCliente.getValueAt(JTCliente.getSelectedRow(), 0));
					ac.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um Cliente!");
				}
				readJTable();
			
		}
	});
		btnNewButton_1.setBounds(310, 272, 133, 51);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(177, 272, 89, 51);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTCliente.getSelectedRow() != -1) {
					
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado?"
							,"Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						ClienteDAO dao = new ClienteDAO();
						Cliente f = new Cliente();
						f.setIdCliente((int) JTCliente.getValueAt(JTCliente.getSelectedRow(), 0));
						dao.delete(f);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um Cliente!");
				}
				readJTable();
		}
		}	);
		btnNewButton_3.setBounds(470, 272, 89, 51);
		contentPane.add(btnNewButton_3);
		readJTable();
	}
		public void readJTable() {
			DefaultTableModel modelo = (DefaultTableModel) JTCliente.getModel();
			modelo.setNumRows(0);
			ClienteDAO fdao = new ClienteDAO();
			for(Cliente f : fdao.read()) {
				modelo.addRow(new Object[] {
						f.getIdCliente(),
						f.getNome(),
						f.getIdade(),
						f.getEmail(),
						f.getEstadocivil()
				});
			}
			
	}
}
