package br.com.colecoes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestesComCollection {
	public static void main(String[] args) {
		
		String[] pessoas = new String[]{"F�bio","Flavio"};
		
		List<?> list2 = new ArrayList<>(Arrays.asList(pessoas));
	}
}
