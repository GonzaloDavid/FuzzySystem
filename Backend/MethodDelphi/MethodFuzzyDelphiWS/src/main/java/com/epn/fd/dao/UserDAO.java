/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import com.epn.dtos.UserContainer;
import com.epn.entities.FilterTypes;
import com.epn.entities.SearchObject;
import com.epn.entities.User;
import com.epn.exception.AppException;
import io.jsonwebtoken.Claims;
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
import java.util.List;
import javax.crypto.Cipher;
import javax.xml.bind.DatatypeConverter;

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

    public void saveUser(User userwhithtoken, JsonObject token) {
        userwhithtoken.setToken(token.getString("JWT"));

    }

    public List<User> getuserbyemail(String email) {
        SearchObject search = new SearchObject("userPK");
        search.addParameter("userPK.email", FilterTypes.EQUAL, email);
        List<User> resultList = search(search);
        return resultList;
    }

    public UserContainer comparePassword(String email, String password) {
        List<User> userselected = getuserbyemail(email);
        if (userselected.size() > 0) {
            UserContainer usercontainer=new UserContainer();
            String passwordEncrypted = encryptAES(password, "FuzziDelphiKey");
            if (userselected.get(0).getPassword().equals(passwordEncrypted)) {
                String key = "FuzziDelphiKey";
                String subject = "FuzziDelphiSystem";
                String namejson = "email";
                //esta una semana en milisegundos la duracion del token
                long expirationTime = System.currentTimeMillis() + 604800000;
                String emailsigned = userselected.get(0).getUserPK().getEmail();
                usercontainer.setUserPK(userselected.get(0).getUserPK());
                usercontainer.setRecoveryMail(userselected.get(0).getRecoveryMail());
                usercontainer.setWorkarea(userselected.get(0).getWorkarea());
                
                JsonObject token = generateJWT(key, subject, namejson, emailsigned, expirationTime);
                String token_string = generateJWT_string(key, subject, namejson, emailsigned, expirationTime);
                saveUser(userselected.get(0), token);
                usercontainer.setJwt(token_string);
                return usercontainer;
            } else {
                throw new AppException("CONTRASEÑA ERRONEA", "CONTRASEÑAS NO COINCIDEN");
            }
        } else {
            throw new AppException("USUARIO NO EXISTE", "USUARIO NO EXISTE,CORREO NO REGISTRADO");
        }
    }
      public String generateJWT_string(String key, String subject,
            String namejson, String claim, long expirationTime) {

        long time = System.currentTimeMillis();
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setSubject(subject)
                .setIssuedAt(new Date(time))
                .setExpiration(new Date(time + expirationTime))
                .claim(namejson, claim)
                .compact();

        return jwt;
    }

    public JsonObject generateJWT(String key, String subject,
            String namejson, String claim, long expirationTime) {

        long time = System.currentTimeMillis();
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setSubject(subject)
                .setIssuedAt(new Date(time))
                .setExpiration(new Date(time + expirationTime))
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

    public String encryptAES(String strToEncrypt, String secret) {
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

    public String decryptAES(String strToDecrypt, String secret) {
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

    public String getpayloadJWT(String token) {
        String email = null;
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("FuzziDelphiKey"))
                .parseClaimsJws(token).getBody();

        if (claims.get("email") != null) {
            email = claims.get("email").toString();
        }
        return email;
    }

    public boolean validateJWT(String token) {
        boolean valid;
        String payloadEmail = getpayloadJWT(token);
        if (payloadEmail != null) {
            List<User> user = getuserbyemail(payloadEmail);
            if (user.size() > 0) {
                if (user.get(0).getToken().equals(token)) {
                    valid = true;
                } else {
                    valid = false;
                    // throw new AppException("TOKEN NO VALIDO", "Los tokens no son iguales");
                }
            } else {
                valid = false;
                //throw new AppException("TOKEN NO VALIDO", "Email no registrado");
            }
        } else {
            valid = false;
        }

        return valid;
    }

    public boolean existToken(String token) {
        boolean valid = false;
        if (token != null) {
            if (!token.equals("")) {
                if (validateJWT(token) == true) {
                    valid = true;
                } else {
                    valid = false;
                    //throw new AppException(460, 1, "Token no valido", "Usuario no logeado", "www.google.com", "PERSONUNAUTHORIZED");
                }
            } else {
                valid = false;
            }
        } else {
            valid = false;
            // throw new AppException(460, 1, "No contiene token", "Usuario no logeado", "www.google.com", "USERNOTSIGNIN");
        }
        return valid;
    }

    public void logout(String email) {
        List<User> user = getuserbyemail(email);
        if (user.size() > 0) {
            User u = new User();
            u = user.get(0);
            u.setToken(null);
            update(u);
        }
    }

    public void SignUp(User user) {
        user.setPassword(encryptAES(user.getPassword(), "FuzziDelphiKey"));
        update(user);
    }

}
