package br.com.dbc.vemser.pessoaapi;

import br.com.dbc.vemser.pessoaapi.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
//@RequiredArgsConstructor
class PessoaApiApplicationTests {

    @Autowired
    private EmailService emailService;

    @Test
    void contextLoads() throws MessagingException {
        emailService.sendTemplateEmail();
    }

}