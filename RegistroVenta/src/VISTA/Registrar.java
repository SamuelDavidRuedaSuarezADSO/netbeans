/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import MODELO.RegistrarClase;
import MODELO.RegistrarDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Propietario
 */
public class Registrar extends javax.swing.JFrame {

    RegistrarClase rg = new RegistrarClase();
    RegistrarDAO register = new RegistrarDAO();
    
    /**
     * Creates new form Registrar
     */
    public Registrar() {
        initComponents();
        this.setBounds(0,0,1350,725);
        this.setLocationRelativeTo(null);
        register.Consultar(rol);
    }

    public void vaciar(){
        nomUser.setText("");
        mailUser.setText("");
        contraseña.setText("");
        confiContra.setText("");
        rol.setSelectedItem("Seleccione un rol...");
    }
    
    public void  registrar(){
        
        if(!"".equals(nomUser.getText()) || !"".equals(mailUser.getText()) || !"".equals(String.valueOf(contraseña.getPassword())) || !"".equals(String.valueOf(confiContra.getPassword()))){
            if(mailUser.getText().contains("@") && mailUser.getText().contains(".com")){
                if(!"Seleccione un rol...".equals(rol.getSelectedItem())){
                    String contra = String.valueOf(contraseña.getPassword());
                    String contraC = String.valueOf(confiContra.getPassword());
                    if(contra.equals(contraC)){
                        rg.setNom_user(nomUser.getText());
                        rg.setEmail_user(mailUser.getText());
                        rg.setContra_user( String.valueOf(contraseña.getPassword()));
                        
                        String selectRol = (String) rol.getSelectedItem();
                        String codrol = selectRol.split(" - ")[0];
                        
                        int cod = Integer.parseInt(codrol);
                        
                        rg.setCod_rol_fk(cod);
                        
                        if(register.Registrar(rg)){
                            JOptionPane.showMessageDialog(null, "Usuario registrado");
                        }
                        
                        
                        
                        vaciar();
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "ERROR: Las CONTRASELAS no coinciden");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"ERROR: Seleccione un rol");
                }                
            }
            else{
                JOptionPane.showMessageDialog(null,"ERROR: El CORREO no es valido");
            }
        }else{
            JOptionPane.showMessageDialog(null,"ERROR: Seleccione todos los campos");
        }
        
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
        jLabel3 = new javax.swing.JLabel();
        nomUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        Iniciar = new javax.swing.JButton();
        contraseña = new javax.swing.JPasswordField();
        mailUser = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        confiContra = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        rol = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(4, 72, 126), 5, true));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(2, 55, 97));
        jLabel3.setText("REGISTAR NUEVO USUARIO");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 30, 480, 48);

        nomUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 90, 138), 3));
        nomUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomUserActionPerformed(evt);
            }
        });
        jPanel1.add(nomUser);
        nomUser.setBounds(130, 150, 340, 40);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(29, 90, 138));
        jLabel2.setText("Nombre de usuario:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 120, 170, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(29, 90, 138));
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(130, 280, 110, 25);

        Cancelar.setBackground(new java.awt.Color(29, 90, 138));
        Cancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        Cancelar.setText("CANCELAR");
        Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarMouseClicked(evt);
            }
        });
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(Cancelar);
        Cancelar.setBounds(310, 580, 240, 40);

        Iniciar.setBackground(new java.awt.Color(55, 160, 244));
        Iniciar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Iniciar.setForeground(new java.awt.Color(255, 255, 255));
        Iniciar.setText("AGREGAR");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });
        jPanel1.add(Iniciar);
        Iniciar.setBounds(50, 580, 240, 40);

        contraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 90, 138), 3));
        jPanel1.add(contraseña);
        contraseña.setBounds(130, 310, 340, 40);

        mailUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 90, 138), 3));
        mailUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailUserActionPerformed(evt);
            }
        });
        jPanel1.add(mailUser);
        mailUser.setBounds(130, 230, 340, 40);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(29, 90, 138));
        jLabel5.setText("Email de usuario:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(130, 200, 170, 25);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(29, 90, 138));
        jLabel6.setText("Contraseña:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(130, 360, 110, 25);

        confiContra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 90, 138), 3));
        jPanel1.add(confiContra);
        confiContra.setBounds(130, 390, 340, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(29, 90, 138));
        jLabel7.setText("Rol:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(130, 440, 110, 25);

        rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un rol..." }));
        rol.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(29, 90, 138)));
        jPanel1.add(rol);
        rol.setBounds(130, 470, 340, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(370, 20, 590, 660);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/fondoArreglo.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-510, -220, 2400, 1300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomUserActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CancelarActionPerformed

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        registrar();
        vaciar();
    }//GEN-LAST:event_IniciarActionPerformed

    private void mailUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailUserActionPerformed

    private void CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseClicked
        Ventas vt = new Ventas();
        vt.setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelarMouseClicked

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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Iniciar;
    private javax.swing.JPasswordField confiContra;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mailUser;
    private javax.swing.JTextField nomUser;
    private javax.swing.JComboBox<String> rol;
    // End of variables declaration//GEN-END:variables
}
