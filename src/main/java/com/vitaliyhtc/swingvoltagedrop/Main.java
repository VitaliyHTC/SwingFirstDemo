package com.vitaliyhtc.swingvoltagedrop;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by VitaliyHTC on 21.01.2017.
 */
public class Main {

    private static Dimension textFieldMinimumDimension = new Dimension(80, 25);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGUI();
            }
        });
    }

    private static  void createGUI(){
        JFrame frame = new JFrame();


        // input part
        JLabel selectMaterialLabel = new JLabel("Select material");
        String[] materialStrings = { "Cooper", "Aluminium" };
        JComboBox materialList = new JComboBox(materialStrings);
        materialList.setSelectedIndex(0);

        JLabel selectWireSizeLabel = new JLabel("Select Wire Size");
        JFormattedTextField selectWireSizeTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
        selectWireSizeTextField.setText("95");
        selectWireSizeTextField.setMinimumSize(textFieldMinimumDimension);
        String[] wireSizeDimStrings = { "AWG", "kcmil", "mm (r)", "mm²"};
        JComboBox wireSizeDimComboBox = new JComboBox(wireSizeDimStrings);
        wireSizeDimComboBox.setSelectedIndex(3);

        JLabel selectVoltageLabel = new JLabel("Select Voltage");
        String[] selectVoltageStrings = { "DC", "AC 1-phase", "AC 3-phase 3-wire", "AC 3-phase 4-wire"};
        JComboBox selectVoltageTypeComboBox = new JComboBox(selectVoltageStrings);
        selectVoltageTypeComboBox.setSelectedIndex(0);

        String[] selectDistanceStrings = { "Distance to the load", "Wire total length"};
        JComboBox selectDistanceComboBox = new JComboBox(selectDistanceStrings);
        selectDistanceComboBox.setSelectedIndex(0);
        JFormattedTextField selectDistanceTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
        selectDistanceTextField.setText("3");
        //JTextField selectDistanceTextField = new JTextField("3");
        selectDistanceTextField.setMinimumSize(textFieldMinimumDimension);
        String[] selectDistanceLengthUnitStrings = {"mm", "m", "km"};
        JComboBox selectDistanceLengthUnitComboBox = new JComboBox(selectDistanceLengthUnitStrings);
        selectDistanceLengthUnitComboBox.setSelectedIndex(1);


        JLabel enterVoltageValueLabel = new JLabel("Voltage");
        JFormattedTextField enterVoltageValueTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
        enterVoltageValueTextField.setText("14.4");
        //JTextField enterVoltageValueTextField = new JTextField("14.4");
        enterVoltageValueTextField.setMinimumSize(textFieldMinimumDimension);
        String[] enterVoltageValueUnitStrings = {"mV", "V", "kV"};
        JComboBox enterVoltageValueUnitComboBox = new JComboBox(enterVoltageValueUnitStrings);
        enterVoltageValueUnitComboBox.setSelectedIndex(1);

        JLabel enterLoadCurrentLabel = new JLabel("Load Current");
        JFormattedTextField enterLoadCurrentValueTextField = new JFormattedTextField(NumberFormat.getNumberInstance());
        enterLoadCurrentValueTextField.setText("370");
        //JTextField enterLoadCurrentValueTextField = new JTextField("370");
        enterLoadCurrentValueTextField.setMinimumSize(textFieldMinimumDimension);
        String[] enterLoadCurrentValueUnitStrings = {"µA", "mA", "A", "kA", "MA"};
        JComboBox enterLoadCurrentValueUnitComboBox = new JComboBox(enterLoadCurrentValueUnitStrings);
        enterLoadCurrentValueUnitComboBox.setSelectedIndex(2);



        // final view formed here
        JPanel mainInputPanel = new JPanel(new MigLayout());
        mainInputPanel.setBackground(new Color(255,224,178));
        //mainInputPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        mainInputPanel.add(selectMaterialLabel);
        mainInputPanel.add(materialList, "span 2, wrap");

        mainInputPanel.add(selectWireSizeLabel);
        mainInputPanel.add(selectWireSizeTextField);
        mainInputPanel.add(wireSizeDimComboBox, "wrap");

        mainInputPanel.add(selectVoltageLabel);
        mainInputPanel.add(selectVoltageTypeComboBox, "span 2, wrap");

        mainInputPanel.add(selectDistanceComboBox);
        mainInputPanel.add(selectDistanceTextField);
        mainInputPanel.add(selectDistanceLengthUnitComboBox, "wrap");

        mainInputPanel.add(enterVoltageValueLabel);
        mainInputPanel.add(enterVoltageValueTextField);
        mainInputPanel.add(enterVoltageValueUnitComboBox, "wrap");

        mainInputPanel.add(enterLoadCurrentLabel);
        mainInputPanel.add(enterLoadCurrentValueTextField);
        mainInputPanel.add(enterLoadCurrentValueUnitComboBox, "wrap");













        JLabel moVoltageDrop = new JLabel("Voltage drop: ");
        JLabel moVoltageDropResult = new JLabel();

        JLabel moVoltageAtTheEndOfCircuit = new JLabel("Voltage at the end of circuit: ");
        JLabel moVoltageAtTheEndOfCircuitResult = new JLabel();

        JLabel moPowerLoss = new JLabel("Power loss: ");
        JLabel moPowerLossResult = new JLabel();

        JLabel moWireCrossSection = new JLabel("Wire cross section: ");
        JLabel moWireCrossSectionResult = new JLabel();

        JLabel moDiameter = new JLabel("Diameter: ");
        JLabel moDiameterResult = new JLabel();


        JPanel mainOutputPanel = new JPanel(new MigLayout());
        mainOutputPanel.setBackground(new Color(255,204,188));
        mainOutputPanel.add(moVoltageDrop);
        mainOutputPanel.add(moVoltageDropResult, "wrap");
        mainOutputPanel.add(moVoltageAtTheEndOfCircuit);
        mainOutputPanel.add(moVoltageAtTheEndOfCircuitResult, "wrap");
        mainOutputPanel.add(moPowerLoss);
        mainOutputPanel.add(moPowerLossResult, "wrap");
        mainOutputPanel.add(moWireCrossSection);
        mainOutputPanel.add(moWireCrossSectionResult, "wrap");
        mainOutputPanel.add(moDiameter);
        mainOutputPanel.add(moDiameterResult, "wrap");



        JPanel mainVoltageDropPanel = new JPanel();
        mainVoltageDropPanel.setLayout(new BoxLayout(mainVoltageDropPanel, BoxLayout.PAGE_AXIS));
        mainVoltageDropPanel.add(mainInputPanel);
        mainVoltageDropPanel.add(mainOutputPanel);
        //mainVoltageDropPanel.setBackground(new Color(255,224,178));



        /* setLookAndFeel begin */
        JLabel selectLAFLabel = new JLabel("Select LookAndFeel: ");
        UIManager.LookAndFeelInfo[] infoArray = UIManager.getInstalledLookAndFeels();
        ArrayList<String> installedLookAndFeelNames = new ArrayList<>();
        for (UIManager.LookAndFeelInfo laf : infoArray) {
            installedLookAndFeelNames.add(laf.getName());
            //System.out.println(laf.getName());
        }
        String[] lafNameStrings1 = new String[installedLookAndFeelNames.size()];
        String[] lafNameStrings = installedLookAndFeelNames.toArray(lafNameStrings1);
        JComboBox selectLAFComboBox = new JComboBox(lafNameStrings);
        selectLAFComboBox.addActionListener(new UpdateLookAndFeelAction(frame, selectLAFComboBox));

        JPanel setLookAndFeelPanel = new JPanel();
        setLookAndFeelPanel.add(selectLAFLabel);
        setLookAndFeelPanel.add(selectLAFComboBox);
        setLookAndFeelPanel.setBackground(new Color(179,229,252));

        /* setLookAndFeel end */


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(mainVoltageDropPanel, BorderLayout.CENTER);
        mainPanel.add(setLookAndFeelPanel, BorderLayout.SOUTH);
        //mainPanel.setBackground(new Color(252,252,252));



        frame.setSize(480,800);
        frame.setMinimumSize(new Dimension(480, 560));
        frame.setPreferredSize(new Dimension(480, 600));
        frame.setMaximumSize(new Dimension(640, 960));
        frame.setTitle("Voltage Drop - Swing Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }



    static class UpdateLookAndFeelAction implements ActionListener {
        private JComboBox<String> list;
        private JFrame rootFrame;

        public UpdateLookAndFeelAction(JFrame rootFrame, JComboBox<String> list) {
            this.rootFrame = rootFrame;
            this.list = list;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String lookAndFeelName = String.valueOf(list.getSelectedItem());
            //System.out.println(lookAndFeelName);
            UIManager.LookAndFeelInfo[] infoArray = UIManager.getInstalledLookAndFeels();
            for(UIManager.LookAndFeelInfo info : infoArray) {
                if(info.getName().equals(lookAndFeelName)) {
                    String message = "Look and feel was changed to " + lookAndFeelName;
                    try {
                        UIManager.setLookAndFeel(info.getClassName());
                        SwingUtilities.updateComponentTreeUI(rootFrame);
                    } catch (ClassNotFoundException e1) {
                        message = "Error: class " + info.getClassName() + " not found";
                    } catch (InstantiationException e1) {
                        message = "Error: instantiation exception";
                    } catch (IllegalAccessException e1) {
                        message = "Error: illegal access";
                    } catch (UnsupportedLookAndFeelException e1) {
                        message = "Error: unsupported look and feel";
                    }
                    JOptionPane.showMessageDialog(null, message);
                    break;
                }
            }
        }
    }

}
