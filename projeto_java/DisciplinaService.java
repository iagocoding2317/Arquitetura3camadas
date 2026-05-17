import java.util.List;

public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository = new DisciplinaRepository();

    public void create(String nome, String professor, String codigo, String turno) {
        Disciplina disciplina = new Disciplina(nome, professor, codigo, turno);
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Disciplina findByCodigo(String codigo) {
        return disciplinaRepository.findByCodigo(codigo);
    }

    public boolean update(String codigo, String novoNome, String novoProfessor, String novoTurno) {
        return disciplinaRepository.update(codigo, novoNome, novoProfessor, novoTurno);
    }

    public boolean delete(String codigo) {
        return disciplinaRepository.delete(codigo);
    }

    public List<Disciplina> getLista() {
        return disciplinaRepository.getLista();
    }
}
