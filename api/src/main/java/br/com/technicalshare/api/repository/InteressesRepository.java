package br.com.technicalshare.api.repository;

import br.com.technicalshare.api.models.AreaDeInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InteressesRepository extends JpaRepository<AreaDeInteresse, Long>,
        JpaSpecificationExecutor<AreaDeInteresse> {

}
