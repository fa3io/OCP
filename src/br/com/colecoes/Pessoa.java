package br.com.colecoes;

public class Pessoa implements Comparable<Pessoa> {
	
	private Integer codigo;
	private String nome;
	private Integer idade;
	
	public Pessoa(Integer codigo, String nome, Integer idade) {
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "ID: " + getCodigo() + " Nome: " + getNome() + " Idade: "+ getIdade()  ;
	}

	@Override
	public int compareTo(Pessoa pessoa) {
		return this.getCodigo().compareTo(pessoa.getCodigo());
	}
	
	
	
	
}
