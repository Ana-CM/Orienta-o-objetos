import java.util.ArrayList;



public class Professor extends Pessoa{

    private String departamento;
    private ArrayList <Materia> listaMateria = new ArrayList<>();
    private int totalHoras;


    // construtor
    public Professor(String nome, String CPF, String departamento, ArrayList<Materia> listaMateria, String dataNascimento){
        super(nome, CPF, dataNascimento);
        this.departamento = departamento;
        this.listaMateria = listaMateria;
    }


    public ArrayList<Materia> getListaMateria(){
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



    @Override
    public void calculaTotalHoras(){

        totalhoras = 0;
        for (Materia materia : listaMateria){
            totalHoras = ((1/4)*materia.getCargaHoraria()) + totalHoras + materia.getCargaHoraria() ;
        }

    }

}




