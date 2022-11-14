package ColaADT;


public class Nodo<T> { 

    private T datos;
    private Nodo<T> Siguiente;

    //Constructores
    public Nodo() { 
    }

    public Nodo(T dato) { 
        this.datos = dato;
    }

    public Nodo(T dato, Nodo<T> Sig) { 
        this.datos = dato;
        this.Siguiente = Sig;
    }

//Métodos de acceso
    public Nodo<T> getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(Nodo<T> Sig) {
        this.Siguiente = Sig;
    }

    public T getDato() {
        return datos;
    }

    public void setDato(T dato) {
        this.datos = dato;
    }

    //Método toString()
    @Override
    public String toString() {
        return "|" + datos + "| -> ";
    }
    
    public String toStringPila(){
        return "[" + datos + "]>";
    }

    public String mostrarTodo() {
        return "[Dato= " + datos + "] -> [Siguiente= " + this.getSiguiente() + "]";
    }
}
