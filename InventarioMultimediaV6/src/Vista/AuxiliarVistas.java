/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Conexion.UConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public AuxiliarVistas(JTextField txtId, JTextField txtNombre, JTextField txtArtista, JTextField txtGenero, JTextField txtEstreno, JTextField txtExistencia, JTextField txtDuracion) {
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
    public final boolean validarFormulario(){
    boolean valido = true;
    Container cp = getContentPane();
    Component[] componentes = cp.getComponents();
    for (Component componente : componentes) {
        if (componente.getName() != null && componente.getName().equals("obligatorio") &&  componente instanceof JTextField ) {
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
    public final void salirVista(){
      int v = JOptionPane.showConfirmDialog(this, "¿Estas seguro de salir de esta ventan?"
              + "\n " + "Si abandonas la ventana se perdera el proceso",
              "¡¡ADVERTENCIA!!", JOptionPane.YES_NO_OPTION);
        if (v == JOptionPane.YES_OPTION) {
            PrincipalAdmi inicio = new PrincipalAdmi();
            this.setVisible(false);
            inicio.setVisible(true);
        } else {
             JOptionPane.showMessageDialog(null, "Sigue con el registro."
                     + "", "¡¡CONTINUAR!!", JOptionPane.INFORMATION_MESSAGE);
          }
    }
}
