package br.com.colecoes;

import java.util.Comparator;

public class PessoaComparator implements Comparator<Pessoa>{

	@Override
	public int compare(Pessoa pessoa1, Pessoa pessoa2) {
		return pessoa1.getNome().compareTo(pessoa2.getNome());
	}
}
