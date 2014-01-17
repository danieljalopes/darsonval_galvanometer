package isep.fsiap.galvanometro.gui;

import isep.fsiap.galvanometro.exceptions.GalvaOverFlowException;
import isep.fsiap.galvanometro.exceptions.MenorQueZeroException;
import isep.fsiap.galvanometro.exceptions.MenorQueUmException;
import isep.fsiap.galvanometro.file_io.SaveBinFile;
import isep.fsiap.galvanometro.business.BusinessModel;
import isep.fsiap.galvanometro.file_io.Export;
import isep.fsiap.galvanometro.file_io.LoadBinFile;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * * @author Daniel Lopes
 */
public class GuiMain extends JFrame {

    /**
     * objecto correspondente ao modelo de negócio
     */
    static BusinessModel bm;
    /**
     * Frame que contem tudo
     */
    private JFrame frameIni;
    /**
     * painel de tabs
     */
    private JTabbedPane tabPane;
    /**
     * painel de suporte a tabPane (tab1)
     */
    private JPanel tab1_panel;
    /**
     * painel com bacground a representar o circuito equivalente
     */
    private JBackgroundPanel tabPane2_painel;
    /**
     * painel esquerod de tabmPane (tabm1)
     */
    private JPanel tabPane1_panelEsq;
    /**
     * layout para sobmreposição de paineis
     */
    private OverlayLayout tab1_panelEsq_overlt;
    /**
     * painel de suporte á imgem do circuito do galvanometro
     */
    private JPanel circuito_panel;
    /**
     * labmel que contem a imagem do circuito do galvanometro
     */
    private JLabel circuito_lbl;
    /**
     * painel invisivel que irá suportar a agulha e possivelmente outros itens
     */
    private ExtJpanel circuito_over;
    /**
     * segundo tabPane alberga circuito equivalente
     */
    private JPanel tab2_panel;
    /**
     * label de R_p no tab2
     */
    private JLabel rp2_lbl;
    /**
     * textfield de rp em tab2
     */
    private JTextField rp2_txt;
    /**
     * label de Rs em tab2
     */
    private JLabel rs2_lbl;
    /**
     * textfield de rs em tab2
     */
    private JTextField rs2_txt;
    /**
     * label de rg em tab2
     */
    private JLabel rg2_lbl;
    /**
     * txtFiled rg2_txt
     */
    private JTextField rg2_txt;
//******************************************************
// componentes manipulação da fonte de alimentação
//******************************************************
    /**
     * label da textfield da fonte
     */
    private JLabel fonte_lbl;
    /**
     * textField da fonte
     */
    private JTextField fonte_txtField;
    /**
     * label de B em tab1
     */
    private JLabel b_lbl;
    /**
     * textFiled de B em Tab1
     */
    private JTextField b_txt;
    /**
     * label da constante elástica
     */
    private JLabel k_lbl;
    /**
     * textfield da constante elástica
     */
    private JTextField k_txt;
    /**
     * lbl num espiras bobine
     */
    private JLabel espiras_lbl;
    /**
     * txtfield num espiras bobine
     */
    private JTextField espiras_txt;
    /**
     * label area secção circular da bobine
     */
    private JLabel areaBobine_lbl;
    /**
     * txtfield area secção circular da bobine
     */
    private JTextField areaBobine_txt;
    /**
     * lbl tensão da fonte em tab2
     */
    private JLabel tensao2_lbl;
    /**
     * lbl tensão da fonte em tab2
     */
    private JTextField tensao2_txt;
    /**
     * painel de componentes de rp
     */
    private JPanel rp_pnl;
    /**
     * label de rp
     */
    private JLabel rp_lbl;
    /**
     * textfield de R_p
     */
    private JTextField rp_txtField;
    /*
     ****************************************
     componentes de escala
     ****************************************
     */
    /**
     * painel de componentes de escala
     */
    private JPanel escala_pnl;
    /**
     * label escala
     */
    private JLabel escala_lbl;
    /**
     *
     * escala por defeito do galvanometro
     */
    String[] escala = {"10E-6", "10E-3", "1E-3", "1E-2", "1E-1", "1", "5"};
    private ArrayList<String> escala_arraL;
    /**
     *
     * combmobmox de selecção da escala
     */
    private JComboBox escala_cmbBox;
    /**
     * botão para executar a medição
     */
    private JButton executar_btn;

    /*
     ***************************************
     barra menus
     ***************************************
     */
    /**
     * cria barra de menu
     */
    private JMenuBar menuBar;
    /**
     * cria menu ficheiro
     */
    private JMenu file_menu;
    /**
     * cria Ficheiro/Guardar
     */
    private JMenuItem file_item1;
    /**
     * cria Ficheiro/Carregar
     */
    private JMenuItem file_item2;
    /**
     * cria Ficheiro/Exportar
     */
    private JMenuItem file_item3;
    /**
     * cria menu lingua
     */
    private JMenu lingua_menu;
    /**
     * radiobuton para lingua PT
     */
    private JRadioButtonMenuItem linguaPT_item;
    /**
     * radiobuton para lingua ENG
     */
    private JRadioButtonMenuItem linguaENG_item;
    /**
     * inset para posionamento fixo de varios componentes
     */

    private ButtonGroup linguaGroup;
    private Insets inset;
    /**
     * dimensão para dimensionar componentes que vão sofrer posionamento fixo
     */
    private Dimension dim;
    private String foradeEscalaMSG;

    /*------------------------------------------
     labels para detalhes dos elementos em circuito euivqlente
     --------------------------------------------*/
    /**
     * detalhe de Rg
     */
    private JLabel detalheRg;
    /**
     * detalhe de fonte
     */
    private JLabel detalheFonte;
    /**
     * detalhe de Rs
     */
    private JLabel detalheRs;
    /**
     * detalhe de rp
     */
    private JLabel detalheRp;

    /*---------------------------------
     TAB3
     ---------------------------------*/
    /**
     * painel que cria o tab3
     */
    private JPanel tab3_panel;

    /**
     * cria frame com texto descritivo da imagem em tab3
     */
    private JButton explain_btn;
    /**
     * painel de suporte aos compomnentes em tab3
     */
    private JBackgroundPanel tab3_pane;
    /**
     * label que armazena a imagem em tab3
     */
    private JLabel b_tab3_lbl;
    /**
     * label de tab3 da bobine
     */
    private JLabel bobine_tab3_lbl;
    /**
     * label de tab3 do electrão
     */
    private JLabel electrao_tab3_lbl;
    /**
     * botão default
     */
    private JButton default_btn;

    /*----------------------------
     Menssagens de erro
     --------------------------------*/
    /**
     * excepção para inputs com tipo de dados errado
     */
    private String error_message_wrongFormatNumber = "Valor com Formato errado";
    
    /**
     * excepção para inputs de valores negativos
     */
    private String error_message_positiveNumberOnly = "Sómente valores positivos";
    /**
     * excepção para inputs que não ppermitam valores menores ou iguais a zero
     */
    private String error_mesage_geatherThanZeroOnly = "Sómente valores maiores que zero";
    
    /**
     * quando o angulo da agulha excede o valor estipulado
     */
    private String error_message_outOfScale = "Fora de escala";

//    /*---------------------------------
//     * tab4 
//     --------------------------------*/
//    /**
//     * painel que constroi o tab4
//     */
//    private JPanel tab4_pane;
//    /**
//     * texto em tab4
//     */
//    private JTextArea tab4_txtArea;
    /*-----------------------------------
     Explain window
     -----------------------------------*/
    /**
     * janela onde é mostrada a explicação
     */
    private JFrame explainWindow_frm;

    /**
     * onde é renderizada a explicação
     */
    private JTextArea explain_txtArea;
    //*********************************
    //METODOS
    //**********************************
    /**
     * inicia o programa
     *
     * @param args
     */
    public static void main(String[] args) {
        bm = new BusinessModel();
        GuiMain gui = new GuiMain();
        gui.setGuiDefaults(bm);

    }

    /**
     * establece os valores por omissão
     * @param b 
     */
    public void setGuiDefaults(BusinessModel b) {
        fonte_txtField.setText(Double.toString(b.FONTE_ALIMENTACAO_DEFAULT));
        rp_txtField.setText(Double.toString(b.RESISTENCIA_PROVA_DEFAULT));// em tab1
        rp2_txt.setText(Double.toString(b.RESISTENCIA_PROVA_DEFAULT));//em tab2
        rs2_txt.setText(Double.toString(b.RESISTENCIA_S_DEFAULT));
        b_txt.setText(Double.toString(b.CAMPOMAGNETICO_DEFAULT));
        k_txt.setText(Double.toString(b.CONSTANTE_ELASTICA_ANGULAR_DEFAULT));
        espiras_txt.setText(Integer.toString(b.NUM_ESPIRAS_DEFAULT));
        areaBobine_txt.setText(Double.toString(b.AREA_ESPIRAS_DEFAULT));
        rg2_txt.setText(Double.toString(b.RESISTENCIA_G_DEFAULT));
        tensao2_txt.setText(Double.toString(b.FONTE_ALIMENTACAO_DEFAULT));
        repaint();
        // b.mudarEscala(1);//para obter r_s
    }

    /**
     * actualiza a gui
     * @param b
     * @param g 
     */
    public void updateGui(BusinessModel b, GuiMain g) {
        g.fonte_txtField.setText(Double.toString(b.getTensao()));
        g.rp_txtField.setText(Double.toString(b.getR_p()));// em tab1
        g.rp2_txt.setText(Double.toString(b.getR_p()));//em tab2
        g.rs2_txt.setText(Double.toString(b.getR_s()));
        g.b_txt.setText(Double.toString(b.getB()));
        g.k_txt.setText(Double.toString(b.getK()));
        g.espiras_txt.setText(Integer.toString(b.getNumEspiras()));
        g.areaBobine_txt.setText(Double.toString(b.getArea()));
        g.rg2_txt.setText(Double.toString(b.getR_g()));
        g.tensao2_txt.setText(Double.toString(b.getTensao()));
    }

    /**
     * construtor do interface gráfico
     */
    public GuiMain() {
        initGui();
    }

    /**
     * construtor do interface gráfico
     */
    public GuiMain(BusinessModel bm) {

        initGui();
    }

    /**
     * inicializa e constroi o interface gráfico, fornece serviço ao construtor
     * GuiMain()
     */
    private void initGui() {

        //inicialização dos componentes swing
//        
        frameIni = new JFrame("FSIAP Galvanómetro");//frame

        tabPane = new JTabbedPane();//tabpane

        buildMenuBar();
        buildTab1();
        buildTab2();
        buildTab3();
        outros();

        tabPane.addTab("Simulação de Galvanómetro", tab1_panel);//titulo do tab1 e painel
        tabPane.addTab("Circuito Equivalente", tab2_panel);//titulo do tab1 e painel
        tabPane.addTab("Interacção Campos", tab3_panel);
//        tabPane.addTab("Descrição", tab4_pane);
        tabPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                rp2_txt.setText(doubleToCientificNotation(bm.getR_p()));
                rs2_txt.setText(doubleToCientificNotation(bm.getR_s()));
                rg2_txt.setText(doubleToCientificNotation(bm.getR_g()));
                tensao2_txt.setText(doubleToCientificNotation(bm.getTensao()));
                if (bm.getTensao() > 0) {
                    tab3_pane.setBackground("/isep/fsiap/galvanometro/images/tab3_pos.png");
                } else if (bm.getTensao() < 0) {
                    tab3_pane.setBackground("/isep/fsiap/galvanometro/images/tab3_neg.png");
                } else if (bm.getTensao() == 0) {
                    tab3_pane.setBackground("/isep/fsiap/galvanometro/images/tab3_o.png");
                }
                detalheRp.setToolTipText(detalheDispositivos("rp"));
                detalheRs.setToolTipText(detalheDispositivos("rs"));
                detalheRg.setToolTipText(detalheDispositivos("rg"));
                detalheFonte.setToolTipText(detalheDispositivos("fonte"));

            }
        });

        //adicionar elementos á frame.
        frameIni.add(tabPane);

        //procedimentos finais obrigatórios
        frameIni.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        frameIni.setCursor(
                new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        frameIni.setVisible(
                true);

        frameIni.setPreferredSize(new java.awt.Dimension(555, 615));
        frameIni.setMaximumSize(new java.awt.Dimension(555, 615));
        frameIni.setMinimumSize(new java.awt.Dimension(555, 615));
//        frameIni.setResizable(false);
        frameIni.pack();//para abrir a janela
//         System.out.printf("%d x %d", frameIni.getWidth(), frameIni.getHeight());
//         System.out.printf("%d x %d", tabPane1_panelEsq.getWidth(), tabPane1_panelEsq.getHeight());
    }

    /**
     * Caixa de selecção de ficheiro
     * @return 
     */
    private File selectFile() {
        File f; //objecto que referencia o ficheiro a usar

        //instancia Jfilechooser
        JFileChooser fileChooser = new JFileChooser();
        //ver ficheiros e pastas
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this); //resultado do botão

        if (result == JFileChooser.CANCEL_OPTION) {
            return null;
        }

        f = fileChooser.getSelectedFile(); // get File
        // display error if invalid
        if ((f == null) || (f.getName().equals(""))) {
            JOptionPane.showMessageDialog(this, "Invalid Name",
                    "Invalid Name", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } // end if

        return f;
    } // end method getFile

    /**
     * gera código html
     * @return 
     */
    public StringBuilder buildHtml() {

        StringBuilder s = new StringBuilder();
        s.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"");
        s.append("\n");
        s.append("      \"http://www.w3.org/TR/html4/loose.dtd\">");
        s.append("<html>\n"
                + "<head>\n"
                + "  <meta http-equiv=\"content-type\" content=\"text/html; charset=iso-8859-15\">\n"
                + "  <title>New1</title>\n"
                + "  <meta name=\"generator\" content=\"Amaya, see http://www.w3.org/Amaya/\">\n"
                + "</head>");
        s.append("<body>\n");
        s.append("<table border=\"1\" style=\"width: 100%\">\n").append("  <caption></caption>\n").append(
                "  <col>\n").append("  <col>\n").append("  <col>\n").append("  <col>\n").append("  <col>\n");
        s.append("<tbody>\n").append("    <tr>");

        s.append("      <td>").append(uToHTML(this.areaBobine_lbl.getText())).append("</td>\n");
        s.append("      <td>").append(this.b_lbl.getText()).append("</td>\n");
        s.append("      <td>").append(this.escala_lbl.getText()).append("</td>\n");
        s.append("      <td>").append(this.espiras_lbl.getText()).append("</td>\n");
        s.append("      <td>").append(this.fonte_lbl.getText()).append("</td>\n");
        s.append("      <td>").append(this.k_lbl.getText()).append("</td>\n");
        s.append("      <td>").append(this.rg2_lbl.getText()).append("</td>\n");
        s.append("      <td>").append(this.rp_lbl.getText()).append("</td>\n");
        s.append("      <td>").append(this.rs2_lbl.getText()).append("</td>\n");

        s.append("    </tr>\n");
        s.append("    <tr>\n");

        s.append("      <td>").append(this.areaBobine_txt.getText()).append("</td>\n");
        s.append("      <td>").append(this.b_txt.getText()).append("</td>\n");
        s.append("      <td>").append(this.escala_cmbBox.getSelectedItem().toString()).append("</td>\n");
        s.append("      <td>").append(this.espiras_txt.getText()).append("</td>\n");
        s.append("      <td>").append(this.fonte_txtField.getText()).append("</td>\n");
        s.append("      <td>").append(this.k_txt.getText()).append("</td>\n");
        s.append("      <td>").append(this.rg2_txt.getText()).append("</td>\n");
        s.append("      <td>").append(this.rp_txtField.getText()).append("</td>\n");
        s.append("      <td>").append(this.rs2_txt.getText()).append("</td>\n");

        s.append("</tr>\n").append("  </tbody>\n").append("</table>\n");
        s.append("<p></p>");
        s.append("<table border=\"1\" style=\"width: 100%\">\n").append("  <caption></caption>\n").append(
                "  <col>\n").append("  <col>\n").append("  <col>\n").append("  <col>\n").append("  <col>\n");
        s.append("<tbody>\n").append("    <tr>");
        s.append("      <td>").append("Ig (A)").append("</td>\n");
        s.append("      <td>").append("Ug (V)").append("</td>\n");
        s.append("      <td>").append("Pg (W)").append("</td>\n");
        s.append("    </tr>\n");
        s.append("    <tr>\n");
        s.append("      <td>").append(String.valueOf((bm.getTensao() - (bm.getTensao() / ((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s()) + bm.getR_p())) * bm.getR_p()))).append("</td>\n");
        s.append("      <td>").append(String.valueOf(bm.getTensao() - (bm.getTensao() / (((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())) + bm.getR_p())) * bm.getR_p())).append("</td>\n");
        s.append("      <td>").append(String.valueOf(Math.abs(((bm.getTensao() - (bm.getTensao() / (((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())) + bm.getR_p())) * bm.getR_p()) * ((bm.getTensao() - (bm.getTensao() / (((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())) + bm.getR_p())) * bm.getR_p()) * bm.getR_g()))))).append("</td>\n");
        s.append("</tr>\n").append("  </tbody>\n").append("</table>\n");
        s.append("<p></p>\n");
        s.append("<p></p>");
        s.append("<table border=\"1\" style=\"width: 100%\">\n").append("  <caption></caption>\n").append(
                "  <col>\n").append("  <col>\n").append("  <col>\n").append("  <col>\n").append("  <col>\n");
        s.append("<tbody>\n").append("    <tr>");
        s.append("      <td>").append("Is (A)").append("</td>\n");
        s.append("      <td>").append("Us (V)").append("</td>\n");
        s.append("      <td>").append("Ps (W)").append("</td>\n");
        s.append("    </tr>\n");
        s.append("    <tr>\n");
        s.append("      <td>").append(String.valueOf((bm.getTensao() - (bm.getTensao() / (((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())) + bm.getR_p())) * bm.getR_p()) * bm.getR_s())).append("</td>\n");
        s.append("      <td>").append(String.valueOf(bm.getTensao() - (bm.getTensao() / (((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())) + bm.getR_p())) * bm.getR_p())).append("</td>\n");
        s.append("      <td>").append(String.valueOf(Math.abs((bm.getTensao() - (bm.getTensao() / ((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s()) + bm.getR_p())) * bm.getR_p()) * ((bm.getTensao() - (bm.getTensao() / ((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s()) + bm.getR_p())) * bm.getR_p()) * bm.getR_g())))).append("</td>\n");
        s.append("</tr>\n").append("  </tbody>\n").append("</table>\n");

        s.append("<p></p>\n");
        s.append("<p></p>");
        s.append("<table border=\"1\" style=\"width: 100%\">\n").append("  <caption></caption>\n").append(
                "  <col>\n").append("  <col>\n").append("  <col>\n").append("  <col>\n").append("  <col>\n");
        s.append("<tbody>\n").append("    <tr>");
        s.append("      <td>").append("Ip (A)").append("</td>\n");
        s.append("      <td>").append("Up (V)").append("</td>\n");
        s.append("      <td>").append("Pp (W)").append("</td>\n");
        s.append("    </tr>\n");
        s.append("    <tr>\n");
        s.append("      <td>").append(String.valueOf(bm.getTensao() / (((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())) + bm.getR_p()))).append("</td>\n");
        s.append("      <td>").append(String.valueOf(bm.getTensao() - (bm.getTensao() / (((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())) + bm.getR_p())) * ((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())))).append("</td>\n");
        s.append("      <td>").append(String.valueOf(Math.abs((bm.getTensao() - bm.getTensao() / (((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())) + bm.getR_p()) * ((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s()))) * (bm.getTensao() / (((bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s())) + bm.getR_p()))))).append("</td>\n");
        s.append("</tr>\n").append("  </tbody>\n").append("</table>\n");

        s.append("</html>");
        return s;
    }

    /**
     * @return the foradeEscalaMSG
     */
    public String getForadeEscalaMSG() {
        return foradeEscalaMSG;
    }

    /**
     * @param foradeEscalaMSG the foradeEscalaMSG to set
     */
    public void setForadeEscalaMSG(String foradeEscalaMSG) {
        this.foradeEscalaMSG = foradeEscalaMSG;
    }

/**
 * actualização da gui de acordo com a lingua escolhida
 */
    private class LinguaListener implements ActionListener {

        private String lingua;

        public LinguaListener(String lingua) {
            this.lingua = lingua;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (lingua) {
                case "pt":
                    file_menu.setText("Ficheiro");
                    file_item1.setText("Guardar");
                    file_item2.setText("Carregar");
                    file_item3.setText("Exportar");
                    lingua_menu.setText("Lingua");
                    fonte_lbl.setText("Fonte (V)");
                    tensao2_lbl.setText("Fonte (V)");
                    escala_lbl.setText("Escala (A)");
                    areaBobine_lbl.setText("Área Espira (m²)");
                    espiras_lbl.setText("Nº. Espiras");
                    tabPane.removeAll();
                    tabPane.add("Simulação Galvanometro", tab1_panel);
                    tabPane.add("Circuito Equivalente", tab2_panel);
                    tabPane.add("Interacção de Campos", tab3_panel);
                    explain_btn.setText("Explicar");
                    setForadeEscalaMSG("Fora de Escala");
                    executar_btn.setText("Executar");
                    default_btn.setText("Omissão");
                    b_tab3_lbl.setText("Vector Campo Magnético do Iman");
                    bobine_tab3_lbl.setText("Vector Campo Magnetico do Solenoide");
                    electrao_tab3_lbl.setText("Movimento do electrão");
                    error_message_wrongFormatNumber = "Valor com Formato errado";
                    error_message_positiveNumberOnly = "Sómente valores positivos";
                    error_mesage_geatherThanZeroOnly = "Sómente valores maiores que zero";
                     error_message_outOfScale = "Fora de Escala";
                    break;
                case "eng":
                    file_menu.setText("File");
                    file_item1.setText("Save");
                    file_item2.setText("Load");
                    file_item3.setText("Export");
                    lingua_menu.setText("Language");
                    fonte_lbl.setText("Power (V)");
                    tensao2_lbl.setText("Power (V)");
                    escala_lbl.setText("Scale (A)");
                    areaBobine_lbl.setText("Loop Area (m²)");
                    espiras_lbl.setText("Loop qtd");
                    tabPane.removeAll();
                    tabPane.add("Galvanometer Simulation", tab1_panel);
                    tabPane.add("Equivalent Circuit", tab2_panel);
                    tabPane.add("Field Interaction", tab3_panel);
                    explain_btn.setText("Explain");
                    setForadeEscalaMSG("Out of Range");
                    executar_btn.setText("Execute");
                    default_btn.setText("Default");
                    b_tab3_lbl.setText("Magnet's Magnetic Field Vector");
                    bobine_tab3_lbl.setText("Solenoid's Magnetic Field Vector");
                    electrao_tab3_lbl.setText("Electron's Movement");
                    error_message_wrongFormatNumber = "Wrong Format Value";
                    error_message_positiveNumberOnly = "Positive values only";
                    error_mesage_geatherThanZeroOnly = "Grather than zero values only";
                    error_message_outOfScale = "Out of Scale";
                    break;
            }
        }
    }

    /**
     * constroi o tab1
     */
    public void buildTab1() {

        tab1_panel = new JPanel(); //gera a tab1 para a simulação
        tabPane1_panelEsq = new JPanel(); //painel esquerdo do tab1
        tabPane1_panelEsq.setMaximumSize(new Dimension(498, 530));
        circuito_panel = new JPanel();//painel que alberga imagem do circuito
        circuito_lbl = new JLabel(); // label com a imagem do circuito

        //  circuito_over = new ExtJpanel("./agulha.png"); //painel que alberga agulha e outros componentes
        circuito_over = new ExtJpanel(); //painel que alberga agulha e outros componentes

        //circuito_over.setBackground(Color.red);//para teste
        tab1_panelEsq_overlt = new OverlayLayout(tabPane1_panelEsq);

        fonte_lbl = new JLabel(); //label da fonte
        fonte_txtField = new JTextField();//valores da fonte

        rp_pnl = new JPanel();
        rp_lbl = new JLabel();//label da textfield de valores de rp
        rp_txtField = new JTextField(); //valores de rp

        escala_pnl = new JPanel();
        escala_lbl = new JLabel(); //label da escala
        escala_arraL = new ArrayList();
        // preencher arraylist
        for (int i = 0; i < bm.getI_fe().length; i++) {
            if (bm.getI_fe()[i] % (int) bm.getI_fe()[i] == 0) {
                escala_arraL.add(String.valueOf((int) bm.getI_fe()[i]));
            } else {
                escala_arraL.add(String.valueOf(doubleToCientificNotation(bm.getI_fe()[i])));
            }
        }
//        for(double d : bm.getI_fe()){
//            System.out.println(d);
//            escala_arraL.add(doubleToCientificNotation(d));
//        }

        escala_cmbBox = new JComboBox(escala_arraL.toArray()); //combobox com os elementos da escala
//        escala_cmbBox = new JComboBox(escala); //combobox com os elementos da escala

        b_lbl = new JLabel();//label de b em tab1
        b_txt = new JTextField();//txt de B em tab1

        k_lbl = new JLabel();//lbl const. elaśt.
        k_txt = new JTextField(); //txtfild const. elast.

        espiras_lbl = new JLabel();
        espiras_txt = new JTextField();

        areaBobine_lbl = new JLabel();
        areaBobine_txt = new JTextField();

        executar_btn = new JButton();//butão para executar nova simulação
        default_btn = new JButton();
        tab1_panel.setLayout(new BoxLayout(tab1_panel, BoxLayout.X_AXIS));
        //----------------painel esquerdo de painel 1 ----------------------
        tabPane1_panelEsq.setLayout(new OverlayLayout(tabPane1_panelEsq)); //painel esquerdo com cardlayout
        circuito_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/isep/fsiap/galvanometro/images/circuito_main_escala.png")));
        circuito_panel.add(circuito_lbl); //adiciona imagem do circuito ao painel que alberga a imagem

        //>>>>>>>>>>>>>>>>Posicionamento absoluto de itens em painel circuito_over
        circuito_over.setLayout(null);
        inset = circuito_over.getInsets();

        /*--------------------------------------------------
         Componentes da Fonte
         //--------------------------------------------------*/
        //label da fonte
        fonte_lbl.setText("Fonte (V)");
        dim = fonte_lbl.getPreferredSize();
        fonte_lbl.setBounds(inset.left + 85, inset.top + 300, dim.width + 10, dim.height);
        circuito_over.add(fonte_lbl);

        //caixa texto da fonte 
        fonte_txtField.setHorizontalAlignment(JTextField.CENTER);
        dim = fonte_txtField.getPreferredSize();
        fonte_txtField.setBounds(inset.left + 86, inset.top + 320, dim.width + 53, dim.height);
        circuito_over.add(fonte_txtField);

        /*--------------------------------------------------
         Componentes da Resistencia r_p
         ----------------------------------------------------*/
        //label da resistencia r_p
        rp_lbl = new JLabel("R_p (ohm)");
        dim = rp_lbl.getPreferredSize();
        rp_lbl.setBounds(inset.left + 171, inset.top + 410, dim.width, dim.height);
        circuito_over.add(rp_lbl);

        //caixa de texto da resistencia r_p
        rp_txtField.setHorizontalAlignment(JTextField.CENTER);
        dim = rp_txtField.getPreferredSize();
        rp_txtField.setBounds(inset.left + 177, inset.top + 440, dim.width + 53, dim.height);
        circuito_over.add(rp_txtField);

        //label de B em tab1
        b_lbl = new JLabel("B (T)");
        dim = b_lbl.getPreferredSize();
        b_lbl.setBounds(inset.left + 163, inset.top + 117, dim.width, dim.height);
        circuito_over.add(b_lbl);

        //txt de B em tab1
        b_txt.setHorizontalAlignment(JTextField.LEFT);
        dim = b_txt.getPreferredSize();
        b_txt.setBounds(inset.left + 163, inset.top + 135, dim.width + 53, dim.height);
        circuito_over.add(b_txt);

        /*--------------------------------------------------
         Componentes de selecção de escala
         ----------------------------------------------------*/
        //label da combobox escala
        escala_lbl.setText("Escala (A)");
        dim = escala_lbl.getPreferredSize();
        escala_lbl.setBounds(inset.left + 30, inset.top + 30, dim.width, dim.height);
        circuito_over.add(escala_lbl);

        //combobox da escala
        escala_cmbBox.setSelectedIndex(5);
        escala_cmbBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JComboBox jc = (JComboBox) e.getSource();
                Double escala = Double.parseDouble(jc.getSelectedItem().toString());
                bm.mudarEscala(escala);
                bm.movement();

            }
        });
        dim = escala_cmbBox.getPreferredSize();
        escala_cmbBox.setBounds(inset.left + 30, inset.top + 48, dim.width, dim.height);
        circuito_over.add(escala_cmbBox);

        /*-----------------------------------------------
         const. elástica
         -----------------------------------------------*/
        k_lbl.setText("K (N/rad)");
        dim = k_lbl.getPreferredSize();
        k_lbl.setBounds(inset.left + 402, inset.top + 117, dim.width, dim.height);
        circuito_over.add(k_lbl);

        k_txt.setHorizontalAlignment(JTextField.CENTER);
        dim = k_txt.getPreferredSize();
        k_txt.setBounds(inset.left + 390, inset.top + 135, dim.width + 70, dim.height);
        circuito_over.add(k_txt);

        /*-----------------------------------------------
         num espiras
         -----------------------------------------------*/
        espiras_lbl.setText("Num. Espiras");
        dim = espiras_lbl.getPreferredSize();
        espiras_lbl.setBounds(inset.left + 385, inset.top + 197, dim.width, dim.height);
        circuito_over.add(espiras_lbl);

        espiras_txt.setHorizontalAlignment(JTextField.RIGHT);
        dim = espiras_txt.getPreferredSize();
        espiras_txt.setBounds(inset.left + 408, inset.top + 215, dim.width + 53, dim.height);
        circuito_over.add(espiras_txt);

        /*-----------------------------------------------
         area secção circular
         -----------------------------------------------*/
        areaBobine_lbl.setText("Área Espira (m^2)");
        dim = areaBobine_lbl.getPreferredSize();
        areaBobine_lbl.setBounds(inset.left + 140, inset.top + 197, dim.width, dim.height);
        circuito_over.add(areaBobine_lbl);

        areaBobine_txt.setHorizontalAlignment(JTextField.LEFT);
        dim = areaBobine_txt.getPreferredSize();
        areaBobine_txt.setBounds(inset.left + 163, inset.top + 215, dim.width + 53, dim.height);
        circuito_over.add(areaBobine_txt);

        circuito_over.add(areaBobine_txt);

        /*--------------------------------------------------
         Componentes da escala - agulha
         ----------------------------------------------------*/
        /*--------------------------------------------------
         Componente botão executar
         ----------------------------------------------------*/
        executar_btn.setText("Executar");
        dim = executar_btn.getPreferredSize();
        executar_btn.setBounds(inset.left + 376, inset.top + 400, dim.width, dim.height);
        executar_btn.setActionCommand("btn tab1");
        executar_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double temp_d = 0.0;
                int temp_i = 0;
                Double escala = 0.0;
                Double ang = 0.0;

                try {
                    temp_d = Double.parseDouble(escala_cmbBox.getSelectedItem().toString());
                    if (temp_d < 0) {
                        throw new MenorQueZeroException();
                    } else {
                        escala = temp_d;
                    }

                    temp_d = Double.parseDouble(areaBobine_txt.getText());
                    if (temp_d <= 0) {
                        throw new MenorQueUmException();
                    } else {
                        bm.setArea(temp_d);//area
                    }

                    bm.setTensao(Double.parseDouble(fonte_txtField.getText()));//area

                    temp_d = Double.parseDouble(b_txt.getText());
                    if (temp_d <= 0) {
                        throw new MenorQueZeroException();
                    } else {
                        bm.setB(temp_d); //b
                    }

                    temp_d = Double.parseDouble(k_txt.getText());
                    if (temp_d < 0) {
                        throw new MenorQueZeroException();
                    } else {
                        bm.setK(temp_d);//k
                    }

                    temp_i = Integer.parseInt(espiras_txt.getText());
                    if (temp_i < 0) {
                        throw new MenorQueZeroException();
                    } else {
                        bm.setNumEspiras(temp_i);
                    }

                    temp_d = Double.parseDouble(rp_txtField.getText());
                    if (temp_d < 0) {
                        throw new MenorQueZeroException();
                    } else {
                        bm.setR_p(temp_d); //r_p
                    }

                    ang = bm.movement();
                    bm.mudarEscala(escala);
                } catch (NumberFormatException ne) {
                    JOptionPane.showMessageDialog(null, error_message_wrongFormatNumber, "", JOptionPane.ERROR_MESSAGE);

                } catch (MenorQueZeroException mz) {
                    JOptionPane.showMessageDialog(null, error_message_positiveNumberOnly, "", JOptionPane.ERROR_MESSAGE);

                } catch (MenorQueUmException mu) {

                    JOptionPane.showMessageDialog(null, error_mesage_geatherThanZeroOnly, "", JOptionPane.ERROR_MESSAGE);
                }

                try {
                    if (ang > Math.PI / 4 || ang < -Math.PI / 4) {
                        throw new GalvaOverFlowException(getForadeEscalaMSG());
                    } else {

                        circuito_over.inclinarAgulha(ang);
                    }//end if
                } catch (GalvaOverFlowException ge) {
                    JOptionPane.showMessageDialog(null, error_message_outOfScale, "", JOptionPane.OK_OPTION);
                }//end try

            }//end actionPerformed
        });
        circuito_over.add(executar_btn);

        default_btn.setText("Omissão");
        dim = default_btn.getPreferredSize();
        default_btn.setBounds(inset.left + 376, inset.top + 450, dim.width, dim.height);
        default_btn.setActionCommand("btn2 tab1");

        default_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setGuiDefaults(bm);

            }//end actionPerformed
        });
        circuito_over.add(default_btn);
        /*--------------------------------------------------
         Parametros de dimensionamento e outros do painel
         circuito_over
         ----------------------------------------------------*/
        circuito_over.setPreferredSize(
                new Dimension(488, 520));
        circuito_over.setMaximumSize(
                new Dimension(488, 520));
        circuito_over.setMinimumSize(
                new Dimension(488, 520));
        circuito_over.setOpaque(
                false);
        //FIM >>>>>>>>>>>>>>>>Posicionamento absoluto de itens em painel circuito_over
        tabPane1_panelEsq.add(circuito_over); //adiciona painel de suporte á agulha

        tabPane1_panelEsq.add(circuito_panel); //adiciona painel com o circuito ao painel esquerdo

        tabPane1_panelEsq.setPreferredSize(
                new Dimension(488, 520));
        tabPane1_panelEsq.setMinimumSize(
                new Dimension(488, 520));
        tabPane1_panelEsq.setMaximumSize(
                new Dimension(488, 520));
        // tabPane1_panelEsq.setBorder(new BevelBorder(BevelBorder.RAISED));

        //FIM ------configurar o painel de suporte á agulha e outros in/out---------------
        tab1_panel.add(tabPane1_panelEsq); //adiciona painel esquerdo ao tab1
        //FIM ----------painel esquerdo de painel 1-------------

        // fim --------------------configurar tab1 - Simulação galvanometro---------------------
    }

    /**
     * constroi a tab do circuito equivalente
     */
    public void buildTab2() {

        tab2_panel = new JPanel();
        tabPane2_painel = new JBackgroundPanel("/isep/fsiap/galvanometro/images/circuito_equivalente.png"); //imagem do circuito equivalente
        inset = tabPane2_painel.getInsets();
        rp2_lbl = new JLabel();//r_p em tab2
        rp2_txt = new JTextField();//r_p em tab2

        rs2_lbl = new JLabel();//rg em tab2
        rs2_txt = new JTextField(); //rg em tab2

        tensao2_lbl = new JLabel();
        tensao2_txt = new JTextField();

        rg2_lbl = new JLabel();
        rg2_txt = new JTextField();

        /*-------------------------------------------------------------------------------
         Configuração do tab2 - circuito equivalente
         --------------------------------------------------------------------------------*/
        tab2_panel.setLayout(
                new FlowLayout());
        tab2_panel.add(tabPane2_painel);

        /*------------------------------------------------------
         Posionamento absoluto em tab2 através do painel
         tabPane2_painel
         -------------------------------------------------------*/
        tabPane2_painel.setLayout(
                null);

        //label rp2_lbl em tab2
        rp2_lbl.setText(
                "R_p (ohm)");
        dim = rp2_lbl.getPreferredSize();

        rp2_lbl.setBounds(inset.left
                + 220, inset.top + 380, dim.width, dim.height);
        tabPane2_painel.add(rp2_lbl);

        //caixa de texto de rp em tab2
        rp2_txt.setHorizontalAlignment(JTextField.CENTER);

        rp2_txt.setEditable(
                false);
        dim = rp2_txt.getPreferredSize();

        rp2_txt.setBounds(inset.left
                + 220, inset.top + 400, dim.width + 65 , dim.height);
        tabPane2_painel.add(rp2_txt);

        //detalhe de rp
        detalheRp = new JLabel();
        detalheRp.setToolTipText(detalheDispositivos("rp"));
        dim = detalheRp.getPreferredSize();
        detalheRp.setBounds(inset.left + 202, inset.top + 420, dim.width + 91, dim.height + 60);
        detalheRp.setBackground(Color.PINK);
        detalheRp.setOpaque(false);
        tabPane2_painel.add(detalheRp);

        //label Rs em tab2
        rs2_lbl.setText(
                "R_s (ohm)");
        dim = rs2_lbl.getPreferredSize();

        rs2_lbl.setBounds(inset.left
                + 265, inset.top + 265, dim.width, dim.height);
        tabPane2_painel.add(rs2_lbl);

        //txtfield em Rs em tab2
               rs2_txt.setHorizontalAlignment(JTextField.CENTER);
        dim = rs2_txt.getPreferredSize();
        rs2_txt.setEditable(false);
        rs2_txt.setBounds(inset.left
                + 265, inset.top + 285, dim.width + 65, dim.height);
        tabPane2_painel.add(rs2_txt);

        //detalhe de rs
        detalheRs = new JLabel();
        detalheRs.setToolTipText(detalheDispositivos("rs"));
        dim = detalheRs.getPreferredSize();
        detalheRs.setBounds(inset.left + 254, inset.top + 210, dim.width + 91, dim.height + 60);
        detalheRs.setBackground(Color.GREEN);
        detalheRs.setOpaque(false);
        tabPane2_painel.add(detalheRs);

        /*--------------------------------------------------
         Componentes de rg em tab2
         ----------------------------------------------------*/
        //label Rg em tab2
        rg2_lbl.setText(
                "R_g (ohm)");
        dim = rg2_lbl.getPreferredSize();

        rg2_lbl.setBounds(inset.left
                + 270, inset.top + 60, dim.width, dim.height);
        tabPane2_painel.add(rg2_lbl);

        //txtfield em Rg em tab2
        rg2_txt.setHorizontalAlignment(JTextField.CENTER);
        rg2_txt.setEditable(false);
        dim = rg2_txt.getPreferredSize();

        rg2_txt.setBounds(inset.left
                + 270, inset.top + 80, dim.width + 65, dim.height);
        tabPane2_painel.add(rg2_txt);

        //detalhe de Rg
        detalheRg = new JLabel();
        detalheRg.setToolTipText(detalheDispositivos("rg"));
        dim = detalheRg.getPreferredSize();
        detalheRg.setBounds(inset.left + 254, inset.top + 100, dim.width + 91, dim.height + 60);
        detalheRg.setBackground(Color.CYAN);
        detalheRg.setOpaque(false);
        tabPane2_painel.add(detalheRg);
        /*--------------------------------------------------
         Tensão da fonte em tab2
         ----------------------------------------------------*/
        tensao2_lbl.setText(
                "Fonte (V)");
        dim = tensao2_lbl.getPreferredSize();

        tensao2_lbl.setBounds(inset.left
                + 110, inset.top + 240, dim.width + 10, dim.height);
        tabPane2_painel.add(tensao2_lbl);

        //txtfield de fonte em tab2
        tensao2_txt.setHorizontalAlignment(JTextField.CENTER);

        tensao2_txt.setEditable(
                false);
        dim = tensao2_txt.getPreferredSize();

        tensao2_txt.setBounds(inset.left
                + 110, inset.top + 260, dim.width + 63, dim.height);
        tabPane2_painel.add(tensao2_txt);

        //detalhe de fonte
        detalheFonte = new JLabel();
        detalheFonte.setToolTipText(detalheDispositivos("fonte"));
        dim = detalheFonte.getPreferredSize();
        detalheFonte.setBounds(inset.left + 50, inset.top + 210, dim.width + 60, dim.height + 91);
        detalheFonte.setBackground(Color.BLUE);
        detalheFonte.setOpaque(false);
        tabPane2_painel.add(detalheFonte);

        /*--------------------------------------------------
         Bloquear o tamanho do painel onde acenta o circuito
         ----------------------------------------------------*/
        tabPane2_painel.setPreferredSize(
                new Dimension(488, 520));
        tabPane2_painel.setMinimumSize(
                new Dimension(488, 520));
        tabPane2_painel.setMaximumSize(
                new Dimension(488, 520));
    }

    /**
     * constroi a barra de menus
     */
    public void buildMenuBar() {
        menuBar = new JMenuBar();
        file_menu = new JMenu("Ficheiro");
        file_item1 = new JMenuItem("Guardar");
        file_item1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        File f;
                //o.add((Object) bm);

                        // display file dialog, so user can choose file or directory to open
                        f = selectFile();
                        if (f != null) {
                            SaveBinFile cbf = new SaveBinFile();

                            cbf.openFile(f.toString());
                            cbf.addBusinessModelToFile(bm);
                            //    cbf.addArrayListToFile(o);
                            cbf.closeFile();

                        }
                    }
                });
        file_item2 = new JMenuItem("Carregar");
        file_item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f;

                f = selectFile();//obtem o endereço do ficheiro
                if (f != null) {
                    LoadBinFile lbf = new LoadBinFile();

                    lbf.openFile(f.toString());//abre o ficheiro

                    bm = lbf.loadBusinessModelFromFile();//carrega do ficheiro para o novo objecto
                    lbf.closeFile(); //fecha ficheiro

                    updateGui(bm, GuiMain.this); //actualiza txtfields
                }
            }
        });

        file_item3 = new JMenuItem("Exportar");
        file_item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File f = selectFile();

                if (f != null) {
                    Export exp = new Export();
                    exp.openFile(f);

                    exp.addText(buildHtml());
                    exp.close();
                }

            }
        });
        linguaGroup = new ButtonGroup();
        lingua_menu = new JMenu("Lingua");
        linguaPT_item = new JRadioButtonMenuItem("Pt");
        linguaPT_item.setActionCommand("pt");
        linguaPT_item.addActionListener(new LinguaListener(linguaPT_item.getActionCommand()));
        // linguaPT_item.addItemListener(new LinguaHandler());
        linguaGroup.add(linguaPT_item);
        linguaPT_item.setSelected(true);
        lingua_menu.add(linguaPT_item);

        linguaENG_item = new JRadioButtonMenuItem("Eng");
        linguaENG_item.setActionCommand("eng");
        linguaENG_item.addActionListener(new LinguaListener(linguaENG_item.getActionCommand()));
        // linguaENG_item.addItemListener(new LinguaHandler());
        lingua_menu.add(linguaENG_item);
        linguaGroup.add(linguaENG_item);

        file_menu.add(file_item1);
        file_menu.add(file_item2);
        file_menu.add(new JSeparator(SwingConstants.HORIZONTAL));
        file_menu.add(file_item3);
        menuBar.add(file_menu);
        menuBar.add(lingua_menu);
        menuBar.setVisible(true);
        frameIni.setJMenuBar(menuBar);
    }

    /**
     * incia vários elementos
     */
    public void outros() {
        setForadeEscalaMSG("Fora de Escala");
    }

    /**
     * constroi os popups que aparecem ao passar o rato pelos componentes
     * electricos
     *
     * @param disp
     * @return
     */
    public String detalheDispositivos(String disp) {
        StringBuilder s = new StringBuilder();
        Double i, ig, is, ueq, req, up;
        req = (bm.getR_g() * bm.getR_s()) / (bm.getR_g() + bm.getR_s());//resistencia eq. de Rs//Rg
        i = bm.getTensao() / (req + bm.getR_p()); //corrente total
        ueq = bm.getTensao() - i * bm.getR_p();//tensão eq. de Rs//Rg
        up = bm.getTensao() - i * req;
        ig = ueq * bm.getR_g(); //corrente em Rg
        is = ueq * bm.getR_s(); //corrente em Rs

        switch (disp) {
            case "rg":
                s.append("I = ").append(doubleToCientificNotation(ig)).append(" A; ");
                s.append("U = ").append(doubleToCientificNotation(ueq)).append(" V; ");
                s.append("P = ").append(doubleToCientificNotation(Math.abs(ueq * ig))).append(" W");
                break;
            case "rs":
                s.append("I = ").append(doubleToCientificNotation(is)).append(" A; ");
                s.append("U = ").append(doubleToCientificNotation(ueq)).append(" V; ");
                s.append("P = ").append(doubleToCientificNotation(Math.abs(ueq * is))).append(" W");
                break;
            case "rp":
                s.append("I = ").append(doubleToCientificNotation(i)).append(" A; ");
                s.append("U = ").append(doubleToCientificNotation(up)).append(" V; ");
                s.append("P = ").append(doubleToCientificNotation(Math.abs(up * i))).append(" W");
                break;
            case "fonte":
                s.append("I = ").append(doubleToCientificNotation(i)).append(" A; ");
                s.append("P = ").append(doubleToCientificNotation(bm.getTensao() * i)).append(" W");
                break;
        }

        return s.toString();

    }

    /**
     * constroi o tab3
     */
    public void buildTab3() {
        tab3_panel = new JPanel();
        tab3_pane = new JBackgroundPanel("/isep/fsiap/galvanometro/images/tab3_pos.png");

        tab3_pane.setLayout(null);
        b_tab3_lbl = new JLabel("Vector Campo Magnético do iman");

        dim = b_tab3_lbl.getPreferredSize();

        b_tab3_lbl.setBounds(inset.left
                + 180, inset.top + 453, dim.width, dim.height);
        tab3_pane.add(b_tab3_lbl);

        bobine_tab3_lbl = new JLabel();

        bobine_tab3_lbl.setText("Vector Campo Magnético do solenoide");
        dim = bobine_tab3_lbl.getPreferredSize();

        bobine_tab3_lbl.setBounds(inset.left
                + 180, inset.top + 475, dim.width, dim.height);
        tab3_pane.add(bobine_tab3_lbl);

        electrao_tab3_lbl = new JLabel();
        electrao_tab3_lbl.setText("Movimento do electrão");
        dim = electrao_tab3_lbl.getPreferredSize();

        electrao_tab3_lbl.setBounds(inset.left
                + 180, inset.top + 497, dim.width, dim.height);
        tab3_pane.add(electrao_tab3_lbl);

        //botão desccrição
        explain_btn = new JButton("Explicar");
        explain_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buildExplainWindow();
            }
        });
        dim = explain_btn.getPreferredSize();

        explain_btn.setBounds(inset.left
                + 20, inset.top + 470, dim.width, dim.height);
        tab3_pane.add(explain_btn);

        tab3_pane.setPreferredSize(
                new Dimension(488, 520));
        tab3_pane.setMinimumSize(
                new Dimension(488, 520));
        tab3_pane.setMaximumSize(
                new Dimension(488, 520));

        tab3_panel.add(tab3_pane);
    }

    /**
     * constroi a janela de descrição da imagem em tab3
     */
    public void buildExplainWindow() {
        explainWindow_frm = new JFrame();
        explain_txtArea = new JTextArea();
        JPanel explain_pnl = new JPanel(new GridLayout(1, 1));

        explain_txtArea.setText(explainText(tab3_pane.getBackgroundFileName(), linguaGroup.getSelection().getActionCommand()));
        explain_txtArea.setEditable(false);
        explain_txtArea.setLineWrap(true);
        explain_txtArea.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(explain_txtArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        explain_pnl.setPreferredSize(
                new Dimension(488, 520));
        explain_pnl.setMinimumSize(
                new Dimension(488, 520));
        explain_pnl.setMaximumSize(
                new Dimension(488, 520));
        explain_pnl.add(scroll);

        explainWindow_frm.add(explain_pnl);

        explainWindow_frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        explainWindow_frm.setCursor(
                new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        explainWindow_frm.setVisible(
                true);

        explainWindow_frm.setPreferredSize(
                new Dimension(488, 520));
        explainWindow_frm.setMinimumSize(
                new Dimension(488, 520));
        explainWindow_frm.setMaximumSize(
                new Dimension(488, 520));

        explainWindow_frm.pack();//para abrir a janela

    }

    public String explainText(String imgFile, String lingua) {

        StringBuilder s = new StringBuilder();
        if (imgFile.equalsIgnoreCase("/isep/fsiap/galvanometro/images/tab3_pos.png") && lingua.equalsIgnoreCase("pt")) {
            s.append("Existe corrente eléctrica a percorrer o circuito.\n");
            s.append("Como se pode ver na figura de cima, os electrões percorrem a bobina no sentido descrito pelas setas a negro e de acordo com a regra "
                    + "da mão direita, esse movimento irá originar um campo magnético que cujo vector será perpendicular"
                    + " ao plano da espira e sentido para cima desse mesmo plano.\n\n");
            s.append("As linhas de campo magnetico uniforme irão interagir com o campo magnético da bobina, criando"
                    + "um momento (M1) sobre o pivot da agulha, levando a que a mesma rode para a esquerda, de modo a que o vector do campo"
                    + "magnético da bobine, fique orientado com a mesma direcção e sentido do campo magnético uniforme.\n");
            s.append("Porém existe uma mola helicoidal plana que irá ser deformada pela rotação produzida. Essa deformação na mola,"
                    + "irá criar uma reacção da mola sobre a agulha, criando assim um momento (M2) com a mesma direcção de M1 mas sentido oposto.\n"
                    + "Quando se atingir o ponto de equilibrio ( M1 + M2 = 0 ), pode-se relacionar a inclinação da agulha com a corrente que percorre o "
                    + "circuito da seguinte forma: NIABsen(ang)=k*ang. ");
        } else if (imgFile.equalsIgnoreCase("/isep/fsiap/galvanometro/images/tab3_pos.png") && lingua.equalsIgnoreCase("eng")) {
            s.append("There's an electric current flowing through the circuit."
                    + "As can be seen in the upper figure, the electrons flow through out the solenoid, according the black arrows and by the right hand rule, that movement"
                    + " will originate a magnetic field whose vector will be upright to the plane formed by the loop.\n\n"
                    + "The uniform magnectic line will interact with the solenoid's magnetic field, generating a torque (T1) in needle's pivot"
                    + " forcing the needle to turn left, in order to align the solenoid's magnetic field  with the uniform magnetic field, "
                    + "resulting both having the same orientation.\n"
                    + "However that rotation is producing a deformation in a flat spiral coil. That deformation will create a reaction that will originat in a torque (T2) with oposite direction of T1."
                    + "when the equilibrium is reached ( T1 + T2 = 0 ), it is possible to relate the needle inclination with current intensity that flows through "
                    + " the circuit with the following formula: NIABsen(ang)=k*ang. ");
        } else if (imgFile.equalsIgnoreCase("/isep/fsiap/galvanometro/images/tab3_neg.png") && lingua.equalsIgnoreCase("pt")){
            s.append("Existe corrente eléctrica a percorrer o circuito.\n");
            s.append("Como se pode ver na figura de cima, os electrões percorrem a bobina no sentido descrito pelas setas a negro e de acordo com a regra "
                    + "da mão direita, esse movimento irá originar um campo magnético que cujo vector será perpendicular"
                    + " ao plano da espira e sentido para baixo desse mesmo plano.\n\n");
            s.append("As linhas de campo magnetico uniforme irão interagir com o campo magnético da bobina, criando"
                    + "um momento (M1) sobre o pivot da agulha, levando a que a mesma rode para a direita, de modo a que o vector do campo"
                    + "magnético da bobine, fique orientado com a mesma direcção e sentido do campo magnético uniforme.\n");
            s.append("Porém existe uma mola helicoidal plana que irá ser deformada pela rotação produzida. Essa deformação na mola,"
                    + "irá criar uma reacção da mola sobre a agulha, criando assim um momento (M2) com a mesma direcção de M1 mas sentido oposto.\n"
                    + "Quando se atingir o ponto de equilibrio ( M1 + M2 = 0 ), pode-se relacionar a inclinação da agulha com a corrente que percorre o "
                    + "circuito da seguinte forma: NIABsen(ang)=k*ang. ");
        }else if (imgFile.equalsIgnoreCase("/isep/fsiap/galvanometro/images/tab3_neg.png") && lingua.equalsIgnoreCase("eng")) {
            s.append("There's an electric current flowing through the circuit."
                    + "As can be seen in the upper figure, the electrons flow through out the solenoid, according the black arrows and by the right hand rule, that movement"
                    + " will originate a magnetic field whose vector will be downright to the plane formed by the loop.\n\n"
                    + "The uniform magnectic line will interact with the solenoid's magnetic field, generating a torque (T1) in needle's pivot"
                    + " forcing the needle to turn right, in order to align the solenoid's magnetic field  with the uniform magnetic field, "
                    + "resulting both having the same orientation.\n"
                    + "However that rotation is producing a deformation in a flat spiral coil. That deformation will create a reaction that will originat in a torque (T2) with oposite direction of T1."
                    + "when the equilibrium is reached ( T1 + T2 = 0 ), it is possible to relate the needle inclination with current intensity that flows through "
                    + " the circuit with the following formula: NIABsen(ang)=k*ang. ");
        }else if (imgFile.equalsIgnoreCase("/isep/fsiap/galvanometro/images/tab3_o.png") && lingua.equalsIgnoreCase("pt")){
            s.append("Não existe corrente eléctrica a percorrer o circuito. Assim, não irá ser criado um campo magnético na bobina, levando a que"
                    + "a posição da agulha não seja alterada.");
        }else if (imgFile.equalsIgnoreCase("/isep/fsiap/galvanometro/images/tab3_o.png") && lingua.equalsIgnoreCase("eng")) {
            s.append("There's no electric current flowing through the circuit. So, no magnetic field will be generated by the coil, leading that the pointer's "
                    + "position will not be changed.");
        }

        return s.toString();

    }

    /**
     * converte caracteres não suportados em html para codigo html
     *
     * @param str string a converter
     * @return string convertida
     */
    public String uToHTML(String str) {
        String temp = "";
        for (int i = 0; i < str.length(); i++) {

            switch (str.charAt(i)) {
                case 'Á':
                    temp = str.replace("Á", "&Aacute;");
                    break;
            }

        }
        return temp;

    }

    /**
     * Formata numeros do tipo double para notaçãp cientifica
     *
     * @param valor numero a converter
     * @return numero em notação cientifica
     */
    public static String doubleToCientificNotation(double valor) {
        NumberFormat formatter = new DecimalFormat("0.##E00");
        String s = "";
        
        if(valor % (int) valor == 0){
            s = String.valueOf(valor);
        } else {
            s = formatter.format(valor);
        }
        return s;
    }
}//fim class
