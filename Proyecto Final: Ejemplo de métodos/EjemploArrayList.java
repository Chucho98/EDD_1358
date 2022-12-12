package ejemplos;

import java.util.ArrayList;

/**
 *
 * @author Alejandro Torres
 */
public class EjemploArrayList { //Uso de los principales métodos de ArrayList
    public static void main(String[] args) {
        ArrayList Test= new ArrayList(); //Creación del arreglo
        //Método add: Agrega un elemento al final de la lista
        Test.add(1);
        Test.add(10);
        Test.add(100);
        Test.add(1000);
        Test.add(20);
        //Método get: Devuelve el elemento en el índice indicado
        System.out.println(Test.get(0));
        System.out.println(Test.get(2));
        System.out.println(Test.get(4));
        //Método remove: Borra un elemento devla lista recorriendo
        //los elementos de lugar.
        Test.remove(2);
        System.out.println(Test.get(2));
        //Método size: Devuelve el número de elementos.
        System.out.println(Test.size());
        //Método clear: Borra todos los elementos de la lista.
        Test.clear();
        System.out.println(Test.size()
        );
    }
}
