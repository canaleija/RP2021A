 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import data.Patron;
import interfaces.ClasificadorSupervisado;
import java.util.ArrayList;

/**
 *
 * @author working
 */
public class MinimaDistancia implements ClasificadorSupervisado{

    ArrayList<Patron> representativos;

    public MinimaDistancia() {
        this.representativos = new ArrayList<>();
    }
           
    @Override
    public void entranar(ArrayList<Patron> instancias) {
      // calcular los representativos
    }

    @Override
    public void clasificar(ArrayList<Patron> instancias) {
       // clasificar las instancias
    }
    
}
