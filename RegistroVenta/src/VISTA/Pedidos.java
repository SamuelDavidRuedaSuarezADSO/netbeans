package VISTA;

import javax.swing.JOptionPane;

public class Pedidos extends javax.swing.JFrame {

    public Pedidos() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
    }

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
        register = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DniClient = new javax.swing.JTextField();
        NomClient = new javax.swing.JTextField();
        DireccClient = new javax.swing.JTextField();
        TelefClient = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbClient = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        ApellClient = new javax.swing.JTextField();
        VaciarTxt = new javax.swing.JButton();
        buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(55, 160, 244));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PEDIDOS");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(1000, 20, 160, 48);

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
        Categoria.setText("CATEGORIAS");
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

        register.setBackground(new java.awt.Color(55, 160, 244));
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("REGISTRAR");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel2.add(register);
        register.setBounds(650, 20, 110, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1360, 90);

        jLabel6.setText("©2024SamuelRueda. Todos los derechos reservados");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 710, 290, 16);

        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 160, 244), 3), "Buscar por codigo...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(60, 320, 400, 70);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("DNI DEL CLIENTE:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(630, 150, 210, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("NOMBRE DEL CLIENTE:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(630, 200, 210, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("DIRECCIÓN DEL CLIENTE:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(630, 300, 210, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("TELEFONO DEL CLIENTE:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(630, 350, 210, 40);

        DniClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(DniClient);
        DniClient.setBounds(870, 150, 270, 40);

        NomClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(NomClient);
        NomClient.setBounds(870, 200, 270, 40);

        DireccClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(DireccClient);
        DireccClient.setBounds(870, 300, 270, 40);

        TelefClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(TelefClient);
        TelefClient.setBounds(870, 350, 270, 40);

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

        TbClient.setAutoCreateRowSorter(true);
        TbClient.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TbClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NOMBRE", "APELLIDO", "DIRECCIÓN", "TELEFONO"
            }
        ));
        TbClient.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TbClient.setGridColor(new java.awt.Color(204, 204, 204));
        TbClient.setRowHeight(35);
        TbClient.setSelectionBackground(new java.awt.Color(85, 183, 252));
        TbClient.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TbClient.setShowGrid(true);
        TbClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbClientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbClient);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(60, 410, 1260, 240);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("APELLIDO DEL CLIENTE:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(630, 250, 210, 40);

        ApellClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(ApellClient);
        ApellClient.setBounds(870, 250, 270, 40);

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

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1360, 740);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentaActionPerformed
        Ventas vt = new Ventas();
        vt.setVisible(true);
        dispose();
    }//GEN-LAST:event_VentaActionPerformed

    private void MuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuebleActionPerformed
        Muebles mb = new Muebles();
        mb.setVisible(true);
        dispose();
    }//GEN-LAST:event_MuebleActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        Categoria ct = new Categoria();
        ct.setVisible(true);
        dispose();
    }//GEN-LAST:event_CategoriaActionPerformed

    private void PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidosActionPerformed
        
    }//GEN-LAST:event_PedidosActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        Clientes cl = new Clientes();
        cl.setVisible(true);
        dispose();
    }//GEN-LAST:event_ClientesActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        Registrar rg = new Registrar();
        rg.setVisible(true);
        dispose();
    }//GEN-LAST:event_registerActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed


    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed

    }//GEN-LAST:event_modificarActionPerformed

    private void TbClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbClientMouseClicked
    }//GEN-LAST:event_TbClientMouseClicked

    private void VaciarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarTxtActionPerformed

    }//GEN-LAST:event_VaciarTxtActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed

    }//GEN-LAST:event_buscarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ApellClient;
    private javax.swing.JButton Categoria;
    private javax.swing.JButton Cerrar;
    private javax.swing.JButton Clientes;
    private javax.swing.JTextField DireccClient;
    private javax.swing.JTextField DniClient;
    private javax.swing.JButton Mueble;
    private javax.swing.JTextField NomClient;
    private javax.swing.JButton Pedidos;
    private javax.swing.JTable TbClient;
    private javax.swing.JTextField TelefClient;
    private javax.swing.JButton VaciarTxt;
    private javax.swing.JButton Venta;
    private javax.swing.JButton buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modificar;
    private javax.swing.JButton register;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
