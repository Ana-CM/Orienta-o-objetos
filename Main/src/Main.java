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
    private static List<Professor> ProfessorList = new ArrayList<>();
    private JPanel painelInicial;
    private JButton botaoListaAlunos;
    private JButton botaoListaProfessores;
    private JButton botaoListaMaterias;
    final static String PAINELINICIAL = "Painel Inicial";
    final static String MATERIAPAINEL = "Painel Materia";
    final static String ADDMATERIAPAINEL = "Painel Adicionar Materia";
    final static String EDITMATERIAPAINEL = "Painel Editar Materia";
    //Strings Professor
    final static String PROFESSORPAINEL = "Painel Professor";
    final static String ADDPROFESSORPAINEL = "Painel Adicionar Professor";
    final static String EDITPROFESSORPAINEL = "Painel Editar Professor";
    final static String PROFESSORINDIVIDUALPAINEL = "Painel Um Professor";
    //Fim Strings Professor
    JPanel cards;
    materiaMainScreen MateriaPanel = new materiaMainScreen();
    AdicionarMateriaScreen AdicionarMateriaPanel = new AdicionarMateriaScreen();
    EditarMateriaScreen EditarMateriaPanel = new EditarMateriaScreen();
    //Professor Cards
    telaTodosProfs telaTodosProfs = new telaTodosProfs();
    telaAdicionaProfessor telaAdicionaProfessor = new telaAdicionaProfessor();
    telaEditaProfessor telaEditaProfessor = new telaEditaProfessor();
    telaUmProf telaUmProf = new telaUmProf();
    //Fim Professor Cadrs
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
//       Professores

        botaoListaProfessores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PROFESSORPAINEL);
                buildProfessor();
            }
        });

        telaTodosProfs.getVoltarButtonProf().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PAINELINICIAL);
            }
        });

        telaTodosProfs.getAdicionarProfessorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(ADDPROFESSORPAINEL);

                telaAdicionaProfessor.getTextFieldCpfProfessor().setText("");
                telaAdicionaProfessor.getTextFieldDepartamentoProfessor().setText("");
                telaAdicionaProfessor.getTextFieldNomeProfessor().setText("");
                telaAdicionaProfessor.getDiaProfessor().setSelectedIndex(0);
                telaAdicionaProfessor.getMesProfessor().setSelectedIndex(0);
                telaAdicionaProfessor.getAnoProfessor().setSelectedIndex(0);
            }
        });

        telaAdicionaProfessor.getVoltarAddAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PROFESSORPAINEL);
            }
        });

        telaEditaProfessor.getVoltarEditarProfessor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PROFESSORPAINEL);
            }
        });

        telaAdicionaProfessor.getButtonAdicionarProfessor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!telaAdicionaProfessor.getTextFieldNomeProfessor().getText().equals("") &&
                !telaAdicionaProfessor.getTextFieldCpfProfessor().getText().equals("") &&
                !telaAdicionaProfessor.getTextFieldDepartamentoProfessor().getText().equals("")){
                    ProfessorList.add(new Professor(telaAdicionaProfessor.getTextFieldNomeProfessor().getText(),
                            telaAdicionaProfessor.getTextFieldCpfProfessor().getText(),
                            telaAdicionaProfessor.getTextFieldDepartamentoProfessor().getText(),
                            telaAdicionaProfessor.getDiaProfessor().getSelectedItem().toString() + "/" +
                            telaAdicionaProfessor.getMesProfessor().getSelectedItem().toString() +"/"+
                            telaAdicionaProfessor.getAnoProfessor().getSelectedItem().toString()));

                    buildProfessor();
                    changeScreen(PROFESSORPAINEL);
                }
            }
        });

        telaTodosProfs.getDeletarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfessorList.remove(telaTodosProfs.getProfTable1().getSelectedRow());
                buildProfessor();
            }
        });

        telaEditaProfessor.getAddMateriaProfEdita().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Professor a = (Professor) ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow());

                   List<Materia> materiasProfessor = new ArrayList<>();

                    for (int i = 0; i < materiaList.size(); i++) {
                        materiasProfessor.add(materiaList.get(i));
                    }

                    for (int i = 0; i < a.getListaMateria().size(); i++) {
                        materiasProfessor.remove(a.getListaMateria().get(i));
                    }

                   Materia m = (Materia) JOptionPane.showInputDialog(frame,
                           "Adicione as matérias",
                           "Adicionar Matéria",
                           JOptionPane.QUESTION_MESSAGE,
                           null, materiasProfessor.toArray(),null);
                   if(m != null){
                       a.addMateria(m);
                       telaEditaProfessor.getProfessorEditaMateriasCB().addItem(m.toString());
                   }
                }
        });



        telaTodosProfs.getVisualizarProfButton().addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                Professor a = (Professor) ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow());
                changeScreen(PROFESSORINDIVIDUALPAINEL);
                telaUmProf.getProfessorIndividualMateriasCB().removeAllItems();
                telaUmProf.getProfessorIndividualNome().setText(ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow()).getNome());
                telaUmProf.getProfessorIndividualCpf().setText(ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow()).getCPF());
                telaUmProf.getProfessorIndividualDepartamento().setText(ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow()).getMatricula());
                telaUmProf.getProfessorIndividualData().setText(ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow()).getDataNascimento());

                for(int i = 0; i < a.getListaMateria().size(); i++){
                    telaUmProf.getProfessorIndividualMateriasCB().addItem(a.getListaMateria().get(i).toString());
                }
            }
        });

        telaTodosProfs.getEditarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(EDITPROFESSORPAINEL);
                Professor a = (Professor) ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow());
                telaEditaProfessor.getProfessorEditaMateriasCB().removeAllItems();
                telaEditaProfessor.getTextFieldCpfProfedita().setText(ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow()).getCPF());
                telaEditaProfessor.getTextFieldDepartamentoProfedita().setText(ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow()).getMatricula());
                telaEditaProfessor.getTextFieldNomeProfedita().setText(ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow()).getNome());

                String dataNascimento = ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow()).getDataNascimento();
                String[] data = dataNascimento.split("/");
                String dia = data[0];
                String mes = data[1];
                String ano = data[2];

                telaEditaProfessor.getDiaProfedita().setSelectedItem(Integer.parseInt(dia));
                telaEditaProfessor.getMesProfedita().setSelectedItem(Integer.parseInt(mes));
                telaEditaProfessor.getAnoProfedita().setSelectedItem(Integer.parseInt(ano));

                for(int i = 0; i < a.getListaMateria().size(); i++){
                    telaEditaProfessor.getProfessorEditaMateriasCB().addItem(a.getListaMateria().get(i).toString());
                }

            }
        });

        telaEditaProfessor.getButtonSalvarProfessor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Professor a = (Professor) ProfessorList.get(telaTodosProfs.getProfTable1().getSelectedRow());
                List<Materia> materias = new ArrayList<>();

                for (int i = 0; i < a.getListaMateria().size(); i++) {
                    materias.add(a.getListaMateria().get(i));
                }

                ProfessorList.set(telaTodosProfs.getProfTable1().getSelectedRow(),
                        new Professor(telaEditaProfessor.getTextFieldNomeProfedita().getText(),
                        telaEditaProfessor.getTextFieldCpfProfedita().getText(),
                        telaEditaProfessor.getTextFieldDepartamentoProfedita().getText(),
                        telaEditaProfessor.getDiaProfedita().getSelectedItem().toString() + "/" +
                                telaEditaProfessor.getMesProfedita().getSelectedItem().toString() +"/"+
                                telaEditaProfessor.getAnoProfedita().getSelectedItem().toString()
                        ));

                buildProfessor();
                changeScreen(PROFESSORPAINEL);
            }
        });



        telaUmProf.getVoltarIndividualProf().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PROFESSORPAINEL);
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

    public void buildProfessor(){
        String col[] = {"Nome", "CPF", "Departamento", "Data de Nascimento"};
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome", "CPF", "Departamento", "Data de Nascimento"}, 0);
        for(Professor p: ProfessorList){
            Object[] objs = {p.getNome(), p.getCPF(), p.getDepartamento(), p.getDataNascimento()};
            model.addRow(objs);
        }
        telaTodosProfs.getProfTable1().setModel(model);
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
        //Professor Cards
        cards.add(telaTodosProfs.getProfessorPainel(), PROFESSORPAINEL);
        cards.add(telaAdicionaProfessor.getAddProfessorPainel(), ADDPROFESSORPAINEL);
        cards.add(telaEditaProfessor.getPainelEditaProfessor(), EDITPROFESSORPAINEL);
        cards.add(telaUmProf.getPainelProfIndividual(), PROFESSORINDIVIDUALPAINEL);
        pane.add(cards, BorderLayout.CENTER);
        //Fim Professor Cards
    }
    public static void main(String[] args){
        materiaList.add(new Materia("Nome", "02", 04));
        materiaList.add(new Materia("Nome2", "03", 04));
        ProfessorList.add(new Aluno("Pedro", "085", "2012AB", "10/06/2004"));
        build();
    }


    //Professor Date
    public void buidDate(){

        for (int i = 2019; i >= 1900; i--) {
            telaAdicionaProfessor.getAnoProfessor().addItem(i);
            telaEditaProfessor.getAnoProfedita().addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            telaAdicionaProfessor.getMesProfessor().addItem(i);
            telaEditaProfessor.getMesProfedita().addItem(i);
        }
        for (int i = 1; i <= 31; i++) {
            telaAdicionaProfessor.getDiaProfessor().addItem(i);
            telaEditaProfessor.getDiaProfedita().addItem(i);
        }
    }


}

