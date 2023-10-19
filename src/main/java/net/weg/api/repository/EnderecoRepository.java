package net.weg.api.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import net.weg.api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
