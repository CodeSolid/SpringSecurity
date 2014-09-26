package com.codesolid.securecassandra.mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service(value="signOnEmailVerification")
public class SignOnEmailVerification {

    private String applicationName;
    private String emailFrom;

    private MailSender mailSender;


    @Autowired
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Value("${application.name}")
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @Value("${email.from}")
    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }


    /*public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }
    */

    public void sendEmail(String email, String verificationLink) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setFrom(emailFrom);
        msg.setSubject("Email verification request from " + applicationName);
        msg.setText("Welcome to " + applicationName + ".  To complete you registration and gain full "
                + "access to all the site's free features, please click the following link to verify your email address: "
                + verificationLink + " .");
        try{
            this.mailSender.send(msg);
        }
        catch(MailException ex) {
            // TODO improve error handling.
            System.err.println("Error sending email:  " + ex.getMessage());
        }




    }


}
