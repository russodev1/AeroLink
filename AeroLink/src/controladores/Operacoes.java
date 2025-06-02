package controladores;

import java.util.Scanner;

public interface Operacoes<T> {
    void cadastrar(Scanner sc);
    void editar(Scanner sc);
    void excluir(Scanner sc);
    void listar();
}
