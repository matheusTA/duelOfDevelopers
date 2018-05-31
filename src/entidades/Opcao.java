package entidades;

import java.awt.image.BufferedImage;

public class Opcao {

    private BufferedImage imagem;
    private boolean correto;

    public Opcao(BufferedImage imagem, boolean correto) {
        this.imagem = imagem;
        this.correto = correto;
    }

    public BufferedImage getImagem() {
        return imagem;
    }

    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }

    public boolean isCorreto() {
        return correto;
    }

    public void setCorreto(boolean correto) {
        this.correto = correto;
    }

}