package br.com.extra;


public class ValidadorException extends Exception {
	
	public static String CPF_INVALIDO;
	public static String SALARIO_BRUTO_INVALIDO;

	    public ValidadorException(String messagem) {
	        super(messagem);
	    }

}
	
