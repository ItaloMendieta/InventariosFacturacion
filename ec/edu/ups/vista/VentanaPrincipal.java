/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.vista.VentanaBuscarProducto;
import ec.edu.ups.vista.VentanaProveedor;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author ASUS
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private VentanaCategoria ventanaCategoria;
    private VentanaProveedor vistaProveedor;
    private VentanaInventario ventanaInventario;
    private VentanaBuscarProducto ventanaBuscarProducto;
    private ImageIcon icon;
    private Image imagen;
   // private VentanaLogguin ventanaLogguin;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal(String gerente) {

        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        ventanaCategoria = new VentanaCategoria(this);
        vistaProveedor = new VentanaProveedor(this);
        ventanaBuscarProducto = new VentanaBuscarProducto(this);
     //   ventanaLogguin = new VentanaLogguin();
        txtgerente.setText(gerente);

    }
    public VentanaCategoria getVentanaCategoria() {
        return ventanaCategoria;
    }

    public void setVentanaCategoria(VentanaCategoria ventanaCategoria) {
        this.ventanaCategoria = ventanaCategoria;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        txtgerente = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setToolTipText("");
        desktopPane.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Gerente:");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(1410, 30, 80, 60);

        txtgerente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        desktopPane.add(txtgerente);
        txtgerente.setBounds(1520, 44, 150, 30);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Categorias");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);

        jMenuItem2.setText("Proveedor");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem2);

        jMenuItem1.setText("Producto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem1);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("Inventarios");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1812, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         if (!desktopPane.isAncestorOf(vistaProveedor)) {
            desktopPane.add(vistaProveedor);
        } else {
            desktopPane.setSelectedFrame(vistaProveedor);
        }
        vistaProveedor.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
             if (!desktopPane.isAncestorOf(ventanaBuscarProducto)) {
            desktopPane.add(ventanaBuscarProducto);
        } else {
            desktopPane.setSelectedFrame(ventanaBuscarProducto);
        }
        ventanaBuscarProducto.show();
        ventanaBuscarProducto.setMaximizable(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
            ventanaInventario = new VentanaInventario(this);
        if (!desktopPane.isAncestorOf(ventanaInventario)) {
            desktopPane.add(ventanaInventario);
        } else {
            desktopPane.remove(ventanaInventario);
            desktopPane.setSelectedFrame(ventanaInventario);
        }
        ventanaInventario.show();
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        // TODO add your handling code here:
                if (!desktopPane.isAncestorOf(ventanaCategoria)) {
            desktopPane.add(ventanaCategoria);
        } else {
            desktopPane.setSelectedFrame(ventanaCategoria);
        }
        ventanaCategoria.show();
    }//GEN-LAST:event_contentMenuItemActionPerformed
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    public javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel txtgerente;
    // End of variables declaration//GEN-END:variables

}
