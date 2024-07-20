/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import MODELO.MueblesClase;
import MODELO.MueblesDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Propietario
 */
public class Muebles extends javax.swing.JFrame {

    MueblesClase mb = new MueblesClase();
    MueblesDAO touch = new MueblesDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    public Muebles() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
        Listar();
    }

    public void Vaciar(){
        codigo.setText("");
        NomMueble.setText("");
        CodCategoria.setText("");
        MaterialMueble.setText("");
        pressMueble.setText("");
        StokMueble.setText("");
    }
    
    public void LimpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void Listar(){
        List<MueblesClase> Lista = touch.Listar();
        modelo = (DefaultTableModel) TbMueble.getModel();
        Object[] ob = new Object[6];
        for (int i = 0; i < Lista.size(); i++){
            ob[0] = Lista.get(i).getCod_categ_fk();
            ob[1] = Lista.get(i).getNom_mueble();
            ob[2] = Lista.get(i).getCod_categ_fk();
            ob[3] = Lista.get(i).getMater_mueble();
            ob[4] = Lista.get(i).getPresi_mueble();
            ob[5] = Lista.get(i).getStok_mueble();
            modelo.addRow(ob);
        }
        TbMueble.setModel(modelo);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Cerrar = new javax.swing.JButton();
        Venta = new javax.swing.JButton();
        Mueble = new javax.swing.JButton();
        Categoria = new javax.swing.JButton();
        Pedidos = new javax.swing.JButton();
        Clientes = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        NomMueble = new javax.swing.JTextField();
        MaterialMueble = new javax.swing.JTextField();
        pressMueble = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbMueble = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        CodCategoria = new javax.swing.JTextField();
        VaciarTxt = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        StokMueble = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(55, 160, 244));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MUEBLES");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(970, 20, 160, 48);

        Cerrar.setBackground(new java.awt.Color(55, 160, 244));
        Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        Cerrar.setText("CERRAR SESIÓN");
        jPanel2.add(Cerrar);
        Cerrar.setBounds(1180, 20, 140, 50);

        Venta.setBackground(new java.awt.Color(55, 160, 244));
        Venta.setForeground(new java.awt.Color(255, 255, 255));
        Venta.setText("VENTAS");
        jPanel2.add(Venta);
        Venta.setBounds(50, 20, 110, 50);

        Mueble.setBackground(new java.awt.Color(55, 160, 244));
        Mueble.setForeground(new java.awt.Color(255, 255, 255));
        Mueble.setText("MUEBLES");
        jPanel2.add(Mueble);
        Mueble.setBounds(170, 20, 110, 50);

        Categoria.setBackground(new java.awt.Color(55, 160, 244));
        Categoria.setForeground(new java.awt.Color(255, 255, 255));
        Categoria.setText("CATEGORIA");
        Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(Categoria);
        Categoria.setBounds(290, 20, 110, 50);

        Pedidos.setBackground(new java.awt.Color(55, 160, 244));
        Pedidos.setForeground(new java.awt.Color(255, 255, 255));
        Pedidos.setText("PEDIDOS");
        jPanel2.add(Pedidos);
        Pedidos.setBounds(410, 20, 110, 50);

        Clientes.setBackground(new java.awt.Color(55, 160, 244));
        Clientes.setForeground(new java.awt.Color(255, 255, 255));
        Clientes.setText("CLIENTES");
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });
        jPanel2.add(Clientes);
        Clientes.setBounds(530, 20, 110, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1360, 90);

        jLabel6.setText("©2024SamuelRueda. Todos los derechos reservados");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 660, 290, 16);

        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(55, 160, 244)));
        jPanel1.add(jTextField1);
        jTextField1.setBounds(170, 330, 410, 50);

        jButton1.setBackground(new java.awt.Color(55, 160, 244));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Iconos/search.png"))); // NOI18N
        jPanel1.add(jButton1);
        jButton1.setBounds(100, 330, 50, 50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("CODIGO DEL MUEBLE:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(640, 100, 210, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("NOMBRE DEL MUEBLE:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(640, 150, 210, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("MATERIAL DEL MUEBLE:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(640, 250, 210, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("PRESIO DEL MUEBLE:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(640, 300, 210, 40);

        codigo.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(codigo);
        codigo.setBounds(880, 100, 270, 40);

        NomMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(NomMueble);
        NomMueble.setBounds(880, 150, 270, 40);

        MaterialMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(MaterialMueble);
        MaterialMueble.setBounds(880, 250, 270, 40);

        pressMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(pressMueble);
        pressMueble.setBounds(880, 300, 270, 40);

        guardar.setBackground(new java.awt.Color(55, 160, 244));
        guardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("GUARDAR");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar);
        guardar.setBounds(1180, 160, 130, 50);

        eliminar.setBackground(new java.awt.Color(55, 160, 244));
        eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("ELIMINAR");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar);
        eliminar.setBounds(1180, 280, 130, 50);

        modificar.setBackground(new java.awt.Color(55, 160, 244));
        modificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        modificar.setForeground(new java.awt.Color(255, 255, 255));
        modificar.setText("MODIFICAR");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel1.add(modificar);
        modificar.setBounds(1180, 220, 130, 50);

        TbMueble.setAutoCreateRowSorter(true);
        TbMueble.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TbMueble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "COD CATEGORIA", "MATERIAL", "PRESIO", "STOK"
            }
        ));
        TbMueble.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TbMueble.setGridColor(new java.awt.Color(204, 204, 204));
        TbMueble.setRowHeight(35);
        TbMueble.setSelectionBackground(new java.awt.Color(85, 183, 252));
        TbMueble.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TbMueble.setShowGrid(true);
        TbMueble.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbMuebleMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbMueble);
        if (TbMueble.getColumnModel().getColumnCount() > 0) {
            TbMueble.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(60, 410, 1260, 240);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("CODIGO DE LA CATEGORIA:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(640, 200, 210, 40);

        CodCategoria.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(CodCategoria);
        CodCategoria.setBounds(880, 200, 270, 40);

        VaciarTxt.setBackground(new java.awt.Color(55, 160, 244));
        VaciarTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VaciarTxt.setForeground(new java.awt.Color(255, 255, 255));
        VaciarTxt.setText("VACIAR");
        VaciarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VaciarTxtActionPerformed(evt);
            }
        });
        jPanel1.add(VaciarTxt);
        VaciarTxt.setBounds(1180, 340, 130, 50);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("STOK DEL MUEBLE:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(640, 350, 210, 40);

        StokMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(StokMueble);
        StokMueble.setBounds(880, 350, 270, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1360, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        Clientes cl = new Clientes();
        cl.setVisible(true);
        dispose();
    }//GEN-LAST:event_ClientesActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        if(!"".equals(codigo.getText()) || !"".equals(NomMueble.getText()) || !"".equals(CodCategoria.getText()) || !"".equals(MaterialMueble.getText()) || !"".equals(pressMueble.getText()) || !"".equals(StokMueble.getText())){
            mb.setCod_mueble(Integer.parseInt(codigo.getText()));
            mb.setNom_mueble(NomMueble.getText());
            mb.setCod_categ_fk(Integer.parseInt(CodCategoria.getText()));
            mb.setMater_mueble(MaterialMueble.getText());
            mb.setPresi_mueble(Integer.parseInt(pressMueble.getText()));
            mb.setStok_mueble(Integer.parseInt(StokMueble.getText()));
            touch.Registrar(mb);
            JOptionPane.showMessageDialog(null, "Mueble Registrado");
            LimpiarTabla();
            Listar();
            Vaciar();
        }
        else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacion");
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(!"".equals(codigo.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este mueble?");
            if(pregunta == 0){
                int cod = Integer.parseInt(codigo.getText());
                
                if (touch.Eliminar(cod)) {
                    JOptionPane.showMessageDialog(null, "Mueble eliminado");
                    LimpiarTabla();
                    Vaciar();
                    Listar();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: El mueble no fue eliminado");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Seleccion un mueble");
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if("".equals(codigo.getText())){
           JOptionPane.showMessageDialog(null, "Selecciones un usuario");
        }
        else{
            mb.setCod_mueble(Integer.parseInt(codigo.getText()));
            mb.setNom_mueble(NomMueble.getText());
            mb.setCod_categ_fk(Integer.parseInt(CodCategoria.getText()));
            mb.setMater_mueble(MaterialMueble.getText());
            mb.setPresi_mueble(Double.parseDouble(pressMueble.getText()));
            mb.setStok_mueble(Integer.parseInt(StokMueble.getText()));
            if(!"".equals(codigo.getText()) || !"".equals(NomMueble.getText()) || !"".equals(CodCategoria.getText()) || !"".equals(MaterialMueble.getText()) || !"".equals(pressMueble.getText()) || !"".equals(StokMueble.getText())){
                touch.Modificar(mb);
                LimpiarTabla();
                Vaciar();
                Listar();
            }
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void TbMuebleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbMuebleMouseClicked
       int fila = TbMueble.rowAtPoint(evt.getPoint());
        codigo.setText(TbMueble.getValueAt(fila, 0).toString());
        NomMueble.setText(TbMueble.getValueAt(fila, 1).toString());
        CodCategoria.setText(TbMueble.getValueAt(fila, 2).toString());
        MaterialMueble.setText(TbMueble.getValueAt(fila, 3).toString());
        pressMueble.setText(TbMueble.getValueAt(fila, 4).toString());
        StokMueble.setText(TbMueble.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TbMuebleMouseClicked

    private void VaciarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarTxtActionPerformed
        Vaciar();
    }//GEN-LAST:event_VaciarTxtActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        Categoria ct = new Categoria();
        ct.setVisible(true);
        dispose();
    }//GEN-LAST:event_CategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(Muebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Muebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Muebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Muebles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Muebles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Categoria;
    private javax.swing.JButton Cerrar;
    private javax.swing.JButton Clientes;
    private javax.swing.JTextField CodCategoria;
    private javax.swing.JTextField MaterialMueble;
    private javax.swing.JButton Mueble;
    private javax.swing.JTextField NomMueble;
    private javax.swing.JButton Pedidos;
    private javax.swing.JTextField StokMueble;
    private javax.swing.JTable TbMueble;
    private javax.swing.JButton VaciarTxt;
    private javax.swing.JButton Venta;
    private javax.swing.JTextField codigo;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField pressMueble;
    // End of variables declaration//GEN-END:variables
}
