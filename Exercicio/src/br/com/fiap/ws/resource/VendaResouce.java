package br.com.fiap.ws.resource;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.ws.dao.VendaDAO;
import br.com.fiap.ws.dao.impl.VendaDAOImpl;
import br.com.fiap.ws.entity.Venda;
import br.com.fiap.ws.exception.CodigoInvalidoException;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

public class VendaResouce {
	private VendaDAO dao;
	
	public VendaResouce() {
		dao = new VendaDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	// DELETE rest/venda/1
		@DELETE
		@Path("{id}")
		public void remover(@PathParam("id") int codigo) {

			try {
				dao.remover(codigo);
				dao.commit();
			} catch (Exception e) {
				e.printStackTrace();
				throw new InternalServerErrorException(); //500
				//return Response.serverError().build();
			}
			//return Response.noContent().build(); //204
		}

		// PUT rest/empresa/1
		@PUT
		@Path("{id}")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response atualizar(Venda venda, @PathParam("id") int codigo) {

			try {
				venda.setId(codigo);
				dao.alterar(venda);
				dao.commit();
			} catch (CommitException e) {
				e.printStackTrace();
				return Response.serverError().build();// 500
			}

			return Response.ok().build(); // 20OK
		}

		// GET rest/empresa/1
		@GET
		@Path("{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Venda busca(@PathParam("id") int codigo) throws CodigoInvalidoException {
			try {
				return dao.buscar(codigo);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

		// http://localhost:8080/12-WS-Restful/rest/empresa/

		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public Response cadastrar(Venda venda, @Context UriInfo url) {

			try {
				dao.cadastrar(venda);
				dao.commit();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.serverError().build(); // 500
			}
			// Criar a URL para acessar a empresa cadastrada
			UriBuilder builder = url.getAbsolutePathBuilder();
			builder.path(String.valueOf(venda.getValor()));

			// HTTP Status Code : 201 Created
			return Response.created(builder.build()).build();
		}

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Venda> buscar() {
			return dao.listar();
		}
}
