package VISTA;

import MODELO.CategoriaClase;
import MODELO.CategoriaDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Categoria extends javax.swing.JFrame {

    CategoriaClase cc = new CategoriaClase();
    CategoriaDAO categori = new CategoriaDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Categoria() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
        ListarCategoria();
    }
    
    public void LimpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void VaciarInputs(){
        CodCategoria.setText("");
        NomCategoria.setText("");
        ZonaCategoria.setText("");
        search.setText("");
    }
    
    public void ListarCategoria(){
        List<CategoriaClase> ListaCl = categori.ListarCategoria();
        modelo = (DefaultTableModel) TbCategoria.getModel();
        Object[] ob = new Object[5];
        for (int i = 0; i < ListaCl.size(); i++){
            ob[0] = ListaCl.get(i).getCod_categ();
            ob[1] = ListaCl.get(i).getNom_categ();
            ob[2] = ListaCl.get(i).getZona_mueble();
            modelo.addRow(ob);
        }
        TbCategoria.setModel(modelo);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CodCategoria = new javax.swing.JTextField();
        NomCategoria = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbCategoria = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        ZonaCategoria = new javax.swing.JTextField();
        VaciarTxt = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        search = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(55, 160, 244));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CATEGORIAS");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(920, 20, 230, 48);

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
        jLabel6.setBounds(10, 660, 290, 16);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("CODIGO DE LA ZONA:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(630, 240, 210, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("NOMBRE DE LA CATEGORIA:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(630, 290, 210, 40);

        CodCategoria.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(CodCategoria);
        CodCategoria.setBounds(870, 240, 270, 40);

        NomCategoria.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(NomCategoria);
        NomCategoria.setBounds(870, 290, 270, 40);

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

        TbCategoria.setAutoCreateRowSorter(true);
        TbCategoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TbCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "ZONA"
            }
        ));
        TbCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TbCategoria.setGridColor(new java.awt.Color(204, 204, 204));
        TbCategoria.setRowHeight(35);
        TbCategoria.setSelectionBackground(new java.awt.Color(85, 183, 252));
        TbCategoria.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TbCategoria.setShowGrid(true);
        TbCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbCategoriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbCategoria);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(310, 410, 780, 240);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("ZONA DEL MUEBLES:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(630, 340, 210, 40);

        ZonaCategoria.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(ZonaCategoria);
        ZonaCategoria.setBounds(870, 340, 270, 40);

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

        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 160, 244), 3), "Buscar por codigo...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(60, 320, 400, 70);

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
        if(!"".equals(CodCategoria.getText()) || !"".equals(NomCategoria.getText()) || !"".equals(ZonaCategoria.getText())){
            cc.setCod_categ(Integer.parseInt(CodCategoria.getText()));
            cc.setNom_categ(NomCategoria.getText());
            cc.setZona_mueble(ZonaCategoria.getText());
            categori.RegistrarCategoria(cc);
            LimpiarTabla();
            ListarCategoria();
            VaciarInputs();
            JOptionPane.showMessageDialog(null, "Categoria Registrada");
        }
        else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacion");
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        if(!"".equals(CodCategoria.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar esta categoria?");
            if(pregunta == 0){
                int cod = Integer.parseInt(CodCategoria.getText());
                
                if (categori.Eliminar(cod)) {
                    JOptionPane.showMessageDialog(null, "Categoria eliminada");
                    LimpiarTabla();
                    VaciarInputs();
                    ListarCategoria();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: La categoria no fue eliminada");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Selecciona una categoria");
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        if("".equals(CodCategoria.getText())){
           JOptionPane.showMessageDialog(null, "Selecciones una categoria");
        }
        else{
            cc.setCod_categ(Integer.parseInt(CodCategoria.getText()));
            cc.setNom_categ(NomCategoria.getText());
            cc.setZona_mueble(ZonaCategoria.getText());
            if(!"".equals(CodCategoria.getText()) || !"".equals(NomCategoria.getText()) || !"".equals(ZonaCategoria.getText())){
                categori.Modificar(cc);
                JOptionPane.showMessageDialog(null, "Categoria modificada");
                LimpiarTabla();
                VaciarInputs();
                ListarCategoria();
            }
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void TbCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbCategoriaMouseClicked
        int fila = TbCategoria.rowAtPoint(evt.getPoint());
        CodCategoria.setText(TbCategoria.getValueAt(fila, 0).toString());
        NomCategoria.setText(TbCategoria.getValueAt(fila, 1).toString());
        ZonaCategoria.setText(TbCategoria.getValueAt(fila, 2).toString());
    }//GEN-LAST:event_TbCategoriaMouseClicked

    private void VaciarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarTxtActionPerformed
        VaciarInputs();
    }//GEN-LAST:event_VaciarTxtActionPerformed

    private void MuebleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuebleActionPerformed
        Muebles mb = new Muebles();
        mb.setVisible(true);
        dispose();
    }//GEN-LAST:event_MuebleActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        if(!"".equals(search.getText())){
            int dni = Integer.parseInt(search.getText());
            CategoriaClase categ = categori.Buscar(dni);
            if(categ != null){
                CodCategoria.setText(String.valueOf(categ.getCod_categ()));
                NomCategoria.setText(categ.getNom_categ());
                ZonaCategoria.setText(categ.getZona_mueble());

            } else {
                JOptionPane.showMessageDialog(null, "Categoria no encontrado");
                VaciarInputs();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un codigo para buscar");
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        Registrar rg = new Registrar();
        rg.setVisible(true);
        dispose();
    }//GEN-LAST:event_registerActionPerformed

    private void PedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedidosActionPerformed
        Pedidos pd = new Pedidos();
        pd.setVisible(true);
        dispose();
    }//GEN-LAST:event_PedidosActionPerformed

    private void VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentaActionPerformed
        Ventas vt = new Ventas();
        vt.setVisible(true);
        dispose();
    }//GEN-LAST:event_VentaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Categoria;
    private javax.swing.JButton Cerrar;
    private javax.swing.JButton Clientes;
    private javax.swing.JTextField CodCategoria;
    private javax.swing.JButton Mueble;
    private javax.swing.JTextField NomCategoria;
    private javax.swing.JButton Pedidos;
    private javax.swing.JTable TbCategoria;
    private javax.swing.JButton VaciarTxt;
    private javax.swing.JButton Venta;
    private javax.swing.JTextField ZonaCategoria;
    private javax.swing.JButton buscar;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton modificar;
    private javax.swing.JButton register;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
