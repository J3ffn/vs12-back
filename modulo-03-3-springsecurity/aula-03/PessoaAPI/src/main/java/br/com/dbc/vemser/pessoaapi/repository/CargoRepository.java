package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.model.entity.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<CargoEntity, Integer> {

    CargoEntity findCargoEntityByNome(String role);

}
