package br.org.testes.exnitrite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@Order(2)
public class DocConfig {
 @Bean
 public OpenAPI customOpenAPI() {
  return new OpenAPI()
    .info(new Info()
      .title("Servidor NoSQL Nitrite")
      .version("1.0.0")
      .contact(new Contact().email("rfdouro@gmail.com").name("Rômulo F. Douro"))
      .description("<h1>Exemplo de API REST</h1><p>Código disponível no "
        + "<a href='https://github.com/rfdouro/nosqlspringboot/tree/master/exnitrite' target='_blank'>Github</a></p>"
        ));
 }

 /*
  * Filtro para liberação das rotas - trata CROSSORIGIN
  */
 /*@Bean
 public FilterRegistrationBean corsFilter() {
  UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
  CorsConfiguration config = new CorsConfiguration();
  // não exige credenciais
  config.setAllowCredentials(false);
  // permite acesso de qualquer origem
  config.addAllowedOrigin("*");
  // permite acesso com qualquer header http
  config.addAllowedHeader("*");
  // essas configurações são para permitir métodos específicos
  config.addAllowedMethod("GET");
  config.addAllowedMethod("POST");
  config.addAllowedMethod("PUT");
  config.addAllowedMethod("DELETE");
  config.addAllowedMethod("PATCH");
  config.addAllowedMethod("OPTIONS");
  config.addAllowedMethod("HEAD");
  // aplica esse filtro em todos os endpoints da API
  source.registerCorsConfiguration("/**", config);
  // registra o filtro na aplicação
  FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
  // indica ordem de execução desse filtro (no caso será o primeiro a ser
  // executado sempre em todas as requisições)
  bean.setOrder(0);
  return bean;
 }*/
}
