/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
GUIDO PADILLA 19200
 */
package hoja10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class Controlador {
    private grafo grafito;
    private ArrayList<String> lineas;
    private HashMap<String,Integer> nodos;
    private HashMap<Integer,String> nodosReves;
    public Controlador(){
        lineas = new ArrayList<String>();
        nodos = new HashMap<String,Integer>();
        nodosReves = new HashMap<Integer,String>();
    }
    
    public void iniciar(){
        String[] lista;
        int cont = 0;
        for (String linea : lineas) {
            lista = linea.split(" ");
            if(nodos.get(lista[0]) == null){
                cont++;
                nodos.put(lista[0], cont);
                nodosReves.put(cont, lista[0]);
            }
            if(nodos.get(lista[1]) == null){
                cont++;
                nodos.put(lista[1], cont);
                nodosReves.put(cont, lista[1]);
            }
        }
        grafito = new grafo(nodos, nodosReves, cont);
        for (String linea : lineas){
            lista = linea.split(" ");
            grafito.setMatriz(nodos.get(lista[0])-1, nodos.get(lista[1])-1, Integer.valueOf(lista[2]));
        }
        grafito.Floyd();
    }
    
    public String imprimirCalculos(){
        return "Matriz con calculos de floyd:" + "\n" + grafito.impresionFloyd();
    }
    
    public String imprimirMatriz(){
        return "Matriz original:" + "\n" +grafito.impresionAdj();
    }
    
    public String imprimirInfo(String fila, String columna){
        return grafito.ruta(nodos.get(fila)-1, nodos.get(columna)-1);
    }
    
    public String imprimirCentro(){
        return grafito.centro();
    }
    
    public void modificarRuta(String fila, String columna, int n){
        grafito.setMatriz(nodos.get(fila)-1, nodos.get(columna)-1, n);
        grafito.setCaminos(nodos.get(fila)-1, nodos.get(columna)-1);
    }
    
    public void Interrupcion(String fila, String columna){
        grafito.setInterrupcion(nodos.get(fila)-1, nodos.get(columna)-1);
    }
    
    public void ReCalcular(){
        grafito.Floyd();
    }
    
    
    public void importText() {
        File inputStream = null;
        try {
            inputStream = new File(System.getProperty("user.dir")+"\\src\\guategrafo.txt");
            Scanner myReader = new Scanner(inputStream);
            while (myReader.hasNextLine()) {
              lineas.add(myReader.nextLine());
            }
            /*everything = myReader.nextLine();*/
            myReader.close();
        } catch (FileNotFoundException ex) {

        }
    }
}
