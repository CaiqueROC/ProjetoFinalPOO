package br.com.dao;

import br.com.connectionDB.ConnectionFactory;
import br.com.empresa.Funcionario;

import java.sql.*;
import java.time.LocalDate;

public class FuncionarioDao {
    private Connection conexao;

    public FuncionarioDao() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public int inserirFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cpf, data_nascimento, salario_bruto) VALUES (?,?,?,?)";
        int idGerado = 0;
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            stmt.setDouble(4, funcionario.getSalarioBruto());
            stmt.execute();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            generatedKeys.next();
            idGerado = generatedKeys.getInt(1);
            stmt.close();
//            conexao.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir funcionario: " + e.getMessage());
        }
        return idGerado;
    }

    public void inserirFolhaPagamento(Funcionario funcionario, int idFuncionario) {
        String sql = "INSERT INTO folha_pagamento (desconto_INSS, desconto_IR, salario_liquido, id_funcionario, data_calculo, vale_transporte) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setDouble(1, funcionario.calculoINSS());
            stmt.setDouble(2, funcionario.calculoIR());
            stmt.setDouble(3, funcionario.salarioLiquido());
            stmt.setInt(4, idFuncionario);
            stmt.setDate(5, Date.valueOf(LocalDate.now()));
            stmt.setDouble(6, funcionario.valeTransporte());
            stmt.execute();
            stmt.close();
            conexao.close();

        } catch (SQLException e) {
            System.err.println("Erro ao inserir folha de pagamento: " + e.getMessage());
        }
    }
}
