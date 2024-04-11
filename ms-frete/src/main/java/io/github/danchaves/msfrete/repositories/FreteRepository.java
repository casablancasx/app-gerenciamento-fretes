package io.github.danchaves.msfrete.repositories;

import io.github.danchaves.msfrete.models.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends JpaRepository<Long, Frete> {
}
