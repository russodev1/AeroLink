package passageiro;

import pessoa.Pessoa;

public class Passageiro extends Pessoa implements Validavel {
    private String cpf;
    private String passaporte;

    public Passageiro(String nome, String cpf, String passaporte, String nacionalidade) {
        super(nome, nacionalidade);
        this.cpf = cpf;
        this.passaporte = passaporte;
    }

    @Override
    public boolean validarDocumentos() {
        return cpf != null || passaporte != null;
    }

    @Override
    public void exibirDados() {
        System.out.println("Passageiro: " + getNome() + " - Nacionalidade: " + getNacionalidade());
    }

    @Override
    public String toString() {
        return getNome() + " (" + getNacionalidade() + ")";
    }
}
