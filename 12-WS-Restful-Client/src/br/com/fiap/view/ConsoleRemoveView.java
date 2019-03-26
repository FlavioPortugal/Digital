package br.com.fiap.view;

import java.util.Scanner;

import br.com.fiap.repository.FilmeRepository;

public class ConsoleRemoveView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Código: ");
		int codigo = sc.nextInt();
		
		FilmeRepository rep = new FilmeRepository();
		try {
			rep.remover(codigo);
			System.out.println("Removido!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();
	}

}
