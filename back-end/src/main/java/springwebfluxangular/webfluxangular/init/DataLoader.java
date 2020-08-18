package springwebfluxangular.webfluxangular.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import springwebfluxangular.webfluxangular.dao.model.entity.User;
import springwebfluxangular.webfluxangular.dao.model.repository.UserRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
//        if (userRepository.count().block() == 0){

//            Flux<User> userFlux = userRepository.saveAll(Flux.just(
//                    User.builder().username("fizz").email("fizz@fizz.fizz").build(),
//                    User.builder().username("user").email("user@user.user").build(),
//                    User.builder().username("zxc").email("zxc@zxc.zxc").build()
//            ));
            
//            log.info("Initial load {}", userFlux);


            try (BufferedReader br = new BufferedReader(new FileReader("book.csv"))) {
                List<List<String>> records = new ArrayList<>();
                String line;

                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    records.add(Arrays.asList(values));
                }

            }
    }
}
