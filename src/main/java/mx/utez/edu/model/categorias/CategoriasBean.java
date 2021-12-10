package mx.utez.edu.model.categorias;

public class CategoriasBean {
    private String nombre;
    private String categorias;

    public CategoriasBean() {
    }

    public CategoriasBean(String nombre, String categorias) {
        this.nombre = nombre;
        this.categorias = categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategorias() {
        return categorias;
    }

    public void setCategorias(String categorias) {
        this.categorias = categorias;
    }


}
