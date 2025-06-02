package modelos;

public class Passageiro extends Pessoa {
    public Passageiro(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Passageiro: " + nome + " | CPF: " + cpf);
    }
}
