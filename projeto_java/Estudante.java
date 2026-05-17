
public class Estudante {
    private String nome;
    private String matricula;
    private String curso;
    private String periodo;
    private int idade;

    

    public Estudante(String nome, String matricula, String curso, String periodo, int idade) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.periodo = periodo;
        this.idade = idade;
    }
    
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    
    public String toString() {
         return "Nome: " + nome + " Matrícula: " + matricula + " Curso: " + curso + " Período: " + periodo + " Idade: " + idade;
    }
}