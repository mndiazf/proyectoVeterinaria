/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.eva3.cl.presentacion;

import com.eva3.cl.entidades.Mascota;
import com.eva3.cl.entidades.Raza;
import com.eva3.cl.negocio.negMascota;
import com.eva3.cl.negocio.negRaza;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manolo
 */
public class frmMantenedorMascotas extends javax.swing.JInternalFrame {
    private HashMap<String,Integer> razMascota = new HashMap<>();
    private SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    private negMascota nMascota = new negMascota();
    /**
     * Creates new form frmMantenedorMascotas
     */
    public frmMantenedorMascotas() {
        initComponents();
        llenaCombo();
    }
    private void llenaCombo()
    {
        negRaza nRaza = new negRaza();
        ArrayList<Raza> lRaza = nRaza.listarTodo();
        for(Raza raz: lRaza)
        {
            cbRaza.addItem(raz.getNombre_raza());
            razMascota.put(raz.getNombre_raza(), raz.getId_raza());
        }
    }
    
    private void llenarTabla()
    {
        
        ArrayList<Mascota> lMascota = nMascota.listarTodo();
        
        //Recursos para llenar la tabla
        DefaultTableModel modelo = (DefaultTableModel) tbListar.getModel();
        Object[] fila = new Object[5];
        for(Mascota mas: lMascota)
        {
            fila[0] = mas.getId_mascota();
            fila[1] = mas.getNombre_mascota();
            fila[2] = mas.getEspecie();
            fila[3] = mas.getRut_propietario();
            fila[4] = mas.getNombre_propietario();
            fila[5] = mas.getEdad();
            fila[6] = formato.format(mas.getFecha_inscripcion());
            fila[7] = mas.getNombre_raza();
            modelo.addRow(fila);
        }
        tbListar.setModel(modelo);
    }
    private void limpiar()
    {
        lblMasc.setText("");
        txtNombre.setText("");
        txtPropietario.setText("");
        txtNPropietario.setText("");
        txtEdad.setText("");
        cbRaza.setSelectedIndex(0);
        txtFechaIns.setText("");

    }
    private void refrescarTabla()
    {
        DefaultTableModel dm = (DefaultTableModel)tbListar.getModel();
        dm.getDataVector().removeAllElements();
        llenarTabla();
    }

    private void agregar()
    {
        try {

            String nombre = txtNombre.getText();
            String especie = buttonGroup1.getSelection().toString();
            String rut_propietario = txtPropietario.getText();
            String nombre_propietario = txtNPropietario.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            int id_raza = razMascota.get(cbRaza.getSelectedItem().toString());
            Date fecha_inscripcion = formato.parse(txtFechaIns.getText());
            Mascota mas = new Mascota();
            mas.setNombre_mascota(nombre);
            mas.setEspecie(especie);
            mas.setRut_propietario(rut_propietario);
            mas.setNombre_propietario(nombre_propietario);
            mas.setEdad(edad);
            mas.setId_raza(id_raza);
            if(nMascota.agregaMascota(mas))
            {
                JOptionPane.showMessageDialog(this, "La mascota ha sido agregada correctamente!");
                limpiar();
                refrescarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ups!! no se pudo agregar la mascota");
            }
        } catch (ParseException ex) {
            Logger.getLogger(frmMantenedorMascotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void modificar()
    {
        try {
            int id_mascota = Integer.parseInt(lblMasc.getText());
            String nombre = txtNombre.getText();
            String especie = buttonGroup1.getSelection().toString();
            String rut_propietario = txtPropietario.getText();
            String nombre_propietario = txtNPropietario.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            int id_raza = razMascota.get(cbRaza.getSelectedItem().toString());
            Date fecha_inscripcion = formato.parse(txtFechaIns.getText());
            Mascota mas = new Mascota();
            mas.setNombre_mascota(nombre);
            mas.setEspecie(especie);
            mas.setRut_propietario(rut_propietario);
            mas.setNombre_propietario(nombre_propietario);
            mas.setEdad(edad);
            mas.setId_raza(id_raza);
            if(nMascota.modificarMascota(mas))
            {
                JOptionPane.showMessageDialog(this, "La mascota ha sido modificada correctamente!");
                limpiar();
                refrescarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ups!! no se pudo modificar la mascota :C");
            }
        } catch (ParseException ex) {
            Logger.getLogger(frmMantenedorMascotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void eliminar()
    {
        try {
            int id_mascota = Integer.parseInt(lblMasc.getText());
            Mascota mas = new Mascota();
            mas.setId_mascota(id_mascota);
            if(nMascota.eliminarMascota(mas))
            {
                JOptionPane.showMessageDialog(this, "La mascota ha sido eliminada correctamente!");
                limpiar();
                refrescarTabla();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Ups!! no se pudo eliminar la mascota :C");
            }
        } catch (Exception ex) {
            Logger.getLogger(frmMantenedorMascotas.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtPropietario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbPerro = new javax.swing.JRadioButton();
        rbGato = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListar = new javax.swing.JTable();
        cbRaza = new javax.swing.JComboBox<>();
        txtFechaIns = new javax.swing.JTextField();
        btAgregar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btEliminar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNPropietario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblMasc = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel2.setText("Mantenedor Mascotas");

        jLabel1.setText("Nombre:");

        jLabel3.setText("Especie:");

        jLabel4.setText("Rut Propietario:");

        jLabel5.setText("Edad:");

        jLabel6.setText("Fecha de inscripcion:");

        jLabel7.setText("Raza:");

        buttonGroup1.add(rbPerro);
        rbPerro.setText("Perro");

        buttonGroup1.add(rbGato);
        rbGato.setText("Gato");

        tbListar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Especie", "Rut propietario", "Nombre propietario", "Edad", "Fecha de inscripcion", "Raza"
            }
        ));
        tbListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListar);

        cbRaza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbRaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRazaActionPerformed(evt);
            }
        });

        txtFechaIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInsActionPerformed(evt);
            }
        });

        btAgregar.setText("Agregar");
        btAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAgregarMouseClicked(evt);
            }
        });

        btModificar.setText("Modificar");
        btModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btModificarMouseClicked(evt);
            }
        });

        btEliminar.setText("Eliminar");
        btEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEliminarMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Listado de mascotas:");

        jLabel9.setText("Nombre propietario: ");

        jLabel10.setText("Id Masc:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(1, 1, 1))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(rbPerro)
                                .addGap(18, 18, 18)
                                .addComponent(rbGato))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(cbRaza, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(24, 24, 24)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEdad, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtFechaIns, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtNPropietario))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(154, 154, 154)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMasc)
                        .addGap(87, 87, 87))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(lblMasc)))
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rbPerro)
                            .addComponent(rbGato))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFechaIns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbRaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbRazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRazaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbRazaActionPerformed

    private void txtFechaInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInsActionPerformed

    private void btAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAgregarMouseClicked
        agregar();
    }//GEN-LAST:event_btAgregarMouseClicked

    private void btModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btModificarMouseClicked
        modificar();
    }//GEN-LAST:event_btModificarMouseClicked

    private void btEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEliminarMouseClicked
        eliminar();
    }//GEN-LAST:event_btEliminarMouseClicked

    private void tbListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListarMouseClicked
        int fila = tbListar.getSelectedRow();
        
        String id = tbListar.getModel().getValueAt(fila, 0).toString();
        String nombre = tbListar.getModel().getValueAt(fila, 1).toString();
        String especie = tbListar.getModel().getValueAt(fila, 2).toString();
        String rut_propietario = tbListar.getModel().getValueAt(fila, 3).toString();
        String nombre_propietario = tbListar.getModel().getValueAt(fila, 4).toString();
        String edad = tbListar.getModel().getValueAt(fila, 5).toString();
        String fecha_inscripcion = tbListar.getModel().getValueAt(fila, 6).toString();
        String raza = tbListar.getModel().getValueAt(fila, 7).toString();
        
        lblMasc.setText(id);
        txtNombre.setText(nombre);
        txtPropietario.setText(rut_propietario);
        txtNPropietario.setText(nombre_propietario);
        txtEdad.setText(edad);
        txtFechaIns.setText(fecha_inscripcion);
        cbRaza.setSelectedItem(raza);
    }//GEN-LAST:event_tbListarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregar;
    private javax.swing.JButton btEliminar;
    private javax.swing.JButton btModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbRaza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMasc;
    private javax.swing.JRadioButton rbGato;
    private javax.swing.JRadioButton rbPerro;
    private javax.swing.JTable tbListar;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtFechaIns;
    private javax.swing.JTextField txtNPropietario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPropietario;
    // End of variables declaration//GEN-END:variables
}
