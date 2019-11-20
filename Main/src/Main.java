import form.AdicionarMateriaScreen;
import form.EditarMateriaScreen;
import form.materiaMainScreen;
import sun.awt.geom.AreaOp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketPermission;
import java.util.ArrayList;
import java.util.List;

public class Main{

    JFrame frame = new JFrame("Sistema Escola");
    private static List<Materia> materiaList = new ArrayList<>();
    private static List<Aluno> AlunoList = new ArrayList<>();
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
    final static String ALUNOINDIVIDUALPAINEL = "Painel Um Aluno";
    JPanel cards;
    materiaMainScreen MateriaPanel = new materiaMainScreen();
    AdicionarMateriaScreen AdicionarMateriaPanel = new AdicionarMateriaScreen();
    EditarMateriaScreen EditarMateriaPanel = new EditarMateriaScreen();
    telaTodosAlunos TelaTodosAlunos = new telaTodosAlunos();
    telaAdicionaAluno telaAdicionaAluno = new telaAdicionaAluno();
    telaEditaAluno TelaEditaAluno = new telaEditaAluno();
    telaUmAluno TelaUmAluno = new telaUmAluno();
    Materia empty = new Materia("Empty", "", 1); ///!!!!

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
                buildAluno();
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
                telaAdicionaAluno.getDiaAluno().setSelectedIndex(0);
                telaAdicionaAluno.getMesAluno().setSelectedIndex(0);
                telaAdicionaAluno.getAnoAluno().setSelectedIndex(0);
            }
        });

        telaAdicionaAluno.getVoltarAddAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(ALUNOPAINEL);
            }
        });

        TelaEditaAluno.getVoltarEditarAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(ALUNOPAINEL);
            }
        });

        telaAdicionaAluno.getButtonAdicionarAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Materia> materias = new ArrayList<>();
                if(!telaAdicionaAluno.getTextFieldNomeAluno().getText().equals("") &&
                !telaAdicionaAluno.getTextFieldCpfAluno().getText().equals("") &&
                !telaAdicionaAluno.getTextFieldMatriculaAluno().getText().equals("")){
                    AlunoList.add(new Aluno(telaAdicionaAluno.getTextFieldNomeAluno().getText(),
                            telaAdicionaAluno.getTextFieldCpfAluno().getText(),
                            telaAdicionaAluno.getTextFieldMatriculaAluno().getText(),
                            telaAdicionaAluno.getDiaAluno().getSelectedItem().toString() + "/" +
                            telaAdicionaAluno.getMesAluno().getSelectedItem().toString() +"/"+
                            telaAdicionaAluno.getAnoAluno().getSelectedItem().toString(), materias));

                    buildAluno();
                    changeScreen(ALUNOPAINEL);
                }
            }
        });

        TelaTodosAlunos.getDeletarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlunoList.remove(TelaTodosAlunos.getAlunoTable1().getSelectedRow());
                buildAluno();
            }
        });

        TelaEditaAluno.getAddMateriaAlunoEdita().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Aluno a = (Aluno) AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow());

                   List<Materia> materiasAluno = new ArrayList<>();

                    for (int i = 0; i < materiaList.size(); i++) {
                        materiasAluno.add(materiaList.get(i));
                    }

                    for (int i = 0; i < a.getListaMateria().size(); i++) {
                        materiasAluno.remove(a.getListaMateria().get(i));
                    }

                   Materia m = (Materia) JOptionPane.showInputDialog(frame,
                           "Adicione as matérias",
                           "Adicionar Matéria",
                           JOptionPane.QUESTION_MESSAGE,
                           null, materiasAluno.toArray(),null);
                   if(m != null){
                       a.addMateria(m);
                       TelaEditaAluno.getAlunoEditaMateriasCB().addItem(m.toString());
                   }
                }
        });


        TelaEditaAluno.getRemoverMateriaAlunoEdita().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno a = (Aluno) AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow());
                if(TelaEditaAluno.getAlunoEditaMateriasCB().getItemAt(0) != ""){
                    Materia m = a.getListaMateria().get(TelaEditaAluno.getAlunoEditaMateriasCB().getSelectedIndex());
                    a.removeMateria(m);
                    TelaEditaAluno.getAlunoEditaMateriasCB().removeItem(m.toString());
                }
            }
        });

        TelaTodosAlunos.getVisualizarAlunoButton().addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                Aluno a = (Aluno) AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow());
                changeScreen(ALUNOINDIVIDUALPAINEL);
                TelaUmAluno.getAlunoIndividualMateriasCB().removeAllItems();
                TelaUmAluno.getAlunoIndividualNome().setText(AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow()).getNome());
                TelaUmAluno.getAlunoINdividualCpf().setText(AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow()).getCPF());
                TelaUmAluno.getAlunoIndividualMatricula().setText(AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow()).getMatricula());
                TelaUmAluno.getAlunoIndividualData().setText(AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow()).getDataNascimento());
                TelaUmAluno.getAlunoHoras().setText(AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow()).calculaTotalHoras());

                for(int i = 0; i < a.getListaMateria().size(); i++){
                    TelaUmAluno.getAlunoIndividualMateriasCB().addItem(a.getListaMateria().get(i).toString());
                }
            }
        });

        TelaTodosAlunos.getEditarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno a = (Aluno) AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow());
                changeScreen(EDITALUNOPAINEL);
                TelaEditaAluno.getAlunoEditaMateriasCB().removeAllItems();
                TelaEditaAluno.getTextFieldCpfAlunoedita().setText(AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow()).getCPF());
                TelaEditaAluno.getTextFieldMatriculaAlunoedita().setText(AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow()).getMatricula());
                TelaEditaAluno.getTextFieldNomeAlunoedita().setText(AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow()).getNome());

                String dataNascimento = AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow()).getDataNascimento();
                String[] data = dataNascimento.split("/");
                String dia = data[0];
                String mes = data[1];
                String ano = data[2];

                TelaEditaAluno.getDiaAlunoedita().setSelectedItem(Integer.parseInt(dia));
                TelaEditaAluno.getMesAlunoedita().setSelectedItem(Integer.parseInt(mes));
                TelaEditaAluno.getAnoAlunoedita().setSelectedItem(Integer.parseInt(ano));

                for(int i = 0; i < a.getListaMateria().size(); i++){
                    TelaEditaAluno.getAlunoEditaMateriasCB().addItem(a.getListaMateria().get(i).toString());
                }

            }
        });

        TelaEditaAluno.getButtonSalvarAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno a = (Aluno) AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow());
                List<Materia> materias = new ArrayList<>();

                for (int i = 0; i < a.getListaMateria().size(); i++) {
                    materias.add(a.getListaMateria().get(i));
                }

                AlunoList.set(TelaTodosAlunos.getAlunoTable1().getSelectedRow(),
                        new Aluno(TelaEditaAluno.getTextFieldNomeAlunoedita().getText(),
                        TelaEditaAluno.getTextFieldCpfAlunoedita().getText(),
                        TelaEditaAluno.getTextFieldMatriculaAlunoedita().getText(),
                        TelaEditaAluno.getDiaAlunoedita().getSelectedItem().toString() + "/" +
                                TelaEditaAluno.getMesAlunoedita().getSelectedItem().toString() +"/"+
                                TelaEditaAluno.getAnoAlunoedita().getSelectedItem().toString(),
                                materias
                        ));
                buildAluno();
               // AlunoList.get(TelaEditaAluno.getAlunoEditaMateriasCB().getSelectedIndex()).setListaMateria(materias);
                changeScreen(ALUNOPAINEL);
            }

        });

        TelaUmAluno.getVoltarIndividualAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(ALUNOPAINEL);
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

    public void buildAluno(){
        String col[] = {"Nome", "CPF", "Matricula", "Data de Nascimento"};
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome", "CPF", "Matricula", "Data de Nascimento"}, 0);
        for(Aluno p: AlunoList){
            Object[] objs = {p.getNome(), p.getCPF(), p.getMatricula(), p.getDataNascimento(), p.getListaMateria()};
            model.addRow(objs);
        }
        TelaTodosAlunos.getAlunoTable1().setModel(model);
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
        gui.buidDate();
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
        cards.add(TelaEditaAluno.getPainelEditaAluno(), EDITALUNOPAINEL);
        cards.add(TelaUmAluno.getPainelAlunoIndividual(), ALUNOINDIVIDUALPAINEL);
        pane.add(cards, BorderLayout.CENTER);
    }
    public static void main(String[] args){
        materiaList.add(new Materia("Nome", "02", 04));
        materiaList.add(new Materia("Nome2", "03", 04));
       // AlunoList.add(new Aluno("Pedro", "085", "2012AB", "10/06/2004"));
        build();
    }

    public void buidDate(){

        for (int i = 2019; i >= 1900; i--) {
            telaAdicionaAluno.getAnoAluno().addItem(i);
            TelaEditaAluno.getAnoAlunoedita().addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            telaAdicionaAluno.getMesAluno().addItem(i);
            TelaEditaAluno.getMesAlunoedita().addItem(i);
        }
        for (int i = 1; i <= 31; i++) {
            telaAdicionaAluno.getDiaAluno().addItem(i);
            TelaEditaAluno.getDiaAlunoedita().addItem(i);
        }
    }


}

