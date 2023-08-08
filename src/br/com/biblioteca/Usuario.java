package br.com.biblioteca;

/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 */

import java.sql.*;

public class Usuario {

	public String nome, telefone, email, rua, numero, cep, complemento, bairro, cidade, estado;
	public int matricula;
	public Connection connection = null;
	/*  SOBRE Connection:
		O tipo Connection é uma interface da API JDBC (Java Database Connectivity), 
		que define métodos e comportamentos para estabelecer e gerenciar conexões com bancos de dados (tabelas, registros).
	*/
	
	public Usuario() {
		System.out.println("instancia OK");
	}

	public void conectar() {
		
		/*  SOBRE TRY:
			O bloco de código TRY é uma estrutura de controle usada para lidar com exceções (erros) 
			que podem ocorrer durante a execução de um bloco de código.
			É uma prática essencial para garantir que as aplicações Java tenham um tratamento 
			adequado de exceções, evitando falhas catastróficas e melhorando a robustez e a capacidade de recuperação do código. 
			
			Try => tenta executar o código
			catch => caso falhe, mostre erros e exceções 
			
		 */
		
		try {
			this.connection = DriverManager.getConnection("jdbc:sqlite:src/br/com/biblioteca/banco.db");
			System.out.println("Tudo certo");
		} catch (Exception e) {

		}
	}

	public void inserir() {
		this.conectar();

		// Definição da query SQL
		String sql = "INSERT INTO tb_usuario (nome, telefone, rua, numero, complemento, cep, bairro, cidade, estado) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
			/*
			 	SOBRE PreparedStatement preparedStatement:
				É uma interface fornecida pela API JDBC (Java Database Connectivity) que permite a criação de consultas 
				SQL parametrizadas, também conhecidas como consultas preparadas.
 
			*/
			
			
			// Atribuição dos valores aos parâmetros do Prepared Statement | vai substituir os valores "?"
			preparedStatement.setString(1, nome); 
			preparedStatement.setString(2, telefone);
			preparedStatement.setString(3, rua);
			preparedStatement.setString(4, numero);
			preparedStatement.setString(5, complemento);
			preparedStatement.setString(6, cep);
			preparedStatement.setString(7, bairro);
			preparedStatement.setString(8, cidade);
			preparedStatement.setString(9, estado);

			// Execução da consulta
			preparedStatement.executeUpdate();

			System.out.println("Usuario inserido com sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao inserir Usuario: " + e.getMessage());
		}
	}

	public void consultar() {
		this.conectar();

		// Definição da query SQL
		String sql = "SELECT * FROM tb_usuario";

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery()) {

			while (resultSet.next()) {
				// Imprimir os dados do Usuario na tela
				System.out.println("Código: " 		+ resultSet.getInt("matricula"));
				System.out.println("Nome: " 		+ resultSet.getString("nome"));
				System.out.println("Telefone: " 	+ resultSet.getString("telefone"));
				System.out.println("Rua: " 			+ resultSet.getString("rua"));
				System.out.println("Número: " 		+ resultSet.getString("numero"));
				System.out.println("Complemento: " 	+ resultSet.getString("complemento"));
				System.out.println("CEP: " 			+ resultSet.getString("cep"));
				System.out.println("Bairro: " 		+ resultSet.getString("bairro"));
				System.out.println("Cidade: " 		+ resultSet.getString("cidade"));
				System.out.println("Estado: " 		+ resultSet.getString("estado"));
				System.out.println();
			}
		} catch (SQLException e) {
			System.err.println("Erro ao consultar Usuario: " + e.getMessage());
		}
	}

	public void consultaSimples() {
        this.conectar();

        // Definição da query SQL
        String sql = "SELECT * FROM tb_usuario WHERE matricula = ?";

        try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
            // Atribuição do valor da matrícula ao parâmetro do Prepared Statement
           
        	preparedStatement.setInt(1, matricula);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Imprimir os dados do Usuario na tela
                    System.out.println("Matrícula: " 		+ resultSet.getInt("matricula"));
                    System.out.println("Nome: " 			+ resultSet.getString("nome"));
                    System.out.println("Telefone: " 		+ resultSet.getString("telefone"));
                    System.out.println("Rua: " 				+ resultSet.getString("rua"));
                    System.out.println("Número: " 			+ resultSet.getString("numero"));
                    System.out.println("Complemento: " 		+ resultSet.getString("complemento"));
                    System.out.println("CEP: " 				+ resultSet.getString("cep"));
                    System.out.println("Bairro: " 			+ resultSet.getString("bairro"));
                    System.out.println("Cidade: " 			+ resultSet.getString("cidade"));
                    System.out.println("Estado: " 			+ resultSet.getString("estado"));
                    System.out.println();
                }
            } catch (SQLException ex) {
                System.err.println("Erro ao acessar os dados do resultado da consulta: " + ex.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar Usuario: " + e.getMessage());
        }
    }
	
	public void alterar() {
		this.conectar();

		String sql = "UPDATE tb_usuario SET nome = ?, telefone = ?, rua = ?, numero = ?, complemento = ?, cep = ?, "
				+ "bairro = ?, cidade = ?, estado = ? WHERE matricula = ?";

		try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {

			// Atribuição dos valores aos parâmetros do Prepared Statement
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, telefone);
			preparedStatement.setString(3, rua);
			preparedStatement.setString(4, numero);
			preparedStatement.setString(5, complemento);
			preparedStatement.setString(6, cep);
			preparedStatement.setString(7, bairro);
			preparedStatement.setString(8, cidade);
			preparedStatement.setString(9, estado);
			preparedStatement.setInt(10, matricula);

			// Execução da consulta
			preparedStatement.executeUpdate();

			System.out.println("Usuario alterado com sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao alterar Usuario: " + e.getMessage());
		}

	}
	
	public void deletar() {
		this.conectar();
		
		String sql = "DELETE FROM tb_usuario WHERE matricula = ?";
		
		try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {

			preparedStatement.setInt(1, matricula);
			preparedStatement.executeUpdate();

			System.out.println("Usuario deletado com sucesso!");
		} catch (SQLException e) {
			System.err.println("Erro ao deletar Usuario: " + e.getMessage());
		}
	}

}
