package voo;

import passageiro.Passageiro;
import aeronave.Aeronave;

public class VooInternacional extends Voo {

    public VooInternacional(String codigo, String data, String horario, String origem, String destino, Aeronave aeronave) {
        super(codigo, data, horario, origem, destino, aeronave);
    }

    @Override
    public boolean verificarDisponibilidade() {
        return passageiros.size() < aeronave.getCapacidade();
    }

    @Override
    public void exibirDados() {
        System.out.println("Voo Internacional: " + codigo + " de " + origem + " para " + destino);
    }
}