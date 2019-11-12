
package logica;

import java.lang.reflect.Method;



public class TerminalLogica {
    private String entrada;
    private String salida;
    private String posicion;
    private Comando ejecuta;
    
    public TerminalLogica() {
        this.posicion = "~";
    }

    public TerminalLogica(String entrada, String salida) {
        this.entrada = entrada;
        this.salida = salida;
        this.posicion = "~";
    }

    
    
    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    
    
    @Override
    public String toString() {
        return "Terminal{" + "entrada=" + entrada + ", salida=" + salida + '}';
    }
    
    public void generarComandoYSalida() {
        Class comandoClass;
        String comandoNombre;
        String comandoArgumento;
        Object comandoObj;
        String[] argumentos;
        try {
            argumentos = entrada.split(" ");
            comandoNombre = argumentos[0];
            
            comandoClass = Class.forName("logica.comandos."+comandoNombre);         
            if (argumentos.length > 1) {                  
               comandoArgumento = entrada.substring(comandoNombre.length() + 1);
            } else {                      
               comandoArgumento = "";
            }
            comandoObj = comandoClass.getDeclaredConstructor(String.class).newInstance(comandoArgumento);            
            
            Method mthd = comandoClass.getDeclaredMethod("ejecutarYverificar");
            System.out.println(" metodo:"+mthd);
            String salida = (String) mthd.invoke(comandoObj);
            
            this.setSalida(salida);
            
        } catch (ClassNotFoundException ex) {
            this.setSalida("Error comando no encontrado ");

        } catch (Exception ex) {
            
            this.setSalida("Error en " + ex);
            System.err.println(">>>>>>>>"+ ex);
        }
        
     
            //this.setSalida(" >> " +ejecuta.ejecutarComando());
    }
}
