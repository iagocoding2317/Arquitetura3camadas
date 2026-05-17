import java.util.List;
import java.util.Scanner;

public class Menu {
    public static final PrinterService printerService = new PrinterService();
    public static final ReaderService readerService = new ReaderService();
    public static final EstudanteController estudanteController = new EstudanteController();
    public static final DisciplinaController disciplinaController = new DisciplinaController();

    private static void createEstudante() {
        printerService.println("Digite o nome: ");
        String nome = readerService.nextLine();

        printerService.println("Digite a matrícula: ");
        String matricula = readerService.nextLine();

        printerService.println("Digite o curso: ");
        String curso = readerService.nextLine();

        printerService.println("Digite o período: ");
        String periodo = readerService.nextLine();

        printerService.println("Digite a idade: ");
        String idadeStr = readerService.nextLine();
        int idade = Integer.parseInt(idadeStr);

        estudanteController.create(nome, matricula, curso, periodo, idade);
    }

    private static void createDisciplina() {
        printerService.println("Digite o nome da disciplina: ");
        String nome = readerService.nextLine();

        printerService.println("Digite o nome do professor: ");
        String professor = readerService.nextLine();

        printerService.println("Digite o código da disciplina: ");
        String codigo = readerService.nextLine();

        printerService.println("Digite o turno: ");
        String turno = readerService.nextLine();

        disciplinaController.create(nome, professor, codigo, turno);
    }

    public void iniciar() {
        int opcao;

        do {
            exibirMenu();
            opcao = readerService.nextInt();
            processarOpcao(opcao);
        } while (opcao != 9);
    }

    private void exibirMenu() {
        printerService.println("\n--- MENU ---");
        printerService.println("1 - Cadastrar Estudante");
        printerService.println("2 - Editar Estudante");
        printerService.println("3 - Deletar Estudante");
        printerService.println("4 - Cadastrar Disciplina");
        printerService.println("5 - Editar Disciplina");
        printerService.println("6 - Deletar Disciplina");
        printerService.println("7 - Inserir Estudante em Disciplina");
        printerService.println("8 - Listar Tudo");
        printerService.println("9 - Sair");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                createEstudante();
                break;
            case 2:
                editEstudante();
                break;
            case 3:
                deleteEstudante();
                break;
            case 4:
                createDisciplina();
                break;
            case 5:
                editDisciplina();
                break;
            case 6:
                deleteDisciplina();
                break;
            case 7:
                inserirAluno();
                break;
            case 8:
                showAll();
                break;
            case 9:
                printerService.println("Encerrando...");
                break;
            default:
                printerService.println("Opção inválida.");
        }
    }

    private static void deleteEstudante() {
        estudanteController.showAll();

        printerService.println("Digite a matrícula do estudante que deseja deletar: ");
        String matricula = readerService.nextLine();

        boolean result = estudanteController.delete(matricula);

        if (result) {
            printerService.println("Estudante deletado.");
        } else {
            printerService.println("Estudante não foi deletado.");
        }
    }

    private static void showAll() {
        estudanteController.showAll();
        disciplinaController.showAll();
    }

    private static void editEstudante() {
        estudanteController.showAll();

        printerService.println("Digite a matrícula do estudante que deseja modificar: ");
        String antigaMatricula = readerService.nextLine();

        printerService.println("Digite o novo nome: ");
        String novoNome = readerService.nextLine();

        printerService.println("Digite a nova matrícula: ");
        String novaMatricula = readerService.nextLine();

        printerService.println("Digite o novo curso: ");
        String novoCurso = readerService.nextLine();

        printerService.println("Digite o novo período: ");
        String novoPeriodo = readerService.nextLine();

        printerService.println("Digite a nova idade: ");
        String novaIdade = readerService.nextLine();

        boolean result = estudanteController.update(antigaMatricula, novoNome, novaMatricula, novoCurso, novoPeriodo, novaIdade);

        if (result) {
            printerService.println("Estudante atualizado.");
        } else {
            printerService.println("Estudante não foi atualizado.");
        }
    }

    private static void deleteDisciplina() {
        disciplinaController.showAll();

        printerService.println("Digite o código da disciplina que deseja deletar: ");
        String codigo = readerService.nextLine();

        disciplinaController.delete(codigo);
    }

    private static void editDisciplina() {
        disciplinaController.showAll();

        printerService.println("Digite o código da disciplina que deseja modificar: ");
        String codigoAntigo = readerService.nextLine();

        printerService.println("Digite o novo nome: ");
        String novoNome = readerService.nextLine();

        printerService.println("Digite o novo professor: ");
        String novoProfessor = readerService.nextLine();

        printerService.println("Digite o novo turno: ");
        String novoTurno = readerService.nextLine();

        disciplinaController.update(codigoAntigo, novoNome, novoProfessor, novoTurno);
    }

    private void inserirAluno() {
        List<Estudante> listaEstudantes = estudanteController.getLista();
        List<Disciplina> listaDisciplinas = disciplinaController.getLista();

        if (listaEstudantes.isEmpty() || listaDisciplinas.isEmpty()) {
            printerService.println("Cadastre ao menos um estudante e uma disciplina antes.");
            return;
        }

        estudanteController.showAll();
        printerService.println("Escolha o índice do estudante: ");
        int i = readerService.nextInt();

        disciplinaController.showAll();
        printerService.println("Escolha o índice da disciplina: ");
        int j = readerService.nextInt();

        if (i < 0 || i >= listaEstudantes.size() || j < 0 || j >= listaDisciplinas.size()) {
            printerService.println("Índice inválido.");
            return;
        }

        Estudante estudante = listaEstudantes.get(i);
        Disciplina disciplina = listaDisciplinas.get(j);
        disciplina.inserirEstudante(estudante);
        printerService.println("Estudante " + estudante.getNome() + " inserido em " + disciplina.getNome() + ".");
    }
}
