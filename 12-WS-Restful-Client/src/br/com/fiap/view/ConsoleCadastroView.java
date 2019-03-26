package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.FilmeRepository;
import br.com.fiap.to.Filme;

public class ConsoleCadastroView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o filme: ");
		String nome = sc.next() + sc.nextLine();
		System.out.print("Digite a duração: ");
		int duracao = sc.nextInt();
		System.out.print("Está em cartaz? ");
		boolean cartaz = sc.nextBoolean();
		
		Filme filme = new Filme(0, nome, duracao, cartaz);
		
		FilmeRepository rep = new FilmeRepository();
		
		try {
			rep.cadastrar(filme);
			System.out.println("Sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}
