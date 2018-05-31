package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dados.DaoJogador;
import entidades.Jogador;

public class ControllerJogador implements Serializable {

    DaoJogador daoJogador = new DaoJogador();

    public void criar(Jogador jogador) throws ClassNotFoundException, IOException {
        ArrayList<Jogador> jogadores = daoJogador.lerJogador();
        jogadores.add(jogador);
        daoJogador.salvarJogador(jogadores);
    }

    public Jogador pegar(String login, String senha) throws ClassNotFoundException, IOException {
        ArrayList<Jogador> jogadores = daoJogador.lerJogador();
        
        for (Jogador jogador : jogadores) {
            if (jogador.getLogin().equals(login) && jogador.getSenha().equals(senha)) {
                return jogador;
            }
        }
       
        return null;
    }
    
    public void atualizarJogador(Jogador jogador) throws ClassNotFoundException, IOException {
    	ArrayList<Jogador> jogadores = daoJogador.lerJogador();
    	
    	for(int i = 0; i < jogadores.size(); i++) {
    		if(jogador.getLogin().equals(jogadores.get(i).getLogin())  && jogador.getSenha().equals(jogadores.get(i).getSenha())) {
    			jogadores.remove(i);
    			jogadores.add(jogador);
    			break;
    		}
    	}
    	
    	daoJogador.salvarJogador(jogadores);
    }
}