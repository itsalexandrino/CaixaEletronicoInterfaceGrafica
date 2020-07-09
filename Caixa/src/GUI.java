import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnEfetuarSaque;
	private JLabel lblMduloDoAdministrador;
	private JButton btnRelatorioCedulas;
	private JButton btnValorTotalDisponivel;
	private JButton btnReposicaoCedulas;
	private JButton btnCotaMinima;
	private JLabel lblMduloDeAmbos;
	private JButton btnSair;
	private CaixaEletronico ce = new CaixaEletronico();

	public GUI() {
		setResizable(false);

		setTitle("Caixa Eletr\u00F4nico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("M\u00F3dulo do Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 18, 264, 14);
		contentPane.add(lblNewLabel);

		btnEfetuarSaque = new JButton("Efetuar Saque");
		btnEfetuarSaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					if (Integer.parseInt(ce.pegaValorTotalDisponivel()) <= ce.cotaMinima) {
						JOptionPane.showMessageDialog(null, "Caixa Vazio: Chame o Operador");
					} else {
						int valor = Integer.parseInt(JOptionPane.showInputDialog("Informe o valor do saque: R$ "));
						String valorSaque = ce.sacar(valor);
						JOptionPane.showMessageDialog(null, valorSaque);
					}

				} catch (Exception e) {
					if (e.getMessage() != "null") {
						JOptionPane.showMessageDialog(null, "Digite apenas números inteiros.");
					}
				}

			}
		});
		btnEfetuarSaque.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEfetuarSaque.setBounds(10, 50, 264, 23);
		contentPane.add(btnEfetuarSaque);

		lblMduloDoAdministrador = new JLabel("M\u00F3dulo do Administrador:");
		lblMduloDoAdministrador.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMduloDoAdministrador.setBounds(10, 91, 264, 14);
		contentPane.add(lblMduloDoAdministrador);

		btnRelatorioCedulas = new JButton("Relatorio de C\u00E9dulas");
		btnRelatorioCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String relatorio = ce.pegaRelatorioCedulas();
				JOptionPane.showMessageDialog(null, relatorio);
			}
		});
		btnRelatorioCedulas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRelatorioCedulas.setBounds(10, 123, 264, 23);
		contentPane.add(btnRelatorioCedulas);

		btnValorTotalDisponivel = new JButton("Valor Total Dispon\u00EDvel");
		btnValorTotalDisponivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String disponivel = ce.pegaValorTotalDisponivel();
				JOptionPane.showMessageDialog(null, "Total disponível: R$ " + disponivel + ",00.");
			}
		});
		btnValorTotalDisponivel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnValorTotalDisponivel.setBounds(10, 164, 264, 23);
		contentPane.add(btnValorTotalDisponivel);

		btnReposicaoCedulas = new JButton("Reposi\u00E7\u00E3o de Cedulas");
		btnReposicaoCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int cedula = 0;
				int quantidade = 0;

				try {

					cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de qual nota deseja repor: "
							+ "\nNota de R$ 100,00 (Digite 100)" + "\nNota de R$ 50,00 (Digite 50) "
							+ "\nNota de R$ 20,00 (Digite 20) " + "\nNota de R$ 10,00 (Digite 10) "
							+ "\nNota de R$ 5,00 (Digite 5)" + "\nNota de R$ 2 (Digite 2)" + ""));

					// Enquanto não for digitada a nota corretamente o laço se
					// repete, pedindo que ela seja digitada
					while (cedula != 100 && cedula != 50 && cedula != 20 && cedula != 10 && cedula != 5	&& cedula != 2) {
						cedula = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de qual nota deseja repor."));
					}

					quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de notas que deseja inserir: "));

					ce.reposicaoCedulas(cedula, quantidade);

				} catch (Exception e2) {
					if (e2.getMessage() != "null") {
						JOptionPane.showMessageDialog(null, "Digite apenas números inteiros.");
					}
				}

			}
		});

		btnReposicaoCedulas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReposicaoCedulas.setBounds(10, 205, 264, 23);
		contentPane.add(btnReposicaoCedulas);

		btnCotaMinima = new JButton("Cota M\u00EDnima");
		btnCotaMinima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String min = ce.armazenaCotaMinima(
							Integer.parseInt(JOptionPane.showInputDialog("Informe a cota mínima: R$ ")));
					JOptionPane.showMessageDialog(null, min);
				} catch (Exception erro) {
					if (erro.getMessage() != "null") {
						JOptionPane.showMessageDialog(null, "Digite apenas números inteiros.");
					}
				}

			}
		});
		btnCotaMinima.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCotaMinima.setBounds(10, 246, 264, 23);
		contentPane.add(btnCotaMinima);

		lblMduloDeAmbos = new JLabel("M\u00F3dulo de Ambos:");
		lblMduloDeAmbos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMduloDeAmbos.setBounds(10, 287, 264, 14);
		contentPane.add(lblMduloDeAmbos);

		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setBounds(10, 319, 264, 23);
		contentPane.add(btnSair);
	}

}
