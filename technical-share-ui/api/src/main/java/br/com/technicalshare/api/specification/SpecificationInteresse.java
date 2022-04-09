package br.com.technicalshare.api.specification;


import br.com.technicalshare.api.models.Usuario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationInteresse {

    public static Specification<Usuario> primeiroInteresse(String primeiroInteresse){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("areaDeInteresse").get("primeiraAreaDeInteresse"),
                        "%"+primeiroInteresse+"%")
        );
    }

    public static Specification<Usuario> segundoInteresse(String segundoInteresse){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("areaDeInteresse").get("segundaAreaDeInteresse"),
                        "%"+segundoInteresse+"%")
        );
    }

    public static Specification<Usuario> terceiraInteresse(String terceiraInteresse){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("areaDeInteresse").get("terceiraAreaDeInteresse"),
                        "%"+terceiraInteresse+"%")
        );
    }

    public static Specification<Usuario> quartoInteresse(String quartoInteresse){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("areaDeInteresse").get("quartaAreaDeInteresse"),
                        "%"+quartoInteresse+"%")
        );
    }

    public static Specification<Usuario> quintoInteresse(String quintoInteresse){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("areaDeInteresse").get("quintaAreaDeInteresse"),
                        "%"+quintoInteresse+"%")
        );
    }

}
