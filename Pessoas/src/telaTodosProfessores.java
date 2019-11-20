import javax.swing.*;

public class telaTodosProfessores {
    private JPanel todosProfessores;
    private JPanel ProfPainel;
    private JPanel painelTopoProf;
    private JButton voltarButtonProf;
    private JButton adicionarProfessorButton;
    private JPanel painelProfLateral;
    private JButton editarProfButton;
    private JButton deletarProfButton;
    private JButton visualizarProfButton;
    private JTable profTable1;

    public JPanel getTodosProfessores() {
        return todosProfessores;
    }

    public void setTodosProfessores(JPanel todosProfessores) {
        this.todosProfessores = todosProfessores;
    }

    public JPanel getProfPainel() {
        return ProfPainel;
    }

    public void setProfPainel(JPanel profPainel) {
        ProfPainel = profPainel;
    }

    public JPanel getPainelTopoProf() {
        return painelTopoProf;
    }

    public void setPainelTopoProf(JPanel painelTopoProf) {
        this.painelTopoProf = painelTopoProf;
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

    public JPanel getPainelProfLateral() {
        return painelProfLateral;
    }

    public void setPainelProfLateral(JPanel painelProfLateral) {
        this.painelProfLateral = painelProfLateral;
    }

    public JButton getEditarProfButton() {
        return editarProfButton;
    }

    public void setEditarProfButton(JButton editarProfButton) {
        this.editarProfButton = editarProfButton;
    }

    public JButton getDeletarProfButton() {
        return deletarProfButton;
    }

    public void setDeletarProfButton(JButton deletarProfButton) {
        this.deletarProfButton = deletarProfButton;
    }

    public JButton getVisualizarProfButton() {
        return visualizarProfButton;
    }

    public void setVisualizarProfButton(JButton visualizarProfButton) {
        this.visualizarProfButton = visualizarProfButton;
    }

    public JTable getProfTable1() {
        return profTable1;
    }

    public void setProfTable1(JTable profTable1) {
        this.profTable1 = profTable1;
    }
}
