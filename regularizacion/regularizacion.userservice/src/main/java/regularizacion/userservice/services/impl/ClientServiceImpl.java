package regularizacion.userservice.services.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import regularizacion.userservice.models.RCCliente;
import regularizacion.userservice.repository.ClientRepository;
import regularizacion.userservice.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	private static final Logger LOG = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public RCCliente getClientByName(String clientName) {
		return clientRepository.findByNombre(clientName);
	}

	@Override
	public RCCliente createClient(RCCliente rcClient) {
	
		RCCliente localClient = clientRepository.findByNombre(rcClient.getNombre());
		Date today = new Date();
		localClient = clientRepository.save(rcClient);
		return localClient;
		
		
		
/*		if(localClient != null) {
		//	LOG.info("Usuario con username {} ya existe. Nada será hecho!", user.getUsername());
		} else {
			
			Set<UserRole> userRoles = new HashSet<>();
			Role localRole = new Role();
			localRole.setRoleId(1);
			userRoles.add(new UserRole(user,localRole));
			user.getUserRoles().addAll(userRoles);
		*/	
			
		//	rcClient.setName("GUZMAN");
		//	rcClient.setDescription("TEST MYSQL");
			
			
		/*	String encryptedPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
			user.setPassword(encryptedPassword); */		 

	}
}
