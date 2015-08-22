package edu.ifsp.hto.poo.torneio;

public class Jogador {

	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	private String nome;
	private String endereco;
	private String telefone;

	@Override
	public boolean equals(Object obj) {
		if (obj != null && ((Jogador) obj == this)) {
			return true;
		}
		if (obj != null && obj instanceof Jogador) {
			Jogador jogador = (Jogador) obj;
			if (jogador.getCpf().equals(getCpf())) {
				if (jogador.getNome().equals(getNome())) {
					if (jogador.getEndereco().equals(getEndereco())) {
						if (jogador.getTelefone().equals(getTelefone())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
