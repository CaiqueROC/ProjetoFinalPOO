package br.com.empresa;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
  
	 private double salarioBruto;
	 private double descontoINSS;
	 private double descontoIR;
	  
	 
	 public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto, double descontoINSS,
			double descontoIR) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.descontoINSS = descontoINSS;
		this.descontoIR = descontoIR;
	}
	 
	 
	 
	
	 
	 
	 
	
}
