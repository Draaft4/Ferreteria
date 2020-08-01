package Controladores;

import java.util.List;

public interface ControladorGenerico {

    public void create(Object obj);

    public void read(String codigo);

    public void update(Object obj);

    public void delete(String codigo);

    public List<Object> find();

}
