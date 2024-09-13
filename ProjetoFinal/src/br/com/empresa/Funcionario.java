package br.com.empresa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa implements InterfaceMetodos {

	private double salarioBruto;
	private double descontoINSS;
	private double descontoIR;
	private List<Dependentes> dependente;

	public Funcionario(String nome, String cpf, LocalDate dataNascimento, double salarioBruto) {
		super(nome, cpf, dataNascimento);
		this.salarioBruto = salarioBruto;
		this.dependente = new ArrayList();
	}

	@Override
	public String toString() {
		return "salarioBruto: " + salarioBruto + "\ndescontoINSS: " + descontoINSS + "\ndescontoIR: " + descontoIR;
	}

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public double getDescontoINSS() {
		return descontoINSS;
	}

	public void setDescontoINSS(double descontoINSS) {
		this.descontoINSS = descontoINSS;
	}

	public double getDescontoIR() {
		return descontoIR;
	}

	public void setDescontoIR(double descontoIR) {
		this.descontoIR = descontoIR;
	}

	@Override
	public double calculoIR() {
		double baseMensal = salarioBruto - descontoINSS - (dependente.size() * 189.59);

		if (baseMensal <= 2259.00) {

			descontoIR = 0;

		} else if (baseMensal > 2259.00 && baseMensal <= 2826.65) {

			descontoIR = (baseMensal * 0.075) - 169.44;

		}

		else if (baseMensal > 2826.66 && baseMensal <= 3751.05) {

			descontoIR = (baseMensal * 0.15) - 381.44;

		}

		else if (baseMensal > 3751.96 && baseMensal <= 4664.68) {

			descontoIR = (baseMensal * 0.225) - 662.77;

		}

		else {

			descontoIR = (baseMensal * 0.275) - 896.00;

		}
		return descontoIR;

	}

	@Override
	public double calculoINSS() {
		double aliquota;
		double deducao;

		if (salarioBruto <= 1412.00) {

			aliquota = 0.075;
			deducao = 0.;
		}

		else if (salarioBruto > 1412.00 && salarioBruto <= 2666.68) {

			aliquota = 0.09;
			deducao = 21.18;

		} else if (salarioBruto > 2666.69 && salarioBruto <= 4000.03) {

			aliquota = 0.12;
			deducao = 101.18;
		}

		else if (salarioBruto > 4000.04 && salarioBruto <= 7786.02) {

			aliquota = 0.14;
			deducao = 181.18;
		} else {

			aliquota = 0.14;
			deducao = 101.18;
		}

		descontoINSS = (salarioBruto * aliquota) - deducao;
		return descontoINSS;
	}

	@Override
	public double salarioLiquido() {
		return salarioBruto - descontoINSS - descontoIR;

	}

}
