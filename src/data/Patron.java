/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author working
 */
public class Patron {
    
    private String clase;
    private String claseResultante;
    private double[] vectorC;

    public Patron(int n) {
        this.clase = "";
        this.claseResultante = "";
        this.vectorC = new double[n];
    }

    public Patron(String clase, String claseResultante, double[] vectorC) {
        this.clase = clase;
        this.claseResultante = claseResultante;
        this.vectorC = vectorC;
    }
    // distancia euclidiana
    public double calcularDistancia (Patron aux){
        double sumatoria = 0;
        // recorre el vector característico
        for (int x=0; x<aux.getVectorC().length;x++ ){
         sumatoria+= Math.pow(this.vectorC[x]-aux.getVectorC()[x], 2);
        }
        sumatoria = Math.sqrt(sumatoria);
        return sumatoria;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * @return the claseResultante
     */
    public String getClaseResultante() {
        return claseResultante;
    }

    /**
     * @param claseResultante the claseResultante to set
     */
    public void setClaseResultante(String claseResultante) {
        this.claseResultante = claseResultante;
    }

    /**
     * @return the vectorC
     */
    public double[] getVectorC() {
        return vectorC;
    }

    /**
     * @param vectorC the vectorC to set
     */
    public void setVectorC(double[] vectorC) {
        this.vectorC = vectorC;
    }
    
    
    
    
}
