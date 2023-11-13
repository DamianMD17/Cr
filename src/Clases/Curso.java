
package Clases;


public class Curso {
    private String codigo;
    private String nombreCurso;
    private String creditos;

    public Curso() {
    }

    public Curso(String codigo, String nombreCurso, String creditos) {
        this.codigo = codigo;
        this.nombreCurso = nombreCurso;
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombreCurso;
    }

    public void setNombre(String nombre) {
        this.nombreCurso = nombre;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }
    
    
    
    
    
}
