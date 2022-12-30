/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.dao.AutoDao;
import controlador.dao.CasaDao;
import controlador.dao.GatoDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Tabla.ModeloTablaAuto;
import vista.Tabla.ModeloTablaCasa;
import vista.Tabla.ModeloTablaGato;
import vistas.Tabla.ModeloTablaNumero;

/**
 *
 * @author SONY VAIO
 */
public class FrmClases extends javax.swing.JDialog {

    private AutoDao autoDao = new AutoDao();
    private CasaDao casaDao = new CasaDao();
    private GatoDao gatoDao = new GatoDao();
    private ModeloTablaAuto mta = new ModeloTablaAuto();
    private ModeloTablaCasa mtc = new ModeloTablaCasa();
    private ModeloTablaGato mtg = new ModeloTablaGato();

    /**
     * Creates new form FrmClases
     */
    public FrmClases(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void cargarTabla() {
//        if (cbxClases.getSelectedIndex() == 0) {
//            jTable1.setModel(mta);
//        }
//        if (cbxClases.getSelectedIndex() == 1) {
//            jTable1.setModel(mtc);
//        }
//        if (cbxClases.getSelectedIndex() == 2) {
//            jTable1.setModel(mtg);
//        }

        jTable1.updateUI();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbxMetodoOrdenamiento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbxTipoOrdenamiento = new javax.swing.JComboBox<>();
        cbxClases = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxMetodoBusqueda = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtCampo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pestania de Clases");

        jLabel2.setText("Clase");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setText("Metodo");

        cbxMetodoOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "SHELL", "QUICKSORT" }));
        cbxMetodoOrdenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMetodoOrdenamientoActionPerformed(evt);
            }
        });

        jLabel5.setText("Ordenar");

        cbxTipoOrdenamiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "ASCENDENTE", "DESCENDENTE" }));
        cbxTipoOrdenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoOrdenamientoActionPerformed(evt);
            }
        });

        cbxClases.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auto", "Casa", "Gato" }));
        cbxClases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxClasesActionPerformed(evt);
            }
        });

        jLabel3.setText("Campo");

        txtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldActionPerformed(evt);
            }
        });

        jButton1.setText("Ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("Nombre a buscar: ");

        jLabel7.setText("Metodo Busqueda : ");

        cbxMetodoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "SECUENCIAL", "LINEAL BINARIA" }));
        cbxMetodoBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMetodoBusquedaActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("Campo");

        txtCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCampoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jLabel1))
                .addGap(225, 225, 225))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(cbxClases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbxMetodoOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxTipoOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cbxMetodoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbxClases, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxMetodoOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(cbxTipoOrdenamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbxMetodoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMetodoOrdenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMetodoOrdenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMetodoOrdenamientoActionPerformed

    public void ordenar() {
        Integer tipoOrdenacion = cbxTipoOrdenamiento.getSelectedIndex();
        String field = txtField.getText();
        if (tipoOrdenacion == 0 && cbxMetodoOrdenamiento.getSelectedIndex() == 0) {
            cargarTabla();
        }
        try {
            Integer metodoOrdenacion = cbxMetodoOrdenamiento.getSelectedIndex();
            if (cbxMetodoOrdenamiento.getSelectedIndex() == 0 || field == null) {
                if (cbxClases.getSelectedIndex() == 0) {
                    mta.setLista(autoDao.listar());
                    jTable1.setModel(mta);
                    jTable1.updateUI();
                }
                if (cbxClases.getSelectedIndex() == 1) {
                    mtc.setLista(casaDao.listar());
                    jTable1.setModel(mtc);
                    jTable1.updateUI();
                }
                if (cbxClases.getSelectedIndex() == 2) {
                    mtg.setLista(gatoDao.listar());
                    jTable1.setModel(mtg);
                    jTable1.updateUI();
                }
            }
            if (metodoOrdenacion == 1) {
                if (cbxClases.getSelectedIndex() == 0) {
                    mta.setLista(autoDao.listar().ordenamientoShell(field, cbxTipoOrdenamiento.getSelectedIndex()));
                    jTable1.setModel(mta);
                    jTable1.updateUI();
                }
                if (cbxClases.getSelectedIndex() == 1) {
                    mtc.setLista(casaDao.listar().ordenamientoShell(field, cbxTipoOrdenamiento.getSelectedIndex()));
                    jTable1.setModel(mtc);
                    jTable1.updateUI();
                }
                if (cbxClases.getSelectedIndex() == 2) {
                    mtg.setLista(gatoDao.listar().ordenamientoShell(field, cbxTipoOrdenamiento.getSelectedIndex()));
                    jTable1.setModel(mtg);
                    jTable1.updateUI();
                }
            }
            if (metodoOrdenacion == 2) {
                if (cbxClases.getSelectedIndex() == 0) {
                    mta.setLista(autoDao.listar().ordenamientoQuickSort(field, cbxTipoOrdenamiento.getSelectedIndex()));
                    jTable1.setModel(mta);
                    jTable1.updateUI();
                }
                if (cbxClases.getSelectedIndex() == 1) {
                    mtc.setLista(casaDao.listar().ordenamientoQuickSort(field, cbxTipoOrdenamiento.getSelectedIndex()));
                    jTable1.setModel(mtc);
                    jTable1.updateUI();
                }
                if (cbxClases.getSelectedIndex() == 2) {
                    mtg.setLista(gatoDao.listar().ordenamientoQuickSort(field, cbxTipoOrdenamiento.getSelectedIndex()));
                    jTable1.setModel(mtg);
                    jTable1.updateUI();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void cbxClasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxClasesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxClasesActionPerformed

    private void cbxTipoOrdenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoOrdenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipoOrdenamientoActionPerformed

    private void txtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ordenar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void cbxMetodoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMetodoBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMetodoBusquedaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            buscar();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCampoActionPerformed

    public void buscar() throws Exception{
        String campo = txtCampo.getText();
        String nombre = txtBuscar.getText();
        Integer tipoBusqueda = cbxMetodoBusqueda.getSelectedIndex();
        Integer tipoClase = cbxClases.getSelectedIndex();

        if (tipoClase == 0) {
            if (tipoBusqueda == 0) {
                mta.setLista(autoDao.listar());
                jTable1.setModel(mta);
                jTable1.updateUI();
            }
            if (tipoBusqueda == 1) {
                mta.setLista(autoDao.listar().busquedaSecuencial(campo, nombre));
                jTable1.setModel(mta);
                jTable1.updateUI();
            }
            if (tipoBusqueda == 2) {
                mta.setLista(autoDao.listar().busquedaLinealBinaria(campo, nombre));
                jTable1.setModel(mta);
                jTable1.updateUI();
            }
        }
        if (tipoClase == 1) {
            if (tipoBusqueda == 0) {
                mtc.setLista(casaDao.listar());
                jTable1.setModel(mta);
                jTable1.updateUI();
            }
            if (tipoBusqueda == 1) {
                mtc.setLista(casaDao.listar().busquedaSecuencial(campo, nombre));
                jTable1.setModel(mtc);
                jTable1.updateUI();
            }
            if (tipoBusqueda == 2) {
                mtc.setLista(casaDao.listar().busquedaLinealBinaria(campo, nombre));
                jTable1.setModel(mtc);
                jTable1.updateUI();
            }
        }
        if (tipoClase == 2) {
            if (tipoBusqueda == 0) {
                mtg.setLista(gatoDao.listar());
                jTable1.setModel(mtg);
                jTable1.updateUI();
            }
            if (tipoBusqueda == 1) {
                mtg.setLista(gatoDao.listar().busquedaSecuencial(campo, nombre));
                jTable1.setModel(mtg);
                jTable1.updateUI();
            }
            if (tipoBusqueda == 2) {
                mtg.setLista(gatoDao.listar().busquedaLinealBinaria(campo, nombre));
                jTable1.setModel(mtg);
                jTable1.updateUI();
            }
        }

    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmClases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmClases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmClases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmClases.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmClases dialog = new FrmClases(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxClases;
    private javax.swing.JComboBox<String> cbxMetodoBusqueda;
    private javax.swing.JComboBox<String> cbxMetodoOrdenamiento;
    private javax.swing.JComboBox<String> cbxTipoOrdenamiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCampo;
    private javax.swing.JTextField txtField;
    // End of variables declaration//GEN-END:variables
}