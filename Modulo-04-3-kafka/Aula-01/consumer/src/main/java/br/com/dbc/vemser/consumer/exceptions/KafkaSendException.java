package br.com.dbc.vemser.consumer.exceptions;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class KafkaSendException extends Exception{

    public KafkaSendException(String message) {
        super(message);
    }

}
