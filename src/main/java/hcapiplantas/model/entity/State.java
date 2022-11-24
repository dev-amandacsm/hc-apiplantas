package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "estado")
@Table(name = "tb_estado", schema = "db_herbcare_teste")
@NoArgsConstructor
public class State {
    @Id
    @Column(name = "sg_estado", length = 2)
    private String id;

    @Column(name = "nm_estado", length = 45, unique = true, nullable = false)
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
