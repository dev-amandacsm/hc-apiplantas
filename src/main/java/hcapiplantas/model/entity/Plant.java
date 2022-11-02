package hcapiplantas.model.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_planta", schema = "db_herbcare_teste")
@NoArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_planta")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cd_categoria", nullable = false)
    private Category category;

    @Column(name = "nm_popular", nullable = false, unique = true, length = 60)
    private String nomePopular;

    @Column(name = "nm_cientifico", nullable = false, unique = true, length = 60)
    private String nomeCientifico;

    @Column(name = "ds_receita", nullable = false, length = 256)
    private String receita;

    @ManyToMany
    @JoinTable(
            name = "tb_plantasintoma",
            joinColumns = @JoinColumn(name = "cd_planta"),
            inverseJoinColumns = @JoinColumn(name = "cd_sintoma"))
    private Set<Symptom> symptoms;

    @ManyToMany
    @JoinTable(
            name = "tb_plantarestricao",
            joinColumns = @JoinColumn(name = "cd_planta"),
            inverseJoinColumns = @JoinColumn(name = "cd_restricao"))
    private Set<Symptom> restrictions;

}
