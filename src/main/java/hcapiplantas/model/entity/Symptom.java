package hcapiplantas.model.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "sintoma")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_sintoma", schema = "db_herbcare_teste")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_sintoma")
    private Long id;

    @Column(name = "nm_sintoma", nullable = false, unique = true, length = 60)
    @JsonProperty(value = "nome")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "symptoms")
    private Set<Plant> plants;

}
