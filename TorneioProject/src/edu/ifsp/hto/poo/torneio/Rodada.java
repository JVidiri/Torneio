package edu.ifsp.hto.poo.torneio;

import java.util.List;

public class Rodada {
	
	List<Partida> partidas;

	public void addPartida(Partida partida) {
		//Verificar se a partida já existe, ou algum jogador está em uma partida duplicada.
		partidas.add(partida);
	}
	
	public List<Partida> getPartidas(){
		return partidas;
	}

}
