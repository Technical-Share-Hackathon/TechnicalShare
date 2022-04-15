package br.com.technicalshare.api.specification;

import br.com.technicalshare.api.models.Usuario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationSoft {

    public static Specification<Usuario> primeiraSoft(String primeiraSoft){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("softSkills").get("primeiraSoftSkill"),
                        "%"+primeiraSoft+"%")
        );
    }

    public static Specification<Usuario> segundaSoft(String segundaSoft){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("softSkills").get("segundaSoftSkill"),
                        "%"+segundaSoft+"%")
        );
    }

    public static Specification<Usuario> terceiraSoft(String terceiraSoft){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("softSkills").get("terceiraSoftSkill"),
                        "%"+terceiraSoft+"%")
        );
    }

    public static Specification<Usuario> quartaSoft(String quartaSoft){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("softSkills").get("quartaSoftSkill"),
                        "%"+quartaSoft+"%")
        );
    }

    public static Specification<Usuario> quintaSoft(String quintaSoft){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("softSkills").get("quintaSoftSkill"),
                        "%"+quintaSoft+"%")
        );
    }
}
