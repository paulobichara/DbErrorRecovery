/*
   Copyright 2011 Paulo Augusto Dacach Bichara

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package org.paulobichara.dberrorrecovery;


import java.io.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Rectangle;

public class Form extends JFrame implements ActionListener {
    public Form() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(null);
        this.getContentPane().setBackground(Color.lightGray);
        jLabel3.setText("jLabel3");
        jLabel3.setBounds(new Rectangle(0, 0, 34, 15));
        jPanel1.setBackground(Color.lightGray);
        jPanel1.setBorder(BorderFactory.createEtchedBorder());
        jPanel1.setBounds(new Rectangle(1, 0, 759, 510));
        jPanel1.setLayout(null);
        jLabel4.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 14));
        jLabel4.setForeground(new Color(1, 4, 186));
        jLabel4.setText("Operações");
        jLabel4.setBounds(new Rectangle(83, 7, 75, 20));
        jComboBoxTipoOp.setFont(new java.awt.Font("Palatino Linotype",
                                                  Font.BOLD, 12));
        jComboBoxTipoOp.setBounds(new Rectangle(105, 39, 119, 20));
        jComboBoxTipoOp.addItem("     ------------    ");
        jComboBoxTipoOp.addItem("WRITE");
        jComboBoxTipoOp.addItem("READ");
        jComboBoxTipoOp.addItem("START");
        jComboBoxTipoOp.addItem("COMMIT");
        jLabel5.setBackground(SystemColor.control);
        jLabel5.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 18));
        jLabel5.setForeground(new Color(1, 4, 186));
        jLabel5.setBorder(BorderFactory.createEtchedBorder());
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Subsistema de Recuperação de Falhas");
        jLabel5.setBounds(new Rectangle(17, 19, 705, 53));
        jLabel6.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jLabel6.setForeground(new Color(1, 4, 186));
        jLabel6.setText("Variável:");
        jLabel6.setBounds(new Rectangle(39, 112, 56, 27));
        jComboBoxVarOp.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jComboBoxVarOp.setBounds(new Rectangle(104, 114, 119, 20));
        jComboBoxVarOp.addItem("     ------------    ");
        jLabel9.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jLabel9.setForeground(new Color(1, 4, 186));
        jLabel9.setText("Transação:");
        jLabel9.setBounds(new Rectangle(37, 71, 68, 27));
        jButtonExecOp.setBounds(new Rectangle(48, 176, 152, 28));
        jButtonExecOp.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jButtonExecOp.setForeground(new Color(1, 4, 186));
        jButtonExecOp.setText("Executar Operação");
        jButtonExecOp.addActionListener(this);
        jButtonExecOp.setEnabled(false);
        jComboBoxTransOp.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jComboBoxTransOp.setBounds(new Rectangle(105, 76, 119, 20));
        jComboBoxTransOp.addItem("  < ID >  < TS > ");
        jButtonDefFreq.setBounds(new Rectangle(104, 73, 112, 28));
        jButtonDefFreq.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jButtonDefFreq.setForeground(new Color(1, 4, 186));
        jButtonDefFreq.setText("Definir");
        jButtonDefFreq.addActionListener(this);
        jLabel10.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 14));
        jLabel10.setForeground(new Color(1, 4, 186));
        jLabel10.setText("Erro");
        jLabel10.setBounds(new Rectangle(100, 7, 31, 20));
        jLabel11.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 14));
        jLabel11.setForeground(new Color(1, 4, 186));
        jLabel11.setText("Transações");
        jLabel11.setBounds(new Rectangle(77, 11, 90, 20));
        jLabel13.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jLabel13.setForeground(new Color(1, 4, 186));
        jLabel13.setText("Operação:");
        jLabel13.setBounds(new Rectangle(40, 36, 64, 27));
        jTextFieldFreq.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jTextFieldFreq.setBounds(new Rectangle(113, 40, 88, 21));
        jLabel14.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 14));
        jLabel14.setForeground(new Color(1, 4, 186));
        jLabel14.setText("Checkpoints");
        jLabel14.setBounds(new Rectangle(73, 11, 95, 21));
        jButtonCriarTrans.setBounds(new Rectangle(107, 73, 112, 28));
        jButtonCriarTrans.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jButtonCriarTrans.setForeground(new Color(1, 4, 186));
        jButtonCriarTrans.setText("Criar Nova");
        jButtonCriarTrans.addActionListener(this);
        jPanel2.setBackground(Color.lightGray);
        jPanel2.setBorder(BorderFactory.createEtchedBorder());
        jPanel2.setBounds(new Rectangle(15, 210, 229, 112));
        jPanel2.setLayout(null);
        jPanel3.setBackground(Color.lightGray);
        jPanel3.setBorder(BorderFactory.createEtchedBorder());
        jPanel3.setBounds(new Rectangle(492, 96, 253, 328));
        jPanel3.setLayout(null);
        jPanel4.setBackground(Color.lightGray);
        jPanel4.setBorder(BorderFactory.createEtchedBorder());
        jPanel4.setBounds(new Rectangle(15, 327, 229, 96));
        jPanel4.setLayout(null);
        jLabel15.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jLabel15.setForeground(new Color(1, 4, 186));
        jLabel15.setText("Frequencia:");
        jLabel15.setBounds(new Rectangle(19, 40, 80, 27));
        jLabel16.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jLabel16.setForeground(new Color(1, 4, 186));
        jLabel16.setText("(em nº de inst.)");
        jLabel16.setBounds(new Rectangle(11, 57, 100, 27));
        jLabel17.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 14));
        jLabel17.setForeground(new Color(1, 4, 186));
        jLabel17.setText("Checkpoints");
        jLabel17.setBounds(new Rectangle(73, 11, 83, 21));
        jPanel5.setBackground(Color.lightGray);
        jPanel5.setBorder(BorderFactory.createEtchedBorder());
        jPanel5.setBounds(new Rectangle(15, 210, 229, 112));
        jPanel6.setBackground(Color.lightGray);
        jPanel6.setBorder(BorderFactory.createEtchedBorder());
        jPanel6.setBounds(new Rectangle(15, 94, 229, 112));
        jPanel6.setLayout(null);
        jPanel7.setBackground(Color.lightGray);
        jPanel7.setBorder(BorderFactory.createEtchedBorder());
        jPanel7.setBounds(new Rectangle(250, 94, 234, 112));
        jPanel7.setLayout(null);
        jLabel18.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jLabel18.setForeground(new Color(1, 4, 186));
        jLabel18.setText("Identificador:");
        jLabel18.setBounds(new Rectangle(16, 43, 85, 27));
        jTextFieldIdTrans.setFont(new java.awt.Font("Palatino Linotype",
                Font.BOLD, 12));
        jTextFieldIdTrans.setText("");
        jTextFieldIdTrans.setBounds(new Rectangle(107, 44, 111, 21));
        jButtonCriarVar.setBounds(new Rectangle(156, 46, 67, 45));
        jButtonCriarVar.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jButtonCriarVar.setForeground(new Color(1, 4, 186));
        jButtonCriarVar.setText("Criar");
        jButtonCriarVar.addActionListener(this);
        jLabel7.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 14));
        jLabel7.setForeground(new Color(1, 4, 186));
        jLabel7.setText("Variáveis");
        jLabel7.setBounds(new Rectangle(82, 11, 75, 20));
        jLabel19.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jLabel19.setForeground(new Color(1, 4, 186));
        jLabel19.setText("Valor Inicial:");
        jLabel19.setBounds(new Rectangle(18, 72, 80, 27));
        jTextFieldValorVar.setFont(new java.awt.Font("Palatino Linotype",
                                                  Font.BOLD, 12));
        jTextFieldValorVar.setBounds(new Rectangle(98, 75, 44, 21));
        jPanel8.setBackground(Color.lightGray);
        jPanel8.setBorder(BorderFactory.createEtchedBorder());
        jPanel8.setBounds(new Rectangle(251, 210, 233, 214));
        jPanel8.setLayout(null);
        jButtonSair.setBounds(new Rectangle(299, 450, 161, 33));
        jButtonSair.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 14));
        jButtonSair.setForeground(new Color(1, 4, 186));
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(this);
        jLabel20.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 14));
        jLabel20.setForeground(new Color(1, 4, 186));
        jLabel20.setText("Arquivo de LOG");
        jLabel20.setBounds(new Rectangle(16, 13, 120, 22));
        jLabel21.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 14));
        jLabel21.setForeground(new Color(1, 4, 186));
        jLabel21.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel21.setText("Lista de REDO");
        jLabel21.setBounds(new Rectangle(141, 12, 110, 22));
        jTextFieldIdVar.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD,
                                              12));
        jTextFieldIdVar.setText("");
        jTextFieldIdVar.setBounds(new Rectangle(98, 44, 44, 21));
        jLabel22.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jLabel22.setForeground(new Color(1, 4, 186));
        jLabel22.setText("Identificador:");
        jLabel22.setBounds(new Rectangle(18, 44, 85, 27));
        jLabel23.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jLabel23.setForeground(new Color(1, 4, 186));
        jLabel23.setText("Valor Novo:");
        jLabel23.setBounds(new Rectangle(71, 144, 73, 27));
        jTextFieldValorOp.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD,
                                              12));
        jTextFieldValorOp.setText("");
        jTextFieldValorOp.setBounds(new Rectangle(153, 146, 44, 21));
        jButtonErro.setBounds(new Rectangle(59, 36, 112, 28));
        jButtonErro.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD, 12));
        jButtonErro.setForeground(new Color(1, 4, 186));
        jButtonErro.setText("Gerar Erro");
        jButtonErro.addActionListener(this);
        jButtonErro.setEnabled(false);
        jTextAreaLog.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD,
                                               12));
        jTextAreaLog.setBorder(BorderFactory.createEtchedBorder());
        jTextAreaREDO.setFont(new java.awt.Font("Palatino Linotype", Font.BOLD,
                                                12));
        jTextAreaREDO.setBorder(BorderFactory.createEtchedBorder());
        jTextAreaREDO.setText("");
        jTextAreaREDO.setBounds(new Rectangle(152, 42, 89, 110));
        jScrollPane1.setBounds(new Rectangle(10, 42, 125, 265));
        jPanel1.add(jLabel5);
        jPanel1.add(jPanel4);
        jPanel2.add(jLabel14);
        jPanel2.add(jLabel17);
        jPanel2.add(jPanel5);
        jPanel2.add(jLabel15);
        jPanel2.add(jTextFieldFreq);
        jPanel2.add(jLabel16);
        jPanel2.add(jButtonDefFreq);
        jPanel1.add(jPanel7);
        jPanel7.add(jLabel7);
        jPanel7.add(jButtonCriarVar);
        jPanel7.add(jTextFieldValorVar);
        jPanel7.add(jTextFieldIdVar);
        jPanel7.add(jLabel19);
        jPanel7.add(jLabel22);
        jPanel1.add(jPanel6);
        jPanel6.add(jLabel11);
        jPanel6.add(jButtonCriarTrans);
        jPanel6.add(jLabel18);
        jPanel6.add(jTextFieldIdTrans);
        jPanel1.add(jPanel2);
        jPanel4.add(jLabel10);
        jPanel4.add(jButtonErro);
        jPanel1.add(jPanel8);
        jPanel8.add(jLabel4);
        jPanel8.add(jLabel13);
        jPanel8.add(jLabel6);
        jPanel8.add(jComboBoxVarOp);
        jPanel8.add(jComboBoxTransOp);
        jPanel8.add(jComboBoxTipoOp);
        jPanel8.add(jButtonExecOp);
        jPanel8.add(jLabel9);
        jPanel8.add(jTextFieldValorOp);
        jPanel8.add(jLabel23);
        jPanel3.add(jLabel20);
        jPanel3.add(jScrollPane1);
        jPanel3.add(jLabel21);
        jPanel3.add(jTextAreaREDO);
        jScrollPane1.getViewport().add(jTextAreaLog);
        jPanel1.add(jButtonSair);
        jPanel1.add(jPanel3);
        this.getContentPane().add(jPanel1);
        jLabel1.setText("jLabel1");
    }


    Subsistema subsistema = new Subsistema();
    TitledBorder titledBorder1 = new TitledBorder("");
    TitledBorder titledBorder2 = new TitledBorder("");
    JLabel jLabel3 = new JLabel();
    JPanel jPanel1 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JComboBox jComboBoxTipoOp = new JComboBox();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    JComboBox jComboBoxVarOp = new JComboBox();
    JLabel jLabel9 = new JLabel();
    JButton jButtonExecOp = new JButton();
    JComboBox jComboBoxTransOp = new JComboBox();
    JButton jButtonDefFreq = new JButton();
    JLabel jLabel10 = new JLabel();
    JLabel jLabel11 = new JLabel();
    JLabel jLabel13 = new JLabel();
    JTextField jTextFieldFreq = new JTextField();
    JLabel jLabel14 = new JLabel();
    JButton jButtonCriarTrans = new JButton();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    JLabel jLabel15 = new JLabel();
    JLabel jLabel16 = new JLabel();
    JLabel jLabel17 = new JLabel();
    JPanel jPanel5 = new JPanel();
    JPanel jPanel6 = new JPanel();
    JPanel jPanel7 = new JPanel();
    JLabel jLabel18 = new JLabel();
    JTextField jTextFieldIdTrans = new JTextField();
    JButton jButton2 = new JButton();
    JButton jButtonCriarVar = new JButton();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel19 = new JLabel();
    JTextField jTextFieldValorVar = new JTextField();
    JPanel jPanel8 = new JPanel();
    JButton jButtonSair = new JButton();
    JLabel jLabel20 = new JLabel();
    JLabel jLabel21 = new JLabel();
    JTextField jTextFieldIdVar = new JTextField();
    JLabel jLabel22 = new JLabel();
    JLabel jLabel23 = new JLabel();
    JTextField jTextFieldValorOp = new JTextField();
    JButton jButtonErro = new JButton();
    JTextArea jTextAreaLog = new JTextArea();
    JTextArea jTextAreaREDO = new JTextArea();
    JScrollPane jScrollPane1 = new JScrollPane(jTextAreaLog);


    public void actionPerformed (ActionEvent aeEvento) {
     Object obSource = aeEvento.getSource();
         if(obSource == jButtonDefFreq) {
             int freq = Integer.parseInt(jTextFieldFreq.getText());
             subsistema.setFreqChkpt(freq);
             JOptionPane alerta = new JOptionPane();
             alerta.showMessageDialog(this, "Frequência de checkpoints definida em: "+freq , "Confirmação", 1);
             jButtonDefFreq.setEnabled(false);
             jTextFieldFreq.setEnabled(false);
             jButtonExecOp.setEnabled(true);
             jButtonErro.setEnabled(true);
         } else {
             if (obSource == jButtonCriarTrans) {
                 String t = jTextFieldIdTrans.getText();
                 subsistema.adicionaTransacao(jTextFieldIdTrans.getText());
                 jComboBoxTransOp.addItem(t + "  " + "-");
                 jTextFieldIdTrans.setText("");
                 JOptionPane alerta = new JOptionPane();
                 alerta.showMessageDialog(this, "Transação "+t+" criada com sucesso!" , "Confirmação", 1);
             } else {
                 if (obSource == jButtonCriarVar) {
                     int v = Integer.parseInt(jTextFieldValorVar.getText());
                     String var = jTextFieldIdVar.getText();
                     subsistema.adicionaVariavel(var, v);
                     jComboBoxVarOp.addItem(var);
                     jTextFieldIdVar.setText("");
                     jTextFieldValorVar.setText("");
                     JOptionPane alerta = new JOptionPane();
                     alerta.showMessageDialog(this, "Variável "+var+" criada com sucesso!" , "Confirmação", 1);
                 } else {
                     if (obSource == jButtonErro) {
                         jTextAreaLog.append(subsistema.insereErro());
                         jTextAreaREDO.append(subsistema.recuperacaoDeErro());
                     } else {
                         if (obSource == jButtonExecOp) {
                             if (jComboBoxTipoOp.getSelectedItem().equals("WRITE")) {
                                int v = Integer.parseInt(jTextFieldValorOp.getText());
                                String s = (String)jComboBoxTransOp.getSelectedItem();
                                String t = s.substring(0, s.length()-3);
                                String o = (String)jComboBoxTipoOp.getSelectedItem();
                                String var = (String)jComboBoxVarOp.getSelectedItem();
                                String resp = subsistema.executaOperacao(t, o, var, v);
                                if (resp.charAt(0) == '<') {
                                    jTextAreaLog.append(resp);
                                } else {
                                    JOptionPane alerta = new JOptionPane();
                                    alerta.showMessageDialog(this, resp, "Atenção", 1);
                                }
                             } else {
                                 if (jComboBoxTipoOp.getSelectedItem().equals("READ")) {
                                     String s = (String)jComboBoxTransOp.getSelectedItem();
                                     String t = s.substring(0, s.length()-3);
                                     String o = (String)jComboBoxTipoOp.getSelectedItem();
                                     String var = (String)jComboBoxVarOp.getSelectedItem();
                                     String msg = subsistema.executaOperacao(t, o, var);
                                     if (msg != null) {
                                         JOptionPane alerta = new JOptionPane();
                                         alerta.showMessageDialog(this, msg, "Atenção", 1);
                                     }
                                 } else {
                                     if (jComboBoxTipoOp.getSelectedItem().equals("START")) {
                                         int i = -1;
                                         String s = (String)jComboBoxTransOp.getSelectedItem();
                                         String t = s.substring(0, s.length()-3);
                                         jTextAreaLog.append(subsistema.executaStart(t));
                                         do {
                                             i++;
                                         } while (!s.equals((String)jComboBoxTransOp.getItemAt(i)));
                                         jComboBoxTransOp.removeItemAt(i);
                                         jComboBoxTransOp.addItem(t+"  "+subsistema.getTimeStamp(t));
                                     } else {
                                         if (jComboBoxTipoOp.getSelectedItem().equals("COMMIT")) {
                                             String s = (String)jComboBoxTransOp.getSelectedItem();
                                             String t = s.substring(0, s.length()-3);
                                             jTextAreaLog.append(subsistema.executaCommit(t));
                                         }
                                     }
                                 }
                             }
                             jComboBoxTransOp.setSelectedIndex(0);
                             jComboBoxTipoOp.setSelectedIndex(0);
                             jComboBoxVarOp.setSelectedIndex(0);
                         } else {
                             if (obSource == jButtonSair) {
                                     System.exit(0);
                             }
                         }
                     }
                 }
             }
         }


     }



    public static void main(String args[]) {

    Form obj = new Form();
    obj.addWindowListener(new WindowAdapter(){
    public void windowClosing (WindowEvent e) {
      System.exit(0);
    }
    });
    obj.pack();
    obj.setBounds(0,0,770,540);
    obj.setTitle("Subsistema de Recuperação de Falhas");
    obj.setVisible(true);

}

}
