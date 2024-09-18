package br.com.empresa;

import java.time.LocalDate;

import br.com.extra.Validador;
import br.com.extra.ValidadorException;

public abstract class Pessoa {

	private String nome;
	private String cpf;
	private LocalDate dataNascimento;

	 public Pessoa(String nome, String cpf, LocalDate dataNascimento) throws ValidadorException {
	        this.nome = nome;
	        Validador.validarCPF(cpf); // Validação do CPF
	        this.cpf = cpf;
	        this.dataNascimento = dataNascimento;
	    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws ValidadorException {
        Validador.validarCPF(cpf); // Validação do CPF
        this.cpf = cpf;
    }

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	 public void setDataNascimento(LocalDate dataNascimento) {
	        this.dataNascimento = dataNascimento;
	    }

}
