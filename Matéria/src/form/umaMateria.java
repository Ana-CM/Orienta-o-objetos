package form;

import javax.swing.*;

public class umaMateria {
    private JPanel UmaMateria;
    private JPanel painelEditaMateria;
    private JPanel painelMateriaIndividual;
    private JPanel individualMateriaPainel;
    private JPanel individualMateriaTopoPainel;
    private JPanel addMateriaCentroPainel;
    private JLabel materiaIndividualCodigo;
    private JButton voltarIndividualMateria;
    private JLabel cargaHorariaIndividual;
    private JLabel MateriaIndividualNome;

    public JPanel getUmaMateria() {
        return UmaMateria;
    }

    public void setUmaMateria(JPanel umaMateria) {
        UmaMateria = umaMateria;
    }

    public JPanel getPainelEditaMateria() {
        return painelEditaMateria;
    }

    public void setPainelEditaMateria(JPanel painelEditaMateria) {
        this.painelEditaMateria = painelEditaMateria;
    }

    public JPanel getPainelMateriaIndividual() {
        return painelMateriaIndividual;
    }

    public void setPainelMateriaIndividual(JPanel painelMateriaIndividual) {
        this.painelMateriaIndividual = painelMateriaIndividual;
    }

    public JPanel getIndividualMateriaPainel() {
        return individualMateriaPainel;
    }

    public void setIndividualMateriaPainel(JPanel individualMateriaPainel) {
        this.individualMateriaPainel = individualMateriaPainel;
    }

    public JPanel getIndividualMateriaTopoPainel() {
        return individualMateriaTopoPainel;
    }

    public void setIndividualMateriaTopoPainel(JPanel individualMateriaTopoPainel) {
        this.individualMateriaTopoPainel = individualMateriaTopoPainel;
    }

    public JPanel getAddMateriaCentroPainel() {
        return addMateriaCentroPainel;
    }

    public void setAddMateriaCentroPainel(JPanel addMateriaCentroPainel) {
        this.addMateriaCentroPainel = addMateriaCentroPainel;
    }

    public JLabel getMateriaIndividualCodigo() {
        return materiaIndividualCodigo;
    }

    public void setMateriaIndividualCodigo(JLabel materiaIndividualCodigo) {
        this.materiaIndividualCodigo = materiaIndividualCodigo;
    }

    public JButton getVoltarIndividualMateria() {
        return voltarIndividualMateria;
    }

    public void setVoltarIndividualMateria(JButton voltarIndividualMateria) {
        this.voltarIndividualMateria = voltarIndividualMateria;
    }

    public JLabel getCargaHorariaIndividual() {
        return cargaHorariaIndividual;
    }

    public void setCargaHorariaIndividual(JLabel cargaHorariaIndividual) {
        this.cargaHorariaIndividual = cargaHorariaIndividual;
    }

    public JLabel getMateriaIndividualNome() {
        return MateriaIndividualNome;
    }

    public void setMateriaIndividualNome(JLabel materiaIndividualNome) {
        MateriaIndividualNome = materiaIndividualNome;
    }
}
