package com.github.naomisoubhia.ecommerce.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.retry.support.RetryTemplate;

import java.sql.SQLException;

import static org.mockito.Mockito.*;

public class DatabaseServiceTest {

    @InjectMocks
    private DatabaseService databaseService;

    @Mock
    private RetryTemplate retryTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchDataWithRetry() throws SQLException {
        // Simula a exceção SQL
        when(retryTemplate.execute(any())).thenThrow(new SQLException("Simulated database error"));

        // Executa o método para verificar o comportamento
        try {
            databaseService.fetchData();
        } catch (SQLException e) {
            // Espera que a exceção seja lançada e verifique o comportamento
        }

        // Verifica que o método foi tentado 3 vezes (máximo de tentativas definido)
        verify(retryTemplate, times(3)).execute(any());
    }

    @Test
    void testRecoverMethod() {
        SQLException sqlException = new SQLException("Simulated database failure");

        // Simula o comportamento do método recover
        databaseService.recover(sqlException);

        // Aqui você pode verificar se o comportamento esperado no método recover foi realizado
        // (Por exemplo, verificar logs, estados, etc.)
    }
}
