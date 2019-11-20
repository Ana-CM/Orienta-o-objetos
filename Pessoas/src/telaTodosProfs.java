import javax.swing.*;

public class telaTodosProfs {
    private JPanel ProfessorPainel;
    private JButton voltarButtonProf;
    private JButton adicionarProfessorButton;
    private JTable profTable1;
    private JButton editarButton;
    private JButton deletarButton;
    private JPanel painelTopoProfessor;
    private JPanel painelProfLateral;
    private JButton visualizarProfButton;

    public JButton getVisualizarProfButton() {
        return visualizarProfButton;
    }

    public void setVisualizarProfButton(JButton visualizarProfButton) {
        this.visualizarProfButton = visualizarProfButton;
    }

    public JPanel getProfessorPainel() {
        return ProfessorPainel;
    }

    public void setProfessorPainel(JPanel professorPainel) {
        ProfessorPainel = professorPainel;
    }

    public JButton getVoltarButtonProf() {
        return voltarButtonProf;
    }

    public void setVoltarButtonProf(JButton voltarButtonProf) {
        this.voltarButtonProf = voltarButtonProf;
    }

    public JButton getAdicionarProfessorButton() {
        return adicionarProfessorButton;
    }

    public void setAdicionarProfessorButton(JButton adicionarProfessorButton) {
        this.adicionarProfessorButton = adicionarProfessorButton;
    }

    public JTable getProfTable1() {
        return profTable1;
    }

    public void setProfTable1(JTable profTable1) {
        this.profTable1 = profTable1;
    }

    public JButton getEditarButton() {
        return editarButton;
    }

    public void setEditarButton(JButton editarButton) {
        this.editarButton = editarButton;
    }

    public JButton getDeletarButton() {
        return deletarButton;
    }

    public void setDeletarButton(JButton deletarButton) {
        this.deletarButton = deletarButton;
    }

    public JPanel getPainelTopoProfessor() {
        return painelTopoProfessor;
    }

    public void setPainelTopoProfessor(JPanel painelTopoProfessor) {
        this.painelTopoProfessor = painelTopoProfessor;
    }

    public JPanel getPainelProfLateral() {
        return painelProfLateral;
    }

    public void setPainelProfLateral(JPanel painelProfLateral) {
        this.painelProfLateral = painelProfLateral;
    }


}
