import java.util.ArrayList;
import java.util.List;
public class Professor extends Pessoa{

   private String departamento;
   private List <Materia> listaMateria = new ArrayList<>();
   private int totalHoras;

   // construtor
   public Professor(String nome, String CPF, String departamento, String dataNascimento ,List<Materia> listaMateria){
       super( nome, CPF, dataNascimento);
       this.departamento = departamento;
       this.listaMateria = listaMateria;
       }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<Materia> getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(List<Materia> listaMateria) {
        this.listaMateria = listaMateria;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }


    public void addMateria(Materia materia){
        listaMateria.add(materia);
    }
    public void removeMateria(Materia materia){
        this.listaMateria.remove(materia);
    }

    public String calculaTotalHoras(){
        // método para calcular o total de horas, somando toda a carga       //horária das matérias lecionada  mais o horário de atendimento
        int totalHoras = 0;
        for (Materia materia : listaMateria)
            totalHoras += materia.getCargaHoraria()+1.2;
        return Float.toString(totalHoras);
    }
}



