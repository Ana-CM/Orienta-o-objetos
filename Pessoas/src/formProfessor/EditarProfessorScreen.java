package formProfessor;

import javax.swing.*;

public class EditarProfessorScreen {
    private JPanel panel1;
    private JTextField c_nome;
    private JTextField c_cpf;
    private JTextField textField3;
    private JTextField c_departamento;
    private JComboBox cb_materia;
    private JButton adicionarButton;
    private JButton removerButton;
    private JButton voltarButton;
    private JButton salvarButton;

    public JTextField getC_nome() {
        return c_nome;
    }

    public void setC_nome(JTextField c_nome) {
        this.c_nome = c_nome;
    }

    public JTextField getC_cpf() {
        return c_cpf;
    }

    public void setC_cpf(JTextField c_cpf) {
        this.c_cpf = c_cpf;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JTextField getC_departamento() {
        return c_departamento;
    }

    public void setC_departamento(JTextField c_departamento) {
        this.c_departamento = c_departamento;
    }

    public JComboBox getCb_materia() {
        return cb_materia;
    }

    public void setCb_materia(JComboBox cb_materia) {
        this.cb_materia = cb_materia;
    }

    public JButton getAdicionarButton() {
        return adicionarButton;
    }

    public void setAdicionarButton(JButton adicionarButton) {
        this.adicionarButton = adicionarButton;
    }

    public JButton getRemoverButton() {
        return removerButton;
    }

    public void setRemoverButton(JButton removerButton) {
        this.removerButton = removerButton;
    }

    public JButton getVoltarButton() {
        return voltarButton;
    }

    public void setVoltarButton(JButton voltarButton) {
        this.voltarButton = voltarButton;
    }

    public JButton getSalvarButton() {
        return salvarButton;
    }

    public void setSalvarButton(JButton salvarButton) {
        this.salvarButton = salvarButton;
    }
}
