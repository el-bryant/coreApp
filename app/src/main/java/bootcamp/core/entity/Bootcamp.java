package bootcamp.core.entity;

public class Bootcamp {
    private String id_bootcamp;
    private String nombre;
    private String descripcion;
    private String icono;
    private String imagen;
    private String id_categoria;

    public Bootcamp(String id_bootcamp, String nombre, String descripcion, String icono, String imagen, String id_categoria) {
        this.id_bootcamp = id_bootcamp;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.imagen = imagen;
        this.id_categoria = id_categoria;
    }

    public String getId_bootcamp() {
        return id_bootcamp;
    }

    public void setId_bootcamp(String id_bootcamp) {
        this.id_bootcamp = id_bootcamp;
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

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }
}
