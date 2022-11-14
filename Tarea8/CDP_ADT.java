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
       CDP_ADT Test = new CDP_ADT(6);
       Test.enqueue(4, "Maestre");
       System.out.println(Test.toString());
       Test.enqueue(2, "Niños");
       System.out.println(Test.toString());
       Test.enqueue(4, "Mecanico");
       System.out.println(Test.toString());
       Test.enqueue(3, "Hombres");
       System.out.println(Test.toString());
       Test.enqueue(4, "Vigia");
       System.out.println(Test.toString());
       Test.enqueue(5, "Capitan");
       System.out.println(Test.toString());
       Test.enqueue(4, "Timonel");
       System.out.println(Test.toString());
       Test.enqueue(3, "Mujeres");
       System.out.println(Test.toString());
       Test.enqueue(2, "3ra Edad");
       System.out.println(Test.toString());
       Test.enqueue(1, "Niñas");
       System.out.println(Test.toString());
    }
    
}
