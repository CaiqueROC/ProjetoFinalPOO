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
                String linha = f.getNome() + ";" + f.getCpf() + ";" + f.getSalarioBruto() + ";";
                writer.write(linha + "\n");
            }
            writer.close();
            System.out.println("Arquivo gravado com sucesso!");
            
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo.");
            e.printStackTrace();
        }
    }
    
        public static void main(String[] args) {
            String caminhoLeitura = "C://curso/Teste01.csv";
            String caminhoEscrita = "C://curso/SaidaTeste01.csv";

            try {
                List<Funcionario> funcionarios = Read.lerArquivo(caminhoLeitura);

                Write escritor = new Write();
                escritor.escreverArquivo(caminhoEscrita, funcionarios);

            } catch (IOException e) {
                System.out.println("Erro ao processar os arquivos.");
                e.printStackTrace();
            }
        }

}
