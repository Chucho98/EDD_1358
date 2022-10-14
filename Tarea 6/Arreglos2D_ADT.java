package Laberinto;

public class Arreglos2D_ADT<T> {

    int Filas, Columnas;
    private final ArregloADT<ArregloADT> Fillas;
    ArregloADT<ArregloADT> Item;
    ArregloADT Collumnas;
    ArregloADT Item2;

    public Arreglos2D_ADT(int Fila, int Colu) { //Constructor
        this.Filas = Fila;
        this.Columnas = Colu;
        Fillas = new ArregloADT(Filas);
        for (int F = 0; F < Filas; F++) {
            Fillas.setElemento(F, new ArregloADT(Colu));
        }
    }

    public int get_Filas() {
        return Filas;
    }

    public int get_Columnas() {
        return Columnas;
    }

    public void set_Item(int IndFil, int IndCol, T Elemento) {
        Fillas.getElemento(IndFil).setElemento(IndCol, Elemento);
    }

    public T get_Item(int IndFil, int IndCol) { //Creo es acá el problema
        if (IndCol >= 0 && IndCol < Columnas) {
            if (IndFil >= 0 && IndFil < Filas) {
                return (T) Fillas.getElemento(IndFil).getElemento(IndCol);
            }
        }
        return null;
    }

    public void clear(T Elemento) {
        for (int Posi = 0; Posi < Fillas.getLongitud(); Posi++) {
            Item2.setElemento(Posi, Elemento);
            Fillas.setElemento(Posi, Item2);
        }
    }

    public String to_String() {
        String S = "";
        S += Fillas + "\n";
        return S;
    }
}