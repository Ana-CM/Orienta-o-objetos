package form;

import javax.swing.*;

public class EditarMateriaScreen {
    private JPanel topPanel;

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

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
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

    public JButton getVoltarButton() {
        return voltarButton;
    }

    public void setVoltarButton(JButton voltarButton) {
        this.voltarButton = voltarButton;
    }

    public JButton getEditarButton() {
        return editarButton;
    }

    public void setEditarButton(JButton editarButton) {
        this.editarButton = editarButton;
    }

    private JPanel bottomPanel;
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JTextField nomeTextField;
    private JTextField codigoTextField;
    private JTextField cargaTextField;
    private JButton voltarButton;
    private JButton editarButton;

}
