package com.mycompany.restaurante;

import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

    Menú ObjMenu = new Menú();

    public Ventana() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        create = new javax.swing.JButton();
        tittle = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        into = new javax.swing.JButton();
        analyze = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        create.setText("crear menú");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        tittle.setText("ANALITICA DE DATOS UFPSO");

        search.setText("consultar el menú");
        search.setEnabled(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        into.setText("ingresar datos");
        into.setEnabled(false);
        into.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intoActionPerformed(evt);
            }
        });

        analyze.setText("analizar información");
        analyze.setEnabled(false);
        analyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(create)
                .addGap(26, 26, 26)
                .addComponent(search)
                .addGap(27, 27, 27)
                .addComponent(into)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(analyze)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(tittle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(tittle)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(create)
                    .addComponent(search)
                    .addComponent(into)
                    .addComponent(analyze))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        ObjMenu.createMenu(validateIntInput(JOptionPane.showInputDialog("¿Cuántos platos quiere añadir?")));
        search.setEnabled(true);
    }//GEN-LAST:event_createActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        ObjMenu.searchMenu();
        into.setEnabled(true);
    }//GEN-LAST:event_searchActionPerformed

    private void intoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intoActionPerformed
        ObjMenu.intoDatos();
        analyze.setEnabled(true);
    }//GEN-LAST:event_intoActionPerformed

    private void analyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyzeActionPerformed
        ObjMenu.analyzeInfo();
    }//GEN-LAST:event_analyzeActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    
    public int validateIntInput(String str) {
        while (isNumber(str)==false) {
            str = JOptionPane.showInputDialog("Ingrese un número ENTERO válido (sin espacios):");
        }
        return Integer.parseInt(str);
    }
    
    public static boolean isNumber(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analyze;
    private javax.swing.JButton create;
    private javax.swing.JButton into;
    private javax.swing.JButton search;
    private javax.swing.JLabel tittle;
    // End of variables declaration//GEN-END:variables
}
