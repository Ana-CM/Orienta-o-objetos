import javax.swing.*;
import java.awt.*;

public class Main {

    JFrame frame = new JFrame("Sistema Escola");
    private JPanel painelInicial;
    private JButton botaoListaAlunos;
    private JButton botaoListaProfessores;
    private JButton botaoListaMaterias;
    final static String PAINELINICIAL = "Painel Inicial";
    JPanel cards;



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
    public void addComponentToPane(Container pane) {

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(painelInicial, PAINELINICIAL);

        pane.add(painelInicial, BorderLayout.CENTER);
    }
    public static void main(String[] args){
    build();
    }
}
