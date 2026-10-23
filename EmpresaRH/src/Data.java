import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        Scanner s = Entrada.scanner;
        System.out.print("Digite o dia: ");
        this.dia = s.nextInt();
        System.out.print("Digite o mês: ");
        this.mes = s.nextInt();
        System.out.print("Digite o ano: ");
        this.ano = s.nextInt();
    }

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

   
    public int compara(Data data){
        if (this.ano < data.ano) {
            return -1;
        } else if (this.ano > data.ano) {
            return 1;
        } else {
            if (this.mes < data.mes) {
                return -1;
            } else if (this.mes > data.mes) {
                return 1;
            } else {
                if (this.dia < data.dia) {
                    return -1;
                } else if (this.dia > data.dia) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
