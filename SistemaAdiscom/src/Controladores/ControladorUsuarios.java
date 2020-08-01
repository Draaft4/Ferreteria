package Controladores;

import DAO.UsuarioBD;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ControladorUsuarios implements ControladorGenerico {

    UsuarioBD base;
    ArrayList<Usuario> listUsuario;

    public ControladorUsuarios() {
        base = new UsuarioBD();
        listUsuario = base.ListUsuario();
    }

    public void print() {
        for (Usuario usuario : listUsuario) {
            System.out.println(usuario.toString());
        }
    }

    public boolean verificar(String usr, String pass) {
        Usuario usrObtn = null;
        for (Usuario usuario : listUsuario) {
            if (usuario.getUser().equals(usr)) {
                usrObtn = usuario;
            }
        }
        if (usrObtn != null) {
            if (usrObtn.getPassword().equals(pass)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void create(Object obj) {

    }

    @Override
    public void read(String codigo) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(String codigo) {

    }

    @Override
    public List<Object> find() {

        return null;

    }

}
