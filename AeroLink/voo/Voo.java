package voo;

import java.util.ArrayList;
import passageiro.Passageiro;
import aeronave.Aeronave;


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
    
    public String getCodigo() {
    	return codigo;
    }
    
    public String getData() {
    	return data;
    }
    
    public void setData(String data) {
    	this.data = data;
    }
    
    public String getHorario() {
    	return horario;
    }
    
    public void setHorario( String horario) {
    	this.horario= horario;
    }
    
    public String getOrigem() {
    	return origem;
    }
    
    public String getDestino() {
    	return destino;
    }
    
    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }
    
    public void cadastrarPassageiro(Passageiro p) {
        passageiros.add(p);
    }

    public ArrayList<Passageiro> getPassageiros() {
        return new ArrayList<>(passageiros);
    }
   
    
    public abstract boolean verificarDisponibilidade();
    
    public abstract void exibirDados() {
    	System.out.println("Código: " + codigo);
	    System.out.println("Data: " + data);
	    System.out.println("Horário: " + horario);
	    System.out.println("Origem: " + origem);
	    System.out.println("Destino: " + destino);
	    System.out.println("Aeronave: " + aeronave);

	    System.out.println("Passageiros:");
	    for (Passageiro p : passageiros) {
	        System.out.println("- " + p);
	    }
	}
    
}
