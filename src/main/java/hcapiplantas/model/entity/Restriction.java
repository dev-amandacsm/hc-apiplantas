package hcapiplantas.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "restricao")
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_restricao", schema = "db_herbcare_teste")
public class Restriction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_restricao")
    private Long id;

    @Column(name = "nm_grupo", nullable = false, unique = true, length = 75)
    @JsonProperty(value = "nome_grupo")
    private String groupName;

    @ManyToMany(mappedBy = "restrictions")
    private Set<Plant> plants;

    public Long getId(){
        return this.id;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
