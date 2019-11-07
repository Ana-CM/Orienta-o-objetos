import java.util.ArrayList;
import java.util.List;
// altercao teste
public class Professor extends Pessoa{

   private String departamento;
   private List <Materia> listaMateria = new ArrayList<>();
   private int totalHoras;

   // construtor
   public Professor(String nome, String CPF, String dataNascimento,List<Materia> listaMateria ){
       super( nome, CPF, dataNascimento);
       this.listaMateria = listaMateria;
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
        totalHoras = 0;
        for (Materia materia : listaMateria)
            totalHoras = ( totalhoras + materia.getCargaHoraria() + (int)(0.25*materia.getCargaHoraria()) );

   } 
}



