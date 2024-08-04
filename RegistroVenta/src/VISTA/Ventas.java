package VISTA;

import MODELO.CategoriaClase;
import MODELO.CategoriaDAO;
import MODELO.MueblesClase;
import MODELO.MueblesDAO;
import MODELO.VentaClase;
import MODELO.VentaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Ventas extends javax.swing.JFrame {

    int item;
    double totalP = 0.00;
    VentaDAO sells = new VentaDAO();
    VentaClase sl = new VentaClase();
    MueblesDAO touch = new MueblesDAO();
    CategoriaDAO categ = new CategoriaDAO();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Ventas() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
        sells.ConsultarCliente(codClient);
        sells.ConsultarEmpleado(codEmple);
    }
    
    private void Vaciar(){
        nomMueble.setText("");
        categMueble.setText("");
        stokMueble.setText("");
        materialMueble.setText("");
        pressMueble.setText("");
        search.setText("");
        cant.setValue(0);
        codClient.setSelectedItem("Selecciona un cliente...");
        pagar.setText("");
    }
    
    private void LimpiserVenta(){
        nomMueble.setText("");
        categMueble.setText("");
        stokMueble.setText("");
        materialMueble.setText("");
        pressMueble.setText("");
        search.setText("");
        cant.setValue(0);
        codClient.setSelectedItem("Selecciona un cliente...");
    }
    
    private void TotalP(){
        totalP = 0.00;
        int numF = tbVenta.getRowCount();
        for (int i = 0; i < numF; i++) {
            double cal = (double) tbVenta.getModel().getValueAt(i, 7);
            totalP = totalP + cal;
        }
        pagar.setText(String.format("%.0f",totalP));
    }
    
    private void añadir(){
        if(!"".equals(nomMueble.getText()) || !"".equals(categMueble.getText()) || !"".equals(stokMueble.getText()) || !"".equals(materialMueble.getText()) || !"".equals(pressMueble.getText())){
            int cantidad = (Integer) cant.getValue();
            if(cantidad != 0 && cantidad >0){
                if(cantidad <= Integer.parseInt(stokMueble.getText())){
                    int codigo = Integer.parseInt(search.getText());
                    String nombre = nomMueble.getText();
                    String categoria = categMueble.getText();
                    String material = materialMueble.getText();
                    int stok = Integer.parseInt(stokMueble.getText());
                    Double precio = Double.parseDouble(pressMueble.getText());
                    Double pressTot = cantidad * precio;
                    
                    item = item + 1;
                    modelo = (DefaultTableModel) tbVenta.getModel();
                    
                    for (int i = 0; i < tbVenta.getRowCount(); i++) {
                        if(tbVenta.getValueAt(i, 1).equals(nomMueble.getText())){
                            JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                            LimpiserVenta();
                            search.requestFocus();
                            return ;
                        }
                    }
                    
                    
                    ArrayList lista = new ArrayList();
                    
                    lista.add(item);
                    lista.add(codigo);
                    lista.add(nombre);
                    lista.add(categoria);
                    lista.add(material);
                    lista.add(stok);
                    lista.add(cantidad);
                    lista.add(precio);
                    lista.add(pressTot);
                    
                    Object[] o = new Object[8];
                    o[0] = lista.get(1);
                    o[1] = lista.get(2);
                    o[2] = lista.get(3);
                    o[3] = lista.get(4);
                    o[4] = lista.get(5);
                    o[5] = lista.get(6);
                    o[6] = lista.get(7);
                    o[7] = lista.get(8);
                    
                    modelo.addRow(o);
                    tbVenta.setModel(modelo);
                    
                    TotalP();
                    LimpiserVenta();
                    search.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR: STOCK no disponible");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR: La CANTIDAD no es valida");
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR: Los CAMPOS estan vacios");
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
        añadir = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbVenta = new javax.swing.JTable();
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
        jLabel12 = new javax.swing.JLabel();
        pagar = new javax.swing.JTextField();

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
        jLabel6.setBounds(10, 670, 330, 16);

        añadir.setBackground(new java.awt.Color(55, 160, 244));
        añadir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        añadir.setForeground(new java.awt.Color(255, 255, 255));
        añadir.setText("AÑADIR");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });
        jPanel1.add(añadir);
        añadir.setBounds(1180, 160, 130, 50);

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

        tbVenta.setAutoCreateRowSorter(true);
        tbVenta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "CATEGORIA", "MATERIAL", "STOCK", "CATIDAD", "PRECIO/U", "PRECIO/T"
            }
        ));
        tbVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbVenta.setGridColor(new java.awt.Color(204, 204, 204));
        tbVenta.setRowHeight(35);
        tbVenta.setSelectionBackground(new java.awt.Color(85, 183, 252));
        tbVenta.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbVenta.setShowGrid(true);
        tbVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVentaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbVenta);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(60, 410, 1260, 140);

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
        jLabel8.setText("CANTIDAD DESEADA:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(680, 360, 190, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("STOCK DEL MUEBLE:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(680, 260, 190, 30);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("MATERIAL DEL MUEBLE:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(680, 210, 190, 30);

        materialMueble.setEditable(false);
        materialMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(materialMueble);
        materialMueble.setBounds(880, 200, 250, 40);

        cant.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(cant);
        cant.setBounds(880, 350, 250, 40);

        nomMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(nomMueble);
        nomMueble.setBounds(880, 100, 250, 40);

        categMueble.setEditable(false);
        categMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(categMueble);
        categMueble.setBounds(880, 150, 250, 40);

        stokMueble.setEditable(false);
        stokMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(stokMueble);
        stokMueble.setBounds(880, 250, 250, 40);

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

        pressMueble.setEditable(false);
        pressMueble.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(pressMueble);
        pressMueble.setBounds(880, 300, 250, 40);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("PRECIO DEL MUEBLE:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(680, 310, 190, 30);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("TOTAL A PAGAR:                 $");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(870, 570, 190, 40);

        pagar.setEditable(false);
        pagar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(pagar);
        pagar.setBounds(1070, 570, 250, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1360, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VentaActionPerformed

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

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed
        añadir();
    }//GEN-LAST:event_añadirActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        modelo = (DefaultTableModel) tbVenta.getModel();
        modelo.removeRow(tbVenta.getSelectedRow());
        TotalP();
        LimpiserVenta();
        search.requestFocus();
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        int fila = tbVenta.getSelectedRow();
        if (fila != -1) {
            modelo.setValueAt(Integer.parseInt(search.getText()), fila, 0);
            modelo.setValueAt(nomMueble.getText(), fila, 1);
            modelo.setValueAt(categMueble.getText(), fila, 2);
            modelo.setValueAt(materialMueble.getText(), fila, 3);
            modelo.setValueAt(Integer.parseInt(stokMueble.getText()), fila, 4);
            modelo.setValueAt((Integer) cant.getValue(), fila, 5);
            modelo.setValueAt(Double.parseDouble(pressMueble.getText()), fila, 6);
            double pressTot = (Integer) cant.getValue() * Double.parseDouble(pressMueble.getText());
            modelo.setValueAt(pressTot, fila, 7);
            TotalP();
            LimpiserVenta();
            search.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un elemento de la tabla para actualizar");
    }
    }//GEN-LAST:event_modificarActionPerformed

    private void tbVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVentaMouseClicked
        int fila = tbVenta.rowAtPoint(evt.getPoint());
        search.setText(tbVenta.getValueAt(fila, 0).toString());
        nomMueble.setText(tbVenta.getValueAt(fila, 1).toString());       
        categMueble.setText(tbVenta.getValueAt(fila, 2).toString());
        materialMueble.setText(tbVenta.getValueAt(fila, 3).toString()); 
        stokMueble.setText(tbVenta.getValueAt(fila, 4).toString());
        cant.setValue(tbVenta.getValueAt(fila, 5));
        pressMueble.setText(tbVenta.getValueAt(fila, 6).toString());
    }//GEN-LAST:event_tbVentaMouseClicked

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
                materialMueble.setText(mueble.getMater_mueble());
                stokMueble.setText(String.valueOf(mueble.getStok_mueble()));
                pressMueble.setText(String.valueOf(mueble.getPresi_mueble()));
            } else {
                JOptionPane.showMessageDialog(null, "Mueble no encontrado");
                Vaciar();
                search.requestFocus();
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

    public static void main(String args[]) {
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
    private javax.swing.JButton VaciarTxt;
    private javax.swing.JButton Venta;
    private javax.swing.JButton añadir;
    private javax.swing.JButton buscar;
    private javax.swing.JSpinner cant;
    private javax.swing.JTextField categMueble;
    private javax.swing.JComboBox<String> codClient;
    private javax.swing.JComboBox<String> codEmple;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField pagar;
    private javax.swing.JTextField pressMueble;
    private javax.swing.JButton register;
    private javax.swing.JTextField search;
    private javax.swing.JTextField stokMueble;
    private javax.swing.JTable tbVenta;
    // End of variables declaration//GEN-END:variables
}
