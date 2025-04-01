package exemplo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static javax.swing.JOptionPane.showMessageDialog;

@SuppressWarnings("serial")
public class FrmExemplo extends JFrame {

	private JPanel jContentPane;

	private JLabel lblNome;
	private JLabel lblCPF;
	private JLabel lblNascimento;

	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtNascimento;

	private JButton btnCadastrar;

	private JButton getBtnCadastrar() {
		btnCadastrar = new JButton();
		btnCadastrar.setBounds(new Rectangle(155, 179, 110, 37));
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.addActionListener(cadastrar());
		return btnCadastrar;
	}

	private JPanel getJContentPane() {

		lblNome = new JLabel();
		lblNome.setBounds(new Rectangle(25, 0, 427, 42));
		lblNome.setText("Nome:");

		txtNome = new JTextField();
		txtNome.setBounds(new Rectangle(120, 6, 280, 28));

		lblCPF = new JLabel();
		lblCPF.setBounds(new Rectangle(25, 35, 427, 42));
		lblCPF.setText("CPF:");

		txtCPF = new JTextField();
		txtCPF.setBounds(new Rectangle(120, 41, 180, 28));

		lblNascimento = new JLabel();
		lblNascimento.setBounds(new Rectangle(25, 70, 427, 42));
		lblNascimento.setText("Nascimento:");

		txtNascimento = new JFormattedTextField();
		txtNascimento.setBounds(new Rectangle(120, 76, 180, 28));

		jContentPane = new JPanel();
		jContentPane.setLayout(null);
		jContentPane.setBackground(Color.white);

		jContentPane.add(lblNome, null);
		jContentPane.add(txtNome, null);

		jContentPane.add(lblCPF, null);
		jContentPane.add(txtCPF, null);

		jContentPane.add(lblNascimento, null);
		jContentPane.add(txtNascimento, null);

		jContentPane.add(getBtnCadastrar(), null);

		return jContentPane;
	}

	private void initialize() {
		this.setSize(420, 280);
		this.setContentPane(getJContentPane());
		this.setTitle("Cadastro de Cliente");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public FrmExemplo() {
		super();
		initialize();
	}

	private ActionListener cadastrar() {
		return (event) -> {

			if (txtNome.getText().equals("")) {
				showMessageDialog(this, "Campo 'Nome' é obrigatório");
				return;
			}

			if (txtCPF.getText().equals("")) {
				showMessageDialog(this, "Campo 'CPF' é obrigatório");
				return;
			}

			if (txtNascimento.getText().equals("")) {
				showMessageDialog(this, "Campo 'Nascimento' é obrigatório");
				return;
			}

			if (!txtNascimento.getText().matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$")) {
				showMessageDialog(this, "Campo 'Nascimento' deve estar no formato 'dd/MM/yyyy'");
				return;
			}

			new ClienteService().salvar(buildCliente());
			showMessageDialog(this, "Cadastro realizado com sucesso");

		};
	}

	private Cliente buildCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome(txtNome.getText());
		cliente.setCpf(txtCPF.getText());
		cliente.setNascimento(LocalDate.parse(txtNascimento.getText(),  DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		return cliente;
	}

}
