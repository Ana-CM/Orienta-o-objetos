import javax.swing.*;

public class professorForm {
    private JButton voltarButton;
    private JButton adicionarProfessorButton;
    private JTable professorTable;
    private JButton editarButton;
    private JButton deletarButton;
    private JPanel painelPrincipal;
    private JPanel painelCima;
    private JPanel painelEsquerda;

    public JButton getVoltarButton() {
        return voltarButton;
    }

    public void setVoltarButton(JButton voltarButton) {
        this.voltarButton = voltarButton;
    }

    public JButton getAdicionarProfessorButton() {
        return adicionarProfessorButton;
    }

    public void setAdicionarProfessorButton(JButton adicionarProfessorButton) {
        this.adicionarProfessorButton = adicionarProfessorButton;
    }

    public JTable getProfessorTable() {
        return professorTable;
    }

    public void setProfessorTable(JTable professorTable) {
        this.professorTable = professorTable;
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

    public JPanel getPainelPrincipal() {
        return painelPrincipal;
    }

    public void setPainelPrincipal(JPanel painelPrincipal) {
        this.painelPrincipal = painelPrincipal;
    }

    public JPanel getPainelCima() {
        return painelCima;
    }

    public void setPainelCima(JPanel painelCima) {
        this.painelCima = painelCima;
    }

    public JPanel getPainelEsquerda() {
        return painelEsquerda;
    }

    public void setPainelEsquerda(JPanel painelEsquerda) {
        this.painelEsquerda = painelEsquerda;
    }
}
