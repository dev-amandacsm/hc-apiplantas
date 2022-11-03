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

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

}
