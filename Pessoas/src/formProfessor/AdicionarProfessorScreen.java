package formProfessor;

import javax.swing.*;

public class AdicionarProfessorScreen {
    private JPanel topPainel;
    private JPanel centerPainel;

    public JPanel getTopPainel() {
        return topPainel;
    }

    public void setTopPainel(JPanel topPainel) {
        this.topPainel = topPainel;
    }

    private JTextField c_dataNascimento;
    private JTextField c_nome;
    private JTextField c_cpf;
    private JTextField c_departamento;
    private JComboBox cb_materia;
    private JButton adicionarMatériaButton;
    private JButton voltarButton;
    private JButton adicionarButton;
    private JButton removerButton;
    private JComboBox comboBox1;


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

    public JButton getAdicionarMatériaButton() {
        return adicionarMatériaButton;
    }

    public void setAdicionarMatériaButton(JButton adicionarMatériaButton) {
        this.adicionarMatériaButton = adicionarMatériaButton;
    }

    public JButton getVoltarButton() {
        return voltarButton;
    }

    public void setVoltarButton(JButton voltarButton) {
        this.voltarButton = voltarButton;
    }

    public JButton getAdicionarButton() {
        return adicionarButton;
    }

    public void setAdicionarButton(JButton adicionarButton) {
        this.adicionarButton = adicionarButton;
    }

    public JTextField getC_dataNascimento() {
        return c_dataNascimento;
    }

    public void setC_dataNascimento(JTextField c_dataNascimento) {
        this.c_dataNascimento = c_dataNascimento;
    }
}
