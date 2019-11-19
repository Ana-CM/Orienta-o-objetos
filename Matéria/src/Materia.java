public class Materia {
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Materia(String nome, String codigo, int cargaHoraria){
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome(){
        return nome;
    }
    public String getCodigo(){
        return codigo;
    }
    public int getCargaHoraria(){
        return cargaHoraria;
    }

    @Override
    public String toString () {
        return new String ( this.getCodigo()  + " - " + this.getNome() );
    }
}
