package apresentacao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerJogador;
import entidades.Jogador;

public class TelaFinal extends JFrame {

	private JPanel contentPane;
	private String status;
	private JLabel lblStatusdojogo;
	private JLabel lblFimDeJogo;
	private JLabel lblDadosjogador01;
	private JLabel lblDadosjogador02;
	private ControllerJogador controllerJogador;
	private Jogador jogador01, jogador02;

	public TelaFinal(Jogador jogador01, Jogador jogador02) throws ClassNotFoundException, IOException {
		controllerJogador = new ControllerJogador();
		this.jogador01 = jogador01;
		this.jogador02 = jogador02;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblFimDeJogo = new JLabel("Fim De Jogo!");
		lblFimDeJogo.setFont(new Font("Dialog", Font.BOLD, 30));
		lblFimDeJogo.setBounds(263, 29, 241, 79);
		contentPane.add(lblFimDeJogo);

		lblStatusdojogo = new JLabel("status");
		lblStatusdojogo.setFont(new Font("Dialog", Font.BOLD, 27));
		lblStatusdojogo.setBounds(42, 127, 705, 48);
		contentPane.add(lblStatusdojogo);
		lblStatusdojogo.setText(this.status);

		lblDadosjogador01 = new JLabel("dadosJogador01");
		lblDadosjogador01.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDadosjogador01.setBounds(85, 224, 241, 208);
		contentPane.add(lblDadosjogador01);

		lblDadosjogador02 = new JLabel("dadosJogador02");
		lblDadosjogador02.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDadosjogador02.setBounds(375, 224, 241, 208);
		contentPane.add(lblDadosjogador02);

		JButton btnSair = new JButton("Sair!");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(652, 435, 117, 25);
		contentPane.add(btnSair);

		verificarVencedor();
	}

	private void verificarVencedor() {

		String mensagemFinal = "";

		if (this.jogador01.getPontos() > this.jogador02.getPontos()) {
			mensagemFinal = "JOGADOR " + this.jogador01.getNome() + " É O VENCEDOR!";
			this.jogador01.setPartidasGanhas(this.jogador01.getPartidasGanhas() + 1);
			this.jogador02.setPartidasPerdidas(this.jogador02.getPartidasPerdidas() + 1);
			
		} else if (this.jogador01.getPontos() < this.jogador02.getPontos()) {
			mensagemFinal = "JOGADOR " + this.jogador02.getNome() + " É O VENCEDOR!";
			this.jogador02.setPartidasGanhas(this.jogador02.getPartidasGanhas() + 1);
			this.jogador01.setPartidasPerdidas(this.jogador01.getPartidasPerdidas() + 1);
			
		} else {
			mensagemFinal = "PARTIDA ACABOU EMPATADA!";
		}
		this.lblStatusdojogo.setText(mensagemFinal);
		lblDadosjogador01.setText(this.jogador01.toString() + "<br>Pontos: " + this.jogador01.getPontos());
		lblDadosjogador02.setText(this.jogador02.toString() + "<br>Pontos: " + this.jogador02.getPontos());
		try {
			this.jogador01.setPontos(0);
			this.jogador02.setPontos(0);
			this.controllerJogador.atualizarJogador(this.jogador01);
			this.controllerJogador.atualizarJogador(this.jogador02);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
