package com.castro.email_service.infra.ses;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSesConfig {

    @Bean // Indica que esse método cria um bean gerenciado pelo Spring
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(
                "coloque aqui sua credencial de acesso",
                "coloque aqui sua senha de acesso"
        );

        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion("us-east-1") // Região do SES, personalize com a sua
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
    }
}
