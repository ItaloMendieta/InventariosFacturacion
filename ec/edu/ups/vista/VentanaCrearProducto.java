/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Inventario;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.modelo.Proveedor;
import ec.edu.ups.controlador.ControladorCategoria;
import ec.edu.ups.controlador.ControladorInventario;
import ec.edu.ups.controlador.ControladorProducto;
import ec.edu.ups.controlador.ControladorProveedor;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class VentanaCrearProducto extends javax.swing.JInternalFrame {

    private VentanaBuscarProducto ventanaBuscarProducto;
    private ControladorProducto controladorProducto;
    private ControladorCategoria controladorCategoria;
    private ControladorProveedor controladorProveedor;
    private ControladorInventario controladorInventario;

    public VentanaCrearProducto(VentanaBuscarProducto vp) {
        initComponents();
        vp = ventanaBuscarProducto;
        controladorProducto = new ControladorProducto();
        controladorCategoria = new ControladorCategoria();
        controladorProveedor = new ControladorProveedor();
        controladorInventario = new ControladorInventario();
        List<Categoria> lista = controladorCategoria.listar();
        for (Categoria p : lista) {
            cbxCategoriaIns.addItem(p.getDescripcion());
        }
        List<Proveedor> listaProv = controladorProveedor.listar();
        for (Proveedor prov : listaProv) {
            cbxProveedorIns.addItem(prov.getNombre());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcionIns = new javax.swing.JTextField();
        btnCrearProducto = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtPrecioInser = new javax.swing.JTextField();
        cbxCategoriaIns = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxProveedorIns = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Agregar Producto");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Descripcion");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Precio");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Categoria");

        btnCrearProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/recursos/agregar.png"))); // NOI18N
        btnCrearProducto.setText("Crear");
        btnCrearProducto.setToolTipText("");
        btnCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProductoActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/recursos/canselar.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbxCategoriaIns.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cbxCategoriaInsComponentAdded(evt);
            }
        });
        cbxCategoriaIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxCategoriaInsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbxCategoriaInsMousePressed(evt);
            }
        });
        cbxCategoriaIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaInsActionPerformed(evt);
            }
        });
        cbxCategoriaIns.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbxCategoriaInsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbxCategoriaInsKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Proveedor");

        cbxProveedorIns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxProveedorInsMouseClicked(evt);
            }
        });
        cbxProveedorIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedorInsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnCrearProducto)
                        .addGap(37, 37, 37)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrecioInser)
                            .addComponent(txtDescripcionIns)
                            .addComponent(cbxCategoriaIns, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxProveedorIns, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcionIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecioInser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxCategoriaIns, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxProveedorIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearProducto)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductoActionPerformed
        // TODO add your handling code here:
        Producto p = new Producto();
        p.setId(controladorProducto.obtenerCodigo());
        controladorProducto.conexion();
        p.setDescripcion(txtDescripcionIns.getText());
        //p.setDescuento();
        String cate = (String) cbxCategoriaIns.getSelectedItem();
        String prove = (String) cbxProveedorIns.getSelectedItem();
        System.out.println("aa " + cate);
        Categoria c = controladorCategoria.BuscarCategoriaNombre(cate);
        Proveedor proveedor = controladorProveedor.buscarP(prove);
        p.setCategoria(c);
        p.setProveedor(proveedor);
        p.setPrecio(Double.valueOf(txtPrecioInser.getText()));
        String codigo=controladorProducto.Codigo(txtDescripcionIns.getText(), cate);
        p.setCodigo(codigo);
        controladorProducto.registrarProducto(p);
        controladorProducto.desconectar();
        System.out.println("p: "+p.getId());
        System.out.println("codigo "+p.getCodigo());
        String codIngresado = controladorProducto.BuscarProducto(p.getId()).getCodigo();
        System.out.println("ss "+codIngresado);
        if(codIngresado.equalsIgnoreCase(p.getCodigo())){
            System.out.println("ingreso");
        Inventario inventario = new Inventario();
        inventario.setProducto(p);
        inventario.setPrecioEntrada(p.getPrecio());
        inventario.setId(controladorInventario.obtenerCodigo());

        controladorInventario.conexion();
        controladorInventario.registrarInventario(inventario);
        controladorInventario.desconectar();
        }
       // txtCodigoInsertar.setText(String.valueOf(controladorProducto.obtenerCodigo()));
        txtDescripcionIns.setText("");
        txtPrecioInser.setText("");
        
    }//GEN-LAST:event_btnCrearProductoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbxCategoriaInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaInsActionPerformed
        // TODO add your handling code here:
         try {
            String txt = (String) cbxCategoriaIns.getSelectedItem();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxCategoriaInsActionPerformed

    private void cbxProveedorInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedorInsActionPerformed
        // TODO add your handling code here:
        try {
            String txt = (String) cbxProveedorIns.getSelectedItem();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbxProveedorInsActionPerformed

    private void cbxCategoriaInsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxCategoriaInsKeyPressed
  
    
    }//GEN-LAST:event_cbxCategoriaInsKeyPressed

    private void cbxCategoriaInsComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cbxCategoriaInsComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaInsComponentAdded

    private void cbxCategoriaInsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbxCategoriaInsKeyReleased
        // TODO add your handling code here:
 
    }//GEN-LAST:event_cbxCategoriaInsKeyReleased

    private void cbxCategoriaInsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCategoriaInsMouseClicked
        // TODO add your handling code here:
                     cbxCategoriaIns.removeAllItems();
        List<Categoria> lista = controladorCategoria.listar();
        for (Categoria p : lista) {
            cbxCategoriaIns.addItem(p.getDescripcion());
        }
    }//GEN-LAST:event_cbxCategoriaInsMouseClicked

    private void cbxProveedorInsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxProveedorInsMouseClicked
        // TODO add your handling code here:
           cbxProveedorIns.removeAllItems();
        List<Proveedor> listaProv = controladorProveedor.listar();
        for (Proveedor pro : listaProv) {
            cbxProveedorIns.addItem(pro.getNombre());
        }
    }//GEN-LAST:event_cbxProveedorInsMouseClicked

    private void cbxCategoriaInsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCategoriaInsMousePressed
           cbxProveedorIns.removeAllItems();
        List<Proveedor> listaProv = controladorProveedor.listar();
        for (Proveedor pro : listaProv) {
            cbxProveedorIns.addItem(pro.getNombre());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaInsMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearProducto;
    private javax.swing.JComboBox<String> cbxCategoriaIns;
    private javax.swing.JComboBox<String> cbxProveedorIns;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescripcionIns;
    private javax.swing.JTextField txtPrecioInser;
    // End of variables declaration//GEN-END:variables
}
