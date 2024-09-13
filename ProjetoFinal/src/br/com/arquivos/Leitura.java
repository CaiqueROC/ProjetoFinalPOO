package br.com.arquivos;

import br.com.empresa.Dependentes;
import br.com.empresa.Funcionario;
import br.com.empresa.Parentesco;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        sc.close();

        path = "ProjetoFinal/src/br/com/arquivos/" + path + ".csv";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String[] stringLinha = new String[4];
        String linha;
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Dependentes> dependentes = new ArrayList<>();

        while (br.ready()) {

            linha = br.readLine();

            if (!linha.isEmpty()) {
                stringLinha = linha.split(";");
                LocalDate teste = LocalDate.parse(stringLinha[2], DateTimeFormatter.ofPattern("yyyyMMdd"));
                Funcionario f = new Funcionario(stringLinha[0], stringLinha[1], teste, Double.parseDouble(stringLinha[3]));
                System.out.println(f);
                funcionarios.add(f);

                linha = br.readLine();
                while (!linha.isBlank()) {

                    stringLinha = linha.split(";");
                    teste = LocalDate.parse(stringLinha[2], DateTimeFormatter.ofPattern("yyyyMMdd"));
                    Dependentes d = new Dependentes(stringLinha[0], stringLinha[1], teste, Parentesco.valueOf(stringLinha[3]));
                    System.out.println(d);
                    dependentes.add(d);
                    linha = br.readLine();
                    if (linha == null) break;
                }
            }
        }
    }
}
