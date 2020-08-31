public class Estados {
    int id;
    String nombre;
    String descripcion;

    public Estados(String nombre, String descripcion) {
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public int getId() {
        return id;
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
