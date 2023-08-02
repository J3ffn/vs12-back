package br.com.dbc.vemser.pessoaapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectionController {

    @GetMapping("/pessoa/{idPessoa}/contatos")
    public RedirectView getContatosByIdUsuario(@PathVariable Integer idPessoa) {
        return new RedirectView("/contato/" + idPessoa + "/all");
    }

}
