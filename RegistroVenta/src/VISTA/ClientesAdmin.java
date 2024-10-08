package VISTA;

import MODELO.ClienteClase;
import MODELO.ClienteDAO;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClientesAdmin extends javax.swing.JFrame {

    ClienteClase cl = new ClienteClase();
    ClienteDAO client = new ClienteDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ClientesAdmin() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
        ListarCliente();
    }
    public void ListarCliente(){
        List<ClienteClase> ListaCl = client.ListarCliente();
        modelo = (DefaultTableModel) TbClient.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < ListaCl.size(); i++){
            ob[0] = ListaCl.get(i).getDni_client();
            ob[1] = ListaCl.get(i).getNom_client();
            ob[2] = ListaCl.get(i).getApell_client();
            ob[3] = ListaCl.get(i).getDirecc_client();
            ob[4] = ListaCl.get(i).getTelef_client();
            modelo.addRow(ob);
        }
        TbClient.setModel(modelo);
    }
    
    public void LimpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }
    private void vaciarInputs(){
        search.setText("");
        DniClient.setText("");
        NomClient.setText("");
        ApellClient.setText("");
        DireccClient.setText("");
        TelefClient.setText("");
    }
    
    public void Añadir(){
        if(!"".equals(DniClient.getText()) || !"".equals(NomClient.getText()) || !"".equals(ApellClient.getText()) || !"".equals(DireccClient.getText()) || !"".equals(TelefClient.getText())){
            if(client.esNumero(DniClient.getText())){
                if(client.esNumero(TelefClient.getText())){
                    int dni = Integer.parseInt(DniClient.getText());
                    if(!client.Exist(dni)){
                        if(DniClient.getText().length()<= 10 && client.esNumero(DniClient.getText())){
                            if(TelefClient.getText().length() <= 10 && client.esNumero(TelefClient.getText())){
                                cl.setDni_client(Integer.parseInt(DniClient.getText()));
                                cl.setNom_client(NomClient.getText());
                                cl.setApell_client(ApellClient.getText());
                                cl.setDirecc_client(DireccClient.getText());
                                cl.setTelef_client(TelefClient.getText());
                                client.RegistrarCliente(cl);
                                JOptionPane.showMessageDialog(null, "CLIENTE Registrado");
                                LimpiarTabla();
                                ListarCliente();
                                vaciarInputs();
                            }else{
                                JOptionPane.showMessageDialog(null, "El TELEFONO no es valido (tiene que ser menor a 10 caracteres)");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "El CODIGO no es valido (tiene que ser menor a 10 caracteres)");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "ERROR: El CODIGO ya esta en USO");
                    }            
                }
                else{
                    JOptionPane.showMessageDialog(null, "ERROR: El TELEFONO no es VALIDO");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR: El CODIGO no es VALIDO");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Los CAMPOS estan VACIOS");
        }
    }
    
    public void Seleccionar(int fila){
        DniClient.setText(TbClient.getValueAt(fila, 0).toString());
        NomClient.setText(TbClient.getValueAt(fila, 1).toString());
        ApellClient.setText(TbClient.getValueAt(fila, 2).toString());
        DireccClient.setText(TbClient.getValueAt(fila, 3).toString());
        TelefClient.setText(TbClient.getValueAt(fila, 4).toString());
    }
    
    public void Modificar(){
        if("".equals(DniClient.getText())){
           JOptionPane.showMessageDialog(null, "SELECCIONE el CLIENTE a modificar");
        }
        else{
            if(!"".equals(DniClient.getText()) || !"".equals(NomClient.getText()) || !"".equals(ApellClient.getText()) || !"".equals(DireccClient.getText()) || !"".equals(TelefClient.getText())){
                cl.setDni_client(Integer.parseInt(DniClient.getText()));
                cl.setNom_client(NomClient.getText());
                cl.setApell_client(ApellClient.getText());
                cl.setTelef_client(TelefClient.getText());
                cl.setDirecc_client(DireccClient.getText());
                client.ModificarCliente(cl);
                JOptionPane.showMessageDialog(null, "CLIENTE Modificado");
                LimpiarTabla();
                vaciarInputs();
                ListarCliente();
            }else{
                JOptionPane.showMessageDialog(null, "ERROR: RELLENE todos los CAMPOS");
            }
        }
    }
    
    public void Eliminar(){
        if(!"".equals(DniClient.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de ELIMINAR este CLIENTE?");
            if(pregunta == 0){
                int dni = Integer.parseInt(DniClient.getText());
                if (client.EliminarCliente(dni)) {
                    JOptionPane.showMessageDialog(null, "CLIENTE Eliminado");
                    LimpiarTabla();
                    vaciarInputs();
                    ListarCliente();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: El CLIENTE no fue eliminado");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: SELECCIONE un CLIENTE");
        }
    }
    
    public void Buscar(){
        if(!"".equals(search.getText())){
            if(client.esNumero(search.getText())){
                int dni = Integer.parseInt(search.getText());
                ClienteClase cliente = client.Buscar(dni);
                if(cliente != null){
                    DniClient.setText(String.valueOf(cliente.getDni_client()));
                    NomClient.setText(cliente.getNom_client());
                    ApellClient.setText(cliente.getApell_client());
                    DireccClient.setText(cliente.getDirecc_client());
                    TelefClient.setText(cliente.getTelef_client());
                } else {
                    JOptionPane.showMessageDialog(null, "CLIENTE NO ENCONTRADO");
                    vaciarInputs();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR: VALOR NO VALIDO");
                vaciarInputs();
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Por favor INGRESE un DNI para BUSCAR");
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

        jPanel2.setBackground(new java.awt.Color(81, 141, 5));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLIENTES");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(970, 20, 160, 48);

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

        DniClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(DniClient);
        DniClient.setBounds(870, 150, 270, 40);

        NomClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(NomClient);
        NomClient.setBounds(870, 200, 270, 40);

        DireccClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(DireccClient);
        DireccClient.setBounds(870, 300, 270, 40);

        TelefClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(TelefClient);
        TelefClient.setBounds(870, 350, 270, 40);

        guardar.setBackground(new java.awt.Color(81, 141, 5));
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

        TbClient.setAutoCreateRowSorter(true);
        TbClient.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TbClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "NOMBRE", "APELLIDO", "DIRECCIÓN", "TELEFONO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
        if (TbClient.getColumnModel().getColumnCount() > 0) {
            TbClient.getColumnModel().getColumn(0).setMinWidth(220);
            TbClient.getColumnModel().getColumn(0).setPreferredWidth(220);
            TbClient.getColumnModel().getColumn(0).setMaxWidth(220);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(60, 410, 1260, 240);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("APELLIDO DEL CLIENTE:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(630, 250, 210, 40);

        ApellClient.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(ApellClient);
        ApellClient.setBounds(870, 250, 270, 40);

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

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1360, 1010);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Añadir();        
    }//GEN-LAST:event_guardarActionPerformed

    private void ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientesActionPerformed
        
    }//GEN-LAST:event_ClientesActionPerformed

    private void TbClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbClientMouseClicked
        int fila = TbClient.rowAtPoint(evt.getPoint());
        Seleccionar(fila);
    }//GEN-LAST:event_TbClientMouseClicked

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
        Registrar rg = new Registrar();
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
        UsuariosAdmin us = new UsuariosAdmin();
        us.setVisible(true);
        dispose();
    }//GEN-LAST:event_UsersActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesAdmin().setVisible(true);
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
    private javax.swing.JButton Users;
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
