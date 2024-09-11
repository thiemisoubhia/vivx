package com.github.naomisoubhia.ecommerce.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

@SpringJUnitConfig
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

    @Test
    void testFetchDataRecovery() throws SQLException {
        // Crie um mock do DatabaseService
        DatabaseService databaseService = Mockito.mock(DatabaseService.class);

        // Simule a SQLException para forçar o retry e depois a chamada ao recover
        doThrow(new SQLException("Database error")).when(databaseService).fetchData();

        // Crie uma instância do DatabaseService real para testar o comportamento
        DatabaseService realDatabaseService = new DatabaseService();

        // Simule a recuperação
        Mockito.doNothing().when(databaseService).recover(any(SQLException.class));

        // Chame o método fetchData
        try {
            realDatabaseService.fetchData();
        } catch (SQLException e) {
            // A exceção esperada após os retries
        }
    }
}
