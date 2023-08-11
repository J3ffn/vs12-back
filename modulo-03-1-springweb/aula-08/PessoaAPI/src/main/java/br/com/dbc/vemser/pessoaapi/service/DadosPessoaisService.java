package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.model.dto.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DadosPessoaisService {

    private DadosPessoaisClient client;

    public List<DadosPessoaisDTO> listDadosPessoais() {
        return client.getAll();
    }

    public DadosPessoaisDTO create(
            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return client.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO update(@PathVariable("cpf") String cpf,
                                   @RequestBody DadosPessoaisDTO dto) throws Exception {
        return client.put(cpf, dto);
    }

    public DadosPessoaisDTO getByCpf(@PathVariable("cpf") String cpf){
        return client.get(cpf);
    }

    public void delete(@PathVariable("cpf") String cpf){
        client.delete(cpf);
    }

}
