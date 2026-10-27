import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior e <seu nome aqui>
 */
public class Entrada {

    /**
     * Se houver um arquivo input.txt na pasta em que o projeto está sendo executado,
     * define que o Scanner vai ler deste arquivo e não do teclado.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     * NÃO ALTERE O ESTE CODIGO!!!!
     * @return Um objeto da classe Scanner de onde a entrada será lida
     */
    public static Scanner abrirEntrada() {
        Scanner input = null;
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            input = new Scanner(new FileInputStream("input.txt")).useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            // Locale.US para que o Java sempre leia double com "pontos" ao invés de "vírgulas"
            input = new Scanner(System.in).useLocale(Locale.US);
        }
        finally {
            return input;
        }
    }

    /**
     * Fecha o Scanner antes de sair do programa.
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     */
    public static void fecharEntrada(Scanner input) {
        input.close();
    }

    /**
     * Faz a leitura de uma linha inteira
     * @param msg: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return Uma String contendo a linha que foi lida
     */
    public static String lerLinha(String msg, Scanner input) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.println(msg);
        String linha = input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return O número digitado pelo usuário convertido para int
     */
    public static int lerInteiro(String msg, Scanner input) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = Entrada.lerLinha(msg, input);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return O número digitado pelo usuário convertido para double
     */
    private static double lerDouble(String msg, Scanner input) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = Entrada.lerLinha(msg, input);
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public static int menu(Scanner input) {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
        String msg = "Escolha uma opção:\n" +
                "1) Cadastro\n" +
                "2) Relatórios\n" +
                "0) Sair\n";

        int op = Entrada.lerInteiro(msg, input);

        while (op < 0 || op > 2) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = Entrada.lerInteiro(msg, input);
        }

        return op;
    }

    public static void menuRelatorios(Sistema s, Scanner input) {
        String msg = "1) Listar Resultados por Conceito\n"
                + "2) Listar Resultados por Área\n"
                + "3) Listar Alunos Irregulares\n"
                + "0) Voltar\n";

        int op = Entrada.lerInteiro(msg, input);

        switch (op) {
            case 1:
                Entrada.relatorioPorConceito(s, input);
                break;
            case 2:
                Entrada.relatorioPorArea(s, input);
                break;
            case 3:
                Entrada.relatorioAlunosIrregulares(s);
                break;
            case 0:
                return;
            default:
                System.out.println("Opção inválida.");
        }
    }

    public static void menuCadastro(Sistema s, Scanner input) {
        String msg = "Escolha uma opção:\n" +
                "1) Cadastrar Área\n" +
                "2) Cadastrar Curso\n" +
                "3) Cadastrar Aluno Ingressante\n" +
                "4) Cadastrar Aluno Concluinte\n" +
                "5) Cadastrar Resposta de Questionário\n" +
                "6) Cadastrar Resultado de Prova\n" +
                "0) Voltar\n";

        int op = Entrada.lerInteiro(msg, input);

        if (op == 0) return;

        switch(op) {
            case 1:
                Entrada.cadArea(s, input);
                break;
            case 2:
                Entrada.cadCurso(s, input);
                break;
            case 3:
                Entrada.cadIngressante(s, input);
                break;
            case 4:
                Entrada.cadConcluinte(s, input);
                break;
            case 5:
                Entrada.cadResposta(s, input);
                break;
            case 6:
                Entrada.cadProva(s, input);
                break;
            default:
                System.out.println("Opção Inválida.");
        }

    }

    //MÉTODOS DE CADASTRO

    public static void cadArea(Sistema s, Scanner input) {
        String nome = Entrada.lerLinha("Digite o nome da área: ", input);
        String codigo = Entrada.lerLinha("Digite o código da área: ", input);

        s.cadastrarArea(new Area(nome, codigo));
        System.out.println("Área cadastrada com sucesso!");
    }

    public static void listarAreas(ArrayList<Area> areas){
        System.out.println("Áreas cadastradas:");
        for(Area area : areas){
            System.out.println(area.getNome() + " (" + area.getCodigo() + ")");
        }
    }


    public static void cadCurso(Sistema s, Scanner input){
        String nome = Entrada.lerLinha("Digite o nome do curso: ", input);
        String codigo = Entrada.lerLinha("Digite o código do curso: ", input);

        ArrayList<Area> areas = s.getAreas();
        Entrada.listarAreas(areas);

        String codigoArea = Entrada.lerLinha("Digite o código da área do curso: ", input);
        Area area = s.buscarAreaPorCodigo(codigoArea);

        s.cadastrarCurso(new Curso(nome, codigo), area);
        System.out.println("Curso cadastrado com sucesso!");
    }

    public static void listarCursos(ArrayList<Curso> cursos){
        System.out.println("Cursos cadastrados:");
        for (Curso curso : cursos) {
            System.out.println(curso.getNome() + " (" + curso.getCodigo() + ")");
        }
    }

    public static void cadIngressante(Sistema s, Scanner input){
        String nome = Entrada.lerLinha("Digite o nome do ingressante: ", input);
        String matricula = Entrada.lerLinha("Digite a matrícula do ingressante: ", input);
        int semestre = Entrada.lerInteiro("Digite o semestre de ingresso: ", input);

        Entrada.listarCursos(s.getCursos());
        String codigo = Entrada.lerLinha("Digite o código do curso do aluno: ", input);
        Curso curso = s.buscarCursoPorCodigo(codigo);

        s.cadastrarAluno(new AlunoIngressante(nome, matricula, semestre), curso);
        System.out.println("Aluno ingressante cadastrado com sucesso!");
    }

    public static void cadConcluinte(Sistema s, Scanner input){
        String nome = Entrada.lerLinha("Digite o nome do concluinte: ", input);
        String matricula = Entrada.lerLinha("Digite a matrícula do concluinte: ", input);

        Entrada.listarCursos(s.getCursos());
        String codigo = Entrada.lerLinha("Digite o código do curso do aluno: ", input);
        Curso curso = s.buscarCursoPorCodigo(codigo);

        s.cadastrarAluno(new AlunoConcluinte(nome, matricula), curso);
        System.out.println("Aluno concluinte cadastrado com sucesso!");
    }

    public static void listarAlunosSemQuestionario(ArrayList<Aluno> alunos){
        System.out.println("Alunos cadastrados:");
        for(Aluno aluno : alunos){
            if (!aluno.isQuestionarioRespondido()) {
                System.out.println(aluno);
            }
        }
        
    }

    public static void cadResposta(Sistema s, Scanner input){
        Entrada.listarAlunosSemQuestionario(s.getAlunos());

        String matricula = Entrada.lerLinha("Digite a matrícula do aluno que respondeu ao questionário: ", input);
        Aluno aluno = s.buscarAlunoPorMatricula(matricula);

        aluno.cadastrarResposta();
        System.out.println("Resposta cadastrada com sucesso!");
    }



    // MÉTODOS DE RELATÓRIOS



    public static void relatorioPorConceito(Sistema s, Scanner input) {
        int conceito = Entrada.lerInteiro(
            "Digite o conceito desejado (1 a 5): ", input
        );

        ArrayList<Curso> cursos = s.listarResultados(conceito);

        System.out.println("Cursos com conceito " + conceito + ":");

        if (cursos.isEmpty()) {
            System.out.println(
                "Nenhum curso com conceito " + conceito + " foi encontrado."
            );
            return;
        }

        for (Curso curso : cursos) {
            Area area = s.buscarAreaDoCurso(curso);

            System.out.println(
                curso.getNome() + " (" + curso.getCodigo() + ")"
                + " - Área: " + area.getNome() + " (" + area.getCodigo() + ")"
            );
        }
    }
    public static void relatorioPorArea(Sistema s, Scanner input) {
        Entrada.listarAreas(s.getAreas());

        String nomeArea = Entrada.lerLinha("Digite o nome da área: ", input);
        ArrayList<Curso> cursos = s.listarResultados(nomeArea);

        if (cursos.isEmpty()) {
            System.out.println(
                "Nenhum curso na área " + nomeArea + " foi encontrado."
            );
            return;
        }

        Area area = s.buscarAreaDoCurso(cursos.get(0));

        System.out.println(
            "Conceitos dos cursos da área "
            + area.getNome() + " (" + area.getCodigo() + "):"
        );

        for (Curso curso : cursos) {
            System.out.println(
                curso.getNome() + " (" + curso.getCodigo() + "): "
                + curso.calcularConceito()
            );
        }
    }
    public static void relatorioAlunosIrregulares(Sistema s) {
        System.out.println("Alunos irregulares com o ENADE:");

        for (Aluno aluno : s.listarAlunosIrregulares()) {
            Curso curso = s.buscarCursoDoAluno(aluno);

            System.out.println(
                aluno + " - CURSO: "
                + curso.getNome() + " (" + curso.getCodigo() + ")"
            );
        }
    }

    public static void cadProva(Sistema s, Scanner input){
        System.out.println("Concluintes cadastrados:");
        for (Aluno aluno : s.getAlunos()) {
            if (aluno instanceof AlunoConcluinte concluinte && !concluinte.isPresente()) {
                System.out.println(aluno);
            }
        }

        String matricula = Entrada.lerLinha("Digite a matrícula do aluno que realizou a prova: ", input);
        Aluno aluno = s.buscarAlunoPorMatricula(matricula);

        double notaGeral = Entrada.lerDouble("Digite o valor da nota de formação geral: ", input);
        double notaConhecimento = Entrada.lerDouble("Digite o valor da nota de conhecimentos específicos: ", input);
        ((AlunoConcluinte) aluno).cadastrarProva(notaGeral, notaConhecimento);
        System.out.println("Prova cadastrada com sucesso!");
    }
}
