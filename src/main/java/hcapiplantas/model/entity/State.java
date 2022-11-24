package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "estado")
@Table(name = "tb_estado", schema = "db_herbcare_teste")
@NoArgsConstructor
public class State {
    @Id
    @Column(name = "sg_estado", length = 2)
    private String acronym;

    @Column(name = "nm_estado", length = 60, unique = true, nullable = false)
    private String name;

    public String getAcronym() {
        return acronym;
    }

    public String getName(){
        return name;
    }

    public void setAcronym(String acronym){
        this.acronym = acronym;
    }

    public void setName(String name) {
        this.name = name;
    }
}
