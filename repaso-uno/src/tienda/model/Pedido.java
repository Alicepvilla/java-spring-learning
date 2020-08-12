package tienda.model;

import java.time.LocalDateTime;

public class Pedido {
    private Long id;
    private LocalDateTime localDateTime;
    private String nombreCliente, direccionInicio, direccionFin, comuna;
    private int monto;
    private Trabajador trabajador;

    public Pedido() {
        this.localDateTime = LocalDateTime.now();
    }

    public Pedido(Long id, String nombreCliente, String direccionInicio, String direccionFin, String comuna, int monto, Trabajador trabajador) {
        this.id = id;
        this.localDateTime = LocalDateTime.now();
        this.nombreCliente = nombreCliente;
        this.direccionInicio = direccionInicio;
        this.direccionFin = direccionFin;
        this.comuna = comuna;
        this.monto = monto;
        this.trabajador = trabajador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionInicio() {
        return direccionInicio;
    }

    public void setDireccionInicio(String direccionInicio) {
        this.direccionInicio = direccionInicio;
    }

    public String getDireccionFin() {
        return direccionFin;
    }

    public void setDireccionFin(String direccionFin) {
        this.direccionFin = direccionFin;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", direccionInicio='" + direccionInicio + '\'' +
                ", direccionFin='" + direccionFin + '\'' +
                ", comuna='" + comuna + '\'' +
                ", monto=" + monto +
                ", trabajador=" + trabajador +
                '}';
    }
}
