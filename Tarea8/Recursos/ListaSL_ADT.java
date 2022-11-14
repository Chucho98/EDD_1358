package cdp_adt.recursos;

public class ListaSL_ADT<T> {

    Nodo<T> cabeza;
    int cuenta;

    public ListaSL_ADT() {
        this.cabeza = null;
    }

    public boolean estaVacia() {
        return this.cabeza == null;
    }
    
    public int getTamanio(){
       Nodo Aux = cabeza;
        if (this.estaVacia()) {
            return 0;
        } else {
            cuenta = 1;
            while (Aux.getSiguiente() != null) {
                Aux = Aux.getSiguiente();
                cuenta++;
            }
        }
        return this.cuenta; 
    }

    public Nodo regresarFinal() {
        if (this.estaVacia()) {
            return null;
        } else {
            Nodo Aux = cabeza;
            while (Aux.getSiguiente() != null) {
                Aux = Aux.getSiguiente();
            }
            return Aux;
        }
    }
    
    public Nodo regresarInicio(){
        if (this.estaVacia()){
            return null;
        }else {
            return cabeza;
        }
    }

    public void agregarAlFinal(T dato) {
        Nodo Aux = new Nodo(dato);
        if (this.estaVacia()) {
            this.cabeza = Aux;
        } else {
            Nodo Temp = cabeza;
            while (Temp.getSiguiente() != null) {
                Temp = Temp.getSiguiente();
            }
            Temp.setSiguiente(Aux);
        }
    }

    public void agregarAlInicio(T dato) {
        Nodo Aux = new Nodo(dato);
        if (this.estaVacia()) {
            this.cabeza = Aux;
        } else {
            Aux.setSiguiente(this.cabeza);
            this.cabeza = Aux;
        }
    }

    public void agregarDespuesDe(int posición, T dato) {
        Nodo Aux = new Nodo(dato);
        Nodo Tem = this.cabeza;
        for (int contador = 1; contador <= posición - 1; contador++) {
            Tem = Tem.getSiguiente();
        }
        Aux.setSiguiente(Tem.getSiguiente());
        Tem.setSiguiente(Aux);
    }

    public void eliminar(int posición) {
        Nodo Temp = this.cabeza;
        if (this.estaVacia()) {
            System.out.println("Lista vacia, llénala primero alcornoque");
        } else {
            if (posición > cabeza.toString().length()) {
                System.out.println("La posición introducida no existe en esta lista, alcornoque");
            } else {
                for (int contador = 1; contador < posición - 1; contador++) {
                    Temp = Temp.getSiguiente();
                }
            }
        }
        Temp.setSiguiente(Temp.getSiguiente().getSiguiente());
    }

    public void eliminarElPrimero() {
        Nodo Aux = cabeza;
        if (this.estaVacia()) {
            cabeza = Aux;
        } else {
            cabeza = Aux.getSiguiente();
        }
    }

    public void eliminarElFinal() {
        Nodo Aux = cabeza;
        if (this.estaVacia()) {
            cabeza = Aux;
        } else {
            while (Aux.getSiguiente().getSiguiente() != null) {
                Aux = Aux.getSiguiente();
            }
            Aux.setSiguiente(null);
        }
    }

    public int buscarValor(T dato) {
        Nodo Aux = cabeza;
        int Posición = 1;
        if (this.estaVacia()) {
            System.out.println("No hay valor, la cadena está vacía.");
        } else {
            while (Aux.getDato() != dato) {
                if (Aux.getDato() == null) {
                    System.out.println("No se encontró ese dato.");
                    return 0;
                } else {
                    Aux = Aux.getSiguiente();
                    Posición++;
                }
            }
        }
        return Posición;
    }

    public void actualizarValor(T dato, T actualizado) {
        Nodo Aux = cabeza;
        while (Aux.getSiguiente() != dato) {
            Aux = Aux.getSiguiente();
        }
        Aux.setDato(actualizado);
    }

    public void transversal() {
        Nodo nodo_actual = this.cabeza;
        while (nodo_actual != null) {
            System.out.print(nodo_actual);
            nodo_actual = nodo_actual.getSiguiente();
        }
        System.out.println("");
    }

    public String transversalAString() {
        Nodo nodo_actual = this.cabeza;
        String Mostrado = "";
        while (nodo_actual != null) {
            Mostrado += nodo_actual.toStringPila();
            nodo_actual = nodo_actual.getSiguiente();
        }
        return Mostrado;
    }

    @Override
    public String toString() {
        return this.transversalAString();
    }
}

