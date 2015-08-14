package edu.ifsp.hto.poo.torneio;

import java.util.ArrayList;
import java.util.List;

public class Torneio {

	List<Jogador> jogadores;
	List<Rodada> rodadas;

	public boolean adicionarJogador(Jogador jogador) {
		if (jogadores == null) {
			jogadores = new ArrayList<Jogador>();
		}
		if (jogadores.size() >= 16) {
			return false;
		}
		jogadores.add(jogador);
		return true;
	}

	public boolean cadastrarJogador() {
		Jogador jogador = null;

		return adicionarJogador(jogador);
	}

	/**
	 * Cria as partidas a partir dos jogadores cadastrados
	 */
	public void sortearJogadores() {
		if (jogadores.size() < 16) {
			// TODO Não iniciar o torneio
		}
	}
	
	public static void main(String[] args) {
		
	}

}