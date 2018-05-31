package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import dados.DaoPergunta;
import entidades.Opcao;
import entidades.Pergunta;

public class ControllerPergunta {

    public Pergunta selecionarPergunta(int index, Pergunta[] perguntas) {
        return perguntas[index];
    }
    
    public boolean respostaCorreta(Pergunta pergunta, int index) {
        return pergunta.getOpcoes()[index].isCorreto();
    }
   
    public Pergunta[] carregarPerguntas() throws IOException {

        ArrayList<String[]> perguntasTexto = DaoPergunta.lerArquivoPerguntas();
        Pergunta[] perguntas = new Pergunta[perguntasTexto.size()];

        for (int i = 0; i < perguntasTexto.size(); i++) {

            String[] perguntaLinha = perguntasTexto.get(i);
            String textoPergunta = perguntaLinha[0];

            String textoOpcaoA = perguntaLinha[1];
            BufferedImage imagemOpcaoA = ImageIO.read(new File(textoOpcaoA));
            String booleanOpcaoA = perguntaLinha[2];
            Opcao opcaoA = new Opcao(imagemOpcaoA, Boolean.parseBoolean(booleanOpcaoA));

            String textoOpcaoB = perguntaLinha[3];
            BufferedImage imagemOpcaoB = ImageIO.read(new File(textoOpcaoB));
            String respostaB = perguntaLinha[4];
            Opcao opcaoB = new Opcao(imagemOpcaoB, Boolean.parseBoolean(respostaB));
            
            Opcao[] opcoes = {opcaoA, opcaoB};

            Pergunta pergunta = null;
            pergunta = new Pergunta(textoPergunta, opcoes);
            perguntas[i] = pergunta;
        }
        return perguntas;
    }
}