package entidades;

public class Pergunta {

    private String textoPergunta;
    private Opcao[] opcoes;

    public Pergunta(String textoPergunta, Opcao[] opcoes) {
        this.textoPergunta = textoPergunta;
        this.opcoes = opcoes;
    }

    public String getTextoPergunta() {
        return textoPergunta;
    }

    public void setTextoPergunta(String textoPergunta) {
        this.textoPergunta = textoPergunta;
    }

    public Opcao[] getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(Opcao[] opcoes) {
        this.opcoes = opcoes;
    }

    public String toString() {
        String menssagem = this.textoPergunta;
        
        
        return menssagem;
    }

}