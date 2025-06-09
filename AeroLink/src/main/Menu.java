package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controladores.Gerenciador;
import exceptions.AeronaveCheiaException;
import modelos.AeronaveBase;
import modelos.Passageiro;
import modelos.Voo;

public class Menu {
	private static Scanner sc = new Scanner(System.in);
	public static void start() {

        Gerenciador<Passageiro> gerenciadorPassageiros = new Gerenciador<>("passageiro");
        Gerenciador<AeronaveBase> gerenciadorAeronaves = new Gerenciador<>("aeronave");
        ArrayList<Voo> voos = new ArrayList<>();

        int opcao;
        do {
            try {
                System.out.println("\n=== MENU PRINCIPAL ===");
                System.out.println("1. Gerenciar Passageiros");
                System.out.println("2. Gerenciar Aeronaves");
                System.out.println("3. Gerenciar Voos");
                System.out.println("0. Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt(); sc.nextLine();

                switch (opcao) {
                    case 1: menuPassageiros(gerenciadorPassageiros); break;
                    case 2: menuAeronaves(gerenciadorAeronaves); break;
                    case 3: menuVoos(gerenciadorPassageiros, gerenciadorAeronaves, voos); break;
                    case 0: System.out.println("Encerrando..."); break;
                    default: System.out.println("Opção inválida."); break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada inválida. Digite apenas números inteiros.");
                sc.nextLine();
                opcao = -1;
            }
        } while (opcao != 0);


        sc.close();
    }

    public static void menuPassageiros(Gerenciador<Passageiro> gp) {
    	int opcao;
    	do {
    	    try {
    	        System.out.println("\n=== MENU PASSAGEIROS ===");
    	        System.out.println("1. Cadastrar");
    	        System.out.println("2. Editar");
    	        System.out.println("3. Listar");
    	        System.out.println("4. Excluir");
    	        System.out.println("0. Voltar");
    	        System.out.print("Escolha: ");
    	        opcao = sc.nextInt(); sc.nextLine();

    	        switch (opcao) {
    	            case 1: gp.cadastrar(); break;
    	            case 2: gp.editar(); break;
    	            case 3: gp.listar(); break;
    	            case 4: gp.excluir(); break;
    	            case 0: System.out.println("Voltando..."); break;
    	            default: System.out.println("Opção inválida.");
    	        }
    	    } catch (InputMismatchException e) {
    	        System.out.println("Erro: entrada inválida. Digite apenas números inteiros.");
    	        sc.nextLine();
    	        opcao = -1;
    	    }
    	} while (opcao != 0);

    }

    public static void menuAeronaves(Gerenciador<AeronaveBase> ga) {
    	int opcao;
    	do {
    	    try {
    	        System.out.println("\n=== MENU AERONAVES ===");
    	        System.out.println("1. Cadastrar");
    	        System.out.println("2. Editar");
    	        System.out.println("3. Listar");
    	        System.out.println("4. Excluir");
    	        System.out.println("0. Voltar");
    	        System.out.print("Escolha: ");
    	        opcao = sc.nextInt(); sc.nextLine();

    	        switch (opcao) {
    	            case 1: ga.cadastrar(); break;
    	            case 2: ga.editar(); break;
    	            case 3: ga.listar(); break;
    	            case 4: ga.excluir(); break;
    	            case 0: System.out.println("Voltando..."); break;
    	            default: System.out.println("Opção inválida."); break;
    	        }
    	    } catch (InputMismatchException e) {
    	        System.out.println("Erro: entrada inválida. Digite apenas números inteiros.");
    	        sc.nextLine();
    	        opcao = -1;
    	    }
    	} while (opcao != 0);

    }

    public static void menuVoos(Gerenciador<Passageiro> gp, Gerenciador<AeronaveBase> ga, ArrayList<Voo> voos) {
        int opcao;
        do {
            try {
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
                    } break;

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

                        try {
                            voos.get(vooIndex).adicionarPassageiro(gp.getLista().get(passIndex));
                            System.out.println("Passageiro adicionado com sucesso!");
                        } catch (AeronaveCheiaException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    } break;


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
                    } break;

                    case 4: {
                        if (voos.isEmpty()) {
                            System.out.println("Nenhum voo cadastrado.");
                            break;
                        }
                        for (Voo voo : voos) {
                            voo.exibirInformacoes();
                        }
                    } break;

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
                    } break;

                    case 0: System.out.println("Voltando..."); break;
                    default: System.out.println("Opção inválida."); break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada inválida. Digite apenas números inteiros.");
                sc.nextLine();
                opcao = -1;
            }

        } while (opcao != 0);
    }

}
