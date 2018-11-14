package com.vilma.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    public static String generateHash(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");	        
        //Applies sha256 to our input, 
        byte[] hash = digest.digest(data.getBytes("UTF-8"));	
        return String.format("%064x", new BigInteger(1, hash));
        // reference  - https://stackoverflow.com/questions/3103652/hash-string-via-sha-256-in-java
    }
}