package edu.ifsp.hto.poo.torneio;

import java.util.Scanner;

public class Partida {

	private Jogador jogador1;
	private Jogador jogador2;
	private Jogador vencedor;

	public Partida(Jogador a, Jogador b) {
		jogador1 = a;
		jogador2 = b;
	}

	public void definirVencedor(Jogador jogador) {
		if (jogador != null
				&& (jogador.equals(jogador1) || jogador.equals(jogador2))) {
			vencedor = jogador;
		} else {
			System.out.println("Jogador não é válido para esta partida!");
		}
	}

	public Jogador getJogadorUm() {
		return jogador1;
	}

	public Jogador getJogadorDois() {
		return jogador2;
	}

	public void definirVencedor() {
		Scanner sc = new Scanner(System.in);
		System.out.println(String.format("O vencedor foi  1- %s ou 2- %s ?",
				jogador1.getNome(), jogador2.getNome()));
		int numVencedor;
		while (true) {
			String respota = sc.nextLine();
			try {
				numVencedor = Integer.parseInt(respota);
				if (numVencedor == 1 || numVencedor == 2) {
					break;
				} else {
					System.out
							.println("Valores inválidos, digite um valor válido!");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("Numero invalido! Tente novamente!");
			}
		}
		if (numVencedor == 1) {
			definirVencedor(jogador1);
		} else {
			definirVencedor(jogador2);
		}
	}

	public Jogador getVencedor() {
		return vencedor;
	}
}
