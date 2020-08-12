package tienda.model.util;

public abstract class Persona {
    private Long id;
    private String nombre, run, telefono;

    public Persona() {
    }

    public Persona(Long id, String nombre, String run, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.run = run;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", run='" + run + '\'' +
                ", telefono='" + telefono;
    }
}
