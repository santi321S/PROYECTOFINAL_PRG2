package co.edu.unbosque.repository;

import co.edu.unbosque.entidades.Parrillaprogramacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParrillaprogramacionRepository extends JpaRepository<Parrillaprogramacion, Integer> {
    @Query("SELECT e FROM Parrillaprogramacion e WHERE e.dia = :texto AND e.idEmisora.id = :idEmisora ORDER BY e.turno ASC")
    List<Parrillaprogramacion> filtrardiaYemisora(@Param("texto") String texto, @Param("idEmisora") Integer idEmisora);
}