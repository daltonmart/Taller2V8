
package logica;

import javax.swing.JOptionPane;
import logica.TerminalLogica;
import logica.interfaces.ISistemaJuegoHistoria;
import static logica.ISistemaPrincipalImpl.historia;
import static logica.ISistemaPrincipalImpl.iJuego;
import static logica.ISistemaPrincipalImpl.iSesion;

public class ControladorJuegoHistoria implements ISistemaJuegoHistoria{
    TerminalLogica t=new TerminalLogica();

    public ControladorJuegoHistoria() {
    }

    public String obtenerHistoriaUsuarioSesion(){
        return historia.obtenerHistoriaDeCampania(iSesion.getNroCampania(),iSesion.getProgreso());
    }
    
    public String manejoComandoDeITerminal (String lineaTextoIngresada){
        t.setEntrada(lineaTextoIngresada);//usa la interfaz
        t.generarComandoYSalida();
        return t.getSalida();
    }
    
    public void avanceMision(){
        if (historia.obtenerComandoDeCampania(iSesion.getNroCampania(), iSesion.getProgreso()).equals(t.getEntrada())){//ingresa correctamente el comando
            if (iJuego.jugadorGano())
                JOptionPane.showConfirmDialog(null,"GANASTE, FELICITACIONES, Eres un PowerHack",
                        "PowerHack",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            else
                //Si llego al final de la campania
                if (iJuego.jugadorAlFinalDeCampania(iSesion.getNroCampania())){//Avanza a la campania siguiente
                    iSesion.setProgreso(0);
                    iSesion.setNroCampania(iSesion.getNroCampania()+1);
                    JOptionPane.showConfirmDialog(null,"Felicitaciones!!!, Avanzaste a la campania "+iSesion.getNroCampania(),
                        "PowerHack",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    iSesion.setProgreso(iSesion.getProgreso()+1);
        }
        else{
            JOptionPane.showConfirmDialog(null,"Ese no es el comando correcto, vuelva a intentar ",
                        "PowerHack",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public String getPrompt() {
        String hostname = "localhost";
        String chroot = "~";
        String pwd = t.getPosicion();
        String usuario = "root";
        String promptSep = " # ";
                
        return usuario+"@"+hostname+":"+pwd+promptSep;
    }
    
    
    @Override
    public boolean jugadorGano(){
        return ( (iSesion.getuEnSesion().getNroCampania() == historia.obtenerCantCampanias()) && (iSesion.getuEnSesion().getProgreso() == historia.obtenerCantidadMisionesDeCampania(historia.obtenerCantCampanias())) );
    }
    
    @Override
    public boolean jugadorAlFinalDeCampania(int nroCampaniasDeHistoria){
        return ( iSesion.getuEnSesion().getProgreso() == historia.obtenerCantidadMisionesDeCampania(nroCampaniasDeHistoria) );
    }
    
}
