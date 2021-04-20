package com.vffs.persistencia;

import com.vffs.model.Professor;
import exception.SqlException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author valeria
 */
public class ProfessorDao implements Dao<Professor> {

    private final Connection conexao;

    public ProfessorDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void createTable() {

        try {
            Statement statement = this.conexao.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS professor(id BIGSERIAL, nome VARCHAR(255), idade INTEGER, PRIMARY KEY (id));");
        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            throw new SqlException(ex);

        }

    }

    @Override
    public void insert(Professor t) {

        try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("INSERT INTO professor(nome, idade) VALUES(?, ?)");
            preparedStatement.setString(1, t.getNome());
            preparedStatement.setInt(2, t.getIdade());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            throw new SqlException(ex);
        }

    }

    @Override
    public Professor findById(Long id) {
        Professor professor = null;

        try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("SELECT * FROM professor WHERE id = ?;");
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");

                professor = new Professor(id, nome, idade);
            }
        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            throw new SqlException(ex);
        }

        return professor;
    }

    @Override
    public List<Professor> findAll() {
        List<Professor> professores = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("SELECT * FROM professor;");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");

                professores.add(new Professor(id, nome, idade));
            }

        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            throw new SqlException(ex);
        }

        return professores;
    }

    @Override
    public void update(Long id, Professor t) {
        try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("UPDATE professor SET nome = ?, idade = ? WHERE id = ?");
            preparedStatement.setString(1, t.getNome());
            preparedStatement.setInt(2, t.getIdade());
            preparedStatement.setLong(3, id);
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            throw new SqlException(ex);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement preparedStatement = this.conexao.prepareStatement("DELETE FROM professor where id = ?;");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println("Código erro" + ex.getErrorCode());
            System.out.println(ex.getMessage());
            throw new SqlException(ex);
        }
    }

}
