import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = Entrada.abrirEntrada();
        Main s = new Main();

        int op = Entrada.menu(input);

        while (op != 0) {
            switch(op) {
                case 1:
                    Entrada.menuCadastro(s, input);
                    break;
                case 2:
                    //Entrada.menu_relatorios(s, input);
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