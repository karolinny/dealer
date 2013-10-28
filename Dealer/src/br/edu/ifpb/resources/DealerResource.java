package br.edu.ifpb.resources;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
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
	
 static{
		dealersMap = new HashMap<Integer,Dealer>();
		
		National booknational1 = new National();
		
		booknational1.setId(1L);
		booknational1.setDescription("Primeiro Livro");
		booknational1.setAuthor("Karol");
		booknational1.setTitle("Uma Ferramenta para detecção de Dados Geograficos em uma "
							+ "infraestrutura de dados espaciais");
		booknational1.setISBN("87777-889");
		
		List<Book> booksDealer = new ArrayList<Book>();
		booksDealer.add(booknational1);
				
		Client client = new Client();
		
		List<Book> booksClient = new ArrayList<Book>();
		booksClient.add(booksDealer.get(0));
		
		client.setId(1L);
		client.setName("Karolinny");
		client.setBirthday(Calendar.getInstance());
		client.setBooks(booksClient);
		
		List<Client> clients = new ArrayList<Client>();
		clients.add(client);
		
		Address address = new Address();
		
		address.setCity("Cajazeiras");
		address.setCEP("58900-000");
		address.setState("PB");
		address.setStreet("Rua Estudante Estefanny Ehrich");
		address.setNumber("93");
		
		Dealer dealer = new Dealer();
		
		dealer.setName("MultDistr");
		dealer.setCnpj("33333/3");
		dealer.setFone("(83)3531-1530");
		dealer.setAddress(address);
		dealer.setBooks(booksDealer);
		dealer.setClients(clients);
		
		dealersMap.put(1, dealer);
	}
 
 	@GET
	@Produces( "application/json")
	public List<Dealer> getDealer() {
		return new ArrayList<Dealer>(dealersMap.values());
	}

 	@Path("{id}")
	@GET
	@Produces("text/xml")
 	public Dealer getDealer(@PathParam("id") int id){
 		return dealersMap.get(id);
 	}

}
