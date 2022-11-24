package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "estado")
@Table(name = "tb_Estado", schema = "db_herbcare_teste")
@NoArgsConstructor
public class State {
    @Id
    @Column(name = "sg_Estado", length = 2)
    private String id;

    @Column(name = "nm_Estado", length = 45, unique = true, nullable = false)
    private String name;

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
