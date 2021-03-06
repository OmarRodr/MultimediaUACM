/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexion.UConnection;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Omar
 */
public class ListaDeCanciones extends javax.swing.JFrame {

    /**
     * Creates new form ListaDeCanciones
     */
    FondoPanel fondo = new FondoPanel();
    JTextField id;
    int idAudio;
    private byte[] archivoaudioby;
    private InputStream archivoaudioin;
    public ListaDeCanciones() {
        initComponents();
        id = new JTextField ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel();
        jlbImg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jlbAutor = new javax.swing.JLabel();
        jlbArtista = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCanciones = new javax.swing.JTable();
        btnReproducir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 0, 0,80));

        jlbAutor.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jlbAutor.setText("jLabel1");

        jlbArtista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jlbArtista.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jlbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbArtista, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        tablaCanciones.setBackground(new java.awt.Color(255, 0, 0,80));
        tablaCanciones.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        tablaCanciones.setForeground(new java.awt.Color(255, 255, 255));
        tablaCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tablaCanciones.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tablaCancionesMouseMoved(evt);
            }
        });
        tablaCanciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCancionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCanciones);

        btnReproducir.setBackground(new java.awt.Color(0, 0, 204));
        btnReproducir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnReproducir.setForeground(new java.awt.Color(255, 255, 255));
        btnReproducir.setText("Reproducir");
        btnReproducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproducirActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 0, 255));
        btnSalir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReproducir))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbImg, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReproducir)
                    .addComponent(btnSalir)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReproducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproducirActionPerformed
        try {
            PreparedStatement ps = null;
            ImageIcon foto;
            InputStream is;
            ResultSet rs = null;
            UConnection conn = new UConnection();
            Connection con = UConnection.getConnection();
            String sql = "SELECT audCancion FROM Cancion WHERE idCancion=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idAudio);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()) {
            archivoaudioby = rs.getBytes(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
            FileOutputStream fileOuputStream = null;
    try {
        fileOuputStream = new FileOutputStream("cancion.mp3");
        fileOuputStream.write(archivoaudioby);
    } catch (Exception ex) {
                System.out.println(ex.getMessage());
    } finally {
        try {
              fileOuputStream.close();
              Desktop.getDesktop().open(new File("cancion.mp3"));
            } catch (IOException ex) {
                System.out.println("Error en la extraccion del audio..." + ex);
            }
        }

    }//GEN-LAST:event_btnReproducirActionPerformed

    private void tablaCancionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCancionesMouseClicked
    int column = tablaCanciones.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tablaCanciones.getRowHeight();

        if (row < tablaCanciones.getRowCount() &&
                row >= 0 && column < tablaCanciones.getColumnCount()
                && column >= 0) {
            idAudio = (int) tablaCanciones.getValueAt(row, 0);
        }
    }//GEN-LAST:event_tablaCancionesMouseClicked

    private void tablaCancionesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCancionesMouseMoved
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            tablaCanciones.setModel(modelo);
            UConnection conn = new UConnection();
            Connection con = UConnection.getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            String sql = "SELECT   idCancion, nombreC,"
                    + "duracionC FROM Cancion WHERE idAlbum =?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id.getText()));
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Duracion");
            while (rs.next()) {
                Object[] filas = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_tablaCancionesMouseMoved

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int v = JOptionPane.showConfirmDialog(this, "¿Estas seguro de salir de esta ventan?"
            + "\n " + "Si abandonas la ventana se perdera el proceso",
            "¡¡ADVERTENCIA!!", JOptionPane.YES_NO_OPTION);
        if (v == JOptionPane.YES_OPTION) {
            PrincipalUsuario ia = new PrincipalUsuario();
            ia.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Sigue con el registro."
                + "", "¡¡CONTINUAR!!", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(ListaDeCanciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDeCanciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDeCanciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDeCanciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDeCanciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReproducir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jlbArtista;
    public static javax.swing.JLabel jlbAutor;
    public static javax.swing.JLabel jlbImg;
    private javax.swing.JTable tablaCanciones;
    // End of variables declaration//GEN-END:variables

class FondoPanel extends JPanel
{
 private Image imagen;
 @Override
 public void paint(Graphics g){
  imagen = new ImageIcon(getClass().getResource(
          "/Imagenes/atardecer5.jpg")).getImage();
  g.drawImage(imagen, 0, 0, getWidth(), getHeight(),this);
  setOpaque(false);
  super.paint(g);
 }
}
}
