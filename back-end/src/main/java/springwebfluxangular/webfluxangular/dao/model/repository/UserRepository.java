package springwebfluxangular.webfluxangular.dao.model.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import springwebfluxangular.webfluxangular.dao.model.entity.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {
    Mono<User> findByUsername(String username);
}
