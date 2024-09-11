package com.github.naomisoubhia.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

@Service
public class DatabaseService {

    @Autowired
    private DataSource primaryDataSource;

    @Autowired
    private DataSource replicaDataSource;

    @Autowired
    private Environment env;

    @Retryable(value = { SQLException.class }, maxAttempts = 3)
    public void fetchData() throws SQLException {
        // Código para acessar o banco de dados principal
        try (Connection conn = primaryDataSource.getConnection()) {
            // Realize operações com o banco de dados principal
        } catch (SQLException e) {
            // Em caso de falha, a lógica de fallback deve ser acionada
            throw e;
        }
    }

    @Recover
    public void recover(SQLException e) {
        // Código para acessar o banco de dados replicado
        try (Connection conn = replicaDataSource.getConnection()) {
            // Realize operações com o banco de dados replicado
        } catch (SQLException e2) {
            // Lógica adicional em caso de falha também na réplica
        }
    }
}
