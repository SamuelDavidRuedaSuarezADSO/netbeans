/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import MODELO.CategoriaClase;
import MODELO.CategoriaDAO;
import MODELO.MueblesClase;
import MODELO.MueblesDAO;
import MODELO.VentaClase;
import MODELO.VentaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Propietario
 */
public class Ventas extends javax.swing.JFrame {

    VentaDAO sells = new VentaDAO();
    VentaClase sl = new VentaClase();
    MueblesDAO touch = new MueblesDAO();
    CategoriaDAO categ = new CategoriaDAO();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
        sells.ConsultarCliente(codClient);
        sells.ConsultarEmpleado(codEmple);
    }
    
    public void Vaciar(){
        nomMueble.setText("");
        categMueble.setText("");
        stokMueble.setText("");
        materialMueble.setText("");
        pressMueble.setText("");
        search.setText("");
        cant.setValue(0);
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
        clores = new javax.swing.JButton();
        register = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        guardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbMueble = new javax.swing.JTable();
        VaciarTxt = new javax.swing.JButton();
        codClient = new javax.swing.JComboBox<>();
        codEmple = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        materialMueble = new javax.swing.JTextField();
        cant = new javax.swing.JSpinner();
        nomMueble = new javax.swing.JTextField();
        categMueble = new javax.swing.JTextField();
        stokMueble = new javax.swing.JTextField();
        search = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        pressMueble = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(55, 160, 244));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENTAS");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(1030, 20, 140, 48);

        Cerrar.setBackground(new java.awt.Color(55, 160, 244));
        Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        Cerrar.setText("CERRAR SESIÓN");
        jPanel2.add(Cerrar);
        Cerrar.setBounds(1180, 20, 140, 50);

        Venta.setBackground(new java.awt.Color(55, 160, 244));
        Venta.setForeground(new java.awt.Color(255, 255, 255));
        Venta.setText("VENTAS");
        Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentaActionPerformed(evt);
            }
        });
        jPanel2.add(Venta);
        Venta.setBounds(50, 20, 110, 50);

        Mueble.setBackground(new java.awt.Color(55, 160, 244));
        Mueble.setForeground(new java.awt.Color(255, 255, 255));
        Mueble.setText("MUEBLES");
        Mueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MuebleActionPerformed(evt);
            }
        });
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
        Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedidosActionPerformed(evt);
            }
        });
        jPanel2.add(Pedidos);
        Pedidos.setBounds(530, 20, 110, 50);

        Clientes.setBackground(new java.awt.Color(55, 160, 244));
        Clientes.setForeground(new java.awt.Color(255, 255, 255));
        Clientes.setText("CLIENTES");
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });
        jPanel2.add(Clientes);
        Clientes.setBounds(650, 20, 110, 50);

        clores.setBackground(new java.awt.Color(55, 160, 244));
        clores.setForeground(new java.awt.Color(255, 255, 255));
        clores.setText("COLORES");
        clores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cloresActionPerformed(evt);
            }
        });
        jPanel2.add(clores);
        clores.setBounds(410, 20, 110, 50);

        register.setBackground(new java.awt.Color(55, 160, 244));
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("REGISTRAR");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel2.add(register);
        register.setBounds(770, 20, 110, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1360, 90);

        jLabel6.setText("©2024SamuelRueda. Todos los derechos reservados");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 750, 290, 16);

        guardar.setBackground(new java.awt.Color(55, 160, 244));
        guardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("AÑADIR");
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

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(60, 410, 1260, 240);

        VaciarTxt.setBackground(new java.awt.Color(55, 160, 244));
        VaciarTxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        VaciarTxt.setForeground(new java.awt.Color(255, 255, 255));
        VaciarTxt.setText("VACIAR");
        VaciarTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VaciarTxtMouseClicked(evt);
            }
        });
        VaciarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VaciarTxtActionPerformed(evt);
            }
        });
        jPanel1.add(VaciarTxt);
        VaciarTxt.setBounds(1180, 340, 130, 50);

        codClient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un cliente..." }));
        codClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(codClient);
        codClient.setBounds(330, 190, 250, 40);

        codEmple.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un empleado..." }));
        codEmple.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        codEmple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codEmpleActionPerformed(evt);
            }
        });
        jPanel1.add(codEmple);
        codEmple.setBounds(330, 140, 250, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("NOMBRE DEL CLIENTE:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 190, 190, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("NOMBRE DEL EMPLEADO:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(130, 140, 190, 30);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("NOMBRE DEL MUEBLE:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(680, 110, 190, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("CATEGORIA DEL MUEBLE:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(680, 160, 190, 30);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("CATIDAD DESEADA:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(680, 360, 190, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("STOK DEL MUEBLE:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(680, 210, 190, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("MATERIAL DEL MUEBLE:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(680, 260, 190, 30);

        materialMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(materialMueble);
        materialMueble.setBounds(880, 250, 250, 40);

        cant.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(cant);
        cant.setBounds(880, 350, 250, 40);

        nomMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(nomMueble);
        nomMueble.setBounds(880, 100, 250, 40);

        categMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(categMueble);
        categMueble.setBounds(880, 150, 250, 40);

        stokMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(stokMueble);
        stokMueble.setBounds(880, 200, 250, 40);

        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 160, 244), 3), "Buscar por codigo...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(60, 320, 400, 70);

        buscar.setBackground(new java.awt.Color(55, 160, 244));
        buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar);
        buscar.setBounds(470, 340, 130, 50);

        pressMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(pressMueble);
        pressMueble.setBounds(880, 300, 250, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("PRESIO DEL MUEBLE:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(680, 310, 190, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1360, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentaActionPerformed
        Ventas vt = new Ventas();
        vt.setVisible(true);
        dispose();
    }//GEN-LAST:event_VentaActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        Categoria ct = new Categoria();
        ct.setVisible(true);
        dispose();
    }//GEN-LAST:event_CategoriaActionPerformed

    private void PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PedidosActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        Clientes cl = new Clientes();
        cl.setVisible(true);
        dispose();
    }//GEN-LAST:event_ClientesActionPerformed

    private void cloresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cloresActionPerformed
        Color cc = new Color();
        cc.setVisible(true);
        dispose();
    }//GEN-LAST:event_cloresActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed

    }//GEN-LAST:event_modificarActionPerformed

    private void TbMuebleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbMuebleMouseClicked

    }//GEN-LAST:event_TbMuebleMouseClicked

    private void VaciarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VaciarTxtMouseClicked

    }//GEN-LAST:event_VaciarTxtMouseClicked

    private void VaciarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarTxtActionPerformed
        Vaciar();
    }//GEN-LAST:event_VaciarTxtActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if(!"".equals(search.getText())){
            int dni = Integer.parseInt(search.getText());
            MueblesClase mueble = touch.Buscar(dni);
            CategoriaClase cag = categ.Buscar(dni);
            if(mueble != null){
                nomMueble.setText(mueble.getNom_mueble());
                categMueble.setText(cag.getNom_categ());
                stokMueble.setText(String.valueOf(mueble.getStok_mueble()));
                materialMueble.setText(mueble.getMater_mueble());
                pressMueble.setText(String.valueOf(mueble.getPresi_mueble()));
            } else {
                JOptionPane.showMessageDialog(null, "Mueble no encontrado");
                Vaciar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un codigo para buscar");
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        Registrar rg = new Registrar();
        rg.setVisible(true);
        dispose();
    }//GEN-LAST:event_registerActionPerformed

    private void codEmpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codEmpleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codEmpleActionPerformed

    private void MuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuebleActionPerformed
        Muebles mf = new Muebles();
        mf.setVisible(true);
        dispose();
    }//GEN-LAST:event_MuebleActionPerformed

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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Categoria;
    private javax.swing.JButton Cerrar;
    private javax.swing.JButton Clientes;
    private javax.swing.JButton Mueble;
    private javax.swing.JButton Pedidos;
    private javax.swing.JTable TbMueble;
    private javax.swing.JButton VaciarTxt;
    private javax.swing.JButton Venta;
    private javax.swing.JButton buscar;
    private javax.swing.JSpinner cant;
    private javax.swing.JTextField categMueble;
    private javax.swing.JButton clores;
    private javax.swing.JComboBox<String> codClient;
    private javax.swing.JComboBox<String> codEmple;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField materialMueble;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nomMueble;
    private javax.swing.JTextField pressMueble;
    private javax.swing.JButton register;
    private javax.swing.JTextField search;
    private javax.swing.JTextField stokMueble;
    // End of variables declaration//GEN-END:variables
}
