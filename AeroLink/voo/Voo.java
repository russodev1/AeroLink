package voo;

import passageiro.Passageiro;
import aeronave.Aeronave;
import java.util.ArrayList;

public abstract class Voo {
    protected String codigo;
    protected String data;
    protected String horario;
    protected String origem;
    protected String destino;
    protected ArrayList<Passageiro> passageiros;
    protected Aeronave aeronave;

    public Voo(String codigo, String data, String horario, String origem, String destino, Aeronave aeronave) {
        this.codigo = codigo;
        this.data = data;
        this.horario = horario;
        this.origem = origem;
        this.destino = destino;
        this.aeronave = aeronave;
        this.passageiros = new ArrayList<>();
    }

    public void cadastrarPassageiro(Passageiro p) {
        passageiros.add(p);
    }

    public abstract boolean verificarDisponibilidade();

    public abstract void exibirDados();
}