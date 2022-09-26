package ldl_adt;

public class NodoDoble<T> {
    

    private T dato;
    private NodoDoble<T> Siguiente;
    private NodoDoble<T> Anterior;

    public NodoDoble(T dato) { 
        this.dato = dato;
    }

    public NodoDoble(T dato, NodoDoble<T> Sig, NodoDoble<T> Ant) { 
        this.dato = dato;
        this.Siguiente = Sig;
        this.Anterior = Ant;
    }

    public NodoDoble<T> getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoDoble<T> Sig) {
        this.Siguiente = Sig;
    }
    
    public NodoDoble<T> getAnterior(){
        return Anterior;
    }
    
    public void setAnterior(NodoDoble<T> Ant){
        this.Anterior = Ant;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "|" + dato + "| <-> ";
    }

    public String mostrarTodo() {
        return "[Anterior= "+ this.getAnterior() + "] <-> [Dato= " + dato + "] <-> [Siguiente= " + this.getSiguiente() + "]";
    }
}
