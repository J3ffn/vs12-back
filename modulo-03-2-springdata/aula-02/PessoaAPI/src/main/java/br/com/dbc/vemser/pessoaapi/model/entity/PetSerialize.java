package br.com.dbc.vemser.pessoaapi.model.entity;

import br.com.dbc.vemser.pessoaapi.model.dto.output.PetOutputDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PetSerialize extends JsonSerializer<Pet>{
    @Override
    public void serialize(Pet pet, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(pet.getPessoa().getIdPessoa());
    }
}
