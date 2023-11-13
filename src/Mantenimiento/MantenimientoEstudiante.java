
package Mantenimiento;

import Clases.Estudiante;
import java.util.ArrayList;

public class MantenimientoEstudiante {
    
     private ArrayList<Estudiante> studentList;

    public MantenimientoEstudiante() {
        studentList = new ArrayList<Estudiante>();
    }
    
     public ArrayList<Estudiante> getstudentList() {
        return studentList;
    }
     
      public void defaultStudent(){
        Estudiante student = new Estudiante("123456789","Juan Perez","informatica");
        
        studentList.add(student);
        
    }
      public void createStudent(String id, String nombre,String carrera){
        Estudiante student = new Estudiante(id,nombre,carrera);
        
        studentList.add(student);
        
    }

    
}
