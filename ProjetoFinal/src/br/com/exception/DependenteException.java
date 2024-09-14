package br.com.exception;

import java.time.LocalDate;

import br.com.empresa.Dependentes;

public class DependenteException extends Exception {

	public DependenteException(String mensagem) {

		super(mensagem);
	}

	public void adicionarDependente(Dependentes dependentes) throws DependenteException {

		if (dependentes.getCpf().equals(dependentes.getCpf())) {

			throw new DependenteException("Dependente com CPF duplicado.");

		}

		if (dependentes.getDataNascimento().isAfter(LocalDate.now().minusYears(18))) {

			throw new DependenteException("Dependente deve ser menor de 18 anos.");
		}
	}

}
