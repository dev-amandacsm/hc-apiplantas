package hcapiplantas.model.entity;

import javax.persistence.*;

@Entity(name = "cidade")
@Table(name = "tb_cidade", schema = "db_herbcare_teste")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nm_cidade", length = 75, unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "sg_estado", nullable = false)
    private State state;

    public Long getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

}
