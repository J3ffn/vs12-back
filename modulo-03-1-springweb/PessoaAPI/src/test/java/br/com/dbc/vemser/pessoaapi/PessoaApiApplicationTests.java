package br.com.dbc.vemser.pessoaapi;

import br.com.dbc.vemser.pessoaapi.model.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.time.LocalDate;

@SpringBootTest
//@RequiredArgsConstructor
class PessoaApiApplicationTests {

    @Autowired
    private EmailService emailService;

    @Test
    void contextLoads() throws MessagingException {
        emailService.sendTemplateEmail(new Pessoa(1, "Maicon Gerardi", LocalDate.of(1990, 10, 10), "12345678910", "jeffn.m220@gmail.com"), "email-template.ftl");
    }

}