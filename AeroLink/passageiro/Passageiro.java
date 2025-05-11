package passageiro;

public class Passageiro implements Validavel {
    private String nome;
    private String cpf;
    private String passaporte;
    private String nacionalidade;

    public Passageiro(String nome, String cpf, String passaporte, String nacionalidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nacionalidade = nacionalidade;
    }

    @Override
    public boolean validarDocumentos() {
        return cpf != null || passaporte != null;
    }

    public void exibirDados() {
        System.out.println("Passageiro: " + nome + " - Nacionalidade: " + nacionalidade);
    }
}