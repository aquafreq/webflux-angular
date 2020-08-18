package springwebfluxangular.webfluxangular.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import springwebfluxangular.webfluxangular.dao.model.entity.User;
import springwebfluxangular.webfluxangular.dao.model.repository.UserRepository;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserHandler {
    private final UserRepository repository;

    public Mono<ServerResponse> register(ServerRequest request) {
        Mono<User> user = request.bodyToMono(User.class);
        return created(request.uri())
                .contentType(APPLICATION_JSON)
                .body(repository.save(user.block()), User.class);
    }

    public Mono<ServerResponse> login(ServerRequest request) {
      log.info("ServerRequest request {}",request);
        return created(request.uri())
                .contentType(APPLICATION_JSON)
                .body(repository.findByUsername("req."), User.class);
    }

    public Mono<ServerResponse> findAllUsers(ServerRequest request) {
        return ok()
                .contentType(APPLICATION_JSON)
                .body(repository.findAll(), User.class);
    }

    public Mono<ServerResponse> findUserById(ServerRequest request) {
        String username = request.pathVariable("id");

        return repository.findById(username)
                .flatMap(person -> ok().contentType(APPLICATION_JSON).bodyValue(person))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
