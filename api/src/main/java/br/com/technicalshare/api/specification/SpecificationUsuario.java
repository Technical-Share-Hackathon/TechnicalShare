package br.com.technicalshare.api.specification;

import br.com.technicalshare.api.models.Usuario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationUsuario {

    public static Specification<Usuario> emailParecidoCom(String email){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("email"), "%"+email+"%")
        );
    }

    public static Specification<Usuario> nomeParecidoCom(String nome){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%"+nome+"%")
        );
    }

    public static Specification<Usuario> profissaoParecidaCom(String profissao){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("profissaoAtual"), "%"+profissao+"%")
        );
    }
}
