
package VISTA;

import MODELO.ClienteDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import MODELO.VentaDAO;
import MODELO.VentaFactu;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class NewVentaAdmin extends javax.swing.JFrame {

    double res = 0;
    ClienteDAO client = new ClienteDAO();
    VentaDAO sells = new VentaDAO();
    VentaFactu vf = new VentaFactu();
    
    
    public NewVentaAdmin(ArrayList<Object[]> datosSeleccionados, String nomEmple, String nomClient, double totalP, int cod) {
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
    
    public NewVentaAdmin() {
        initComponents();
    }
   
    public void Confirmar(){
        if(Double.parseDouble(totalF.getText()) <= Double.parseDouble(pagaCon.getText())){
            double total = Double.parseDouble(totalF.getText());
            double paga = Double.parseDouble(pagaCon.getText());
            
            res = paga - total;
            
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
            pdf();
        }
        else{
            JOptionPane.showMessageDialog(null, "ERROR: Valor de PAGO no valido");
        }
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
        nombreE.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(nombreE);
        nombreE.setBounds(150, 70, 290, 40);

        nombreC.setEditable(false);
        nombreC.setBackground(new java.awt.Color(255, 255, 255));
        nombreC.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
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
        totalF.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
        jPanel1.add(totalF);
        totalF.setBounds(150, 370, 290, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("TOTAL:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 380, 80, 20);

        pagaCon.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(81, 141, 5)));
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
        Confirmar();
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
            java.util.logging.Logger.getLogger(NewVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
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

                new NewVentaAdmin(datosEjemplo, nomEmple, nomClient, totalP, cod).setVisible(true);
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
    
    private void pdf(){
        
        try {
            int codF = client.codFact(Integer.parseInt(codP.getText()));
            int ped = Integer.parseInt(codP.getText());
            
            
            // Obtener la carpeta de Descargas
            String home = System.getProperty("user.home");
            File downloadsFolder = new File(home, "Downloads");

            // Generar un nombre único para el archivo PDF
            String fileName = "Factura_" + codF + "_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".pdf";
            File file = new File(downloadsFolder, fileName);

            FileOutputStream archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            Image img = Image.getInstance("src/IMAGENES/Logo.png");
            
            Paragraph fecha = new Paragraph();
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Factura: " + codF + "\n" + "Pedido: "+ ped +"\n" + "Fecha: " + new SimpleDateFormat("dd-MM-yyyy").format(date)+"\n\n");
            
            PdfPTable encabe = new PdfPTable(3);
            encabe.setWidthPercentage(100);
            encabe.getDefaultCell().setBorder(0);
            float[] columnaE = new float[]{40f, 60f, 40f};
            encabe.setWidths(columnaE);
            encabe.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            encabe.addCell(img);
            encabe.addCell("");
            encabe.addCell(fecha);
            doc.add(encabe);
            
            Paragraph emp = new Paragraph();
            emp.add(Chunk.NEWLINE);
            emp.add("DATOS DEL EMPLEADO: " + "\n\n");
            doc.add(emp);
            
            PdfPTable tbEmp = new PdfPTable( 2);
            tbEmp.setWidthPercentage(100);
            tbEmp.getDefaultCell().setBorder(0);
            float[] columnaEm = new float[]{30f, 120f};
            tbEmp.setWidths(columnaEm);
            tbEmp.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell em1 = new PdfPCell(new Phrase("NOMBRE: "));
            em1.setBorder(0);
            
            tbEmp.addCell(em1);
            
            tbEmp.addCell(nombreE.getText());
            
            doc.add(tbEmp);
            
            
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("DATOS DEL CLIENTE: " + "\n\n");
            doc.add(cli);
            
            PdfPTable tbCli = new PdfPTable( 2);
            tbCli.setWidthPercentage(100);
            tbCli.getDefaultCell().setBorder(0);
            float[] columnaC = new float[]{30f, 120f};
            tbCli.setWidths(columnaC);
            tbCli.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cl1 = new PdfPCell(new Phrase("NOMBRE: "));
            cl1.setBorder(0);

            tbCli.addCell(cl1);
            tbCli.addCell(nombreC.getText());
            
            doc.add(tbCli);

            Paragraph pro = new Paragraph();
            pro.add(Chunk.NEWLINE);
            pro.add("Productos Seleccionados: " + "\n\n");
            doc.add(pro);
            
            //productos
            PdfPTable tbPro = new PdfPTable(tbDeta.getColumnCount());
            tbPro.setWidthPercentage(100);
            tbPro.getDefaultCell().setBorder(0);
            float[] columnaP = new float[tbDeta.getColumnCount()];
            for (int i = 0; i < columnaP.length; i++) {
                columnaP[i] = 30f; // Ajusta según tus necesidades
            }
            tbPro.setWidths(columnaP);
            tbPro.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Agregar encabezados de columna
            for (int col = 0; col < tbDeta.getColumnCount(); col++) {
                PdfPCell cell = new PdfPCell(new Phrase(tbDeta.getColumnName(col)));
                cell.setBorder(0);
                tbPro.addCell(cell);
            }

            // Agregar datos de la JTable
            for (int row = 0; row < tbDeta.getRowCount(); row++) {
                for (int col = 0; col < tbDeta.getColumnCount(); col++) {
                    Object value = tbDeta.getValueAt(row, col);
                    PdfPCell cell = new PdfPCell(new Phrase(value != null ? value.toString() : ""));
                    cell.setBorder(0);
                    tbPro.addCell(cell);
                }
            }
            doc.add(tbPro);
            
                        
            // Espacio antes de los totales
            doc.add(Chunk.NEWLINE);

            // Totales
            PdfPTable tbTot = new PdfPTable(2);
            tbTot.setWidthPercentage(100);
            tbTot.getDefaultCell().setBorder(0);
            float[] columnaT = new float[]{30f, 140f};
            tbTot.setWidths(columnaT);
            tbTot.setHorizontalAlignment(Element.ALIGN_RIGHT);

            PdfPCell tot1 = new PdfPCell(new Phrase("TOTAL: "));
            tot1.setBorder(0);

            tbTot.addCell(tot1);
            tbTot.addCell(totalF.getText());
            
            doc.add(tbTot);

            PdfPTable tbCam = new PdfPTable(2);
            tbCam.setWidthPercentage(100);
            tbCam.getDefaultCell().setBorder(0);
            float[] columnaCam = new float[]{30f, 140f};
            tbCam.setWidths(columnaCam);
            tbCam.setHorizontalAlignment(Element.ALIGN_RIGHT);

            PdfPCell cam = new PdfPCell(new Phrase("CAMBIO: "));
            cam.setBorder(0);

            tbCam.addCell(cam);
            tbCam.addCell(String.valueOf(res));

            doc.add(tbCam);
            
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);

            
            Paragraph gracias = new Paragraph();
            gracias.add(Chunk.NEWLINE);
            gracias.add("¡GRACIAS POR LA COMPRA!");
            gracias.setAlignment(Element.ALIGN_CENTER); // Centrar el mensaje
            doc.add(gracias);
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
