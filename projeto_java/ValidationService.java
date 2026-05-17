public class ValidationService {

    public boolean validarNome(String nome) {
        return nome != null && !nome.isEmpty();
    }

    public boolean validarMatricula(String matricula) {
        return matricula != null && !matricula.isEmpty();
    }

    public boolean validarCurso(String curso) {
        return curso != null && !curso.isEmpty();
    }

    public boolean validarPeriodo(int periodo) {
        return periodo > 0;
    }

    public boolean validarIdade(int idade) {
        return idade >= 14;
    }

    public boolean validarNomeDisciplina(String nome) {
        return nome != null && !nome.isEmpty();
    }

    public boolean validarProfessor(String professor) {
        return professor != null && !professor.isEmpty();
    }

    public boolean validarCodigo(String codigo) {
        return codigo != null && !codigo.isEmpty();
    }

    public boolean validarTurno(String turno) {
        return turno != null && !turno.isEmpty();
    }

}
