package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "bairro")
@Table(name = "tb_bairro", schema = "db_herbcare_teste")
@NoArgsConstructor
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nm_bairro", nullable = false, length = 75, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "cd_cidade", nullable = false)
    private City city;

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public City getCity(){
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
