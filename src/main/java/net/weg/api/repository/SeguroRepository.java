package net.weg.api.repository;

import net.weg.api.model.entity.Seguro;
import net.weg.api.model.entity.SeguroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, SeguroId> {
}
