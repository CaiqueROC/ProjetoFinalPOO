package br.com.empresa;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import br.com.extra.ValidadorException;


public class Dependentes extends Pessoa {

	private Parentesco parentesco;
    private static Set<String> cpfsCadastrados = new HashSet<>();

	public Dependentes(String nome, String cpf, LocalDate dataNascimento, Parentesco parentesco) throws DependenteException, ValidadorException {
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
		//Validador.validarDataNascimento(dataNascimento);
		if(Period.between(dataNascimento , LocalDate.now()).getYears()>=18) {
			throw new DependenteException ("Dependente com idade igual ou maior a 18 anos não é válido. ");
		}
		if (cpfsCadastrados.contains(cpf)) {
			throw new DependenteException("CPF já existente. ");
			
			}
		
	}
		   private void ParentescoValido( Parentesco parentesco) throws DependenteException{
			boolean ParentescoValido = parentesco == Parentesco.FILHO || parentesco == Parentesco.SOBRINHO || parentesco == Parentesco.OUTROS;
		    if (!ParentescoValido) {
			throw new DependenteException ("Parentesco de dependente não valido. Apenas FILHO, OUTROS e SOBRINHO são permitidos. ");
			}
		   }
		   
		    
	}
	
	

