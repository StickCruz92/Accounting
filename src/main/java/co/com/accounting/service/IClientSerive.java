package co.com.accounting.service;

import java.util.List;
import java.util.Optional;

import co.com.accounting.model.Client;

public interface IClientSerive {

	List<Client> getAllCustomers();
	
	Client createClient (Client client); 

    void deleteClient (long id); 

    Optional<Client> findClientById(long id);

	Client updateClient(Client client);
	
	Client getClienByEmail (String email);
	
}
