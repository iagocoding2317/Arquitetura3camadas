import java.util.ArrayList;


public class Disciplina {
    private String nome;
    private String professor;
    private String codigo;
    private String turno;
    private ArrayList<Estudante> estudantes;
    

    public Disciplina(String nome, String professor, String codigo, String turno) {
        this.nome = nome;
        this.professor = professor;
        this.codigo = codigo;
        this.turno = turno;
        this.estudantes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getProfessor() {
        return professor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTurno() {
        return turno;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

   

    public void inserirEstudante(Estudante e){
        estudantes.add(e);

    }

    
    public String toString() {
     return "Nome: " + nome + " Professor: " + professor + " Codigo: " + codigo + " Turno: " + turno + " Estudantes: " + estudantes;
    }
}