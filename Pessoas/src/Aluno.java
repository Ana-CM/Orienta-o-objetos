import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{

    private String matricula;
    private List<Materia> listaMateria = new ArrayList<>();
    public Aluno(String nome, String CPF, String matricula, List<Materia> listaMateria, String dataNascimento){
        super(nome, CPF, dataNascimento);
        this.matricula = matricula;
        this.listaMateria = listaMateria;
    }

    public List<Materia> getListaMateria(){
        return listaMateria;
    }
    public void addMateria(Materia materia){
        this.listaMateria.add(materia);
    }
    public void removeMateria(Materia materia){
        this.listaMateria.remove(materia);
    }
    public String getMatricula(){
        return matricula;
    }
    public void calculaTotalHoras(){
        for(Materia m : listaMateria){
            totalhoras = totalhoras + m.cargahoraria;
        }
    }
}
