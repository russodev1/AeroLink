package principal;

import aeronave.Aeronave;
import passageiro.Passageiro;
import voo.VooNacional;
import voo.VooInternacional;

public class Principal {
    public static void main(String[] args) {
        Aeronave a1 = new Aeronave("Boeing 737", 180, "Boeing");
        Passageiro p1 = new Passageiro("Gabriel", "12345678900", null, "Brasileira");

        VooNacional vn = new VooNacional("BR123", "2025-05-11", "14:00", "SP", "RJ", a1);
        vn.cadastrarPassageiro(p1);
        vn.exibirDados();
    }
}