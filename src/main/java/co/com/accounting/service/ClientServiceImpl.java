package co.com.accounting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.accounting.model.Client;
import co.com.accounting.repository.ClientRepository;

@Transactional
@Service
public class ClientServiceImpl implements IClientSerive{

	private final ClientRepository clientRepository;
	
	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	
	@Transactional
	public List<Client> getAllCustomers() {
		// TODO Auto-generated method stub
		return this.clientRepository.findAll();
	}

	@Transactional
	public Client createClient(Client client) {
		// TODO Auto-generated method stub
		return this.clientRepository.save(client);
	}

	@Transactional
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}
	
	@Transactional
	public void deleteClient(long id) {
		// TODO Auto-generated method stub
		Optional<Client> client = this.clientRepository.findById(id);
		if (client.isPresent()) {
		   this.clientRepository.deleteById(id);
		}
	}

	@Transactional
	public Optional<Client> findClientById(long id) {
		// TODO Auto-generated method stub
			Optional<Client> client =	this.clientRepository.findById(id);
			return client;
	}

	@Transactional
	public Client getClienByEmail(String email) {
		// TODO Auto-generated method stub
		return  this.clientRepository.findAll().stream()
                .filter(client -> client.getEmail().toLowerCase().contains(email.toLowerCase()))
                .findFirst().get();
	}

}
