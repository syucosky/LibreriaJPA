package libreria.servicio;

import libreria.entidad.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicio {
    private EditorialDAO dao;
    
    
    public EditorialServicio(){
        this.dao = new EditorialDAO();
    }
    
    public String guardarAutor(Editorial editorial)throws Exception{
        try {
            dao.guardarEditorial(editorial);
            return "Editorial guardado";
        } catch (Exception e) {
            throw e;
        }
    }
    public String estadoEditorial(Integer id) throws Exception{
        try {
            dao.estadoEditorial(id);
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
            dao.editarNombreEditorial(id, nuevoNombre);
            return "Nombre Editado";
        } catch (Exception e) {
            throw e;
        }
    }
    public Editorial buscarPorId(Integer id)throws Exception{
        try {
            return dao.buscarPorId(id);
        } catch (Exception e) {
            throw e;
        }
    }
    public Editorial buscarEditorialPorNombre(String nombre)throws Exception{
        try {
            return dao.buscarEditorialPorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
}
