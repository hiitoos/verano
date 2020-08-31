import java.util.Date;

public class Tareas {
    int id;
    String titulo;
    String descripcion;
    boolean estado; //0 NO prestado - 1 Prestado
    String responsable;
    Date fechaCreacion;

    public Tareas(String titulo, String descripcion, boolean estado, String responsable, Date fechaCreacion) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        setEstado(estado);
        setResponsable(responsable);
        setFechaCreacion(fechaCreacion);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
