 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mantenimiento;

import Clases.Curso;
import java.util.ArrayList;
import Clases.Estudiante;

/**
 *
 * @author andre
 */
public class MantenimientoCursos {
    
     private ArrayList<Curso> CursosList;
     
     public MantenimientoCursos() {
        CursosList = new ArrayList<Curso>();
    }
     
         public ArrayList<Curso> getCursosList() {
        return CursosList;
    }
         
     public void defaultStudent(){
        Curso Cr = new Curso("Fl300","Informatica","04");
        
        CursosList.add(Cr);
        
    }
     
      public void createStudent(String codigo, String nombreCurso,String creditos){
        Curso student = new Curso(codigo,nombreCurso,creditos);
        
        CursosList.add(student);
        
    }
     
}
