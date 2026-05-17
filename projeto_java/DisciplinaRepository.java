import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository {

    private List<Disciplina> lista = new ArrayList<>();

    public void save(Disciplina disciplina) {
        lista.add(disciplina);
    }

    public List<Disciplina> findAll() {
        return lista;
    }

    public Disciplina findByCodigo(String codigo) {
        for (Disciplina disciplina : lista) {
            if (disciplina.getCodigo().equals(codigo)) {
                return disciplina;
            }
        }
        return null;
    }

    public boolean update(String codigo, String nome,
                          String professor, String turno) {
        Disciplina disciplina = findByCodigo(codigo);
        if (disciplina != null) {
            disciplina.setNome(nome);
            disciplina.setProfessor(professor);
            disciplina.setTurno(turno);
            return true;
        }
        return false;
    }

    public boolean delete(String codigo) {
        for (Disciplina disciplina : lista) {
            if (disciplina.getCodigo().equals(codigo)) {
                lista.remove(disciplina);
                return true;
            }
        }
        return false;
    }

    public List<Disciplina> getLista() {
        return lista;
    }
}
