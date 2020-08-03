package Vista;

import Controladores.ControladorCategorias;
import Controladores.ControladorCliente;
import Controladores.ControladorFacturaCabecera;
import Controladores.ControladorFacturaDetalles;
import Controladores.ControladorKardexCabecera;
import Controladores.ControladorKardexDetalles;
import Controladores.ControladorMetodoPago;
import Controladores.ControladorProductos;
import Controladores.ControladorTarjeta;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    int NivelAcceso;
    Facturacion viewFacturacion;
    infFactura viewInfFactura;
    adminProductos viewProductos;
    AdministracionClientes viewClientes;
    VentanaKardex viewKardex;
    ControladorCliente controlCliente;
    ControladorCategorias controlCategoria;
    ControladorProductos controlProducto;
    ControladorTarjeta controlTarjeta;
    ControladorMetodoPago controlMetodoPago;
    ControladorFacturaCabecera controlFacturaCabecera;
    ControladorKardexCabecera controlKardexCabecera;
    ControladorFacturaDetalles controlFacturaDetalles;
    ControladorKardexDetalles controlKardexDetalle;

    public VentanaPrincipal(int nivelAcceso) {

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Sistema Adiscom");

        controlCliente = new ControladorCliente();
        controlCategoria = new ControladorCategorias();
        controlProducto = new ControladorProductos(controlCategoria.getCategoria());
        controlTarjeta = new ControladorTarjeta();
        controlMetodoPago = new ControladorMetodoPago(controlTarjeta.getTarjetaCredito());
        controlFacturaDetalles = new ControladorFacturaDetalles(controlProducto.getProducto());
        controlFacturaCabecera = new ControladorFacturaCabecera(controlCliente.getCliente(), controlMetodoPago.getMetodoPago(), controlFacturaDetalles.getListDetalle());
        controlKardexDetalle = new ControladorKardexDetalles();
        controlKardexCabecera = new ControladorKardexCabecera(controlKardexDetalle.getListKardexDet());
        this.NivelAcceso = nivelAcceso;
        viewFacturacion = new Facturacion(controlCliente, controlFacturaCabecera, controlProducto, controlTarjeta, controlMetodoPago, controlKardexCabecera, controlFacturaDetalles);
        viewInfFactura = new infFactura(controlFacturaCabecera);
        viewProductos = new adminProductos(controlProducto, controlCategoria, controlKardexCabecera);
        viewClientes = new AdministracionClientes(controlCliente);
        viewKardex = new VentanaKardex(controlProducto, controlKardexCabecera);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        esc = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escLayout = new javax.swing.GroupLayout(esc);
        esc.setLayout(escLayout);
        escLayout.setHorizontalGroup(
            escLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        escLayout.setVerticalGroup(
            escLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jMenu1.setText("Facturacion");

        jMenuItem1.setText("Nueva Factura...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Informe Facturas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Inventario");

        jMenuItem3.setText("Administracion Productos");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Kardex");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Clientes");

        jMenuItem6.setText("Administracion de Clientes");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(esc)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(esc)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    Nivel de acceso 1= Administrador
    Nivel de acceso 2 = Cajera
    Nivel de acceso 3 = bodega
    Nivel de acceso 4 = contabilidad
    
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (NivelAcceso == 1 || NivelAcceso == 2 || NivelAcceso == 4) {
            esc.add(viewFacturacion);
            viewFacturacion.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No tiene acceso a esta ventana ");
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (NivelAcceso == 1 || NivelAcceso == 2 || NivelAcceso == 4) {
            esc.add(viewInfFactura);
            viewInfFactura.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No tiene acceso a esta ventana ");
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (NivelAcceso == 1 || NivelAcceso == 3 || NivelAcceso == 4) {
            esc.add(viewProductos);
            viewProductos.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No tiene acceso a esta ventana ");
        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (NivelAcceso == 1 || NivelAcceso == 2 || NivelAcceso == 4) {
            esc.add(viewClientes);
            viewClientes.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No tiene acceso a esta ventana ");
        }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (NivelAcceso == 1 || NivelAcceso == 4) {
            esc.add(viewKardex);
            viewKardex.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No tiene acceso a esta ventana ");
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane esc;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
