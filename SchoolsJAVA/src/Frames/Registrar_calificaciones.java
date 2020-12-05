package Frames;

import Clases.Conectar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Marlon
 */
public class Registrar_calificaciones extends javax.swing.JFrame {
    
    int idalumno = 0;
    
    String nombre_alumno = "";
    String nombre_curso = "";
    

  
    public Registrar_calificaciones() {
        initComponents();
        cerrar();
        
        TextPrompt tarea = new TextPrompt("Ingresa tarea",txttarea);
        TextPrompt calificacion = new TextPrompt("Ingresa calificacion",txtcalificacion);
        
        this.setLocationRelativeTo(null);
        
        txtnombre.setEditable(false);
        cmbcurso.setEnabled(false);
        
        cargarcombocurso(cmbcurso);
        
        idalumno = Gestion_alumnos.idalumno;
        
        try {
            
            PreparedStatement ps = cn.prepareStatement("SELECT nombre FROM alumnos WHERE id_alumno = '"+idalumno+"'");
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                nombre_alumno = rs.getString("nombre");
                
            }
            
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al consultar nombre del alumno");
        }
        
        txtnombre.setText(nombre_alumno);
        
        //----------------------------------------------------------------------------
        
        try{
            
            PreparedStatement ps = cn.prepareStatement("SELECT id_curso_asignado FROM alumnos WHERE id_alumno = '"+idalumno+"'");
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                nombre_curso = rs.getString("id_curso_asignado");
                
            }
            
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al consultar el curso del alumno");
    }
        
        cmbcurso.setSelectedItem(nombre_curso);

    }
    
    //-----------------------------------------------------------------------------
    
    public void cargarcombocurso (JComboBox combodelcurso){
        
        try {
            
                String sql = "SELECT nombre_curso FROM curso";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                
                while (rs.next()) {
                    
                    combodelcurso.addItem(rs.getString("nombre_curso"));
                
                
                }
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al cargar datos en el Combobox");
            
        }
        
        
    
    }
    
    
    //--------------------------------------
    
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txttarea = new javax.swing.JTextField();
        cmbcurso = new javax.swing.JComboBox<>();
        txtcalificacion = new javax.swing.JTextField();
        btnregistrar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Registrar calificaciones");

        jLabel2.setText("Alumno:");

        jLabel3.setText("Tarea:");

        jLabel4.setText("Curso:");

        jLabel5.setText("Calificacion");

        cmbcurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciones materia" }));

        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro.png"))); // NOI18N
        btnregistrar.setText("Registrar");
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });

        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver-flecha.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre)
                    .addComponent(txttarea)
                    .addComponent(cmbcurso, 0, 162, Short.MAX_VALUE)
                    .addComponent(txtcalificacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnvolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnregistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbcurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnvolver)
                    .addComponent(txtcalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
        
        String curso = cmbcurso.getSelectedItem().toString();
        
        
        try {
            
                if (txttarea.getText().isEmpty()) {
                
                    JOptionPane.showMessageDialog(null,"No puedes dejar el campo Tarea vacio");
            }
                
          //----------------------------------------------------------------------------------------------      
                else if (txtcalificacion.getText().isEmpty()) {
                
                    JOptionPane.showMessageDialog(null,"No puedes dejar el campo Calificacion vacio");
            }
                
          //-------------------------------------------------------------
          
                else {
                
                    PreparedStatement ps = cn.prepareStatement("INSERT INTO notas (id_alumno_nota, id_curso_nota, tarea, calificacion) VALUES (?,?,?,?)");
                 
                    ps.setInt(1,idalumno);
                    ps.setString(2, curso);
                    ps.setString(3, txttarea.getText());
                    ps.setString(4, txtcalificacion.getText());
                    
                    ps.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Datos guardados exisotamente");
                }
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al guardar datos de calificaciones");
            
        }
        
        
    }//GEN-LAST:event_btnregistrarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        
        Informacion_alumnos info_alumnos = new Informacion_alumnos();
        info_alumnos.setVisible(true);
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
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_calificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_calificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cmbcurso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtcalificacion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttarea;
    // End of variables declaration//GEN-END:variables

    Conectar con = new Conectar();
    Connection cn = con.conexion();


}
