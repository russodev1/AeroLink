package modelos;

public class AeronaveGrande extends AeronaveBase {
    public AeronaveGrande(String modelo, int capacidade) {
        super(modelo, capacidade);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Aeronave Grande | Modelo: " + modelo + " | Capacidade: " + capacidade);
    }
}
