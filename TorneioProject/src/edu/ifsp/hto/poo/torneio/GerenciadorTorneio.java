package edu.ifsp.hto.poo.torneio;

public class GerenciadorTorneio {

	Torneio torneio;

	void gerarRodada() {

	}

	void gerarPartida() {

	}

	void sortearJogadores() {
		
	}

	void iniciarTorneio() {
		torneio = new Torneio();
		while (torneio.getNumJogadores() < 16) {
			torneio.cadastrarJogador();
		}
		
	}

}
