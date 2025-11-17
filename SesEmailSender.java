package com.castro.email_service.infra.ses;

import com.castro.email_service.adapters.EmailSenderGateway;
import com.castro.email_service.core.exceptions.EmailServiceException;
import org.springframework.stereotype.Service;  
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest; 
@Service
public class SesEmailSender implements EmailSenderGateway {
    private final AmazonSimpleEmailService amazonSimpleEmailService;

    //mostrar que vai ser injetado pelo spring (que é o framework)
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
public void sendEmail(String to, String subject, String body) {
    try {
        SendEmailRequest request = new SendEmailRequest()
            .withSource("coloque aqui seu remetente verificado") // remetente verificado na AWS SES
            .withDestination(new Destination().withToAddresses(to))
            .withMessage(new Message()
                .withSubject(new Content(subject))
                .withBody(new Body().withText(new Content(body))));

        amazonSimpleEmailService.sendEmail(request);
    } catch (Exception e) {
        e.printStackTrace();
        throw new EmailServiceException("Erro ao enviar e-mail", e);
    }
}

    }   


