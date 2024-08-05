package VISTA;

import MODELO.MueblesClase;
import MODELO.PedidosClase;
import MODELO.PedidosDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Pedidos extends javax.swing.JFrame {
    
    int codUser;
    int codClient;
    String user;
    String client;
    
    PedidosDAO pedidos = new PedidosDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public Pedidos() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
        Listar();
    }
    
    public void Listar() {
        List<PedidosClase> Lista = pedidos.Listar();

        modelo = (DefaultTableModel) TbPedido.getModel();
        modelo.setRowCount(0);

        for (int i = 0; i < Lista.size(); i++) {
            Object[] ob = new Object[5];
            ob[0] = Lista.get(i).getCod_pedido();
            
            codUser = Lista.get(i).getCod_user_fk();
            user = pedidos.BuscarEmple(codUser);
            
            ob[1] = codUser + " - " + user;
            
            codClient = Lista.get(i).getDni_client_fk();
            client = pedidos.BuscarClient(codClient);
            
            ob[2] = codClient + " - " + client;
            ob[3] = Lista.get(i).getTotal_pedido();

            modelo.addRow(ob);
        }
        TbPedido.setModel(modelo);
    }

    public void Buscar(){
        if(!"".equals(search.getText())){
            int cod = Integer.parseInt(search.getText());
            if(pedidos.Exist(cod)){
                List<PedidosClase> Lista = pedidos.ListarBusca(cod);

                modelo = (DefaultTableModel) TbPedido.getModel();
                modelo.setRowCount(0);

                for (int i = 0; i < Lista.size(); i++) {
                    Object[] ob = new Object[5];
                    ob[0] = Lista.get(i).getCod_pedido();

                    codUser = Lista.get(i).getCod_user_fk();
                    user = pedidos.BuscarEmple(codUser);

                    ob[1] = codUser + " - " + user;

                    codClient = Lista.get(i).getDni_client_fk();
                    client = pedidos.BuscarClient(codClient);

                    ob[2] = codClient + " - " + client;
                    ob[3] = Lista.get(i).getTotal_pedido();

                    modelo.addRow(ob);
                }
                TbPedido.setModel(modelo);
            }
            else{
                JOptionPane.showMessageDialog(null, "ERROR: No se encontro ningun CLIENTE registrado con ese codigo");
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
        jLabel6 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        Ver = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbPedido = new javax.swing.JTable();

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
        jLabel6.setBounds(60, 660, 290, 16);

        search.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(55, 160, 244), 3), "Buscar pedidos de un cliente por codigo...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search);
        search.setBounds(60, 110, 400, 70);

        Ver.setBackground(new java.awt.Color(55, 160, 244));
        Ver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Ver.setForeground(new java.awt.Color(255, 255, 255));
        Ver.setText("ACTUALIZAR");
        Ver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerActionPerformed(evt);
            }
        });
        jPanel1.add(Ver);
        Ver.setBounds(1170, 130, 140, 50);

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
        buscar.setBounds(480, 130, 130, 50);

        TbPedido.setAutoCreateRowSorter(true);
        TbPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TbPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PEDIDO", "EMPLEADO", "CLIENTE", "TOTAL"
            }
        ));
        TbPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TbPedido.setGridColor(new java.awt.Color(204, 204, 204));
        TbPedido.setRowHeight(35);
        TbPedido.setSelectionBackground(new java.awt.Color(85, 183, 252));
        TbPedido.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TbPedido.setShowGrid(true);
        TbPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbPedido);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(50, 200, 1260, 410);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1360, 690);

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

    private void VerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerActionPerformed
        search.setText("");
        Listar();
    }//GEN-LAST:event_VerActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        Buscar();
    }//GEN-LAST:event_buscarActionPerformed

    private void TbPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPedidoMouseClicked
        
    }//GEN-LAST:event_TbPedidoMouseClicked

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_CerrarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Categoria;
    private javax.swing.JButton Cerrar;
    private javax.swing.JButton Clientes;
    private javax.swing.JButton Mueble;
    private javax.swing.JButton Pedidos;
    private javax.swing.JTable TbPedido;
    private javax.swing.JButton Venta;
    private javax.swing.JButton Ver;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton register;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
