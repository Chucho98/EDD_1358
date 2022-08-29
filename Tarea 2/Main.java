package arregloadt;

public class Main {
    public static void main(String[] args) {
        //Constructor
        ArregloADT lista = new ArregloADT(5);
        // Método getLongitud
        System.out.println("El tamaño del arreglo es de: "+ lista.getLongitud());
        // Método setElemento
        lista.setElemento("Hola", 0);
        // Método getElemento
        System.out.println("EL objeto guardado en el lugar 1 del arreglo es: "+ lista.getElemento(0));
        // Método toString
        System.out.println(lista.toString());
        // Método limpiar
        lista.limpiar(null);
        System.out.println(lista.getElemento(0));
        System.out.println(lista.getElemento(2));
        System.out.println(lista.getElemento(4));
        // Método toString
        // Método toString
        System.out.println(lista.toString());
    }
}
