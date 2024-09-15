package br.com.empresa;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import br.com.exception.DependenteException;

public class Dependentes extends Pessoa {
      /*/Criar uma classe DependenteException para tratar exceções de
dependente:
● Todo dependente tem que ser menor que 18 anos.
● Não pode existir dependentes com o mesmo CPF.
      */
	private Parentesco parentesco;
    private static Set<String> cpfsCadastrados = new HashSet<>();

	public Dependentes(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) throws DependenteException {
		super(nome, cpf, dataNascimento);
		this.parentesco = parentesco;
		
		DependenteValido(dataNascimento, cpf);  
	     ParentescoValido(parentesco); 
	    cpfsCadastrados.add(cpf);
	}

	public Parentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(Parentesco parentesco) {
		this.parentesco = parentesco;
	}
	private void DependenteValido(LocalDate dataNascimento,String cpf) throws DependenteException{
		if(Period.between(dataNascimento , LocalDate.now()).getYears()>=18) {
			throw new DependenteException ("Pessoa com idade igual ou mair a 18 anos não é um dependente valido. ");
		}
		if (cpfsCadastrados.contains(cpf)) {
			throw new DependenteException("CPF já existente. ");
			
			}
		
	}
		   private void ParentescoValido( Parentesco parentesco) throws DependenteException{
			boolean ParentescoValido = parentesco == Parentesco.FILHO || parentesco == Parentesco.SOBRINHO;
		    if (!ParentescoValido) {
			throw new DependenteException ("Parentesco de dependente não valido. Apenas FILHO e SOBRINHO são permitidos. ");
			}
	}
	
	
}
