/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Proveedor;
import ec.edu.ups.controlador.ControladorCategoria;
import ec.edu.ups.controlador.ControladorInventario;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.controlador.ControladorProveedor;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class VentanaModificarProducto extends javax.swing.JInternalFrame {

    private VentanaBuscarProducto ventanaBuscarProducto;
    private ControladorProducto controladorProducto;
    private ControladorCategoria controladorCategoria;
    private ControladorProveedor controladorProveedor;
    private ControladorInventario controladorInventario;
    private String codigo1;

    public VentanaModificarProducto(VentanaBuscarProducto vp, String codigo) {
        initComponents();
        vp = ventanaBuscarProducto;
        controladorProducto = new ControladorProducto();
        controladorCategoria = new ControladorCategoria();
        controladorProveedor = new ControladorProveedor();
        controladorInventario = new ControladorInventario();
        codigo1 = codigo;
       
        txtCodigoModificarBuscar.setText(codigo1);
        System.out.println("scnjsc "+codigo1);
        if(codigo1!=null){
            buscar();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Seleccione un producto en la tabla");
        }
        
        
    }
    public void buscar(){
           Producto p = controladorProducto.BuscarProductoCod(codigo1);
        if (p.getId() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Producto no disponible");
        } else {
            txtCodigoModificarP.setText(p.getCodigo());
            txtDescripcionModificar.setText(p.getDescripcion());
            txtPrecioModificar.setText(String.valueOf(p.getPrecio()));
            cbxProveedorModificar.addItem(p.getProveedor().getNombre());
            cbxCategoriaModificar.addItem(p.getCategoria().getDescripcion());
//            cbxCategoriaModificar.removeAllItems();
//            List<Categoria> listaCat = controladorCategoria.listar();
//            for (Categoria cat : listaCat) {
//                cbxCategoriaModificar.addItem(cat.getDescripcion());
//            }
//            cbxProveedorModificar.removeAllItems();
//            List<Proveedor> listaProv = controladorProveedor.listar();
//            for (Proveedor pro : listaProv) {
//                cbxProveedorModificar.addItem(pro.getNombre());
//            }
}
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoModificarP = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtCodigoModificarBuscar = new javax.swing.JTextField();
        cbxCategoriaModificar = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        txtDescripcionModificar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxProveedorModificar = new javax.swing.JComboBox<>();
        txtPrecioModificar = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Modificar Producto");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Codigo:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Descripcion:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Precio:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Categoria:");

        txtCodigoModificarP.setEditable(false);
        txtCodigoModificarP.setEnabled(false);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/recursos/madificar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel32.setText("Codigo:");

        cbxCategoriaModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxCategoriaModificarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxCategoriaModificarMousePressed(evt);
            }
        });
        cbxCategoriaModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaModificarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/recursos/canselar.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Proveedor:");

        cbxProveedorModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxProveedorModificarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxProveedorModificarMousePressed(evt);
            }
        });
        cbxProveedorModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedorModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnModificar)
                .addGap(34, 34, 34)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel32)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCodigoModificarP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoModificarBuscar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxCategoriaModificar, 0, 90, Short.MAX_VALUE)
                    .addComponent(txtDescripcionModificar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxProveedorModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecioModificar))
                .addGap(170, 170, 170))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32))
                    .addComponent(txtCodigoModificarBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtCodigoModificarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDescripcionModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecioModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbxCategoriaModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(cbxProveedorModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 436, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        Producto p = new Producto();
        controladorProducto.conexion();
        p.setCodigo(txtCodigoModificarP.getText());
        p.setDescripcion(txtDescripcionModificar.getText());
        //p.setDescuento();
        String cate = (String) cbxCategoriaModificar.getSelectedItem();
        String prove = (String) cbxProveedorModificar.getSelectedItem();
        System.out.println("aa " + cate);
        Categoria c = controladorCategoria.BuscarCategoriaNombre(cate);
        Proveedor proveedor = controladorProveedor.buscarP(prove);
        p.setCategoria(c);
        p.setProveedor(proveedor);
        p.setPrecio(Double.valueOf(txtPrecioModificar.getText()));
        controladorProducto.modificarProducto(p, p.getCodigo());
        txtCodigoModificarP.setText("");
        txtCodigoModificarBuscar.setText("");
        txtDescripcionModificar.setText("");
        txtPrecioModificar.setText("");
        //ventanaBuscarProducto.listarProductos();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cbxCategoriaModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaModificarActionPerformed
        // TODO add your handling code here:
        try {
            String txt = (String) cbxCategoriaModificar.getSelectedItem();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_cbxCategoriaModificarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtCodigoModificarBuscar.setText("");
        txtDescripcionModificar.setText("");
        txtCodigoModificarP.setText("");
        cbxCategoriaModificar.removeAllItems();
        txtPrecioModificar.setText("");
        List<Categoria> lista = controladorCategoria.listar();
        for (Categoria p : lista) {
            cbxCategoriaModificar.addItem(p.getDescripcion());
        }
        cbxProveedorModificar.removeAllItems();
        List<Proveedor> listaProv = controladorProveedor.listar();
        for (Proveedor pro : listaProv) {
            cbxProveedorModificar.addItem(pro.getNombre());
        }
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxProveedorModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedorModificarActionPerformed
        // TODO add your handling code here:
        try {
            String txt = (String) cbxProveedorModificar.getSelectedItem();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxProveedorModificarActionPerformed

    private void cbxCategoriaModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCategoriaModificarMouseClicked
        // TODO add your handling code here:
     
    }//GEN-LAST:event_cbxCategoriaModificarMouseClicked

    private void cbxProveedorModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxProveedorModificarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxProveedorModificarMouseClicked

    private void cbxCategoriaModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCategoriaModificarMousePressed
        // TODO add your handling code here:
              cbxCategoriaModificar.removeAllItems();
            List<Categoria> listaCat = controladorCategoria.listar();
            for (Categoria cat : listaCat) {
                cbxCategoriaModificar.addItem(cat.getDescripcion());
            }
    }//GEN-LAST:event_cbxCategoriaModificarMousePressed

    private void cbxProveedorModificarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxProveedorModificarMousePressed
            cbxProveedorModificar.removeAllItems();
        List<Proveedor> listaProv = controladorProveedor.listar();
        for (Proveedor pro : listaProv) {
            cbxProveedorModificar.addItem(pro.getNombre());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProveedorModificarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cbxCategoriaModificar;
    private javax.swing.JComboBox<String> cbxProveedorModificar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtCodigoModificarBuscar;
    private javax.swing.JTextField txtCodigoModificarP;
    private javax.swing.JTextField txtDescripcionModificar;
    private javax.swing.JTextField txtPrecioModificar;
    // End of variables declaration//GEN-END:variables
}
