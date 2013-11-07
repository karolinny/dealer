package br.edu.ifpb.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.edu.ifpb.model.Address;
import br.edu.ifpb.model.Book;
import br.edu.ifpb.model.Client;
import br.edu.ifpb.model.Dealer;
import br.edu.ifpb.model.National;

@Path("/dealer")
public class DealerResource {

	static private Map<Integer, Dealer> dealersMap;
	static private List<Book> booksDealer;
	static private List<Book> booksClient;
	static private List<Client> clients;

	static {
		dealersMap = new HashMap<Integer, Dealer>();

		National booknational1 = new National();

		booknational1.setId(1L);
		booknational1.setDescription("Primeiro Livro");
		booknational1.setAuthor("Karol");
		booknational1
				.setTitle("Uma Ferramenta para detecção de Dados Geograficos em uma "
						+ "infraestrutura de dados espaciais");
		booknational1.setISBN("87777-889");

		booksDealer = new ArrayList<Book>();
		booksDealer.add(booknational1);

		Client client = new Client();

		booksClient = new ArrayList<Book>();
		booksClient.add(booksDealer.get(0));

		client.setId();
		client.setName("Karolinny");
		client.setBirthday("05/05/1994");
		client.setBooks(booksClient);

		clients = new ArrayList<Client>();
		clients.add(client);

		Address address = new Address();

		address.setCity("Cajazeiras");
		address.setCEP("58900-000");
		address.setState("PB");
		address.setStreet("Rua Estudante Estefanny Ehrich");
		address.setNumber("93");

		Dealer dealer = new Dealer();
		
		dealer.setId(1);
		dealer.setName("MultDistr");
		dealer.setCnpj("33333/3");
		dealer.setFone("(83)3531-1530");
		dealer.setAddress(address);
		dealer.setBooks(booksDealer);
		dealer.setClients(clients);

		dealersMap.put(dealer.getId(), dealer);
	}
	
	//Lista todas as Distribuidoras
	@Path("/get")
	@GET
	@Produces("text/xml")
	public List<Dealer> getDealer() {
		return new ArrayList<Dealer>(dealersMap.values());
	}

	

	//Atualiza Distribuidora
	@Path("updateDealer/{id}")
	@PUT @Consumes("text/xml")
	@Produces("text/plain") 
	public String updateDealer(Dealer dealer, @PathParam("id") int id) { 
		Dealer modify = dealersMap.get(id); 
		modify.setName(dealer.getName());
		modify.setCnpj(dealer.getCnpj());
		modify.setFone(dealer.getFone());
		return dealer.getName() + " atualizada."; 
	}
	
	//Deleta uma distribuidora
	@Path("/delete/{id}")
	@DELETE
	@Produces("text/xml") 
	public String removeDealer(@PathParam("id") int id) { 
		dealersMap.remove(id); return "Distribuidora removida.";
	}
	
	//Lista todos os clientes
	@Path("client/get")
	@GET
	@Produces("text/xml")
	public List<Client> getClient() {
		return clients;
	}
	
	//Adiciona uma novo Cliente
		@Path("/addClient")
		@POST
		@Consumes("text/xml")
		@Produces("text/xml")
		public String adicionaClient(Client client) {
			clients.add(client);
			return client.getName() + "adicionado.";
		}
	
		
		//Atualiza Cliente
		@Path("updateClient/{id}")
		@PUT @Consumes("text/xml")
		@Produces("text/plain") 
		public String updateClient(Client client, @PathParam("id") int id) { 
			Client modify = clients.get(id); 
			modify.setName(client.getName());
			modify.setBirthday(client.getBirthday());
			return client.getName() + " atualizado."; 
		}
		
		//Deleta um cliente
		@Path("/deleteClient/{id}")
		@DELETE
		@Produces("text/xml") 
		public String removeClient(@PathParam("id") int id) { 
			clients.remove(clients.get(id -1)); return "Cliente removido.";
		}
	
}
