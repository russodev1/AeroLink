package modelos;

public class AeronavePequena extends AeronaveBase {
    public AeronavePequena(String modelo, int capacidade) {
        super(modelo, capacidade);
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Aeronave Pequena | Modelo: " + modelo + " | Capacidade: " + capacidade);
    }
}
