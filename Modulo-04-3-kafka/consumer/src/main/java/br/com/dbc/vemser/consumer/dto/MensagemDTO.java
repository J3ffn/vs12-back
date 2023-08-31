package br.com.dbc.vemser.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensagemDTO {
    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;

}
