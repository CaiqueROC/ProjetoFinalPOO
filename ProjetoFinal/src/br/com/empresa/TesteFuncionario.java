package br.com.empresa;

import java.time.LocalDate;

public class TesteFuncionario {
	public static void main(String[] args) {
		Funcionario f1 = new Funcionario("Caique", "1231231", LocalDate.now(), 6000.);
		
		f1.calculoINSS();
		f1.calculoIR();
		
		System.out.println(f1.toString() +"\n"+ f1.salarioLiquido());
		
	}
}
