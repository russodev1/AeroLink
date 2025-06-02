package main;

import java.util.ArrayList;
import java.util.Scanner;

import controladores.Gerenciador;
import modelos.AeronaveBase;
import modelos.Passageiro;
import modelos.Voo;

public class Menu {
	public static void start() {
		Scanner sc = new Scanner(System.in);

        Gerenciador<Passageiro> gerenciadorPassageiros = new Gerenciador<>("passageiro");
        Gerenciador<AeronaveBase> gerenciadorAeronaves = new Gerenciador<>("aeronave");
        ArrayList<Voo> voos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Gerenciar Passageiros");
            System.out.println("2. Gerenciar Aeronaves");
            System.out.println("3. Gerenciar Voos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1 -> menuPassageiros(sc, gerenciadorPassageiros);
                case 2 -> menuAeronaves(sc, gerenciadorAeronaves);
                case 3 -> menuVoos(sc, gerenciadorPassageiros, gerenciadorAeronaves, voos);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sc.close();
    }

    public static void menuPassageiros(Scanner sc, Gerenciador<Passageiro> gp) {
        int opcao;
        do {
            System.out.println("\n=== MENU PASSAGEIROS ===");
            System.out.println("1. Cadastrar");
            System.out.println("2. Editar");
            System.out.println("3. Listar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1: gp.cadastrar(sc);break;
                case 2: gp.editar(sc);break;
                case 3: gp.listar();break;
                case 4: gp.excluir(sc);break;
                case 0: System.out.println("Voltando...");break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public static void menuAeronaves(Scanner sc, Gerenciador<AeronaveBase> ga) {
        int opcao;
        do {
            System.out.println("\n=== MENU AERONAVES ===");
            System.out.println("1. Cadastrar");
            System.out.println("2. Editar");
            System.out.println("3. Listar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1: ga.cadastrar(sc);break;
                case 2: ga.editar(sc);break;
                case 3: ga.listar();break;
                case 4: ga.excluir(sc);break;
                case 0: System.out.println("Voltando...");break;
                default: System.out.println("Opção inválida.");break;
            }
        } while (opcao != 0);
    }

    public static void menuVoos(Scanner sc, Gerenciador<Passageiro> gp, Gerenciador<AeronaveBase> ga, ArrayList<Voo> voos) {
        int opcao;
        do {
            System.out.println("\n=== MENU VOOS ===");
            System.out.println("1. Cadastrar Voo");
            System.out.println("2. Adicionar Passageiro");
            System.out.println("3. Remover Passageiro");
            System.out.println("4. Exibir Informações dos Voos");
            System.out.println("5. Excluir Voo");
            System.out.println("0. Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt(); sc.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.print("Número do voo: ");
                    String numero = sc.nextLine();
                    System.out.print("Origem: ");
                    String origem = sc.nextLine();
                    System.out.print("Destino: ");
                    String destino = sc.nextLine();

                    if (ga.getLista().isEmpty()) {
                        System.out.println("Nenhuma aeronave disponível.");
                        break;
                    }

                    ga.listar();
                    System.out.print("Índice da aeronave: ");
                    int index = sc.nextInt(); sc.nextLine();

                    if (index >= 0 && index < ga.getLista().size()) {
                        AeronaveBase aeronave = ga.getLista().get(index);
                        voos.add(new Voo(numero, origem, destino, aeronave));
                        System.out.println("Voo cadastrado com sucesso!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                }break;

                case 2: {
                    if (voos.isEmpty()) {
                        System.out.println("Nenhum voo cadastrado.");
                        break;
                    }
                    for (int i = 0; i < voos.size(); i++)
                        System.out.println("[" + i + "] " + voos.get(i).getNumero());

                    System.out.print("Índice do voo: ");
                    int vooIndex = sc.nextInt(); sc.nextLine();
                    if (vooIndex < 0 || vooIndex >= voos.size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }

                    gp.listar();
                    System.out.print("Índice do passageiro: ");
                    int passIndex = sc.nextInt(); sc.nextLine();
                    if (passIndex < 0 || passIndex >= gp.getLista().size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }

                    voos.get(vooIndex).adicionarPassageiro(gp.getLista().get(passIndex));
                }break;

                case 3: {
                    if (voos.isEmpty()) {
                        System.out.println("Nenhum voo cadastrado.");
                        break;
                    }

                    for (int i = 0; i < voos.size(); i++)
                        System.out.println("[" + i + "] " + voos.get(i).getNumero());

                    System.out.print("Índice do voo: ");
                    int vooIndex = sc.nextInt(); sc.nextLine();
                    if (vooIndex < 0 || vooIndex >= voos.size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }

                    System.out.print("CPF do passageiro para remover: ");
                    String cpf = sc.nextLine();
                    voos.get(vooIndex).removerPassageiro(cpf);
                }break;

                case 4: {
                    if (voos.isEmpty()) {
                        System.out.println("Nenhum voo cadastrado.");
                        break;
                    }
                    for (Voo voo : voos)
                        voo.exibirInformacoes();
                }break;

                case 5: {
                    if (voos.isEmpty()) {
                        System.out.println("Nenhum voo cadastrado.");
                        break;
                    }

                    for (int i = 0; i < voos.size(); i++)
                        System.out.println("[" + i + "] " + voos.get(i).getNumero());

                    System.out.print("Índice do voo para excluir: ");
                    int index = sc.nextInt(); sc.nextLine();
                    if (index >= 0 && index < voos.size()) {
                        voos.remove(index);
                        System.out.println("Voo removido.");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                }break;

                case 0: System.out.println("Voltando...");break;
                default: System.out.println("Opção inválida.");break;
            }

        } while (opcao != 0);
	}
}
