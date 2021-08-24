package zara.model.cadena;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name="cadena")
public class Cadena {
    @Id
    private Integer id;
    private String name;
    private String description;
}
