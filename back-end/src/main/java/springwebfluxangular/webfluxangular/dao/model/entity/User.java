package springwebfluxangular.webfluxangular.dao.model.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User extends BaseEntity{
    private String username;
    private String email;
}
