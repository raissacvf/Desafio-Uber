package com.castro.email_service.controllers;
import com.castro.email_service.application.EmailSenderService;
import com.castro.email_service.core.exceptions.EmailServiceException;
import com.castro.email_service.core.EmailRequest;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/email")
public class EmailSenderController {
private final EmailSenderService emailSenderService;

public EmailSenderController(EmailSenderService emailService) {
    this.emailSenderService = emailService;   
}

@PostMapping()
public ResponseEntity<String> sendEmail (@RequestBody EmailRequest request) {
   try{
    this.emailSenderService.sendEmail(request.to(), request.subject(), request.body());
     return ResponseEntity.ok("E-mail enviado com sucesso!");
}catch (EmailServiceException ex){
return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body("Falha ao enviar e-mail");
 
}   }}

   
//meu ponto de entrada para requisições relacionadas ao envio de e-mails
