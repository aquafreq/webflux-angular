package springwebfluxangular.webfluxangular.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> register(UserHandler handler) {
        return RouterFunctions
                .route()
                .POST("/register", accept(APPLICATION_JSON), handler::register)
                .POST("/login", accept(APPLICATION_JSON), handler::login)
                .GET("/all-users", accept(APPLICATION_JSON), handler::findAllUsers)
                .GET("/users/{id}", accept(APPLICATION_JSON), handler::findUserById)
                .build();
    }
}
