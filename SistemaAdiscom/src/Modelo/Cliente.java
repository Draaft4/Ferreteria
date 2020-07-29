package Modelo;

public class Cliente extends Persona{
    
    private String correo;

    public Cliente(int codigo, String nombre, String apellido, String telefono, String cedula, String correo) {
        super(codigo, nombre, apellido, telefono, cedula);
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "correo=" + correo + ",apellido=" + this.getApellido()+
                ",nombre="+this.getNombre()+",cedula="+this.getCedula()+
                "telefono"+this.getTelefono()+'}';
    } 
    
}
