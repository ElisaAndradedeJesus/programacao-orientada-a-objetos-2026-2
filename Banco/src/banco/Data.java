package banco;

public class Data {
    int dia, mes, ano;

    Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
        System.out.println("Data cadastrada com sucesso!");
    }

    void exibirData() {
        System.out.println("Data: " + this.dia + "/" + this.mes + "/" + this.ano);
    }
}
