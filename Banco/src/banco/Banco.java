package banco;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private ArrayList<Pessoa> pessoas;
    private ArrayList<Gerente> gerentes;
    private ArrayList<ContaCorrente> contasCorrentes;
    private ArrayList<ContaPoupanca> contasPoupanca;

    public Banco() {
        this.pessoas = new ArrayList<>();
        this.gerentes = new ArrayList<>();
        this.contasCorrentes = new ArrayList<>();
        this.contasPoupanca = new ArrayList<>();

    }

    public static void main(String[] args) {
        Banco banco = new Banco();

        int opcao = menuInicial();
        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    char subOpcao1 = opcao1();
                    switch (subOpcao1) {
                        case 'a'://==============================================================
                            Pessoa pessoa = new Pessoa();
                            banco.adicionarPessoa(pessoa);
                            break;

                        case 'b'://==============================================================
                            Gerente gerente = new Gerente();
                            banco.adicionarGerente(gerente);
                            break;

                        case 'c'://==============================================================
                            banco.criarContaCorrente();
                            break;

                        case 'd'://==============================================================
                            banco.criarContaPoupanca();
                            break;

                        default://==============================================================
                            System.out.println("Opção inválida");
                    }
                    break;
                case 2:
                    char subOpcao2 = opcao2();
                    switch (subOpcao2) {
                        case 'a':
                            banco.verificarExtrato();
                            break;
                        case 'b':
                            banco.depositar();
                            break;
                        case 'c':
                            banco.sacar();
                            break;
                        case 'd':
                            banco.transferir();
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            opcao = menuInicial();

        }
        Entrada.scanner.close();
    }
    // ======================================================================================
    //METODOS DO MENU
    
    public static int menuInicial() {
        System.out.println("Bem vindo!\n");
        System.out.println("1) Cadastro");
        System.out.println("2) Movimentações financeiras");
        System.out.println("0) Sair");
        
        int opcao = Entrada.lerInteiro("Escolha uma opção: ");

        while (opcao < 0 || opcao > 2) {
            opcao = Entrada.lerInteiro("Opção inválida. Digite novamente: ");
        }
        return opcao;
    }
    public static char opcao1() {
        System.out.println("a) Adicionar pessoa");
        System.out.println("b) Adicionar gerente");
        System.out.println("c) Criar conta corrente");
        System.out.println("d) Criar poupança");
        Scanner s = Entrada.scanner;
        char opcao = s.nextLine().trim().toLowerCase().charAt(0);
        while (opcao < 'a' || opcao > 'd') {
            System.out.println("Opção inválida. Digite novamente: ");
            opcao = s.nextLine().trim().toLowerCase().charAt(0);
        }
        return opcao;
    }
    public static char opcao2(){
        System.out.println("a) Verificar extrato");
        System.out.println("b) Depositar");
        System.out.println("c) Sacar");
        System.out.println("d) Transferir");
        Scanner s = Entrada.scanner;
        char opcao = s.nextLine().trim().toLowerCase().charAt(0);
        while (opcao < 'a' || opcao > 'd') {
            System.out.println("Opção inválida. Digite novamente: ");
            opcao = s.nextLine().trim().toLowerCase().charAt(0);
        }
        return opcao;
    }
    public Gerente selecionarGerente() {
        if (gerentes.isEmpty()) {
            System.out.println("Não há gerentes cadastrados.");
            return null;
        }

        System.out.println("Selecione um gerente:");
        for (int i = 0; i < gerentes.size(); i++) {
            System.out.println(gerentes.get(i).getNome() + "  " + gerentes.get(i).getMatricula());
        }

        Scanner s = Entrada.scanner;
        String escolha = s.nextLine();
        while (escolha.isEmpty()) {
            System.out.println("Entrada inválida. Digite a matrícula do gerente:");
            escolha = s.nextLine();
        }
        for (int i = 0; i < gerentes.size(); i++) {
            if (gerentes.get(i).getMatricula().equals(escolha)) {
                return gerentes.get(i);
            }
        }
        System.out.println("Gerente não encontrado.");
        return null;
    }

    public Pessoa selecionarPessoa() {
        if (pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas.");
            return null;
        }

        System.out.println("Selecione uma pessoa:");
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i).getNome() + "  " + pessoas.get(i).getCpf());
        }

        Scanner s = Entrada.scanner;
        String escolha = s.nextLine().trim().toLowerCase();
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getCpf().equals(escolha)) {
                return pessoas.get(i);
            }
        }
        System.out.println("Pessoa não encontrada.");
        return null;
    }
    // ======================================================================================
    // METODOS DO BANCO

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void adicionarGerente(Gerente gerente) {
        gerentes.add(gerente);
    }

    public Boolean temGerentesEPessoas() {
        if (this.gerentes.isEmpty()) {
            System.out.println("Não há gerentes cadastrados. Cadastre um gerente antes de criar uma conta.");
            return false;
        }
        if (this.pessoas.isEmpty()) {
            System.out.println("Não há pessoas cadastradas. Cadastre uma pessoa antes de criar uma conta.");
            return false;
        }
        return true;
    }
    public Data lerData() {
        System.out.println("Digite a data de criação da conta:");
        int dia = Entrada.lerInteiro("Dia: ");
        while (dia < 1 || dia > 31) {
            System.out.println("Dia inválido. Digite novamente: ");
            dia = Entrada.lerInteiro("Dia: ");
        }
        int mes = Entrada.lerInteiro("Mês: ");
        while (mes < 1 || mes > 12) {
            System.out.println("Mês inválido. Digite novamente: ");
            mes = Entrada.lerInteiro("Mês: ");
        }
        int ano = Entrada.lerInteiro("Ano: ");
        while (ano < 1900 || ano > 2100) {
            System.out.println("Ano inválido. Digite novamente: ");
            ano = Entrada.lerInteiro("Ano: ");
        }
        return new Data(dia, mes, ano);
    }

    public void criarContaCorrente() {
        if (!temGerentesEPessoas()) {
            return;
        }
        Gerente gerenteSelecionado = this.selecionarGerente();
        if (gerenteSelecionado == null) {
            System.out.println("Nenhum gerente selecionado. A conta corrente não será criada.");
            return;
        }
        Pessoa pessoaSelecionada = this.selecionarPessoa();
        if (pessoaSelecionada == null) {
            System.out.println("Nenhuma pessoa selecionada. A conta corrente não será criada.");
            return;
        }
        //ContaCorrente(String numero, Pessoa titular, Data criacao, Gerente gerente)
        Data dataCriacao = this.lerData();
        ContaCorrente novaContaCorrente = new ContaCorrente(pessoaSelecionada, gerenteSelecionado, dataCriacao);

        this.contasCorrentes.add(novaContaCorrente);

        System.out.println("Conta corrente criada com sucesso!");
    }

    public void criarContaPoupanca() {
        if (!temGerentesEPessoas()) {
            return;
        }
        Gerente gerenteSelecionado = this.selecionarGerente();
        if (gerenteSelecionado == null) {
            System.out.println("Nenhum gerente selecionado. A conta poupança não será criada.");
            return; 
        }
        Pessoa pessoaSelecionada = this.selecionarPessoa();
        if (pessoaSelecionada == null) {
            System.out.println("Nenhuma pessoa selecionada. A conta poupança não será criada.");
            return;
        }
        Data dataCriacao = this.lerData();
        ContaPoupanca novaContaPoupanca = new ContaPoupanca(pessoaSelecionada, gerenteSelecionado, dataCriacao);
        this.contasPoupanca.add(novaContaPoupanca);
        System.out.println("Conta poupança criada com sucesso!");
    }

    public void listarContasCorrentes() {
        if (contasCorrentes.isEmpty()) {
            System.out.println("Não há contas correntes cadastradas.");
            return;
        }
        System.out.println("Contas Correntes:");
        for (ContaCorrente conta : contasCorrentes) {
            System.out.println("Número: " + conta.numero + ", Titular: " + conta.titular.getNome());
        }
    }
    public void listarContasPoupanca() {
        if (contasPoupanca.isEmpty()) {
            System.out.println("Não há contas poupança cadastradas.");
            return;
        }
        System.out.println("Contas Poupança:");
        for (ContaPoupanca conta : contasPoupanca) {
            System.out.println("Número: " + conta.numero + ", Titular: " + conta.titular.getNome());
        }
    }

    public Conta SelecionarConta() {
        System.out.println("Selecione o tipo de conta:");
        System.out.println("1) Conta Corrente");
        System.out.println("2) Conta Poupança");
        int tipoConta = Entrada.lerInteiro("Escolha uma opção: ");
        while (tipoConta < 1 || tipoConta > 2) {
            tipoConta = Entrada.lerInteiro("Opção inválida. Digite novamente: ");
        }

        if (tipoConta == 1) {
            this.listarContasCorrentes();
            System.out.println("Digite o número da conta corrente desejada:");
            String numeroConta = Entrada.scanner.nextLine().trim();
            for (ContaCorrente conta : contasCorrentes) {
                if (conta.numero.equals(numeroConta)) {
                    return conta;
                }
            }
            System.out.println("Conta corrente não encontrada.");
        } else {
            this.listarContasPoupanca();
            System.out.println("Digite o número da conta poupança desejada:");
            String numeroConta = Entrada.scanner.nextLine().trim();
            for (ContaPoupanca conta : contasPoupanca) {
                if (conta.numero.equals(numeroConta)) {
                    return conta;
                }
            }
            System.out.println("Conta poupança não encontrada.");
        }
        return null;
    }
    public void verificarExtrato() {
        Conta contaSelecionada = this.SelecionarConta();
        if (contaSelecionada != null) {
            contaSelecionada.extrato();
        }
    }
    public void depositar() {
        Conta contaSelecionada = this.SelecionarConta();
        if (contaSelecionada != null) {
            double valor = Entrada.lerDecimal("Digite o valor a ser depositado: ");
            contaSelecionada.depositar(valor);
        }
    }

    public void sacar() {
        Conta contaSelecionada = this.SelecionarConta();
        if (contaSelecionada != null) {
            double valor = Entrada.lerDecimal("Digite o valor a ser sacado: ");
            contaSelecionada.sacar(valor);
        }
    }

    public void transferir() {
        System.out.println("Selecione a conta de origem:");
        Conta contaOrigem = this.SelecionarConta();
        if (contaOrigem == null) {
            System.out.println("Conta de origem inválida. A transferência não será realizada.");
            return;
        }

        System.out.println("Selecione a conta de destino:");
        Conta contaDestino = this.SelecionarConta();
        if (contaDestino == null || contaDestino == contaOrigem) {
            System.out.println("Conta de destino inválida. A transferência não será realizada.");
            return;
        }

        double valor = Entrada.lerDecimal("Digite o valor a ser transferido: ");
        if (contaOrigem.transferir(valor, contaDestino)) {
            System.out.println("Transferência de R$ " + valor + " realizada com sucesso!");
        } else {
            System.out.println("Falha na transferência. Verifique os saldos e tente novamente.");
        }
    }
    // ======================================================================================


}
