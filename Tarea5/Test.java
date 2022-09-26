package ldl_adt;

public class Test {

    public static void main(String[] args) {
        LDL_ADT Cabeza = new LDL_ADT();
        Cabeza.agregarAlFinal(2);
        Cabeza.agregarAlFinal(4);
        Cabeza.agregarAlFinal(6);
        Cabeza.agregarAlFinal(8);
        Cabeza.agregarAlFinal(10);
        Cabeza.agregarAlInicio(15);
        Cabeza.transversal();
        Cabeza.actualizarValor(2, 12);
        Cabeza.actualizarValor(15, 30);
        Cabeza.transversal();
        Cabeza.eliminarElPrimero();
        Cabeza.transversal();
        Cabeza.eliminar(2);
        Cabeza.transversal();
        Cabeza.agregarDespuesDe(1, 14);
        Cabeza.agregarDespuesDe(3, 28);
        Cabeza.transversal();
        Cabeza.agregarAlFinal(16);
        Cabeza.agregarAlInicio(18);
        Cabeza.transversal();
        Cabeza.buscarValor(14);
        Cabeza.getTamanio();
        
    }

}


