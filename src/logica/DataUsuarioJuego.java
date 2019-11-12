
package logica;

public class DataUsuarioJuego {
    private String nickname;
    private String email;
    private String contrasenia;
    private int nroCampania;
    private int progreso;
        
    public DataUsuarioJuego(){
        progreso=0;
        nroCampania=1;
    }

    public DataUsuarioJuego(String nickname, String email, String contrasenia, int nroCampania, int progreso) {
        this.nickname = nickname;
        this.email = email;
        this.contrasenia = contrasenia;
        this.nroCampania = nroCampania;
        this.progreso = progreso;
    }

   

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    public int getNroCampania() {
        return nroCampania;
    }

    public void setNroCampania(int nroCampania) {
        this.nroCampania = nroCampania;
    }

    
    
    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    @Override
    public String toString() {
        return "DataUsuarioJuego{" + "nickname=" + nickname + ", email=" + email + ", contrasenia=" + contrasenia + ", nroCampania=" + nroCampania + ", progreso=" + progreso + '}';
    }

    
}
