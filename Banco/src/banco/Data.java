package banco;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        this.dia = Entrada.lerInteiro("Digite o dia: ");
        this.mes = Entrada.lerInteiro("Digite o mês: ");
        this.ano = Entrada.lerInteiro("Digite o ano: ");
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

    // Getters and Setters
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia; 
    }


    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

}
