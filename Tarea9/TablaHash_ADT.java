package tablahash_adt;

import Recursos.ArregloADT;
import java.util.ArrayList;
import java.util.Scanner;

public class TablaHash_ADT<K, T> {
    ArregloADT<ArrayList> Tabla;
    int tamaño;
    
    public TablaHash_ADT(int Tamaño){
       this.tamaño = Tamaño;
        if (tamaño < 7) {
            this.tamaño = 7;
            Tabla = new ArregloADT(tamaño);
        } else {           
            if ((tamaño % 2) == 0) { 
                this.tamaño = tamaño + 1;
                Tabla = new ArregloADT(tamaño);
            } else { 
                Tabla = new ArregloADT(tamaño);
            }

        }
        for (int F = 0; F < tamaño; F++) { 
            Tabla.setElemento(F, new ArrayList());
        }
    }
    
    public void agregar(int llave, T valor){
        int posicion = llave%tamaño;
        Tabla.getElemento(posicion).add(valor);
    }
    
    public T valorDe(int llave){
        int posicion = llave % tamaño;
        Object encontrar = null;
        
        if ( Tabla.getElemento(posicion).size()==1){
            return (T) Tabla.getElemento(posicion).get(0);
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.println("Hay mas de un objeto, ¿Cúal Buscas?");
            int N = sc.nextInt();
            for (int i = 0; i < Tabla.getElemento(posicion).size(); i++) {
                /*if (Tabla.getElemento(posicion).get(i).equals(N)){
                    encontrar = Tabla.getElemento(posicion).get(i);
                }*/
                encontrar = Tabla.getElemento(posicion).get(i).equals(N);
            }
        }return (T)encontrar;
    }
    
    public void eliminar(int llave){
        int posicion = llave%tamaño;
        
        if ( Tabla.getElemento(posicion).size()==1){
            Tabla.getElemento(posicion).clear();
        } else{
            Scanner sc = new Scanner(System.in);
            System.out.println("Hay mas de un objeto, ¿Cúal Buscas?");
            int N = sc.nextInt();
            for (int i = 0; i < Tabla.getElemento(posicion).size(); i++) {
                if (Tabla.getElemento(posicion).get(i).equals(N)){
                    Tabla.getElemento(posicion).remove(i);
                }
            }
        }
    }

    
    public static void main(String[] args) {
       TablaHash_ADT Test = new TablaHash_ADT(11);
       Test.agregar(100, 1);
       Test.agregar(101, 2);
       Test.agregar(102, 3);
       Test.agregar(103, 4);
       Test.agregar(104, 5);
       Test.agregar(105, 6);
       Test.agregar(106, 7);
       Test.agregar(107, 8);
       Test.agregar(108, 9);
       Test.agregar(109, 10);
       Test.agregar(110, 11);
       System.out.println(Test.valorDe(101));
       System.out.println(Test.valorDe(102));
       System.out.println(Test.valorDe(103));
       System.out.println(Test.valorDe(104));
       System.out.println(Test.valorDe(105));
       System.out.println(Test.valorDe(106));
       System.out.println(Test.valorDe(107));
       System.out.println(Test.valorDe(108));
       System.out.println(Test.valorDe(109));
       System.out.println(Test.valorDe(110));
       Test.eliminar(103);
       System.out.println(Test.valorDe(103));
       
    }
    
}
