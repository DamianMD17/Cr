/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mantenimiento;

import Clases.Estudiante;
import Clases.Matriculado;
import java.util.ArrayList;

/**
 *
 * @author damia
 */
public class MantenimientoMatriculados {
    private ArrayList<Matriculado> listaMatricula;

    public MantenimientoMatriculados() {
        listaMatricula = new ArrayList<Matriculado>();
    }
    
     public ArrayList<Matriculado> getstudentList() {
        return listaMatricula;
    }
     public void estudiantePorDefecto(){
        Matriculado student = new Matriculado("123456789","Juan Perez","informatica");
        
        listaMatricula.add(student);
        
    }
      public void crearEstudiante(String id, String nombre,String carrera){
       Matriculado matricula = new Matriculado(id,nombre,carrera);
        
        listaMatricula.add(matricula);
        
    }
}
