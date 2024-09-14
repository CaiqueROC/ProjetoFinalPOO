
	package br.com.empresa;

	import java.time.LocalDate;

	public class TestarException {

	    public static void main(String[] args) {
	        try {
	            Dependentes dependente1 = new Dependentes("João", "12345678900", LocalDate.of(2006, 9, 14), Parentesco.FILHO);
	            System.out.println("Dependente "+ dependente1.getNome() + " criado com sucesso." + "\n" );
	        } catch (br.com.exception.DependenteException e) {
	            System.out.println("Erro ao criar dependente: " + "\n"  + e.getMessage() + "\n" );
	        }

	        try {
	            Dependentes dependente2 = new Dependentes("Maria", "12345678900", LocalDate.of(2013, 5, 20), Parentesco.FILHO);
	            System.out.println("Dependente " +  dependente2.getNome() + " criado com sucesso.");
	        } catch (br.com.exception.DependenteException e) {
	            System.out.println("Erro ao criar dependente: "+"\n" + e.getMessage() + "\n" );
	        }

	      
	        try {
	            Dependentes dependente3 = new Dependentes("Ana", "09876543210", LocalDate.of(2010, 1, 1), Parentesco.OUTROS);
	            System.out.println("Dependente " +  dependente3.getNome()+ " criado com sucesso.");
	        } catch (br.com.exception.DependenteException e) {
	            System.out.println("Erro ao criar dependente: " + "\n"  + e.getMessage() + "\n" );
	        }
	    }
	}


