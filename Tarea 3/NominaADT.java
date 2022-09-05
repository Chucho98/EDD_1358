package Principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class NominaADT {
    
    public NominaADT(){
        String archivo = "junio.dat";
        String columna;
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            
            while((columna = br.readLine()) !=null){
                String[] valores = columna.split(",");
                System.out.println(columna);
               
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
