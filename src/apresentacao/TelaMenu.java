package apresentacao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class TelaMenu extends JFrame implements Serializable {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocarTelaLogin();
			}
		});
		btnJogar.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnJogar.setBounds(307, 197, 171, 48);
		contentPane.add(btnJogar);

		JButton btnCriarJogador = new JButton("Criar jogador");
		btnCriarJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocarTelaCriarJogador();
			}
		});
		btnCriarJogador.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnCriarJogador.setBounds(307, 257, 171, 48);
		contentPane.add(btnCriarJogador);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnSair.setBounds(307, 321, 171, 48);
		contentPane.add(btnSair);

		JLabel lblDuelOfDevelopers = new JLabel("Duel Of Developers");
		lblDuelOfDevelopers.setFont(new Font("Dialog", Font.BOLD, 25));
		lblDuelOfDevelopers.setBounds(251, 51, 330, 83);
		contentPane.add(lblDuelOfDevelopers);
		this.setLocationRelativeTo(null);
	}

	private void trocarTelaCriarJogador() {
		this.setVisible(false);
		TelaCriarJogador telaCriarJogador = new TelaCriarJogador();
		telaCriarJogador.show();
	}

	private void trocarTelaLogin() {
		this.setVisible(false);
		TelaLogin telaLogin = new TelaLogin();
		telaLogin.show();
	}
}