package libreria.servicio;

import java.util.List;
import libreria.entidad.Libro;
import libreria.persistencia.LibroDAO;

public class LibroServicio {
    private LibroDAO dao;
    
    public LibroServicio(){
        this.dao = new LibroDAO();
    }
    
    public String guardarLibro(Libro unLibro) throws Exception{
        try {
            dao.guardarLibro(unLibro);
            return "Libro guardado";
        } catch (Exception e) {
            throw e;
        }
    }
    
    public String estadoLibro(Long isbn) throws Exception{
        try {
            dao.estadoLibro(isbn);
            boolean estado = dao.busquedaPorIsbn(isbn).getAlta();
            if (estado){
                return "Estado activo";
            }else{
                return "Estado inactivo";
            }
        } catch (Exception e) {
           throw e;
        }
    }
    public String editarTitulo(Long isbn, String nuevoTitulo)throws Exception{
        try {
            dao.editarTituloLibro(isbn, nuevoTitulo);
            return "Titulo editado";
        } catch (Exception e) {
            throw e;
        }
    }
    public Libro busquedaPorIsbn(Long isbn)throws Exception{
        try {
            return dao.busquedaPorIsbn(isbn);
        } catch (Exception e) {
            throw e;
        }
    }
    public Libro busquedaPorTitulo(String titulo)throws Exception{
        try {
            return dao.busquedaPorTitulo(titulo);
        } catch (Exception e) {
            throw e;
        }
    }
    public List<Libro> busquedaPorAutor(String autor)throws Exception{
        try {
            return dao.busquedaPorAutor(autor);
        } catch (Exception e) {
            throw e;
        }
    }
    public List<Libro> busquedaPorEditorial(String editorial)throws Exception{
        try {
            return dao.busquedaPorAutor(editorial);
        } catch (Exception e) {
            throw e;
        }
    }
}
