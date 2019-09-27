package co.com.accounting.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import co.com.accounting.model.Client;
import co.com.accounting.modelView.ClientViewModel;
import co.com.accounting.service.IClientSerive;
import co.com.accounting.util.GeneralResponse;


@RestController
@RequestMapping("/v1/api/client")
public class ClientController {
	
	private final IClientSerive clientSerive;

	public ClientController(IClientSerive clientSerive) {
		this.clientSerive = clientSerive;
	}
	
	@GetMapping
	public ResponseEntity<GeneralResponse> findAll () {
		
		List<Client> clients;
		clients = clientSerive.getAllCustomers();
		return new ResponseEntity<GeneralResponse>(new GeneralResponse("200", "Listar clientes operación exitosa", clients),
				HttpStatus.OK);

	}
	
	
	@GetMapping("/{email}")
	public ResponseEntity<GeneralResponse> findClientByEmail (@PathVariable("email") String email) {
		
		Client client = clientSerive.getClienByEmail(email);
		return new ResponseEntity<GeneralResponse>(new GeneralResponse("200", "Listar clientes operación exitosa", client),
				HttpStatus.OK);

	}
	
	@PostMapping
	public ResponseEntity<?> createCliente(@RequestBody ClientViewModel clientmodel, 
			UriComponentsBuilder uriComponentsBuilder) {
		
		Client client = new Client();
		client.setName(clientmodel.getName());
		client.setAddress(clientmodel.getAddress());
		client.setBirthDate(clientmodel.getBirthDate());
		client.setEmail(clientmodel.getEmail());
		client.setPhone(clientmodel.getPhone());
		
		clientSerive.createClient(client);

		Client  ClienteResul =  this.clientSerive.getClienByEmail(clientmodel.getEmail());
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uriComponentsBuilder.path("/v1/api/client/{email}")
				.buildAndExpand(ClienteResul.getEmail()).toUri());
	
		return new ResponseEntity<GeneralResponse>(
				new GeneralResponse("200", "Cliente Registrado operación exitosa", headers),
				HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/{email}")
	public ResponseEntity<GeneralResponse> updateClienteByEmail (@PathVariable("email") String email,
			@RequestBody ClientViewModel clientmodel) {

		 Client client = this.clientSerive.getClienByEmail(email);
 
		if (client != null) {
			return new ResponseEntity<GeneralResponse>(
					new GeneralResponse("204", "No hay datos en la consulta"),
					HttpStatus.NOT_FOUND);
	        } else {
	        	
	        	Client client2 = new Client();
	        	client2.setName(clientmodel.getName());
	        	client2.setAddress(clientmodel.getAddress());
	        	client2.setBirthDate(clientmodel.getBirthDate());
	        	client2.setEmail(clientmodel.getEmail());
	        	client2.setPhone(clientmodel.getPhone());
	    		this.clientSerive.updateClient(client2);
			
			return new ResponseEntity<GeneralResponse>(
					new GeneralResponse("200", "Cliente actualizado operación exitosa", client),
					HttpStatus.OK);
		}

	}

	@DeleteMapping("/{email}")
	public ResponseEntity<GeneralResponse> RemoveCliente(@PathVariable("email") String email) {

		 Client client =  this.clientSerive.getClienByEmail(email);
		if (client != null)  {
			this.clientSerive.deleteClient(client.getIdClient());
			return new ResponseEntity<GeneralResponse>(new GeneralResponse("200", "Cliente eliminado Operación exitosa"),
					HttpStatus.OK);
		}
        return new ResponseEntity<GeneralResponse>(new GeneralResponse("204", "No hay datos asociado a la consulta"),
        		HttpStatus.NOT_FOUND);

	}
}
