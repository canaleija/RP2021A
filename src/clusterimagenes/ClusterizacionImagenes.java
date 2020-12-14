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
    
    public void clusterizar(int c){
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
        
        CMeansImagen clasificador = new CMeansImagen(instancias, c);
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
    
      public void clusterizar2(){
      
        ArrayList<PatronImagen> instancias = new ArrayList<>();
        /*
        34	56	254
123	2	56
23	77	101
6	6	6
17	11	255
245	222	234
111	101	100
4	3	1
4	78	99
112	255	255

        
        */
        
        instancias.add(new PatronImagen(0, 0, new double[]{34,56,254}));
        instancias.add(new PatronImagen(0, 1, new double[]{123,2,56}));
        instancias.add(new PatronImagen(0, 2, new double[]{23,77,101}));
        instancias.add(new PatronImagen(0, 3, new double[]{6,6,6}));
        instancias.add(new PatronImagen(0, 4, new double[]{17,11,255}));
        instancias.add(new PatronImagen(0, 5, new double[]{245,222,234}));
        instancias.add(new PatronImagen(0, 6, new double[]{111,101,100}));
        instancias.add(new PatronImagen(0, 7, new double[]{4,3,1}));
        instancias.add(new PatronImagen(0, 8, new double[]{4,78,99}));
        instancias.add(new PatronImagen(0, 9, new double[]{112,255,255}));
        
        CMeansImagen clasificador = new CMeansImagen(instancias, 2);
        clasificador.clasifica();
        ArrayList<PatronImagen> resutlado = clasificador.getInstancias();
        
//        // recorrer la imagen 
//        BufferedImage nuevo = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_INT_RGB);
//        
//        for(PatronImagen p: resutlado){
//            int x = p.getX();
//            int y = p.getY();
//            nuevo.setRGB(x, y,Integer.parseInt(p.getClase()));
//        }
//        
//        Image imagencluster = AbrirImagen.toImage(nuevo);
//       
//         JframeImagen frame = new JframeImagen(imagencluster);
        
    }
    
}
