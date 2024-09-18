package br.com.arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.dao.DependenteDao;
import br.com.dao.FuncionarioDao;
import br.com.empresa.DependenteException;
import br.com.empresa.Dependentes;
import br.com.empresa.Funcionario;
import br.com.empresa.Parentesco;

public final class Read {
	private Read() {
	}

	public static List<Funcionario> lerArquivo(String path) throws FileNotFoundException, IOException {
        System.out.println("Lendo o arquivo...");
        List<Funcionario> funcionarios = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        int idGerado;
        String[] stringLinha = new String[5];
        String linha;

        while (br.ready()) {
            linha = br.readLine();
            if (!linha.isEmpty()) {
                stringLinha = linha.split(";");
                LocalDate dataNascimento = LocalDate.parse(stringLinha[2], DateTimeFormatter.ofPattern("yyyyMMdd"));
                Funcionario f = new Funcionario(stringLinha[0], stringLinha[1], dataNascimento,
                        Double.parseDouble(stringLinha[3]), Integer.parseInt(stringLinha[4]));

                funcionarios.add(f);
                FuncionarioDao daoFuncionario = new FuncionarioDao();
                idGerado = daoFuncionario.inserirFuncionario(f);
                linha = br.readLine();
                if (linha == null) {
                    daoFuncionario.inserirFolhaPagamento(f, idGerado);
                    break;
                }
                while (!linha.isBlank()) {

                    stringLinha = linha.split(";");
                    dataNascimento = LocalDate.parse(stringLinha[2], DateTimeFormatter.ofPattern("yyyyMMdd"));

                    try {
                        Dependentes d = new Dependentes(stringLinha[0], stringLinha[1], dataNascimento,
                                Parentesco.valueOf(stringLinha[3]));

                        linha = br.readLine();
                        f.setDependente(f.getDependente() + 1);
                        DependenteDao daoDependente = new DependenteDao();
                        daoDependente.inserirDependente(d, idGerado);
                        if (linha == null) {
                            daoFuncionario.inserirFolhaPagamento(f, idGerado);
                            break;
                        }

                    } catch (DependenteException e) {
                        System.err.println("Erro ao cadastrar " + e.getMessage());
                        linha = br.readLine();
                        if (linha == null) {
                            break;
                        }
                    }

                }
                daoFuncionario.inserirFolhaPagamento(f, idGerado);
            }
        }
        return funcionarios;
    }
	}

