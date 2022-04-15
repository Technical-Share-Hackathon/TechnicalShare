package br.com.technicalshare.api.specification;

import br.com.technicalshare.api.models.Usuario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationHard {

    public static Specification<Usuario> primeiraHard(String primeiraHard){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("hardSkills").get("primeiraHardSkill"),
                        "%"+primeiraHard+"%")
        );
    }

    public static Specification<Usuario> segundaHard(String segundaHard){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("hardSkills").get("segundaHardSkill"),
                        "%"+segundaHard+"%")
        );
    }

    public static Specification<Usuario> terceiraHard(String terceiraHard){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("hardSkills").get("terceiraHardSkill"),
                        "%"+terceiraHard+"%")
        );
    }

    public static Specification<Usuario> quartaHard(String quartaHard){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("hardSkills").get("quartaHardSkill"),
                        "%"+quartaHard+"%")
        );
    }

    public static Specification<Usuario> quintaHard(String quintaHard){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("hardSkills").get("quintaHardSkill"),
                        "%"+quintaHard+"%")
        );
    }
}
