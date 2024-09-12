package br.com.empresa;

import java.time.LocalDate;

public class Dependentes extends Pessoa {
      
	private Parentesco parentesco;

	public Dependentes(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}
	
	
}
