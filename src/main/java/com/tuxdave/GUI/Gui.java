package com.tuxdave.GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.tuxdave.CodiceFiscale.CodiceFiscale;
import com.tuxdave.JComponents.JPlaceHolderTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Gui extends JFrame {
    private JPanel panel1;
    private JComboBox<Character> sessoBox;
    private JComboBox<String> cittaBox;
    private JButton calcolaButton;
    private JTextField codiceFiscaleTextField;
    private JPlaceHolderTextField cognomeEdit;
    private JPlaceHolderTextField nomeEdit;
    private JDatePicker datePicker;

    private String originalResult = "Codice Fiscale: ";
    CodiceFiscale code = null;

    //START AUTOGENERATED CODE

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(7, 1, new Insets(0, 0, 0, 0), -1, -1));
        cognomeEdit = new JPlaceHolderTextField();
        Font cognomeEditFont = this.$$$getFont$$$("Ubuntu", Font.BOLD, 14, cognomeEdit.getFont());
        if (cognomeEditFont != null) cognomeEdit.setFont(cognomeEditFont);
        cognomeEdit.setPlaceHolder("Cognome...");
        panel1.add(cognomeEdit, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        nomeEdit = new JPlaceHolderTextField();
        Font nomeEditFont = this.$$$getFont$$$("Ubuntu", Font.BOLD, 14, nomeEdit.getFont());
        if (nomeEditFont != null) nomeEdit.setFont(nomeEditFont);
        nomeEdit.setPlaceHolder("Nome...");
        nomeEdit.setToolTipText("Nome...");
        panel1.add(nomeEdit, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        datePicker = new JDatePicker();
        panel1.add(datePicker.$$$getRootComponent$$$(), new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        sessoBox = new JComboBox();
        Font sessoBoxFont = this.$$$getFont$$$("Ubuntu", Font.BOLD, 14, sessoBox.getFont());
        if (sessoBoxFont != null) sessoBox.setFont(sessoBoxFont);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        sessoBox.setModel(defaultComboBoxModel1);
        sessoBox.setToolTipText("Sesso...");
        panel1.add(sessoBox, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cittaBox = new JComboBox();
        Font cittaBoxFont = this.$$$getFont$$$("Ubuntu", Font.BOLD, 14, cittaBox.getFont());
        if (cittaBoxFont != null) cittaBox.setFont(cittaBoxFont);
        cittaBox.setToolTipText("Città di Nascita");
        panel1.add(cittaBox, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        calcolaButton = new JButton();
        Font calcolaButtonFont = this.$$$getFont$$$("Ubuntu", Font.BOLD, 14, calcolaButton.getFont());
        if (calcolaButtonFont != null) calcolaButton.setFont(calcolaButtonFont);
        calcolaButton.setText("Calcola!");
        panel1.add(calcolaButton, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        codiceFiscaleTextField = new JTextField();
        codiceFiscaleTextField.setEditable(false);
        Font codiceFiscaleTextFieldFont = this.$$$getFont$$$("Ubuntu", Font.BOLD, 14, codiceFiscaleTextField.getFont());
        if (codiceFiscaleTextFieldFont != null) codiceFiscaleTextField.setFont(codiceFiscaleTextFieldFont);
        codiceFiscaleTextField.setText("Codice Fiscale: ");
        panel1.add(codiceFiscaleTextField, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

    //END AUTOGENERATED CODE

    public Gui() {//setup window
        super();
        //setup form
        add(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);

        try {
            setupUi();
        } catch (IOException e) {
            codiceFiscaleTextField.setForeground(Color.RED);
            codiceFiscaleTextField.setText("Impossibile trovare database, avviare programma da file JAR!");
        }
    }

    {//setup listener
        calcolaButton.addActionListener(new GuiListenr());
    }

    private void setupUi() throws IOException {
        sessoBox.setModel(new DefaultComboBoxModel<Character>());
        sessoBox.addItem('M');
        sessoBox.addItem('F');

        cittaBox.setModel(new DefaultComboBoxModel<String>());
        URL file = getClass().getClassLoader().getResource("catasto.csv");
        BufferedReader lettore = null;
        if (file != null) {
            lettore = new BufferedReader(new InputStreamReader(file.openStream()));
            String[] riga = new String[3];
            riga[0] = lettore.readLine();
            do {
                riga = riga[0].split(",");
                cittaBox.addItem(riga[0] + " (" + riga[1] + ")");
                riga[0] = lettore.readLine();
            } while (riga[0] != null);
        }
    }

    private class GuiListenr implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == calcolaButton) {
                String cognome, nome, data;
                String[] citta = new String[2];
                char sesso;

                cognome = cognomeEdit.getText();
                nome = nomeEdit.getText();
                String[] s = datePicker.getDate();
                data = s[0] + "/" + s[1] + "/" + s[2];
                sesso = (Character) sessoBox.getSelectedItem();//casting to Char
                citta[0] = (String) cittaBox.getSelectedItem();//casting to String
                if (citta[0] != null) {
                    citta[0] = citta[0].replace("(", "");
                    citta[0] = citta[0].replace(")", "");
                    citta = citta[0].split(" ");
                }

                try {
                    System.out.println(cognome);//todo: sistemato
                    code = new CodiceFiscale();
                    code.setCognome(cognome);
                    code.setNome(nome);
                    code.setData(data);
                    code.setSesso(sesso);
                    code.setComune(citta[0], citta[1]);
                    codiceFiscaleTextField.setText(originalResult + code.codeCF());
                } catch (NullPointerException e) {
                    final JDialog dialog = new JDialog();
                    dialog.getContentPane().setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
                    dialog.add(new JLabel("Impossibile trovare database con codici catastali..."));
                    dialog.add(new JLabel("Eseguire il programma da file JAR!"));
                    JButton b = new JButton("OK!");
                    b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            dialog.setVisible(false);
                        }
                    });
                    dialog.add(b);
                    dialog.setVisible(true);
                    dialog.pack();
                } catch (IOException e) {
                    System.out.println("Ciao");
                }
            }
        }
    }
}
