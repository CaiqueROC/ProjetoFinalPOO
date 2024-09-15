package br.com.arquivos;

import br.com.empresa.Dependentes;
import br.com.empresa.Funcionario;
import br.com.empresa.Parentesco;
import br.com.exception.DependenteException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

public final class Read {
	private Read() {
	}

	public static List lerArquivo(String path) throws IOException {
		List<Funcionario> funcionarios = new ArrayList<>();
		List<String> dependentes = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String[] stringLinha = new String[4];
		String linha;

		while (br.ready()) {

			linha = br.readLine();

			if (!linha.isEmpty()) {
				stringLinha = linha.split(";");
				LocalDate teste = LocalDate.parse(stringLinha[2], DateTimeFormatter.ofPattern("yyyyMMdd"));
				Funcionario f = new Funcionario(stringLinha[0], stringLinha[1], teste,
						Double.parseDouble(stringLinha[3]));
				System.out.println(f);
				funcionarios.add(f);

				linha = br.readLine();
				while (!linha.isBlank()) {

					stringLinha = linha.split(";");
					dependentes.add(stringLinha[1]);
					teste = LocalDate.parse(stringLinha[2], DateTimeFormatter.ofPattern("yyyyMMdd"));

					try {
						Dependentes d = new Dependentes(stringLinha[0], stringLinha[1], teste,
								Parentesco.valueOf(stringLinha[3]));

						System.out.println(d);
						linha = br.readLine();
						if (linha == null)
							break;

					} catch (DependenteException e) {
						System.err.println("Erro ao cadastrar" + e.getMessage());
					}

				}
			}
		}
		return funcionarios;
	}

	public static void main(String[] args) throws IOException {
		Read.lerArquivo("src/br/com/arquivos/teste.csv");

	}
}
