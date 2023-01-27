
package libreria.persistencia;

import libreria.entidad.Cliente;

public class ClienteDAO extends DAO<Cliente>{
    
    
    public void guardarCliente(Cliente cliente){
        try {
            super.guardar(cliente);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
