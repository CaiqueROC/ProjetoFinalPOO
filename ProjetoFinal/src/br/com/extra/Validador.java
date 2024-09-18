
package br.com.extra;


public class Validador {

    public static void validarCPF(String cpf) throws ValidadorException {
         	
    	try {
    		if (cpf == null || (cpf.length() != 11) || !cpf.matches("\\d+")) {
                throw new ValidadorException(ValidadorException.CPF_INVALIDO);
       		}
		} catch (ValidadorException e) {
			
			System.err.println("CPF deve possuir 11 digitos!! ");
		}
    		
    }
    
    public static void validarSalarioBruto(double salarioBruto) throws ValidadorException {
    	
    	try {
    		
    		if (salarioBruto < 0) {
                throw new ValidadorException(ValidadorException.SALARIO_BRUTO_INVALIDO);
            }
			
		} catch (Exception e) {
			
			System.err.println("Salário Bruto deve ser positivo!! ");
			
		}
    }

    }

