package regularizacion.userservice.services;

import regularizacion.userservice.models.RCCliente;

public interface ClientService {
	
	RCCliente createClient(RCCliente rcClient);
	
	RCCliente getClientByName(String name);
	

}
