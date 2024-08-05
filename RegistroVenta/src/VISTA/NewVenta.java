
package VISTA;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import MODELO.VentaDAO;
import MODELO.VentaFactu;
import javax.swing.table.DefaultTableModel;

public class NewVenta extends javax.swing.JFrame {

    VentaDAO sells = new VentaDAO();
    VentaFactu vf = new VentaFactu();
    
    
    public NewVenta(ArrayList<Object[]> datosSeleccionados, String nomEmple, String nomClient, double totalP, int cod) {
        // Inicialización de componentes...
        initComponents();
        this.setBounds(0,0,506,600);
        this.setLocationRelativeTo(null);
        
        
        // Mostrar datos del empleado, cliente y total
        nombreE.setText(nomEmple);
        nombreC.setText(nomClient);
        totalF.setText(String.valueOf(totalP));
        pagaCon.setText(String.valueOf(totalP));
        codP.setText(String.valueOf(cod));
        
        // Configurar la tabla con los datos recibidos
        DefaultTableModel model = (DefaultTableModel) tbDeta.getModel();
        for (Object[] fila : datosSeleccionados) {
            model.addRow(fila);
        }
    }
    
    public NewVenta() {
        initComponents();
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreE = new javax.swing.JTextField();
        nombreC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDeta = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        totalF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pagaCon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        codP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("ULTIMOS DETALLES");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 10, 180, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("EMPLEADO:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 80, 80, 20);

        nombreE.setEditable(false);
        nombreE.setBackground(new java.awt.Color(255, 255, 255));
        nombreE.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(nombreE);
        nombreE.setBounds(150, 70, 290, 40);

        nombreC.setEditable(false);
        nombreC.setBackground(new java.awt.Color(255, 255, 255));
        nombreC.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(nombreC);
        nombreC.setBounds(150, 130, 290, 40);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("CONTENIDO:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 190, 110, 20);

        tbDeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "CANTIDAD", "VALOR/U", "VALOR/T"
            }
        ));
        jScrollPane1.setViewportView(tbDeta);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 220, 452, 140);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("CLIENTE:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 140, 80, 20);

        totalF.setEditable(false);
        totalF.setBackground(new java.awt.Color(255, 255, 255));
        totalF.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(totalF);
        totalF.setBounds(150, 370, 290, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("TOTAL:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 380, 80, 20);

        pagaCon.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(55, 160, 244)));
        jPanel1.add(pagaCon);
        pagaCon.setBounds(150, 430, 290, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("PAGA CON:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 440, 80, 20);

        cancelar.setBackground(new java.awt.Color(243, 33, 33));
        cancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(cancelar);
        cancelar.setBounds(30, 510, 110, 40);

        confirmar.setBackground(new java.awt.Color(0, 182, 18));
        confirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmar.setForeground(new java.awt.Color(255, 255, 255));
        confirmar.setText("CONFIRMAR");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        jPanel1.add(confirmar);
        confirmar.setBounds(350, 510, 120, 40);

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("CODIGO PEDIDO:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 590, 100, 16);

        codP.setEditable(false);
        jPanel1.add(codP);
        codP.setBounds(110, 580, 110, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 490, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cancelarActionPerformed

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        if(Double.parseDouble(totalF.getText()) <= Double.parseDouble(pagaCon.getText())){
            double total = Double.parseDouble(totalF.getText());
            double paga = Double.parseDouble(pagaCon.getText());
            
            double res = paga - total;
            
            int codPedido = Integer.parseInt(codP.getText());
            
            vf.setCod_pedido_fk(codPedido);
            vf.setTotal_factu(total);
            vf.setCambio_factu(res);
            sells.registrarFactu(vf);
            
            if(res == 0){
                JOptionPane.showMessageDialog(null, "Venta Realizada con exito");
                dispose();
            }
            else{
                String mensaj = "El cambio o vueltos corresponden a $" + res;
                JOptionPane.showMessageDialog(null, mensaj);
                JOptionPane.showMessageDialog(null, "Venta Realizada con exito");
                dispose();
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR: Valor de PAGO no valido");
        }
    }//GEN-LAST:event_confirmarActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(NewVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Ejemplo de datos para inicialización
                ArrayList<Object[]> datosEjemplo = new ArrayList<>();
                datosEjemplo.add(new Object[]{"Producto A", 2, 50.0, 100.0});
                datosEjemplo.add(new Object[]{"Producto B", 1, 30.0, 30.0});
                
                String nomEmple = "Empleado Ejemplo";
                String nomClient = "Cliente Ejemplo";
                double totalP = 130.0;
                int cod = 1;

                new NewVenta(datosEjemplo, nomEmple, nomClient, totalP, cod).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codP;
    private javax.swing.JButton confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreC;
    private javax.swing.JTextField nombreE;
    private javax.swing.JTextField pagaCon;
    private javax.swing.JTable tbDeta;
    private javax.swing.JTextField totalF;
    // End of variables declaration//GEN-END:variables
}
