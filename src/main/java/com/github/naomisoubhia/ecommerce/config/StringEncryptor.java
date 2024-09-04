package com.github.naomisoubhia.ecommerce.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {

    @Bean(name = "jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("SimplePassword"); // Senha para descriptografar propriedades
        encryptor.setAlgorithm("PBEWithMD5AndDES"); // Algoritmo de criptografia
        return encryptor;
    }
}
