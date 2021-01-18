/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexion.UConnection;
import static Vista.InicioAdmi.txtContrasena;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Omar
 */
public class AuxiliarVistas extends javax.swing.JFrame{
   private Border b;
   JTextField txtId;
   JTextField txtNombre;
   JTextField txtArtista;
   JTextField txtGenero;
   JTextField txtEstreno;
   JTextField txtExistencia;
   JTextField txtDuracion;
   JTextField txtContrasena;

    public AuxiliarVistas() {
    }
    public AuxiliarVistas(JTextField txtId, JTextField txtContrasena) {
        this.txtId = txtId;
        this.txtContrasena = txtContrasena;
    }
    public AuxiliarVistas(JTextField txtId, JTextField txtNombre,
            JTextField txtArtista, JTextField txtGenero, JTextField txtEstreno,
            JTextField txtExistencia, JTextField txtDuracion) {
        this.txtId = txtId;
        this.txtNombre = txtNombre;
        this.txtArtista = txtArtista;
        this.txtGenero = txtGenero;
        this.txtEstreno = txtEstreno;
        this.txtExistencia = txtExistencia;
        this.txtDuracion = txtDuracion;
    }
   public final void eliminaMensaje(JTextField t){
           t.setBorder(b);
           t.setToolTipText(null);
    }
    public final void enviaMensaje(String mensaje, JTextField t){
           t.setBorder(new LineBorder(Color.red));
           t.setToolTipText(mensaje);
    }
    public int existeRegistro(JTextField txtUsuario,
            JTextField txtContrasena, String cad1,
            String cad2, String cad3 ) {
    try {
           PreparedStatement ps = null;
           ResultSet rs = null;
           Connection con = UConnection.getConnection();
           String sql = "SELECT COUNT(*) FROM "+cad1+" WHERE"
                   + " "+cad2+"=? and "+cad3+"=?";
           ps = con.prepareStatement(sql);
           ps.setInt(1, Integer.parseInt(txtUsuario.getText()));
           ps.setString(2, txtContrasena.getText());
           rs = ps.executeQuery();
           if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
       } catch (SQLException e) {
            Logger.getLogger(InicioAdmi.class.getName()).log(
                    Level.SEVERE, null, e);
            return 1;
        } 
    }
    public int existeMultimedia(String tabla, String nombre, JTextField txtBuscar) {
    try {
           PreparedStatement ps = null;
           ResultSet rs = null;
           Connection con = UConnection.getConnection();
           String sql = "SELECT COUNT(*) FROM "+tabla+" WHERE"
                   + " "+nombre+"=?";
           ps = con.prepareStatement(sql);
           ps.setString(1, txtBuscar.getText());
           rs = ps.executeQuery();
           if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
       } catch (SQLException e) {
            Logger.getLogger(InicioAdmi.class.getName()).log(
                    Level.SEVERE, null, e);
            return 1;
        } 
    }
     public boolean verificaUsuario(String cad1, String cad2, String cad3) {
      if (existeRegistro(txtId, txtContrasena, cad1, cad2, cad3) == 0) {
        JOptionPane.showMessageDialog(null, "Tu clave o tu contraseña son invalidos,"
                + "\nintenta de nuevo y verifica que los dato esten escritos correctamente",
                "¡¡Advertencia!!", JOptionPane.INFORMATION_MESSAGE);
        txtId.setText("");
        txtContrasena.setText("");
        return false;
      } else {
          return true;
        }
    }
    public final boolean validarFormularioInicio() {
    boolean valido = true;
    Container cp = getContentPane();
    Component[] componentes = cp.getComponents();
    for (Component componente : componentes) {
        if (componente.getName() != null && componente.getName().equals(
                "obligatorio") &&  componente instanceof JTextField) {
            JTextField campo = (JTextField) componente;
            if (Validador.campoVacio(campo.getText())) {
                valido = false;
                enviaMensaje("Campo Obligatorio", campo);
            } else {
                eliminaMensaje(campo);
              }
        }
    }
    if (!Validador.validaEntero(txtId.getText())) {
       valido = false;
       enviaMensaje("El nombre de usuario"
               + " puede contener numeros enteros", txtId);
    } else {
          eliminaMensaje(txtId);
       }
    if (!Validador.validaContrasena(txtContrasena.getText())) {
       valido = false;
       enviaMensaje("La contraseña debe contener 10"
               + " caracteres estos pueden ser mayusculas,"
               + " minusculas y numeros", txtContrasena);
    } else {
        eliminaMensaje(txtContrasena);
      }
    return valido;
    }
    public final boolean validarFormulario(){
    boolean valido = true;
    Container cp = getContentPane();
    Component[] componentes = cp.getComponents();
    for (Component componente : componentes) {
        if (componente.getName() != null && componente.getName().equals(
                "obligatorio") &&  componente instanceof JTextField ) {
            JTextField campo = (JTextField) componente;
            if (Validador.campoVacio(campo.getText())) {
                valido = false;
                enviaMensaje("Campo Obligatorio", campo);
            } else {
                eliminaMensaje(campo);
            }
        }
    }
    if (!Validador.validaEntero(txtId.getText())) {
      valido = false;
      txtId.setText("");
      enviaMensaje("El id solo debe de contener caracteres numericos", txtId);
    } else {
        eliminaMensaje(txtId);
      }
    if (!Validador.validaTexto(txtArtista.getText())) {
      valido = false;
      txtArtista.setText("");
      enviaMensaje("El nombre del artista o autor solo debe de contener"
              + " caracteres alfabeticos", txtArtista);
    } else {
        eliminaMensaje(txtArtista);
      }
    if (!Validador.validaTexto(txtNombre.getText())) {
       valido = false;
       txtNombre.setText("");
       enviaMensaje("El nombre del álbum o video solo debe de contener"
               + " caracteres alfabeticos ", txtNombre);
    } else {
        eliminaMensaje(txtNombre);
      }
    if (!Validador.validaTexto(txtGenero.getText())) {
       valido = false;
       txtGenero.setText("");
       enviaMensaje("El genero solo debe de contener"
               + " caracteres alfabeticos", txtGenero);
    } else {
        eliminaMensaje(txtGenero);
      }
    if (!Validador.validaEntero(txtEstreno.getText())) {
       valido = false;
       txtEstreno.setText("");
       enviaMensaje("El año de publicación solo debe de contener"
               + " caracteres numericos", txtEstreno);
    } else {
        eliminaMensaje(txtEstreno);
      }
    if (!Validador.validaEntero(txtExistencia.getText())) {
       valido = false;
       txtExistencia.setText("");
       enviaMensaje("Esta sección solo permite caracteres"
               + " numericos enteros", txtExistencia);
    } else {
        eliminaMensaje(txtExistencia);
      }
    if (!Validador.validaDuracion(txtDuracion.getText())) {
       valido = false;
       txtDuracion.setText("");
       enviaMensaje("El tiempo de duracion solo debe de contener"
               + " caracteres numericos seguidos de un punto y nuevamente"
               + " caracteres numericos", txtDuracion);
    } else {
        eliminaMensaje(txtDuracion);
      }
    return valido;
    }
     public String seleccionaId(String c) {
        if(c == "Cancion"){    
          return "idCanciones";
        }
        if(c == "Album"){
          return "idAlbum";
        }
        if(c == "Video"){
          return "idVideo";
        }
        return "0";
    }
}
