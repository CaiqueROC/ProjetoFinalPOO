package br.com.teste;

import br.com.arquivos.Read;
import br.com.arquivos.Write;
import br.com.empresa.Funcionario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        try {

            List<Funcionario> funcionarios = Read.lerArquivo("ProjetoFinal/src/br/com/teste/teste.csv");
            Write write = new Write();
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario.getDependente());
            }
            write.escreverArquivo("ProjetoFinal/src/br/com/teste/escrita.csv", funcionarios);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}