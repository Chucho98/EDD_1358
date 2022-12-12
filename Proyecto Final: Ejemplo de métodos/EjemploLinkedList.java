package ejemplos;
/**
 *
 * @author Alejandro Torres
 */
public class EjemploLinkedList {
    public static void main(String[] args) {
        //Contructor de la lista
        ListaSL_ADT Test = new ListaSL_ADT();
        //Método agregaAlInicio: agrega un elemento al inicio.
        Test.agregarAlInicio(10);
        Test.agregarAlInicio(20);
        Test.agregarAlInicio(30);
        Test.agregarAlInicio(40);
        //Método agregaAlFinal: agrega un elemento al final.
        Test.agregarAlInicio(50);
        Test.agregarAlInicio(60);
        Test.agregarAlInicio(70);
        Test.agregarAlInicio(80);
        //Método transversal: recorrido de todos los elementos.
        Test.transversal();
        //Método agregarDespuesDe: Agrega un elemento después de una posición. 
        Test.agregarDespuesDe(3, 100);
        //Método actualizarValor: Cambio el valor de un elemento.
        Test.actualizarValor(10, 9);
        Test.transversal();
        //Método getTamanio: Regresa el número de elementos.
        System.out.println(Test.getTamanio());
        //Método eliminar: Elimina el elemento en cierta posición.
        Test.eliminar(4);
        //Método eliminarElPrimero: Elimina el primer elemento.
        Test.eliminarElPrimero();
        //Método eliminarElFinal: Elimina el último elemento.
        Test.eliminarElFinal();
        Test.transversal();
    }
}
