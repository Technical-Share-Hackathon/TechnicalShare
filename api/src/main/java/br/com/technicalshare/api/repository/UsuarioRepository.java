package br.com.technicalshare.api.repository;

import br.com.technicalshare.api.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
