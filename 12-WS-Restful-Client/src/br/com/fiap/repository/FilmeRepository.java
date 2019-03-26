package br.com.fiap.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.to.Filme;

public class FilmeRepository {

	private Client client = Client.create();
	
	private static final String URL = "http://localhost:8080/11-WS-Restful/rest/filme/";
	
	public void atualizar(Filme filme) throws Exception {
		WebResource resource = client.resource(URL)
						.path(String.valueOf(filme.getCodigo()));
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, filme);
		
		if (resp.getStatus() != 200) {
			throw new Exception();
		}
	}
	
	public void remover(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
						.path(String.valueOf(codigo));
		
		ClientResponse resp = resource.delete(ClientResponse.class);
		
		if (resp.getStatus() != 204) { //204 No Content
			throw new Exception();
		}
		
	}
	
	public void cadastrar(Filme filme) throws Exception {
		
		WebResource resource = client.resource(URL);
		
		ClientResponse resp = resource.type(MediaType.APPLICATION_JSON)
									.post(ClientResponse.class, filme);
		
		if (resp.getStatus() != 201) {
			throw new Exception();
		}
		
	}
	
	public Filme buscar(int codigo) throws Exception {

		WebResource resource = client.resource(URL).path(String.valueOf(codigo));		

		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// valida se a chamada ao ws deu certo
		if (resp.getStatus() != 200) {
			throw new Exception("Erro ao conectar no servidor");
		}
		
		Filme filme = resp.getEntity(Filme.class);
		return filme;
	}

	public List<Filme> listar() throws Exception {

		WebResource resource = client.resource(URL);

		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// valida se a chamada ao ws deu certo
		if (resp.getStatus() != 200) {
			throw new Exception("Erro ao conectar no servidor");
		}
		// Recuperar os filmes
		Filme[] array = resp.getEntity(Filme[].class);
		return Arrays.asList(array); // transforma um vetor em lista
	}

}
