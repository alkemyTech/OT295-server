//------------------------------------------------------------------------------//
//  EmailServiceImplementation: implementation of EmailServiceInterface to create different emails according to necessity
//
//  By                          DATE                TICKET              DETAILS/CHANGES
//  Daniel-Zemanate             2022-09-17          OT295-28            Implementation for sending emails SENDGRID
//------------------------------------------------------------------------------//


package com.alkemy.ong.service.impl;
import com.alkemy.ong.service.EmailServiceInterface;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class EmailServiceImplementation implements EmailServiceInterface {

    @Autowired
    private Environment env;

    @Value("${alkemy.ong.email.sender}")
    private String emailSender;

    @Value("${alkemy.ong.email.enabled}")
    private Boolean emailEnabled;


    @Override
    public void sendEmailTo(String to) {
        if (!emailEnabled) {
            return;
        }

        String apiKey = env.getProperty("EMAIL_API_KEY");

        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(to);

        // You have two options for the content type: text/plain or text/html. The second parameter will take the plain text or HTML content you wish to send.
        Content content = new Content(
                "text/plain",
                "Bienvenido/a a ONG"
        );
        String subject = "ONG";

        Mail mail = new Mail(fromEmail, subject, toEmail, content);
        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        }catch(IOException ex){
            System.out.println("Error trying to send the email");
        }



    }
}
