package cdp_adt;

import cdp_adt.recursos.ArregloADT;
import cdp_adt.recursos.ColaADT;

public class CDP_ADT<T> {
    
    ArregloADT<ColaADT> ColaP;
    int Prioridad;
    
    public CDP_ADT(int niveles){
        ColaP = new ArregloADT(niveles);
        this.Prioridad = niveles;
        for (int i = 0; i < niveles; i++) {
            ColaP.setElemento(i, new ColaADT());
        }
    }
    
    public boolean estaVacia(){
        int Aux = 0;
        for (int i = 0; i < Prioridad -1; i++) {
            if (ColaP.getElemento(i).estaVacia()){
                Aux++;
            }
        }return Aux ==0;
    }
    
    public int length(){
        int Cuenta = 0;
        ColaADT Aux;
        for (int i = 0; i < Prioridad-1; i++) {
            Aux = ColaP.getElemento(i);
            Cuenta += Aux.length();
        }return Cuenta;
    }
    
    public void enqueue(int P, T valor){
        if (P >=0 && P < Prioridad){
            ColaP.getElemento(P).enqueue(valor);
        }else if (P>Prioridad){
            ColaP.getElemento(Prioridad-1).enqueue(valor);
        }
    }
    
    public void dequeue(){
        for (int i = 0; i < Prioridad; i++) {
            if(!ColaP.getElemento(i).estaVacia()){
                ColaP.getElemento(i).dequeue();
            }
        }
    }

    @Override
    public String toString() {
        return "CDP_ADT{" + "ColaP=" + ColaP + '}';
    }
    
    
    public static void main(String[] args) {
       CDP_ADT Test = new CDP_ADT(7);
       Test.enqueue(0, "A");
       Test.enqueue(1, "B");
       Test.enqueue(2, "C");
       Test.enqueue(3, "D");
       Test.enqueue(4, "E");
       Test.enqueue(5, "F");
       Test.enqueue(6, "G");
       Test.enqueue(4, "H");
       Test.enqueue(2, "I");
       Test.enqueue(5, "J");
       Test.enqueue(0, "K");
        System.out.println(Test.toString());
    }
    
}
