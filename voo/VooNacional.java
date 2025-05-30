package voo;

import passageiro.Passageiro;
import aeronave.Aeronave;

public class VooNacional extends Voo {

    public VooNacional(String codigo, String data, String horario, String origem, String destino, Aeronave aeronave) {
        super(codigo, data, horario, origem, destino, aeronave);
    }

    @Override
    public boolean verificarDisponibilidade() {
        return passageiros.size() < aeronave.getCapacidade();
    }

    @Override
    public void exibirDados() {
        System.out.println("Voo Nacional: " + codigo + " de " + origem + " para " + destino);
    }
}