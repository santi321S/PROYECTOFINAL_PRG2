package co.edu.unbosque.repository;

import co.edu.unbosque.entidades.Pistamusical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PistamusicalRepository extends JpaRepository<Pistamusical, Integer> {
}