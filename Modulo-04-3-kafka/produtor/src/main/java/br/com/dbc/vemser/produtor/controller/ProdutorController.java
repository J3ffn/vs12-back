package br.com.dbc.vemser.produtor.controller;

import br.com.dbc.vemser.produtor.model.dto.MensagemDTO;
import br.com.dbc.vemser.produtor.model.enumerate.EnvioEnum;
import br.com.dbc.vemser.produtor.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/producer")
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar-mensagem")
    private void sendMessageToUser(String msg, @RequestParam("envios") List<EnvioEnum> envios) throws JsonProcessingException {
        for (EnvioEnum envioEnum : envios){
            MensagemDTO mensagemDTO = new MensagemDTO(EnvioEnum.JEFFERSON.name(), msg, LocalDateTime.now());
            produtorService.sendMessageDTO(mensagemDTO, String.valueOf(envioEnum.ordinal()));
        }
    }

}
