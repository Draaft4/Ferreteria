package Vista;

import Controladores.ControladorFacturaCabecera;
import Modelo.FacturaCab;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class infFactura extends javax.swing.JInternalFrame {

    DefaultTableModel modelo2;
    ControladorFacturaCabecera controlCabecera;
    ArrayList<FacturaCab> listCabecera;

    public infFactura(ControladorFacturaCabecera controlCabecera) {
        initComponents();
        CrearModelo2();
        this.controlCabecera = controlCabecera;
        this.listCabecera = controlCabecera.getFacturaCab();
        actualizarTabla(listCabecera);
    }

    private void CrearModelo2() {
        //int id, String numero, Date fechaEmision, double subtotal, double desc, double IVA, double total, String anulado, Cliente cliente, MetodoPago metodoPago, ArrayList<FacturaDet> detalles
        try {
            modelo2 = (new DefaultTableModel(
                    null, new String[]{
                        "Codigo", "Numero", "Cliente",
                        "Fecha Emision", "Subtotal", "Descuento", "Iva", "Total", "Estado"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla1.setModel(modelo2);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

    public void actualizarTabla(ArrayList<FacturaCab> listCabecera) {
        /*
         "Codigo", "Numero","Cliente",
                        "Fecha Emision", "Subtotal", "Descuento", "Iva", "Total", "Estado"
        
         */
        Object O[] = null;

        for (int i = 0; i < listCabecera.size(); i++) {
            modelo2.addRow(O);

            FacturaCab getC = (FacturaCab) listCabecera.get(i);
            modelo2.setValueAt(getC.getId(), i, 0);
            modelo2.setValueAt(getC.getNumero(), i, 1);
            modelo2.setValueAt(getC.getCliente().getNombre() + " " + getC.getCliente().getApellido(), i, 2);
            modelo2.setValueAt(getC.getFechaEmision(), i, 3);
            modelo2.setValueAt(getC.getSubtotal(), i, 4);
            modelo2.setValueAt(getC.getDesc(), i, 5);
            modelo2.setValueAt(getC.getIVA(), i, 6);
            modelo2.setValueAt(getC.getTotal(), i, 7);
            if (getC.getAnulado() == null) {
                modelo2.setValueAt("Activo", i, 8);
            } else {
                modelo2.setValueAt(getC.getAnulado(), i, 8);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtBusqueda = new javax.swing.JTextField();
        radioNumero = new javax.swing.JRadioButton();
        radioNom = new javax.swing.JRadioButton();
        dcFechaEmi = new com.toedter.calendar.JDateChooser();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Informe Facturas");

        buttonGroup1.add(radioNumero);
        radioNumero.setText("Num. Factura");
        radioNumero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radioNumeroFocusGained(evt);
            }
        });

        buttonGroup1.add(radioNom);
        radioNom.setText("Nom. Cliente");
        radioNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                radioNomFocusGained(evt);
            }
        });
        radioNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioNomActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        jButton1.setText("Visualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBusqueda)
                        .addGap(18, 18, 18)
                        .addComponent(radioNumero)
                        .addGap(18, 18, 18)
                        .addComponent(radioNom)
                        .addGap(18, 18, 18)
                        .addComponent(dcFechaEmi, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioNumero)
                            .addComponent(radioNom)))
                    .addComponent(dcFechaEmi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioNomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radioNomFocusGained
        radioNumero.setSelected(false);
    }//GEN-LAST:event_radioNomFocusGained

    private void radioNumeroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_radioNumeroFocusGained
        radioNom.setSelected(false);
    }//GEN-LAST:event_radioNumeroFocusGained

    private void radioNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioNomActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        CrearModelo2();
        String busqueda = txtBusqueda.getText();

        if (busqueda.equals("")) {
            JOptionPane.showMessageDialog(null, "No dejar campos vacíos");
        } else {
            if (radioNumero.isSelected()) {
                actualizarTabla(controlCabecera.buscar(busqueda, 1));
            } else {
                if (radioNom.isSelected()) {
                    actualizarTabla(controlCabecera.buscar(busqueda, 2));
                }
            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int fila = tabla1.getSelectedRow();
        String codigo = tabla1.getValueAt(fila, 0) + "";
        for (FacturaCab facturaCab : listCabecera) {
            if (codigo.equals(facturaCab.getId() + "")) {
                viewFact wosFact = new viewFact(facturaCab);
                wosFact.setVisible(true);
                wosFact.setLocationRelativeTo(null);
                break;
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dcFechaEmi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioNom;
    private javax.swing.JRadioButton radioNumero;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
