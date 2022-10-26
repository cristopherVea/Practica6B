/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.copiadelejemplo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class Juego {
   // ArrayList<Integer> combinacion; 
    Map<Integer, String > combinacion;
    ArrayList<Integer>combinacionEnArray; 
    public int resp;
    public final String msjTitulo = "MASTERMIND";
    public final String msjGanar = "Enhorabuena, ¡ GANASTE ! ";
    public String msjIntentos = "UPS!, HAS GASTADO LOS 15 INTENTOS";
    public String msjRepetir = "¿PROBAMOS DE NUEVO?";  
    public Juego(){ 
       // combinacion = new ArrayList(); 
        
    }
    
    public  void iniciar(){
       Tablero t = new Tablero();
       combinacion = new HashMap<Integer, String>(0); 
       combinacionEnArray = new ArrayList(); 
       generarCombinacion(); 
       guadarLaCombinacionEnArrayList();
        System.out.println(toString());
       //System.out.println(toString1());
      
       InterfazDeUsuario interfaz = new InterfazDeUsuario(); 
       int contador = 0; 
        
      for(int i = 0; i<15; i++){
    
         // HashMap<Integer,String> combinacionActual;
         ArrayList <Integer> combinacionActual;
          combinacionActual = new ArrayList(); 
          //contador = contador +1; 
        combinacionActual=interfaz.iniciar(t.getCuadros(),contador);
         //cambiarColoresdePines(combinacionActual, (HashMap<Integer, String>) combinacion,t.getCirculos(),contador);
        cambiarColoresdePines(combinacionActual, combinacionEnArray,t.getCirculos(),contador);
         if (comparar(combinacionActual, t.getCirculos() )){
        // if (comparar(interfaz.iniciar(t.getCuadros(),contador), t.getCirculos() )){
           // if (comparar(interfaz.iniciar(t.getCuadros(),contador))){ 
            System.out.println("HA GANADO EL JUEGO");
             resp =JOptionPane.showConfirmDialog(null, msjGanar, msjTitulo, JOptionPane.YES_NO_OPTION);
             break;
         } 
         contador = contador +1; 
      }
        
    }
    
    public boolean comparar(ArrayList<Integer> colores , ArrayList<Circle> c){
        boolean bandera = false; 
        int i=0; 
         //if ((combinacion.get(0)==colores.get(0))&&(combinacion.get(1)==colores.get(1))&&(combinacion.get(2)==colores.get(2))&&(combinacion.get(3)==colores.get(3))&&(combinacion.get(4)==colores.get(4))&&(combinacion.get(5)==colores.get(5))){
        bandera = combinacionEnArray.equals(colores);
       // c.get(1).changeColor("white"); 
        //colores.clear();
        colores.removeAll(colores); 
        /*for(Integer n: combinacion){
            if(n==colores.get(i)){
              c.get(i).changeColor("white");  
              
            }
            i++; 
            
        }*/
         //}
         return bandera;
    }
    
   // public void cambiarColoresdePines(HashMap<Integer,String> colores ,HashMap<Integer,String> combinacion ,ArrayList<Circle> c,int contador){
    public void cambiarColoresdePines(ArrayList<Integer> colores ,ArrayList<Integer>combinacion ,ArrayList<Circle> c,int contador){
        int miniContador =0; 
        for (int i = 0; i < 6; i++) {
            if(colores.get(i)==combinacion.get(i)){
                c.get(89-(miniContador + contador)).changeColor("white");
                miniContador = miniContador + 15;
            }
            
        }
    
    }
   /*    
    public boolean comparar1(ArrayList<Integer> colores,ArrayList<Circle> c ){
        boolean bandera = false; 
        int i = 0; 
       // for (String c : combinacion) {
        for (int j = 0; j < 6; j++) {
            //System.out.println(colores.get(i));
            int c1= combinacion.get(j);
            int c2 = colores.get(j);
            
            System.out.println(combinacion.get(j)+" "+colores.get(j));
            if(c1==c2) {i++;
            c.get(j).changeColor("white");} 
            
            if (i>=5) {
                bandera = true; 
            }
            //System.out.println("\n"+combinacion.get(j)+ "  "+colores.get(j));
            System.out.println("\n"+c1+ "  "+c2);
            colores.removeAll(colores);
        }
        return bandera;
    }

*/
    public HashMap generarCombinacion(){
        int x = 0;
        int y=0; 
        String color= "NE";
        //for (int i = 0; i < 6; i++) {
        while(y<=50){
           Random r = new Random();
            x = r.nextInt(6)+1; 
            
            if (x==1) {color= "RO"; }
            else
            if (x==2) {color= "AZ"; }
            else
            if (x==3) {color= "AM"; }
            else
            if (x==4) {color= "NE"; }
            else
            if (x==5) {color= "VE"; }
            else
            if (x==6) {color= "CA"; }
            else 
                color = "NE";
            combinacion.put(x,color); 
          // combinacion.add(x);
         // y= combinacion.size();
         y++;
         if (combinacion.size()>5)
                    y= 51;
         //   System.out.print(x+ " ,");
        }
        return (HashMap) combinacion ;
    }
    
    public void guadarLaCombinacionEnArrayList(){
        int x=0; 
        for (int i = 0; i < 6; i++) {
            if (null== combinacion.get(i))x=5; 
        else
        switch (combinacion.get(i)) {
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
            combinacionEnArray.add(x);
        }
    }

        public String toString1() {
        String lasCartas = ""; 
        
            for (int i = 0; i < 8; i++) {
           lasCartas =lasCartas+" "+ combinacion.get(i) + "\n"; 
            }
        return lasCartas;
}
    @Override
            public String toString() {
        String lasCartas = ""; 
        
        for (Integer carta: combinacionEnArray) {
           lasCartas = lasCartas + carta + "\n"; 
        }
        return lasCartas;
    }
    
}
   

