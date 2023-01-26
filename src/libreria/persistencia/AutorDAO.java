package libreria.persistencia;

import libreria.entidad.Autor;

public class AutorDAO extends DAO<Autor>{
    
    
    public void guardarAutor(Autor autor)throws Exception{
        try {
            super.guardar(autor);

        } catch (Exception e) {
            throw e;
        }
    }
    public void estadoAutor(Integer id) throws Exception{
        try {        
            Autor autor = buscarPorId(id);
            if(autor.getAlta() == true){
                autor.setAlta(false);
            }else{
                autor.setAlta(true);
            }
               super.editar(autor);
            } catch (Exception e) {
                throw e;
        }
    }
    public void editarNombreAutor(Integer id, String nombre) throws Exception{
        try {                
            Autor autor = buscarPorId(id);
            autor.setNombre(nombre);
            super.editar(autor);
        } catch (Exception e) {
            throw e;
        }
    }
    public Autor buscarPorId(Integer id)throws Exception{
        try {
            conectar();
            Autor nuevoAutor = em.find(Autor.class, id);
            if(nuevoAutor != null){
                desconectar();
                throw new Exception("Autor ya existe");
            }else{
                desconectar();
                return nuevoAutor;
            }
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    public Autor buscarAutorPorNombre(String nombre)throws Exception{
        try {
            conectar();
            Autor nuevoAutor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
            if(nuevoAutor != null){
                desconectar();
                throw new Exception("Autor no existe");
            }else{
                desconectar();
                return nuevoAutor;
            }
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
   
}
