package modelos;

public abstract class AeronaveBase {
    protected String modelo;
    protected int capacidade;

    public AeronaveBase(String modelo, int capacidade) {
        this.modelo = modelo;
        this.capacidade = capacidade;
    }

    public String getModelo() { return modelo; }
    public int getCapacidade() { return capacidade; }

    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }

    public abstract void exibirInformacoes();
}
