package edu.ifsp.hto.poo.torneio;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GerenciadorTorneio {

	public static final int MAX_JOGADORES_TORNEIO = 16;

	Torneio torneio;

	Rodada gerarRodada(List<Jogador> vencedores) {
		System.out.println("Gerando rodada");
		Rodada rodada = new Rodada();
		for (int indexJogador = 0; indexJogador < vencedores.size(); indexJogador++) {
			Jogador jogadorA = vencedores.get(indexJogador);
			indexJogador++;
			Jogador jogadorB = vencedores.get(indexJogador);
			Partida partida = gerarPartida(jogadorA, jogadorB);
			rodada.addPartida(partida);
		}
		return rodada;
	}

	Partida gerarPartida(Jogador a, Jogador b) {
		return new Partida(a, b);

	}

	private Rodada sortearJogadores() {
		List<Jogador> jogadores = torneio.getJogadores();
		Rodada rodada = new Rodada();
		long seed = System.nanoTime();
		Collections.shuffle(jogadores, new Random(seed));
		for (Iterator<Jogador> i = jogadores.iterator(); i.hasNext();) {
			Jogador jogadorA = (Jogador) i.next();
			Jogador jogadorB = (Jogador) i.next();
			Partida partida = gerarPartida(jogadorA, jogadorB);
			rodada.addPartida(partida);
		}
		return rodada;

	}

	void iniciarTorneio() {
		torneio = new Torneio();
		while (torneio.getNumJogadores() < MAX_JOGADORES_TORNEIO) {
			torneio.cadastrarJogador();
		}
		torneio.addRodada(sortearJogadores());
		do {
			List<Jogador> vencedores = torneio.iniciarRodada();
			if (vencedores.size() < 2) {
				break;
			}
			torneio.addRodada(gerarRodada(vencedores));
		} while (torneio.hasProximaRodada());
		System.out.println("O campeão foi: " + torneio.getCampeao().getNome());

	}

	public static void main(String[] args) {
		GerenciadorTorneio gerenciador = new GerenciadorTorneio();
		gerenciador.iniciarTorneio();
	}

}
