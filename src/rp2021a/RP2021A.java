/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import data.LeerDatos;
import data.Patron;
import java.util.ArrayList;

/**
 *
 * @author working
 */
public class RP2021A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Patron a = new Patron("","", new double[]{5.006,3.418,1.464,0.244});
        Patron b = new Patron("","", new double[]{1.2,0.8,5.1,1.1});
               
        System.out.println(a.calcularDistancia(b));
        // TODO: TOKENIZADOR PARA PODER SEPARAR POR COMAS Y GENERAR UN COLECCION DE PATRONES
        
    }
    
}
