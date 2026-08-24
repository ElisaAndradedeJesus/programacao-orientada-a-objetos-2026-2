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
