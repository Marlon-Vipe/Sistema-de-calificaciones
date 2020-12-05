package Frames;

import Clases.Conectar;
import java.awt.event.MouseAdapter;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


/**
 *
 * @author Marlon
 */
public class Gestion_alumnos extends javax.swing.JFrame {
    
    public static int idalumno = 0;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Gestion_alumnos
     */
    public Gestion_alumnos() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        cerrar();
        
        
        
        try {
            
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM alumnos");
                ResultSet rs = ps.executeQuery();
                
                tabla_gestion_alumnos = new JTable(model);
                jScrollPane1.setViewportView(tabla_gestion_alumnos);
                
                model.addColumn("Id");
                model.addColumn("Nombre");
                model.addColumn("Apellido");
                model.addColumn("Grado");
                model.addColumn("Telefono");
                
                
                while(rs.next()){
                
                    Object [] fila = new Object [5];
                    
                    for (int i = 0; i < 5; i++) {
                        
                        fila[i] = rs.getObject(i+1);
                        
                        
                    }
                    
                    model.addRow(fila);
                    
                    
                }
                
                cn.close();
            
        } catch (SQLException e) {
            
            System.err.println("Error en el llenado de la tabla");
        }
        
        //---------------------------------------------
        
        tabla_gestion_alumnos.addMouseListener(new MouseAdapter() {
        
                @Override
                public void mouseClicked(MouseEvent e) {
                
                    int fila_point = tabla_gestion_alumnos.rowAtPoint(e.getPoint());
                    int columna_point = 0;
                    
                    
                    if (fila_point > -1) {
                        
                        idalumno = (int)model.getValueAt(fila_point,columna_point);
                        
                        Informacion_alumnos informacion_alumnos = new Informacion_alumnos();
                        informacion_alumnos.setVisible(true);
                        dispose();
                    }
                    
                }
        });
        
    }
    
    public void cerrar() {
    
        try {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
            
                public void windowClosing(WindowEvent e){
                    
                    confirmarsalida();
                }
            });
            
            
        } catch (Exception e) {
        }
    }
    
    public void confirmarsalida(){
        
        int valor = JOptionPane.showConfirmDialog
        (this,"Desea cerrar la aplicacion?","Advertencia",JOptionPane.YES_NO_OPTION
        ,JOptionPane.WARNING_MESSAGE);
        
        if(valor == JOptionPane.YES_NO_OPTION){
            JOptionPane.showMessageDialog(null,"Hasta pronto","",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnvolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_gestion_alumnos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnvolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        tabla_gestion_alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_gestion_alumnos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 610, 340));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestion de alumnos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pngtree-welcome-back-to-school-background-image_389856.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion_alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnvolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_gestion_alumnos;
    // End of variables declaration//GEN-END:variables

    
    Conectar con = new Conectar();
    Connection cn = con.conexion();
    

}
