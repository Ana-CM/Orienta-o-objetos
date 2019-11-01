import java.util.ArrayList;
import java.util.List;
// altercao teste
public class Professor extends Pessoa{

   private String departamento;
   private List <Materia> listaMateria = new Arraylist<>();
   private int totalHoras;
   private String departamento;

   // construtor
   public Professor(String nome, String CPF, String matricula, List<Materia> listaMateria, String departamento){
       super( Professor.nome, Professor.CPF, Professor.matricula, Professor.listaMateria);
       this.departamento = departamento;
       }
   
   public List<Materia> getListaMateria(){

     return listaMateria;
   }
   public void addMateria(Materia materia){
      
      listaMateria.add(materia);
   }  
   public void removeMateria(Materia materia){
    // método para remover uma matéria
     listaMateria.remove(materia);
   }
   public String getDepartamento(){
      return departamento;
   }

   public void calculaTotalHoras(){
    // método para calcular o total de horas, somando toda a carga       //horária das matérias lecionada  mais o horário de atendimento
    int totalHoras = 0;
        for (Materia materia : listaMateria)
            totalHoras += materia.getCargaHoraria();
        return totalHoras;
   } 
}



