package net.weg.api.repository;

import net.weg.api.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository  extends JpaRepository<Carro, Integer> {

}
