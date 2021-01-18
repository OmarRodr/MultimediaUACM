/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexion.UConnection;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Omar
 */
public class AuxBotones extends javax.swing.JFrame {
   private Border b;
   private byte[] longitudBytess; 
   FileInputStream fis;
   int longitudBytes;
   private byte[] archivoaudioby;
   private InputStream archivoaudioin;
   JTextField txtId;
   JTextField txtNombre;
   JTextField txtArtista;
   JTextField txtGenero;
   JTextField txtEstreno;
   JTextField txtExistencia;
   JTextField txtDuracion;
   JLabel jlbImg;
   JTextField txtAudio;
   AuxiliarVistas auxVista; 

    public AuxBotones(JTextField txtId, JTextField txtNombre, JTextField txtArtista, JTextField txtGenero, JTextField txtEstreno, JTextField txtExistencia, JTextField txtDuracion, JLabel jlbImg, JTextField txtAudio) {
        this.txtId = txtId;
        this.txtNombre = txtNombre;
        this.txtArtista = txtArtista;
        this.txtGenero = txtGenero;
        this.txtEstreno = txtEstreno;
        this.txtExistencia = txtExistencia;
        this.txtDuracion = txtDuracion;
        this.jlbImg = jlbImg;
        this.txtAudio = txtAudio;
        auxVista= new AuxiliarVistas( txtId, txtNombre, txtArtista, txtGenero, txtEstreno, txtExistencia, txtDuracion);
    }
   

    public AuxBotones(JTextField txtId, JTextField txtNombre, JTextField txtArtista, JTextField txtGenero, JTextField txtEstreno, JTextField txtExistencia, JTextField txtDuracion, JLabel jlbImg) {
        this.txtId = txtId;
        this.txtNombre = txtNombre;
        this.txtArtista = txtArtista;
        this.txtGenero = txtGenero;
        this.txtEstreno = txtEstreno;
        this.txtExistencia = txtExistencia;
        this.txtDuracion = txtDuracion;
        this.jlbImg = jlbImg;
        auxVista= new AuxiliarVistas( txtId, txtNombre, txtArtista, txtGenero, txtEstreno, txtExistencia, txtDuracion);
    }
    
    public final void btnGuardarC(String tabla, String cad1, String cad2, String cad3,
            String cad4, String cad5, String cad6, String cad7, String cad8, String cad9){
    if (auxVista.validarFormulario()) {
      try {
        PreparedStatement ps = null;
        Connection con = UConnection.getConnection();
        String sql = "INSERT INTO "+tabla+" ("+cad1+", "+cad2+", "+cad3+", "+cad4+", "+cad5+","
                + " "+cad6+", "+cad7+", "+cad8+","+cad9+") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(txtId.getText()));
        ps.setString(2, txtNombre.getText());
        ps.setString(3, txtArtista.getText());
        ps.setString(4, txtGenero.getText());
        ps.setInt(5, Integer.parseInt(txtEstreno.getText()));
        ps.setInt(6, Integer.parseInt(txtExistencia.getText()));
        ps.setDouble(7, Double.parseDouble(txtDuracion.getText()));
        ps.setBinaryStream(8, fis, longitudBytes);
        ps.setBytes(9, longitudBytess);
           int rs = ps.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(Album.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Todos los datos son correctos y"
                + " han sido guardados correctamente");
        txtId.setText("");
        txtNombre.setText("");
        txtArtista.setText("");
        txtGenero.setText("");
        txtEstreno.setText("");
        txtExistencia.setText("");
        txtDuracion.setText("");
        txtAudio.setText("");
        }    
    }
    public final void btnGuardar(String tabla, String cad1, String cad2, String cad3,
            String cad4, String cad5, String cad6, String cad7, String cad8){
    if (auxVista.validarFormulario()) {
      try {
        PreparedStatement ps = null;
        Connection con = UConnection.getConnection();
        String sql = "INSERT INTO "+tabla+" ("+cad1+", "+cad2+", "+cad3+", "+cad4+", "+cad5+","
                + " "+cad6+", "+cad7+", "+cad8+") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(txtId.getText()));
        ps.setString(2, txtNombre.getText());
        ps.setString(3, txtArtista.getText());
        ps.setString(4, txtGenero.getText());
        ps.setInt(5, Integer.parseInt(txtEstreno.getText()));
        ps.setInt(6, Integer.parseInt(txtExistencia.getText()));
        ps.setDouble(7, Double.parseDouble(txtDuracion.getText()));
        ps.setBinaryStream(8, fis, longitudBytes);
           int rs = ps.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(Album.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Todos los datos son correctos y"
                + " han sido guardados correctamente");
        txtId.setText("");
        txtNombre.setText("");
        txtArtista.setText("");
        txtGenero.setText("");
        txtEstreno.setText("");
        txtExistencia.setText("");
        txtDuracion.setText("");
        }    
    }
    public final void btnGuardaActualizacionV_A(JTextField actualizar, String txtTabla,String cad1, String cad2, String cad3,
            String cad4, String cad5, String cad6, String cad7, String cad8){
         if (auxVista.validarFormulario()){
      try {
         Connection con = UConnection.getConnection();
         String sql = "UPDATE "+txtTabla+" SET "+cad1+"=?,"+cad2+"=?,"+cad3+"=?,"+cad4+"=?,"+cad5+"=?,"
                 + ""+cad6+"=?,"+cad7+"=?,"+cad8+"=? WHERE "+cad1+"=? ";
         PreparedStatement pstm = con.prepareStatement(sql);
         pstm.setInt(1, Integer.parseInt(txtId.getText()));
         pstm.setString(2, txtNombre.getText());
         pstm.setString(3, txtArtista.getText());
        // pstm.setString(4, txtProtagonista.getText());
         pstm.setString(4, txtGenero.getText());
         pstm.setInt(5, Integer.parseInt(txtEstreno.getText()));
         pstm.setInt(6, Integer.parseInt(txtExistencia.getText()));
         pstm.setDouble(7, Double.parseDouble(txtDuracion.getText()));
         pstm.setBinaryStream(8, fis, longitudBytes);
         pstm.setInt(9, Integer.parseInt(txtId.getText()));
         
         int rs = pstm.executeUpdate();  
        } catch (SQLException ex) {
              Logger.getLogger(Album.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null,"Todos los datos son correctos y han sido guardados correctamente");
            txtId.setText("");
            txtNombre.setText("");
            txtArtista.setText("");
            txtGenero.setText("");
            txtEstreno.setText("");
            txtExistencia.setText("");
            txtDuracion.setText("");
            actualizar.setText("");
            
           }   
    }
    public final void btnActualizaV_A(JTextField txtActualizar,String Tabla, String cad1, String cad2, String cad3,
            String cad4, String cad5, String cad6, String cad7, String cad8){
     try{
            PreparedStatement ps = null;
            ImageIcon foto;
            InputStream is;
            ResultSet rs = null;
            UConnection conn = new UConnection();
            Connection con = UConnection.getConnection();
            String sql = "SELECT   "+cad1+","+cad2+","+cad3+","+cad4+","+cad5+","+cad6+","+cad7+","+cad8+" FROM "+Tabla+" WHERE "+cad1+"=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtActualizar.getText()));
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()) {
            txtId.setText(rs.getString(1));
            txtNombre.setText(rs.getString(2));
            txtArtista.setText(rs.getString(3));
            //txtProtagonista.setText(rs.getString(4));
            txtGenero.setText(rs.getString(4));
            txtEstreno.setText(rs.getString(5));
            txtExistencia.setText(rs.getString(6));
            txtDuracion.setText(Double.toString(rs.getDouble(7)));
            is = rs.getBinaryStream(8);
            BufferedImage bi = ImageIO.read(is);
            foto = new ImageIcon(bi);
            Image img = foto.getImage();
            Image newImg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImg);
            jlbImg.setIcon(newIcon);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "exception"+ex);
        }   
        
    }
    public final void btnGuardarActualizacionC(JTextField txtActualizar,String tabla, String cad1, String cad2, String cad3,
            String cad4, String cad5, String cad6, String cad7, String cad8, String cad9){
        
                try{
            PreparedStatement ps = null;
            ImageIcon foto;
            InputStream is;
            ResultSet rs = null;
            UConnection conn = new UConnection();
            Connection con = UConnection.getConnection();
            String sql = "SELECT "+cad1+", "+cad2+", "+cad3+", "+cad4+", "+cad5+", "+cad6+", "+cad7+", "+cad8+", "+cad9+" FROM "+tabla+" WHERE "+cad1+"=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtActualizar.getText()));
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            while (rs.next()) {
            txtId.setText(rs.getString(1));
            txtNombre.setText(rs.getString(2));
            txtArtista.setText(rs.getString(3));
            //txtProtagonista.setText(rs.getString(4));
            txtGenero.setText(rs.getString(4));
            txtEstreno.setText(rs.getString(5));
            txtExistencia.setText(rs.getString(6));
            txtDuracion.setText(Double.toString(rs.getDouble(7)));
            is = rs.getBinaryStream(8);
            BufferedImage bi = ImageIO.read(is);
            foto = new ImageIcon(bi);
            Image img = foto.getImage();
            Image newImg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newImg);
            jlbImg.setIcon(newIcon);
            archivoaudioby = rs.getBytes(9);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, "exception"+ex);
        }   
    }
    public final void btnImagen(){
     jlbImg.setIcon(null);
    JFileChooser j = new JFileChooser();
    j.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int estado = j.showOpenDialog(null);
    if (estado == JFileChooser.APPROVE_OPTION){
      try {
         fis = new FileInputStream(j.getSelectedFile());
         this.longitudBytes = (int) j.getSelectedFile().length();
         try {
           Image icon = ImageIO.read(j.getSelectedFile()).getScaledInstance
                 (jlbImg.getWidth(), jlbImg.getHeight(), Image.SCALE_DEFAULT); 
           jlbImg.setIcon(new ImageIcon(icon));
           jlbImg.updateUI();
         } catch (IOException ex) {
          JOptionPane.showMessageDialog(rootPane, "imagen"+ex);
         } 
      } catch (FileNotFoundException ex) {
          ex.printStackTrace();
      }
      }    
    }
    
       public final void btnSelecAudio( ){
         JFileChooser j = new JFileChooser();
        j.setCurrentDirectory(new File("C:\\Users\\david\\Music\\Sonidos Animales"));
        FileNameExtensionFilter fil = new FileNameExtensionFilter("mp3, wav & flac", "mp3", "wav", "flac");
        j.setFileFilter(fil);
        int s = j.showOpenDialog(this);
        File rutaa;
        if (s == JFileChooser.APPROVE_OPTION) {
            String ruta = j.getSelectedFile().getAbsolutePath();
            String name = j.getSelectedFile().getName();
            txtAudio.setText(ruta);
            rutaa = new File(txtAudio.getText());
            
            try {
            byte[] audio = new byte[(int) rutaa.length()];
            InputStream input = new FileInputStream(rutaa);
            input.read(audio);
            longitudBytess = audio;
            //vo.setArchivoaudioby(audio);
        } catch (Exception ex) {
            longitudBytess = null;
            //vo.setArchivoaudioby(null);
        }
        }
    }
}
