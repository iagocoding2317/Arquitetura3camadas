import java.util.ArrayList;
import java.util.List;

public class EstudanteRepository {

    private List<Estudante> lista = new ArrayList<>();

    public void save(Estudante estudante) {
        lista.add(estudante);
    }

    public List<Estudante> findAll() {
        return lista;
    }

    public Estudante findByMatricula(String matricula) {
        for (Estudante estudante : lista) {
            if (estudante.getMatricula().equals(matricula)) {
                return estudante;
            }
        }
        return null;
    }

    public boolean update(String matricula, String nome,
                          String curso, String periodo, int idade) {
        Estudante estudante = findByMatricula(matricula);
        if (estudante != null) {
            estudante.setNome(nome);
            estudante.setCurso(curso);
            estudante.setPeriodo(periodo);
            estudante.setIdade(idade);
            return true;
        }
        return false;
    }

    public boolean delete(String matricula) {
        for (Estudante estudante : lista) {
            if (estudante.getMatricula().equals(matricula)) {
                lista.remove(estudante);
                return true;
            }
        }
        return false;
    }

}
