
package logica.interfaces;

public interface ISistemaJuegoHistoria {
    public String obtenerHistoriaUsuarioSesion();
    public String manejoComandoDeITerminal(String lineaTextoIngresada);
    public void avanceMision();
    public String getPrompt();
    
    public boolean jugadorGano();
    
    public boolean jugadorAlFinalDeCampania(int nroCampaniasDeHistoria);
}
