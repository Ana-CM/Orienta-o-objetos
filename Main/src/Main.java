import form.AdicionarMateriaScreen;
import form.EditarMateriaScreen;
import form.materiaMainScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main{

    JFrame frame = new JFrame("Sistema Escola");
    private static List<Materia> materiaList = new ArrayList<>();
    private JPanel painelInicial;
    private JButton botaoListaAlunos;
    private JButton botaoListaProfessores;
    private JButton botaoListaMaterias;
    final static String PAINELINICIAL = "Painel Inicial";
    final static String MATERIAPAINEL = "Painel Materia";
    final static String ADDMATERIAPAINEL = "Painel Adicionar Materia";
    final static String EDITMATERIAPAINEL = "Painel Editar Materia";
    final static String ALUNOPAINEL = "Painel Aluno";
    final static String ADDALUNOPAINEL = "Painel Adicionar Aluno";
    final static String EDITALUNOPAINEL = "Painel Editar Aluno";
    JPanel cards;
    materiaMainScreen MateriaPanel = new materiaMainScreen();
    AdicionarMateriaScreen AdicionarMateriaPanel = new AdicionarMateriaScreen();
    EditarMateriaScreen EditarMateriaPanel = new EditarMateriaScreen();
    telaTodosAlunos TelaTodosAlunos = new telaTodosAlunos();
    telaAdicionaAluno telaAdicionaAluno = new telaAdicionaAluno();

    public Main(){

        MateriaPanel.getVoltarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PAINELINICIAL);
            }
        });
        botaoListaMaterias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(MATERIAPAINEL);
                buildMateria();

            }
        });
        MateriaPanel.getDeletarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                materiaList.remove(MateriaPanel.getMateriaTable().getSelectedRow());
                buildMateria();
            }
        });
        MateriaPanel.getAdicionarMatériaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(ADDMATERIAPAINEL);
                AdicionarMateriaPanel.getNomeTextField().setText("");
                AdicionarMateriaPanel.getCodigoTextField().setText("");
                AdicionarMateriaPanel.getCargaTextField().setText("");
            }
        });
        AdicionarMateriaPanel.getVoltarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(MATERIAPAINEL);
            }
        });
        AdicionarMateriaPanel.getAdicionarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                materiaList.add(new Materia(AdicionarMateriaPanel.getNomeTextField().getText(),
                        AdicionarMateriaPanel.getCodigoTextField().getText(),
                        Integer.parseInt(AdicionarMateriaPanel.getCargaTextField().getText())));
                buildMateria();
                changeScreen(MATERIAPAINEL);
            }
        });
        MateriaPanel.getEditarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(EDITMATERIAPAINEL);
                EditarMateriaPanel.getNomeTextField().setText(materiaList.get(MateriaPanel.getMateriaTable().getSelectedRow()).getNome());
                EditarMateriaPanel.getCodigoTextField().setText(materiaList.get(MateriaPanel.getMateriaTable().getSelectedRow()).getCodigo());
                EditarMateriaPanel.getCargaTextField().setText(Integer.toString(materiaList.get((MateriaPanel.getMateriaTable().getSelectedRow())).getCargaHoraria()));

            }
        });
        EditarMateriaPanel.getVoltarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(MATERIAPAINEL);
            }
        });
        EditarMateriaPanel.getEditarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                materiaList.set(MateriaPanel.getMateriaTable().getSelectedRow(),
                        new Materia(EditarMateriaPanel.getNomeTextField().getText(),
                                EditarMateriaPanel.getCodigoTextField().getText(),
                                Integer.parseInt(EditarMateriaPanel.getCargaTextField().getText())));
                buildMateria();
                changeScreen(MATERIAPAINEL);

            }
        });
//        Alunos

        botaoListaAlunos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(ALUNOPAINEL);


            }
        });

        TelaTodosAlunos.getVoltarButtonAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PAINELINICIAL);
            }
        });

        TelaTodosAlunos.getAdicionarAlunoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(ADDALUNOPAINEL);

                telaAdicionaAluno.getTextFieldCpfAluno().setText("");
                telaAdicionaAluno.getTextFieldMatriculaAluno().setText("");
                telaAdicionaAluno.getTextFieldNomeAluno().setText("");
                telaAdicionaAluno.getTextFieldMatriculaAluno().setText("");
            }
        });



        telaAdicionaAluno.getButtonAdicionarAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                materiaList.add(new Materia(AdicionarMateriaPanel.getNomeTextField().getText(),
                        AdicionarMateriaPanel.getCodigoTextField().getText(),
                        Integer.parseInt(AdicionarMateriaPanel.getCargaTextField().getText())));
                buildMateria();
                changeScreen(MATERIAPAINEL);
            }
        });


    }
    public void buildMateria(){
        String col[] = {"Nome", "Código", "Carga Horária"};
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome", "Codigo", "Carga horaria"}, 0);
        for(Materia m: materiaList){
            Object[] objs = {m.getNome(),m.getCodigo(),m.getCargaHoraria()};
            model.addRow(objs);
        }
        MateriaPanel.getMateriaTable().setModel(model);
    }


    public static void build(){
        JFrame frame = new JFrame("Sistema Escola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(740, 350));
        Main gui = new Main();
        gui.addComponentToPane(frame.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void changeScreen(String panel){
        CardLayout c1 = (CardLayout) (cards.getLayout());
        c1.show(cards,panel);
    }
    public void addComponentToPane(Container pane) {

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(painelInicial, PAINELINICIAL);
        cards.add(MateriaPanel.getMainPanel(), MATERIAPAINEL);
        cards.add(AdicionarMateriaPanel.getMainPanel(), ADDMATERIAPAINEL);
        cards.add(EditarMateriaPanel.getMainPanel(), EDITMATERIAPAINEL);
        cards.add(TelaTodosAlunos.getAlunoPainel(), ALUNOPAINEL);
        cards.add(telaAdicionaAluno.getAddAlunoPainel(), ADDALUNOPAINEL);
        pane.add(cards, BorderLayout.CENTER);
    }
    public static void main(String[] args){
        materiaList.add(new Materia("Nome", "02", 04));
        materiaList.add(new Materia("Nome2", "03", 04));

        build();
    }



}
