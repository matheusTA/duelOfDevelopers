package dados;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import entidades.Pergunta;

public class DaoPergunta {

	public static ArrayList<String[]> lerArquivoPerguntas() {
		String line = "";
		String cvsSplitBy = ";";

		ArrayList<String[]> linhasTotais = new ArrayList<String[]>();

		try (BufferedReader br = new BufferedReader(
				new FileReader("/home/matheus/Documentos/java project/duelOfDevelopers/Perguntas.csv"))) {

			while ((line = br.readLine()) != null) {
				String[] linha = line.split(cvsSplitBy);
				linhasTotais.add(linha);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return linhasTotais;
	}

	public ArrayList<Image[]> lerImagemDoArquivo(int posicaoImagem) {
		ArrayList<String[]> perguntasTexto = DaoPergunta.lerArquivoPerguntas();
		Pergunta[] perguntas = new Pergunta[perguntasTexto.size()];

		for (int i = 0; i < perguntasTexto.size(); i++) {

			String[] perguntaLinha = perguntasTexto.get(i);

			String textoOpcaoA = perguntaLinha[1];
			String textoOpcaoB = perguntaLinha[3];
		}

		return null;
	}

}