package arregloadt;

import java.util.ArrayList;

public class ArregloADT {
   
    private int longitud;
    ArrayList<Object> datos;
    
    public ArregloADT(int tam){
        this.longitud = tam;
        datos = new ArrayList();
        for(int i=0; i<tam; i++){
            datos.add(new Object());
        }
    }
    
    public Object getElemento(int indice){
        if(indice>=0 && indice<this.longitud){
            return datos.get(indice);
        }
        return null;
    }
    public Object setElemento(Object elemento, int indice){
        if(indice>=0 && indice<this.longitud){
            datos.set(indice, elemento);
        }
        return null;
    }
    public int getLongitud(){
        return datos.size();
    }
    public void limpiar(Object elemento){
        for (int i = 0; i < this.longitud; i++) {
            datos.set(i, elemento);
        }
    }
    @Override
    public String toString(){
        return datos.toString();
    }
}
