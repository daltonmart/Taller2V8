
package logica;

import java.util.ArrayList;

public class Historia {
    private ArrayList<Campania> listaCampanias;
    

    public Historia(){
        listaCampanias=new ArrayList<>();
    }

    public Historia(ArrayList<Campania> listaCampanias) {
        this.listaCampanias = listaCampanias;
    }

    public ArrayList<Campania> getListaCampanias() {
        return listaCampanias;
    }

    public void setListaCampanias(ArrayList<Campania> listaCampanias) {
        this.listaCampanias = listaCampanias;
    }

    public int obtenerCantCampanias() {
        return listaCampanias.size();
    }

    
    public int obtenerCantidadMisionesDeCampania(int nroCampania){
        return listaCampanias.get(nroCampania).obtenerCantMisiones();
    }
    
    public void insertarCampania(Campania u){
        listaCampanias.add(u);
    }
    
    public void borrarCampania(Campania u){
        listaCampanias.remove(u);
    }
    
    public Campania obtenerCampania (int nroCampania){
        return listaCampanias.get(nroCampania);
    }
    
    public void generarCampanias (int cantCampanias){
        Campania c;
        for (int i=0; i<cantCampanias+1; i++){
           c= new Campania();
           this.insertarCampania(c);
        }
        
    }
    
    //Precondicion: generarCampanias
    public void insertarMisionACampania(int nroCampania, String pista, String historia, String comando){
        DataMision m=new DataMision(pista, historia, comando);
        Campania c= listaCampanias.get(nroCampania);
        c.insertarMision(m);
     
        
    }
    
    public String obtenerPistaDeCampania(int nroCampania, int progreso){
        return obtenerCampania(nroCampania).obtenerMision(progreso).getPista();
    }
    
    public String obtenerHistoriaDeCampania(int nroCampania, int progreso){
        return obtenerCampania(nroCampania).obtenerMision(progreso).getHistoria();
    }
    
    public String obtenerComandoDeCampania(int nroCampania, int progreso){
        Campania camp=obtenerCampania(nroCampania);
        return camp.obtenerMision(progreso).getComando();
    }

  
    
    @Override
    public String toString() {
        return "Historia{" + "listaCampanias=" + listaCampanias + '}';
    }
    
    
}
