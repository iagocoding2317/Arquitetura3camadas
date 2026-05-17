import java.util.List;

public class EstudanteService {

    private EstudanteRepository estudanteRepository = new EstudanteRepository();

    public void create(String nome, String matricula, String curso, String periodo, int idade) {
        Estudante estudante = new Estudante(nome, matricula, curso, periodo, idade);
        estudanteRepository.save(estudante);
    }

    public List<Estudante> findAll() {
        return estudanteRepository.findAll();
    }

    public Estudante findByMatricula(String matricula) {
        return estudanteRepository.findByMatricula(matricula);
    }

    public boolean update(String novoNome, String matricula, String novoCurso, String novoPeriodo, int novaIdade) {
        return estudanteRepository.update(novoNome, matricula, novoCurso, novoPeriodo, novaIdade);
    }

    public boolean delete(String matricula) {
        return estudanteRepository.delete(matricula);
    }

    public List<Estudante> getLista() {
        return estudanteRepository.getLista();
    }
}
