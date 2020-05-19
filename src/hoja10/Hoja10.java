/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
GUIDO PADILLA 19200
 */
package hoja10;

import java.util.Scanner;

/**
 *
 * @author sebas
 */
public class Hoja10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controlador op = new Controlador();
        Scanner scanner = new Scanner(System.in);
        op.importText();
        String fila = "", columna = "";
        int valor = 0;
        op.iniciar();
        String opcion = "";
        while(!opcion.equals("7")){
            System.out.print("Ingrese una opcion\n1. Mostrar ruta entre 2 ciudades y su peso(distancia)\n2. Mostrar centro\n3. Realizar una interrupcion entre ciudades\n4. Realizar modificacion de distancia de camino\n5. Mostrar matriz de adyacencia\n6. Mostrar matriz con calculos de floyd\n7. Salir\n");
            opcion = scanner.nextLine();
            if(opcion.equals("1")){
                System.out.print("Ingrese ciudad de inicio: ");
                fila = scanner.nextLine();
                System.out.print("Ingrese ciudad de destino: ");
                columna = scanner.nextLine();
                System.out.println(op.imprimirInfo(fila, columna));
            }
            if(opcion.equals("2")){
                System.out.println(op.imprimirCentro());
            }
            if(opcion.equals("3")){
                System.out.print("Ingrese ciudad de inicio: ");
                fila = scanner.nextLine();
                System.out.print("Ingrese ciudad de destino: ");
                columna = scanner.nextLine();
                op.Interrupcion(fila, columna);
                op.ReCalcular();
            }
            if(opcion.equals("4")){
                System.out.print("Ingrese ciudad de inicio: ");
                fila = scanner.nextLine();
                System.out.print("Ingrese ciudad de destino: ");
                columna = scanner.nextLine();
                System.out.print("Ingrese distancia entre ciudades: ");
                valor = scanner.nextInt();
                op.modificarRuta(fila, columna, valor);
                op.ReCalcular();
            }
            if(opcion.equals("5"))
                System.out.println(op.imprimirMatriz());
            if(opcion.equals("6"))
                System.out.println(op.imprimirCalculos());
        }
    }
    
}
