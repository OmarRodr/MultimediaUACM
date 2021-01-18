/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexion.UConnection;
import static Vista.PrincipalAdmi.jlbIdUsuario;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Omar
 */
public class PrincipalUsuario extends javax.swing.JFrame {

    //int id;
    JTextField txtId;
    JTextField txtNombre = null;
    JTextField txtArtista= null;
    JLabel jlbImg1 = null;
    AuxiliarVistas auxVistas;
    public PrincipalUsuario() {
        initComponents();
        txtId = new JTextField();
        txtNombre = new JTextField();
        txtArtista = new JTextField();
        jlbImg1 = new JLabel();
        auxVistas = new AuxiliarVistas();
    }
    private boolean validarFormulario() {
       boolean valido = true;
       Container cp = getContentPane();
       Component[] componentes = cp.getComponents();
       for (Component componente : componentes) {
         if (componente.getName() != null && 
                 componente.getName().equals("obligatorio") &&
                 componente instanceof JTextField ) {
            JTextField campo = (JTextField) componente;
            if (Validador.campoVacio(campo.getText())) {
                valido = false;
                auxVistas.enviaMensaje("Campo Obligatorio", campo);
            } else {
                auxVistas.eliminaMensaje(campo);
              }
         }
       }
       if (!Validador.validaTexto(txtBuscar.getText())) {
         valido = false;
         auxVistas.enviaMensaje("El nombre puede contener"
                 + " caracteres alfanumericos", txtBuscar);
        } else {
            auxVistas.eliminaMensaje(txtId);
          }
    return valido;
    }
    public void asignaVentana(int id){
        try {
            PreparedStatement ps = null;
            ImageIcon foto;
            InputStream is;
            ResultSet rs = null;
            UConnection conn = new UConnection();
            Connection con = UConnection.getConnection();
            String sql = "SELECT idAlbum, nombreA,"
                    + " artistaA,imgAlbum FROM Album WHERE idAlbum=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()) {
                txtId.setText(rs.getString(1));
                txtNombre.setText(rs.getString(2));
                txtArtista.setText(rs.getString(3));
                is = rs.getBinaryStream(4);
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newImg = img.getScaledInstance(140,
                        170, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newImg);
                jlbImg1.setIcon(newIcon);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "exception" + ex);
        }
     }
     public void asignaVentanaB(String nombre, String tabla
             , String cad1, String cad2, String cad3, String cad4) {
         try {
            PreparedStatement ps = null;
            ImageIcon foto;
            InputStream is;
            ResultSet rs = null;
            UConnection conn = new UConnection();
            Connection con = UConnection.getConnection();
            String sql = "SELECT "+cad1+","
              + " "+cad2+", "+cad3+","+cad4+""
              + " FROM "+tabla+" WHERE "+cad2+"=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()) {
                txtId.setText(rs.getString(1));
                txtNombre.setText(rs.getString(2));
                txtArtista.setText(rs.getString(3));
                is = rs.getBinaryStream(4);
                BufferedImage bi = ImageIO.read(is);
                foto = new ImageIcon(bi);
                Image img = foto.getImage();
                Image newImg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newImg);
                jlbImg1.setIcon(newIcon);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "exception" + ex);
        } 
     }
    private void asignaImg(String cad1,
            String tabla, String cad3, int n, JButton b) {
    try {
            PreparedStatement ps = null;
            ImageIcon foto;
            InputStream is;
            ResultSet rs = null;
            UConnection conn = new UConnection();
            Connection con = UConnection.getConnection();
            String sql = "SELECT   "+cad1+" FROM"
                    + " "+tabla+"  WHERE "+cad3+"=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, n);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()) {
            is = rs.getBinaryStream(1);
            BufferedImage bi = ImageIO.read(is);
            foto = new ImageIcon(bi);
            Image img = foto.getImage();
            Image newImg = img.getScaledInstance(140,
                    170, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImg);
            b.setIcon(newIcon);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "exception" + ex);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cbxTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 255, 0));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Inicio");

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setText("Biemvenid@");

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setText("Usuario:");

        jlbUsuario.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlbUsuario.setText("editarlo");

        jlbIdUsuario.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jlbIdUsuario.setText("idtexto");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 0, 204));
        btnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jlbImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbxTipo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Album", "Cancion", "Video" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbUsuario)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jlbUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jlbIdUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jlbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Elige una opción: ");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBorder(null);

        jButton3.setBorder(null);

        jButton4.setBorder(null);

        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBorder(null);

        jButton7.setBorder(null);

        jButton8.setBorder(null);

        jButton9.setBorder(null);

        jButton10.setBorder(null);

        jButton11.setBorder(null);

        jButton12.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        asignaVentana(1);
        ListaDeCanciones ldc = new ListaDeCanciones();
        VistaInventario inv = new VistaInventario(); 
        ldc.jlbAutor.setText(txtNombre.getText());
        ldc.jlbArtista.setText(txtArtista.getText());
        ldc.id.setText(txtId.getText());
        ldc.jlbImg.setIcon(jlbImg1.getIcon());
        ldc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        asignaVentana(3);
        ListaDeCanciones ldc = new ListaDeCanciones();
        VistaInventario inv = new VistaInventario(); 
        ldc.jlbAutor.setText(txtNombre.getText());
        ldc.jlbArtista.setText(txtArtista.getText());
        ldc.id.setText(txtId.getText());
        ldc.jlbImg.setIcon(jlbImg1.getIcon());
        ldc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
    asignaImg("imgAlbum", "Album", "idAlbum", 1, jButton1);
    asignaImg("imgAlbum", "Album", "idAlbum", 2, jButton2);
    asignaImg("imgAlbum", "Album", "idAlbum", 3, jButton3);
    asignaImg("imgAlbum", "Album", "idAlbum", 4, jButton4);
    asignaImg("imgAlbum", "Album", "idAlbum", 5, jButton5);
    asignaImg("imgAlbum", "Album", "idAlbum", 6, jButton6);
    asignaImg("imgAlbum", "Album", "idAlbum", 7, jButton7);
    asignaImg("imgAlbum", "Album", "idAlbum", 8, jButton8);
    asignaImg("imgAlbum", "Album", "idAlbum", 12, jButton9);
    asignaImg("imgAlbum", "Album", "idAlbum", 10, jButton10);
    asignaImg("imgAlbum", "Album", "idAlbum", 11, jButton11);
    asignaImg("imgAlbum", "Album", "idAlbum", 9, jButton12);
    }//GEN-LAST:event_jPanel1MouseMoved

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    String c = (String) cbxTipo.getSelectedItem();
        if (validarFormulario()) {
            if (c == "Album"){
                asignaVentanaB(txtBuscar.getText(), "Album",
                        "idAlbum", "nombreA", "artistaA", "imgAlbum");
                ListaDeCanciones ldc = new ListaDeCanciones();
                VistaInventario inv = new VistaInventario(); 
                ldc.jlbAutor.setText(txtNombre.getText());
                ldc.jlbArtista.setText(txtArtista.getText());
                ldc.id.setText(txtId.getText());
                ldc.jlbImg.setIcon(jlbImg1.getIcon());
                ldc.setVisible(true);
                this.setVisible(false);
            }
            if (c == "Cancion"){
                asignaVentanaB(txtBuscar.getText(),
                        "Cancion", "idCancion", "nombreC",
                        "artistaC", "imgCancion");
                VistaCancion ldc = new VistaCancion();
                ldc.id.setText(txtId.getText());
                ldc.setVisible(true);
                this.setVisible(false);
            }
            if (c == "Video"){
               asignaVentanaB(txtBuscar.getText(), "Video",
                    "idVideo", "nombreV", "artistaV", "imgVideo");
                VistaVideo ldc = new VistaVideo();
                ldc.id.setText(txtId.getText());
                ldc.setVisible(true);
                this.setVisible(false);
                System.out.println(""+txtId.getText());
            }
            
            
            
            
            
            /*try {
              Connection con = UConnection.getConnection();
              String sql = "DELETE FROM "+c+" WHERE "+ auxVistas.seleccionaId(c) + " = "+Integer.parseInt(txtId.getText())+"";
              PreparedStatement pstm = con.prepareStatement(sql);
              int rs = pstm.executeUpdate();
            } catch (SQLException ex) {
                  Logger.getLogger(Album.class.getName()).log(Level.SEVERE, null, ex);
                }
            JOptionPane.showMessageDialog(null,"El multimedia ha sido eliminado");*/
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> cbxTipo;
    private final javax.swing.JButton jButton1 = new javax.swing.JButton();
    private final javax.swing.JButton jButton10 = new javax.swing.JButton();
    private final javax.swing.JButton jButton11 = new javax.swing.JButton();
    private final javax.swing.JButton jButton12 = new javax.swing.JButton();
    private final javax.swing.JButton jButton2 = new javax.swing.JButton();
    private final javax.swing.JButton jButton3 = new javax.swing.JButton();
    private final javax.swing.JButton jButton4 = new javax.swing.JButton();
    private final javax.swing.JButton jButton5 = new javax.swing.JButton();
    private final javax.swing.JButton jButton6 = new javax.swing.JButton();
    private final javax.swing.JButton jButton7 = new javax.swing.JButton();
    private final javax.swing.JButton jButton8 = new javax.swing.JButton();
    private final javax.swing.JButton jButton9 = new javax.swing.JButton();
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static final javax.swing.JLabel jlbIdUsuario = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbImg = new javax.swing.JLabel();
    public static final javax.swing.JLabel jlbUsuario = new javax.swing.JLabel();
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
