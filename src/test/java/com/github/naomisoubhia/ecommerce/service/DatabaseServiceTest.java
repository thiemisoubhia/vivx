package com.github.naomisoubhia.ecommerce.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.annotation.Recover;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

@SpringBootTest
public class DatabaseServiceTest {

    @Test
    void testFetchDataRetries() throws SQLException {
        // Crie um mock do DatabaseService
        DatabaseService databaseService = Mockito.spy(new DatabaseService());

        // Simule a SQLException para forçar o retry
        doThrow(new SQLException("Database error")).when(databaseService).fetchData();

        // Execute o método que deve causar retries
        try {
            databaseService.fetchData();
        } catch (SQLException e) {
            // A exceção esperada após os retries
        }

        // Verifique se o método fetchData foi chamado 3 vezes
        verify(databaseService, times(3)).fetchData();
    }


    }
}
