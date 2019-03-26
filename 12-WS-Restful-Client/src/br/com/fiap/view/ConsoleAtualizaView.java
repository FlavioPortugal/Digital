package br.com.fiap.view;

import java.util.Scanner;

import org.omg.CORBA.RepositoryIdHelper;

import br.com.fiap.repository.FilmeRepository;
import br.com.fiap.to.Filme;

public class ConsoleAtualizaView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Código: ");
		int codigo = sc.nextInt();
		System.out.print("Nome: ");
		String nome = sc.next() + sc.nextLine();
		System.out.print("Duração: ");
		int duracao = sc.nextInt();
		System.out.print("Cartaz: ");
		boolean cartaz = sc.nextBoolean();
		
		Filme filme = new Filme(codigo, nome, duracao, cartaz);
		
		FilmeRepository rep = new FilmeRepository();
		
		try {
			rep.atualizar(filme);
			System.out.println("Atualizado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}
