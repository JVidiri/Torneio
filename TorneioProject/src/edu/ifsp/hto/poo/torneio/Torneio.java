package edu.ifsp.hto.poo.torneio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Torneio {

	private List<Jogador> jogadores;
	private List<Rodada> rodadas;

	public Torneio() {
		jogadores = new ArrayList<Jogador>();
		rodadas = new ArrayList<Rodada>();
	}

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
		Jogador jogador = new Jogador();
		Scanner sc = new Scanner(System.in);
		jogador.setNome(sc.nextLine());
		jogador.setCpf(sc.nextLine());
		jogador.setEndereco(sc.nextLine());
		jogador.setTelefone(sc.nextLine());
		return adicionarJogador(jogador);
	}

	public static void main(String[] args) {

	}

	public int getNumJogadores() {
		return jogadores.size();
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void addRodada(Rodada rodada) {
		rodadas.add(rodada);
	}

	public List<Jogador> iniciarRodada() {
		List<Jogador> campoes = new ArrayList<Jogador>();
		return campoes;
	}

}