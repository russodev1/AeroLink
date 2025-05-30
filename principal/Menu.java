package principal;

import aeronave.Aeronave;
import passageiro.Passageiro;
import voo.Voo;
import voo.VooNacional;
import voo.VooInternacional;
import exceptions.LimPassageiroExc;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final ArrayList<Aeronave> aeronaves = new ArrayList<>();
    private static final ArrayList<Passageiro> passageiros = new ArrayList<>();
    private static final ArrayList<Voo> voos = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int answ;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastrar aeronave");
            System.out.println("2. Cadastrar passageiro");
            System.out.println("3. Cadastrar voo");
            System.out.println("4. Adicionar passageiro ao voo");
            System.out.println("5. Exibir todos os voos");
            System.out.println("6. Exibir passageiros de um voo");
            System.out.println("7. Sair");
            System.out.print("Opção: ");
            
            answ = Integer.parseInt(scanner.nextLine());

            switch (answ) {
                case 1: cadastrarAeronave(); break;
                case 2: cadastrarPassageiro(); break;
                case 3: cadastrarVoo(); break;
                case 4: adicionarPassageiroAoVoo(); break;
                case 5: exibirVoos(); break;
                case 6: exibirPassageirosDoVoo(); break;
                case 7: System.out.println("Encerrando o programa."); break;
                default: System.out.println("Opção inválida.");
            }

        } while (answ != 7);
    }

    private static void cadastrarAeronave() {
    	
        System.out.println("\n== Cadastro de Aeronave ==");
        System.out.print("Modelo: ");
        
        String modelo = scanner.nextLine();
        System.out.print("Capacidade: ");
        
        int capacidade = Integer.parseInt(scanner.nextLine());
        System.out.print("Fabricante: ");
        
        String fabricante = scanner.nextLine();

        aeronaves.add(new Aeronave(modelo, capacidade, fabricante));
        System.out.println("Aeronave cadastrada com sucesso!");
    }

    private static void cadastrarPassageiro() {
    	
        System.out.println("\n== Cadastro de Passageiro ==");
        System.out.print("Nome: ");
        
        String nome = scanner.nextLine();
        
        System.out.print("CPF (ou deixe vazio): ");
        
        String cpf = scanner.nextLine();
        
        if (cpf.isEmpty()) {
            cpf = null;
        } else {
            cpf = cpf;
        }
        
        System.out.print("Passaporte (ou deixe vazio): ");
        String passaporte = scanner.nextLine();
        
        passaporte = passaporte.isEmpty() ? null : passaporte;
        
        System.out.print("Nacionalidade: ");
        String nacionalidade = scanner.nextLine();

        Passageiro p = new Passageiro(nome, cpf, passaporte, nacionalidade);
        if (!p.validarDocumentos()) {
            System.out.println("Erro: é necessário CPF ou Passaporte.");
            return;
        }

        passageiros.add(p);
        System.out.println("Passageiro cadastrado com sucesso!");
    }

    private static void cadastrarVoo() {
    	
        if (aeronaves.isEmpty()) {
            System.out.println("Nenhuma aeronave cadastrada!");
            return;
        }

        System.out.println("\n== Cadastro de Voo ==");
        System.out.print("Código do voo: ");
        
        String codigo = scanner.nextLine();
        System.out.print("Data (AAAA-MM-DD): ");
        
        String data = scanner.nextLine();
        System.out.print("Horário (HH:MM): ");
        
        String horario = scanner.nextLine();
        System.out.print("Origem: ");
        
        String origem = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();

        System.out.println("Escolha a aeronave:");
        for (int i = 0; i < aeronaves.size(); i++) {
            System.out.println(i + " - " + aeronaves.get(i).getCapacidade() + " lugares | " + aeronaves.get(i).getClass().getSimpleName());
        }
        
        int idxAeronave = Integer.parseInt(scanner.nextLine());
        Aeronave aeronave = aeronaves.get(idxAeronave);

        System.out.print("Tipo de voo (1 - Nacional | 2 - Internacional): ");
        int tipo = Integer.parseInt(scanner.nextLine());
        Voo voo;

        if (tipo == 1) {
            voo = new VooNacional(codigo, data, horario, origem, destino, aeronave);
        } else {
            voo = new VooInternacional(codigo, data, horario, origem, destino, aeronave);
        }
        
        voos.add(voo);
        System.out.println("Voo cadastrado com sucesso!");
        
    }

    private static void adicionarPassageiroAoVoo() {
    	
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo disponível.");
            return;
        }
        
        if (passageiros.isEmpty()) {
            System.out.println("Nenhum passageiro disponível.");
            return;
        }

        System.out.println("\nEscolha o voo:");
        for (int i = 0; i < voos.size(); i++) {
            System.out.println(i + " - " + voos.get(i).getCodigo());
        }
        
        int idxVoo = Integer.parseInt(scanner.nextLine());
        Voo vooSelecionado = voos.get(idxVoo);

        System.out.println("Escolha o passageiro:");
        for (int i = 0; i < passageiros.size(); i++) {
            System.out.println(i + " - " + passageiros.get(i));
        }
        
        int idxPassageiro = Integer.parseInt(scanner.nextLine());
        Passageiro p = passageiros.get(idxPassageiro);

        try {
            vooSelecionado.cadastrarPassageiro(p);
            System.out.println("Passageiro adicionado ao voo com sucesso!");
        } catch (LimPassageiroExc e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void exibirVoos() {
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
            return;
        }

        System.out.println("\n== Voos Cadastrados ==");
        for (Voo v : voos) {
            v.exibirDados();
            System.out.println("----------------------");
        }
    }

    
    private static void exibirPassageirosDoVoo() {
    	
        if (voos.isEmpty()) {
            System.out.println("Nenhum voo disponível.");
            return;
        }

        System.out.println("\nEscolha o voo:");
        for (int i = 0; i < voos.size(); i++) {
            System.out.println(i + " - " + voos.get(i).getCodigo());
        }
        
        int idx = Integer.parseInt(scanner.nextLine());
        Voo v = voos.get(idx);

        System.out.println("Passageiros:");
        for (Passageiro p : v.getPassageiros()) {
            System.out.println("- " + p);
        }
    }
}
