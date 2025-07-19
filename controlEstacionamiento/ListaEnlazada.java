package controlEstacionamiento;

public class ListaEnlazada {

    // Nodo interno
    private class Nodo {

        Vehiculo dato;
        Nodo siguiente;

        Nodo(Vehiculo dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;

    public ListaEnlazada() {
        cabeza = null;
        cola = null;
    }

    private Nodo cola;

    // Agregar al final
    public void agregar(Vehiculo dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }
    }

    // Eliminar el primer nodo con un valor dado
    public boolean eliminar(Vehiculo dato) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(dato)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) {
            return false;
        }

        actual.siguiente = actual.siguiente.siguiente;
        return true;
    }

    // Mostrar elementos
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    //para que se muestre en la interfaz
    public String obtenerElementos() {
        //se usa un Strinbuilder
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        //se recorre la lista
        while (actual != null) {
            //se agrega al StringBuilder
            sb.append(actual.dato.mostrarDatos()).append("\n");
            actual = actual.siguiente;
        }
        //retorna el Stringbuilder
        return sb.toString();
    }

    // Método para buscar un vehículo por placa
    public Vehiculo buscarPorPlaca(String placa) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.getPlaca().equalsIgnoreCase(placa)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }
}
