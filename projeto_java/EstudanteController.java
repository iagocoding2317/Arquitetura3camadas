import java.util.List;

public class EstudanteController {

    private EstudanteService estudanteService = new EstudanteService();
    private ValidationService validationService = new ValidationService();
    private PrinterService printerService = new PrinterService();

    public void create(String nome, String matricula, String curso, String periodo, int idade) {
        if (!validationService.validarNome(nome)) {
            printerService.println("Nome inválido.");
            return;
        }
        estudanteService.create(nome, matricula, curso, periodo, idade);
        printerService.println("Estudante cadastrado com sucesso!");
    }

    public List<Estudante> findAll() {
        return estudanteService.findAll();
    }

    public Estudante findByMatricula(String matricula) {
        return estudanteService.findByMatricula(matricula);
    }

    public boolean update(String matricula, String novoNome, String novaMatricula,
                          String novoCurso, String novoPeriodo, String novaIdade) {
        if (!validationService.validarNome(novoNome)) {
            printerService.println("Nome inválido.");
            return false;
        }
        int idade;
        try {
            idade = Integer.parseInt(novaIdade);
        } catch (NumberFormatException e) {
            printerService.println("Idade inválida.");
            return false;
        }
        boolean atualizado = estudanteService.update(matricula, novoNome, novoCurso, novoPeriodo, idade);
        if (atualizado) {
            printerService.println("Estudante atualizado com sucesso!");
        } else {
            printerService.println("Estudante não encontrado.");
        }
        return atualizado;
    }

    public boolean delete(String matricula) {
        boolean deletado = estudanteService.delete(matricula);
        if (deletado) {
            printerService.println("Estudante removido com sucesso!");
        } else {
            printerService.println("Estudante não encontrado.");
        }
        return deletado;
    }

    public void showAll() {
        List<Estudante> lista = estudanteService.findAll();
        if (lista.isEmpty()) {
            printerService.println("Nenhum estudante cadastrado.");
        } else {
            for (Estudante e : lista) {
                printerService.println(e.toString());
            }
        }
    }

    public List<Estudante> getLista() {
        return estudanteService.getLista();
    }
}
