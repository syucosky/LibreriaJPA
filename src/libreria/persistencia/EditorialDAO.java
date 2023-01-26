package libreria.persistencia;

import libreria.entidad.Editorial;

public class EditorialDAO extends DAO<Editorial>{
    
    
    public void guardarEditorial(Editorial editorial)throws Exception{
        try {
                super.guardar(editorial);
        } catch (Exception e) {
            throw e;
        }
    }
    public void estadoEditorial(Integer id) throws Exception{
        try {        
            Editorial editorial = buscarPorId(id);
            if(editorial.getAlta() == true){
                editorial.setAlta(false);
            }else{
                editorial.setAlta(true);
            }
               super.editar(editorial);
            } catch (Exception e) {
                throw e;
        }
    }
    public void editarNombreEditorial(Integer id, String nombre) throws Exception{
        try {                
            Editorial editorial = buscarPorId(id);
            editorial.setNombre(nombre);
            super.editar(editorial);
        } catch (Exception e) {
            throw e;
        }
    }
    public Editorial buscarPorId(Integer id)throws Exception{
        try {
            conectar();
            Editorial nuevaEditorial = em.find(Editorial.class, id);
            if(nuevaEditorial != null){
                desconectar();
                throw new Exception("Autor ya existe");
            }else{
                desconectar();
                return nuevaEditorial;
            }
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    public Editorial buscarEditorialPorNombre(String nombre)throws Exception{
        try {
            conectar();
            Editorial nuevaEditorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
            if(nuevaEditorial != null){
                desconectar();
                throw new Exception("Autor no existe");
            }else{
                desconectar();
                return nuevaEditorial;
            }
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
}
