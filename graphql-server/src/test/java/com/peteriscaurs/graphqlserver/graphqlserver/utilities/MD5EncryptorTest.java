package com.peteriscaurs.graphqlserver.graphqlserver.utilities;

import org.junit.Test;

import javax.validation.constraints.AssertTrue;

import static org.junit.Assert.*;

public class MD5EncryptorTest {

    @Test
    public void testEncryption() {
        final String inputPassword = "password";
        String encryptedInputPassword = MD5Encryptor.encrypt(inputPassword);
        final String databasePassword = "password";
        String encryptedDatabasePassword = MD5Encryptor.encrypt(databasePassword);
        assertTrue(encryptedInputPassword.equals(encryptedDatabasePassword));
    }

}