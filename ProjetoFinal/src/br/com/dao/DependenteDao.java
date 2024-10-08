package br.com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import br.com.connectionDB.ConnectionFactory;
import br.com.empresa.Dependentes;

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

	public Set<String> mostrarCpfsDependentes() {
		String sql = "SELECT cpf FROM dependente";
		Set<String> cpfsDependentes = new HashSet<>();

		try (PreparedStatement stmt = conexao.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				String cpf = rs.getString("cpf");
				cpfsDependentes.add(cpf);
			}
		} catch (SQLException e) {
			System.err.println("Erro ao obter CPFs dos dependentes: " + e.getMessage());
		}
		return cpfsDependentes;
	}
}