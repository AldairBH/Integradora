package mx.utez.edu.model.marcas;

public class MarcasBean {
    private String nombre;
    private String descripcion;

    public MarcasBean() {
    }

    public MarcasBean(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
