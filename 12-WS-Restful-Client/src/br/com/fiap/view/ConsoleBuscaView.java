package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.FilmeRepository;
import br.com.fiap.to.Filme;

public class ConsoleBuscaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o código do filme: ");
		
		int codigo = sc.nextInt();
		
		FilmeRepository rep = new FilmeRepository();
		
		try {
			Filme filme = rep.buscar(codigo);
			
			System.out.println(filme.getNome() + " " +
				filme.getDuracao() + " " + filme.isCartaz());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}
