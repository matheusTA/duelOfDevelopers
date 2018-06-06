package apresentacao;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControllerJogador;
import entidades.Jogador;
import java.awt.Color;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin01;
	private JPasswordField txtSenha01;
	private JTextField txtLogin02;
	private JPasswordField txtSenha02;
	private Jogador jogadorLogado01, jogadorLogado02;

	ControllerJogador controllerJogador = new ControllerJogador();

	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblJogador = new JLabel("Jogador 1");
		lblJogador.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblJogador.setBounds(87, 32, 184, 41);
		contentPane.add(lblJogador);

		JLabel lblJogador_1 = new JLabel("Jogador 2");
		lblJogador_1.setFont(new Font("Bahnschrift", Font.PLAIN, 30));
		lblJogador_1.setBounds(518, 32, 180, 41);
		contentPane.add(lblJogador_1);

		JLabel lblLogin01 = new JLabel("Login:");
		lblLogin01.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblLogin01.setBounds(10, 144, 94, 25);
		contentPane.add(lblLogin01);

		JLabel lblSenha01 = new JLabel("Senha:");
		lblSenha01.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblSenha01.setBounds(10, 218, 82, 25);
		contentPane.add(lblSenha01);

		txtLogin01 = new JTextField();
		txtLogin01.setBounds(87, 146, 262, 25);
		contentPane.add(txtLogin01);
		txtLogin01.setColumns(10);

		txtSenha01 = new JPasswordField();
		txtSenha01.setBounds(87, 220, 262, 25);
		contentPane.add(txtSenha01);
		txtSenha01.setColumns(10);

		JButton btnLogarJogador01 = new JButton("Logar jogador 1");
		btnLogarJogador01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				jogadorLogado01 = logarUsuario(txtLogin01, txtSenha01, 1);

			}

		});
		btnLogarJogador01.setBounds(114, 277, 146, 25);
		contentPane.add(btnLogarJogador01);

		JLabel lblLogin02 = new JLabel("Login:");
		lblLogin02.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblLogin02.setBounds(433, 144, 82, 25);
		contentPane.add(lblLogin02);

		txtLogin02 = new JTextField();
		txtLogin02.setBounds(504, 146, 262, 25);
		contentPane.add(txtLogin02);
		txtLogin02.setColumns(10);

		JLabel lblSenha02 = new JLabel("Senha:");
		lblSenha02.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblSenha02.setBounds(426, 214, 82, 25);
		contentPane.add(lblSenha02);

		txtSenha02 = new JPasswordField();
		txtSenha02.setBounds(504, 214, 262, 25);
		contentPane.add(txtSenha02);
		txtSenha02.setColumns(10);

		JButton btnLogarJogador02 = new JButton("Logar Jogador 2");
		btnLogarJogador02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jogadorLogado02 = logarUsuario(txtLogin02, txtSenha02, 2);
			}
		});
		btnLogarJogador02.setBounds(552, 277, 146, 25);
		contentPane.add(btnLogarJogador02);

		JButton btnJogar = new JButton("Jogar");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jogadorLogado01 != null && jogadorLogado02 != null) {
					trocarTelaJogar(jogadorLogado01, jogadorLogado02);
				} else {
					JOptionPane.showMessageDialog(null, "Algum usuário não foi logado com sucesso");
				}
			}
		});
		btnJogar.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnJogar.setBounds(340, 354, 94, 33);
		contentPane.add(btnJogar);

		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocarTelaMenu();
			}
		});
		btnMenu.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnMenu.setBounds(340, 400, 94, 33);
		contentPane.add(btnMenu);
		this.setLocationRelativeTo(null);
	}

	private void trocarTelaMenu() {
		this.setVisible(false);
		TelaMenu telaMenu = new TelaMenu();
		telaMenu.show();
	}

	private void trocarTelaJogar(Jogador jogador01, Jogador jogador02) {
		this.setVisible(false);
		TelaPergunta telaPergunta = new TelaPergunta(jogador01, jogador02);
		telaPergunta.show();
	}

	private Jogador logarUsuario(JTextField login, JPasswordField senha, int i) {
		Jogador jogador, jogadorLogado;
		try {
			jogador = controllerJogador.pegar(login.getText(), senha.getText());
			if (jogador != null) {
				jogadorLogado = jogador;
				JOptionPane.showMessageDialog(null, "Jogador " + i + " logado com sucesso");
				return jogadorLogado;
			} else {
				JOptionPane.showMessageDialog(null, "Login ou senha incorreta, tente novamente.");
				txtLogin01.setText("");
				txtSenha01.setText("");
				return null;
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}