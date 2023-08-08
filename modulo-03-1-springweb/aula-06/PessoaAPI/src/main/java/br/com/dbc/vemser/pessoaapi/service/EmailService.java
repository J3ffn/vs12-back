package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    private final Configuration fmConfiguration;

    private String from = "Jefferson Izaquiel <jefferson.izaquiel@dbccompany.com.br>";

    @Value("${spring.mail.username}")
    private String emailSuporte;

    public void sendSimpleEmail(Pessoa pessoa) {
        SimpleMailMessage email = new SimpleMailMessage();

        email.setFrom(from);
        email.setTo(pessoa.getEmail());
        email.setSubject("aula vem ser");
        email.setText("Olá, " + pessoa.getNome() + "!");
        mailSender.send(email);
    }

    public void sendTemplateMailCreateAccontConfirmation(Pessoa pessoa) throws MessagingException {
        sendTemplateEmail(pessoa, "email-createAccount-template.ftl");
    }

    public void sendTemplateMailUpdateAccount(Pessoa pessoa) throws MessagingException {
        sendTemplateEmail(pessoa, "email-updateAccount-template.ftl");
    }

    public void sendTemplateMailDeleteAccount(Pessoa pessoa) throws MessagingException {
        sendTemplateEmail(pessoa, "email-deleteAccount-template.ftl");
    }

    public void sendMailWithAttachment(Pessoa pessoa) throws MessagingException {
        MimeMessage email = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(email, true);

        helper.setFrom(from);
        helper.setTo(pessoa.getEmail());
        helper.setSubject("email com anexo");
        helper.setText("enviando email com anexo\npulando linha");

        File file = new File("src/main/resources/images/image.jpg");
        FileSystemResource image = new FileSystemResource(file);

        helper.addAttachment(file.getName(), image);

        mailSender.send(email);
    }

    public void sendTemplateEmail(Pessoa pessoa, String template) throws MessagingException {
        MimeMessage emailTemplate = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(emailTemplate, true);

        try {
            helper.setFrom(from);
            helper.setTo(pessoa.getEmail());
            helper.setSubject("email a partir de template");
            helper.setText(getContentFromTemplate(pessoa, template), true);

            mailSender.send(helper.getMimeMessage());

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    public String getContentFromTemplate(Pessoa pessoa, String estruturaTemplate) throws IOException, TemplateException {
        Map<String, String> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("idade", pessoa.getIdade().toString());
        dados.put("id", pessoa.getIdPessoa().toString());
        dados.put("email", pessoa.getEmail());
        dados.put("emailSuporte", emailSuporte);
        Template template = fmConfiguration.getTemplate(estruturaTemplate);
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }
}