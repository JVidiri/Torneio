package edu.ifsp.hto.poo.torneio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rodada {

	List<Partida> partidas;
	List<Jogador> vencedores;

	public Rodada() {
		partidas = new ArrayList<Partida>();
		vencedores = new ArrayList<Jogador>();
	}

	public void addPartida(Partida partida) {
		// Verificar se a partida já existe, ou algum jogador está em uma
		// partida duplicada.

		partidas.add(partida);
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public void iniciarPartidasDaRodada() {
		for (Iterator<Partida> i = partidas.iterator(); i.hasNext();) {
			Partida partidaAtual = (Partida) i.next();
			partidaAtual.definirVencedor();
			vencedores.add(partidaAtual.getVencedor());
		}
	}

	public List<Jogador> getVencedoresDaRodada() {
		return vencedores;
	}

}
