/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import data.Patron;

/**
 *
 * @author working
 */
class PatronRepresentativo extends Patron{
    
      /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }
    private int contador;
    
    public PatronRepresentativo(Patron a,String nombre){
        super(a.getVectorC(),nombre);
        
        this.contador=0;
        acumular(a);
      
      
    }
   
    public PatronRepresentativo(Patron a){
        super(a.getVector()C.length);
        super.set(a.getClase());
        this.contador=0;
        acumular(a);
      
      
    }

    public  void acumular(Patron a) {
       for (int x=0;x<a.getVector().length;x++){
            super.getVector()[x]+=a.getVector()[x];
        }
       this.contador++;
    }
    
    public void actualizar(){
        for (int x=0;x<super.getVector().length;x++){
            super.getVector()[x]/=this.getContador();
        }
        this.contador = 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String aux = "";
        for(int x=0; x<getVector().length;x++)
            aux+="["+getVector()[x]+"]";
        
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void contar(){
        this.contador++;
    }
    
}
