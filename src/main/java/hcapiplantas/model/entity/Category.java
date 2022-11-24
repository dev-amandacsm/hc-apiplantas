package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Table(name = "tb_categoria", schema = "db_herbcare_teste")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_categoria")
    private Long id;

    @Column(name = "nm_categoria", nullable = false, unique = true, length = 60)
    private String name;

    @Column(name = "ds_categoria", nullable = false, length = 256)
    private String description;

    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @OneToMany(mappedBy = "category")
    private Set<Plant> plants;

    public Long getId() {
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

}
