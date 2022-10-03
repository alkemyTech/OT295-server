//------------------------------------------------------------------------------//
//  EmailServiceImplementation: implementation of EmailServiceInterface to create different emails according to necessity
//
//  By                          DATE                TICKET              DETAILS/CHANGES
//  Daniel-Zemanate             2022-09-17          OT295-28            Implementation for sending emails SENDGRID
//------------------------------------------------------------------------------//


package com.alkemy.ong.service.impl;

import com.alkemy.ong.service.EmailServiceInterface;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImplementation implements EmailServiceInterface {

    final static Logger LOGGER = Logger.getLogger(EmailServiceImplementation.class);
    @Autowired
    private Environment env;
    @Autowired
    private Configuration configuration;
    @Value("${alkemy.ong.email.sender}")
    private String emailSender;

    @Value("${alkemy.ong.email.enabled}")
    private Boolean emailEnabled;

//    @Value("${alkemy.ong.email.welcomeTemplate}")
//    private String welcomeTemplate;


    @Override
    public void sendEmailTo(String to, String template) {
        if (!emailEnabled) {
            LOGGER.warn("Mail service in not available. Check properties file");
            return;
        }

        try {
            Mail mail = prepareMail(to, template);
            String apiKey = env.getProperty("EMAIL_API_KEY");
            SendGrid sg = new SendGrid(apiKey);
            Request request = new Request();

            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            LOGGER.info(response.getStatusCode());
            LOGGER.info(response.getBody());
            LOGGER.info(response.getHeaders());
        } catch (IOException | TemplateException e) {
            LOGGER.error("Error trying to send the email. MESSAGE -> " + e.getMessage() + " TRACE ->" + e.getStackTrace().toString());
            throw new RuntimeException(e);
        }


    }

    private Mail prepareMail(String to, String template) throws TemplateException, IOException {

        Email fromEmail = new Email(emailSender);
        Email toEmail = new Email(to);
        String subject = "ONG";
        Content content = new Content();
        content.setType("text/html");

        if (template.equals("welcome")) {

            content.setValue(prepareWelcomeTemplate(to));
            subject = "ONG: Welcome!";
        } else if (template.equals("contact")) {

            content.setValue(prepareContactTemplate(to));
            subject = "ONG: Contact Form";
        } else {

            content.setValue(template);
        }

        return new Mail(fromEmail, subject, toEmail, content);
    }

    private String prepareWelcomeTemplate(String toEmail) throws IOException, TemplateException {
        String text = "¡Hola "+toEmail+", bienvenido a Somos Más!";

        String contactOng = "● Mail: somosfundacionmas@gmail.com " + "● Instagram: SomosMás " + "● Facebook: Somos_Más " +"● Teléfono de contacto: 1160112988";

        Map<String, Object> model = new HashMap<>();
        model.put("title", "BIENVENIDO!!");
        model.put("text", text);
        model.put("contactOng", contactOng);
        return FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate("plantilla_email.html"),model);
    }

    private String prepareContactTemplate(String toEmail) throws IOException, TemplateException {
        String text = "¡Hola "+toEmail+", hemos recibido tu contacto. Somos Más! y pronto atenderemos tu solicitud";

        String contactOng = "● Mail: somosfundacionmas@gmail.com " + "● Instagram: SomosMás " + "● Facebook: Somos_Más " +"● Teléfono de contacto: 1160112988";

        Map<String, Object> model = new HashMap<>();
        model.put("title", "MUCHAS GRACIAS! HEMOS RECIBIDO TU SOLICITUD");
        model.put("text", text);
        model.put("contactOng", contactOng);
        return FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getTemplate("plantilla_email.html"),model);
    }


}
