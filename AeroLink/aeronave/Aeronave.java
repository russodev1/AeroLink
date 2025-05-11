package aeronave;

public class Aeronave {
    private String modelo;
    private int capacidade;
    private String fabricante;

    public Aeronave(String modelo, int capacidade, String fabricante) {
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.fabricante = fabricante;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void exibirInformacoes() {
        System.out.println("Aeronave: " + modelo + " - Fabricante: " + fabricante + " - Capacidade: " + capacidade);
    }
}