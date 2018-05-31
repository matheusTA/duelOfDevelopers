package dados;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import entidades.Jogador;

public class DaoJogador implements Serializable {

    public void salvarJogador(ArrayList<Jogador> jogadores) throws IOException {

        FileOutputStream fos = new FileOutputStream("/home/matheus/Documentos/java project/duelOfDevelopers/jogadores.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(jogadores);

        oos.flush();
        fos.flush();

        oos.close();
        fos.close();
    }

    public ArrayList<Jogador> lerJogador() throws IOException, ClassNotFoundException {
        ArrayList<Jogador> jogadores = null;

        if (estaVazio()) {
            jogadores = new ArrayList<>();
        } else {
            FileInputStream fis = new FileInputStream("/home/matheus/Documentos/java project/duelOfDevelopers/jogadores.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            jogadores = (ArrayList<Jogador>) ois.readObject();

            ois.close();
            fis.close();

            ois.close();
            fis.close();
        }
        return jogadores;
    }

    private boolean estaVazio() throws IOException {

        FileReader fileReader = new FileReader("/home/matheus/Documentos/java project/duelOfDevelopers/jogadores.txt");
        BufferedReader buffer = new BufferedReader(fileReader);

        String primeiraLinha = buffer.readLine();

        buffer.close();
        fileReader.close();

        if (primeiraLinha != null) {
            if (!primeiraLinha.trim().equals("")) {
                return false;
            }
        }

        return true;
    }
}