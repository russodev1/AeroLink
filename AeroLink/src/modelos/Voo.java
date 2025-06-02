package modelos;

import java.util.ArrayList;

public class Voo {
    private String numero;
    private String origem;
    private String destino;
    private AeronaveBase aeronave;
    private ArrayList<Passageiro> passageiros;

    public Voo(String numero, String origem, String destino, AeronaveBase aeronave) {
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.aeronave = aeronave;
        this.passageiros = new ArrayList<>();
    }

    public String getNumero() { return numero; }

    public void setNumero(String numero) { this.numero = numero; }
    public void setOrigem(String origem) { this.origem = origem; }
    public void setDestino(String destino) { this.destino = destino; }

    public void setAeronave(AeronaveBase aeronave) { this.aeronave = aeronave; }

    
    
    public void adicionarPassageiro(Passageiro p) {
    	
        if (passageiros.size() < aeronave.getCapacidade()) {
            passageiros.add(p);
            System.out.println("Passageiro adicionado com sucesso.");
            
        } else {
            System.out.println("Aeronave cheia! Não é possível adicionar mais passageiros.");
        }
    }

    
    
    public void removerPassageiro(String cpf) {
    	
        passageiros.removeIf(p -> p.getCpf().equals(cpf));
        
    }

    
    
    public void listarPassageiros() {
    	
        if (passageiros.isEmpty()) {
        	
            System.out.println("Nenhum passageiro cadastrado.");
            
        } else {
        	
            for (Passageiro p : passageiros) {
            	
                p.exibirInformacoes();
                
            }
        }
    }

    
    
    public void exibirInformacoes() {
    	
        System.out.println("\n=== VOO " + numero + " ===");
        System.out.println("Origem: " + origem + " | Destino: " + destino);
        aeronave.exibirInformacoes();
        System.out.println("Passageiros:");
        listarPassageiros();
        
    }
}
