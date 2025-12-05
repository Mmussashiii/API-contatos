package api.contatos.contatos.repository;

import api.contatos.contatos.domain.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContatoRepository extends JpaRepository<Contatos, Integer> {

    @Query("SELECT c FROM Contatos c ORDER BY c.dataNascimento DESC")
    Optional<Contatos> findByEmail(String email);
    Optional<Contatos> findById(UUID id);

    void deleteById(Integer id);

    List<Contatos> findAllByOrderByNomeAsc();

}
