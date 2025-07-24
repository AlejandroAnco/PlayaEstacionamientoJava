package controlEstacionamiento;

import java.time.LocalDateTime;

public class Auto extends Vehiculo implements Comparable {

    private String marca;
    private String color;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    public Auto(String marca, String placa, String color, Persona propietario, String tipo, LocalDateTime fechaIngreso) {
        super(placa, propietario, tipo, fechaIngreso);
        this.marca = marca;
        this.color = color;
    }

    public Auto(String placa, Persona propietario, String tipo, LocalDateTime fechaIngreso) {
        super(placa, propietario, tipo, fechaIngreso);
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String mostrarDatos() {
        return "Nombre de usuario: " + super.getPropietario().getNombre()
                + ", Placa: " + super.getPlaca()
                + ", Fecha de ingreso: " + super.getFechaIngreso()
                + ", Tipo de vehiculo: Auto";
    }

    @Override
    public int compareTo(Object o) {
        if (o.equals(this)) {
            return 0;
        } else {
            return 1;
        }
    }

}
