/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.entities.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 *
 * @author david
 */
@Stateless
public class UserDAO extends GenericDAO<User> {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public UserDAO() {
        super(User.class);
    }

    public JsonObject generateJWT(String key, String sign,String subject,
            String namejson,long expirationTime,Object claim) {

        long time = System.currentTimeMillis();
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setSubject(subject)
                .setIssuedAt(new Date(time))
                .setExpiration(new Date(time+expirationTime))
                .claim(namejson, claim)
                .compact();

        JsonObject json = Json.createObjectBuilder().
                add("JWT", jwt).build();
        return json;
    }

    public static void setKey(String myKey) {
        MessageDigest sha = null;
        String testsha2 = "";
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-256");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");

            testsha2 = String.format("%064x", new BigInteger(1, sha.digest()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String encryptAES(String strToEncrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decryptAES(String strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

}
