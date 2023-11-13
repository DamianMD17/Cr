/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Clases.Curso;
import Mantenimiento.MantenimientoCursos;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import Clases.Estudiante;
import Mantenimiento.MantenimientoEstudiante;

/**
 *
 * @author andre
 */
public class Cursos extends javax.swing.JFrame {

 
    
  private DefaultTableModel tableModel;
    private static final String ARCHIVO_Cursos= "Cursos.txt";
    public Cursos() {
         
        initComponents();
        MantenimientoCursos mante = new MantenimientoCursos();
        mante.defaultStudent();
        ArrayList<Curso> listaEst = mante.getCursosList();
        
        tableModel = new DefaultTableModel();
        
        
         tableModel.addColumn("Codigo");
         tableModel.addColumn("Nombre Curso");
         tableModel.addColumn("Creditos");
         
         cargarArchivo(ARCHIVO_Cursos);
         
         for (Curso listaCursos : listaEst) {
            tableModel.addRow(new Object[]{
               listaCursos.getCodigo(),
                listaCursos.getNombre(),
                listaCursos.getCreditos()});
        }
         
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tabla.getSelectedRow();
                    if (selectedRow >= 0) {
                        Vector rowData = (Vector) tableModel.getDataVector().elementAt(selectedRow);
                        txtCodigo.setText((String) rowData.get(0));
                        txtNombreC.setText((String) rowData.get(1));
                       txtCreditos.setText((String) rowData.get(2));

                    }
                }
            }
        });
        
         tabla.setModel(tableModel);
    }
    
    
     private void cargarArchivo(String file) {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] dato = line.split(","); 
            if (dato.length == 3) {
              tableModel.addRow(new Object[]{dato[0], dato[1], dato[2]});
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
     
     
  private void guardarTxt() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_Cursos, true))) {
       
        String codigo = txtCodigo.getText();
        String nombrecurso = txtNombreC.getText();
        String creditos = txtCreditos.getText();

        if (!codigo.isEmpty() && !nombrecurso.isEmpty() && !creditos.isEmpty()) {
            
            String linea =(codigo + "," + nombrecurso + "," + creditos);
            bw.write(linea);
            bw.newLine();
            JOptionPane.showMessageDialog(this, "Curso Agregado con exito");
            
        }
          
        
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
  
  
 public void addRow() {
        String codigo = txtCodigo.getText();
        String nombreC = txtNombreC.getText();
        String credito = txtCreditos.getText();
       

        //Validar campos se encuentren llenos
        if (codigo.isEmpty() || nombreC.isEmpty() || credito.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos");
        }

        Curso student = new Curso(codigo, nombreC, credito);
        MantenimientoCursos man = new MantenimientoCursos();
        man.createStudent(codigo, nombreC, credito);

        // Crear las filas
        tableModel.addRow(new Object[]{
            student.getCodigo(),
            student.getNombre(),
            student.getCreditos()});

        //Limpiar txt
        txtCodigo.setText("");
        txtNombreC.setText("");
        txtCreditos.setText("");
      
        //Asignar modelo a la tabla que creamos en el FRM
        tabla.setModel(tableModel);

    }
 
 
 
 private static void eliminarLinea(String cedulaAEliminar) {
       ArrayList<String> lineas = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_Cursos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando la coma como delimitador
                String[] partes = linea.split(",");

                // Verificar si la línea contiene la cédula que se desea eliminar
                if (partes.length > 0 && partes[0].equals(cedulaAEliminar)) {
                    // Si contiene la cédula, no agregar la línea a la lista
                    continue;
                }

                // Agregar la línea a la lista
                lineas.add(linea);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_Cursos))) {
            // Escribir todas las líneas en el archivo original
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }

           JOptionPane.showMessageDialog(null, "Curso eliminado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        rr = new javax.swing.JLabel();
        ee = new javax.swing.JLabel();
        ww = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombreC = new javax.swing.JTextField();
        txtCreditos = new javax.swing.JTextField();
        bntAgregar = new javax.swing.JButton();
        bntEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 390, 110));

        rr.setText("Codigo del Curso");
        jPanel1.add(rr, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 20));

        ee.setText("Nombre del Curso");
        jPanel1.add(ee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, -1));

        ww.setText("Creditos");
        jPanel1.add(ww, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 120, -1));
        jPanel1.add(txtNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 120, -1));

        txtCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCreditosActionPerformed(evt);
            }
        });
        jPanel1.add(txtCreditos, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 120, -1));

        bntAgregar.setText("Agregar");
        bntAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(bntAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        bntEliminar.setText("Eliminar");
        bntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(bntEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, -1, -1));

        jButton1.setText("Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCreditosActionPerformed
      
    }//GEN-LAST:event_txtCreditosActionPerformed

    private void bntAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAgregarActionPerformed
       guardarTxt();   
        addRow();
    }//GEN-LAST:event_bntAgregarActionPerformed

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
       String eliminar = txtCodigo.getText();
            eliminarLinea(eliminar);
            int fila =tabla.getSelectedRow();
       
            if (fila>=0) {
            tableModel.removeRow(fila);
        }else{
               JOptionPane.showMessageDialog(null, "Seleccionar Fila"); 
            }
    }//GEN-LAST:event_bntEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Menu men = new Menu();
       men.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAgregar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JLabel ee;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rr;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCreditos;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JLabel ww;
    // End of variables declaration//GEN-END:variables
}
