package br.com.technicalshare.api.configuration.swagger;

import br.com.technicalshare.api.models.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.technicalshare.api"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiInfo())
                .ignoredParameterTypes(Usuario.class);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("API Technical Share Hackaton")
                .description("uma plataforma para busca de mentoria e ajuda de profissionais")
                .version("1.0")
                .contact(contact())
                .build();
    }

    private Contact contact(){
        return new Contact("Lucas Trevizan", "https://github.com/LucasTrevizanbr",
                "lucasevizan@hotmail.com");
    }
}
