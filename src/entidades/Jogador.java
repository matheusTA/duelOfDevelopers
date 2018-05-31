package entidades;

import java.io.Serializable;

public class Jogador implements Serializable{

    private String nome, senha, login;
    private int partidasGanhas, partidasPerdidas, pontos;

    public Jogador(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.partidasPerdidas = 0;
        this.partidasGanhas = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPartidasGanhas() {
        return partidasGanhas;
    }

    public void setPartidasGanhas(int partidasGanhas) {
        this.partidasGanhas = partidasGanhas;
    }

    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }
    
    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String toString() {
        String menssagem = "<html>Nome: " + this.nome + "<br>Partidas ganhas: " + this.partidasGanhas
                + "<br>Partidas perdidas: " + this.partidasPerdidas;
        return menssagem;
    }
}