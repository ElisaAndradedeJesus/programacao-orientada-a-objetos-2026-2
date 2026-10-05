package banco;

import java.util.Scanner;

// Um único leitor compartilhado evita conflitos na leitura de System.in.
final class Entrada {
    static final Scanner scanner = new Scanner(System.in);

    private Entrada() {}

    static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    static double lerDecimal(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                double valor = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                if (Double.isFinite(valor)) return valor;
            } catch (NumberFormatException e) {
                // Solicita novamente quando a entrada não é numérica.
            }
            System.out.println("Digite um número válido.");
        }
    }
}
