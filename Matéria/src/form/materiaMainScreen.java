package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class materiaMainScreen {
    private JPanel mainPanel;
    private JButton voltarButton;
    private JPanel tablePanel;
    private JButton adicionarMatériaButton;
    private JTable materiaTable;
    private JButton editarButton;
    private JButton deletarButton;
    private JPanel rightPanel;
    private JButton visualizarButtonMateria;

    public JButton getVisualizarButtonMateria() {
        return visualizarButtonMateria;
    }

    public void setVisualizarButtonMateria(JButton visualizarButtonMateria) {
        this.visualizarButtonMateria = visualizarButtonMateria;
    }

    public void atualizaCardList(){

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getTablePanel() {
        return tablePanel;
    }

    public void setTablePanel(JPanel tablePanel) {
        this.tablePanel = tablePanel;
    }

    public JButton getAdicionarMatériaButton() {
        return adicionarMatériaButton;
    }

    public void setAdicionarMatériaButton(JButton adicionarMatériaButton) {
        this.adicionarMatériaButton = adicionarMatériaButton;
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

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

    public JButton getVoltarButton() {
        return voltarButton;
    }

    public JTable getMateriaTable() {
        return materiaTable;
    }

    public void setMateriaTable(JTable materiaTable) {
        this.materiaTable = materiaTable;
    }

    public void setVoltarButton(JButton voltarButton) {
        this.voltarButton = voltarButton;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

}
