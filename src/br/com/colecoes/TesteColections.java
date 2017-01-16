package br.com.colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
class Aluno implements Comparable<Aluno> {
	 int matricula;
	 String nome;
	 
	 public Aluno(int matricula, String nome) {
		 this.matricula = matricula;
		 this.nome = nome;
	} 
	 @Override
	public boolean equals(Object obj) {
		return ((Aluno)obj).matricula == this.matricula;
	}	 
	 @Override
	public String toString() {
		return this.nome;
	}
	@Override
	public int compareTo(Aluno aluno) {
		return this.nome.compareTo(aluno.nome);
	}
}

class ComparadorDeAlunos  implements Comparator<Aluno>{

	@Override
	public int compare(Aluno o1, Aluno o2) {
		Integer matricula = o1.matricula; 
		return matricula.compareTo(o2.matricula);
	}
	
}


public class TesteColections {
	public static void main(String[] args) {
		
		//Collection -> List -> Arraylist 
		//						LinkedList
		
		//ordenada get remove contais
		List<String> arrayList = new  ArrayList<>();
		
		
		List<Aluno> alunos = new  LinkedList<>();
		
		alunos.add(new Aluno(0, "Gabriel"));
		alunos.add(new Aluno(1, "Jefferson"));
		alunos.add(new Aluno(2, "Lucas"));
		alunos.add(new Aluno(3, "Jan"));
		alunos.add(new Aluno(4, "Rodrigo"));
		alunos.add(new Aluno(5, "Timtim"));
		
		Aluno timtim = new Aluno(5, "Timtim");
		
		boolean contem = alunos.contains(timtim);
		System.out.println("Timtim em lista: " + contem);
		
		System.out.println(alunos);
		
		Collections.sort(alunos);

		System.out.println(alunos);
		
		Collections.sort(alunos, new ComparadorDeAlunos());
		
		System.out.println(alunos);
		
	}
}
