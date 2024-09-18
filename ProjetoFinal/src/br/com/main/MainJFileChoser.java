package br.com.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import br.com.arquivos.Read;
import br.com.arquivos.Write;
import br.com.empresa.Funcionario;

public class MainJFileChoser {

	public static void main(String[] args) {
		JFileChooser j = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Apenas .csv", "csv");
		j.setAcceptAllFileFilterUsed(false);
		j.addChoosableFileFilter(filtro);
		String caminhoLeitura = "";
		String caminhoEscrita = "";

		JOptionPane.showMessageDialog(null, "Selecione um arquivo com as informações para cadastro");

		int respostDoFileChooser = j.showOpenDialog(null);

		if (respostDoFileChooser == j.APPROVE_OPTION) {
			File arquivoSelecionado = j.getSelectedFile();
			System.out.println("Caminho do arquivo de entrada : " + arquivoSelecionado.getAbsolutePath());
			caminhoLeitura = arquivoSelecionado.getAbsolutePath();

		} else {
			System.out.println("Nenhum arquivo de entrada selecionado");
		}
		
		JOptionPane.showMessageDialog(null, "Selecione um arquivo para guardar as informações");
		int respostDoFileChooser1 = j.showOpenDialog(null);

		if (respostDoFileChooser1 == j.APPROVE_OPTION) {
			File arquivoSelecionado = j.getSelectedFile();
			System.out.println("Caminho do arquivo da saida: " + arquivoSelecionado.getAbsolutePath());
			caminhoEscrita = arquivoSelecionado.getAbsolutePath();

		} else {
			System.out.println("Nenhum arquivo de entrada selecionado");
		}
		
		
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
