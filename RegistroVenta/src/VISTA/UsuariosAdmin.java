
package VISTA;

import MODELO.ClienteClase;
import MODELO.ClienteDAO;
import MODELO.UsuariosClase;
import MODELO.UsuariosDAO;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsuariosAdmin extends javax.swing.JFrame {

    UsuariosClase us = new UsuariosClase();
    UsuariosDAO user = new UsuariosDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    int codRol;
    String nomRol;
    
    public UsuariosAdmin() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
        user.ConsultarRol(rol);
        LlenarTabla();
    }
    public void LlenarTabla(){
        List<UsuariosClase> ListaCl = user.Listar();
        modelo = (DefaultTableModel) TbUsers.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < ListaCl.size(); i++){
            ob[0] = ListaCl.get(i).getCod_user();
            ob[1] = ListaCl.get(i).getNom_user();
            ob[2] = ListaCl.get(i).getEmail_user();
            ob[3] = ListaCl.get(i).getContra_user();
            codRol = ListaCl.get(i).getCod_rol_fk();
            nomRol = user.nomRol(codRol);
            ob[4] = codRol + " - " + nomRol;
            modelo.addRow(ob);
        }
        TbUsers.setModel(modelo);
    }
    
    public void LimpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    private void vaciarInputs(){
        search.setText("");
        codUser.setText("");
        nomUser.setText("");
        mailUser.setText("");
        contraUser.setText("");
        rol.setSelectedItem("Seleccione un rol...");
    }

    public void Buscar(){
        if(!"".equals(search.getText())){
            if(user.esNumero(search.getText())){
                int cod = Integer.parseInt(search.getText());
                UsuariosClase u = user.Buscar(cod);
                if(u != null){
                    codUser.setText(String.valueOf(u.getCod_user()));
                    nomUser.setText(u.getNom_user());
                    mailUser.setText(u.getEmail_user());
                    contraUser.setText(u.getContra_user());
                    codRol = u.getCod_rol_fk();
                    nomRol = user.nomRol(codRol);
                    rol.setSelectedItem( codRol + " - " + nomRol);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                    vaciarInputs();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR: VALOR NO VALIDO");
                vaciarInputs();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un CODIGO para buscar");
        }
    }

    public void Selected(int fila){
        codUser.setText(TbUsers.getValueAt(fila, 0).toString());
        nomUser.setText(TbUsers.getValueAt(fila, 1).toString());
        mailUser.setText(TbUsers.getValueAt(fila, 2).toString());
        contraUser.setText(TbUsers.getValueAt(fila, 3).toString());
        rol.setSelectedItem(TbUsers.getValueAt(fila, 4).toString());
    }
    
    public void Eliminar(){
        if(!"".equals(codUser.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de ELIMINAR este USUARIO?");
            if(pregunta == 0){
                int cod = Integer.parseInt(codUser.getText());
                
                if (user.Eliminar(cod)) {
                    JOptionPane.showMessageDialog(null, "USUARIO eliminado");
                    LimpiarTabla();
                    vaciarInputs();
                    LlenarTabla();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: El USUARIO no fue eliminado");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Seleccion un USUARIO");
        }
    }
    
    public void Modificar(){
        if("".equals(codUser.getText())){
           JOptionPane.showMessageDialog(null, "Selecciones un USUARIO");
        }
        else{
            if(!"".equals(codUser.getText()) || !"".equals(nomUser.getText()) || !"".equals(mailUser.getText()) || !"".equals(contraUser.getText()) || !"Seleccione un rol...".equals(rol.getSelectedItem())){
                if(mailUser.getText().contains("@") && mailUser.getText().contains(".com")){
                    us.setCod_user(Integer.parseInt(codUser.getText()));
                    us.setNom_user(nomUser.getText());
                    us.setEmail_user(mailUser.getText());
                    us.setContra_user(contraUser.getText());

                    String selectRol = (String) rol.getSelectedItem();
                    String codRol = selectRol.split(" - ")[0];

                    us.setCod_rol_fk(Integer.parseInt(codRol));
                    user.Modificar(us);
                    JOptionPane.showMessageDialog(null, "USUARIO Modificado");
                    LimpiarTabla();
                    vaciarInputs();
                    LlenarTabla();
                }
                else{
                    JOptionPane.showMessageDialog(null,"ERROR: El CORREO debe tener un @ y un .com");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR: RELLENE todos los CAMPOS");
            }
        }
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
        Users = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        codUser = new javax.swing.JTextField();
        nomUser = new javax.swing.JTextField();
        contraUser = new javax.swing.JTextField();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbUsers = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        mailUser = new javax.swing.JTextField();
        VaciarTxt = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        rol = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(81, 141, 5));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USUARIOS");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(940, 20, 190, 48);

        Cerrar.setBackground(new java.awt.Color(81, 141, 5));
        Cerrar.setForeground(new java.awt.Color(255, 255, 255));
        Cerrar.setText("CERRAR SESIÓN");
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });
        jPanel2.add(Cerrar);
        Cerrar.setBounds(1180, 20, 140, 50);

        Venta.setBackground(new java.awt.Color(81, 141, 5));
        Venta.setForeground(new java.awt.Color(255, 255, 255));
        Venta.setText("VENTAS");
        Venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VentaActionPerformed(evt);
            }
        });
        jPanel2.add(Venta);
        Venta.setBounds(50, 20, 110, 50);

        Mueble.setBackground(new java.awt.Color(81, 141, 5));
        Mueble.setForeground(new java.awt.Color(255, 255, 255));
        Mueble.setText("MUEBLES");
        Mueble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MuebleActionPerformed(evt);
            }
        });
        jPanel2.add(Mueble);
        Mueble.setBounds(170, 20, 110, 50);

        Categoria.setBackground(new java.awt.Color(81, 141, 5));
        Categoria.setForeground(new java.awt.Color(255, 255, 255));
        Categoria.setText("CATEGORIAS");
        Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(Categoria);
        Categoria.setBounds(290, 20, 110, 50);

        Pedidos.setBackground(new java.awt.Color(81, 141, 5));
        Pedidos.setForeground(new java.awt.Color(255, 255, 255));
        Pedidos.setText("PEDIDOS");
        Pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedidosActionPerformed(evt);
            }
        });
        jPanel2.add(Pedidos);
        Pedidos.setBounds(410, 20, 110, 50);

        Clientes.setBackground(new java.awt.Color(81, 141, 5));
        Clientes.setForeground(new java.awt.Color(255, 255, 255));
        Clientes.setText("CLIENTES");
        Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientesActionPerformed(evt);
            }
        });
        jPanel2.add(Clientes);
        Clientes.setBounds(530, 20, 110, 50);

        register.setBackground(new java.awt.Color(81, 141, 5));
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.setText("REGISTRAR");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        jPanel2.add(register);
        register.setBounds(650, 20, 110, 50);

        Users.setBackground(new java.awt.Color(81, 141, 5));
        Users.setForeground(new java.awt.Color(255, 255, 255));
        Users.setText("USUARIOS");
        Users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersActionPerformed(evt);
            }
        });
        jPanel2.add(Users);
        Users.setBounds(770, 20, 110, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1360, 90);

        jLabel6.setText("©2024SamuelRueda. Todos los derechos reservados");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 710, 290, 16);

        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(81, 141, 5), 3), "Buscar por codigo...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(60, 320, 400, 70);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("CODIGO DEL USUARIO:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(630, 150, 210, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("NOMBRE DEL USUARIO:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(630, 200, 210, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("CONTRASEÑA DEL USUARIO:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(630, 300, 210, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("ROL:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(630, 350, 210, 40);

        codUser.setEditable(false);
        codUser.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(codUser);
        codUser.setBounds(870, 150, 270, 40);

        nomUser.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(nomUser);
        nomUser.setBounds(870, 200, 270, 40);

        contraUser.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(contraUser);
        contraUser.setBounds(870, 300, 270, 40);

        eliminar.setBackground(new java.awt.Color(81, 141, 5));
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

        modificar.setBackground(new java.awt.Color(81, 141, 5));
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

        TbUsers.setAutoCreateRowSorter(true);
        TbUsers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TbUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "USUARIO", "EMAIL", "CONTRASEÑA", "ROL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TbUsers.setGridColor(new java.awt.Color(204, 204, 204));
        TbUsers.setRowHeight(35);
        TbUsers.setSelectionBackground(new java.awt.Color(85, 183, 252));
        TbUsers.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TbUsers.setShowGrid(true);
        TbUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbUsersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbUsers);
        if (TbUsers.getColumnModel().getColumnCount() > 0) {
            TbUsers.getColumnModel().getColumn(0).setMinWidth(220);
            TbUsers.getColumnModel().getColumn(0).setPreferredWidth(220);
            TbUsers.getColumnModel().getColumn(0).setMaxWidth(220);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(60, 410, 1260, 240);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("EMAIL DEL USUARIO:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(630, 250, 210, 40);

        mailUser.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(mailUser);
        mailUser.setBounds(870, 250, 270, 40);

        VaciarTxt.setBackground(new java.awt.Color(81, 141, 5));
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

        buscar.setBackground(new java.awt.Color(81, 141, 5));
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

        rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un rol..." }));
        rol.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(rol);
        rol.setBounds(870, 350, 270, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1360, 1010);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        ClientesAdmin cl = new ClientesAdmin();
        cl.setVisible(true);
        dispose();
    }//GEN-LAST:event_ClientesActionPerformed

    private void TbUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbUsersMouseClicked
        int fila = TbUsers.rowAtPoint(evt.getPoint());
        Selected(fila);
    }//GEN-LAST:event_TbUsersMouseClicked

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Eliminar();
    }//GEN-LAST:event_eliminarActionPerformed

    private void VaciarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarTxtActionPerformed
        vaciarInputs();
    }//GEN-LAST:event_VaciarTxtActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        Modificar();
    }//GEN-LAST:event_modificarActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        CategoriaAdmin ct = new CategoriaAdmin();
        ct.setVisible(true);
        dispose();
    }//GEN-LAST:event_CategoriaActionPerformed

    private void MuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuebleActionPerformed
        MueblesAdmin mf = new MueblesAdmin();
        mf.setVisible(true);
        dispose();
    }//GEN-LAST:event_MuebleActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        Buscar();
    }//GEN-LAST:event_buscarActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        RegistrarAdmin rg = new RegistrarAdmin();
        rg.setVisible(true);
        dispose();
    }//GEN-LAST:event_registerActionPerformed

    private void PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidosActionPerformed
        PedidosAdmin pd = new PedidosAdmin();
        pd.setVisible(true);
        dispose();
    }//GEN-LAST:event_PedidosActionPerformed

    private void VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentaActionPerformed
        VentasAdmin vt = new VentasAdmin();
        vt.setVisible(true);
        dispose();
    }//GEN-LAST:event_VentaActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarActionPerformed

    private void UsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersActionPerformed

    }//GEN-LAST:event_UsersActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuariosAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Categoria;
    private javax.swing.JButton Cerrar;
    private javax.swing.JButton Clientes;
    private javax.swing.JButton Mueble;
    private javax.swing.JButton Pedidos;
    private javax.swing.JTable TbUsers;
    private javax.swing.JButton Users;
    private javax.swing.JButton VaciarTxt;
    private javax.swing.JButton Venta;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField codUser;
    private javax.swing.JTextField contraUser;
    private javax.swing.JButton eliminar;
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
    private javax.swing.JTextField mailUser;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nomUser;
    private javax.swing.JButton register;
    private javax.swing.JComboBox<String> rol;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
