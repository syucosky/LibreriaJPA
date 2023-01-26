
package libreria.persistencia;

import java.util.List;
import libreria.entidad.Libro;

public class LibroDAO extends DAO<Libro>{
    
    
    public void guardarLibro(Libro libro)throws Exception {
        try {        
            super.guardar(libro);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void estadoLibro(Long isbn) throws Exception{
        try {        
            Libro libro = busquedaPorIsbn(isbn);
            if(libro.getAlta() == true){
                libro.setAlta(false);
            }else{
                libro.setAlta(true);
            }
               super.editar(libro);
            } catch (Exception e) {
                throw e;
        }
    }
    
    public void editarTituloLibro(Long isbn, String titulo) throws Exception{
        try {                
            Libro libro = busquedaPorIsbn(isbn);
            libro.setTitulo(titulo);
            super.editar(libro);
        } catch (Exception e) {
            throw e;
        }
    }
    public Libro busquedaPorIsbn(Long isbn)throws Exception{
        try {
            conectar();
            Libro nuevoLibro = em.find(Libro.class, isbn);
            if(nuevoLibro == null){
                desconectar();
                throw new Exception("Libro no existe");
            }else{
                desconectar();
                return nuevoLibro;
            }
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    public Libro busquedaPorTitulo(String titulo) throws Exception{
        try {
            conectar();
            Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo").setParameter("titulo", titulo).getSingleResult();
            if(libro == null){
                desconectar();
                throw new Exception("Libro inexistente");
            }else{
                desconectar();
                return libro;
            }
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    public List<Libro> busquedaPorAutor(String nombreAutor)throws Exception{
        try {
            conectar();
            List<Libro> Listalibro = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :nAutor").setParameter("nAutor", nombreAutor).getResultList();
            if(Listalibro == null){    
                desconectar();
                throw new Exception("No se encontro Libro con ese Autor");
            }else{
                desconectar();
                return Listalibro;
            }
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    public List<Libro> busquedaPorEditorial(String nombreEditorial)throws Exception{
        try {
            conectar();
            List<Libro> Listalibro = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nEditorial").setParameter("nEditorial", nombreEditorial).getResultList();
            if(Listalibro == null){
                desconectar();
                throw new Exception("No se encontro Libro con ese Autor");
            }else{
                desconectar();
                return Listalibro;
            }
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
}
