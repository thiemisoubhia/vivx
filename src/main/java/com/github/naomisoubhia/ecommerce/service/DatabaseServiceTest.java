package com.github.naomisoubhia.ecommerce.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DatabaseServiceTest {

    @InjectMocks
    private DatabaseService databaseService; // Your service class here

    @Mock
    private SomeDependency someDependency; // A dependency your service class might have

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSomeMethod() {
        when(someDependency.someMethod()).thenReturn(someValue);

        // Your test logic here

        verify(someDependency, times(1)).someMethod();
    }
}
