/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epn.fd.dao;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Singleton;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author david
 */
@Singleton()
public class Mail {

    private final String validate = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";//los caractees que permite un mail
    private final String from = "fuzzydelphi2019@gmail.com";//es el correo del cual encviamos
    private final String pwd = "Temporal2019.";//es la clave del correo
    private final Properties properties = new Properties();//
    private Session session;

    public boolean validarEmail(String email) {
        Pattern patron = Pattern.compile(validate);

        Matcher match = patron.matcher(email);
        return match.matches();
    }

    private void init() {
        //adicionamos la propiedades del servidor  gmail 
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");//para que ingeese con tu usuario y contarseña 

        session = Session.getDefaultInstance(properties);
        session.setDebug(true);
    }

    public void sendEmail(String destinatarioMail, String asunto, String mensaje) {
        init();
        //creando los campos del mensaje
        try {
            MimeMessage mimemessage = new MimeMessage(session);
            mimemessage.setFrom(new InternetAddress(from));
            mimemessage.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatarioMail));
            mimemessage.setSubject(asunto);
            mimemessage.setContent(mensaje, "text/html; charset=UTF-8");

            Transport t = session.getTransport();//conecta y envia el mensahje
            t.connect("smtp.gmail.com", 465, from, pwd);
            t.sendMessage(mimemessage, mimemessage.getRecipients(Message.RecipientType.TO));
            t.close();
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }

}
