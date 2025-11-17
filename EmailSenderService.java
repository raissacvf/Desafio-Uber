package com.castro.email_service.application;
 
import com.castro.email_service.core.EmailSenderUseCase;
import com.castro.email_service.adapters.EmailSenderGateway;
import org.springframework.stereotype.Service;
@Service

public class EmailSenderService implements EmailSenderUseCase {
    private final EmailSenderGateway emailSenderGateway;

    //mostrar que vai ser injetado pelo spring (que é o framework que estou usando)
    public EmailSenderService(EmailSenderGateway emailGateway) {
        this.emailSenderGateway = emailGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        emailSenderGateway.sendEmail(to, subject, body);
    }
}
