package regularizacion.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import regularizacion.userservice.models.RCCliente;
import regularizacion.userservice.services.ClientService;

@RestController
@RequestMapping("/v1/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/{clientName}")
	public RCCliente getClientByName(@PathVariable String clientName) {
		return clientService.getClientByName(clientName);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public RCCliente createRCClient(@RequestBody RCCliente client) {
		return clientService.createClient(client);
	}
	
/*	@RequestMapping(method = RequestMethod.POST)
	public RCCliente createUser(@RequestBody RCCliente user) {
		return userService.createUser(user);
	}*/

}
