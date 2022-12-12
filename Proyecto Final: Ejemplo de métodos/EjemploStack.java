package ejemplos;

/**
 *
 * @author Alejandro Torres
 */
public class EjemploStack {
    public static void main(String[] args) {
       //Constructor
       Pila_ADT Test = new Pila_ADT();
       //Método push: agrega un elemento al tope de la pila.
       Test.push(2);
       Test.push(4);
       Test.push(6);
       Test.push(8);
       Test.push(10);
       //Método peek: Regresa el elemento del tope.
       System.out.println(Test.peek());
       //Método length: Regresa el número de elementos.
       System.out.println(Test.getLongitud());
       //Método pop: Regresa el elemento del tope y lo saca.
       System.out.println(Test.pop());
       System.out.println(Test.getLongitud());
       System.out.println(Test.peek());
    }
}
