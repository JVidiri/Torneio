package edu.ifsp.hto.poo.torneio;

import java.util.List;

public class GerenciadorTorneio {

	Torneio torneio;

	void gerarRodada() {

	}

	Partida gerarPartida(Jogador a, Jogador b) {
		return new Partida(a, b);

	}

	Rodada sortearJogadores() {
		List<Jogador> jogadores = torneio.getJogadores();
		Rodada rodada = new Rodada();
		while (jogadores.size() > 0) {
			int pegaJogador = (int) (Math.random() % jogadores.size());
			Jogador jogadorA = jogadores.get(pegaJogador);
			jogadores.remove(pegaJogador);
			pegaJogador = (int) (Math.random() % jogadores.size());
			Jogador jogadorB = jogadores.get(pegaJogador);
			jogadores.remove(pegaJogador);
			Partida partida = gerarPartida(jogadorA, jogadorB);
			rodada.addPartida(partida);
		}
		return rodada;

	}

	void iniciarTorneio() {
		torneio = new Torneio();
		while (torneio.getNumJogadores() < 16) {
			torneio.cadastrarJogador();
		}
		torneio.addRodada(sortearJogadores());
		List<Jogador> campeoes = torneio.iniciarRodada();
		
	}

}
