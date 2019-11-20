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
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{

    JFrame frame = new JFrame("Sistema Escola");
    private static List<Materia> materiaList = new ArrayList<>();
    private static List<Aluno> AlunoList = new ArrayList<>();
    private static List<Professor> ProfessorList = new ArrayList<>();
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
    final static String PROFESSORPAINEL = "Painel Professor";
    final static String ADDPROFESSORPAINEL = "Painel Adicionar Professor";
    final static String EDITAPROFESSORPAINEL = "Painel Editar Professor";
    final static String PROFESSORINDIVIDUALPAINEL = "Painel Um Professor";

    JPanel cards;
    materiaMainScreen MateriaPanel = new materiaMainScreen();
    AdicionarMateriaScreen AdicionarMateriaPanel = new AdicionarMateriaScreen();
    EditarMateriaScreen EditarMateriaPanel = new EditarMateriaScreen();
    telaTodosAlunos TelaTodosAlunos = new telaTodosAlunos();
    telaAdicionaAluno telaAdicionaAluno = new telaAdicionaAluno();
    telaEditaAluno TelaEditaAluno = new telaEditaAluno();
    telaUmAluno TelaUmAluno = new telaUmAluno();
    telaTodosProfessores TelaTodosProfessores = new telaTodosProfessores();
    telaAdicionaProfessor telaAdicionaProfessor = new telaAdicionaProfessor();
    telaEditaProfessor TelaEditaProfessor = new telaEditaProfessor();
    telaUmProf TelaUmProf = new telaUmProf();


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
                     Aluno a = new Aluno(telaAdicionaAluno.getTextFieldNomeAluno().getText(),
                             telaAdicionaAluno.getTextFieldCpfAluno().getText(),
                             telaAdicionaAluno.getTextFieldMatriculaAluno().getText(),
                             telaAdicionaAluno.getDiaAluno().getSelectedItem().toString() + "/" +
                                     telaAdicionaAluno.getMesAluno().getSelectedItem().toString() +"/"+
                                     telaAdicionaAluno.getAnoAluno().getSelectedItem().toString(), materias);
                     Pattern pattern = Pattern.compile("[0-9]");
                     Pattern letras = Pattern.compile(("[a-z]"));
                     Matcher nome = pattern.matcher(a.getNome());
                     Matcher cpf = pattern.matcher(a.getCPF());
                     Matcher cpfLetras = letras.matcher(a.getCPF());

                    if( ( !nome.find() && a.getNome().length() > 3)){
                        if( cpf.find() && a.getCPF().length() == 11 && !cpfLetras.find() ){
                            AlunoList.add(new Aluno(telaAdicionaAluno.getTextFieldNomeAluno().getText(),
                                    telaAdicionaAluno.getTextFieldCpfAluno().getText(),
                                    telaAdicionaAluno.getTextFieldMatriculaAluno().getText(),
                                    telaAdicionaAluno.getDiaAluno().getSelectedItem().toString() + "/" +
                                            telaAdicionaAluno.getMesAluno().getSelectedItem().toString() +"/"+
                                            telaAdicionaAluno.getAnoAluno().getSelectedItem().toString(), materias));
                            buildAluno();
                            changeScreen(ALUNOPAINEL);
                        }else { JOptionPane.showMessageDialog(null, "Insira um CPF Valido! "); }
                    }else { JOptionPane.showMessageDialog(null, "Insira um nome Valido! ");}
                }else{ JOptionPane.showMessageDialog(null, "Preencha todos os campos! "); }
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
                Aluno b = (Aluno) AlunoList.get(TelaTodosAlunos.getAlunoTable1().getSelectedRow());
                List<Materia> materias = new ArrayList<>();

                for (int i = 0; i < b.getListaMateria().size(); i++) {
                    materias.add(b.getListaMateria().get(i));
                }
                Aluno a = new Aluno(TelaEditaAluno.getTextFieldNomeAlunoedita().getText(),
                        TelaEditaAluno.getTextFieldCpfAlunoedita().getText(),
                        TelaEditaAluno.getTextFieldMatriculaAlunoedita().getText(),
                        TelaEditaAluno.getDiaAlunoedita().getSelectedItem().toString() + "/" +
                                TelaEditaAluno.getMesAlunoedita().getSelectedItem().toString() +"/"+
                                TelaEditaAluno.getAnoAlunoedita().getSelectedItem().toString(),
                        materias);

                if(!(a.getNome().isEmpty() || a.getCPF().isEmpty() || a.getMatricula().isEmpty())) {
                    Pattern pattern = Pattern.compile("[0-9]");
                    Pattern letras = Pattern.compile(("[a-z]"));
                    Matcher nome = pattern.matcher(a.getNome());
                    Matcher cpf = pattern.matcher(a.getCPF());
                    Matcher cpfLetras = letras.matcher(a.getCPF());

                    if( ( !nome.find() && a.getNome().length() > 3)){
                        if(cpf.find()&&a.getCPF().length()==11&&!cpfLetras.find()){
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
                            changeScreen(ALUNOPAINEL);
                        }else { JOptionPane.showMessageDialog(null, "Insira um CPF Valido! "); }
                    }else { JOptionPane.showMessageDialog(null, "Insira um nome Valido! ");}
                }else{ JOptionPane.showMessageDialog(null, "Preencha todos os campos! "); }
            }
        });

        TelaUmAluno.getVoltarIndividualAluno().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(ALUNOPAINEL);
            }
        });

        //Professor

        botaoListaProfessores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PROFESSORPAINEL);
                buildAluno();
            }
        });

        TelaTodosProfessores.getVoltarButtonProf().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PAINELINICIAL);
            }
        });

        TelaTodosProfessores.getAdicionarProfessorButton().addActionListener(new ActionListener() {
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

        telaAdicionaProfessor.getVoltarAddProfessor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PROFESSORPAINEL);
            }
        });

        TelaEditaProfessor.getVoltarEditarProfessor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PROFESSORPAINEL);
            }
        });

       telaAdicionaProfessor.getButtonAdicionarProfessor().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               List<Materia> materias = new ArrayList<>();
               if(!telaAdicionaProfessor.getTextFieldNomeProfessor().getText().equals("") &&
                       !telaAdicionaProfessor.getTextFieldCpfProfessor().getText().equals("") &&
                       !telaAdicionaProfessor.getTextFieldDepartamentoProfessor().getText().equals("")){

                           Professor p = new Professor(telaAdicionaProfessor.getTextFieldNomeProfessor().getText(),
                                   telaAdicionaProfessor.getTextFieldCpfProfessor().getText(),
                                   telaAdicionaProfessor.getTextFieldDepartamentoProfessor().getText(),
                                   telaAdicionaProfessor.getDiaProfessor().getSelectedItem().toString() + "/" +
                                   telaAdicionaProfessor.getMesProfessor().getSelectedItem().toString() + "/" +
                                   telaAdicionaProfessor.getAnoProfessor().getSelectedItem().toString(), materias);
                                       Pattern pattern = Pattern.compile("[0-9]");
                                       Pattern letras = Pattern.compile(("[a-z]"));
                                       Matcher nome = pattern.matcher(p.getNome());
                                       Matcher cpf = pattern.matcher(p.getCPF());
                                       Matcher cpfLetras = letras.matcher(p.getCPF());

                   if( ( !nome.find() && p.getNome().length() > 3)){
                       if( cpf.find() && p.getCPF().length() == 11 && !cpfLetras.find() ){

                           ProfessorList.add(new Professor(telaAdicionaProfessor.getTextFieldNomeProfessor().getText(),
                                   telaAdicionaProfessor.getTextFieldCpfProfessor().getText(),
                                   telaAdicionaProfessor.getTextFieldDepartamentoProfessor().getText(),
                                   telaAdicionaProfessor.getDiaProfessor().getSelectedItem().toString() + "/" +
                                           telaAdicionaProfessor.getMesProfessor().getSelectedItem().toString() + "/" +
                                           telaAdicionaProfessor.getAnoProfessor().getSelectedItem().toString(), materias));
                           buildProfessor();
                           changeScreen(PROFESSORPAINEL);
                           }else { JOptionPane.showMessageDialog(null, "Insira um CPF Valido! "); }
                        }else { JOptionPane.showMessageDialog(null, "Insira um nome Valido! ");}
               }else{ JOptionPane.showMessageDialog(null, "Preencha todos os campos! "); }
           }
       });

        TelaTodosProfessores.getDeletarProfButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProfessorList.remove(TelaTodosProfessores.getProfTable1().getSelectedRow());
                buildProfessor();
            }
        });

        TelaEditaProfessor.getAddMateriaProfEdita().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Professor p = (Professor) ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow());
                List<Materia> materias = new ArrayList<>();

                for (int i = 0; i < materiaList.size(); i++) {
                    materias.add(materiaList.get(i));
                }

                for (int i = 0; i < p.getListaMateria().size(); i++) {
                    materias.remove(p.getListaMateria().get(i));
                }

                Materia m = (Materia) JOptionPane.showInputDialog(frame,
                        "Adicione as matérias",
                        "Adicionar Matéria",
                        JOptionPane.QUESTION_MESSAGE,
                        null, materias.toArray(),null);
                if(m != null){
                    p.addMateria(m);
                    TelaEditaProfessor.getProfEditaMateriasCB().addItem(m.toString());
                }
            }
        });

        TelaEditaProfessor.getRemoverMateriaProfEdita().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Professor p = (Professor) ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow());
                if (TelaEditaProfessor.getProfEditaMateriasCB().getItemAt(0) != "") {
                    Materia m = p.getListaMateria().get(TelaEditaProfessor.getProfEditaMateriasCB().getSelectedIndex());
                    p.removeMateria(m);
                    TelaEditaProfessor.getProfEditaMateriasCB().removeItem(m.toString());
                }
            }
        });

        TelaTodosProfessores.getVisualizarProfButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Professor p = (Professor) ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow());
                changeScreen(PROFESSORINDIVIDUALPAINEL);
                TelaUmProf.getProfIndividualMateriasCB().removeAllItems();
                TelaUmProf.getProfIndividualNome().setText(ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow()).getNome());
                TelaUmProf.getProfINdividualCpf().setText(ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow()).getCPF());
                TelaUmProf.getProfIndividualDepartamento().setText(ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow()).getDepartamento());
                TelaUmProf.getProfIndividualData().setText(ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow()).getDataNascimento());
                TelaUmProf.getProfHoras().setText(ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow()).calculaTotalHoras());

                for(int i = 0; i < p.getListaMateria().size(); i++){
                    TelaUmProf.getProfIndividualMateriasCB().addItem(p.getListaMateria().get(i).toString());
                }
            }
        });

        TelaTodosProfessores.getEditarProfButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Professor p = (Professor) ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow());
                changeScreen(EDITAPROFESSORPAINEL);
                TelaEditaProfessor.getProfEditaMateriasCB().removeAllItems();
                TelaEditaProfessor.getTextFieldCpfProfedita().setText(ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow()).getCPF());
                TelaEditaProfessor.getTextFieldNomeProfessoredita().setText(ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow()).getNome());
                TelaEditaProfessor.getTextFieldDeptProfedita().setText(ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow()).getDepartamento());

                String dataNascimento = ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow()).getDataNascimento();

                String[] data = dataNascimento.split("/");
                String dia = data[0];
                String mes = data[1];
                String ano = data[2];

                TelaEditaProfessor.getDiaProfedita().setSelectedItem(Integer.parseInt(dia));
                TelaEditaProfessor.getMesProfedita().setSelectedItem(Integer.parseInt(mes));
                TelaEditaProfessor.getAnoProfedita().setSelectedItem(Integer.parseInt(ano));

                for(int i = 0; i < p.getListaMateria().size(); i++){
                    TelaEditaProfessor.getProfEditaMateriasCB().addItem(p.getListaMateria().get(i).toString());
                }
            }
        });

        TelaUmProf.getVoltarIndividualProfessor().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeScreen(PROFESSORPAINEL);
            }
        });

        TelaEditaProfessor.getButtonSalvaProf().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Professor b = (Professor) ProfessorList.get(TelaTodosProfessores.getProfTable1().getSelectedRow());
                List<Materia> materias = new ArrayList<>();

                for (int i = 0; i < b.getListaMateria().size(); i++) {
                materias.add(b.getListaMateria().get(i));
                }


                Professor p = new Professor( TelaEditaProfessor.getTextFieldNomeProfessoredita().getText(),
                        TelaEditaProfessor.getTextFieldCpfProfedita().getText(),
                        TelaEditaProfessor.getTextFieldDeptProfedita().getText(),
                        TelaEditaProfessor.getDiaProfedita().getSelectedItem().toString() + "/" +
                                TelaEditaProfessor.getMesProfedita().getSelectedItem().toString() + "/" +
                                TelaEditaProfessor.getAnoProfedita().getSelectedItem().toString(), materias);

                if(!(p.getNome().isEmpty() || p.getCPF().isEmpty() || p.getDepartamento().isEmpty())) {
                    Pattern pattern = Pattern.compile("[0-9]");
                    Pattern letras = Pattern.compile(("[a-z]"));
                    Matcher nome = pattern.matcher(p.getNome());
                    Matcher cpf = pattern.matcher(p.getCPF());
                    Matcher cpfLetras = letras.matcher(p.getCPF());

                   if( ( !nome.find() && p.getNome().length() > 3)){
                        if(cpf.find()&&p.getCPF().length()==11&&!cpfLetras.find()){
                            ProfessorList.set(TelaTodosProfessores.getProfTable1().getSelectedRow(),
                                    new Professor( TelaEditaProfessor.getTextFieldNomeProfessoredita().getText(),
                                            TelaEditaProfessor.getTextFieldCpfProfedita().getText(),
                                            TelaEditaProfessor.getTextFieldDeptProfedita().getText(),
                                            TelaEditaProfessor.getDiaProfedita().getSelectedItem().toString() + "/" +
                                                    TelaEditaProfessor.getMesProfedita().getSelectedItem().toString() + "/" +
                                                    TelaEditaProfessor.getAnoProfedita().getSelectedItem().toString(), materias));
                                                        buildProfessor();
                                                        changeScreen(PROFESSORPAINEL);
                            }else { JOptionPane.showMessageDialog(null, "Insira um CPF Valido! "); }
                       }else { JOptionPane.showMessageDialog(null, "Insira um nome Valido! ");}
               }else{ JOptionPane.showMessageDialog(null, "Preencha todos os campos! "); }
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

    public void buildProfessor(){
        String col[] = {"Nome", "CPF", "Departamento", "Data de Nascimento"};
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Nome", "CPF", "Departamento", "Data de Nascimento"}, 0);
        for(Professor p: ProfessorList){
            Object[] objs = {p.getNome(), p.getCPF(), p.getDepartamento(), p.getDataNascimento(), p.getListaMateria()};
            model.addRow(objs);
        }
        TelaTodosProfessores.getProfTable1().setModel(model);
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
        cards.add(TelaTodosProfessores.getTodosProfessores(), PROFESSORPAINEL);
        cards.add(telaAdicionaProfessor.getPainelProfessor(), ADDPROFESSORPAINEL);
        cards.add(TelaEditaProfessor.getJprofessorEdita(), EDITAPROFESSORPAINEL);
        cards.add(TelaUmProf.getUmProf(), PROFESSORINDIVIDUALPAINEL);
        pane.add(cards, BorderLayout.CENTER);
    }
    public static void main(String[] args){
        List<Materia> lista = new ArrayList<>();
        materiaList.add(new Materia("Nome", "02", 04));
        materiaList.add(new Materia("Nome2", "03", 04));
        AlunoList.add(new Aluno("Pedro", "08556780716", "2012AB", "10/06/2004", lista));
        build();
    }

    public void buidDate(){

        for (int i = 2019; i >= 1900; i--) {
            telaAdicionaAluno.getAnoAluno().addItem(i);
            TelaEditaAluno.getAnoAlunoedita().addItem(i);
            TelaEditaProfessor.getAnoProfedita().addItem(i);
            telaAdicionaProfessor.getAnoProfessor().addItem(i);
        }
        for (int i = 1; i <= 12; i++) {
            telaAdicionaAluno.getMesAluno().addItem(i);
            TelaEditaAluno.getMesAlunoedita().addItem(i);
            TelaEditaProfessor.getMesProfedita().addItem(i);
            telaAdicionaProfessor.getMesProfessor().addItem(i);
        }
        for (int i = 1; i <= 31; i++) {
            telaAdicionaAluno.getDiaAluno().addItem(i);
            TelaEditaAluno.getDiaAlunoedita().addItem(i);
            TelaEditaProfessor.getDiaProfedita().addItem(i);
            telaAdicionaProfessor.getDiaProfessor().addItem(i);
        }
    }


}

