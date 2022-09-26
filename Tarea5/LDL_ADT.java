package ldl_adt;

public class LDL_ADT<T> {
    
    NodoDoble<T> Head;

    public LDL_ADT() {
        this.Head = null;
    }

    public boolean estaVacia() {
        return this.Head == null;
    }
    
    public void getTamanio() {
        NodoDoble nodo_actual = this.Head;
        int Contador = 0;
        while (nodo_actual != null) {
            Contador ++;
            nodo_actual = nodo_actual.getSiguiente();
        }
        System.out.println("La Lista tiene: " +Contador+ " elementos");
    }

    public void agregarAlFinal(T valor) {
        NodoDoble<T> Nuevo = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.Head = Nuevo;
        } else {
            NodoDoble<T> Aux = this.Head;
            while (Aux.getSiguiente() != null) {
                Aux = Aux.getSiguiente();
                Nuevo.setAnterior(Aux);
            }
            Aux.setSiguiente(Nuevo);
            Aux = null;
            Nuevo = null;
        }
    }

    public void agregarAlInicio(T valor) {
        NodoDoble<T> Aux = new NodoDoble(valor);
        if (this.estaVacia()) {
            this.Head = Aux;
        } else {
            Aux.setSiguiente(Head);
            Head = Aux;
        }
    }

    public void agregarDespuesDe(int posición, T valor) {
        NodoDoble Aux = new NodoDoble(valor);
        NodoDoble Tem = this.Head;
        for (int contador = 1; contador <= posición - 1; contador++) {
            Tem = Tem.getSiguiente();
        }
        Aux.setSiguiente(Tem.getSiguiente());
        Tem.setSiguiente(Aux);
        Tem.setAnterior(Tem.getAnterior());
    }

    public void eliminar(int posición) {
        NodoDoble Aux = Head;
        if (this.estaVacia()) {
            System.out.println("Lista vacia, llénala primero alcornoque");
        } else {
            if (posición > Head.toString().length()) {
                System.out.println("La posición introducida no existe en esta lista, alcornoque");
            } else {
                for (int contador = 1; contador < posición - 1; contador++) {
                    Aux = Aux.getSiguiente();
                }
            }
        }

        Aux.setSiguiente(Aux.getSiguiente().getSiguiente());
        Aux.setAnterior(Aux.getAnterior());
    }

    public void eliminarElPrimero() {
        NodoDoble Aux = Head;
        if (this.estaVacia()) {
            Head = Aux;
        } else {
            Head = Aux.getSiguiente();
        }
    }

    public void eliminarElFinal() {
        NodoDoble Aux = Head;
        if (this.estaVacia()) {
            Head = Aux;
        } else {
            while (Aux.getSiguiente() != null) {
                Aux = Aux.getSiguiente();
            }
            Aux = null;
        }
    }

    public void buscarValor(T valor) {
        NodoDoble Aux = Head;
        int posición = 1;
        if (this.estaVacia()) {
            System.out.println("No hay valor");
        } else {
            while (Aux.getDato() != valor) {
                Aux = Aux.getSiguiente();
                posición++;
            }
        }
        System.out.println("El valor esta en la posición: " +posición);
    }

    public void actualizarValor(T valor, T actualizado) {
        NodoDoble Aux = Head;
        while (Aux.getDato() != valor) {
            Aux = Aux.getSiguiente();
        }
        Aux.setDato(actualizado);
    }

    public void transversal() {
        NodoDoble nodo_actual = this.Head;
        while (nodo_actual != null) {
            System.out.print(nodo_actual);
            nodo_actual = nodo_actual.getSiguiente();
        }
        System.out.println("");
    }
}

