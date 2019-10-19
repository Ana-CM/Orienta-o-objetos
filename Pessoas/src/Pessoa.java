public class Pessoa {
    private String nome;
    private int totalhoras;
    private String CPF;
    private String dataNascimento;

    public Pessoa(String nome, int totalhoras, String CPF, String dataNascimento) {
        this.nome = nome;
        this.totalhoras = totalhoras;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTotalhoras() {
        return totalhoras;
    }

    public void setTotalhoras(int totalhoras) {
        this.totalhoras = totalhoras;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void calculaTotalHoras() {

    }
}