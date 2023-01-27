package libreria.persistencia;

import libreria.entidad.Prestamo;

public class PrestamoDAO extends DAO<Prestamo> {
    
    public void guardarPrestamo(Prestamo prestamo) throws Exception{
        try {
            super.guardar(prestamo);
        } catch (Exception e) {
            throw e;
        }        
    }
    
        
    
    
    
    
}
