import javax.swing.*;

public class telaUmProf {
    private JPanel umProf;
    private JPanel painelProfIndividual;
    private JPanel individualProfPainel;
    private JPanel individualProfTopoPainel;
    private JPanel addProfCentroPainel;
    private JLabel profIndividualData;
    private JButton voltarIndividualProfessor;
    private JComboBox profIndividualMateriasCB;
    private JLabel profINdividualCpf;
    private JLabel profIndividualNome;
    private JLabel profIndividualDepartamento;
    private JLabel CargaHorariprof;
    private JLabel profHoras;
    private JLabel salario;

    public JPanel getUmProf() {
        return umProf;
    }

    public JLabel getSalario() {
        return salario;
    }

    public void setSalario(JLabel salario) {
        this.salario = salario;
    }

    public void setUmProf(JPanel umProf) {
        this.umProf = umProf;
    }

    public JPanel getPainelProfIndividual() {
        return painelProfIndividual;
    }

    public void setPainelProfIndividual(JPanel painelProfIndividual) {
        this.painelProfIndividual = painelProfIndividual;
    }

    public JPanel getIndividualProfPainel() {
        return individualProfPainel;
    }

    public void setIndividualProfPainel(JPanel individualProfPainel) {
        this.individualProfPainel = individualProfPainel;
    }

    public JPanel getIndividualProfTopoPainel() {
        return individualProfTopoPainel;
    }

    public void setIndividualProfTopoPainel(JPanel individualProfTopoPainel) {
        this.individualProfTopoPainel = individualProfTopoPainel;
    }

    public JPanel getAddProfCentroPainel() {
        return addProfCentroPainel;
    }

    public void setAddProfCentroPainel(JPanel addProfCentroPainel) {
        this.addProfCentroPainel = addProfCentroPainel;
    }

    public JLabel getProfIndividualData() {
        return profIndividualData;
    }

    public void setProfIndividualData(JLabel profIndividualData) {
        this.profIndividualData = profIndividualData;
    }

    public JButton getVoltarIndividualProfessor() {
        return voltarIndividualProfessor;
    }

    public void setVoltarIndividualProfessor(JButton voltarIndividualProfessor) {
        this.voltarIndividualProfessor = voltarIndividualProfessor;
    }

    public JComboBox getProfIndividualMateriasCB() {
        return profIndividualMateriasCB;
    }

    public void setProfIndividualMateriasCB(JComboBox profIndividualMateriasCB) {
        this.profIndividualMateriasCB = profIndividualMateriasCB;
    }

    public JLabel getProfINdividualCpf() {
        return profINdividualCpf;
    }

    public void setProfINdividualCpf(JLabel profINdividualCpf) {
        this.profINdividualCpf = profINdividualCpf;
    }

    public JLabel getProfIndividualNome() {
        return profIndividualNome;
    }

    public void setProfIndividualNome(JLabel profIndividualNome) {
        this.profIndividualNome = profIndividualNome;
    }

    public JLabel getProfIndividualDepartamento() {
        return profIndividualDepartamento;
    }

    public void setProfIndividualDepartamento(JLabel profIndividualDepartamento) {
        this.profIndividualDepartamento = profIndividualDepartamento;
    }

    public JLabel getCargaHorariprof() {
        return CargaHorariprof;
    }

    public void setCargaHorariprof(JLabel cargaHorariprof) {
        CargaHorariprof = cargaHorariprof;
    }

    public JLabel getProfHoras() {
        return profHoras;
    }

    public void setProfHoras(JLabel profHoras) {
        this.profHoras = profHoras;
    }
}
