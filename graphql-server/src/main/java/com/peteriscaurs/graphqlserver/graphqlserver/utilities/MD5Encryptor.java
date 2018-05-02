package com.peteriscaurs.graphqlserver.graphqlserver.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MD5Encryptor {

    private static MessageDigest messageDigest;

    public static String encrypt(String password){
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] passBytes = password.getBytes();
            messageDigest.reset();
            byte[] digested = messageDigest.digest(passBytes);
            StringBuffer stringBuffer = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                stringBuffer.append(Integer.toHexString(0xff & digested[i]));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MD5Encryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}