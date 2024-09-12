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
import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        sc.close();

        path = "ProjetoFinal/src/br/com/arquivos/" + path + ".csv";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String[] linha = new String[4];

        while (br.ready()) {
            linha = br.readLine().split(";");
            LocalDate teste = LocalDate.parse(linha[2], DateTimeFormatter.ofPattern("yyyyMMdd"));
//            Criar construtor recebendo 4 parâmetros
//            Funcionario f = new Funcionario(linha[0], linha[1], teste, Double.parseDouble(linha[3]));
            linha = br.readLine().split(";");
            teste = LocalDate.parse(linha[2], DateTimeFormatter.ofPattern("yyyyMMdd"));
            Dependentes d = new Dependentes(linha[0], linha[1], teste, Parentesco.FILHO);

/*
                if (linha.length == 4) {
                br.readLine();
                System.out.println("teste");
            }

 */
//            System.out.println(f);
            System.out.println(d);
        }
    }
}

