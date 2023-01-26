package libreria;

import libreria.entidad.Autor;
import libreria.entidad.Editorial;
import libreria.entidad.Libro;
import libreria.servicio.AutorServicio;
import libreria.servicio.LibroServicio;
import libreria.servicio.EditorialServicio;

public class MainLibreria {
    public static void main(String[] args) throws Exception{
       LibroServicio libroServ = new LibroServicio();
       AutorServicio autorServ = new AutorServicio();
       EditorialServicio editorialServ = new EditorialServicio();
       
       Libro libroUno = new Libro();
       libroUno.setTitulo("Un libro");
       libroUno.setAnio(1960);
       
       Autor autor1 = new Autor();
       autor1.setNombre("Autor de libro 1");
       
       Editorial editorial1 = new Editorial();
       editorial1.setNombre("Editorial de libro 1");
     
       libroUno.setAutor(autor1);
       libroUno.setEditorial(editorial1);
       
       autorServ.guardarAutor(autor1);
       editorialServ.guardarAutor(editorial1);
       
       libroServ.guardarLibro(libroUno);
       
    }   
}
