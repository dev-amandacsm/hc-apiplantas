package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_sintoma", schema = "db_herbcare_teste")
@NoArgsConstructor
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_sintoma")
    private Long id;

    @Column(name = "nm_sintoma", nullable = false, unique = true, length = 60)
    private String name;

    @ManyToMany(mappedBy = "symptoms")
    private Set<Plant> plants;

}
