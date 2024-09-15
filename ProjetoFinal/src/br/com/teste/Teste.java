package br.com.teste;

import br.com.empresa.Funcionario;

public class Teste {

	public static void main(String[] args) {

		Funcionario f = new Funcionario("Rayssa", "20926220030", null, 6000.);

		f.calculoINSS();
		f.calculoIR();

		System.out.println(f);

	}

}