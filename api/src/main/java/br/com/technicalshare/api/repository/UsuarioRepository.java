package br.com.technicalshare.api.repository;

import br.com.technicalshare.api.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByNomeLikeIgnoreCase(String nome);

}
