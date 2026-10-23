import java.util.Scanner;
public class Entrada {
    //METODOS
    public String lerLinha(String mensagem, Scanner input) {
        System.out.print(mensagem);
        return input.nextLine();
    }
    public int lerInteiro(String mensagem, Scanner input) {
        System.out.print(mensagem);
        while (!input.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            input.next(); // descarta a entrada inválida
            System.out.print(mensagem);
        }
        return input.nextInt();
    }
    public double lerDouble(String mensagem, Scanner input) {
        System.out.print(mensagem);
        while (!input.hasNextDouble()) {
            System.out.println("Entrada inválida. Digite um número decimal.");
            input.next(); // descarta a entrada inválida
            System.out.print(mensagem);
        }
        return input.nextDouble();
    }
    public int menu(Scanner input) {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Acessar conta");
        System.out.println("3 - Sair");
        int opcao = lerInteiro("Opção: ", input);
        while (opcao < 1 || opcao > 3) {
            System.out.println("Opção inválida. Digite novamente.");
            opcao = lerInteiro("Opção: ", input);
        }
        return opcao;
    }
    public void contratarFuncionario(Empresa empresa,Scanner input) {
        System.out.println("Digite os dados do funcionário:");
        String nome = lerLinha("Nome: ", input);
        String cpf = lerLinha("CPF: ", input);
        double salario = lerDouble("Salário: ", input);
        System.out.println("Data de nascimento:");
        Data dtNasc = new Data();
        System.out.println("Data de contratação:");
        Data dtContr = new Data();
        Funcionario funcionario = new Funcionario(nome, cpf, salario, dtNasc, dtContr);
        empresa.contratarFuncionario(funcionario);
    }

    public void contratarGerente(Empresa empresa,Scanner input) {
        System.out.println("Digite os dados do gerente:");
        String nome = lerLinha("Nome: ", input);
        String cpf = lerLinha("CPF: ", input);
        double salario = lerDouble("Salário: ", input);
        System.out.println("Data de nascimento:");
        Data dtNasc = new Data();
        System.out.println("Data de contratação:");
        Data dtContr = new Data();
        String senha = lerLinha("Senha: ", input);
        Gerente gerente = new Gerente(nome, cpf, salario, dtNasc, dtContr, senha);
        empresa.contratarGerente(gerente);
    }
    public Funcionario selecionarFuncionario(Empresa empresa, Scanner input) {
        System.out.println("Selecione um funcionário:");
        for (int i = 0; i < empresa.getFuncionarios().size(); i++) {
            Funcionario f = empresa.getFuncionarios().get(i);
            System.out.println((i + 1) + " - " + f.nome);
        }
        int opcao = lerInteiro("Opção: ", input);
        while (opcao < 1 || opcao > empresa.getFuncionarios().size()) {
            System.out.println("Opção inválida. Digite novamente.");
            opcao = lerInteiro("Opção: ", input);
        }
        return empresa.getFuncionarios().get(opcao - 1);
    }
    public Gerente selecionarGerente(Empresa empresa, Scanner input) {
        System.out.println("Selecione um gerente:");
        for (int i = 0; i < empresa.getGerentes().size(); i++) {
            Gerente g = empresa.getGerentes().get(i);
            System.out.println((i + 1) + " - " + g.nome);
        }
        int opcao = lerInteiro("Opção: ", input);
        while (opcao < 1 || opcao > empresa.getGerentes().size()) {
            System.out.println("Opção inválida. Digite novamente.");
            opcao = lerInteiro("Opção: ", input);
        }
        return empresa.getGerentes().get(opcao - 1);
    }
    public void atribuirFunGer(Empresa empresa, Scanner input) {
        Funcionario funcionario = selecionarFuncionario(empresa, input);
        Gerente gerente = selecionarGerente(empresa, input);
        gerente.inserirFuncEquipe(funcionario);
        System.out.println("Funcionário " + funcionario.nome + " atribuído ao gerente " + gerente.nome + ".");
    }
    public void alterarSenhaGerente(Empresa empresa, Scanner input) {
        Gerente gerente = selecionarGerente(empresa, input);
        String senhaAtual = lerLinha("Digite a senha atual: ", input);
        String novaSenha = lerLinha("Digite a nova senha: ", input);
        gerente.alterarSenha(senhaAtual, novaSenha);
    }
    public void funcionarioMaisAntigo(Empresa empresa, Scanner input) {
        Funcionario funcionario = empresa.funcionarioMaisAntigo();
        if (funcionario != null) {
            System.out.println("Funcionário mais antigo:");
            funcionario.listarDados();
        } else {
            System.out.println("Não há funcionários na empresa.");
        }
    }
    public void funcionarioMaisVelho(Empresa empresa, Scanner input) {
        Funcionario funcionario = empresa.funcionarioMaisVelho();
        if (funcionario != null) {
            System.out.println("Funcionário mais velho:");
            funcionario.listarDados();
        } else {
            System.out.println("Não há funcionários na empresa.");
        }
    }
}
