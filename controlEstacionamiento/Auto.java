package controlEstacionamiento;

public class Auto extends Vehiculo implements Comparable {

    private String marca;
    private String color;

    public Auto(String marca, String placa, String color, Persona propietario) {
        super(placa, propietario);
        this.marca = marca;
        this.color = color;
    }

    public Auto(String placa, Persona propietario) {
        super(placa, propietario);
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
