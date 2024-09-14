package br.com.empresa;

import java.time.LocalDate;

public class Dependentes extends Pessoa {

	private Parentesco parentesco;
	private static Integer qntDependentes = 0;

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

	public static Integer getQntDependentes() {
		return qntDependentes;
	}

	public void setQntDependentes(Integer qntDependentes) {
		this.qntDependentes = qntDependentes;
	}

}
