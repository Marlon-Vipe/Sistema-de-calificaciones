package Frames;

import Clases.Conectar;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import java.sql.PreparedStatement;

/**
 *
 * @author Marlon
 */
public class Registrar_alumnos extends javax.swing.JFrame {

    /**
     * Creates new form Registrar_alumnos
     */
    public Registrar_alumnos() {
        initComponents();
        
        TextPrompt nombre = new TextPrompt("Escribe tu nombre",txtnombre);
        TextPrompt apellido = new TextPrompt("Escribe tu apellido",txtapellido);
        TextPrompt telefono = new TextPrompt("Escribe tu telefono",txttelefono);
        TextPrompt buscar = new TextPrompt("Buscar",txtbuscar);
        
        this.setLocationRelativeTo(null);
        
        
        limpiar();
        
        txtid_alumnos.setEnabled(false);
        txtcantidad.setEditable(false);
        
        
        mostrartabla("");
        cerrar();
        cargarcombocurso(cmb_materia);
        
        for(int i=0; i <= tabla_registro_alumnos.getRowCount(); i++){
                        
                        
                        txtcantidad.setText(" "+i);
     
                    }
        
    }
    
    void limpiar() {
    
        txtid_alumnos.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txttelefono.setText("");
        cmb_grado.setSelectedIndex(0);
        cmb_materia.setSelectedIndex(0);
        
    }
    
    void mostrartabla(String valor) {
    
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Grado");
        modelo.addColumn("Materia");
        
        tabla_registro_alumnos.setModel(modelo);
        
        String sql = "SELECT * FROM alumnos WHERE CONCAT (nombre,' ',apellido,' ',grado,' ',id_curso_asignado) LIKE '%"+valor+"%'";
        
        String datos [] = new String [6];
        
        Statement st;
        
        try {
            
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
            
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
                
                modelo.addRow(datos);
                
            }
            
            tabla_registro_alumnos.setModel(modelo);
            
        } catch (SQLException e) {
            
            System.err.println(e);
            
        }
        
    }
    
    
    public void cargarcombocurso(JComboBox combodelcurso) {
        
        try {
            
                String sql = "SELECT nombre_curso FROM curso";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                
                while(rs.next()) {
                
                    combodelcurso.addItem(rs.getString("nombre_curso"));
                
                }
            
            
        } catch (SQLException e) {
            
            System.err.println(e);
        }
    
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popborrar = new javax.swing.JPopupMenu();
        popeliminar = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_registro_alumnos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnagregar = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        txtid_alumnos = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        cmb_grado = new javax.swing.JComboBox<>();
        cmb_materia = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        popeliminar.setText("Borrar");
        popeliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popeliminarActionPerformed(evt);
            }
        });
        popborrar.add(popeliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setText("Buscar:");

        jLabel10.setText("Cantidad:");

        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 500, 90));

        tabla_registro_alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_registro_alumnos.setComponentPopupMenu(popborrar);
        tabla_registro_alumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_registro_alumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_registro_alumnos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 500, 280));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alumnos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel3.setText("ID Alumno:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Apellidos:");

        jLabel6.setText("Grado:");

        jLabel7.setText("Telefono:");

        jLabel8.setText("Materia:");

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuario (1).png"))); // NOI18N
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btnvolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver-flecha.png"))); // NOI18N
        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        cmb_grado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione grado", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cmb_materia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione materia" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmb_grado, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtapellido, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtid_alumnos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmb_materia, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnagregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnvolver)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtid_alumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmb_grado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmb_materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar)
                    .addComponent(btnactualizar)
                    .addComponent(btnvolver))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 350, 390));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro de alumnos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2357c6c0ce98502.jpg"))); // NOI18N
        jLabel1.setText("Regis");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void popeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popeliminarActionPerformed
                
        try {
            
                PreparedStatement ps = cn.prepareStatement("DELETE FROM alumnos WHERE id_alumno = '"+txtid_alumnos.getText()+"'");
                
                int respuesta = ps.executeUpdate();
                
                if(respuesta>0){
                
                    JOptionPane.showMessageDialog(null, "Alumno eliminado");
                    limpiar();
                    mostrartabla("");
                    
                    for(int i=0; i <= tabla_registro_alumnos.getRowCount(); i++){
                        
                        
                        txtcantidad.setText(" "+i);
     
                    }
                    
                
                }else {
                
                        JOptionPane.showMessageDialog(null, "No ha seleccionado fila");
                }
                
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al actualizar alumno");
            
        }
        
        
        
    }//GEN-LAST:event_popeliminarActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        
        String id_curso_asignado = cmb_materia.getSelectedItem().toString();
        String materia = (String)cmb_materia.getSelectedItem();
        String grado = (String) cmb_grado.getSelectedItem();
        
        
        try {
            
            if(txtnombre.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null,"No puedes dejar el cambo nombre vacio");
            }
            ////////////////////////////////////////////////////////////////////////
            else if(txtapellido.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null,"No puedes dejar el cambo apellidos vacio");
            }
            
            ////////////////////////////////////////////////////////////////////////////////////
            
            else if(txttelefono.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null,"No puedes dejar el cambo telefono vacio");
            }
            
            ///////////////////////////////////////////////////////////////////////////////////
            
            else if(grado.equals("Seleccione grado")){
                
                JOptionPane.showMessageDialog(null,"Debe seleccionar un grado");
            }
            
            /////////////////////////////////////////////////////////////////////////////////
            
            
            else if(materia.equals("Seleccione grado")){
                
                JOptionPane.showMessageDialog(null,"Debe seleccionar una materia");
            }
            
            else {
                
                PreparedStatement ps = cn.prepareStatement("INSERT INTO alumnos (nombre,apellido,grado,telefono,id_curso_asignado) VALUES(?,?,?,?,?)");
                ps.setString(1, txtnombre.getText());
                ps.setString(2, txtapellido.getText());
                ps.setString(3, cmb_grado.getSelectedItem().toString());
                ps.setString(4, txttelefono.getText());
                ps.setString(5, id_curso_asignado);
                
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Alumno registrado con exito");
                mostrartabla("");
                limpiar();
                
                for(int i=0; i <= tabla_registro_alumnos.getRowCount(); i++){
                        
                        
                        txtcantidad.setText(" "+i);
     
                    }
             
            }
            
        } catch (SQLException e) {
            
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Error al guardar alumno... contacta al administrador");
            
        }
        
        
    }//GEN-LAST:event_btnagregarActionPerformed

    private void tabla_registro_alumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_registro_alumnosMouseClicked
        
        int fila = this.tabla_registro_alumnos.getSelectedRow();
        
        this.txtid_alumnos.setText(this.tabla_registro_alumnos.getValueAt(fila, 0).toString());
        this.txtnombre.setText(this.tabla_registro_alumnos.getValueAt(fila, 1).toString());
        this.txtapellido.setText(this.tabla_registro_alumnos.getValueAt(fila, 2).toString());
        this.cmb_grado.setSelectedItem(this.tabla_registro_alumnos.getValueAt(fila,3).toString());
        this.txttelefono.setText(this.tabla_registro_alumnos.getValueAt(fila, 4).toString());
        this.cmb_materia.setSelectedItem(this.tabla_registro_alumnos.getValueAt(fila,5).toString());
        
        
    }//GEN-LAST:event_tabla_registro_alumnosMouseClicked

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        
        String materia = (String) cmb_materia.getSelectedItem();
        String grado = (String) cmb_grado.getSelectedItem();
        
        
        try {
            
                if(txtnombre.getText().isEmpty()){
                    
                    JOptionPane.showMessageDialog(null, "No puedes dejar el campo nombre vacio");
                   
                }
                
                //------------------------------------------------------------------------------------------------------
                
                
                else if(txtapellido.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null,"No puedes dejar el cambo apellidos vacio");
            }
            
                //--------------------------------------------------------------------------------------------------------
            
            else if(txttelefono.getText().isEmpty()){
                
                JOptionPane.showMessageDialog(null,"No puedes dejar el cambo telefono vacio");
            }
            
                    ///////////////////////////////////////////////////////////////////////////////////
            
            else if(grado.equals("Seleccione grado")){
                
                JOptionPane.showMessageDialog(null,"Debe seleccionar un grado");
            }
            
                    /////////////////////////////////////////////////////////////////////////////////
            
            
            else if(materia.equals("Seleccione grado")){
                
                JOptionPane.showMessageDialog(null,"Debe seleccionar una materia");
            }
                
                //-----------------------------------------------------------------
                
                
            else {
            
                PreparedStatement ps =
                        cn.prepareStatement("UPDATE alumnos SET nombre='"+txtnombre.getText()+"',"
                                + "apellido='"+txtapellido.getText()+"',"
                                        + "grado='"+cmb_grado.getSelectedItem().toString()+
                                                    "',telefono= '"+txttelefono.getText()+"',"
                                                            + "id_curso_asignado='"+cmb_materia.getSelectedItem().toString()+"'"
                                                                    + " WHERE id_alumno='"+txtid_alumnos.getText()+"'");
                
                
                int respuesta = ps.executeUpdate();
                
                if(respuesta>0) {
                    
                    JOptionPane.showMessageDialog(null, "Datos del alumno modoficados");
                    limpiar();
                    mostrartabla("");
                
                }else {
                
                    JOptionPane.showMessageDialog(null, "No ha seleccionado fila");
                    
                }
                
                
            }
            
            
        } catch (SQLException e) {
            
                System.err.println(e);
                
                JOptionPane.showMessageDialog(null, "Error al actualizar alumno... contacte al administrador");
            
        }
        
        
        
        
        
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        
        Principal principal = new Principal();
        principal.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnvolverActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        
        mostrartabla(txtbuscar.getText());
        for(int i=0; i <= tabla_registro_alumnos.getRowCount(); i++){
                        
                        
                        txtcantidad.setText(" "+i);
     
                    }
        
        
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        
        char c = evt.getKeyChar();
        
        if((c< 'a' || c > 'z') && (c < 'A' ) | c> 'Z' && c!= KeyEvent.VK_SPACE) evt.consume();
 
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
        
        char c = evt.getKeyChar();
        
        if((c< 'a' || c > 'z') && (c < 'A' ) | c> 'Z' && c!= KeyEvent.VK_SPACE) evt.consume();
 
    
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        
        char c = evt.getKeyChar();
        
        if(c < '0' || c > '9' ) evt.consume();
        
    }//GEN-LAST:event_txttelefonoKeyTyped

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
            java.util.logging.Logger.getLogger(Registrar_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar_alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cmb_grado;
    private javax.swing.JComboBox<String> cmb_materia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popborrar;
    private javax.swing.JMenuItem popeliminar;
    private javax.swing.JTable tabla_registro_alumnos;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtid_alumnos;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
    
    Conectar con = new Conectar();
    Connection cn = con.conexion();


}
