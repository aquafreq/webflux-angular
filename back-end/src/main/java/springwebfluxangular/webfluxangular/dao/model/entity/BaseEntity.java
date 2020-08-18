package springwebfluxangular.webfluxangular.dao.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class BaseEntity {
    @Id
    public String id;
}
