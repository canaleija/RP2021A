/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clusterimagenes;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author working
 */
public class CMeansImagen {
    
    // conjunto de instancias
    private ArrayList<PatronImagen> instancias;
    // numero de clusters
    private int c;
    // centroidesIniciales 
    private ArrayList<PatronImagen[]> centroides;
    int[] contadores;  
    public CMeansImagen(ArrayList<PatronImagen> instancias, int c) {
        this.instancias = instancias;
        this.centroides = new ArrayList<>();
        this.c = c;
    }
    
    public void clasifica(){
     // generar mis centroidesIniciales iniciales aleatorios 
     Random ran = new Random();
     PatronImagen[] centroidesIniciales = new PatronImagen[c];
     for (int x=0; x < this.c;x++){
       int pos = ran.nextInt(this.getInstancias().size());
       centroidesIniciales[x] = new PatronImagen(0,0,this.getInstancias().get(pos).getVectorC().clone());
     }
     // agregamos a la coleccion de centroidesIniciales los centroidesIniciales iniciales
     this.getCentroides().add(centroidesIniciales);
     calcularClusters();
    }
    
    
    private void calcularClusters (){
    
     // etiquetar por primera ocasiÃ³n (clasificar por primera ocasiÃ³n)
     etiquetar(this.centroides.get(0));
     // generar un proceso iterativo 
     // que modifique o ajuste los centroidesIniciales
     int contador = 0;
     
     do {
        // recalcular centroidesIniciales
        // necesitamos donde acumular 
        PatronImagen[] centroidesNuevos = new PatronImagen[c];
        contadores = new int[c];
        inicializarNuevosCentroides(centroidesNuevos);
        // acumulamos(recorrer todas las instancias) 
        for (PatronImagen instancia: this.getInstancias()){
            String nombreCluster = instancia.getClase();
            forCentroides: for (int x=0; x < centroidesNuevos.length;x++){
             if (centroidesNuevos[x].getClase().equals(nombreCluster)){
               centroidesNuevos[x].setVectorC(sumaVectores(centroidesNuevos[x].getVectorC(),instancia.getVectorC()));
               contadores[x]++;
               break forCentroides;
             }
            }
        }
        // agregar los centroidesIniciales a la coleccion
        this.getCentroides().add(centroidesNuevos);
        // dividimos 
        dividirUltimosCentroides(contadores);
        // actualizar el nomnre de la clase en base al color       
        // re etiquetar 
       etiquetar(this.getCentroides().get(this.getCentroides().size()-1));
       System.out.println(contador++);
      
     }while (!verificaCentroides()&&contador<500);
        
    
    }
    
    private void etiquetar (PatronImagen[] centroides){
    // recorrer las instancias y etiquetar 
    // cada una de ellas en base a distancias
    for (PatronImagen patron: this.getInstancias()){
       double menor = AbrirImagen.calcularDistEucli(patron,centroides[0]);
       patron.setClase(centroides[0].getClase());
       for (int x=1; x < this.c; x++){
       // calculamos distancias
       double dist = AbrirImagen.calcularDistEucli(patron,centroides[x]);
       if (dist< menor){
       menor = dist;
       patron.setClase(centroides[x].getClase());
       }
       }
      
    }
  
    }

    private boolean verificaCentroides() {
        // verificar si los centroidesIniciales nuevos
        // son iguales a los anteriores
       int numCentroides = this.getCentroides().size();
       PatronImagen[] ultimo = this.getCentroides().get(numCentroides-1);
       PatronImagen[] penultimo = this.getCentroides().get(numCentroides-2);
       for (int x=0; x < ultimo.length;x++){
           if (!ultimo[x].equals(penultimo[x]))
               return false;
       }
       System.out.println("Convergen los centroides!");
       return true;
    }

    
    private void inicializarNuevosCentroides(PatronImagen[] centroidesNuevos) {
      // recorro el arreglo 
      for (int x=0; x < centroidesNuevos.length;x++){
        centroidesNuevos[x] = new PatronImagen(0,0,new double[this.getInstancias().get(0).getVectorC().length]);
      }
    }

    private double[] sumaVectores(double[] vector, double[] vector0) {
       double aux[] = new double[vector.length];
       for (int x=0; x < aux.length;x++)
           aux[x] = vector[x]+vector0[x];
       
       return aux;
    }

    private void dividirUltimosCentroides(int[] contadores) {
        PatronImagen[] aux = this.getCentroides().get(this.getCentroides().size()-1);
        
        for (int x=0; x < aux.length;x++){
         double[] vector = aux[x].getVectorC();
          for (int y=0;y<vector.length;y++){
           vector[y]/=contadores[x];
          }
          
          aux[x].actualizarNombre();
        }
          
    }

    /**
     * @return the centroidesIniciales
     */
    public ArrayList<PatronImagen[]> getCentroides() {
        return centroides;
    }

    /**
     * @return the instancias
     */
    public ArrayList<PatronImagen> getInstancias() {
        return instancias;
    }
    
        
    
}
