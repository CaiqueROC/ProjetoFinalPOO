package br.com.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.com.arquivos.Read;
import br.com.arquivos.Write;
import br.com.empresa.Funcionario;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String caminhoLeitura = "C://curso/";
		String caminhoEscrita = "C://curso/";
		
		System.out.println("Insira o nome do arquivo .csv de entrada:");
		caminhoLeitura += sc.next() + ".csv";
		
		System.out.println("Insira o nome do arquivo .csv onde deseja imprimir as informações:");
		caminhoEscrita += sc.next() + ".csv";
		
		try {
			
			List<Funcionario> funcionarios = Read.lerArquivo(caminhoLeitura);
			
			Write escritor = new Write();
			escritor.escreverArquivo(caminhoEscrita, funcionarios);
			
		} catch (FileNotFoundException a) {
			System.err.println("Arquivo não encontrado!");
		} catch (IOException e) {
			System.err.println("Erro na leitura ou escrita!");
		}
	}

}
