package regularizacion.userservice.repository;

import org.springframework.data.repository.CrudRepository;

import regularizacion.userservice.models.RCCliente;

public interface ClientRepository extends CrudRepository<RCCliente, Long> {

	RCCliente findByNombre(String nombre);
}
