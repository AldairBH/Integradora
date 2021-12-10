package mx.utez.edu.model.productos;

public class ProductosBean {
    private int codigo;
    private String nombre;
    private String categoria;
    private String marca;
    private int existencias;
    private int precio_unitario;
    private String descripcion;

    public ProductosBean() {
    }

    public ProductosBean(int codigo, String nombre, String categoria, String marca, int existencias, int precio_unitario, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.existencias = existencias;
        this.precio_unitario = precio_unitario;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(int precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
