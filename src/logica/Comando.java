
package logica;


public abstract class Comando {
    public String argumentos;
    private TerminalLogica salida;
    
    public Comando() {
        argumentos = "";
        //this.salida = new TerminalLogica();
    }

    public Comando(String argumentos) {
        this.argumentos = argumentos;
        this.salida = new TerminalLogica();
    }

    public String getArgumentos() {
        return argumentos;
    }

    public void setArgumentos(String argumentos) {
        this.argumentos = argumentos;
    }

    public TerminalLogica getSalida() {
        return salida;
    }

    public void setSalida(TerminalLogica salida) {
        this.salida = salida;
    }

    
    
    public abstract String ejecutarComando();
    
    
    public abstract String ejecutarYverificar();
}
