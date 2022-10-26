/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.copiadelejemplo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author crist
 */

public class InterfazDeUsuario {
    Scanner scan; 
    ArrayList<Integer> colores; 
    //HashMap <Integer, String> colores; 
    
    public InterfazDeUsuario(){
      scan = new Scanner(System.in); 
      //colores = new HashMap(0); 
      colores = new ArrayList(); 
       // contador = 0;
    }
    
//public HashMap iniciar(ArrayList<Square> t, int contador){ 
    public ArrayList iniciar(ArrayList<Square> t, int contador){ 
    int miniContador =0; 
    int x=0; 
    int y=0;
   for(int i=contador ; i<contador+6; i++){
   //while(y<=50){
        System.out.println("Ingresa color el tablero 1");
        String c = scan.nextLine();
        
        t.get(89-(miniContador + contador)).changeColor(c);
        if (null== c)x=6; 
        else
        switch (c) {
            case "RO":
                x=1;
                break;
            case "AZ":
                x=2;
                break;
            case "VE":
                x=3;
                break;
            case "AM":
                x=4;              
                break;
            case "CA":
                x=5;
                break;
            case "NE":
                x=6;
                break;
            default:
                x=6;
                break;
        }
       
       // System.out.println(colores.size());
         //   System.out.println(x);
        //colores.put(x,c); 
        colores.add(x);
       // y ++; 
                //if (colores.size()>5)
              //      y= 51; 
        miniContador = miniContador + 15; 
    }
    //contador = contador + 6; 
    return colores; 
}

}
