import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = Entrada.abrirEntrada();
        Sistema sistema = new Sistema();

        int op = Entrada.menu(input);

        while (op != 0) {
            switch(op) {
                case 1:
                    Entrada.menuCadastro(sistema, input);
                    break;
                case 2:
                    Entrada.menuRelatorios(sistema, input);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            op = Entrada.menu(input);
        }

        Entrada.fecharEntrada(input);
    }
}