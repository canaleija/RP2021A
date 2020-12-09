/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clusterimagenes;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author working
 */
public class ClusterizacionImagenes {
    
    private Image imagenOriginal;

    public ClusterizacionImagenes() {
        this.imagenOriginal = null;
    }
    
    
    public void abrir(){
        this.imagenOriginal = AbrirImagen.openImage();
        JframeImagen frame = new JframeImagen(imagenOriginal);
                
    }
    
    public void clusterizar(){
        // generar la coleccion de instancias obtenidas de los colores de la imagen 
        BufferedImage bi = AbrirImagen.toBufferedImage(this.imagenOriginal);
        ArrayList<PatronImagen> instancias = new ArrayList<>();
        // recorremos la imagen
        Color color;
        for(int x=0; x<bi.getWidth();x++){
            for(int y = 0 ; y<bi.getHeight();y++){
                int rgb = bi.getRGB(x, y);
                color = new Color(rgb);
                instancias.add(new PatronImagen(x, y, new double[]{color.getRed(),
                    color.getGreen(),
                    color.getBlue()}));
            }
        }
        
        CMeansImagen clasificador = new CMeansImagen(instancias, 10);
        clasificador.clasifica();
        ArrayList<PatronImagen> resutlado = clasificador.getInstancias();
        
        // recorrer la imagen 
        BufferedImage nuevo = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_INT_RGB);
        
        for(PatronImagen p: resutlado){
            int x = p.getX();
            int y = p.getY();
            nuevo.setRGB(x, y,Integer.parseInt(p.getClase()));
        }
        
        Image imagencluster = AbrirImagen.toImage(nuevo);
       
         JframeImagen frame = new JframeImagen(imagencluster);
        
    }
    
    
}
