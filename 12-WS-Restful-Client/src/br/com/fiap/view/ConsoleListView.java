package br.com.fiap.view;

import java.util.List;

import br.com.fiap.repository.FilmeRepository;
import br.com.fiap.to.Filme;

public class ConsoleListView {

	public static void main(String[] args) {
		
		//Listar todos os filmes cadastrados
		FilmeRepository rep = new FilmeRepository();
		
		try {
			List<Filme> lista = rep.listar();
			
			for (Filme filme : lista) {
				System.out.println(filme.getNome() + ", Duração: " +
					filme.getDuracao() + ", Cartaz: " + filme.isCartaz());
			}
			
		} catch (Exception e) {
			e.printStackTrace();		
		}
		
	}
	
}