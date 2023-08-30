package br.com.dbc.vemser.produtor.controller;

import br.com.dbc.vemser.produtor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/producer")
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping
    public ResponseEntity<?> sendMessage(String message) {
        produtorService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
