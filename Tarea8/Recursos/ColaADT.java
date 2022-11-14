package cdp_adt.recursos;

public class ColaADT<T> {
    ListaSL_ADT cola;
    
    public ColaADT(){
        this.cola = new ListaSL_ADT();
    }
    
    public boolean estaVacia(){
        return this.cola.estaVacia();
    }
    
    public int length(){
        return this.cola.getTamanio();
    }
    
    public void enqueue(T valor){
        this.cola.agregarAlFinal(valor);
    }
    
    public T dequeue(){
        Object inicio = this.cola.regresarInicio();
        cola.eliminarElPrimero();
        return (T) inicio;
    }

    @Override
    public String toString() {
        return "ColaADT{" + "cola=" + cola + '}';
    }
    
    
    
    public static void main(String[] args) {
        ColaADT Test = new ColaADT();
        Test.enqueue("A");
        Test.enqueue("B");
        Test.enqueue("C");
        Test.enqueue("D");
        Test.enqueue("E");
        Test.enqueue("F");
        Test.enqueue(10 + "s");
        System.out.println(Test.length());
        System.out.println(Test.toString());
        System.out.println(Test.dequeue());
        System.out.println(Test.toString());
        System.out.println(Test.dequeue());
        System.out.println(Test.toString());
        System.out.println(Test.length());
    }
    
}
