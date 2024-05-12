package co.edu.unbosque.repository;

import co.edu.unbosque.entidades.Emisora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmisoraRepository extends JpaRepository<Emisora, Integer> {
}