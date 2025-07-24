package controlEstacionamiento;

import java.time.LocalDateTime;

public abstract class Vehiculo {

    private String marca;
    private String modelo;
    private Persona propietario;
    private String placa;
    private String color;
    String tipo;
    private LocalDateTime fechaIngreso;

    public Vehiculo(String placa, Persona propietario, String tipo, LocalDateTime fechaIngreso) {
        this.placa = placa;
        this.propietario = propietario;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
    }

    public Vehiculo() {

    }

    public String getPlaca() {
        return placa;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public abstract String getTipo();

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public abstract String mostrarDatos();
}
