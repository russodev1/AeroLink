package controladores;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelos.AeronaveBase;
import modelos.AeronaveGrande;
import modelos.AeronavePequena;
import modelos.Passageiro;

public class Gerenciador<T> implements Operacoes<T> {
    private final ArrayList<T> lista;
    private final String tipo;
    private static Scanner sc = new Scanner(System.in);

    public Gerenciador(String tipo) {
        this.lista = new ArrayList<>();
        this.tipo = tipo;
    }

    public ArrayList<T> getLista() {
        return lista;
    }

    @Override
    public void cadastrar() {
    	
        if (tipo.equals("passageiro")) {
        	
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("CPF: ");
            String cpf = sc.nextLine();
            lista.add((T) new Passageiro(nome, cpf));
            System.out.println("Passageiro cadastrado!");
            
        } else if (tipo.equals("aeronave")) {
        	
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            try {
                System.out.print("Capacidade: ");
                int capacidade = sc.nextInt();
                sc.nextLine();

                System.out.print("Tipo (1-Pequena | 2-Grande): ");
                int tipoA = sc.nextInt();
                sc.nextLine();

                if (tipoA == 1)
                    lista.add((T) new AeronavePequena(modelo, capacidade));
                else if (tipoA == 2)
                    lista.add((T) new AeronaveGrande(modelo, capacidade));
                else
                    System.out.println("Tipo inválido!");

                System.out.println("Aeronave cadastrada!");
            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada inválida. Use apenas números.");
                sc.nextLine();
            }

            
        }
    }

    
    
    @Override
    public void editar() {
        try {
            listar();
            System.out.print("Índice para editar: ");
            int index = sc.nextInt();
            sc.nextLine();

            if (index < 0 || index >= lista.size()) {
                throw new IndexOutOfBoundsException();
            }

            if (tipo.equals("passageiro")) {
                Passageiro p = (Passageiro) lista.get(index);
                System.out.print("Novo nome: ");
                p.setNome(sc.nextLine());
                System.out.print("Novo CPF: ");
                p.setCpf(sc.nextLine());
                System.out.println("Passageiro atualizado!");

            } else if (tipo.equals("aeronave")) {
                AeronaveBase a = (AeronaveBase) lista.get(index);
                System.out.print("Novo modelo: ");
                a.setModelo(sc.nextLine());
                System.out.print("Nova capacidade: ");
                a.setCapacidade(sc.nextInt());
                sc.nextLine();
                System.out.println("Aeronave atualizada!");

            } else {
                System.out.println("Tipo desconhecido.");
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: índice fora do intervalo.");
        } catch (InputMismatchException e) {
            System.out.println("Erro: entrada inválida.");
            sc.nextLine();
        }
    }


    @Override
    public void excluir() {
        listar();
        System.out.print("Índice para excluir: ");
        int index = sc.nextInt(); sc.nextLine();
        if (index >= 0 && index < lista.size()) {
        	
            lista.remove(index);
            System.out.println("Removido com sucesso!");
            
        } else {
            System.out.println("Índice inválido.");
        }
    }

    @Override
    public void listar() {
    	
        if (lista.isEmpty()) {
        	
            System.out.println("Nenhum " + tipo + " cadastrado.");
            return;
            
        }

        for (int i = 0; i < lista.size(); i++) {
        	
            System.out.print("[" + i + "] ");
            if (tipo.equals("passageiro"))
                ((Passageiro) lista.get(i)).exibirInformacoes();
            else if (tipo.equals("aeronave"))
                ((AeronaveBase) lista.get(i)).exibirInformacoes();
            
        }
    }
}
