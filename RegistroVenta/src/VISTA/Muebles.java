package VISTA;


import MODELO.MueblesClase;
import MODELO.MueblesDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Muebles extends javax.swing.JFrame {
    
    public int codCateg;
    public String categ;

    MueblesClase mb = new MueblesClase();
    MueblesDAO touch = new MueblesDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Muebles() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
        Listar();
        touch.ConsultarCategoria(categoria);
    }

    public void Vaciar(){
        codigo.setText("");
        NomMueble.setText("");
        categoria.setSelectedItem("Selecione una categoria...");
        MaterialMueble.setText("");
        pressMueble.setText("");
        StokMueble.setText("");
        colorMueble.setText("");
        search.setText("");
    }  
    
    public void LimpiarTabla(){
        for (int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i);
            i = i-1;
        }
    }
    
    public void Listar() {
        List<MueblesClase> Lista = touch.Listar();

        modelo = (DefaultTableModel) TbMueble.getModel();
        modelo.setRowCount(0);

        for (int i = 0; i < Lista.size(); i++) {
            Object[] ob = new Object[8];
            ob[0] = Lista.get(i).getCod_mueble();
            ob[1] = Lista.get(i).getNom_mueble();
            
            codCateg = Integer.parseInt(Lista.get(i).getCod_categ_fk() );
            categ = touch.nomCateg(codCateg);
            
            ob[2] = codCateg + " - " + categ;
            ob[3] = Lista.get(i).getMater_mueble();
            ob[4] = Lista.get(i).getColor_mueble();
            ob[5] = Lista.get(i).getPresi_mueble();
            ob[6] = Lista.get(i).getStok_mueble();
            
            modelo.addRow(ob);
        }
        TbMueble.setModel(modelo);
    }

    public void Añadir(){
        if (!"".equals(codigo.getText()) || !"".equals(NomMueble.getText()) || "Seleccione una categoria...".equals(categoria.getSelectedItem()) || "".equals(colorMueble.getText()) || !"".equals(MaterialMueble.getText()) || !"".equals(pressMueble.getText()) || !"".equals(StokMueble.getText())) {
            if(touch.esNumero(pressMueble.getText()) && touch.esNumero(StokMueble.getText())){
                if(touch.Exist(Integer.parseInt(codigo.getText()))){
                    JOptionPane.showMessageDialog(null, "ERROR: El CODIGO del mueble YA esta en USO");
                }
                else{
                    mb.setCod_mueble(Integer.parseInt(codigo.getText()));
                    mb.setNom_mueble(NomMueble.getText());

                    String selectedCategoria = (String) categoria.getSelectedItem();
                    String codCategoria = selectedCategoria.split(" - ")[0];

                    mb.setCod_categ_fk(codCategoria);
                    mb.setMater_mueble(MaterialMueble.getText());
                    mb.setColor_mueble(colorMueble.getText());
                    mb.setPresi_mueble(Double.parseDouble(pressMueble.getText()));
                    mb.setStok_mueble(Integer.parseInt(StokMueble.getText()));
                    touch.Registrar(mb);
                    JOptionPane.showMessageDialog(null, "MUEBLE Registrado");
                    LimpiarTabla();
                    Listar();
                    Vaciar();   
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR: El PRECIO o El STOCK no son validos");
            }        
        } else {
            JOptionPane.showMessageDialog(null, "Los CAMPOS estan VACIOS");
        }
    }
    
    public void Modificar(){
        if("".equals(codigo.getText())){
           JOptionPane.showMessageDialog(null, "SELECCIONA un MUEBLE");
        }
        else{
            if(!"".equals(codigo.getText()) || !"".equals(NomMueble.getText()) || !"Seleccione una categoria...".equals(categoria.getSelectedItem()) || !"".equals(MaterialMueble.getText()) || !"".equals(colorMueble.getText()) || !"".equals(pressMueble.getText()) || !"".equals(StokMueble.getText())){
                if(touch.esNumero(StokMueble.getText())){
                    int pregunta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de MODIFICAR este MUEBLE?");
                    if(pregunta == 0){
                        mb.setCod_mueble(Integer.parseInt(codigo.getText()));
                        mb.setNom_mueble(NomMueble.getText());

                        String selectedCategoria = (String) categoria.getSelectedItem();
                        String codCategoria = selectedCategoria.split(" - ")[0];

                        mb.setCod_categ_fk(codCategoria);
                        mb.setMater_mueble(MaterialMueble.getText());
                        mb.setColor_mueble(colorMueble.getText());
                        mb.setPresi_mueble(Double.parseDouble(pressMueble.getText()));
                        mb.setStok_mueble(Integer.parseInt(StokMueble.getText()));
                        touch.Modificar(mb);
                        JOptionPane.showMessageDialog(null, "MUEBLE modificado");
                        LimpiarTabla();
                        Vaciar();
                        Listar();
                    }                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "ERROR:Valor del STOCK no es VALIDO");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR: RELLENE todos los CAMPOS");
            }
        }
    }
    
    public void Seleccionar(int fila){
        codigo.setText(TbMueble.getValueAt(fila, 0).toString());
        NomMueble.setText(TbMueble.getValueAt(fila, 1).toString());
        categoria.setSelectedItem(TbMueble.getValueAt(fila, 2));
        MaterialMueble.setText(TbMueble.getValueAt(fila, 3).toString()); 
        colorMueble.setText(TbMueble.getValueAt(fila, 4).toString());
        pressMueble.setText(TbMueble.getValueAt(fila, 5).toString());
        StokMueble.setText(TbMueble.getValueAt(fila, 6).toString());
    }
    
    public void Buscar(){
        if(!"".equals(search.getText())){
            boolean cod = touch.esNumero(search.getText());
            if(cod){
                int dni = Integer.parseInt(search.getText());
                MueblesClase mueble = touch.Buscar(dni);
                if(mueble != null){
                    codigo.setText(String.valueOf(mueble.getCod_mueble()));
                    NomMueble.setText(mueble.getNom_mueble());
                    MaterialMueble.setText(mueble.getMater_mueble());
                    pressMueble.setText(String.valueOf(mueble.getPresi_mueble()));
                    StokMueble.setText(String.valueOf(mueble.getStok_mueble()));
                    colorMueble.setText(mueble.getColor_mueble());
                } else {
                    JOptionPane.showMessageDialog(null, "MUEBLE no encontrado");
                }
            }else{
                JOptionPane.showMessageDialog(null, "ERROR: CODIGO no VALIDO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERROR: Por favor ingrese un CODIGO para BUSCAR");
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
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        NomMueble = new javax.swing.JTextField();
        MaterialMueble = new javax.swing.JTextField();
        pressMueble = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbMueble = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        VaciarTxt = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        StokMueble = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        categoria = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        colorMueble = new javax.swing.JTextField();

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
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });
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
        jLabel6.setBounds(10, 670, 290, 16);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("CODIGO DEL MUEBLE:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 190, 210, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("NOMBRE DEL MUEBLE:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(90, 240, 210, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("MATERIAL DEL MUEBLE:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(640, 200, 210, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("PRESIO DEL MUEBLE:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(640, 300, 210, 40);

        codigo.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(codigo);
        codigo.setBounds(330, 190, 270, 40);

        NomMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(NomMueble);
        NomMueble.setBounds(330, 240, 270, 40);

        MaterialMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(MaterialMueble);
        MaterialMueble.setBounds(880, 200, 270, 40);

        pressMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(pressMueble);
        pressMueble.setBounds(880, 300, 270, 40);

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
        guardar.setBounds(1180, 220, 130, 50);

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
        modificar.setBounds(1180, 280, 130, 50);

        TbMueble.setAutoCreateRowSorter(true);
        TbMueble.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TbMueble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "CATEGORIA", "MATERIAL", "COLOR", "PRECIO", "STOCK"
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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("CATEGORIA DE LA CATEGORIA:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(640, 150, 210, 40);

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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("STOCK DEL MUEBLE:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(640, 350, 210, 40);

        StokMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(StokMueble);
        StokMueble.setBounds(880, 350, 270, 40);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("SELECONAR COLOR:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(640, 250, 210, 40);

        categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione una categoria..." }));
        categoria.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(categoria);
        categoria.setBounds(880, 150, 270, 40);

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

        colorMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(colorMueble);
        colorMueble.setBounds(880, 250, 270, 40);

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
        Añadir();
    }//GEN-LAST:event_guardarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        Modificar();
    }//GEN-LAST:event_modificarActionPerformed

    private void TbMuebleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbMuebleMouseClicked
       int fila = TbMueble.rowAtPoint(evt.getPoint());
       Seleccionar(fila);
    }//GEN-LAST:event_TbMuebleMouseClicked

    private void VaciarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VaciarTxtActionPerformed
        Vaciar();
    }//GEN-LAST:event_VaciarTxtActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        Categoria ct = new Categoria();
        ct.setVisible(true);
        dispose();
    }//GEN-LAST:event_CategoriaActionPerformed

    private void VaciarTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VaciarTxtMouseClicked

    }//GEN-LAST:event_VaciarTxtMouseClicked

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

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        Registrar rg = new Registrar();
        rg.setVisible(true);
        dispose();
    }//GEN-LAST:event_registerActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        Buscar();
    }//GEN-LAST:event_buscarActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarActionPerformed

    public static void main(String args[]) {

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
    private javax.swing.JTextField MaterialMueble;
    private javax.swing.JButton Mueble;
    private javax.swing.JTextField NomMueble;
    private javax.swing.JButton Pedidos;
    private javax.swing.JTextField StokMueble;
    private javax.swing.JTable TbMueble;
    private javax.swing.JButton VaciarTxt;
    private javax.swing.JButton Venta;
    private javax.swing.JButton buscar;
    private javax.swing.JComboBox<String> categoria;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField colorMueble;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JButton modificar;
    private javax.swing.JTextField pressMueble;
    private javax.swing.JButton register;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
