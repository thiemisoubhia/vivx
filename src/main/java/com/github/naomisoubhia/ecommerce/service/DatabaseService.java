package com.github.naomisoubhia.ecommerce.service;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DatabaseService {

    @Retryable(value = { SQLException.class }, maxAttempts = 3)
    public void fetchData() throws SQLException {
        // Código para acessar o banco de dados principal
    }

    @Recover
    public void recover(SQLException e) {
        // Código para acessar o banco de dados replicado
    }
}
