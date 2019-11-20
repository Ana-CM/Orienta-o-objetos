import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa{

    private String matricula;
    private List<Materia> listaMateria = new ArrayList<>();

    public Aluno(String nome, String CPF, String matricula, String dataNascimento, List<Materia> listaMateria){
        super(nome, CPF, dataNascimento);
        this.matricula = matricula;
        this.listaMateria=listaMateria;
    }
    public List<Materia> getListaMateria(){
        return listaMateria;
    }

    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public void addMateria(Materia materia){
        listaMateria.add(materia);
    }
    public void removeMateria(Materia materia){
        this.listaMateria.remove(materia);
    }

    public String getMatricula(){
        return matricula;
    }

    public String calculaTotalHoras(){
        int horas = 0;

        for(Materia m : listaMateria){
            horas = horas + m.getCargaHoraria();
        }

        return Integer.toString(horas);
    }
}
