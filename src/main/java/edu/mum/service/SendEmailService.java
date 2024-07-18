package edu.mum.service;

import jakarta.mail.MessagingException;

import java.io.IOException;

public interface SendEmailService {
    void sendEmail(String email,String subject,String body) throws IOException, MessagingException;
}
