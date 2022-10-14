package Laberinto;

public class Pila_ADT<T> {

    ListaSL_ADT pila;

    public Pila_ADT() {
        this.pila = new ListaSL_ADT();
    }

    public boolean estaVacia() {
        return this.pila.estaVacia();
    }

    public String pop() {
        String A = pila.regresarFinal().toString();
        this.pila.eliminarElFinal();
        return A;
    }

    public String peek() {
        String B = pila.regresarFinal().toString();
        return B;
    }

    public void push(T valor) {
        this.pila.agregarAlFinal(valor);
    }

    public void transversal() {
        this.pila.transversal();
    }
   
}