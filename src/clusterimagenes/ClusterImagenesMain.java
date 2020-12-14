/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clusterimagenes;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author working
 */
public class ClusterImagenesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClusterizacionImagenes aux = new ClusterizacionImagenes();
        aux.abrir();
        aux.clusterizar(80);
    }
       
    
    
}
