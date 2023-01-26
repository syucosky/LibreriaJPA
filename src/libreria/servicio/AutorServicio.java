package libreria.servicio;

import libreria.entidad.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicio {
    private AutorDAO dao;
    
    
    public AutorServicio(){
        this.dao = new AutorDAO();
    }
    
    public String guardarAutor(Autor autor)throws Exception{
        try {
            dao.guardarAutor(autor);
            return "Autor guardado";
        } catch (Exception e) {
            throw e;
        }
    }
    public String estadoAutor(Integer id) throws Exception{
        try {
            dao.estadoAutor(id);
            boolean estado = dao.buscarPorId(id).getAlta();
            if (estado){
                return "Estado activo";
            }else{
                return "Estado inactivo";
            }
        } catch (Exception e) {
           throw e;
        }
    }
    public String editarNombre(Integer id,String nuevoNombre)throws Exception{
        try {
            dao.editarNombreAutor(id, nuevoNombre);
            return "Nombre Editado";
        } catch (Exception e) {
            throw e;
        }
    }
    public Autor buscarPorId(Integer id)throws Exception{
        try {
            return dao.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    public Autor buscarPorNombre(String nombre)throws Exception{
        try {
            return dao.buscarAutorPorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
}
