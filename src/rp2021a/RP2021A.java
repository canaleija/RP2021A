/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import data.Patron;

/**
 *
 * @author working
 */
public class RP2021A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        /**distancias 
        (2.4,5.6,3)   (5,6,3) d1:
        (1,2) (6.7,7.8)  d2:
        **/
        Patron p1 = new Patron("", "", new double[]{1,2});
        Patron p2 = new Patron("", "", new double[]{6.7,7.8});
        System.out.println(p2.calcularDistancia(p1));
        // TODO: TOKENIZADOR PARA PODER SEPARAR POR COMAS Y GENERAR UN COLECCION DE PATRONES
        
    }
    
}
