package exemplo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

@SuppressWarnings("serial")
public class FrmExemplo extends JFrame {

	private JPanel jContentPane;

	private JLabel lblNumero1;
	private JLabel lblNumero2;

	private JTextField txtNumero1;
	private JTextField txtNumero2;

	private JButton btnCalcular;

	private JButton getBtnCalcular() {
		btnCalcular = new JButton();
		btnCalcular.setBounds(new Rectangle(155, 179, 110, 37));
		btnCalcular.setText("Calcular");
		btnCalcular.addActionListener(calcular());
		return btnCalcular;
	}

	private JPanel getJContentPane() {

		lblNumero1 = new JLabel();
		lblNumero1.setBounds(new Rectangle(25, 0, 427, 42));
		lblNumero1.setText("Número 1:");

		txtNumero1 = new JTextField();
		txtNumero1.setBounds(new Rectangle(120, 6, 280, 28));

		lblNumero2 = new JLabel();
		lblNumero2.setBounds(new Rectangle(25, 35, 427, 42));
		lblNumero2.setText("Número 2:");

		txtNumero2 = new JTextField();
		txtNumero2.setBounds(new Rectangle(120, 41, 120, 28));

		jContentPane = new JPanel();
		jContentPane.setLayout(null);
		jContentPane.setBackground(Color.white);

		jContentPane.add(lblNumero1, null);
		jContentPane.add(txtNumero1, null);

		jContentPane.add(lblNumero2, null);
		jContentPane.add(txtNumero2, null);

		jContentPane.add(getBtnCalcular(), null);

		return jContentPane;
	}

	private void initialize() {
		this.setSize(420, 280);
		this.setContentPane(getJContentPane());
		this.setTitle("Calculadora - Divisão");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public FrmExemplo() {
		super();
		initialize();
	}

	private ActionListener calcular() {
		return (event) -> {

			if (txtNumero1.getText().equals("")) {
				showMessageDialog(this, "Campo 'Número 1' é obrigatório");
				return;
			}

			if (txtNumero2.getText().equals("")) {
				showMessageDialog(this, "Campo 'Número 2' é obrigatório");
				return;
			}

			if (!txtNumero1.getText().matches("[0-9]+")) {
				showMessageDialog(this, "Campo 'Número 1' deve ser um número");
				return;
			}

			if (!txtNumero2.getText().matches("[0-9]+")) {
				showMessageDialog(this, "Campo 'Número 2' deve ser um número");
				return;
			}

			Long num1 = Long.parseLong(txtNumero1.getText());
			Long num2 = Long.parseLong(txtNumero2.getText());
			showMessageDialog(this, "Resultado: " + new CalculoService().dividir(num1, num2));

		};
	}
	
}
