package br.com.arquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import br.com.empresa.Funcionario;

public class Write {

	public void escreverArquivo(String caminho, List<Funcionario> funcionarios) {
		try {
			FileWriter writer = new FileWriter(caminho, true);

			for (Funcionario f : funcionarios) {
				String linha = String.format("%s;%s;%.2f;%.2f;%.2f", f.getNome(), f.getCpf(), f.calculoINSS(), f.calculoIR(), f.salarioLiquido());
				writer.write(linha + "\n");
			}
			writer.close();
			System.out.println("Arquivo gravado com sucesso!");

		} catch (IOException e) {
			System.out.println("Erro ao escrever o arquivo.");
			e.printStackTrace();
		}
	}

}
