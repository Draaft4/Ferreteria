package Modelo;

public class Usuario {

    private int idUsr;
    private String user;
    private String password;
    private int nivelAcceso;

    public Usuario(int idUsr, String password, int nivelAcceso, String user) {
        this.idUsr = idUsr;
        this.password = password;
        this.nivelAcceso = nivelAcceso;
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getIdUsr() {
        return idUsr;
    }

    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsr=" + idUsr + ", password=" + password + ", nivelAcceso=" + nivelAcceso + "Nombre de Usuario= " + user + '}';
    }

}
