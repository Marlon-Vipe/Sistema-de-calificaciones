package Frames;

import Clases.Conectar;
import static Frames.Gestion_alumnos.idalumno;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import java.sql.PreparedStatement;


/**
 *
 * @author Marlon
 */
public class Informacion_alumnos extends javax.swing.JFrame {
    
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    int idalumno = 0;
    
    public static int idcalificacion = 0;
    

    /** Creates new form Informacion_alumnos */
    public Informacion_alumnos() {
        initComponents();
        
        cerrar();
        
        this.setLocationRelativeTo(null);
        
        txtnombre.setEditable(false);
        txtapellido.setEditable(false);
        txttelefono.setEditable(false);
        txtcalificacion.setEditable(false);
        txtestatus.setEditable(false);
        cmbgrado.setEnabled(false);
        
        idalumno = Gestion_alumnos.idalumno;
        
        
        try {
            
                Connection cn = con.conexion();
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno = '"+idalumno+"'");
                ResultSet rs = ps.executeQuery(); 
                
                if (rs.next()) {
                    
                    setTitle("Informacion del alumno: "+rs.getString("nombre"));
                    lblinfo_alumno.setText("Informacion del alumno: "+rs.getString("nombre") );
                    
                    txtnombre.setText(rs.getString("nombre"));
                    txtapellido.setText(rs.getString("apellido"));
                    cmbgrado.setSelectedItem(rs.getString("grado"));
                    txttelefono.setText(rs.getString("telefono"));
                    
                
            }
                
            
        } catch (SQLException e) {
            
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "Error al cargar alumno ... contacte al administrador");
            
        }
        
        //--------------------------------------------------------------------------------------------------------------------------
        
        try {
            
                PreparedStatement pst = cn.prepareStatement("SELECT id_nota,tarea,calificacion FROM notas WHERE id_alumno_nota = '"+idalumno+"'");
                
                ResultSet rs  = pst.executeQuery();
                
                tabla_calificaciones =new JTable(modelo);
                jScrollPane1.setViewportView(tabla_calificaciones);
                
                
                modelo.addColumn("ID_nota");
                modelo.addColumn("Tarea");
                modelo.addColumn("Calificacion");
                
                
                while(rs.next()) {
                
                    Object [] fila = new Object[3];
                    
                    for (int i = 0; i < 3; i++) {
                        
                        
                        fila[i] = rs.getObject(i+1);
                        
                    }
                    
                    modelo.addRow(fila);
                
                    //--------------------------------------------------------------
                    
                    int filax = 0;
                    int total = 0;
                    
                    for (int i = 0; i < tabla_calificaciones.getRowCount(); i++) {
                        
                        filax = Integer.parseInt(tabla_calificaciones.getValueAt(i,2).toString());
                        
                        total += filax;
                        
                        txtcalificacion.setText(""+total);
                        
                    }
                    
                    
                    int califa = Integer.parseInt(txtcalificacion.getText());
                    
                    if (califa >= 70) {
                        
                        txtestatus.setText(String.valueOf("Aprobado"));
                        txtcalificacion.setBackground(Color.GREEN);
                      
                    }else {
                        
                        txtestatus.setText(String.valueOf("Reprobado"));
                        txtcalificacion.setBackground(Color.RED);
                    
                    }
                    
                    
                    
                    
                    
                }
            
            
        } catch (Exception e) {
            
            System.err.println("Error en el llenado de la tabla calificaciones");
            
        }
        
        tabla_calificaciones.addMouseListener(new MouseAdapter() {
        
                @Override
                public void mouseClicked(MouseEvent e) {
                
                    int fila_point = tabla_calificaciones.rowAtPoint(e.getPoint());
                    int columna_point = 0;
                    
                    
                    if (fila_point > -1) {
                        
                        idcalificacion = (int)modelo.getValueAt(fila_point,columna_point);
                        
                        Informacion_Calificaciones informacion_calificaciones = new Informacion_Calificaciones();
                        informacion_calificaciones.setVisible(true);
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

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblinfo_alumno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        cmbgrado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_calificaciones = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtestatus = new javax.swing.JTextField();
        btnvolver = new javax.swing.JButton();
        btnregistrar_alumnos = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtcalificacion = new javax.swing.JTextField();
        btnimprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        lblinfo_alumno.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lblinfo_alumno.setForeground(new java.awt.Color(0, 0, 0));
        lblinfo_alumno.setText("Informacion alumno");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Grado");

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefono");

        cmbgrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione grado", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        tabla_calificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_calificaciones);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Estatus:");

        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver-flecha.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        btnregistrar_alumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registro.png"))); // NOI18N
        btnregistrar_alumnos.setText("Registrar calificacion");
        btnregistrar_alumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrar_alumnosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Calificacion");

        btnimprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/impresora.png"))); // NOI18N
        btnimprimir.setText("IMPRIMIR");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblinfo_alumno)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(13, 13, 13)))
                        .addComponent(txtestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtnombre)
                            .addComponent(txtapellido)
                            .addComponent(txttelefono)
                            .addComponent(cmbgrado, 0, 168, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(btnvolver, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnregistrar_alumnos)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcalificacion))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)))))
                .addGap(96, 96, 96))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblinfo_alumno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtestatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4)
                        .addGap(8, 8, 8)
                        .addComponent(cmbgrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnvolver)
                        .addComponent(btnregistrar_alumnos))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtcalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnimprimir)
                .addGap(14, 14, 14))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        
        Gestion_alumnos gestion_alumnos = new Gestion_alumnos();
        gestion_alumnos.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnregistrar_alumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrar_alumnosActionPerformed
        
        Registrar_calificaciones registrar_calificaciones = new Registrar_calificaciones();
        registrar_calificaciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnregistrar_alumnosActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        
        Document documento = new Document();
        
        Calendar cal = Calendar.getInstance();
        Date fecha = new Date(cal.getTimeInMillis());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String verfecha = formato.format(fecha);
        
        try {
            
                String ruta = System.getProperty("user.home");
                PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/desktop/"+txtnombre.getText()+".pdf"));
                
                Paragraph parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.setFont(FontFactory.getFont("Arial", 20, BaseColor.BLACK));
                parrafo.add("Informacion del alumno. \n \n");
                
                
                Paragraph poner_fecha = new Paragraph();
                poner_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
                poner_fecha.add("Fecha: "+verfecha+"\n \n");
                
                
                documento.open();
                documento.add(parrafo);
                
                documento.add(poner_fecha);
                
                PdfPTable tabla_alumno = new PdfPTable(4);
                
                tabla_alumno.addCell("Nombre");
                tabla_alumno.addCell("Apellido");
                tabla_alumno.addCell("Grado");
                tabla_alumno.addCell("Materia");
                
                
                try {
                
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno = '"+idalumno+"'");
                
                ResultSet rs = ps.executeQuery();
                
                
                    if (rs.next()) {
                        
                        
                        do {
                            
                            tabla_alumno.addCell(rs.getString(2));
                            tabla_alumno.addCell(rs.getString(3));
                            tabla_alumno.addCell(rs.getString(4));
                            tabla_alumno.addCell(rs.getString(6));
                            
                        } while (rs.next());{
                    
                                documento.add(tabla_alumno);
                    
                    }
                        
                        
                    }
                    
                    
                    Paragraph parrafo2 = new Paragraph();
                    parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo2.setFont(FontFactory.getFont("Arial",20, BaseColor.BLACK));
                    parrafo2.add("\n \n Tareas registradas \n \n");
                    
                    
                    documento.add(parrafo2);
                    PdfPTable tabla_tareas = new PdfPTable(2);
                    
                    
                    tabla_tareas.addCell("Tarea");
                    tabla_tareas.addCell("Calificacion");
                    
                    
                    
                    try {
                        Connection cn2 = con.conexion();
                        PreparedStatement ps2 = cn2.prepareStatement("SELECT tarea,calificacion FROM notas WHERE id_alumno_nota = '"+idalumno+"'");
                        
                        ResultSet rs2 = ps2.executeQuery();
                        
                        
                        if (rs2.next()) {
                            
                            do {
                                
                                tabla_tareas.addCell(rs2.getString(1));
                                tabla_tareas.addCell(rs2.getString(2));
                                
                                
                                
                                
                            } while (rs2.next());{
                        
                                
                                    documento.add(tabla_tareas);
                        
                        }
                            
                            
                        }
                        
                    } catch (SQLException e) {
                        
                        
                        System.err.println("Error al cargar tareas"+e);
                    }
                    
                    
    //----------------------------------------------------------------------------------------                
                    
                    
            } catch (SQLException e) {
                
                
                    System.err.println("Error al obtener datos del alumno"+e);
            }
                
    //------------------------------------------------------------------------------------------------------
    
    documento.close();
    JOptionPane.showMessageDialog(null, "Documento agregado con exito");
            
        } catch (DocumentException  | IOException e) {
            
            
            System.err.println("Error en pdf o en la ruta"+e);
            
            
            JOptionPane.showMessageDialog(null, "Error al generar PDF ... contacte al administrador");
        }
        
        
        
        
        
    }//GEN-LAST:event_btnimprimirActionPerformed

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
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnregistrar_alumnos;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cmbgrado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblinfo_alumno;
    private javax.swing.JTable tabla_calificaciones;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcalificacion;
    private javax.swing.JTextField txtestatus;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    Conectar con = new Conectar();
    Connection cn = con.conexion();
    
    
}
