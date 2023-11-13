package Clases;

public class Estudiante {

    private String Id;
    private String Nombre;
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String Id, String Nombre, String carrera) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.carrera = carrera;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
}
