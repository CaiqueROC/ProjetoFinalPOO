package br.com.dao;

import br.com.connectionDB.ConnectionFactory;
import br.com.empresa.Dependentes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DependenteDao {
    private Connection conexao;

    public DependenteDao() {
        this.conexao = new ConnectionFactory().getConnection();
    }

    public void inserirDependente(Dependentes dependente, int idFuncionario) {
        String sql = "INSERT INTO Dependente (nome,cpf,data_nascimento,parentesco,id_funcionario) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, dependente.getNome());
            stmt.setString(2, dependente.getCpf());
            stmt.setDate(3, Date.valueOf(dependente.getDataNascimento()));
            stmt.setString(4, dependente.getParentesco().toString());
            stmt.setInt(5, idFuncionario);
            stmt.execute();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Dependente: " + e.getMessage());
        }
    }
}