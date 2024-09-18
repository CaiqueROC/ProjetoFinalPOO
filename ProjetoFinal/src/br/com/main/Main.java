
package br.com.main;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.arquivos.Read;
import br.com.arquivos.Write;
import br.com.empresa.DependenteException;
import br.com.empresa.Funcionario;
import br.com.extra.ValidadorException;

public class Main {

    public static void main(String[] args) {
        String caminhoEntrada = "C://curso/entrada.csv";
        String caminhoSaida = "C://curso/saida.csv";

        try (FileWriter writer = new FileWriter(caminhoEntrada, false)) {
            
            JOptionPane.showMessageDialog(null, "---INSIRA OS DADOS DOS FUNCIONARIOS---\nSe deseja encerrar o programa digite 'sair'");

            while (true) {
                String nome = JOptionPane.showInputDialog("Nome do funcionário:");
                if (nome == null || nome.equalsIgnoreCase("sair")) break;

                String cpf = JOptionPane.showInputDialog("CPF do funcionário:");
                String dataNascimentoStr = JOptionPane.showInputDialog("Data de nascimento (yyyyMMdd):");
                String salarioStr = JOptionPane.showInputDialog("Salário bruto:");
                
                double salarioBruto = Double.parseDouble(salarioStr.replace(',', '.'));
                
                writer.write(String.format("%s;%s;%s;%s%n", nome, cpf, dataNascimentoStr, salarioBruto));

                JOptionPane.showMessageDialog(null, "INSIRA OS DADOS DO DEPENDENTE\nDigite 'fim' para finalizar os dependentes");

                while (true) {
                    String nomeDependente = JOptionPane.showInputDialog("Nome do dependente:");
                    if (nomeDependente == null || nomeDependente.equalsIgnoreCase("fim")) {
                        writer.write(""); // Might be unnecessary, can be removed
                        break;
                    }

                    String cpfDependente = JOptionPane.showInputDialog("CPF do dependente:");
                    String dataNascimentoDependenteStr = JOptionPane.showInputDialog("Data de nascimento do dependente (yyyyMMdd):");
                    String parentesco = JOptionPane.showInputDialog("Parentesco (FILHO, SOBRINHO, OUTROS):");
                
                    writer.write(String.format("%s;%s;%s;%s%n", nomeDependente, cpfDependente, dataNascimentoDependenteStr, parentesco));
                }
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao manipular arquivos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            List<Funcionario> funcionarios = Read.lerArquivo(caminhoEntrada);
            Write escritor = new Write();
            escritor.escreverArquivo(caminhoSaida, funcionarios);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro na leitura ou escrita do arquivo: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ValidadorException | DependenteException e) {
            JOptionPane.showMessageDialog(null, "Erro de validação: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

		
		
	   