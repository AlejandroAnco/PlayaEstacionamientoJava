package controlEstacionamiento;

public class Moto extends Vehiculo implements Comparable {
    
    private String marca;
    private String modelo;
    private Persona propietario;
    private String placa;
    private String color;
    
    public Moto(String placa, Persona propietario){
        super(placa,propietario);
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public Persona getPropietario(){
        return propietario;
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public String getColor(){
        return color;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public void setPropietario(Persona propietario){
        this.propietario = propietario;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
    }
    
    public void setColor(String color){
        this.color = color;
    }
    
    

    @Override
    public int compareTo(Object o) {
        if (o.equals(this)){
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String mostrarDatos() {
        return "Nombre de usuario: "+propietario.getNombre()+
                ", Placa: "+this.placa +
                ", Tipo de vehiculo: Auto";
    }
    
    
}
