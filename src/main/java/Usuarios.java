public class Usuarios {
    int id;
    String nombre;
    String appellidos;
    String email;

    public Usuarios(String nombre, String appellidos, String email) {
        setNombre(nombre);
        setAppellidos(appellidos);
        setEmail(email);
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

    public String getAppellidos() {
        return appellidos;
    }

    public void setAppellidos(String appellidos) {
        this.appellidos = appellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
