package Laberinto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Laberinto {
    

    public static void main(String[] args) throws FileNotFoundException {
        //Leerá el archivo con un arraylist.
        File Archivo = new File("C:/Users/Alejandro Torres/Escritorio/Nivel.csv");
        Laberinto Prueba = new Laberinto(Archivo);
        Tablero.llenarTablero(Prueba.TablaLaberinto, Prueba.OutterArray);
        Prueba.empezar(Prueba.OutterArray);
        System.out.println("Laberinto:");
        Tablero.imprimirTablero(Prueba.TablaLaberinto);
        while (Tablero.esSalida(Prueba.TablaLaberinto, Prueba.Solución)) {
            Prueba.aplicarReglas(Prueba.TablaLaberinto);
            Tablero.imprimirTablero(Prueba.TablaLaberinto);
        }
        System.out.println("Final:");
        Tablero.imprimirTablero(Prueba.TablaLaberinto);
        System.out.println("Pila de Solución:");
        Prueba.Solución.transversal();

    }

    ArrayList<ArrayList<String>> OutterArray = new ArrayList();
    String[] Lineas;
    String[] TamLis;
    Arreglos2D_ADT TablaLaberinto;
    Pila_ADT Solución = new Pila_ADT();

    public Laberinto(File Arch) {
        int fila;
        int colu;
        try {
            Path Ruta = Arch.toPath();
            BufferedReader Lector = Files.newBufferedReader(Ruta);
            String Leido;
            while ((Leido = Lector.readLine()) != null) {
                Lineas = Leido.split(",");
                ArrayList<String> InnerArray = new ArrayList();
                for (String datos : Lineas) {
                    InnerArray.add(datos);
                }
                OutterArray.add(InnerArray);
            }

            fila = Integer.parseInt(OutterArray.get(0).get(0).trim());
            colu = Integer.parseInt(OutterArray.get(1).get(0).trim());
            TablaLaberinto = new Arreglos2D_ADT(fila, colu);

        } catch (IOException ex) {
        }
    }

    public void empezar(ArrayList<ArrayList<String>> OutterArray) {
        for (int Fik = 0; Fik < Integer.parseInt(OutterArray.get(0).get(0)); Fik++) {
            for (int Cok = 0; Cok < Integer.parseInt(OutterArray.get(1).get(0)); Cok++) {
                if (OutterArray.get(Fik + 2).get(Cok).equals("E")) {
                    Solución.push(Fik + "," + Cok);
                }
            }
        }
    }

    public void aplicarReglas(Arreglos2D_ADT TablaLaberinto) {
        String[] dividido = Solución.peek().split(",");
        int x = Integer.parseInt(dividido[0]);
        int xAdicional = 0;
        int y = Integer.parseInt(dividido[1]);
        int yAdicional = 0;
        int IGNORAR = 0;
        
//Arriba
        if (IGNORAR != 1) {
            if (TablaLaberinto.get_Item(x - 1, y) != "|") {
                if (TablaLaberinto.get_Item(x - 1, y) != null) {
                    if (TablaLaberinto.get_Item(x - 1, y) != "*") {
                        if (TablaLaberinto.get_Item(x - 1, y) != "^" && TablaLaberinto.get_Item(x - 1, y) != "S" && TablaLaberinto.get_Item(x - 1, y) != "X") {
                            xAdicional = x - 1;
                            Solución.push(xAdicional + "," + y);
                            TablaLaberinto.set_Item(x, y, "*");
                            IGNORAR = 2;
                        } else {
                            if (TablaLaberinto.get_Item(x - 1, y) == "S") {
                                xAdicional = x - 1;
                                Solución.push(xAdicional + "," + y);
                                TablaLaberinto.set_Item(xAdicional, y, "S");
                                TablaLaberinto.set_Item(x, y, "*");
                                IGNORAR = 2;
                            }
                        }
                    }
                }
            }
        }
        //Izquierda
        if (TablaLaberinto.get_Item(x, y - 1) != "|") {
            if (TablaLaberinto.get_Item(x, y - 1) != null) {
                if (TablaLaberinto.get_Item(x, y - 1) != "*") {
                    if (TablaLaberinto.get_Item(x, y - 1) != "^" && TablaLaberinto.get_Item(x, y - 1) != "S" && TablaLaberinto.get_Item(x, y - 1) != "X") {
                        yAdicional = y - 1;
                        Solución.push(x + "," + yAdicional);
                        TablaLaberinto.set_Item(x, y, "*");
                        IGNORAR = 1;
                    } else {
                        if (TablaLaberinto.get_Item(x, y - 1) == "S") {
                            yAdicional = y - 1;
                            Solución.push(x + "," + yAdicional);
                            TablaLaberinto.set_Item(x, yAdicional, "S");
                            TablaLaberinto.set_Item(x, y, "*");
                            IGNORAR = 1;
                        }
                    }
                }
            }
        }
        //Derecha
        if (IGNORAR != 1 && IGNORAR != 2) {
            if (TablaLaberinto.get_Item(x, y + 1) != "|") {
                if (TablaLaberinto.get_Item(x, y + 1) != null) {
                    if (TablaLaberinto.get_Item(x, y + 1) != "*") {
                        if (TablaLaberinto.get_Item(x, y + 1) != "^" && TablaLaberinto.get_Item(x, y + 1) != "S" && TablaLaberinto.get_Item(x, y + 1) != "X") {
                            yAdicional = y + 1;
                            Solución.push(x + "," + yAdicional);
                            TablaLaberinto.set_Item(x, y, "*");
                            IGNORAR = 3;
                        } else {
                            if (TablaLaberinto.get_Item(x, y + 1) == "S") {
                                yAdicional = y + 1;
                                Solución.push(x + "," + yAdicional);
                                TablaLaberinto.set_Item(x, yAdicional, "S");
                                TablaLaberinto.set_Item(x, y, "*");
                                IGNORAR = 3;
                            }
                        }
                    }
                }
            }
        }
        //Abajo
        if (IGNORAR != 1 && IGNORAR != 2 && IGNORAR != 3) {
            if (TablaLaberinto.get_Item(x + 1, y) != "|") {
                if (TablaLaberinto.get_Item(x + 1, y) != null) {
                    if (TablaLaberinto.get_Item(x + 1, y) != "*") {
                        if (TablaLaberinto.get_Item(x + 1, y) != "^" && TablaLaberinto.get_Item(x + 1, y) != "S" && TablaLaberinto.get_Item(x + 1, y) != "X") {
                            xAdicional = x + 1;
                            Solución.push(xAdicional + "," + y);
                            TablaLaberinto.set_Item(x, y, "*");
                        } else {
                            if (TablaLaberinto.get_Item(x + 1, y) == "S") {
                                xAdicional = x + 1;
                                Solución.push(xAdicional + "," + y);
                                TablaLaberinto.set_Item(xAdicional, y, "S");
                                TablaLaberinto.set_Item(x, y, "*");
                            }
                        }
                    }
                }
            }
        }
        //Caminos sin salida
        /* Caso 1:
        ||||
        | *
        ||||
         */
        if (TablaLaberinto.get_Item(x + 1, y) == "|") { 
            if (TablaLaberinto.get_Item(x, y - 1) == "|") { 
                if (TablaLaberinto.get_Item(x - 1, y) == "|") { 
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 1.1:
                    |X|
                    | *
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                /* Caso 1.2:
                |||
                X *
                |||
                 */
            } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { 
                if (TablaLaberinto.get_Item(x - 1, y) == "|") { 
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                /* Caso 1.3:
                |||
                | *
                |X|
                 */
            } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { 
                if (TablaLaberinto.get_Item(x, y - 1) == "|") { 
                    if (TablaLaberinto.get_Item(x - 1, y) == "|") { 
                        if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                            TablaLaberinto.set_Item(x, y, "X");
                            Solución.pop();
                        }
                    } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { 
                        if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                            TablaLaberinto.set_Item(x, y, "X");
                            Solución.pop();
                        }
                    }
                    /* Caso 1.4:
                    |||
                    X *
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { 
                    if (TablaLaberinto.get_Item(x - 1, y) == "|") { 
                        if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                            TablaLaberinto.set_Item(x, y, "X");
                            Solución.pop();
                        }
                    /* Caso 1.5:
                    |X|
                    X *
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x - 1, y) == "X") {
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
                    /* Caso 1.6:
                    |X|
                    X *
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
        }

        /* Caso 2:
        |||
        | |
        |*|
         */
        if (TablaLaberinto.get_Item(x, y - 1) == "|") { 
            if (TablaLaberinto.get_Item(x - 1, y) == "|") { 
                if (TablaLaberinto.get_Item(x, y + 1) == "|") { 
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 2.1:
                    |X|
                    | |
                    |*|
                     */
                } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y + 1) == "|") { 
                        if (TablaLaberinto.get_Item(x + 1, y) == "*") { 
                            TablaLaberinto.set_Item(x, y, "X");
                            Solución.pop();
                        }
                    /* Caso 2.2
                    Encerrado de la forma:
                    |||
                    | X
                    |*|
                     */
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { 
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                    /* Caso 2.3:
                    |||
                    X |
                    |*|
                     */
                } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { 
                    if (TablaLaberinto.get_Item(x - 1, y) == "|") { 
                        if (TablaLaberinto.get_Item(x, y + 1) == "|") { 
                            if (TablaLaberinto.get_Item(x + 1, y) == "*") { 
                                TablaLaberinto.set_Item(x, y, "X");
                                Solución.pop();
                            }
                        } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { 
                            if (TablaLaberinto.get_Item(x + 1, y) == "*") { 
                                TablaLaberinto.set_Item(x, y, "X");
                                Solución.pop();
                            }
                        }
                        /* Caso 2.4:
                        |X|
                        X |
                        |*|
                         */
                    } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { 
                        if (TablaLaberinto.get_Item(x, y + 1) == "|") { 
                            if (TablaLaberinto.get_Item(x + 1, y) == "*") {
                                TablaLaberinto.set_Item(x, y, "X");
                                Solución.pop();
                            }
                    /* Caso 2.5:
                    |X|
                    | X
                    |*|
                     */
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { 
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }

                } else if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
                    /* Caso 2.6:
                    |X|
                    X X
                    |*|
                     */
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { 
                    if (TablaLaberinto.get_Item(x + 1, y) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
        }

        /* Caso 3:
        |||
        * |
        |||
         */
        if (TablaLaberinto.get_Item(x - 1, y) == "|") { 
            if (TablaLaberinto.get_Item(x, y + 1) == "|") { 
                if (TablaLaberinto.get_Item(x + 1, y) == "|") { 
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 3.1:
                    |||
                    * X
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { 
                    if (TablaLaberinto.get_Item(x + 1, y) == "|") { 
                        if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                            TablaLaberinto.set_Item(x, y, "X");
                            Solución.pop();
                        }
                    /* Caso 3.2:
                    |X|
                    * |
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x - 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y + 1) == "|") { 
                        if (TablaLaberinto.get_Item(x + 1, y) == "|") { 
                            if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                                TablaLaberinto.set_Item(x, y, "X");
                                Solución.pop();
                            }
                        } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { 
                            if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                                TablaLaberinto.set_Item(x, y, "X");
                                Solución.pop();
                            }
                        }
                    /* Caso 3.3:
                    |||
                    * |
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") {
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                    /* Caso 3.4:
                    |X|
                    * X
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { 
                    if (TablaLaberinto.get_Item(x + 1, y) == "|") { 
                        if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                            TablaLaberinto.set_Item(x, y, "X");
                            Solución.pop();
                        }
                    /* Caso 3.5:
                    |||
                    * X
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                } else if (TablaLaberinto.get_Item(x + 1, y) == "*") { 
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            } else if (TablaLaberinto.get_Item(x, y + 1) == "*") { 
                if (TablaLaberinto.get_Item(x + 1, y) == "|") { 
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 3.6:
                    |||
                    * X
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                } else if (TablaLaberinto.get_Item(x + 1, y) == "*") {
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
                    /* Caso 3.7:
                    |X|
                    * X
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y - 1) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
        }
        /* Caso 4:
        |*|
        | |
        |||
         */
        if (TablaLaberinto.get_Item(x, y + 1) == "|") { 
            if (TablaLaberinto.get_Item(x + 1, y) == "|") { 
                if (TablaLaberinto.get_Item(x, y - 1) == "|") {
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                    /* Caso 4.1:
                    |*|
                    | |
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y - 1) == "|") { 
                        if (TablaLaberinto.get_Item(x - 1, y) == "*") { 
                            TablaLaberinto.set_Item(x, y, "X");
                            Solución.pop();
                        }
                    /* Caso 4.2:
                    |*|
                    | X
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x, y + 1) == "X") { 
                    if (TablaLaberinto.get_Item(x + 1, y) == "|") { 
                        if (TablaLaberinto.get_Item(x, y - 1) == "|") { 
                            if (TablaLaberinto.get_Item(x - 1, y) == "*") { 
                                TablaLaberinto.set_Item(x, y, "X");
                                Solución.pop();
                            }
                        } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { 
                            if (TablaLaberinto.get_Item(x - 1, y) == "*") { 
                                TablaLaberinto.set_Item(x, y, "X");
                                Solución.pop();
                            }
                        }
                    /* Caso 4.3:
                    |*|
                    X |
                    |||
                     */
                } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { 
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
                    /* Caso 4.4:
                    |*|
                    | X
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x + 1, y) == "X") { 
                    if (TablaLaberinto.get_Item(x, y - 1) == "|") { 
                        if (TablaLaberinto.get_Item(x - 1, y) == "*") { 
                            TablaLaberinto.set_Item(x, y, "X");
                            Solución.pop();
                         }
                    /* Caso 4.5:
                    |*|
                    X |
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { 
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
                    /* Caso 4.6:
                    |*|
                    X X
                    |X|
                     */
                } else if (TablaLaberinto.get_Item(x, y - 1) == "X") { 
                    if (TablaLaberinto.get_Item(x - 1, y) == "*") { 
                        TablaLaberinto.set_Item(x, y, "X");
                        Solución.pop();
                    }
                }
            }
        }

    }
}
