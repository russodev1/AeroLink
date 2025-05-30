package voo;

import java.util.ArrayList;
import passageiro.Passageiro;
import aeronave.Aeronave;
import exceptions.LimPassageiroExc;

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

    public void cadastrarPassageiro(Passageiro p) throws LimPassageiroExc {
        if (!verificarDisponibilidade()) {
            throw new LimPassageiroExc("Capacidade máxima atingida para o voo " + codigo);
        }
        passageiros.add(p);
    }


    public ArrayList<Passageiro> getPassageiros() {
        return new ArrayList<>(passageiros);
    }

    public abstract boolean verificarDisponibilidade();

    public abstract void exibirDados();
    
    public String getCodigo() {return codigo;}
    
}
