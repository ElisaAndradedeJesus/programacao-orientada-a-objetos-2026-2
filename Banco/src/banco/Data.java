package banco;
import java.util.Scanner;

public class Data {
    int dia, mes, ano;

    public Data() {
        Scanner s = new Scanner(System.in);
        System.out.print("Digite o dia: ");
        this.dia = s.nextInt();
        System.out.print("Digite o mês: ");
        this.mes = s.nextInt();
        System.out.print("Digite o ano: ");
        this.ano = s.nextInt();
        System.out.println("Data cadastrada com sucesso!");
    }
    public Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
        System.out.println("Data cadastrada com sucesso!");
    }

    void exibirData() {
        System.out.println("Data: " + this.dia + "/" + this.mes + "/" + this.ano);
    }

    boolean maior (Data d){
        if (this.ano > d.ano) {
            return true;
        } else if (this.ano == d.ano && this.mes > d.mes) {
            return true;
        } else if (this.ano == d.ano && this.mes == d.mes && this.dia > d.dia) {
            return true;
        }
        return false;
    }

}
