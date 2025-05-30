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
    
     private boolean cpfJaNoVoo(String cpfParaVerificar) { 
        if (cpfParaVerificar == null || cpfParaVerificar.isEmpty()) { 
            return false;
        }
      
        for (int i = 0; i < this.passageiros.size(); i++) {
            Passageiro passageiroExistente = this.passageiros.get(i);

            if (passageiroExistente.getCpf() != null && passageiroExistente.getCpf().equals(cpfParaVerificar)) {
                return true; 
            }
        }
        return false; 
    }

    public void cadastrarPassageiro(Passageiro p) throws LimPassageiroExc {
        if (!verificarDisponibilidade()) {
            throw new LimPassageiroExc("Capacidade máxima atingida para o voo " + codigo);
        }
        if (p.getCpf() != null && cpfJaNoVoo(p.getCpf())) {
            throw new CpfDuplicadoExc("O CPF " + p.getCpf() + " já está cadastrado neste voo (" + codigo + ").");
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
