package pessoa;

public abstract class Pessoa {
    private String nome;
    private String nacionalidade;

    public Pessoa(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public abstract void exibirDados();
}
