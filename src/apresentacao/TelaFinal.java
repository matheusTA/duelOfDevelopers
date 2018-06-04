package apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerJogador;
import entidades.Jogador;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaFinal extends JFrame {

	private JPanel contentPane;
	private String status;
	private JLabel lblStatusdojogo;
	private JLabel lblFimDeJogo;
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
		
		verificarVencedor();
		
		
		lblStatusdojogo = new JLabel("status");
		lblStatusdojogo.setFont(new Font("Dialog", Font.BOLD, 27));
		lblStatusdojogo.setBounds(42, 127, 705, 48);
		contentPane.add(lblStatusdojogo);
		lblStatusdojogo.setText(this.status);
		
		JLabel lblDadosjogador01 = new JLabel("dadosJogador01");
		lblDadosjogador01.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDadosjogador01.setBounds(85, 224, 241, 208);
		contentPane.add(lblDadosjogador01);
		lblDadosjogador01.setText(jogador01.toString() + "<br>Pontos: " + jogador01.getPontos());
		
		JLabel lblDadosjogador02 = new JLabel("dadosJogador02");
		lblDadosjogador02.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDadosjogador02.setBounds(375, 224, 241, 208);
		contentPane.add(lblDadosjogador02);
		lblDadosjogador02.setText(jogador02.toString() + "<br>Pontos: " + jogador02.getPontos());
		
		
		JButton btnSair = new JButton("Sair!");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finalizarJogo();
			}
		});
		btnSair.setBounds(652, 435, 117, 25);
		contentPane.add(btnSair);
	}
	
	private void finalizarJogo() {
		System.exit(0);
	}
	
	private void atualizarJogadores(double vencedor) throws ClassNotFoundException, IOException {
		if (vencedor == 1) {
			this.jogador01.setPartidasGanhas(this.jogador01.getPartidasGanhas() + 1);
			this.jogador02.setPartidasPerdidas(this.jogador02.getPartidasPerdidas() + 1);
			this.jogador01.setPontos(0);
		} else if (vencedor == 2) {
			this.jogador02.setPartidasGanhas(this.jogador02.getPartidasGanhas() + 1);
			this.jogador01.setPartidasPerdidas(this.jogador01.getPartidasPerdidas() + 1);
			this.jogador02.setPontos(0);
		}

		controllerJogador.atualizarJogador(this.jogador01);
		controllerJogador.atualizarJogador(this.jogador02);
	}
	
	private void verificarVencedor() {
		double pontosJogador01 = this.jogador01.getPontos();
		double pontosJogador02 = this.jogador02.getPontos();
		double vencedor = 0;
		
		if(pontosJogador01 > pontosJogador02) {
			this.status = "O vencedor foi " + jogador01.getNome();
			vencedor = 1;
		}else if(pontosJogador02 > pontosJogador01){
			this.status = "O vencedor foi " + jogador02.getNome();
			vencedor = 2;
		}else {
			this.status = "A partida deu empate";
		}
		
		try {
			atualizarJogadores(vencedor);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
