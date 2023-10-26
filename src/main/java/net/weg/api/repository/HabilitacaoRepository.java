package net.weg.api.repository;

import net.weg.api.model.entity.Habilitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilitacaoRepository extends JpaRepository<Habilitacao, Integer> {
}
