package apresentacao;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerJogador;
import controller.ControllerPergunta;
import entidades.Jogador;
import entidades.Opcao;
import entidades.Pergunta;

@SuppressWarnings("serial")
public class TelaPergunta extends JFrame {

	private static int contadorDePerguntas = 0;
	private JPanel contentPane;
	private Pergunta[] perguntas;
	private Pergunta perguntaAtual;
	private ControllerPergunta controllerPergunta;
	private JLabel JLperguntas;
	private Jogador jogador01, jogador02;
	private JLabel lblDadosjogador;
	private boolean finalizarJogo = false;

	private JLabel opcaoA;
	private JLabel opcaoB;

	public TelaPergunta(Jogador jogador01, Jogador jogador02) {

		this.jogador01 = jogador01;
		this.jogador02 = jogador02;

		controllerPergunta = new ControllerPergunta();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLperguntas = new JLabel("JLPerguntas");
		JLperguntas.setBounds(10, 72, 766, 44);
		contentPane.add(JLperguntas);

		lblDadosjogador = new JLabel("DadosJogador");
		lblDadosjogador.setBounds(10, 11, 224, 59);
		contentPane.add(lblDadosjogador);

		try {
			iniciarJogo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			exibirProximaPergunta(JLperguntas);
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		opcaoA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					verificaResposta(0);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		opcaoB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					verificaResposta(1);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

	}

	private Jogador retornarJogadorDaVez() {
		return this.contadorDePerguntas % 2 == 0 ? this.jogador01 : this.jogador02;
	}

	private void exibirPergunta(Pergunta pergunta) {

		exibirJogador(retornarJogadorDaVez());

		Opcao[] opcoes = this.perguntaAtual.getOpcoes();

		this.JLperguntas.setText(pergunta.getTextoPergunta());
		if (opcaoA == null && opcaoB == null) {

			opcaoA = new JLabel(new ImageIcon(opcoes[0].getImagem()));
			opcaoA.setBounds(10, 127, 450, 450);
			contentPane.add(opcaoA);

			opcaoB = new JLabel(new ImageIcon(opcoes[1].getImagem()));
			opcaoB.setBounds(457, 127, 450, 450);
			contentPane.add(opcaoB);

		} else {
			opcaoA.setIcon(new ImageIcon(opcoes[0].getImagem()));
			opcaoB.setIcon(new ImageIcon(opcoes[1].getImagem()));
		}

	}

	private void exibirProximaPergunta(JLabel JLtexto) throws ClassNotFoundException, IOException {
		if (isUltimaPergunta()) {
			trocaTelaFinal(this.jogador01, this.jogador02);
		} else {
			this.perguntaAtual = this.controllerPergunta.selecionarPergunta(this.contadorDePerguntas, this.perguntas);
			exibirPergunta(this.perguntaAtual);

		}

	}

	private void addContadorPerguntas() {
		this.contadorDePerguntas++;
	}

	private void iniciarJogo() throws IOException {
		this.perguntas = this.controllerPergunta.carregarPerguntas();
	}

	private void verificaResposta(int resposta) throws ClassNotFoundException, IOException {
		boolean resultadoDaResposta = controllerPergunta.respostaCorreta(this.perguntaAtual, resposta);
		Jogador play = retornarJogadorDaVez();

		if (resultadoDaResposta == true) {
			if (play.getNome() == this.jogador01.getNome()) {
				this.jogador01.setPontos(this.jogador01.getPontos() + 1);

			} else {
				this.jogador02.setPontos(this.jogador02.getPontos() + 1);

			}
			addContadorPerguntas();
			exibirProximaPergunta(this.JLperguntas);
		} else {
			addContadorPerguntas();
			exibirProximaPergunta(this.JLperguntas);
		}
	}

	private void exibirJogador(Jogador jogador) {
		this.lblDadosjogador.setText(jogador.toString());
		if (jogador == this.jogador01) {
			Color corJogador01 = new Color(135, 206, 235);
			contentPane.setBackground(corJogador01);
		} else {
			Color corJogador02 = new Color(255, 182, 193);
			contentPane.setBackground(corJogador02);
		}
	}

	private boolean isUltimaPergunta() {
		return this.perguntaAtual == this.perguntas[this.perguntas.length - 1];
	}

	private void trocaTelaFinal(Jogador jogador01, Jogador jogador02) throws ClassNotFoundException, IOException {
		this.setVisible(false);
		TelaFinal telaFinal = new TelaFinal(jogador01, jogador02);
		telaFinal.show();
	}

}
