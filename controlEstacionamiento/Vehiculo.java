package controlEstacionamiento;

public abstract class Vehiculo {
    private String marca;
    private String modelo;
    private Persona propietario;
    private String placa;
    private String color;
    
    public Vehiculo(String placa, Persona propietario){
        this.placa = placa;
        propietario = new Persona();
    }
    
    public Vehiculo(){
        
    }
    
    public String getPlaca(){
        return placa;
    }
    
    
    public abstract String mostrarDatos();
}
