package form;

import javax.swing.*;

public class AdicionarMateriaScreen {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JButton voltarButton;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public void setTopPanel(JPanel topPanel) {
        this.topPanel = topPanel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(JPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
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

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(JPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public JTextField getNomeTextField() {
        return nomeTextField;
    }

    public void setNomeTextField(JTextField nomeTextField) {
        this.nomeTextField = nomeTextField;
    }

    public JTextField getCodigoTextField() {
        return codigoTextField;
    }

    public void setCodigoTextField(JTextField codigoTextField) {
        this.codigoTextField = codigoTextField;
    }

    public JTextField getCargaTextField() {
        return cargaTextField;
    }

    public void setCargaTextField(JTextField cargaTextField) {
        this.cargaTextField = cargaTextField;
    }

    private JButton adicionarButton;
    private JPanel centerPanel;
    private JTextField nomeTextField;
    private JTextField codigoTextField;
    private JTextField cargaTextField;
}
