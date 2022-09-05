package arregloadt;

import java.util.ArrayList;

public class ArregloADT<T> {
   
    int longitud;
    ArrayList<T> datos;
    
    public ArregloADT(int tam){
        this.longitud = tam;
        datos = new ArrayList(this.longitud);
        for(int i=0; i<this.longitud; i++){
            this.datos.add(null);
        }
    }
    private boolean comprobacion(int indice) {
        return indice >= 0 && indice < this.longitud;
    }
    
    public T getElemento(int indice){
        if(comprobacion(indice)){
            return this.datos.get(indice);
        }else{
            System.out.println("Fuera del rango");
        }
        return null;
    }
    public void setElemento(int indice, T dato){
        if (comprobacion(indice)) {
            this.datos.set(indice, dato);
        } else {
            System.out.println("Fuera del rango");
        }
    }
    public int getLongitud(){
        return this.longitud;
    }
    public void limpiar(T dato){
        for (int i = 0; i < this.longitud; i++) {
            datos.set(i, dato);
        }
    }
    @Override
    public String toString(){
        String estado = "------------- "+this.longitud+" -------------\n";
        for (T dato : datos) {
            if(dato != null){
                estado += dato.toString()+"\n";
            }else{
                estado += "No hay dato guardado aun"+"\n";
            }
        }
        return estado;
    }
}
