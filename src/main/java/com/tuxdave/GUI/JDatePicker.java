package com.tuxdave.GUI;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class JDatePicker extends JPanel {
    //graphic component (Swing)
    private JPanel bodyPanel;
    private JPanel monthPanel;
    private JPanel dayPanel;
    private JPanel yearPanel;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JSpinner daySpinner;
    private JComboBox<String> monthCombo;
    private JSpinner yearSpinner;

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
        bodyPanel = new JPanel();
        bodyPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        bodyPanel.setMinimumSize(new Dimension(215, 105));
        monthPanel = new JPanel();
        monthPanel.setLayout(new BorderLayout(0, 0));
        bodyPanel.add(monthPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Ubuntu", Font.BOLD, -1, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setHorizontalAlignment(0);
        label2.setText("Mese:");
        monthPanel.add(label2, BorderLayout.CENTER);
        monthCombo = new JComboBox();
        monthCombo.setEditable(false);
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        monthCombo.setModel(defaultComboBoxModel1);
        monthPanel.add(monthCombo, BorderLayout.SOUTH);
        dayPanel = new JPanel();
        dayPanel.setLayout(new BorderLayout(0, 0));
        bodyPanel.add(dayPanel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Ubuntu", Font.BOLD, -1, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalAlignment(0);
        label1.setText("Giorno:");
        dayPanel.add(label1, BorderLayout.CENTER);
        daySpinner = new JSpinner();
        dayPanel.add(daySpinner, BorderLayout.SOUTH);
        yearPanel = new JPanel();
        yearPanel.setLayout(new BorderLayout(0, 0));
        bodyPanel.add(yearPanel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Ubuntu", Font.BOLD, -1, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setHorizontalAlignment(0);
        label3.setText("Anno:");
        yearPanel.add(label3, BorderLayout.CENTER);
        yearSpinner = new JSpinner();
        yearPanel.add(yearSpinner, BorderLayout.SOUTH);
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
        return bodyPanel;
    }

    //END AUTOGENERATED CODE

    {
        //inizializing all the needed
        //adding listeners
        daySpinner.addChangeListener(new JDataPickerListener());
        yearSpinner.addChangeListener(new JDataPickerListener());
        monthCombo.addActionListener(new JDataPickerListener());

        //creation of a generic model based on String
        monthCombo.setModel(new DefaultComboBoxModel<String>());
        //and add the months
        String[] mesi = new String[]{"Gennaio", "Febbraio", "Marzo", "Aprile", "Maggio", "Giugno", "Luglio", "Agosto", "Settembre", "Ottobre", "Novembre", "Dicembre"};
        for (short i = 0; i < 12; i++) {
            monthCombo.addItem(new String(Integer.toString(i + 1) + " " + mesi[i]));
        }

        //set the starting year
        Calendar c = Calendar.getInstance();
        yearSpinner.setValue(c.getTime().getYear() + 1900);
    }

    public String[] getDate() {
        String giorno = Integer.toString((int) (daySpinner.getValue()));
        String mese = Integer.toString(monthCombo.getSelectedIndex() + 1);
        String anno = Integer.toString((int) (yearSpinner.getValue()));

        if (giorno.length() == 1) {
            giorno = "0" + giorno;
        }
        if (mese.length() == 1) {
            mese = "0" + mese;
        }
        return new String[]{giorno, mese, anno};//day, month, year
    }


    private class JDataPickerListener implements ChangeListener, ActionListener { //creation of the class that implements the listeners
        @Override
        public void stateChanged(ChangeEvent changeEvent) { //implementation of ChangeListener
            if (changeEvent.getSource().equals(yearSpinner)) { //if the listener is called by "yearSpinner"
                Calendar c = Calendar.getInstance();
                int min = c.getTime().getYear() + 1900 - 125;
                int now = c.getTime().getYear() + 1900;
                if ((int) yearSpinner.getValue() < min) {
                    yearSpinner.setValue(min);
                }
                if ((int) yearSpinner.getValue() > now) {
                    yearSpinner.setValue(now);
                }
                JDataPickerListener controller = new JDataPickerListener(); //check if the day is ok
                controller.stateChanged(new ChangeEvent(daySpinner));
            }
            if (changeEvent.getSource().equals(daySpinner)) { // condiction about daySpinner
                int day = (int) (daySpinner.getValue());
                if (day < 1) {
                    daySpinner.setValue(1);
                }
                if (day > 28) {
                    int[] giorni = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
                    int mese = monthCombo.getSelectedIndex();
                    int anno = (int) (yearSpinner.getValue());
                    boolean bis = anno % 4 == 0;
                    if (day > giorni[mese] + (mese == 1 && bis ? 1 : 0)) {
                        daySpinner.setValue(day - 1);
                    }
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource().equals(monthCombo)) {
                JDataPickerListener controller = new JDataPickerListener(); //check if the day is ok
                controller.stateChanged(new ChangeEvent(daySpinner));
            }
        }
    }
}
