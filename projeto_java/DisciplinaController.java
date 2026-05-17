import java.util.List;

public class DisciplinaController {

    private DisciplinaService disciplinaService = new DisciplinaService();
    private ValidationService validationService = new ValidationService();
    private PrinterService printerService = new PrinterService();

    public void create(String nome, String professor, String codigo, String turno) {
        if (!validationService.validarNome(nome)) {
            printerService.println("Nome inválido.");
            return;
        }
        disciplinaService.create(nome, professor, codigo, turno);
        printerService.println("Disciplina cadastrada com sucesso!");
    }

    public List<Disciplina> findAll() {
        return disciplinaService.findAll();
    }

    public Disciplina findByCodigo(String codigo) {
        return disciplinaService.findByCodigo(codigo);
    }

    public void update(String codigo, String novoNome, String novoProfessor, String novoTurno) {
        if (!validationService.validarNome(novoNome)) {
            printerService.println("Nome inválido.");
            return;
        }
        boolean atualizado = disciplinaService.update(codigo, novoNome, novoProfessor, novoTurno);
        if (atualizado) {
            printerService.println("Disciplina atualizada com sucesso!");
        } else {
            printerService.println("Disciplina não encontrada.");
        }
    }

    public void delete(String codigo) {
        boolean deletado = disciplinaService.delete(codigo);
        if (deletado) {
            printerService.println("Disciplina removida com sucesso!");
        } else {
            printerService.println("Disciplina não encontrada.");
        }
    }

    public void showAll() {
        List<Disciplina> lista = disciplinaService.findAll();
        if (lista.isEmpty()) {
            printerService.println("Nenhuma disciplina cadastrada.");
        } else {
            for (Disciplina d : lista) {
                printerService.println(d.toString());
            }
        }
    }

    public List<Disciplina> getLista() {
        return disciplinaService.getLista();
    }
}
